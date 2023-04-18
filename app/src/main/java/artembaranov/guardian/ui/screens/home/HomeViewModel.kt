package artembaranov.guardian.ui.screens.home

import androidx.lifecycle.ViewModel
import artembaranov.guardian.entities.Threat
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {
    data class UiState(val threats: List<Threat> = emptyList())

    var uiState = UiState()
        private set

}
