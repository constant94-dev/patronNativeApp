package digital.patron.app_patronnativeapp.ui.main

import android.annotation.SuppressLint
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import digital.patron.app_patronnativeapp.domain.main.entity.MainEntity
import kotlinx.coroutines.flow.observeOn
import kotlinx.coroutines.launch

/*
* view 는 비즈니스 로직을 모르는 바보가 되어야 한다
* */
@SuppressLint("UnrememberedMutableState", "StateFlowValueCalledInComposition")
@ExperimentalMaterial3Api
@Composable
fun MainView(
    viewModel: MainViewModel
) {
    var text by remember {
        mutableStateOf("")
    }



    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        Divider(color = Color.Black, thickness = 1.dp)
        Spacer(modifier = Modifier.height(60.dp))
        Divider(color = Color.Black, thickness = 1.dp)
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
                    viewModel.test(MainEntity(text))
                    text = ""

                Log.d("MainView1: ", viewModel.state2.value.toString())
                Log.d("MainView2: ", viewModel.state2.value.code)
            })
        )
    }


}