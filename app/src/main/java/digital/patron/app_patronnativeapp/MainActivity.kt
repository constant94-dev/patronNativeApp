package digital.patron.app_patronnativeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import digital.patron.app_patronnativeapp.domain.util.HomeAndroidViewModelFactory
import digital.patron.app_patronnativeapp.ui.main.HomeView
import digital.patron.app_patronnativeapp.ui.main.HomeViewModel
import digital.patron.app_patronnativeapp.ui.player.PlayerView
import digital.patron.app_patronnativeapp.ui.search.SearchView

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    companion object {
        const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: HomeViewModel = viewModel(
                factory = HomeAndroidViewModelFactory(application),
            )

            var navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = "home"
            ) {
                composable("home") {
                    HomeView(viewModel, navController)
                }
                composable("search") {
                    SearchView(navController)
                }
                composable("player") {
                    PlayerView(navController)
                }
            }

        }
    }

}