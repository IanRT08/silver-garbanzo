package mx.edu.utez.silvergarbanzo.ui.components.buttons

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import mx.edu.utez.silvergarbanzo.R

@Composable
fun LikeButton(
    isLiked: Boolean,
    onLikeChanged: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(
            id = if (isLiked) R.drawable.likes else R.drawable.corazon
        ),
        contentDescription = if (isLiked) "Quitar like" else "Dar like",
        modifier = modifier
            .size(32.dp)
            .clickable { onLikeChanged(!isLiked) }
            .padding(2.dp)
    )
}