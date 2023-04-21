package artembaranov.guardian.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import artembaranov.guardian.db.entities.Threat

/**
 * Created by Artem Baranov on 21.04.2023.
 */

@Dao
interface ThreatDao {
    @Query("SELECT * FROM threat")
    suspend fun getAll(): List<Threat>

    @Insert
    suspend fun insert(threat: Threat)

    @Delete
    suspend fun delete(threat: Threat)

    @Update
    suspend fun update(threat: Threat)
}