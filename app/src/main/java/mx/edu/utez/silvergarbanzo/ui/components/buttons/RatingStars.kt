package mx.edu.utez.silvergarbanzo.ui.components.buttons

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import mx.edu.utez.silvergarbanzo.R

@Composable
fun RatingStars(
    rating: Float,
    onRatingChanged: (Float) -> Unit,
    modifier: Modifier = Modifier,
    starCount: Int = 5
) {
    Row(modifier = modifier) {
        for (i in 1..starCount) {
            val starResource = if (i <= rating) {
                R.drawable.star_filled
            } else {
                R.drawable.staroutline
            }

            Image(
                painter = painterResource(id = starResource),
                contentDescription = "Calificación $i de $starCount",
                modifier = Modifier
                    .size(24.dp)
                    .clickable { onRatingChanged(i.toFloat()) }
                    .padding(2.dp)
            )
        }
    }
}