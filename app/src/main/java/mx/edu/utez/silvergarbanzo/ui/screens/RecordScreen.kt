package mx.edu.utez.silvergarbanzo.ui.screens

import android.R.attr.onClick
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import mx.edu.utez.silvergarbanzo.ui.components.buttons.PrimaryButton
import mx.edu.utez.silvergarbanzo.ui.components.buttons.SecundaryButton
import mx.edu.utez.silvergarbanzo.ui.components.cards.PeliSmallCard
import mx.edu.utez.silvergarbanzo.ui.components.cards.ReseñaCard
import mx.edu.utez.silvergarbanzo.ui.components.images.IconImage
import mx.edu.utez.silvergarbanzo.ui.components.images.IconSmall
import mx.edu.utez.silvergarbanzo.ui.components.images.PromoImage
import mx.edu.utez.silvergarbanzo.ui.components.texts.Label
import mx.edu.utez.silvergarbanzo.ui.components.texts.Link
import mx.edu.utez.silvergarbanzo.ui.theme.SilverGarbanzoTheme
import mx.edu.utez.silvergarbanzo.viewmodel.RecordViewmodel

@Composable
fun RecordScreen(viewmodel: RecordViewmodel, navController: NavController){
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
            } //encabezado
            Spacer(modifier = Modifier.height(15.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                Spacer(modifier = Modifier.width(15.dp))
                Label(
                    "Historial de peliculas",
                )
                Spacer(modifier = Modifier.width(85.dp))
                SearchField(
                    modifier = Modifier
                        .height(30.dp)
                        .width(90.dp),
                    onClick = {navController.navigate("login") }
                )
            }
            Spacer(modifier = Modifier.height(15.dp))
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    PeliSmallCard(R.drawable.grease)
                    Spacer(modifier = Modifier.width(10.dp))
                    PeliSmallCard(R.drawable.heathers)
                    Spacer(modifier = Modifier.width(10.dp))
                    PeliSmallCard(R.drawable.dps)
                    Spacer(modifier = Modifier.width(10.dp))
                    PeliSmallCard(R.drawable.club)
                    Spacer(modifier = Modifier.width(10.dp))
                    PeliSmallCard(R.drawable.lalaland)
                    Spacer(modifier = Modifier.width(10.dp))
                }
                Spacer(modifier = Modifier.height(15.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    PeliSmallCard(R.drawable.wicked)
                    Spacer(modifier = Modifier.width(10.dp))
                    PeliSmallCard(R.drawable.mamma_mia)
                    Spacer(modifier = Modifier.width(10.dp))
                    PeliSmallCard(R.drawable.wedding)
                    Spacer(modifier = Modifier.width(10.dp))
                    PeliSmallCard(R.drawable.legally)
                    Spacer(modifier = Modifier.width(10.dp))
                    PeliSmallCard(R.drawable.mins31)
                    Spacer(modifier = Modifier.width(10.dp))
                }
                Spacer(modifier = Modifier.height(15.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    PeliSmallCard(R.drawable.grease)
                    Spacer(modifier = Modifier.width(10.dp))
                    PeliSmallCard(R.drawable.heathers)
                    Spacer(modifier = Modifier.width(10.dp))
                    PeliSmallCard(R.drawable.dps)
                    Spacer(modifier = Modifier.width(10.dp))
                    PeliSmallCard(R.drawable.club)
                    Spacer(modifier = Modifier.width(10.dp))
                    PeliSmallCard(R.drawable.lalaland)
                    Spacer(modifier = Modifier.width(10.dp))
                }
                Spacer(modifier = Modifier.height(15.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    PeliSmallCard(R.drawable.wicked)
                    Spacer(modifier = Modifier.width(10.dp))
                    PeliSmallCard(R.drawable.mamma_mia)
                    Spacer(modifier = Modifier.width(10.dp))
                    PeliSmallCard(R.drawable.wedding)
                    Spacer(modifier = Modifier.width(10.dp))
                    PeliSmallCard(R.drawable.legally)
                    Spacer(modifier = Modifier.width(10.dp))
                    PeliSmallCard(R.drawable.mins31)
                    Spacer(modifier = Modifier.width(10.dp))
                }
                Spacer(modifier = Modifier.height(15.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    PeliSmallCard(R.drawable.grease)
                    Spacer(modifier = Modifier.width(10.dp))
                    PeliSmallCard(R.drawable.heathers)
                    Spacer(modifier = Modifier.width(10.dp))
                    PeliSmallCard(R.drawable.dps)
                    Spacer(modifier = Modifier.width(10.dp))
                    PeliSmallCard(R.drawable.club)
                    Spacer(modifier = Modifier.width(10.dp))
                    PeliSmallCard(R.drawable.lalaland)
                    Spacer(modifier = Modifier.width(10.dp))
                }
                Spacer(modifier = Modifier.height(15.dp))
            }
            Spacer(modifier = Modifier.height(15.dp))
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ){  Spacer(modifier = Modifier.width(180.dp))
                PrimaryButton(
                    text = "Mas antiguo",
                    onClick = { navController.navigate("home") },
                    modifier = Modifier.weight(1f)
                )
            }
            Spacer(modifier = Modifier.height(15.dp))
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ){  Spacer(modifier = Modifier.width(12.dp))
                SecundaryButton(
                    text = "1",
                    onClick = { navController.navigate("home") },
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.width(12.dp))
                SecundaryButton(
                    text = "2",
                    onClick = { navController.navigate("home") },
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.width(12.dp))
                SecundaryButton(
                    text = "3",
                    onClick = { navController.navigate("home") },
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}
@SuppressLint("ViewModelConstructorInComposable")
@Preview(showBackground = true)
@Composable
fun PreviewRecordScreen() {
    SilverGarbanzoTheme {
        val navController = rememberNavController()
        val viewModel = RecordViewmodel()
        RecordScreen(
            viewmodel=viewModel,
            navController=navController
        )
    }
}