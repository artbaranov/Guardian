package artembaranov.guardian.ui.previewValues

import artembaranov.guardian.entities.Threat
import artembaranov.guardian.entities.ThreatConsequence
import artembaranov.guardian.entities.ThreatSource
import java.time.ZonedDateTime

val previewThreat = Threat(
    id = 1,
    name = "УБИ.001",
    date = ZonedDateTime.parse("2020-03-19T10:24:00.000+03:00[Europe/Moscow]"),
    shortDescription = "Угроза автоматического распространения вредоносного кода в грид-системе",
    fullDescription = "Угроза заключается в возможности внедрения и запуска вредоносного кода от имени доверенного процесса на любом из ресурсных центров грид-системы и его автоматического распространения на все узлы грид-системы.\n" +
            "Данная угроза обусловлена слабостями технологии грид-вычислений – высоким уровнем автоматизации при малой администрируемости грид-системы.\n" +
            "Реализация данной угрозы возможна при условии наличия у нарушителя привилегий легального пользователя грид-системы",
    threatSources = listOf(
        ThreatSource("Внешний нарушитель со средним потенциалом"),
        ThreatSource("Внутренний нарушитель со средним потенциалом")
    ), threatConsequences = listOf(
        ThreatConsequence("Нарушение конфиденциальности"),
        ThreatConsequence("Нарушение целостности"),
        ThreatConsequence("Нарушение доступности"),
    )
)
