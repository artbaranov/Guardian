package artembaranov.guardian.di

import artembaranov.guardian.utils.ExcelReader
import artembaranov.guardian.utils.TableReader
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Created by Artem Baranov on 27.04.2023.
 */

@Module
@InstallIn(SingletonComponent::class)
abstract class TableReaderModule {

    @Binds
    abstract fun bindTableReader(tableReader: ExcelReader): TableReader
}