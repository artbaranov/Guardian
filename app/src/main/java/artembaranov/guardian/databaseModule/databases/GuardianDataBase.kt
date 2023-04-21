package artembaranov.guardian.databaseModule.databases

import androidx.room.Database
import androidx.room.RoomDatabase
import artembaranov.guardian.databaseModule.entities.Threat

/**
 * Created by Artem Baranov on 21.04.2023.
 */

@Database(entities = [Threat::class], version = 1)
abstract class GuardianDataBase : RoomDatabase() {
    abstract fun threatDao()
}