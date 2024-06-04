package com.juvey.examen.screensexam.views

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState
import com.juvey.examen.screensexam.models.Rest
import com.juvey.examen.screensexam.viewmodel.RestViewModel

@Composable
fun RestViewDetail(rest: Rest, viewModel: RestViewModel, navController: NavController, context: Context = LocalContext.current) {
    val latLng = LatLng(rest.latitude.toDouble(), rest.longitude.toDouble())
    val cameraPositionState = rememberCameraPositionState{
        position = com.google.android.gms.maps.model.CameraPosition.fromLatLngZoom(latLng, 15f)
    }

    fun callPhoneNumber(phoneNumber: String) {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$phoneNumber")
        }
        context.startActivity(intent)
    }
    fun openWebsite(url: String?, context: Context) {
        if (!url.isNullOrBlank()) {
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse(url)
            }
            context.startActivity(intent)
        } else {
            // Manejar el caso en el que la URL es nula o vacía
            Log.e("OpenWebsite", "La URL es nula o vacía")
        }
    }

    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        // Botón de flecha para regresar en la esquina superior izquierda
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier.align(Alignment.Start)
        ) {
            Icon(Icons.Default.ArrowBack, contentDescription = "Back")
        }

        // Nombre del restaurante centrado y en negritas
        Text(
            text = rest.name,
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(vertical = 8.dp)
        )

        // Mostrar imagen del restaurante que abarca toda la anchura disponible
        Image(
            painter = rememberImagePainter(data = rest.imgName),
            contentDescription = "Imagen del restaurante",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.Crop
        )

        GoogleMap(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(16 / 9f),
            cameraPositionState = cameraPositionState
        ) {
            Marker(
                state = com.google.maps.android.compose.MarkerState(
                    position = latLng),
                title = rest.name
            )
        }

        Button(
            onClick = { callPhoneNumber(rest.phone) },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("Llamar")
        }

        Button(
            onClick = { openWebsite(rest.webSite, context) },
            modifier = Modifier
                .padding(vertical = 8.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Text("Sitio Web")
        }
    }
}







