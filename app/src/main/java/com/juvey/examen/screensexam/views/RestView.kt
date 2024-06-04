package com.juvey.examen.screensexam.views

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.juvey.examen.screensexam.models.Rest
import com.juvey.examen.screensexam.viewmodel.RestViewModel
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun MyApp() {
    val navController = rememberNavController()
    val viewModel: RestViewModel = viewModel() // Obtener ViewModel

    NavHost(navController = navController, startDestination = "restView") {
        composable("restView") {
            RestView(viewModel, navController)
        }
        composable("restViewDetail/{restName}") { backStackEntry ->
            val restName = backStackEntry.arguments?.getString("restName")
            val rest = viewModel.rests.value.find { it.name.equals(restName, ignoreCase = true) }
            if (rest != null) {
                RestViewDetail(rest, viewModel, navController)
            } else {
                Text("Restaurante no encontrado")
            }
        }
    }
}

@Composable
fun RestView(viewModel: RestViewModel, navController: NavController) {
    val rests by viewModel.rests.collectAsState()

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(rests) { rest ->
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .clickable {
                        // Navegar a RestViewDetail cuando se hace clic en un restaurante
                        navController.navigate("restViewDetail/${rest.name}")
                    }
            ) {
                Box(modifier = Modifier.fillMaxSize()) {
                    AsyncImage(
                        model = rest.imgName,
                        contentDescription = "No jala",
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(16 / 9f)
                            .clip(RoundedCornerShape(8.dp)),
                        contentScale = ContentScale.Crop
                    )
                    val icon = if (rest.isFavorite) {
                        Icons.Default.Favorite
                    } else {
                        Icons.Default.FavoriteBorder
                    }

                    Icon(
                        imageVector = icon,
                        contentDescription = "Favorite",
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .padding(8.dp)
                            .size(24.dp),
                        tint = Color.Magenta
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = rest.name,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        modifier = Modifier.weight(1f)
                    )
                    Box(
                        modifier = Modifier
                            .padding(start = 8.dp)
                            .background(Color.LightGray)
                            .padding(horizontal = 8.dp, vertical = 4.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = rest.rating.toString(),
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        )
                    }
                }
                Text(text = "\uD83D\uDCB3 MX $ ${rest.fee} Delivery Fee: 35 - 45 min")
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
    DisposableEffect(Unit) {
        viewModel.getRests()
        onDispose {}
    }
}
