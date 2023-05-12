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
    )

    var uiState by mutableStateOf(UiState())
        private set

    init {
        viewModelScope.launch(ioDispatcher) {
            updateRepository()

            loadThreats()
        }
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
