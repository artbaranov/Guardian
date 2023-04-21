package artembaranov.guardian.ui.screens.threat

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import artembaranov.guardian.R

@Composable
fun ThreatDetails(
    viewModel: ThreatDetailsViewModel,
    modifier: Modifier = Modifier
) {
    val uiState = viewModel.uiState

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(start = 25.dp, end = 25.dp)
    ) {
        item {
            Title(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp),
                text = uiState.name,
            )
        }
        item {
            DetailsSection(
                modifier = Modifier.fillMaxWidth(),
                headline = stringResource(id = R.string.threat_details_full_description_section_title),
                content = {
                    Text(text = uiState.fullDescription)
                }
            )
        }
        item {
            DetailsSection(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp),
                headline = stringResource(id = R.string.threat_details_threat_sources_section_title),
                content = {
                    uiState.threatSources.forEach {
                        Text(text = it.name)
                    }
                }
            )
        }
        item {
            DetailsSection(
                modifier = Modifier.fillMaxWidth(),
                headline = stringResource(id = R.string.threat_details_threat_consequence_section_title),
                content = {
                    uiState.threatConsequences.forEach {
                        Text(text = it.name)
                    }
                }
            )
        }
        item {
            DetailsSection(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp),
                headline = stringResource(id = R.string.threat_details_objects_of_influence_section_title),
                content = {
                    uiState.objectsOfInfluence.forEach {
                        Text(text = it.name)
                    }
                }
            )
        }
    }

    LaunchedEffect(Unit) {
        viewModel.onAppear()
    }
}

@Composable
private fun Title(
    modifier: Modifier,
    text: String,
) {
    Text(
        modifier = modifier,
        text = text,
        textAlign = TextAlign.Center,
        fontSize = 24.sp
    )
}

@Composable
private fun DetailsSection(modifier: Modifier, headline: String, content: @Composable () -> Unit) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .background(Color(0xFF7DCEA0), shape = RoundedCornerShape(10.dp))
            .padding(5.dp),
    ) {
        Text(text = headline, fontSize = 18.sp)
        Divider(color = Color.Black.copy(alpha = 0.5f), modifier = Modifier.height(1.dp))
        content()
    }
}