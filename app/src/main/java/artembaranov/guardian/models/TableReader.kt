package artembaranov.guardian.models

import android.content.Context
import artembaranov.guardian.entities.ObjectOfInfluence
import artembaranov.guardian.entities.Threat
import artembaranov.guardian.entities.ThreatConsequence
import artembaranov.guardian.entities.ThreatSource
import dagger.hilt.android.qualifiers.ApplicationContext
import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.ss.usermodel.WorkbookFactory
import java.time.ZonedDateTime
import javax.inject.Inject


/**
 * Created by Artem Baranov on 27.04.2023.
 */

interface TableReader {
    suspend fun read(fileName: String): List<Threat>
}

class ExcelReader @Inject constructor(
    @ApplicationContext private val context: Context
) : TableReader {

    // TODO: Refactor this method
    override suspend fun read(fileName: String): List<Threat> {

        val workbook = WorkbookFactory.create(context.assets.open(fileName))
        val sheet = workbook.getSheetAt(0)
        val threats = mutableListOf<Threat>()

        for (row in sheet) {
            val cellId = row.getCell(0)
            val cellShortDescription = row.getCell(1)
            val cellFullDescription = row.getCell(2)

            val cellThreatSources = row.getCell(3)
            val cellObjectsOfInfluence = row.getCell(4)
            val cellPrivacyViolation = row.getCell(5)
            val cellAccessibilityViolation = row.getCell(6)
            val cellIntegrityViolation = row.getCell(7)

            val cellDate = row.getCell(8)

            if (cellsInitialized(cellId, cellShortDescription, cellFullDescription)) {

                val id = cellId.numericCellValue.toLong()
                val name = "УБИ.${id}"
                val shortDescription = cellShortDescription.stringCellValue
                val fullDescription = cellFullDescription.stringCellValue

                val privacyViolation = cellPrivacyViolation.numericCellValue.toInt()
                val accessibilityViolation = cellAccessibilityViolation.numericCellValue.toInt()
                val integrityViolation = cellIntegrityViolation.numericCellValue.toInt()

                // from(date.dateCellValue.toInstant())
                val date = ZonedDateTime.now()

                val threatConsequences =
                    createConsequences(privacyViolation, accessibilityViolation, integrityViolation)
                val threatSources = createThreatSources(cellThreatSources.stringCellValue)
                val objectsOfInfluence = createObjectsOfInfluence(cellObjectsOfInfluence.stringCellValue)

                threats.add(
                    Threat(
                        id,
                        name,
                        date,
                        shortDescription,
                        fullDescription,
                        threatSources,
                        objectsOfInfluence,
                        threatConsequences
                    )
                )
            }
        }

        workbook.close()

        return threats
    }

    private fun cellsInitialized(id: Cell?, name: Cell?, description: Cell?): Boolean {
        return id != null && name != null && description != null
    }

    private fun createThreatSources(stringCellValue: String?): List<ThreatSource> {
        if (stringCellValue == null) return emptyList()

        val threatSources = mutableListOf<ThreatSource>()

        val sources = stringCellValue.split(";")

        sources.forEach {
            threatSources.add(ThreatSource(it))
        }

        return threatSources
    }


    private fun createObjectsOfInfluence(stringCellValue: String?): List<ObjectOfInfluence> {
        if (stringCellValue == null) return emptyList()

        val objectsOfInfluence = mutableListOf<ObjectOfInfluence>()

        val sources = stringCellValue.split(";")

        sources.forEach {
            objectsOfInfluence.add(ObjectOfInfluence(it))
        }

        return objectsOfInfluence
    }

    private fun createConsequences(
        privacyViolation: Int,
        accessibilityViolation: Int,
        integrityViolation: Int
    ): List<ThreatConsequence> {
        val consequences = mutableListOf<ThreatConsequence>()

        if (privacyViolation == 1) {
            consequences.add(ThreatConsequence("Нарушение конфиденциальности"))
        }
        if (accessibilityViolation == 1) {
            consequences.add(ThreatConsequence("Нарушение доступности"))
        }
        if (integrityViolation == 1) {
            consequences.add(ThreatConsequence("Нарушение целостности"))
        }

        return consequences
    }
}
