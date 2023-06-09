package digital.patron.app_patronnativeapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.lifecycle.viewmodel.compose.viewModel
import digital.patron.app_patronnativeapp.domain.util.HomeAndroidViewModelFactory
import digital.patron.app_patronnativeapp.ui.main.MainView
import digital.patron.app_patronnativeapp.ui.main.HomeViewModel

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: HomeViewModel = viewModel(
                factory = HomeAndroidViewModelFactory(application),
            )
            MainView(viewModel = viewModel)
        }
    }
}
