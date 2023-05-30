package digital.patron.app_patronnativeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import digital.patron.app_patronnativeapp.data.main.remote.dto.MainRequest
import digital.patron.app_patronnativeapp.data.main.repository.MainRepositoryImpl
import digital.patron.app_patronnativeapp.domain.main.MainRepository
import digital.patron.app_patronnativeapp.domain.main.usecase.MainUseCase
import digital.patron.app_patronnativeapp.domain.util.MainAndroidViewModelFactory
import digital.patron.app_patronnativeapp.ui.main.MainView
import digital.patron.app_patronnativeapp.ui.main.MainViewModel

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            var mainRepository: MainRepository = MainRepositoryImpl(application)
            var mainUseCase = MainUseCase(application, mainRepository)

            val viewModel: MainViewModel = viewModel(
                factory = MainAndroidViewModelFactory(application, mainUseCase),
            )

            MainView(viewModel = viewModel)
        }
    }
}