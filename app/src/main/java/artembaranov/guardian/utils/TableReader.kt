package artembaranov.guardian.utils

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

    override suspend fun read(fileName: String): List<Threat> {

        val workbook = WorkbookFactory.create(context.assets.open(fileName))
        val sheet = workbook.getSheetAt(0)
        val threats = mutableListOf<Threat>()

        for (row in sheet) {
            val id = row.getCell(0)
            val shortDescription = row.getCell(1)
            val fullDescription = row.getCell(2)

            val threatSources = row.getCell(3)
            val objectsOfInfluence = row.getCell(4)
            val privacyViolation = row.getCell(5)
            val accessibilityViolation = row.getCell(6)
            val integrityViolation = row.getCell(7)

            val date = row.getCell(8)

            if (cellsInitialized(id, shortDescription, fullDescription)) {

                val id = id.numericCellValue.toLong()
                val name = "УБИ.${id}"
                val shortDescription = shortDescription.stringCellValue
                val fullDescription = fullDescription.stringCellValue

                val privacyViolation = privacyViolation.numericCellValue
                val accessibilityViolation = accessibilityViolation.numericCellValue
                val integrityViolation = integrityViolation.numericCellValue

                // from(date.dateCellValue.toInstant())
                val date = ZonedDateTime.now()

                val threatConsequences = createConsequences(privacyViolation, accessibilityViolation, integrityViolation)
                val threatSources = createThreatSources(threatSources.stringCellValue)
                val objectsOfInfluence = createObjectsOfInfluence(objectsOfInfluence.stringCellValue)

                threats.add(Threat(id, name, date, shortDescription, fullDescription, threatSources, objectsOfInfluence, threatConsequences))
            }
        }

        workbook.close()

        return threats
    }

    private fun cellsInitialized(id: Cell?, name: Cell?, description: Cell?): Boolean {
        return id != null && name != null && description != null
    }

    private fun createThreatSources(stringCellValue: String?): List<ThreatSource> {
        return emptyList()
    }


    private fun createObjectsOfInfluence(stringCellValue: String?): List<ObjectOfInfluence> {
        return emptyList()
    }

    private fun createConsequences(
        privacyViolation: Double,
        accessibilityViolation: Double,
        integrityViolation: Double
    ): List<ThreatConsequence> {
        return emptyList()
    }
}
