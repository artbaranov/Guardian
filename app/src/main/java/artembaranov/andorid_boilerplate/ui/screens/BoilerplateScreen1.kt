package artembaranov.andorid_boilerplate.ui

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import artembaranov.andorid_boilerplate.R

@Composable
fun BoilerplateScreen1(modifier: Modifier = Modifier) {
    Text(
        modifier = modifier,
        text = stringResource(R.string.app_name)
    )
}
