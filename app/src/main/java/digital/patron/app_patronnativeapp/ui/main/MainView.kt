package digital.patron.app_patronnativeapp.ui.main

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import digital.patron.app_patronnativeapp.domain.main.entity.MainEntity

/*
* view 는 비즈니스 로직을 모르는 바보가 되어야 한다
* */
@SuppressLint("UnrememberedMutableState", "StateFlowValueCalledInComposition")
@ExperimentalMaterial3Api
@Composable
fun MainView(
    viewModel: MainViewModel
) {
    val context = LocalContext.current

    var text by remember {
        mutableStateOf("")
    }

    var mainRequest by remember {
        mutableStateOf(MainEntity("N00003"))
    }


    var a = viewModel.state2.value.code

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
        })
    )

    // 토스트 띄우는 완전한 함수형태
    Toast.makeText(context, a, Toast.LENGTH_SHORT).show()

}