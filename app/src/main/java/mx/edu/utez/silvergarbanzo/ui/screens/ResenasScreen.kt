package mx.edu.utez.silvergarbanzo.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import mx.edu.utez.silvergarbanzo.ui.components.cards.ResenasList
import mx.edu.utez.silvergarbanzo.viewmodel.ResenasViewModel
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import mx.edu.utez.silvergarbanzo.R
import mx.edu.utez.silvergarbanzo.ui.components.images.IconImage
import mx.edu.utez.silvergarbanzo.ui.components.images.IconSmall
import mx.edu.utez.silvergarbanzo.ui.components.texts.Link

@Composable
fun ResenasScreen(viewModel: ResenasViewModel, navController: NavController){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1b1d23))
    ) {
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
            Column{
                val resenas by viewModel.resenas.collectAsStateWithLifecycle()
                ResenasList(resenas) { viewModel::clickResena }
            }
        }
    }
}