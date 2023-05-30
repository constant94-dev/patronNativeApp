package digital.patron.app_patronnativeapp.ui.main

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import digital.patron.app_patronnativeapp.data.main.remote.dto.MainRequest
import digital.patron.app_patronnativeapp.domain.main.entity.MainEntity


@SuppressLint("UnrememberedMutableState")
@ExperimentalMaterial3Api
@Composable
fun MainView(
    viewModel: MainViewModel
) {
    var text by remember {
        mutableStateOf("")
    }

    var mainRequest by remember {
        mutableStateOf(MainEntity("N00003"))
    }

    var testResult: MainEntity


    OutlinedTextField(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        value = text,
        onValueChange = {
            text = it
        },
        label = { Text(text = "Label") },
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(onDone = {
            viewModel.test(mainRequest)
            text = ""
        })
    )

}
