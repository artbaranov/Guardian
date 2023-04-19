package artembaranov.guardian.databases.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import artembaranov.guardian.entities.ThreatSource
import java.time.Instant

@Entity
data class Threat(
    @PrimaryKey val uid: Long,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "data") val date: Instant,
    @ColumnInfo(name = "shortDescription") val shortDescription: String,
    @ColumnInfo(name = "fullDescription") val fullDescription: String,
    @ColumnInfo(name = "threatSources") val threatSources: ThreatSource
)
