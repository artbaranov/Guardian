package artembaranov.guardian.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Checkbox
import androidx.compose.material.DropdownMenu
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import artembaranov.guardian.ui.screens.home.Filter
import artembaranov.guardian.ui.theme.GuardianTheme

/**
 * Created by Artem Baranov on 13.05.2023.
 */

@Composable
fun DropDownMenu(
    modifier: Modifier = Modifier,
    filters: List<Filter>,
    onFilterApplied: (Filter) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Box(
        modifier = modifier
    ) {
        IconButton(onClick = { expanded = !expanded }) {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "More",
                tint = GuardianTheme.colors.primary
            )
        }

        DropdownMenu(
            modifier = Modifier.width(300.dp),
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            filters.forEach {
                FilterItem(filter = it, onFilterApplied = onFilterApplied)
            }
        }
    }
}

@Composable
private fun FilterItem(
    modifier: Modifier = Modifier,
    filter: Filter,
    onFilterApplied: (Filter) -> Unit
) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Checkbox(checked = filter.applied, onCheckedChange = { onFilterApplied(filter) })


        Text(text = filter.name)
    }
}
