package artembaranov.guardian.ui.screens.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import artembaranov.guardian.di.IODispatcher
import artembaranov.guardian.di.MainDispatcher
import artembaranov.guardian.entities.Threat
import artembaranov.guardian.repositories.ThreatRepository
import artembaranov.guardian.utils.TableReader
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val threatRepository: ThreatRepository,
    private val tableReader: TableReader,
    @MainDispatcher private val uiDispatcher: CoroutineDispatcher,
    @IODispatcher private val ioDispatcher: CoroutineDispatcher,
) : ViewModel() {
    data class UiState(
        val threats: List<Threat> = emptyList(),
        val foundThreats: List<Threat> = emptyList(),
        val searchQuery: String = "",
        val filters: List<Filter> = listOf(
            Filter(1, "Внутренний нарушитель с низким потенциалом", false),
            Filter(2, "Внутренний нарушитель со средним потенциалом", false),
            Filter(3, "Внутренний нарушитель с высоким потенциалом", false),
            Filter(4, "Внешний нарушитель с низким потенциалом", false),
            Filter(5, "Внешний нарушитель с средним потенциалом", false),
            Filter(6, "Внешний нарушитель с высоким потенциалом", false),
            Filter(7, "Нарушение конфиденциальности", false),
            Filter(8, "Нарушение целостности", false),
            Filter(9, "Нарушение доступности", false),
        )
    )

    var uiState by mutableStateOf(UiState())
        private set

    init {
        viewModelScope.launch(ioDispatcher) {
            updateRepository()

            loadThreats()
        }
    }

    fun applyFilters(filter: Filter) {

        val filters = uiState.filters.toMutableList()
        val filterBeingSelected = filters.find { it == filter }
        val filterBeingSelectedIndex = filters.indexOf(filterBeingSelected)

        val updatedFilter = filterBeingSelected?.copy(applied = !filterBeingSelected.applied)

        if (updatedFilter != null) {
            filters[filterBeingSelectedIndex] = updatedFilter
        }

        uiState = uiState.copy(filters = filters)
    }

    fun updateSearchQuery(query: String) {
        uiState = uiState.copy(searchQuery = query)

        updateFoundThreatsWith(query)
    }

    private fun updateFoundThreatsWith(query: String) {
        val foundThreats = mutableListOf<Threat>()

        uiState.threats.forEach {
            val query = query.lowercase()

            val name = it.name.lowercase()
            val shortDescription = it.shortDescription.lowercase()

            if (name.contains(query) || shortDescription.contains(query)) foundThreats.add(it)
        }

        uiState = uiState.copy(foundThreats = foundThreats)
    }


    private suspend fun updateRepository() {
        if (threatRepository.loadAll().isEmpty()) {
            val threats = tableReader.read("thrlist.xlsx")

            threatRepository.insertAll(threats)
        }
    }

    private suspend fun loadThreats() {
        viewModelScope.launch(ioDispatcher) {
            val threats = threatRepository.loadAll()

            viewModelScope.launch(uiDispatcher) {
                uiState = uiState.copy(threats = threats)
            }
        }
    }
}
