package digital.patron.app_patronnativeapp.ui.main

import android.annotation.SuppressLint
import android.content.res.Resources
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import digital.patron.app_patronnativeapp.R
import digital.patron.app_patronnativeapp.ui.theme.Title

/* 파트론 메인 UI 요약
* - 비회원 UI
* 0. 메뉴 바 (최상단 고정)
* 1. 추천 큐레이션
* 2. 새로운 아트워크
* 3. 커피 한 잔 생각날 때
* 4. Jazz Today
* 5. 공개예정 큐레이션
* 6. 봄의 아침을 맞이하며
* 7. 집중의 시간
* 8. 내적 Groove 좀 타볼까요
* 9. 모든 아트워크
* 10. 추천 아티스트
* 11. 모든 아티스트
* 12. 풋터
* - 회원 UI
* 1. 메뉴 바 (최상단 고정)
* 2. 추천 큐레이션
* 3. 최근 본 아트워크
* 4. 좋아한 아트워크
* 5. 새로운 아트워크
* 6. 커피 한 잔 생각날 때
* 7. Jazz Today
* 8. 공개예정 큐레이션
* 9. 봄의 아침을 맞이하며
* 10. 집중의 시간
* 11. 내적 Groove 좀 타볼까요
* 12. 모든 아트워크
* 13. 추천 아티스트
* 14. 모든 아티스트
* 15. 풋터
* */
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@ExperimentalMaterial3Api
@Composable
fun MainView(
    viewModel: MainViewModel
) {
    val hzScrollState = rememberScrollState()
    val vtScrollState = rememberScrollState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "") },
                navigationIcon = {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(1f)
                            .padding(top = 4.dp),
                        horizontalArrangement = Arrangement.Start,
                    ) {
                        IconButton(
                            onClick = {},
                            modifier = Modifier.fillMaxWidth(0.1f)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.icon_logo),
                                contentDescription = "Patron logo.",
                                colorFilter = ColorFilter.tint(Color.White),
                            )

                        }

                        Spacer(modifier = Modifier.fillMaxWidth(0.8f)) // 80% width as the parent

                        IconButton(
                            onClick = {},
                            modifier = Modifier.fillMaxWidth(0.5f),
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.icon_search),
                                contentDescription = "Patron search.",
                                colorFilter = ColorFilter.tint(Color.White),
                            )
                        }
                        IconButton(
                            onClick = {},
                            modifier = Modifier.fillMaxWidth(0.5f),
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
        containerColor = Color(R.color.background)
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(vtScrollState)
                .fillMaxSize(),
        ) {
            Spacer(modifier = Modifier.height(60.dp))
            Column {
                Divider(
                    color = Color.Black,
                    thickness = 8.dp,
                ) // 'Scaffold' 레이아웃과 구분하기 위한 선

                Column(
                    modifier = Modifier
                        .padding(bottom = 40.dp, start = 20.dp, end = 20.dp)
                        .fillMaxWidth(),
                ) {
                    Text(
                        text = "추천 큐레이션",
                        color = Title,
                    )
                    Row(
                        modifier = Modifier
                            .horizontalScroll(hzScrollState)
                    ) {
                        for (index in 1..15) {
                            Image(
                                painter = painterResource(id = R.drawable.img_empty),
                                contentDescription = "",
                                modifier = Modifier
                                    .padding(top = 8.dp, bottom = 4.dp, end = 12.dp),
                            )
                        }
                    }
                } // 자식 레이아웃 추천 큐레이션 끝

                Column(
                    modifier = Modifier
                        .padding(bottom = 40.dp, start = 20.dp, end = 20.dp)
                        .fillMaxWidth(),
                ) {
                    Text(
                        text = "새로운 아트워크",
                        color = Title,
                    )
                    Row(
                        modifier = Modifier
                            .horizontalScroll(hzScrollState)
                    ) {
                        for (index in 1..15) {
                            Image(
                                painter = painterResource(id = R.drawable.img_empty),
                                contentDescription = "",
                                modifier = Modifier
                                    .padding(top = 8.dp, bottom = 4.dp, end = 12.dp),
                            )
                        }
                    }
                } // 자식 레이아웃 새로운 아트워크 끝

                Column(
                    modifier = Modifier
                        .padding(bottom = 40.dp, start = 20.dp, end = 20.dp)
                        .fillMaxWidth(),
                ) {
                    Text(
                        text = "커피 한 잔 생각날 때",
                        color = Title,
                    )
                    Row(
                        modifier = Modifier
                            .horizontalScroll(hzScrollState)
                    ) {
                        for (index in 1..15) {
                            Image(
                                painter = painterResource(id = R.drawable.img_empty),
                                contentDescription = "",
                                modifier = Modifier
                                    .padding(top = 8.dp, bottom = 4.dp, end = 12.dp),
                            )
                        }
                    }
                } // 자식 레이아웃 커피.. 끝

                Column(
                    modifier = Modifier
                        .padding(bottom = 40.dp, start = 20.dp, end = 20.dp)
                        .fillMaxWidth(),
                ) {
                    Text(
                        text = "Jazz Today",
                        color = Title,
                    )
                    Row(
                        modifier = Modifier
                            .horizontalScroll(hzScrollState)
                    ) {
                        for (index in 1..15) {
                            Image(
                                painter = painterResource(id = R.drawable.img_empty),
                                contentDescription = "",
                                modifier = Modifier
                                    .padding(top = 8.dp, bottom = 4.dp, end = 12.dp),
                            )
                        }
                    }
                } // 자식 레이아웃 Jazz Today 끝

                Column(
                    modifier = Modifier
                        .padding(bottom = 40.dp, start = 20.dp, end = 20.dp)
                        .fillMaxWidth(),
                ) {
                    Text(
                        text = "공개예정 큐레이션",
                        color = Title,
                    )
                    Row(
                        modifier = Modifier
                            .horizontalScroll(hzScrollState)
                    ) {
                        for (index in 1..15) {
                            Image(
                                painter = painterResource(id = R.drawable.img_empty),
                                contentDescription = "",
                                modifier = Modifier
                                    .padding(top = 8.dp, bottom = 4.dp, end = 12.dp),
                            )
                        }
                    }
                } // 자식 레이아웃 공개예정 큐레이션 끝

                Column(
                    modifier = Modifier
                        .padding(bottom = 40.dp, start = 20.dp, end = 20.dp)
                        .fillMaxWidth(),
                ) {
                    Text(
                        text = "봄의 아침을 맞이하며",
                        color = Title,
                    )
                    Row(
                        modifier = Modifier
                            .horizontalScroll(hzScrollState)
                    ) {
                        for (index in 1..15) {
                            Image(
                                painter = painterResource(id = R.drawable.img_empty),
                                contentDescription = "",
                                modifier = Modifier
                                    .padding(top = 8.dp, bottom = 4.dp, end = 12.dp),
                            )
                        }
                    }
                } // 자식 레이아웃 봄의 .. 끝

                Column(
                    modifier = Modifier
                        .padding(bottom = 40.dp, start = 20.dp, end = 20.dp)
                        .fillMaxWidth(),
                ) {
                    Text(
                        text = "집중의 시간",
                        color = Title,
                    )
                    Row(
                        modifier = Modifier
                            .horizontalScroll(hzScrollState)
                    ) {
                        for (index in 1..15) {
                            Image(
                                painter = painterResource(id = R.drawable.img_empty),
                                contentDescription = "",
                                modifier = Modifier
                                    .padding(top = 8.dp, bottom = 4.dp, end = 12.dp),
                            )
                        }
                    }
                } // 자식 레이아웃 집중의 시간 끝

                Column(
                    modifier = Modifier
                        .padding(bottom = 40.dp, start = 20.dp, end = 20.dp)
                        .fillMaxWidth(),
                ) {
                    Text(
                        text = "내적 Groove 좀 타볼까요",
                        color = Title,
                    )
                    Row(
                        modifier = Modifier
                            .horizontalScroll(hzScrollState)
                    ) {
                        for (index in 1..15) {
                            Image(
                                painter = painterResource(id = R.drawable.img_empty),
                                contentDescription = "",
                                modifier = Modifier
                                    .padding(top = 8.dp, bottom = 4.dp, end = 12.dp),
                            )
                        }
                    }
                } // 자식 레이아웃 내적 .. 끝

                Button(
                    onClick = {},
                    modifier = Modifier
                        .padding(bottom = 40.dp, start = 20.dp, end = 20.dp)
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        text = "모든 아트워크",
                        color = Title,
                    )
                } // 자식 레이아웃 모든 아트워크 끝

            } // 메인페이지 본문 부모 레이아웃 끝
        }
    }
} // MainView function end

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun MainView() {
    val hzScrollState = rememberScrollState()
    val vtScrollState = rememberScrollState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "") },
                navigationIcon = {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(1f)
                            .padding(top = 4.dp),
                        horizontalArrangement = Arrangement.Start,
                    ) {
                        IconButton(
                            onClick = {},
                            modifier = Modifier.fillMaxWidth(0.1f)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.icon_logo),
                                contentDescription = "Patron logo.",
                                colorFilter = ColorFilter.tint(Color.White),
                            )

                        }

                        Spacer(modifier = Modifier.fillMaxWidth(0.8f)) // 80% width as the parent

                        IconButton(
                            onClick = {},
                            modifier = Modifier.fillMaxWidth(0.5f),
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.icon_search),
                                contentDescription = "Patron search.",
                                colorFilter = ColorFilter.tint(Color.White),
                            )
                        }
                        IconButton(
                            onClick = {},
                            modifier = Modifier.fillMaxWidth(0.5f),
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
        containerColor = Color(R.color.background)
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(vtScrollState)
                .fillMaxSize(),
        ) {
            Spacer(modifier = Modifier.height(60.dp))
            Column {
                Divider(
                    color = Color.Black,
                    thickness = 8.dp,
                ) // 'Scaffold' 레이아웃과 구분하기 위한 선

                Column(
                    modifier = Modifier
                        .padding(bottom = 40.dp, start = 20.dp, end = 20.dp)
                        .fillMaxWidth(),
                ) {
                    Text(
                        text = "추천 큐레이션",
                        color = Title,
                    )
                    Row(
                        modifier = Modifier
                            .horizontalScroll(hzScrollState)
                    ) {
                        for (index in 1..15) {
                            Image(
                                painter = painterResource(id = R.drawable.img_empty),
                                contentDescription = "",
                                modifier = Modifier
                                    .padding(top = 8.dp, bottom = 4.dp, end = 12.dp),
                            )
                        }
                    }
                } // 자식 레이아웃 추천 큐레이션 끝

                Column(
                    modifier = Modifier
                        .padding(bottom = 40.dp, start = 20.dp, end = 20.dp)
                        .fillMaxWidth(),
                ) {
                    Text(
                        text = "새로운 아트워크",
                        color = Title,
                    )
                    Row(
                        modifier = Modifier
                            .horizontalScroll(hzScrollState)
                    ) {
                        for (index in 1..15) {
                            Image(
                                painter = painterResource(id = R.drawable.img_empty),
                                contentDescription = "",
                                modifier = Modifier
                                    .padding(top = 8.dp, bottom = 4.dp, end = 12.dp),
                            )
                        }
                    }
                } // 자식 레이아웃 새로운 아트워크 끝

                Column(
                    modifier = Modifier
                        .padding(bottom = 40.dp, start = 20.dp, end = 20.dp)
                        .fillMaxWidth(),
                ) {
                    Text(
                        text = "커피 한 잔 생각날 때",
                        color = Title,
                    )
                    Row(
                        modifier = Modifier
                            .horizontalScroll(hzScrollState)
                    ) {
                        for (index in 1..15) {
                            Image(
                                painter = painterResource(id = R.drawable.img_empty),
                                contentDescription = "",
                                modifier = Modifier
                                    .padding(top = 8.dp, bottom = 4.dp, end = 12.dp),
                            )
                        }
                    }
                } // 자식 레이아웃 커피.. 끝

                Column(
                    modifier = Modifier
                        .padding(bottom = 40.dp, start = 20.dp, end = 20.dp)
                        .fillMaxWidth(),
                ) {
                    Text(
                        text = "Jazz Today",
                        color = Title,
                    )
                    Row(
                        modifier = Modifier
                            .horizontalScroll(hzScrollState)
                    ) {
                        for (index in 1..15) {
                            Image(
                                painter = painterResource(id = R.drawable.img_empty),
                                contentDescription = "",
                                modifier = Modifier
                                    .padding(top = 8.dp, bottom = 4.dp, end = 12.dp),
                            )
                        }
                    }
                } // 자식 레이아웃 Jazz Today 끝

                Column(
                    modifier = Modifier
                        .padding(bottom = 40.dp, start = 20.dp, end = 20.dp)
                        .fillMaxWidth(),
                ) {
                    Text(
                        text = "공개예정 큐레이션",
                        color = Title,
                    )
                    Row(
                        modifier = Modifier
                            .horizontalScroll(hzScrollState)
                    ) {
                        for (index in 1..15) {
                            Image(
                                painter = painterResource(id = R.drawable.img_empty),
                                contentDescription = "",
                                modifier = Modifier
                                    .padding(top = 8.dp, bottom = 4.dp, end = 12.dp),
                            )
                        }
                    }
                } // 자식 레이아웃 공개예정 큐레이션 끝

                Column(
                    modifier = Modifier
                        .padding(bottom = 40.dp, start = 20.dp, end = 20.dp)
                        .fillMaxWidth(),
                ) {
                    Text(
                        text = "봄의 아침을 맞이하며",
                        color = Title,
                    )
                    Row(
                        modifier = Modifier
                            .horizontalScroll(hzScrollState)
                    ) {
                        for (index in 1..15) {
                            Image(
                                painter = painterResource(id = R.drawable.img_empty),
                                contentDescription = "",
                                modifier = Modifier
                                    .padding(top = 8.dp, bottom = 4.dp, end = 12.dp),
                            )
                        }
                    }
                } // 자식 레이아웃 봄의 .. 끝

                Column(
                    modifier = Modifier
                        .padding(bottom = 40.dp, start = 20.dp, end = 20.dp)
                        .fillMaxWidth(),
                ) {
                    Text(
                        text = "집중의 시간",
                        color = Title,
                    )
                    Row(
                        modifier = Modifier
                            .horizontalScroll(hzScrollState)
                    ) {
                        for (index in 1..15) {
                            Image(
                                painter = painterResource(id = R.drawable.img_empty),
                                contentDescription = "",
                                modifier = Modifier
                                    .padding(top = 8.dp, bottom = 4.dp, end = 12.dp),
                            )
                        }
                    }
                } // 자식 레이아웃 집중의 시간 끝

                Column(
                    modifier = Modifier
                        .padding(bottom = 40.dp, start = 20.dp, end = 20.dp)
                        .fillMaxWidth(),
                ) {
                    Text(
                        text = "내적 Groove 좀 타볼까요",
                        color = Title,
                    )
                    Row(
                        modifier = Modifier
                            .horizontalScroll(hzScrollState)
                    ) {
                        for (index in 1..15) {
                            Image(
                                painter = painterResource(id = R.drawable.img_empty),
                                contentDescription = "",
                                modifier = Modifier
                                    .padding(top = 8.dp, bottom = 4.dp, end = 12.dp),
                            )
                        }
                    }
                } // 자식 레이아웃 내적 .. 끝

                Button(
                    onClick = {},
                    modifier = Modifier
                        .padding(bottom = 40.dp, start = 20.dp, end = 20.dp)
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        text = "모든 아트워크",
                        color = Title,
                    )
                } // 자식 레이아웃 모든 아트워크 끝

            } // 메인페이지 본문 부모 레이아웃 끝
        }
    }
} // MainView end
