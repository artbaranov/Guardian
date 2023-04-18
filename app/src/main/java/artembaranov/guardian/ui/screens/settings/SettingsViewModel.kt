package artembaranov.guardian.ui.screens.settings

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor() : ViewModel() {
    enum class CurrentScreen {
        HOME
    }

    data class UiState(val currentScreen: CurrentScreen = CurrentScreen.HOME)

    var uiState = UiState()
        private set
}
