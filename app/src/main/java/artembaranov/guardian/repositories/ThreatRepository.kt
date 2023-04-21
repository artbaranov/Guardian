package artembaranov.guardian.repositories

import artembaranov.guardian.db.dao.ThreatDao
import artembaranov.guardian.entities.Threat
import javax.inject.Inject

/**
 * Created by Artem Baranov on 21.04.2023.
 */

interface ThreatRepository {
    fun loadAll(): List<Threat>
    fun insert(threat: Threat): Long
    fun update(threat: Threat)
    fun delete(threat: Threat)
}

class ThreatRepositoryImpl @Inject constructor(
    private val threatDao: ThreatDao
) : ThreatRepository {

    override fun loadAll(): List<Threat> {
        return threatDao.getAll()
    }

    override fun insert(threat: Threat): Long {
        return threatDao.insert(threat)
    }

    override fun update(threat: Threat) {
        threatDao.update(threat)
    }

    override fun delete(threat: Threat) {
        threatDao.delete(threat)
    }
}