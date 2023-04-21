package artembaranov.guardian.ui.screens.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import artembaranov.guardian.entities.Threat
import artembaranov.guardian.ui.screens.home.views.ThreatList

@Composable
fun Home(
    modifier: Modifier = Modifier,
    onThreatClicked: (Threat) -> Unit,
    viewModel: HomeViewModel
) {
    val uiState = viewModel.uiState

    ThreatList(threats = uiState.threats, modifier = modifier.fillMaxSize(), onThreatClicked = onThreatClicked)

    LaunchedEffect(Unit) {
        viewModel.onStart()
    }
}
