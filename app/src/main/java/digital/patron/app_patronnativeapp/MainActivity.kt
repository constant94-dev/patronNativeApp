package digital.patron.app_patronnativeapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.lifecycle.viewmodel.compose.viewModel
import digital.patron.app_patronnativeapp.domain.util.MainAndroidViewModelFactory
import digital.patron.app_patronnativeapp.ui.main.MainView
import digital.patron.app_patronnativeapp.ui.main.MainViewModel
import kotlinx.coroutines.launch

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    lateinit var viewModel: MainViewModel
    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        setContent {
            viewModel = viewModel(
                factory = MainAndroidViewModelFactory(application),
            )
            MainView(viewModel = viewModel)

        }

    }
}


// JetNews 보며 아키텍처 전체흐름 파악