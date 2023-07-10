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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import digital.patron.app_patronnativeapp.R
import digital.patron.app_patronnativeapp.ui.common.HomeContentsReady
import digital.patron.app_patronnativeapp.ui.theme.SubTitle
import digital.patron.app_patronnativeapp.ui.theme.Title

@ExperimentalMaterial3Api
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SettingPayDetailView(
    navController: NavController,
) {
    val vtScrollState = rememberScrollState()

    // 결제 내역 UI 데이터
    val itemsPayDate =
        listOf("2023년 12월 27일", "2023년 11월 27일", "2023년 10월 27일", "2023년 9월 27일", "2023년 8월 27일")
    val itemsPayMembership = listOf("아티스트 멤버쉽", "아티스트 멤버쉽", "아티스트 멤버쉽", "아티스트 멤버쉽", "아티스트 멤버쉽")
    val itemsPayMembershipDuration = listOf(
        "2023년 12월 27일 ~ 2024년 1월 26일",
        "2023년 11월 27일 ~ 2023년 12월 26일",
        "2023년 10월 27일 ~ 2023년 11월 26일",
        "2023년 9월 27일 ~ 2023년 10월 26일",
        "2023년 8월 27일 ~ 2023년 9월 26일",
    )
    val itemsPayCardNumber = listOf("9094", "9094", "9094", "9094", "9094")
    val itemsPayCost = listOf("5,000", "5,000", "5,000", "5,000", "5,000")
    val itemsPayTotalCost = listOf("￦5,500", "￦5,500", "￦5,500", "￦5,500", "￦5,500")

    val showDialog = remember { mutableStateOf(false) }
    if (showDialog.value) {
        HomeContentsReady(
            visible = showDialog.value,
            onDismissRequest = { showDialog.value = false }
        )
    }

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
                text = "결제 내역",
                color = Title,
                fontWeight = FontWeight(700),
                fontSize = 32.sp,
            )

            Text(
                text = "멤버십 요금은 결제 주기 시작일에 청구되며, 계정에 청구일이 표시될 때까지 수일이 걸릴 수 있습니다.",
                modifier = Modifier
                    .padding(top = 8.dp, bottom = 16.dp),
                color = SubTitle,
                fontWeight = FontWeight(300),
                fontSize = 18.sp,
            )

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                val itemSize = itemsPayDate.size
                items(itemSize) {
                    Divider(
                        modifier = Modifier
                            .padding(top = 16.dp, bottom = 16.dp),
                        color = SubTitle,
                        thickness = 1.dp,
                    )

                    Column {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                        ) {
                            Text(
                                text = itemsPayDate[it],
                                color = Title,
                                fontWeight = FontWeight(500),
                                fontSize = 20.sp,
                            )

                            Text(
                                text = itemsPayTotalCost[it],
                                color = Title,
                                fontWeight = FontWeight(500),
                                fontSize = 20.sp,
                            )
                        }


                        Text(
                            text = itemsPayMembership[it],
                            color = SubTitle,
                            fontWeight = FontWeight(300),
                            fontSize = 18.sp,
                        )

                        Text(
                            text = itemsPayMembershipDuration[it],
                            color = SubTitle,
                            fontWeight = FontWeight(300),
                            fontSize = 18.sp,
                        )

                        Text(
                            text = "**** **** **** ${itemsPayCardNumber[it]}",
                            color = SubTitle,
                            fontWeight = FontWeight(300),
                            fontSize = 18.sp,
                        )

                        Text(
                            text = "${itemsPayCost[it]} (+500원 부가세)",
                            color = SubTitle,
                            fontWeight = FontWeight(300),
                            fontSize = 18.sp,
                        )
                    }
                }
            }
        }
    }
}