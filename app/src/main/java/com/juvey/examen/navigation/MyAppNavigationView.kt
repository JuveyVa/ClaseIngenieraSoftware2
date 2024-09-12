package com.juvey.examen.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.juvey.examen.act1.SumView
import com.juvey.examen.act1.SumViewModel
import com.juvey.examen.act2.SoccerScoreViewModel
import com.juvey.examen.act2.SoccerView
import com.juvey.examen.act3.GameView
import com.juvey.examen.act3.GameViewModel
import com.juvey.examen.act4.ImcView
import com.juvey.examen.act4.ImcViewModel
import com.juvey.examen.animation.LottieAnimationView
import com.juvey.examen.appleapp.AppleAppView
import com.juvey.examen.appleapp.AppleAppViewModel
import com.juvey.examen.examen3er.ExamenView
import com.juvey.examen.examen3er.ExamenViewModel
import com.juvey.examen.game.TimeFireView
import com.juvey.examen.game.TimeFireViewModel
import com.juvey.examen.randomcards.CardView
import com.juvey.examen.randomcards.CardViewModel
import com.juvey.examen.screens.gyms.viewmodel.GymViewModel
import com.juvey.examen.screens.gyms.views.GymView
import com.juvey.examen.screensexam.viewmodel.RestViewModel
import com.juvey.examen.screensexam.views.RestView
import com.juvey.examen.spotify.SpotifyView

@Composable
fun MyAppNavigationView() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.firstPartialView, builder =  {

        composable(Routes.firstPartialView) {
            FirstPartialView(navController)
        }
        composable(Routes.secondPartialView) {
            SecondPartialView(navController)
        }
        composable(Routes.thirdPartialView) {
            ThirdPartialView(navController)
        }
        composable(Routes.TimeFireView) {
            TimeFireView(viewModel = TimeFireViewModel(), navController)
        }
        composable(Routes.SumView) {
            SumView(viewModel = SumViewModel(), navController)
        }
        composable(Routes.SoccerView) {
            SoccerView(viewModel = SoccerScoreViewModel(), navController)
        }
        composable(Routes.GameView) {
            GameView(viewModel = GameViewModel(), navController)
        }
        composable(Routes.ImcView) {
            ImcView(viewModel = ImcViewModel(), navController)
        }
        composable(Routes.ExamenView) {
            ExamenView(viewModel = ExamenViewModel(), navController)
        }
        composable(Routes.GymView) {
            GymView(viewModel = GymViewModel(), navController)
        }
        composable(Routes.RestView) {
            RestView(viewModel = RestViewModel(), navController)
        }
        composable(Routes.LottieAnimationView) {
            LottieAnimationView(navController)
        }
        composable(Routes.spotifyview) {
            SpotifyView(navController)
        }
        composable(Routes.appleview) {
            AppleAppView(viewModel = AppleAppViewModel(), navController)
        }
        composable(Routes.cardview) {
            CardView(viewModel = CardViewModel(), navController)
        }
    })
}

