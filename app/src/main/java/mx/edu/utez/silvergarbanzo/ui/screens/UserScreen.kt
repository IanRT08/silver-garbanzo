package mx.edu.utez.silvergarbanzo.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import mx.edu.utez.silvergarbanzo.R
import mx.edu.utez.silvergarbanzo.ui.components.PeliPreviewCard
import mx.edu.utez.silvergarbanzo.ui.components.SearchField
import mx.edu.utez.silvergarbanzo.ui.components.cards.PeliFavCard
import mx.edu.utez.silvergarbanzo.ui.components.cards.PeliSmallCard
import mx.edu.utez.silvergarbanzo.ui.components.cards.RecentCard
import mx.edu.utez.silvergarbanzo.ui.components.cards.RecentCardLike
import mx.edu.utez.silvergarbanzo.ui.components.cards.ReseñaCard
import mx.edu.utez.silvergarbanzo.ui.components.images.CircularImage
import mx.edu.utez.silvergarbanzo.ui.components.images.IconImage
import mx.edu.utez.silvergarbanzo.ui.components.images.IconSmall
import mx.edu.utez.silvergarbanzo.ui.components.images.PromoImage
import mx.edu.utez.silvergarbanzo.ui.components.texts.Label
import mx.edu.utez.silvergarbanzo.ui.components.texts.Link
import mx.edu.utez.silvergarbanzo.ui.components.texts.UserLabel
import mx.edu.utez.silvergarbanzo.ui.theme.SilverGarbanzoTheme
import mx.edu.utez.silvergarbanzo.viewmodel.HomeViewModel
import mx.edu.utez.silvergarbanzo.viewmodel.UserViewModel

@Composable
fun UserScreen(viewModel: UserViewModel, navController: NavController){
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
            CircularImage(R.drawable.garbanzo)
            Spacer(modifier = Modifier.height(5.dp))
            UserLabel("silvergarbanzo", color = Color(0xFFD0D0D0))
            Spacer(modifier = Modifier.height(15.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ){
                Spacer(modifier = Modifier.width(15.dp))
                Label(
                    "Peliculas favoritas",
                )
                Spacer(modifier = Modifier.width(15.dp))
            }
            Divider()
            Spacer(modifier = Modifier.height(15.dp))
            Row (modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ){
                PeliFavCard(R.drawable.mins31)
                Spacer(modifier = Modifier.width(10.dp))
                PeliFavCard(R.drawable.grease)
                Spacer(modifier = Modifier.width(10.dp))
                PeliFavCard(R.drawable.legally)
                Spacer(modifier = Modifier.width(10.dp))
                PeliFavCard(R.drawable.prada)
            }
            Spacer(modifier = Modifier.height(15.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ){
                Spacer(modifier = Modifier.width(15.dp))
                Label(
                    "Actividad reciente",
                )
                Spacer(modifier = Modifier.width(15.dp))
            }
            Divider()
            Spacer(modifier = Modifier.height(15.dp))
            Row (modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ){
                RecentCardLike(R.drawable.club, R.drawable.rate4)
                Spacer(modifier = Modifier.width(10.dp))
                RecentCard(R.drawable.wedding, R.drawable.rate1)
                Spacer(modifier = Modifier.width(10.dp))
                RecentCardLike(R.drawable.scream, R.drawable.rate3)
                Spacer(modifier = Modifier.width(10.dp))
                IconSmall(
                    R.drawable.next,
                    size = 30,
                    navController = navController,
                    navigateTo = "registros"
                ) //navigate to se cambiara a registros

            }
            Spacer(modifier = Modifier.height(15.dp))
            Divider()
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ){
                Spacer(modifier = Modifier.width(15.dp))
                Link("Likes",){navController.navigate("like")} //ruta a ver likes
            }
            Divider()
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ){
                Spacer(modifier = Modifier.width(15.dp))
                Link("Registros",){navController.navigate("registros")} //ruta a ver registros
            }
            Divider()
            Spacer(modifier = Modifier.height(50.dp))
            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .border(
                        border = BorderStroke(1.dp, Color.Gray,),
                        shape = RoundedCornerShape(5.dp),)
                    .fillMaxWidth()
                    .height(70.dp)
            ){
                Spacer(modifier = Modifier.width(20.dp))
                IconSmall(
                    R.drawable.lupa,
                    size = 40,
                    navController = navController,
                    navigateTo = "search"
                ) //navigate to se cambiara a buscar
                Spacer(modifier = Modifier.width(20.dp))
                IconSmall(
                    R.drawable.likes,
                    size = 40,
                    navController = navController,
                    navigateTo = "like"
                ) //navigate to se cambiara a likes
                Spacer(modifier = Modifier.width(20.dp))
                IconSmall(
                    R.drawable.home,
                    size = 40,
                    navController = navController,
                    navigateTo = "home"
                )
                Spacer(modifier = Modifier.width(20.dp))
                IconSmall(
                    R.drawable.agregar,
                    size = 40,
                    navController = navController,
                    navigateTo = "add"
                ) //navigate to se cambiara a agregar
                Spacer(modifier = Modifier.width(20.dp))
                IconSmall(
                    R.drawable.registros,
                    size = 40,
                    navController = navController,
                    navigateTo = "registros"
                ) //navigate to se cambiara a registros
                Spacer(modifier = Modifier.width(20.dp))
            }

        }
    }
}

@SuppressLint("ViewModelConstructorInComposable")
@Preview(showBackground = true)
@Composable
fun PreviewUserScreen() {
    SilverGarbanzoTheme {
        val navController = rememberNavController()
        val viewModel = UserViewModel()
        UserScreen(
            viewModel = viewModel,
            navController = navController
        )
    }
}