package mx.edu.utez.silvergarbanzo.ui.components.images

import androidx.annotation.RestrictTo
import androidx.annotation.Size
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun IconSmall(
    imageRes: Int,
    size: Int,
    navController: NavController,
    navigateTo: String
) {
    Image(
        painter = painterResource(imageRes),
        contentDescription = "Ir a otra pantalla",
        modifier = Modifier
            .size(size.dp)
            .clickable {
                navController.navigate(navigateTo)
            }
    )

}