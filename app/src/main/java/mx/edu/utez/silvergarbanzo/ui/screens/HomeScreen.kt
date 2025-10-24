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
import mx.edu.utez.silvergarbanzo.ui.components.images.IconImage
import mx.edu.utez.silvergarbanzo.ui.theme.SilverGarbanzoTheme
import mx.edu.utez.silvergarbanzo.viewmodel.HomeViewModel
import mx.edu.utez.silvergarbanzo.R
import mx.edu.utez.silvergarbanzo.data.model.Resena
import mx.edu.utez.silvergarbanzo.ui.components.PeliPreviewCard
import mx.edu.utez.silvergarbanzo.ui.components.SearchField
import mx.edu.utez.silvergarbanzo.ui.components.cards.PeliSmallCard
import mx.edu.utez.silvergarbanzo.ui.components.cards.ReseñaCard
import mx.edu.utez.silvergarbanzo.ui.components.images.IconSmall
import mx.edu.utez.silvergarbanzo.ui.components.images.PromoImage
import mx.edu.utez.silvergarbanzo.ui.components.texts.Label
import mx.edu.utez.silvergarbanzo.ui.components.texts.Link

@Composable
fun HomeScreen(viewModel: HomeViewModel, navController: NavController) {
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
            Row (modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ){
                IconImage(R.drawable.icon)
                Spacer(modifier = Modifier.width(10.dp))
                Link("@silvergarbanzo"){navController.navigate("user")}
                Spacer(modifier = Modifier.width(35.dp))
                IconSmall(R.drawable.salir, size = 25,  navController = navController, navigateTo = "login")
            }
            Spacer(modifier = Modifier.height(15.dp))
            PromoImage(R.drawable.wicked)
            Spacer(modifier = Modifier.height(15.dp))
            Row (modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row (
                    modifier = Modifier
                        .border(
                        border = BorderStroke(1.dp, Color.Gray,),
                        shape = RoundedCornerShape(1.dp),
                    )
                ){
                    Spacer(modifier = Modifier.width(20.dp))
                    Label("Popular", modifier = Modifier.padding(4.dp), fontSize = 10)
                    Spacer(modifier = Modifier.width(20.dp))
                    Label("Año", modifier = Modifier.padding(4.dp), fontSize = 10)
                    Spacer(modifier = Modifier.width(20.dp))
                    Label("Género", modifier = Modifier.padding(4.dp), fontSize = 10)
                    Spacer(modifier = Modifier.width(20.dp))
                }
                Spacer(modifier = Modifier.width(20.dp))
                SearchField(
                    modifier = Modifier
                        .height(30.dp)
                        .width(90.dp),
                    onClick = {navController.navigate("search") }
                    )}
            Spacer(modifier = Modifier.height(15.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ){
                Spacer(modifier = Modifier.width(15.dp))
                Label(
                    "Populares esta semana",
                )
                Spacer(modifier = Modifier.width(55.dp))
                Link("Más", modifier = Modifier.fillMaxWidth(),textAlign = TextAlign.End) {
                    navController.navigate("registros")
                }
                Spacer(modifier = Modifier.width(15.dp))
            }
            Divider()
            Spacer(modifier = Modifier.height(15.dp))
            Row (modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ){
                PeliPreviewCard(R.drawable.dps, "1M")
                Spacer(modifier = Modifier.width(10.dp))
                PeliPreviewCard(R.drawable.mamma_mia, "340K")
                Spacer(modifier = Modifier.width(10.dp))
                PeliPreviewCard(R.drawable.lalaland, "800K")
            }
            Spacer(modifier = Modifier.height(15.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ){
                Spacer(modifier = Modifier.width(15.dp))
                Label(
                    "Reseñadas ahora mismo",
                )
            }
            Divider()
            Spacer(modifier = Modifier.height(15.dp))
            Row (modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ){
                PeliSmallCard(R.drawable.hamilton)
                Spacer(modifier = Modifier.width(10.dp))
                PeliSmallCard(R.drawable.interstellar)
                Spacer(modifier = Modifier.width(10.dp))
                PeliSmallCard(R.drawable.tick__tickboom)
                Spacer(modifier = Modifier.width(10.dp))
                PeliSmallCard(R.drawable.fight_club)
                Spacer(modifier = Modifier.width(10.dp))
                PeliSmallCard(R.drawable.spiderman_into)
                Spacer(modifier = Modifier.width(10.dp))
                IconSmall(
                    R.drawable.next,
                    size = 30,
                    navController = navController,
                    navigateTo = "login"
                ) //navigate to se cambiara a registros
            }
            Spacer(modifier = Modifier.height(15.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ){
                Spacer(modifier = Modifier.width(15.dp))
                Label(
                    "Reseñas populares",
                )
                Spacer(modifier = Modifier.width(55.dp))
                Link("Más", modifier = Modifier.fillMaxWidth(),textAlign = TextAlign.End) {
                navController.navigate("resenas")
            }
            }
            Divider()
            Spacer(modifier = Modifier.height(15.dp))
            ReseñaCard(
                resena = Resena(
                    id = 1,
                    imagen = R.drawable.superman,
                    nombrePeli = "Superman",
                    userName = "silvergarbanzo",
                    desc = "De las mejores películas que he visto este año"
                ),
                onClick = {}
            )

        }
    }
}

@SuppressLint("ViewModelConstructorInComposable")
@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    SilverGarbanzoTheme {
        val navController = rememberNavController()
        val viewModel = HomeViewModel()
        HomeScreen(
            viewModel = viewModel,
            navController = navController
        )
    }
}