package mx.edu.utez.silvergarbanzo.ui.components.cards

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.items
import mx.edu.utez.silvergarbanzo.data.model.Resena

@Composable
fun ResenasList(lista: List<Resena>, x: (Resena) -> Unit){
    LazyColumn (
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ){
        items(items = lista, key = {it.id} ) {resena ->
            ReseñaCard(resena) {x(resena)}
        }
    }
}