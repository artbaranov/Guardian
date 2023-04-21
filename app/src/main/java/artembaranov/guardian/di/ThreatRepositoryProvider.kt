package artembaranov.guardian.di

import artembaranov.guardian.repositories.ThreatRepository
import artembaranov.guardian.repositories.ThreatRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Created by Artem Baranov on 21.04.2023.
 */

@Module
@InstallIn(SingletonComponent::class)
abstract class ThreatRepositoryProvider {

    @Binds
    abstract fun bindThreatRepository(threatRepositoryImpl: ThreatRepositoryImpl): ThreatRepository
}