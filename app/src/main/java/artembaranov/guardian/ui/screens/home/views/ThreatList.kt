package artembaranov.guardian.ui.screens.home.views

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import artembaranov.guardian.entities.Threat
import artembaranov.guardian.ui.theme.GuardianTheme
import kotlinx.coroutines.launch

@Composable
fun ThreatList(
    threats: List<Threat>, modifier: Modifier = Modifier,
    onThreatClicked: (Threat) -> Unit
) {
    val listState = rememberLazyListState()

    var lastVisibleItemPosition by remember { mutableStateOf(0) }

    Box(modifier = modifier) {
        LazyColumn(
            modifier = modifier,
            state = listState
        ) {
            itemsIndexed(threats) { index, threat ->
                ThreatItem(threat, Modifier.fillMaxWidth()) { onThreatClicked(threat) }

                lastVisibleItemPosition = index
            }
        }

        ScrollToTopButton(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(bottom = 15.dp, end = 15.dp),
            visible = lastVisibleItemPosition >= 30,
            state = listState
        )
    }
}

@Composable
private fun ScrollToTopButton(modifier: Modifier, visible: Boolean, state: LazyListState) {
    val coroutineScope = rememberCoroutineScope()

    AnimatedVisibility(
        enter = fadeIn(),
        exit = fadeOut(),
        visible = visible,
        modifier = modifier
    ) {
        FloatingActionButton(
            backgroundColor = GuardianTheme.colors.onSurface,
            onClick = {
                coroutineScope.launch {
                    state.animateScrollToItem(index = 0)
                }
            }
        ) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowUp,
                contentDescription = null
            )
        }
    }
}
