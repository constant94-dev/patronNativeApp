package digital.patron.app_patronnativeapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import digital.patron.app_patronnativeapp.domain.util.HomeAndroidViewModelFactory
import digital.patron.app_patronnativeapp.domain.util.SettingAndroidViewModelFactory
import digital.patron.app_patronnativeapp.ui.main.HomeView
import digital.patron.app_patronnativeapp.ui.main.HomeViewModel
import digital.patron.app_patronnativeapp.ui.player.PlayerView
import digital.patron.app_patronnativeapp.ui.search.SearchView
import digital.patron.app_patronnativeapp.ui.setting.SettingLanguageView
import digital.patron.app_patronnativeapp.ui.setting.SettingMembershipCancel
import digital.patron.app_patronnativeapp.ui.setting.SettingPayDetailView
import digital.patron.app_patronnativeapp.ui.setting.SettingView
import digital.patron.app_patronnativeapp.ui.setting.SettingViewModel
import digital.patron.app_patronnativeapp.ui.theme.SplashScreenAPITheme
import kotlinx.coroutines.launch

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    companion object {
        const val TAG = "MainActivity"
    }

    private val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Splash Screen Delay 실행
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                mainViewModel.loading.value
            }
        }

        setContent {
            val homeViewModel: HomeViewModel = viewModel(
                factory = HomeAndroidViewModelFactory(application),
            )

            val settingViewModel: SettingViewModel = viewModel(
                factory = SettingAndroidViewModelFactory(application),
            )

            var navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = "setting"
            ) {
                composable("home") {
                    HomeView(homeViewModel, navController)
                }
                composable("search") {
                    SearchView(navController)
                }
                composable("player") {
                    PlayerView(navController)
                }
                composable("setting") {
                    SettingView(settingViewModel, navController)
                }
                composable("setting-language") {
                    SettingLanguageView(navController)
                }
                composable("setting-payDetails") {
                    SettingPayDetailView(navController)
                }
                composable("setting-membershipCancel") {
                    SettingMembershipCancel(navController)
                }
            }



        }
    }

}