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

/**
 * Created by Artem Baranov on 13.05.2023.
 */

@Composable
fun SearchField(
    text: String,
    modifier: Modifier = Modifier,
    onTextChanged: (String) -> Unit
) {

    TextField(
        modifier = modifier
            .clip(RoundedCornerShape(35.dp)),
        value = text,
        onValueChange = onTextChanged,
        trailingIcon = {
            Icon(imageVector = Icons.Default.Search, contentDescription = null)
        },
        leadingIcon = {
            DropDownMenu()
        },
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(
            disabledTextColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        )
    )
}
