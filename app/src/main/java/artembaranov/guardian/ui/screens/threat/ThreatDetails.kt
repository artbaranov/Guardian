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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import artembaranov.guardian.R
import artembaranov.guardian.ui.theme.GuardianTheme

@Composable
fun ThreatDetails(
    viewModel: ThreatDetailsViewModel,
    modifier: Modifier = Modifier
) {
    val uiState = viewModel.uiState

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(color = GuardianTheme.colors.background)
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
                    Text(modifier = it, text = uiState.fullDescription, color = GuardianTheme.colors.primaryVariant1)
                }
            )
        }
        item {
            DetailsSection(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp),
                headline = stringResource(id = R.string.threat_details_threat_sources_section_title),
                content = { modifier ->
                    uiState.threatSources.forEach { threat ->
                        Text(modifier = modifier, text = threat.name, color = GuardianTheme.colors.primaryVariant1)
                    }
                }
            )
        }
        item {
            DetailsSection(
                modifier = Modifier.fillMaxWidth(),
                headline = stringResource(id = R.string.threat_details_threat_consequence_section_title),
                content = { modifier ->
                    uiState.threatConsequences.forEach { threatConsequence ->
                        Text(
                            modifier = modifier,
                            text = threatConsequence.name,
                            color = GuardianTheme.colors.primaryVariant1
                        )
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
                content = { modifier ->
                    uiState.objectsOfInfluence.forEach { objectOfInfluence ->
                        Text(
                            modifier = modifier,
                            text = objectOfInfluence.name,
                            color = GuardianTheme.colors.primaryVariant1
                        )
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
        fontSize = 24.sp,
        color = GuardianTheme.colors.primaryVariant1
    )
}

@Composable
private fun DetailsSection(modifier: Modifier, headline: String, content: @Composable (Modifier) -> Unit) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .background(color = GuardianTheme.colors.onSurfaceVariant1, shape = RoundedCornerShape(10.dp))
            .padding(10.dp),
    ) {
        Text(
            modifier = Modifier.padding(bottom = 3.dp),
            text = headline,
            fontSize = 20.sp,
            color = GuardianTheme.colors.primaryVariant1
        )
        Divider(color = GuardianTheme.colors.primary, modifier = Modifier.height(1.dp))
        content(modifier.padding(top = 5.dp))
    }
}