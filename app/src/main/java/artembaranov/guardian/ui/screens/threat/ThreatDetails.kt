package artembaranov.guardian.ui.screens.threat

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier

@Composable
fun ThreatDetails(
    viewModel: ThreatDetailsViewModel,
    modifier: Modifier = Modifier
) {
    val uiState = viewModel.uiState

    Column(modifier = modifier.fillMaxSize()) {
        Text(text = uiState.name)
        Text(text = uiState.shortDescription)
        Text(text = uiState.fullDescription)
        uiState.threatSources.forEach {
            Text(text = it.name)
        }
        uiState.threatConsequences.forEach {
            Text(text = it.name)
        }
        uiState.objectsOfInfluence.forEach {
            Text(text = it.name)
        }
    }

    LaunchedEffect(Unit) {
        viewModel.onAppear()
    }
}
