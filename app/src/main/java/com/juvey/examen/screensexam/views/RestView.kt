package com.juvey.examen.screensexam.views

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.juvey.examen.screensexam.models.Rest
import com.juvey.examen.screensexam.viewmodel.RestViewModel
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@Composable
fun MyApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "rests") {
        composable("rests") {
            RestView(RestViewModel(), navController)
        }
        composable("detail/{rest}", arguments = listOf(navArgument("rest") { type = NavType.StringType})) { backStackEntry ->
            val restaurantJson = backStackEntry.arguments?.getString("rest")
            val restaurant = Json.decodeFromString<Rest>(restaurantJson!!)
            RestViewDetail(restaurant, navController)
        }
    }
}


@Composable
fun RestView(viewModel: RestViewModel, navController: NavController) {
    val rests by viewModel.rests.collectAsState()


    LazyColumn(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp)) {
        items(rests) {
                rest ->
        Box(modifier = Modifier.fillMaxSize()){
            AsyncImage(
                model = rest.imgName,
                contentDescription = "No jala",   modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(16 / 9f)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
            val icon = if (rest.isFavorite) {
                Icons.Default.Favorite
            }else {
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
            Column(modifier = Modifier.padding(16.dp).clickable{
                navController.navigate("detail/$rest")}) {
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