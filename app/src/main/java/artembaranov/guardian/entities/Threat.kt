package artembaranov.guardian.entities

import java.time.ZonedDateTime

data class Threat(
//    val id: Long,
//    val name: String,
//    val date: ZonedDateTime,
//    val shortDescription: String,
//    val fullDescription: String,
    val threatSources: List<ThreatSource>,
    val objectsOfInfluence: List<ObjectOfInfluence>,
    val threatConsequences: List<ThreatConsequence>,
)
