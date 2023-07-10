package digital.patron.app_patronnativeapp.ui.setting

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import digital.patron.app_patronnativeapp.R
import digital.patron.app_patronnativeapp.ui.common.HomeContentsReady
import digital.patron.app_patronnativeapp.ui.theme.BoxText
import digital.patron.app_patronnativeapp.ui.theme.HomeButton
import digital.patron.app_patronnativeapp.ui.theme.SubTitle
import digital.patron.app_patronnativeapp.ui.theme.Title

@ExperimentalMaterial3Api
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SettingView(
    navController: NavController,
) {
    val vtScrollState = rememberScrollState()

    val showDialog = remember { mutableStateOf(false) }
    if (showDialog.value) {
        HomeContentsReady(
            visible = showDialog.value,
            onDismissRequest = { showDialog.value = false })
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
                            onClick = {},
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
                                //navController.navigate("search")
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
                .verticalScroll(vtScrollState)
                .fillMaxSize(),
        ) {
            Spacer(modifier = Modifier.height(80.dp))

            Text(
                text = "설정",
                color = Title,
                fontWeight = FontWeight(700),
                fontSize = 20.sp,
            )

            Text(
                text = "계정 정보 수정 및 기타 설정은 웹 사이트에서 변경할 수 있습니다." +
                        " 아래의 버튼을 눌러 웹 사이트로 이동해주세요.",
                modifier = Modifier
                    .padding(top = 16.dp, bottom = 16.dp),
                color = Title,
                fontWeight = FontWeight(700),
                fontSize = 14.sp,
            )

            Button(
                onClick = {},
                modifier = Modifier
                    .padding(bottom = 40.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(HomeButton),
            ) {
                Text(
                    text = "웹 사이트 방문",
                    modifier = Modifier
                        .padding(top = 8.dp, bottom = 8.dp),
                    color = Title,
                    fontWeight = FontWeight(500),
                    fontSize = 16.sp,
                )
            }

            Text(
                text = "계정",
                modifier = Modifier
                    .padding(bottom = 20.dp),
                color = SubTitle,
                fontWeight = FontWeight(500),
                fontSize = 12.sp,
            )

            Text(
                text = "언어 설정",
                modifier = Modifier
                    .padding(bottom = 20.dp)
                    .clickable {
                               navController.navigate("setting-language")
                    },
                color = Title,
                fontWeight = FontWeight(500),
                fontSize = 16.sp,
            )

            Text(
                text = "로그아웃",
                modifier = Modifier
                    .padding(bottom = 20.dp),
                color = Title,
                fontWeight = FontWeight(500),
                fontSize = 16.sp,
            )

            Divider(
                color = SubTitle,
                thickness = 1.dp
            )

            Text(
                text = "멤버쉽",
                modifier = Modifier
                    .padding(top = 8.dp, bottom = 16.dp),
                color = Title,
                fontWeight = FontWeight(500),
                fontSize = 14.sp,
            )

            if (false){ // 사용자가 멤버십이 있을 때 or 없을 때 조건을 변수로 사용 해야함
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            color = BoxText,
                            shape = RoundedCornerShape(8.dp)
                        )
                ) {
                    Column(
                        modifier = Modifier
                            .align(Alignment.CenterStart)
                            .padding(16.dp),
                    ) {
                        Text(
                            text = "&멤버십 이름",
                            modifier = Modifier
                                .padding(bottom = 16.dp),
                            color = Title,
                            fontWeight = FontWeight(500),
                            fontSize = 16.sp,
                        )

                        Text(
                            text = "￦ 8,000 / 월\n다음 결제일은 2023년 1월 26일 입니다.",
                            color = SubTitle,
                            fontWeight = FontWeight(500),
                            fontSize = 14.sp,
                        )
                    }
                    Button(
                        onClick = {},
                        modifier = Modifier
                            .align(Alignment.CenterEnd)
                            .padding(8.dp),
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(Color.Gray),
                    ) {
                        Text(
                            text = "변경",
                            color = Color.White,
                            fontWeight = FontWeight(500),
                            fontSize = 14.sp,
                        )
                    }
                }
            } else {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            color = BoxText,
                            shape = RoundedCornerShape(8.dp)
                        )
                ) {
                    Column(
                        modifier = Modifier
                            .align(Alignment.CenterStart)
                            .padding(16.dp),
                    ) {
                        Text(
                            text = "나의 멤버쉽",
                            modifier = Modifier
                                .padding(bottom = 16.dp),
                            color = Title,
                            fontWeight = FontWeight(500),
                            fontSize = 16.sp,
                        )

                        Text(
                            text = "이용중인 멤버십이 없습니다.",
                            color = SubTitle,
                            fontWeight = FontWeight(500),
                            fontSize = 14.sp,
                        )
                    }
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = "결제 내역",
                    modifier = Modifier
                        .align(CenterVertically),
                    color = Title,
                    fontWeight = FontWeight(500),
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                )

                IconButton(
                    onClick = {
                        navController.navigate("setting-payDetails")
                    },
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.icon_arrow),
                        contentDescription = "Patron search.",
                        colorFilter = ColorFilter.tint(Color.White),
                    )
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = "결제 수단 관리",
                    modifier = Modifier
                        .align(CenterVertically),
                    color = Title,
                    fontWeight = FontWeight(500),
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                )

                IconButton(
                    onClick = {
                        //navController.navigate("search")
                    },
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.icon_arrow),
                        contentDescription = "Patron search.",
                        colorFilter = ColorFilter.tint(Color.White),
                    )
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = "멤버십 해지",
                    modifier = Modifier
                        .align(CenterVertically),
                    color = Title,
                    fontWeight = FontWeight(500),
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                )

                IconButton(
                    onClick = {
                        navController.navigate("setting-membershipCancel")
                    },
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.icon_arrow),
                        contentDescription = "Patron search.",
                        colorFilter = ColorFilter.tint(Color.White),
                    )
                }
            }

            Text(
                text = "약관 및 정책",
                modifier = Modifier
                    .padding(top = 16.dp, bottom = 20.dp),
                color = SubTitle,
                fontWeight = FontWeight(500),
                fontSize = 12.sp,
            )

            Text(
                text = "서비스 이용약관",
                modifier = Modifier
                    .padding(bottom = 20.dp),
                color = Title,
                fontWeight = FontWeight(500),
                fontSize = 16.sp,
            )

            Text(
                text = "개인정보 처리 방침",
                modifier = Modifier
                    .padding(bottom = 20.dp),
                color = Title,
                fontWeight = FontWeight(500),
                fontSize = 16.sp,
            )

            Text(
                text = "계정 운영정책",
                modifier = Modifier
                    .padding(bottom = 20.dp),
                color = Title,
                fontWeight = FontWeight(500),
                fontSize = 16.sp,
            )

            Divider(
                color = SubTitle,
                thickness = 1.dp,
            )

            Text(
                text = "문의",
                modifier = Modifier
                    .padding(top = 16.dp, bottom = 16.dp),
                color = SubTitle,
                fontWeight = FontWeight(500),
                fontSize = 12.sp,
            )

            Text(
                text = "help@patron.digital",
                modifier = Modifier
                    .padding(bottom = 16.dp),
                color = Title,
                fontWeight = FontWeight(500),
                fontSize = 16.sp,
                textDecoration = TextDecoration.Underline,
            )

            Spacer(modifier = Modifier.height(100.dp))

        }
    }
}

@ExperimentalMaterial3Api
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview(showBackground = true)
@Composable
fun SettingPreView(

) {
    val vtScrollState = rememberScrollState()

    val showDialog = remember { mutableStateOf(false) }
    if (showDialog.value) {
        HomeContentsReady(
            visible = showDialog.value,
            onDismissRequest = { showDialog.value = false })
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
                            onClick = {},
                            modifier = Modifier.weight(1f),
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.icon_logo_symbol),
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
                                //navController.navigate("search")
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
                .padding(start = 8.dp, end = 8.dp)
                .verticalScroll(vtScrollState)
                .fillMaxSize(),
        ) {
            Spacer(modifier = Modifier.height(80.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = "결제 내역",
                    modifier = Modifier
                        .align(CenterVertically),
                    color = Title,
                    fontWeight = FontWeight(500),
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                )

                IconButton(
                    onClick = {
                        //navController.navigate("search")
                    },
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.icon_arrow),
                        contentDescription = "Patron search.",
                        colorFilter = ColorFilter.tint(Color.White),
                    )
                }
            }

        }
    }
}