package digital.patron.app_patronnativeapp.ui.main

import android.app.Application
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import digital.patron.app_patronnativeapp.domain.remote.model.User
import digital.patron.app_patronnativeapp.domain.remote.repository.ArtworkRepository
import digital.patron.app_patronnativeapp.domain.remote.repository.UserRepository

class MainViewModel(
    application: Application,
    private val userRepository: UserRepository,
    private val artworkRepository: ArtworkRepository,
) : AndroidViewModel(application) {
    private val _items = mutableStateOf(emptyList<User>())
    val items: State<List<User>> = _items
}