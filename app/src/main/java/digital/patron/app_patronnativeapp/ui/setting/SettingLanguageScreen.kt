package digital.patron.app_patronnativeapp.ui.setting

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import digital.patron.app_patronnativeapp.R
import digital.patron.app_patronnativeapp.ui.common.HomeContentsReady
import digital.patron.app_patronnativeapp.ui.theme.HomeButton
import digital.patron.app_patronnativeapp.ui.theme.Title

@ExperimentalMaterial3Api
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SettingLanguageView(
    navController: NavController,
) {
    val showDialog = remember { mutableStateOf(false) }
    if (showDialog.value) {
        HomeContentsReady(
            visible = showDialog.value,
            onDismissRequest = { showDialog.value = false })
    }

    val languageSelector = listOf("한국어", "English", "日本語")

    val selectedValue = remember { mutableStateOf("") }
    val isSelectedItem: (String) -> Boolean = { selectedValue.value == it }
    val onChangeState: (String) -> Unit = { selectedValue.value = it }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "") },
                navigationIcon = {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 14.dp, start = 20.dp, end = 20.dp),
                        horizontalArrangement = Arrangement.Start,
                    ) {
                        IconButton(
                            onClick = {
                                navController.navigate("setting")
                            },
                            modifier = Modifier.weight(1f),
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.icon_go_back),
                                contentDescription = "Patron logo.",
                                colorFilter = ColorFilter.tint(Color.White),
                            )
                        }

                        Spacer(modifier = Modifier.weight(6f)) // 60% width as the parent

                        IconButton(
                            onClick = {
                                showDialog.value = true
                            },
                            modifier = Modifier.weight(1f),
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.icon_library),
                                contentDescription = "Patron dump profile.",
                            )
                        }

                        Spacer(modifier = Modifier.weight(0.5f))

                        IconButton(
                            onClick = {
                                navController.navigate("search")
                            },
                            modifier = Modifier.weight(1f),
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.icon_search),
                                contentDescription = "Patron search.",
                                colorFilter = ColorFilter.tint(Color.White),
                            )
                        }

                        Spacer(modifier = Modifier.weight(0.5f))

                        IconButton(
                            onClick = {
                                showDialog.value = true
                            },
                            modifier = Modifier.weight(1f),
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.icon_menu),
                                contentDescription = "Patron menu.",
                                colorFilter = ColorFilter.tint(Color.White),
                            )
                        }

                    } // Row end
                }, // navigation end
                colors = TopAppBarDefaults.largeTopAppBarColors(containerColor = Color(R.color.background)),
            )
        }, // topBar end
        containerColor = Color(R.color.background),
    ) {

        Column(
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp)
                .fillMaxSize(),
        ) {
            Spacer(modifier = Modifier.height(80.dp))

            Text(
                text = "언어 설정",
                color = Title,
                fontWeight = FontWeight(700),
                fontSize = 32.sp,
            )

            Text(
                text = "앱 언어를 변경할 수 있습니다.",
                modifier = Modifier
                    .padding(top = 8.dp, bottom = 16.dp),
                color = Title,
                fontWeight = FontWeight(500),
                fontSize = 16.sp,
            )

            languageSelector.forEach { item ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .selectable(
                            selected = isSelectedItem(item),
                            onClick = { onChangeState(item) },
                            role = Role.RadioButton,
                        )
                        .padding(bottom = 16.dp),
                ) {
                    RadioButton(
                        selected = isSelectedItem(item),
                        onClick = null
                    )
                    Text(
                        text = item,
                        modifier = Modifier.fillMaxWidth()
                            .padding(start = 8.dp),
                        color = Title,
                        fontWeight = FontWeight(700),
                        fontSize = 20.sp,
                    )
                }
            }

            Button(
                onClick = {},
                modifier = Modifier
                    .padding(top = 16.dp, bottom = 40.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(HomeButton),
            ) {
                Text(
                    text = "저장",
                    modifier = Modifier
                        .padding(top = 8.dp, bottom = 8.dp),
                    color = Title,
                    fontWeight = FontWeight(700),
                    fontSize = 20.sp,
                )
            }

        }
    }
}