package mx.edu.utez.silvergarbanzo.ui.components.images

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun IconImage(
    imageRes: Int,
    width: Int = 150,
    height: Int = 40,
    cornerRadius: Int = 8
) {
    Image(
        painter = painterResource(id = imageRes),
        contentDescription = "Icono de la aplicación",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .width(width.dp)
            .height(height.dp)
            .clip(RoundedCornerShape(cornerRadius.dp))
            .border(
                border = BorderStroke(0.5.dp, Color.Gray),
                shape = RoundedCornerShape(cornerRadius.dp)
            )
    )
}