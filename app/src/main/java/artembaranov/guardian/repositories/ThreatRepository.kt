package artembaranov.guardian.repositories

import artembaranov.guardian.db.dao.ThreatDao
import artembaranov.guardian.db.mappers.ThreatMapper
import artembaranov.guardian.entities.Threat
import javax.inject.Inject

/**
 * Created by Artem Baranov on 21.04.2023.
 */

interface ThreatRepository {
    suspend fun loadAll(): List<Threat>
    suspend fun insert(threat: Threat)
    suspend fun update(threat: Threat)
    suspend fun delete(threat: Threat)
    suspend fun loadById(id: Long): Threat
}

class ThreatRepositoryImpl @Inject constructor(
    private val threatDao: ThreatDao
) : ThreatRepository {

    override suspend fun loadAll(): List<Threat> {
        val threats = threatDao.getAll()

        return threats.map {
            ThreatMapper.map(it)
        }
    }

    override suspend fun insert(threat: Threat) {
        val dbThreat = ThreatMapper.map(threat)

        threatDao.insert(dbThreat)
    }

    override suspend fun update(threat: Threat) {
        val dpThreat = ThreatMapper.map(threat)

        threatDao.update(dpThreat)
    }

    override suspend fun delete(threat: Threat) {
        val dpThreat = ThreatMapper.map(threat)

        threatDao.delete(dpThreat)
    }

    override suspend fun loadById(id: Long): Threat {
        val threat = ThreatMapper.map(threatDao.loadById(id))

        return threat
    }
}