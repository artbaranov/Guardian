package artembaranov.guardian.ui.screens.home

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import artembaranov.guardian.entities.Threat
import artembaranov.guardian.ui.components.SearchField
import artembaranov.guardian.ui.screens.home.views.ThreatList

@Composable
fun Home(
    modifier: Modifier = Modifier,
    onThreatClicked: (Threat) -> Unit,
    viewModel: HomeViewModel
) {
    val uiState = viewModel.uiState


    val uiFlow = UiFlow(
        onThreatClicked = onThreatClicked,
        onSearchQueryChanged = viewModel::updateSearchQuery
    )

    HomeImpl(modifier = modifier, uiState = uiState, uiFlow = uiFlow)
}

@Composable
fun HomeImpl(
    modifier: Modifier,
    uiState: HomeViewModel.UiState = HomeViewModel.UiState(),
    uiFlow: UiFlow = UiFlow(),
) {
    val focusManager = LocalFocusManager.current

    Column(
        modifier = modifier.pointerInput(Unit) {
            detectTapGestures(onTap = {
                focusManager.clearFocus()
            })
        },
        horizontalAlignment = CenterHorizontally
    ) {
        SearchField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 30.dp),
            text = uiState.searchQuery,
            onTextChanged = uiFlow.onSearchQueryChanged
        )

        val searchQuery = uiState.searchQuery

        ThreatList(
            threats = if (searchQuery.isEmpty()) {
                uiState.threats
            } else {
                uiState.foundThreats
            },
            modifier = Modifier.fillMaxSize(),
            onThreatClicked = uiFlow.onThreatClicked
        )
    }
}

data class UiFlow(
    val onSearchQueryChanged: (String) -> Unit = {},
    val onThreatClicked: (Threat) -> Unit = {},
)
