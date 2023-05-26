package digital.patron.app_patronnativeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import digital.patron.app_patronnativeapp.data.main.remote.dto.MainRequest
import digital.patron.app_patronnativeapp.domain.main.usecase.MainUseCase
import digital.patron.app_patronnativeapp.domain.util.MainAndroidViewModelFactory
import digital.patron.app_patronnativeapp.ui.main.MainViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        setContent {

            val viewModel: MainViewModel = viewModel(
                factory = MainAndroidViewModelFactory(application),
            )
        }
    }
}