package artembaranov.guardian.db.mappers

/**
 * Created by Artem Baranov on 21.04.2023.
 */


import artembaranov.guardian.entities.Threat
import artembaranov.guardian.db.entities.Threat as dbThreat
import java.time.ZoneId
import java.time.ZonedDateTime

object TransactionMapper {
    fun map(dbThreat: dbThreat): Threat {

        return Threat(
            id = dbThreat.id,
            name = dbThreat.name,

            createdAt = ZonedDateTime.ofInstant(dbTransaction.createdAt, ZoneId.systemDefault()),
        )
    }

    fun map(transaction: Transaction): dbTransaction {
        return if (transaction.isPersistent) {
            dbTransaction(
                amount = transaction.amount,
                comment = transaction.comment,
                createdAt = transaction.createdAt.toInstant(),
                categoryId = transaction.category?.id,
                id = transaction.id
            )
        } else {
            dbTransaction(
                amount = transaction.amount,
                comment = transaction.comment,
                createdAt = transaction.createdAt.toInstant(),
                categoryId = transaction.category?.id,
            )
        }
    }
}
