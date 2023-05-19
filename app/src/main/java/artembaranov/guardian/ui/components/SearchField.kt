package artembaranov.guardian.ui.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import artembaranov.guardian.ui.screens.home.Filter
import artembaranov.guardian.ui.theme.GuardianTheme

/**
 * Created by Artem Baranov on 13.05.2023.
 */

@Composable
fun SearchField(
    modifier: Modifier = Modifier,
    text: String,
    filters: List<Filter>,
    onTextChanged: (String) -> Unit,
    onFilterApplied: (Filter) -> Unit,
) {

    TextField(
        modifier = modifier
            .clip(RoundedCornerShape(35.dp)),
        value = text,
        onValueChange = onTextChanged,
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Search, contentDescription = null,
                tint = GuardianTheme.colors.primary
            )
        },
        leadingIcon = {
            DropDownMenu(filters = filters, onFilterApplied = onFilterApplied)
        },
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(
            textColor = GuardianTheme.colors.primary,
            cursorColor = GuardianTheme.colors.primary,
            disabledTextColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        )
    )
}
