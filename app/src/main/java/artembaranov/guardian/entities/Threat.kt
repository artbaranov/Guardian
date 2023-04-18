package artembaranov.guardian.entities

import java.time.ZonedDateTime

data class Threat(
    val id: Long,
    val name: String,
    val date: ZonedDateTime,
    val description: String,
    val threatSources: ThreatSource,
    val threatConsequences: ThreatConsequence
)
