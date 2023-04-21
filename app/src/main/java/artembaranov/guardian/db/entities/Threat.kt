package artembaranov.guardian.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import artembaranov.guardian.entities.ObjectOfInfluence
import artembaranov.guardian.entities.ThreatConsequence
import artembaranov.guardian.entities.ThreatSource
import java.time.Instant

@Entity(tableName = "threat")
data class Threat(
    @PrimaryKey val id: Long,
    val name: String,
    val date: Instant,
    val shortDescription: String,
    val fullDescription: String,
    val threatSources: List<ThreatSource>,
    val objectsOfInfluence: List<ObjectOfInfluence>,
    val threatConsequences: List<ThreatConsequence>,
)
