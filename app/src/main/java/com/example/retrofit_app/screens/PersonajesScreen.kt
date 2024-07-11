package com.example.retrofit_app.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.retrofit_app.model.Personaje

@Composable
fun PersonajesScreen(viewModel: PersonajesViewModel = HiltViewModel){
val state by viewModel.state.collectAsState()
    Log.d("Cantidad Items", "${state.size}")
    LazyColumn(){
        items(state){
            personaje -> PersonajeCard(personaje)
        }

    }
}

@Composable
fun PersonajeCard(personaje: Personaje, modifier: Modifier = Modifier) {
    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ){
        Column {
            Row{
                Surface (
                    modifier.size(120.dp),
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f)
                ){
                    AsyncImage(
                        model = personaje.image,
                        contentDescription = personaje.name,
                        contentScael = ContentScale.FillBounds
                    )

                }
            }

        }
    }

}
