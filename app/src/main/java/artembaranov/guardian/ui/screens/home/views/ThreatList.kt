package artembaranov.guardian.ui.screens.home.views

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import artembaranov.guardian.entities.Threat

@Composable
fun ThreatList(
    threats: List<Threat>, modifier: Modifier = Modifier,
    onThreatClicked: () -> Unit
) {
    LazyColumn(modifier = modifier) {
        items(threats) { threat ->
            ThreatItem(threat, Modifier.fillMaxWidth(), onThreatClicked)
        }
    }
}
