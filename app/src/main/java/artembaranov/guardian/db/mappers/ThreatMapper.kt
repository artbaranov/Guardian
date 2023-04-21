package artembaranov.guardian.db.mappers

/**
 * Created by Artem Baranov on 21.04.2023.
 */


import artembaranov.guardian.entities.Threat
import artembaranov.guardian.db.entities.Threat as dbThreat
import java.time.ZoneId
import java.time.ZonedDateTime

object ThreatMapper {
    fun map(dbThreat: dbThreat): Threat {

        return Threat(
            id = dbThreat.id,
            name = dbThreat.name,
            date = ZonedDateTime.ofInstant(dbThreat.date, ZoneId.systemDefault()),
            shortDescription = dbThreat.shortDescription,
            fullDescription = dbThreat.fullDescription,
            threatSources = dbThreat.threatSources,
            objectsOfInfluence = dbThreat.objectsOfInfluence,
            threatConsequences = dbThreat.threatConsequences,
        )
    }

    fun map(threat: Threat): dbThreat {
        return dbThreat(
            id = threat.id,
            name = threat.name,
            date = threat.date.toInstant(),
            shortDescription = threat.shortDescription,
            fullDescription = threat.fullDescription,
            threatSources = threat.threatSources,
            objectsOfInfluence = threat.objectsOfInfluence,
            threatConsequences = threat.threatConsequences,
        )
    }
}
