package artembaranov.guardian.ui.screens.home

import androidx.lifecycle.ViewModel
import artembaranov.guardian.entities.ObjectOfInfluence
import artembaranov.guardian.entities.Threat
import artembaranov.guardian.entities.ThreatConsequence
import artembaranov.guardian.entities.ThreatSource
import artembaranov.guardian.repositories.ThreatRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import java.time.ZonedDateTime
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    threatRepository: ThreatRepository,
) : ViewModel() {
    data class UiState(val threats: List<Threat> = emptyList())

    var uiState = UiState()
        private set

    init {
        threatRepository.insert(
            Threat(
                id = 1,
                name = "УБИ.001",
                date = ZonedDateTime.parse("2020-03-19T10:24:00.000+03:00[Europe/Moscow]"),
                shortDescription = "Угроза автоматического распространения вредоносного кода в грид-системе",
                fullDescription = "Угроза заключается в возможности внедрения и запуска вредоносного кода от имени доверенного процесса на любом из ресурсных центров грид-системы и его автоматического распространения на все узлы грид-системы.\n" +
                        "Данная угроза обусловлена слабостями технологии грид-вычислений – высоким уровнем автоматизации при малой администрируемости грид-системы.\n" +
                        "Реализация данной угрозы возможна при условии наличия у нарушителя привилегий легального пользователя грид-системы",
                threatSources = listOf(
                    ThreatSource("Внешний нарушитель со средним потенциалом"),
                    ThreatSource("Внутренний нарушитель со средним потенциалом"),
                ),
                objectsOfInfluence = listOf(
                    ObjectOfInfluence("Ресурсные центры грид-системы")
                ),
                threatConsequences = listOf(
                    ThreatConsequence("Нарушение конфиденциальности"),
                    ThreatConsequence("Нарушение целостности"),
                    ThreatConsequence("Нарушение доступности"),
                )
            )
        )
        uiState = uiState.copy(threats = loadThreats())
    }

    private fun loadThreats(): List<Threat> {

        return listOf(
            Threat(
                id = 1,
                name = "УБИ.001",
                date = ZonedDateTime.parse("2020-03-19T10:24:00.000+03:00[Europe/Moscow]"),
                shortDescription = "Угроза автоматического распространения вредоносного кода в грид-системе",
                fullDescription = "Угроза заключается в возможности внедрения и запуска вредоносного кода от имени доверенного процесса на любом из ресурсных центров грид-системы и его автоматического распространения на все узлы грид-системы.\n" +
                        "Данная угроза обусловлена слабостями технологии грид-вычислений – высоким уровнем автоматизации при малой администрируемости грид-системы.\n" +
                        "Реализация данной угрозы возможна при условии наличия у нарушителя привилегий легального пользователя грид-системы",
                threatSources = listOf(
                    ThreatSource("Внешний нарушитель со средним потенциалом"),
                    ThreatSource("Внутренний нарушитель со средним потенциалом"),
                ),
                objectsOfInfluence = listOf(
                    ObjectOfInfluence("Ресурсные центры грид-системы")
                ),
                threatConsequences = listOf(
                    ThreatConsequence("Нарушение конфиденциальности"),
                    ThreatConsequence("Нарушение целостности"),
                    ThreatConsequence("Нарушение доступности"),
                )
            ),
            Threat(
                id = 2,
                name = "УБИ.002",
                date = ZonedDateTime.parse("2020-03-19T10:24:00.000+03:00[Europe/Moscow]"),
                shortDescription = "Угроза агрегирования данных, передаваемых в грид-системе",
                fullDescription = "Угроза заключается в возможности раскрытия нарушителем защищаемой информации путём выявления задействованных в её обработке узлов, сбора, анализа и обобщения данных, перехватываемых в сети передачи данных грид-системы.\n" +
                        "Данная угроза обусловлена слабостью технологии грид-вычислений – использованием незащищённых каналов сети Интернет как транспортной сети грид-системы.\n" +
                        "Реализация данной угрозы возможна при условии наличия у нарушителя:\n" +
                        "сил и средств, достаточных для компенсации чрезвычайной распределённости грид-заданий между узлами грид-системы;\n" +
                        "привилегий, достаточных для перехвата трафика сети передачи данных между элементами (узлами) грид-системы",
                threatSources = listOf(
                    ThreatSource("Внешний нарушитель со средним потенциалом"),
                ),
                objectsOfInfluence = listOf(
                    ObjectOfInfluence("Сетевой трафик")
                ),
                threatConsequences = listOf(
                    ThreatConsequence("Нарушение конфиденциальности"),
                )
            )
        )
    }
}
