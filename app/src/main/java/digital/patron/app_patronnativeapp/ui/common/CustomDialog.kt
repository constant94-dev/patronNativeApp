package digital.patron.app_patronnativeapp.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import java.util.Properties

@Composable
fun CustomAlertDialog(
    onDismissRequest: () -> Unit,
    properties: DialogProperties = DialogProperties(),
    content: @Composable () -> Unit,
) {
    Dialog(
        onDismissRequest = onDismissRequest,
        properties = properties,
    ) {
        content()
    }
}

@Composable
fun HomeContentsReady(
    visible: Boolean,
    onDismissRequest: () -> Unit,
) {
    if (visible) {
        CustomAlertDialog(onDismissRequest = { onDismissRequest() }) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .clip(RoundedCornerShape(12.dp))
                    .background(color = Color.White),
            ) {
                Text(
                    modifier = Modifier
                        .padding(top = 24.dp)
                        .padding(horizontal = 24.dp),
                    text = "준비중인 기능입니다.",
                    style = TextStyle(color = Color.Black),
                )
                Text(
                    modifier = Modifier
                        .align(Alignment.End)
                        .padding(16.dp)
                        .clickable {
                            onDismissRequest()
                        },
                    text = "OK",
                    style = TextStyle(color = Color.Black),
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeContentsReadyPreView() {
    CustomAlertDialog(onDismissRequest = {  }) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .clip(RoundedCornerShape(12.dp))
                .background(color = Color.White),
        ) {
            Text(
                modifier = Modifier
                    .padding(top = 24.dp)
                    .padding(horizontal = 24.dp),
                text = "준비중인 기능입니다.",
                style = TextStyle(color = Color.Black),
            )
            Text(
                modifier = Modifier
                    .padding(12.dp)
                    .align(Alignment.End)
                    .clickable {

                    },
                text = "OK",
                style = TextStyle(color = Color.Black),
            )
        }
    }
}