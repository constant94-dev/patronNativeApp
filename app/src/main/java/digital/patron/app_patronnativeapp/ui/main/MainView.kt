package digital.patron.app_patronnativeapp.ui.main

import android.annotation.SuppressLint
import android.content.res.Resources
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import digital.patron.app_patronnativeapp.R
import digital.patron.app_patronnativeapp.ui.theme.FooterSubTitle
import digital.patron.app_patronnativeapp.ui.theme.FooterTitle
import digital.patron.app_patronnativeapp.ui.theme.SubTitle
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
                            .fillMaxWidth()
                            .padding(top = 14.dp, start = 20.dp, end = 20.dp),
                        horizontalArrangement = Arrangement.Start,
                    ) {
                        IconButton(
                            onClick = {},
                            modifier = Modifier.weight(1f),
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.icon_logo),
                                contentDescription = "Patron logo.",
                                colorFilter = ColorFilter.tint(Color.White),
                            )

                        }

                        Spacer(modifier = Modifier.weight(6f)) // 60% width as the parent

                        IconButton(
                            onClick = {},
                            modifier = Modifier.weight(1f),
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.icon_dump_profile),
                                contentDescription = "Patron dump profile.",
                                colorFilter = ColorFilter.tint(Color.White),
                            )
                        }

                        IconButton(
                            onClick = {},
                            modifier = Modifier.weight(1f),
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.icon_search),
                                contentDescription = "Patron search.",
                                colorFilter = ColorFilter.tint(Color.White),
                            )
                        }

                        IconButton(
                            onClick = {},
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
        containerColor = Color(R.color.background)
    ) {
        Column {
            Spacer(modifier = Modifier.height(60.dp))
            Column(
                modifier = Modifier
                    .verticalScroll(vtScrollState)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Top,
            ) {
                Divider(
                    color = Color.Red,
                    thickness = 8.dp,
                ) // 'Scaffold' 레이아웃과 구분하기 위한 선

                Column(
                    modifier = Modifier
                        .padding(bottom = 40.dp, start = 20.dp),
                ) {
                    Text(
                        text = "추천 큐레이션",
                        color = Title,
                        fontWeight = FontWeight(700),
                        fontSize = 20.sp,
                    )
                    Row(
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .horizontalScroll(hzScrollState),
                    ) {
                        for (index in 1..15) {
                            Column {
                                Image(
                                    painter = painterResource(id = R.drawable.img_empty),
                                    contentDescription = "",
                                )

                                Text(
                                    text = "&작품명",
                                    color = Title,
                                    fontWeight = FontWeight(500),
                                    fontSize = 16.sp,
                                )
                                Text(
                                    text = "&작가명 외 1명",
                                    color = SubTitle,
                                    fontWeight = FontWeight(400),
                                    fontSize = 14.sp,
                                )
                                Text(
                                    text = "&작품수 · &총감상시간",
                                    color = SubTitle,
                                    fontWeight = FontWeight(400),
                                    fontSize = 12.sp,
                                )
                            }
                        }
                    } // 추천 큐레이션 작품 리스트 끝
                } // 자식 레이아웃 추천 큐레이션 끝

                Column(
                    modifier = Modifier
                        .padding(bottom = 40.dp, start = 20.dp),
                ) {
                    Text(
                        text = "새로운 아트워크",
                        color = Title,
                        fontWeight = FontWeight(700),
                        fontSize = 20.sp,
                    )
                    Row(
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .horizontalScroll(hzScrollState),
                    ) {
                        for (index in 1..15) {
                            Column {
                                Image(
                                    painter = painterResource(id = R.drawable.img_empty),
                                    contentDescription = "",
                                )

                                Text(
                                    text = "&아트워크 타이틀",
                                    color = Title,
                                )
                                Text(
                                    text = "&아티스트 타이틀",
                                    color = SubTitle,
                                )
                            }
                        }
                    } // 새로운 아트워크 리스트 끝
                } // 자식 레이아웃 새로운 아트워크 끝

                Column(
                    modifier = Modifier
                        .padding(bottom = 40.dp, start = 20.dp),
                ) {
                    Text(
                        text = "커피 한 잔 생각날 때",
                        color = Title,
                        fontWeight = FontWeight(700),
                        fontSize = 20.sp,
                    )
                    Text(
                        text = "&작품수 · &감상시간",
                        color = SubTitle,
                        fontWeight = FontWeight(400),
                        fontSize = 12.sp,
                    )
                    Row(
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .horizontalScroll(hzScrollState),
                    ) {
                        for (index in 1..15) {
                            Column {
                                Image(
                                    painter = painterResource(id = R.drawable.img_empty),
                                    contentDescription = "",
                                )

                                Text(
                                    text = "&아트워크 타이틀",
                                    color = Title,
                                    fontWeight = FontWeight(500),
                                    fontSize = 16.sp,
                                )
                                Text(
                                    text = "&아티스트 타이틀",
                                    color = SubTitle,
                                    fontWeight = FontWeight(400),
                                    fontSize = 14.sp,
                                )
                            }
                        }
                    } // 커피 한 잔 생각날 때 리스트 끝
                } // 자식 레이아웃 커피.. 끝

                Column(
                    modifier = Modifier
                        .padding(bottom = 40.dp, start = 20.dp),
                ) {
                    Text(
                        text = "Jazz Today",
                        color = Title,
                    )
                    Text(
                        text = "&작품수 · &감상시간",
                        color = SubTitle,
                        fontWeight = FontWeight(400),
                        fontSize = 12.sp,
                    )
                    Row(
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .horizontalScroll(hzScrollState),
                    ) {
                        for (index in 1..15) {
                            Column {
                                Image(
                                    painter = painterResource(id = R.drawable.img_empty),
                                    contentDescription = "",
                                )

                                Text(
                                    text = "&아트워크 타이틀",
                                    color = Title,
                                    fontWeight = FontWeight(500),
                                    fontSize = 16.sp,
                                )
                                Text(
                                    text = "&아티스트 타이틀",
                                    color = SubTitle,
                                    fontWeight = FontWeight(400),
                                    fontSize = 14.sp,
                                )
                            }
                        }
                    } // Jazz Today 리스트 끝
                } // 자식 레이아웃 Jazz Today 끝

                Column(
                    modifier = Modifier
                        .padding(bottom = 40.dp, start = 20.dp),
                ) {
                    Text(
                        text = "공개예정 큐레이션",
                        color = Title,
                        fontWeight = FontWeight(700),
                        fontSize = 20.sp
                    )
                    Row(
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .horizontalScroll(hzScrollState),
                    ) {
                        for (index in 1..15) {
                            Column {
                                Image(
                                    painter = painterResource(id = R.drawable.img_empty),
                                    contentDescription = "",
                                )

                                Text(
                                    text = "&아트워크 타이틀",
                                    color = Title,
                                    fontWeight = FontWeight(500),
                                    fontSize = 16.sp,
                                )
                                Text(
                                    text = "&아티스트 타이틀",
                                    color = SubTitle,
                                    fontWeight = FontWeight(400),
                                    fontSize = 14.sp,
                                )
                            }
                        }
                    } // 공개예정 큐레이션 리스트 끝
                } // 자식 레이아웃 공개예정 큐레이션 끝

                Column(
                    modifier = Modifier
                        .padding(bottom = 40.dp, start = 20.dp),
                ) {
                    Text(
                        text = "봄의 아침을 맞이하며",
                        color = Title,
                        fontWeight = FontWeight(700),
                        fontSize = 20.sp,
                    )
                    Text(
                        text = "&작품수 · &감상시간",
                        color = SubTitle,
                        fontWeight = FontWeight(400),
                        fontSize = 12.sp,
                    )
                    Row(
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .horizontalScroll(hzScrollState),
                    ) {
                        for (index in 1..15) {
                            Column {
                                Image(
                                    painter = painterResource(id = R.drawable.img_empty),
                                    contentDescription = "",
                                )

                                Text(
                                    text = "&아트워크 타이틀",
                                    color = Title,
                                    fontWeight = FontWeight(500),
                                    fontSize = 16.sp,
                                )
                                Text(
                                    text = "&아티스트 타이틀",
                                    color = SubTitle,
                                    fontWeight = FontWeight(400),
                                    fontSize = 14.sp,
                                )
                            }
                        }
                    } // 봄의 .. 리스트 끝
                } // 자식 레이아웃 봄의 .. 끝

                Column(
                    modifier = Modifier
                        .padding(bottom = 40.dp, start = 20.dp),
                ) {
                    Text(
                        text = "집중의 시간",
                        color = Title,
                        fontWeight = FontWeight(700),
                        fontSize = 20.sp,
                    )
                    Text(
                        text = "&작품수 · &감상시간",
                        color = SubTitle,
                        fontWeight = FontWeight(400),
                        fontSize = 12.sp,
                    )
                    Row(
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .horizontalScroll(hzScrollState),
                    ) {
                        for (index in 1..15) {
                            Column {
                                Image(
                                    painter = painterResource(id = R.drawable.img_empty),
                                    contentDescription = "",
                                )

                                Text(
                                    text = "&아트워크 타이틀",
                                    color = Title,
                                    fontWeight = FontWeight(500),
                                    fontSize = 16.sp,
                                )
                                Text(
                                    text = "&아티스트 타이틀",
                                    color = SubTitle,
                                    fontWeight = FontWeight(400),
                                    fontSize = 14.sp,
                                )
                            }
                        }
                    } // 집중의 시간 리스트 끝
                } // 자식 레이아웃 집중의 시간 끝

                Column(
                    modifier = Modifier
                        .padding(bottom = 40.dp, start = 20.dp),
                ) {
                    Text(
                        text = "내적 Groove 좀 타볼까요",
                        color = Title,
                        fontWeight = FontWeight(700),
                        fontSize = 20.sp,
                    )
                    Text(
                        text = "&작품수 · &감상시간",
                        color = SubTitle,
                        fontWeight = FontWeight(400),
                        fontSize = 12.sp,
                    )
                    Row(
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .horizontalScroll(hzScrollState),
                    ) {
                        for (index in 1..15) {
                            Column {
                                Image(
                                    painter = painterResource(id = R.drawable.img_empty),
                                    contentDescription = "",
                                )

                                Text(
                                    text = "&아트워크 타이틀",
                                    color = Title,
                                    fontWeight = FontWeight(500),
                                    fontSize = 16.sp,
                                )
                                Text(
                                    text = "&아티스트 타이틀",
                                    color = SubTitle,
                                    fontWeight = FontWeight(400),
                                    fontSize = 14.sp,
                                )
                            }
                        }
                    } // 내적 .. 리스트 끝
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
                        fontWeight = FontWeight(500),
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center,
                    )
                } // 자식 레이아웃 모든 아트워크 끝

                Column(
                    modifier = Modifier
                        .padding(bottom = 40.dp, start = 20.dp),
                ) {
                    Text(
                        text = "추천 아티스트",
                        color = Title,
                        fontWeight = FontWeight(700),
                        fontSize = 20.sp,
                    )
                    Row(
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .horizontalScroll(hzScrollState),
                    ) {
                        for (index in 1..15) {
                            Column {
                                Image(
                                    painter = painterResource(id = R.drawable.img_empty),
                                    contentDescription = "",
                                )

                                Text(
                                    text = "아티스트 타이틀",
                                    color = Title,
                                    fontWeight = FontWeight(500),
                                    fontSize = 16.sp,
                                    textAlign = TextAlign.Center,
                                )
                            }
                        }
                    } // 추천 아티스트 리스트 끝
                } // 자식 레이아웃 추천 아티스트 끝

                Button(
                    onClick = {},
                    modifier = Modifier
                        .padding(bottom = 40.dp, start = 20.dp, end = 20.dp)
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        text = "모든 아티스트",
                        color = Title,
                        fontWeight = FontWeight(500),
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center,
                    )
                } // 자식 레이아웃 모든 아티스트 끝

                Box(
                    modifier = Modifier
                        .background(Color.White),
                ) {
                    Column(
                        modifier = Modifier
                            .padding(top = 40.dp, bottom = 40.dp, start = 20.dp, end = 20.dp)
                            .fillMaxWidth(),
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(
                                17.dp,
                                alignment = Alignment.Start
                            ),
                        ) {
                            Text(
                                text = "서비스이용약관",
                                color = FooterTitle,
                            )
                            Text(
                                text = "개인정보 처리 방침",
                                color = FooterTitle,
                            )
                            Text(
                                text = "계정 운영정책",
                                color = FooterTitle,
                            )
                        }

                        Spacer(
                            modifier = Modifier.padding(top = 20.dp),
                        )

                        Column {
                            Text(
                                text = "주식회사 노다멘",
                                color = FooterTitle,
                                fontWeight = FontWeight.Bold,
                            )
                            Text(
                                text = "Copyright © 2023Nodamen Inc.",
                                modifier = Modifier.padding(top = 8.dp, bottom = 8.dp),
                                color = FooterSubTitle,
                            )
                            Text(
                                text = "사업자등록번호 : 489-88-00555 | 대표이사 : 이원준 |  통신판매업신고 : 제2017-제주이도2-0100호 사업자정보확인\n" +
                                        " 주소 : 서울특별시 서대문구 연희로 134-1 제임스빌 5층 | 대표전화 : 070 7724 1703",
                                color = FooterSubTitle,
                            )

                            Spacer(
                                modifier = Modifier.padding(top = 8.dp),
                            )

                            Text(
                                text = "고객 help@patron.digital ㅣ 작가 artist@patron.digital\n" +
                                        "전화 070-7724-1703 (주중 09:00 ~ 17:00)",
                                color = FooterSubTitle,
                            )
                        }

                    } // 풋터 영역 본문 부모 레이아웃 끝
                } // 풋터 영역을 위한 레이아웃 끝


            } // 메인페이지 본문 부모 레이아웃 끝
        } // 메인페이지 상단 바 / 본문 / 하단 바 구조를 잡기위한 레이아웃 끝

    } // Scaffold function end
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
                            .fillMaxWidth()
                            .padding(top = 14.dp, start = 20.dp, end = 20.dp),
                        horizontalArrangement = Arrangement.Start,
                    ) {
                        IconButton(
                            onClick = {},
                            modifier = Modifier.weight(1f),
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.icon_logo),
                                contentDescription = "Patron logo.",
                                colorFilter = ColorFilter.tint(Color.White),
                            )

                        }

                        Spacer(modifier = Modifier.weight(6f)) // 60% width as the parent

                        IconButton(
                            onClick = {},
                            modifier = Modifier.weight(1f),
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.icon_dump_profile),
                                contentDescription = "Patron dump profile.",
                                colorFilter = ColorFilter.tint(Color.White),
                            )
                        }

                        IconButton(
                            onClick = {},
                            modifier = Modifier.weight(1f),
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.icon_search),
                                contentDescription = "Patron search.",
                                colorFilter = ColorFilter.tint(Color.White),
                            )
                        }

                        IconButton(
                            onClick = {},
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
        containerColor = Color(R.color.background)
    ) {
        Column {
            Spacer(modifier = Modifier.height(60.dp))
            Column(
                modifier = Modifier
                    .verticalScroll(vtScrollState)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Top,
            ) {
                Divider(
                    color = Color.Red,
                    thickness = 8.dp,
                ) // 'Scaffold' 레이아웃과 구분하기 위한 선

                Column(
                    modifier = Modifier
                        .padding(bottom = 40.dp, start = 20.dp),
                ) {
                    Text(
                        text = "추천 큐레이션",
                        color = Title,
                        fontWeight = FontWeight(700),
                        fontSize = 20.sp,
                    )
                    Row(
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .horizontalScroll(hzScrollState),
                    ) {
                        for (index in 1..15) {
                            Column {
                                Image(
                                    painter = painterResource(id = R.drawable.img_empty),
                                    contentDescription = "",
                                )

                                Text(
                                    text = "&작품명",
                                    color = Title,
                                    fontWeight = FontWeight(500),
                                    fontSize = 16.sp,
                                )
                                Text(
                                    text = "&작가명 외 1명",
                                    color = SubTitle,
                                    fontWeight = FontWeight(400),
                                    fontSize = 14.sp,
                                )
                                Text(
                                    text = "&작품수 · &총감상시간",
                                    color = SubTitle,
                                    fontWeight = FontWeight(400),
                                    fontSize = 12.sp,
                                )
                            }
                        }
                    } // 추천 큐레이션 작품 리스트 끝
                } // 자식 레이아웃 추천 큐레이션 끝

                Column(
                    modifier = Modifier
                        .padding(bottom = 40.dp, start = 20.dp),
                ) {
                    Text(
                        text = "새로운 아트워크",
                        color = Title,
                        fontWeight = FontWeight(700),
                        fontSize = 20.sp,
                    )
                    Row(
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .horizontalScroll(hzScrollState),
                    ) {
                        for (index in 1..15) {
                            Column {
                                Image(
                                    painter = painterResource(id = R.drawable.img_empty),
                                    contentDescription = "",
                                )

                                Text(
                                    text = "&아트워크 타이틀",
                                    color = Title,
                                )
                                Text(
                                    text = "&아티스트 타이틀",
                                    color = SubTitle,
                                )
                            }
                        }
                    } // 새로운 아트워크 리스트 끝
                } // 자식 레이아웃 새로운 아트워크 끝

                Column(
                    modifier = Modifier
                        .padding(bottom = 40.dp, start = 20.dp),
                ) {
                    Text(
                        text = "커피 한 잔 생각날 때",
                        color = Title,
                        fontWeight = FontWeight(700),
                        fontSize = 20.sp,
                    )
                    Text(
                        text = "&작품수 · &감상시간",
                        color = SubTitle,
                        fontWeight = FontWeight(400),
                        fontSize = 12.sp,
                    )
                    Row(
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .horizontalScroll(hzScrollState),
                    ) {
                        for (index in 1..15) {
                            Column {
                                Image(
                                    painter = painterResource(id = R.drawable.img_empty),
                                    contentDescription = "",
                                )

                                Text(
                                    text = "&아트워크 타이틀",
                                    color = Title,
                                    fontWeight = FontWeight(500),
                                    fontSize = 16.sp,
                                )
                                Text(
                                    text = "&아티스트 타이틀",
                                    color = SubTitle,
                                    fontWeight = FontWeight(400),
                                    fontSize = 14.sp,
                                )
                            }
                        }
                    } // 커피 한 잔 생각날 때 리스트 끝
                } // 자식 레이아웃 커피.. 끝

                Column(
                    modifier = Modifier
                        .padding(bottom = 40.dp, start = 20.dp),
                ) {
                    Text(
                        text = "Jazz Today",
                        color = Title,
                    )
                    Text(
                        text = "&작품수 · &감상시간",
                        color = SubTitle,
                        fontWeight = FontWeight(400),
                        fontSize = 12.sp,
                    )
                    Row(
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .horizontalScroll(hzScrollState),
                    ) {
                        for (index in 1..15) {
                            Column {
                                Image(
                                    painter = painterResource(id = R.drawable.img_empty),
                                    contentDescription = "",
                                )

                                Text(
                                    text = "&아트워크 타이틀",
                                    color = Title,
                                    fontWeight = FontWeight(500),
                                    fontSize = 16.sp,
                                )
                                Text(
                                    text = "&아티스트 타이틀",
                                    color = SubTitle,
                                    fontWeight = FontWeight(400),
                                    fontSize = 14.sp,
                                )
                            }
                        }
                    } // Jazz Today 리스트 끝
                } // 자식 레이아웃 Jazz Today 끝

                Column(
                    modifier = Modifier
                        .padding(bottom = 40.dp, start = 20.dp),
                ) {
                    Text(
                        text = "공개예정 큐레이션",
                        color = Title,
                        fontWeight = FontWeight(700),
                        fontSize = 20.sp
                    )
                    Row(
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .horizontalScroll(hzScrollState),
                    ) {
                        for (index in 1..15) {
                            Column {
                                Image(
                                    painter = painterResource(id = R.drawable.img_empty),
                                    contentDescription = "",
                                )

                                Text(
                                    text = "&아트워크 타이틀",
                                    color = Title,
                                    fontWeight = FontWeight(500),
                                    fontSize = 16.sp,
                                )
                                Text(
                                    text = "&아티스트 타이틀",
                                    color = SubTitle,
                                    fontWeight = FontWeight(400),
                                    fontSize = 14.sp,
                                )
                            }
                        }
                    } // 공개예정 큐레이션 리스트 끝
                } // 자식 레이아웃 공개예정 큐레이션 끝

                Column(
                    modifier = Modifier
                        .padding(bottom = 40.dp, start = 20.dp),
                ) {
                    Text(
                        text = "봄의 아침을 맞이하며",
                        color = Title,
                        fontWeight = FontWeight(700),
                        fontSize = 20.sp,
                    )
                    Text(
                        text = "&작품수 · &감상시간",
                        color = SubTitle,
                        fontWeight = FontWeight(400),
                        fontSize = 12.sp,
                    )
                    Row(
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .horizontalScroll(hzScrollState),
                    ) {
                        for (index in 1..15) {
                            Column {
                                Image(
                                    painter = painterResource(id = R.drawable.img_empty),
                                    contentDescription = "",
                                )

                                Text(
                                    text = "&아트워크 타이틀",
                                    color = Title,
                                    fontWeight = FontWeight(500),
                                    fontSize = 16.sp,
                                )
                                Text(
                                    text = "&아티스트 타이틀",
                                    color = SubTitle,
                                    fontWeight = FontWeight(400),
                                    fontSize = 14.sp,
                                )
                            }
                        }
                    } // 봄의 .. 리스트 끝
                } // 자식 레이아웃 봄의 .. 끝

                Column(
                    modifier = Modifier
                        .padding(bottom = 40.dp, start = 20.dp),
                ) {
                    Text(
                        text = "집중의 시간",
                        color = Title,
                        fontWeight = FontWeight(700),
                        fontSize = 20.sp,
                    )
                    Text(
                        text = "&작품수 · &감상시간",
                        color = SubTitle,
                        fontWeight = FontWeight(400),
                        fontSize = 12.sp,
                    )
                    Row(
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .horizontalScroll(hzScrollState),
                    ) {
                        for (index in 1..15) {
                            Column {
                                Image(
                                    painter = painterResource(id = R.drawable.img_empty),
                                    contentDescription = "",
                                )

                                Text(
                                    text = "&아트워크 타이틀",
                                    color = Title,
                                    fontWeight = FontWeight(500),
                                    fontSize = 16.sp,
                                )
                                Text(
                                    text = "&아티스트 타이틀",
                                    color = SubTitle,
                                    fontWeight = FontWeight(400),
                                    fontSize = 14.sp,
                                )
                            }
                        }
                    } // 집중의 시간 리스트 끝
                } // 자식 레이아웃 집중의 시간 끝

                Column(
                    modifier = Modifier
                        .padding(bottom = 40.dp, start = 20.dp),
                ) {
                    Text(
                        text = "내적 Groove 좀 타볼까요",
                        color = Title,
                        fontWeight = FontWeight(700),
                        fontSize = 20.sp,
                    )
                    Text(
                        text = "&작품수 · &감상시간",
                        color = SubTitle,
                        fontWeight = FontWeight(400),
                        fontSize = 12.sp,
                    )
                    Row(
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .horizontalScroll(hzScrollState),
                    ) {
                        for (index in 1..15) {
                            Column {
                                Image(
                                    painter = painterResource(id = R.drawable.img_empty),
                                    contentDescription = "",
                                )

                                Text(
                                    text = "&아트워크 타이틀",
                                    color = Title,
                                    fontWeight = FontWeight(500),
                                    fontSize = 16.sp,
                                )
                                Text(
                                    text = "&아티스트 타이틀",
                                    color = SubTitle,
                                    fontWeight = FontWeight(400),
                                    fontSize = 14.sp,
                                )
                            }
                        }
                    } // 내적 .. 리스트 끝
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
                        fontWeight = FontWeight(500),
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center,
                    )
                } // 자식 레이아웃 모든 아트워크 끝

                Column(
                    modifier = Modifier
                        .padding(bottom = 40.dp, start = 20.dp),
                ) {
                    Text(
                        text = "추천 아티스트",
                        color = Title,
                        fontWeight = FontWeight(700),
                        fontSize = 20.sp,
                    )
                    Row(
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .horizontalScroll(hzScrollState),
                    ) {
                        for (index in 1..15) {
                            Column {
                                Image(
                                    painter = painterResource(id = R.drawable.img_empty),
                                    contentDescription = "",
                                )

                                Text(
                                    text = "아티스트 타이틀",
                                    color = Title,
                                    fontWeight = FontWeight(500),
                                    fontSize = 16.sp,
                                    textAlign = TextAlign.Center,
                                )
                            }
                        }
                    } // 추천 아티스트 리스트 끝
                } // 자식 레이아웃 추천 아티스트 끝

                Button(
                    onClick = {},
                    modifier = Modifier
                        .padding(bottom = 40.dp, start = 20.dp, end = 20.dp)
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        text = "모든 아티스트",
                        color = Title,
                        fontWeight = FontWeight(500),
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center,
                    )
                } // 자식 레이아웃 모든 아티스트 끝

                Box(
                    modifier = Modifier
                        .background(Color.White),
                ) {
                    Column(
                        modifier = Modifier
                            .padding(top = 40.dp, bottom = 40.dp, start = 20.dp, end = 20.dp)
                            .fillMaxWidth(),
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(
                                17.dp,
                                alignment = Alignment.Start
                            ),
                        ) {
                            Text(
                                text = "서비스이용약관",
                                color = FooterTitle,
                            )
                            Text(
                                text = "개인정보 처리 방침",
                                color = FooterTitle,
                            )
                            Text(
                                text = "계정 운영정책",
                                color = FooterTitle,
                            )
                        }

                        Spacer(
                            modifier = Modifier.padding(top = 20.dp),
                        )

                        Column {
                            Text(
                                text = "주식회사 노다멘",
                                color = FooterTitle,
                                fontWeight = FontWeight.Bold,
                            )
                            Text(
                                text = "Copyright © 2023Nodamen Inc.",
                                modifier = Modifier.padding(top = 8.dp, bottom = 8.dp),
                                color = FooterSubTitle,
                            )
                            Text(
                                text = "사업자등록번호 : 489-88-00555 | 대표이사 : 이원준 |  통신판매업신고 : 제2017-제주이도2-0100호 사업자정보확인\n" +
                                        " 주소 : 서울특별시 서대문구 연희로 134-1 제임스빌 5층 | 대표전화 : 070 7724 1703",
                                color = FooterSubTitle,
                            )

                            Spacer(
                                modifier = Modifier.padding(top = 8.dp),
                            )

                            Text(
                                text = "고객 help@patron.digital ㅣ 작가 artist@patron.digital\n" +
                                        "전화 070-7724-1703 (주중 09:00 ~ 17:00)",
                                color = FooterSubTitle,
                            )
                        }

                    } // 풋터 영역 본문 부모 레이아웃 끝
                } // 풋터 영역을 위한 레이아웃 끝


            } // 메인페이지 본문 부모 레이아웃 끝
        } // 메인페이지 상단 바 / 본문 / 하단 바 구조를 잡기위한 레이아웃 끝

    } // Scaffold function end
} // MainView function end