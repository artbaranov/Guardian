package artembaranov.guardian.db.databases

import androidx.room.Database
import androidx.room.RoomDatabase
import artembaranov.guardian.db.dao.ThreatDao
import artembaranov.guardian.db.entities.Threat

/**
 * Created by Artem Baranov on 21.04.2023.
 */

@Database(entities = [Threat::class], version = 1)
abstract class GuardianDataBase : RoomDatabase() {
    abstract fun threatDao(): ThreatDao
}