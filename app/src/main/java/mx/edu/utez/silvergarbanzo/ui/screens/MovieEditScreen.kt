package mx.edu.utez.silvergarbanzo.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import mx.edu.utez.silvergarbanzo.R
import mx.edu.utez.silvergarbanzo.ui.components.PeliPreviewCard
import mx.edu.utez.silvergarbanzo.ui.components.buttons.Checkbox
import mx.edu.utez.silvergarbanzo.ui.components.buttons.SecundaryButton
import mx.edu.utez.silvergarbanzo.ui.components.images.IconImage
import mx.edu.utez.silvergarbanzo.ui.components.images.IconSmall
import mx.edu.utez.silvergarbanzo.ui.components.texts.Label
import mx.edu.utez.silvergarbanzo.ui.components.texts.Link
import mx.edu.utez.silvergarbanzo.ui.theme.SilverGarbanzoTheme
import mx.edu.utez.silvergarbanzo.viewmodel.MovieEditViewmodel
import mx.edu.utez.silvergarbanzo.viewmodel.RecordViewmodel

@Composable
fun MovieEditScreen (viewmodel: MovieEditViewmodel, navController: NavController){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1b1d23))
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconImage(R.drawable.icon)
                Spacer(modifier = Modifier.width(10.dp))
                Link("@silvergarbanzo") { navController.navigate("user") }
                Spacer(modifier = Modifier.width(35.dp))
                IconSmall(
                    R.drawable.salir,
                    size = 25,
                    navController = navController,
                    navigateTo = "login"
                )
            }
            Spacer(modifier = Modifier.height(15.dp))
            Row (modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Absolute.Left,
                verticalAlignment = Alignment.CenterVertically,
            ){
                PeliPreviewCard(R.drawable.tick__tickboom, "1M")
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                Row {
                    Label(
                        "Tik tik.. boom",
                    )
                }
                Row {
                    Label(
                        "Año de estreno: 2022",
                    )
                }
                    Row {
                        Label(
                            "Momo de twice",
                        )
                    }
                    Row {
                        Label(
                            "Andrew ",
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(15.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                Spacer(modifier = Modifier.width(15.dp))
                Label(
                    "Fecha en la que se vio la pelicula: 24 | 10 | 23",
                )
            }
            Spacer(modifier = Modifier.height(15.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                Spacer(modifier = Modifier.width(15.dp))
                Label(
                    "Calificación",
                )

            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                Spacer(modifier = Modifier.width(15.dp))
                Image(
                    painter = painterResource(R.drawable.rate4),
                    contentDescription = "Rating",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .width(60.dp)
                        .height(20.dp)
                )
            }
            Spacer(modifier = Modifier.height(15.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                Spacer(modifier = Modifier.width(15.dp))
                Label(
                    "Reseña",
                )
            }
            Row {
                Label(
                    "La cinta combina música, emoción y reflexión sobre los sueños y la pasión por el arte. Andrew Garfield interpreta a Jonathan con mucha energía y sentimiento, mostrando lo difícil pero inspirador que puede ser perseguir tus metas.\n" +
                            "\n" +
                            "En general, es una película que motiva a no rendirse y a seguir tus sueños, incluso cuando todo parece estar en tu contra."
                )
            }
            Spacer(modifier = Modifier.height(170.dp))
            Row {
                SecundaryButton(
                   text = "Borrar reseña",
                    onClick = { navController.navigate("home") },
                    modifier = Modifier.weight(5f)
                )
            }
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ){  Spacer(modifier = Modifier.height(12.dp))
                SecundaryButton(
                    text = "Borrar registro",
                    onClick = { navController.navigate("home") },
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.width(15.dp))
                SecundaryButton(
                    text = "Guardar ",
                    onClick = { navController.navigate("home") },
                    modifier = Modifier.weight(1f)
                )
            }
            Spacer(modifier = Modifier.height(250.dp))
        }
    }
}
@SuppressLint("ViewModelConstructorInComposable")
@Preview(showBackground = true)
@Composable
fun PreviewMovieEditScreen() {
    SilverGarbanzoTheme {
        val navController = rememberNavController()
        val viewModel = MovieEditViewmodel()
        MovieEditScreen(
            viewmodel=viewModel,
            navController=navController
        )
    }
}