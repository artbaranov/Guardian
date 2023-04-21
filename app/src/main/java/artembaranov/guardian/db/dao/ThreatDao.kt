package artembaranov.guardian.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import artembaranov.guardian.entities.Threat

/**
 * Created by Artem Baranov on 21.04.2023.
 */

@Dao
interface ThreatDao {

    @Query("SELECT * FROM threat")
    fun getAll(): List<Threat>

    @Insert
    fun insert(threat: Threat): Long

    @Delete
    fun delete(threat: Threat)

    @Update
    fun update(threat: Threat)
}