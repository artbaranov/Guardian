package artembaranov.guardian.ui.screens.home.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import artembaranov.guardian.entities.Threat

@Composable
fun ThreatItem(
    threat: Threat,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier
            .clickable(onClick = onClick)
            .padding(start = 35.dp, top = 13.dp, bottom = 12.dp, end = 25.dp)
            .fillMaxWidth(),
    ) {
        Text(
            text = threat.name,
            fontSize = 18.sp,
            fontFamily = FontFamily.SansSerif,
        )
    }
}
