package artembaranov.guardian.databaseModule.dao

import androidx.room.Dao
import androidx.room.Query
import artembaranov.guardian.databaseModule.entities.Threat

/**
 * Created by Artem Baranov on 21.04.2023.
 */

@Dao
interface ThreatDao {
    
    @Query("SELECT * FROM threat")
    fun getAll(): List<Threat>
}