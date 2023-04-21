package artembaranov.guardian.di

import android.content.Context
import androidx.room.Room
import artembaranov.guardian.db.dao.ThreatDao
import artembaranov.guardian.db.databases.GuardianDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Artem Baranov on 21.04.2023.
 */

@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): GuardianDataBase {
        return Room.databaseBuilder(
            appContext,
            GuardianDataBase::class.java,
            "guardian"
        )
            .build()
    }

    @Provides
    fun provideCategoriesDao(database: GuardianDataBase): ThreatDao {
        return database.threatDao()
    }
}