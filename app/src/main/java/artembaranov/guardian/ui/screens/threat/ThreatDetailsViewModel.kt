package artembaranov.guardian.ui.screens.threat

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import artembaranov.guardian.di.IODispatcher
import artembaranov.guardian.di.MainDispatcher
import artembaranov.guardian.entities.ObjectOfInfluence
import artembaranov.guardian.entities.ThreatConsequence
import artembaranov.guardian.entities.ThreatSource
import artembaranov.guardian.repositories.ThreatRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ThreatDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val threatRepository: ThreatRepository,
    @MainDispatcher private val uiDispatcher: CoroutineDispatcher,
    @IODispatcher private val ioDispatcher: CoroutineDispatcher,
) : ViewModel() {
    private val threatId: Long = requireNotNull(savedStateHandle[SavedStateKeys.THREAT_ID])

    object SavedStateKeys {
        const val THREAT_ID = "threatId"
    }

    data class UiState(
        val name: String = "",
        val shortDescription: String = "",
        val fullDescription: String = "",
        val threatSources: List<ThreatSource> = emptyList(),
        val objectsOfInfluence: List<ObjectOfInfluence> = emptyList(),
        val threatConsequences: List<ThreatConsequence> = emptyList(),
    )

    var uiState: UiState by mutableStateOf(UiState())
        private set

    suspend fun onAppear() {
        loadThreat()
    }

    private suspend fun loadThreat() {
        viewModelScope.launch(ioDispatcher) {
            val threat = threatRepository.loadById(threatId)

            viewModelScope.launch(uiDispatcher) {
                uiState = uiState.copy(
                    name = threat.name,
                    shortDescription = threat.shortDescription,
                    fullDescription = threat.fullDescription,
                    threatSources = threat.threatSources,
                    objectsOfInfluence = threat.objectsOfInfluence,
                    threatConsequences = threat.threatConsequences,
                )
            }
        }
    }
}
