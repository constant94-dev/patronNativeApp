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
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import digital.patron.app_patronnativeapp.R
import digital.patron.app_patronnativeapp.ui.theme.BoxText
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

    val itemsList = (1..15).toList()

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
                                modifier = Modifier
                                    .width(34.dp)
                                    .height(20.dp),
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
                                modifier = Modifier
                                    .width(34.dp)
                                    .height(20.dp),
                                contentDescription = "Patron dump profile.",
                            )
                        }

                        Spacer(modifier = Modifier.weight(0.5f))

                        IconButton(
                            onClick = {},
                            modifier = Modifier.weight(1f),
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.icon_search),
                                contentDescription = "Patron search.",
                                modifier = Modifier
                                    .width(34.dp)
                                    .height(20.dp),
                                colorFilter = ColorFilter.tint(Color.White),
                            )
                        }

                        Spacer(modifier = Modifier.weight(0.5f))

                        IconButton(
                            onClick = {},
                            modifier = Modifier.weight(1f),
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.icon_menu),
                                contentDescription = "Patron menu.",
                                modifier = Modifier
                                    .width(34.dp)
                                    .height(20.dp),
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
                .padding(start = 8.dp)
                .verticalScroll(vtScrollState)
                .fillMaxSize(),
        ) {
            Spacer(modifier = Modifier.height(80.dp))

            Text(
                text = "추천 큐레이션",
                color = Title,
                fontWeight = FontWeight(700),
                fontSize = 20.sp,
            )

            Column(
                modifier = Modifier.padding(
                        top = 8.dp, bottom = 40.dp
                    ),
            ) {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                ) {
                    items(itemsList.size) {
                        Column {
                            Box {
                                Image(
                                    painter = painterResource(id = R.drawable.img_empty),
                                    contentDescription = "",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .size(320.dp, 180.dp)
                                        .clip(RoundedCornerShape(16.dp)),
                                )

                                Icon(
                                    painter = painterResource(id = R.drawable.icon_exhibition),
                                    contentDescription = "",
                                    modifier = Modifier
                                        .align(Alignment.TopEnd)
                                        .padding(8.dp)
                                        .size(16.dp),
                                    tint = Color.White,
                                )

                                Text(
                                    text = "1/8",
                                    modifier = Modifier
                                        .align(Alignment.BottomEnd)
                                        .padding(8.dp)
                                        .background(BoxText),
                                    color = Title,
                                    fontWeight = FontWeight(700),
                                    fontSize = 12.sp,
                                )
                            }

                            Text(
                                text = "&작품명",
                                modifier = Modifier.padding(
                                    bottom = 4.dp, top = 4.dp
                                ),
                                color = Title,
                                fontWeight = FontWeight(500),
                                fontSize = 16.sp,
                            )
                            Text(
                                text = "&작가명 외 1명",
                                modifier = Modifier.padding(bottom = 4.dp),
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
                        } // 아이템 구성 UI
                    } // 뷰 모델에서 잔달받은 콘텐츠 사이즈만큼 아이템 생성
                } // 추천 큐레이션 Row 리스트
            } // 추천 큐레이션 UI

            Text(
                text = "새로운 아트워크",
                color = Title,
                fontWeight = FontWeight(700),
                fontSize = 20.sp,
            )

            Column(
                modifier = Modifier.padding(
                        top = 8.dp, bottom = 40.dp
                    ),
            ) {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                ) {
                    items(itemsList.size) {
                        Column {
                            Box {
                                Image(
                                    painter = painterResource(id = R.drawable.img_empty),
                                    contentDescription = "",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .size(154.dp)
                                        .clip(RoundedCornerShape(16.dp)),
                                )

                                Text(
                                    text = "신규",
                                    modifier = Modifier
                                        .align(Alignment.TopStart)
                                        .padding(8.dp)
                                        .background(BoxText),
                                    color = Title,
                                    fontWeight = FontWeight(700),
                                    fontSize = 12.sp,
                                )
                            }

                            Text(
                                text = "&작품명",
                                modifier = Modifier.padding(
                                    top = 4.dp, bottom = 4.dp
                                ),
                                color = Title,
                                fontWeight = FontWeight(500),
                                fontSize = 16.sp,
                            )
                            Text(
                                text = "&작가명 외 1명",
                                modifier = Modifier.padding(bottom = 4.dp),
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
                        } // 아이템 구성 UI
                    } // 뷰 모델에서 잔달받은 콘텐츠 사이즈만큼 아이템 생성
                } // 새로운 아트워크 Row 리스트
            } // 새로운 아트워크 UI

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

            Column(
                modifier = Modifier.padding(
                        top = 8.dp, bottom = 40.dp
                    ),
            ) {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                ) {
                    items(itemsList.size) {
                        Column {
                            Box {
                                Image(
                                    painter = painterResource(id = R.drawable.img_empty),
                                    contentDescription = "",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .size(154.dp)
                                        .clip(RoundedCornerShape(16.dp)),
                                )
                            }

                            Text(
                                text = "&아트워크 타이틀",
                                modifier = Modifier.padding(
                                    top = 4.dp, bottom = 4.dp
                                ),
                                color = Title,
                                fontWeight = FontWeight(500),
                                fontSize = 16.sp,
                            )
                            Text(
                                text = "&아티스트 타이틀",
                                modifier = Modifier.padding(bottom = 4.dp),
                                color = SubTitle,
                                fontWeight = FontWeight(400),
                                fontSize = 14.sp,
                            )
                        } // 아이템 구성 UI
                    } // 뷰 모델에서 잔달받은 콘텐츠 사이즈만큼 아이템 생성
                } // 커피 한 잔 생각날 때 Row 리스트
            } // 커피 한 잔 생각날 때 UI

            Text(
                text = "Jazz Today",
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

            Column(
                modifier = Modifier.padding(
                        top = 8.dp, bottom = 40.dp
                    ),
            ) {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                ) {
                    items(itemsList.size) {
                        Column {
                            Box {
                                Image(
                                    painter = painterResource(id = R.drawable.img_empty),
                                    contentDescription = "",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .size(154.dp)
                                        .clip(RoundedCornerShape(16.dp)),
                                )
                            }

                            Text(
                                text = "&아트워크 타이틀",
                                modifier = Modifier.padding(
                                    top = 4.dp, bottom = 4.dp
                                ),
                                color = Title,
                                fontWeight = FontWeight(500),
                                fontSize = 16.sp,
                            )
                            Text(
                                text = "&아티스트 타이틀",
                                modifier = Modifier.padding(bottom = 4.dp),
                                color = SubTitle,
                                fontWeight = FontWeight(400),
                                fontSize = 14.sp,
                            )
                        } // 아이템 구성 UI
                    } // 뷰 모델에서 잔달받은 콘텐츠 사이즈만큼 아이템 생성
                } // Jazz Today Row 리스트
            } // Jazz Today UI

            Text(
                text = "공개예정 큐레이션", color = Title, fontWeight = FontWeight(700), fontSize = 20.sp
            )

            Column(
                modifier = Modifier.padding(
                        top = 8.dp, bottom = 40.dp
                    ),
            ) {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                ) {
                    items(itemsList.size) {
                        Column {
                            Box {
                                Image(
                                    painter = painterResource(id = R.drawable.img_empty),
                                    contentDescription = "",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .size(320.dp, 180.dp)
                                        .clip(RoundedCornerShape(16.dp)),
                                )

                                Text(
                                    text = "D-7",
                                    modifier = Modifier
                                        .align(Alignment.TopStart)
                                        .padding(8.dp)
                                        .background(BoxText),
                                    color = Title,
                                    fontWeight = FontWeight(700),
                                    fontSize = 12.sp,
                                )

                                Icon(
                                    painter = painterResource(id = R.drawable.icon_exhibition),
                                    contentDescription = "",
                                    modifier = Modifier
                                        .align(Alignment.TopEnd)
                                        .padding(8.dp)
                                        .size(16.dp),
                                    tint = Color.White,
                                )
                            }

                            Text(
                                text = "&아트워크 타이틀",
                                modifier = Modifier.padding(
                                    top = 4.dp, bottom = 4.dp
                                ),
                                color = Title,
                                fontWeight = FontWeight(500),
                                fontSize = 16.sp,
                            )
                            Text(
                                text = "&아티스트 타이틀",
                                modifier = Modifier.padding(bottom = 4.dp),
                                color = SubTitle,
                                fontWeight = FontWeight(400),
                                fontSize = 14.sp,
                            )

                            Button(onClick = { }) {
                                Text(
                                    text = "저장",
                                    color = Color.White,
                                    fontWeight = FontWeight(500),
                                    fontSize = 14.sp,
                                )
                            }
                        } // 아이템 구성 UI
                    } // 뷰 모델에서 잔달받은 콘텐츠 사이즈만큼 아이템 생성
                } // 공개예정 큐레이션 Row 리스트
            } // 공개예정 큐레이션 UI

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

            Column(
                modifier = Modifier.padding(
                        top = 8.dp, bottom = 40.dp
                    ),
            ) {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                ) {
                    items(itemsList.size) {
                        Column {
                            Box {
                                Image(
                                    painter = painterResource(id = R.drawable.img_empty),
                                    contentDescription = "",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .size(154.dp)
                                        .clip(RoundedCornerShape(16.dp)),
                                )
                            }

                            Text(
                                text = "&아트워크 타이틀",
                                modifier = Modifier.padding(
                                    top = 4.dp, bottom = 4.dp
                                ),
                                color = Title,
                                fontWeight = FontWeight(500),
                                fontSize = 16.sp,
                            )
                            Text(
                                text = "&아티스트 타이틀",
                                modifier = Modifier.padding(bottom = 4.dp),
                                color = SubTitle,
                                fontWeight = FontWeight(400),
                                fontSize = 14.sp,
                            )
                        } // 아이템 구성 UI
                    } // 뷰 모델에서 잔달받은 콘텐츠 사이즈만큼 아이템 생성
                } // 봄의 아침을 맞이하며 Row 리스트
            } // 봄의 아침을 맞이하며 UI

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

            Column(
                modifier = Modifier.padding(
                        top = 8.dp, bottom = 40.dp
                    ),
            ) {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                ) {
                    items(itemsList.size) {
                        Column {
                            Box {
                                Image(
                                    painter = painterResource(id = R.drawable.img_empty),
                                    contentDescription = "",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .size(154.dp)
                                        .clip(RoundedCornerShape(16.dp)),
                                )
                            }

                            Text(
                                text = "&아트워크 타이틀",
                                modifier = Modifier.padding(
                                    top = 4.dp, bottom = 4.dp
                                ),
                                color = Title,
                                fontWeight = FontWeight(500),
                                fontSize = 16.sp,
                            )
                            Text(
                                text = "&아티스트 타이틀",
                                modifier = Modifier.padding(bottom = 4.dp),
                                color = SubTitle,
                                fontWeight = FontWeight(400),
                                fontSize = 14.sp,
                            )
                        } // 아이템 구성 UI
                    } // 뷰 모델에서 잔달받은 콘텐츠 사이즈만큼 아이템 생성
                } // 집중의 시간 Row 리스트
            } // 집중의 시간 UI

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

            Column(
                modifier = Modifier.padding(
                        top = 8.dp, bottom = 40.dp
                    ),
            ) {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                ) {
                    items(itemsList.size) {
                        Column {
                            Box {
                                Image(
                                    painter = painterResource(id = R.drawable.img_empty),
                                    contentDescription = "",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .size(154.dp)
                                        .clip(RoundedCornerShape(16.dp)),
                                )
                            }

                            Text(
                                text = "&아트워크 타이틀",
                                modifier = Modifier.padding(
                                    top = 4.dp, bottom = 4.dp
                                ),
                                color = Title,
                                fontWeight = FontWeight(500),
                                fontSize = 16.sp,
                            )
                            Text(
                                text = "&아티스트 타이틀",
                                modifier = Modifier.padding(bottom = 4.dp),
                                color = SubTitle,
                                fontWeight = FontWeight(400),
                                fontSize = 14.sp,
                            )
                        } // 아이템 구성 UI
                    } // 뷰 모델에서 잔달받은 콘텐츠 사이즈만큼 아이템 생성
                } // 내적 Groove 좀 타볼까요 Row 리스트
            } // 내적 Groove 좀 타볼까요 UI

            Button(
                onClick = {},
                modifier = Modifier
                    .padding(bottom = 40.dp)
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
            } // 모든 아트워크 버튼 UI

            Text(
                text = "추천 아티스트",
                color = Title,
                fontWeight = FontWeight(700),
                fontSize = 20.sp,
            )

            Column(
                modifier = Modifier
                    .padding(
                        top = 8.dp, bottom = 40.dp
                    )
                    .fillMaxWidth(),
            ) {
                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                ) {
                    items(itemsList.size) {
                        Column {
                            Box {
                                Image(
                                    painter = painterResource(id = R.drawable.img_empty),
                                    contentDescription = "",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .size(154.dp)
                                        .clip(CircleShape),
                                )
                            }

                            Text(
                                text = "&아티스트 타이틀",
                                modifier = Modifier
                                    .width(154.dp)
                                    .padding(top = 4.dp),
                                color = Title,
                                fontWeight = FontWeight(500),
                                fontSize = 16.sp,
                                textAlign = TextAlign.Center,
                            )
                        } // 아이템 구성 UI
                    } // 뷰 모델에서 잔달받은 콘텐츠 사이즈만큼 아이템 생성
                } // 추천 아티스트 Row 리스트
            } // 추천 아티스트 UI

            Button(
                onClick = {},
                modifier = Modifier
                    .padding(bottom = 40.dp)
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
            } // 모든 아티스트 버튼 UI

            Box(
                modifier = Modifier.background(Color.White),
            ) {
                Column(
                    modifier = Modifier
                        .padding(
                            top = 40.dp, bottom = 40.dp, start = 20.dp, end = 20.dp
                        )
                        .fillMaxWidth(),
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(
                            17.dp, alignment = Alignment.Start
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
                            text = "사업자등록번호 : 489-88-00555 | 대표이사 : 이원준 |  통신판매업신고 : 제2017-제주이도2-0100호 사업자정보확인\n" + " 주소 : 서울특별시 서대문구 연희로 134-1 제임스빌 5층 | 대표전화 : 070 7724 1703",
                            color = FooterSubTitle,
                        )

                        Spacer(
                            modifier = Modifier.padding(top = 8.dp),
                        )

                        Text(
                            text = "고객 help@patron.digital ㅣ 작가 artist@patron.digital\n" + "전화 070-7724-1703 (주중 09:00 ~ 17:00)",
                            color = FooterSubTitle,
                        )
                    }
                } // 풋터 본문 레이아웃 끝
            } // 풋터 전체 영역 레이아웃 끝
        } // 메인페이지 상단 바 / 본문 / 풋터 구조를 잡기위한 레이아웃 끝
    } // Scaffold function end
} // MainView function end

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun MainView() {
    val hzScrollState = rememberScrollState()
    val vtScrollState = rememberScrollState()

    val itemsList = (1..15).toList()

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
                                modifier = Modifier
                                    .width(34.dp)
                                    .height(20.dp),
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
                                modifier = Modifier
                                    .width(34.dp)
                                    .height(20.dp),
                                contentDescription = "Patron dump profile.",
                            )
                        }

                        Spacer(modifier = Modifier.weight(0.5f))

                        IconButton(
                            onClick = {},
                            modifier = Modifier.weight(1f),
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.icon_search),
                                contentDescription = "Patron search.",
                                modifier = Modifier
                                    .width(34.dp)
                                    .height(20.dp),
                                colorFilter = ColorFilter.tint(Color.White),
                            )
                        }

                        Spacer(modifier = Modifier.weight(0.5f))

                        IconButton(
                            onClick = {},
                            modifier = Modifier.weight(1f),
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.icon_menu),
                                contentDescription = "Patron menu.",
                                modifier = Modifier
                                    .width(34.dp)
                                    .height(20.dp),
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
                .padding(start = 8.dp)
                .verticalScroll(vtScrollState)
                .fillMaxSize(),
        ) {
            Spacer(modifier = Modifier.height(80.dp))

            Text(
                text = "추천 큐레이션",
                color = Title,
                fontWeight = FontWeight(700),
                fontSize = 20.sp,
            )

            Column(
                modifier = Modifier.padding(
                        top = 8.dp, bottom = 40.dp
                    ),
            ) {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                ) {
                    items(itemsList.size) {
                        Column(
                            modifier = Modifier.background(Color.Green),
                        ) {
                            Box {
                                Image(
                                    painter = painterResource(id = R.drawable.img_empty),
                                    contentDescription = "",
                                )

                                Icon(
                                    painter = painterResource(id = R.drawable.icon_exhibition),
                                    contentDescription = "",
                                    modifier = Modifier
                                        .align(Alignment.TopEnd)
                                        .padding(4.dp),
                                    tint = Color.White,
                                )

                                Text(
                                    text = "1/8",
                                    modifier = Modifier
                                        .align(Alignment.BottomEnd)
                                        .padding(4.dp)
                                        .background(BoxText),
                                    color = Title,
                                    fontWeight = FontWeight(700),
                                    fontSize = 8.sp,
                                )
                            }

                            Text(
                                text = "&작품명",
                                modifier = Modifier
                                    .padding(bottom = 4.dp)
                                    .background(Color.Red),
                                color = Title,
                                fontWeight = FontWeight(500),
                                fontSize = 16.sp,
                                textAlign = TextAlign.Center,
                            )
                            Text(
                                text = "&작가명 외 1명",
                                modifier = Modifier.padding(bottom = 4.dp),
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
                        } // 아이템 구성 UI
                    } // 뷰 모델에서 잔달받은 콘텐츠 사이즈만큼 아이템 생성
                } // 추천 큐레이션 Row 리스트
            } // 추천 큐레이션 UI

            Text(
                text = "새로운 아트워크",
                color = Title,
                fontWeight = FontWeight(700),
                fontSize = 20.sp,
            )

            Column(
                modifier = Modifier.padding(
                        top = 8.dp, bottom = 40.dp
                    ),
            ) {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                ) {
                    items(itemsList.size) {
                        Column {
                            Box {
                                Image(
                                    painter = painterResource(id = R.drawable.img_empty),
                                    contentDescription = "",
                                )

                                Text(
                                    text = "신규",
                                    modifier = Modifier
                                        .align(Alignment.TopStart)
                                        .padding(4.dp)
                                        .background(BoxText),
                                    color = Title,
                                    fontWeight = FontWeight(700),
                                    fontSize = 8.sp,
                                )
                            }

                            Text(
                                text = "&작품명",
                                modifier = Modifier.padding(bottom = 4.dp),
                                color = Title,
                                fontWeight = FontWeight(500),
                                fontSize = 16.sp,
                            )
                            Text(
                                text = "&작가명 외 1명",
                                modifier = Modifier.padding(bottom = 4.dp),
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
                        } // 아이템 구성 UI
                    } // 뷰 모델에서 잔달받은 콘텐츠 사이즈만큼 아이템 생성
                } // 새로운 아트워크 Row 리스트
            } // 새로운 아트워크 UI

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

            Column(
                modifier = Modifier.padding(
                        top = 8.dp, bottom = 40.dp
                    ),
            ) {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                ) {
                    items(itemsList.size) {
                        Column {
                            Box {
                                Image(
                                    painter = painterResource(id = R.drawable.img_empty),
                                    contentDescription = "",
                                )
                            }

                            Text(
                                text = "&아트워크 타이틀",
                                modifier = Modifier.padding(bottom = 4.dp),
                                color = Title,
                                fontWeight = FontWeight(500),
                                fontSize = 16.sp,
                            )
                            Text(
                                text = "&아티스트 타이틀",
                                modifier = Modifier.padding(bottom = 4.dp),
                                color = SubTitle,
                                fontWeight = FontWeight(400),
                                fontSize = 14.sp,
                            )
                        } // 아이템 구성 UI
                    } // 뷰 모델에서 잔달받은 콘텐츠 사이즈만큼 아이템 생성
                } // 커피 한 잔 생각날 때 Row 리스트
            } // 커피 한 잔 생각날 때 UI

            Text(
                text = "Jazz Today",
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

            Column(
                modifier = Modifier.padding(
                        top = 8.dp, bottom = 40.dp
                    ),
            ) {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                ) {
                    items(itemsList.size) {
                        Column {
                            Box {
                                Image(
                                    painter = painterResource(id = R.drawable.img_empty),
                                    contentDescription = "",
                                )
                            }

                            Text(
                                text = "&아트워크 타이틀",
                                modifier = Modifier.padding(bottom = 4.dp),
                                color = Title,
                                fontWeight = FontWeight(500),
                                fontSize = 16.sp,
                            )
                            Text(
                                text = "&아티스트 타이틀",
                                modifier = Modifier.padding(bottom = 4.dp),
                                color = SubTitle,
                                fontWeight = FontWeight(400),
                                fontSize = 14.sp,
                            )
                        } // 아이템 구성 UI
                    } // 뷰 모델에서 잔달받은 콘텐츠 사이즈만큼 아이템 생성
                } // Jazz Today Row 리스트
            } // Jazz Today UI

            Text(
                text = "공개예정 큐레이션", color = Title, fontWeight = FontWeight(700), fontSize = 20.sp
            )

            Column(
                modifier = Modifier.padding(
                        top = 8.dp, bottom = 40.dp
                    ),
            ) {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                ) {
                    items(itemsList.size) {
                        Column {
                            Box {
                                Image(
                                    painter = painterResource(id = R.drawable.img_empty),
                                    contentDescription = "",
                                )

                                Text(
                                    text = "D-7",
                                    modifier = Modifier
                                        .align(Alignment.TopStart)
                                        .padding(4.dp)
                                        .background(BoxText),
                                    color = Title,
                                    fontWeight = FontWeight(700),
                                    fontSize = 8.sp,
                                )

                                Icon(
                                    painter = painterResource(id = R.drawable.icon_exhibition),
                                    contentDescription = "",
                                    modifier = Modifier
                                        .align(Alignment.TopEnd)
                                        .padding(4.dp),
                                    tint = Color.White,
                                )
                            }

                            Text(
                                text = "&아트워크 타이틀",
                                modifier = Modifier.padding(bottom = 4.dp),
                                color = Title,
                                fontWeight = FontWeight(500),
                                fontSize = 16.sp,
                            )
                            Text(
                                text = "&아티스트 타이틀",
                                modifier = Modifier.padding(bottom = 4.dp),
                                color = SubTitle,
                                fontWeight = FontWeight(400),
                                fontSize = 14.sp,
                            )

                            Button(onClick = { }) {
                                Text(
                                    text = "저장",
                                    color = Color.White,
                                    fontWeight = FontWeight(500),
                                    fontSize = 14.sp,
                                )
                            }
                        } // 아이템 구성 UI
                    } // 뷰 모델에서 잔달받은 콘텐츠 사이즈만큼 아이템 생성
                } // 공개예정 큐레이션 Row 리스트
            } // 공개예정 큐레이션 UI

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

            Column(
                modifier = Modifier.padding(
                        top = 8.dp, bottom = 40.dp
                    ),
            ) {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                ) {
                    items(itemsList.size) {
                        Column {
                            Box {
                                Image(
                                    painter = painterResource(id = R.drawable.img_empty),
                                    contentDescription = "",
                                )
                            }

                            Text(
                                text = "&아트워크 타이틀",
                                modifier = Modifier.padding(bottom = 4.dp),
                                color = Title,
                                fontWeight = FontWeight(500),
                                fontSize = 16.sp,
                            )
                            Text(
                                text = "&아티스트 타이틀",
                                modifier = Modifier.padding(bottom = 4.dp),
                                color = SubTitle,
                                fontWeight = FontWeight(400),
                                fontSize = 14.sp,
                            )
                        } // 아이템 구성 UI
                    } // 뷰 모델에서 잔달받은 콘텐츠 사이즈만큼 아이템 생성
                } // 봄의 아침을 맞이하며 Row 리스트
            } // 봄의 아침을 맞이하며 UI

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

            Column(
                modifier = Modifier.padding(
                        top = 8.dp, bottom = 40.dp
                    ),
            ) {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                ) {
                    items(itemsList.size) {
                        Column {
                            Box {
                                Image(
                                    painter = painterResource(id = R.drawable.img_empty),
                                    contentDescription = "",
                                )
                            }

                            Text(
                                text = "&아트워크 타이틀",
                                modifier = Modifier.padding(bottom = 4.dp),
                                color = Title,
                                fontWeight = FontWeight(500),
                                fontSize = 16.sp,
                            )
                            Text(
                                text = "&아티스트 타이틀",
                                modifier = Modifier.padding(bottom = 4.dp),
                                color = SubTitle,
                                fontWeight = FontWeight(400),
                                fontSize = 14.sp,
                            )
                        } // 아이템 구성 UI
                    } // 뷰 모델에서 잔달받은 콘텐츠 사이즈만큼 아이템 생성
                } // 집중의 시간 Row 리스트
            } // 집중의 시간 UI

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

            Column(
                modifier = Modifier.padding(
                        top = 8.dp, bottom = 40.dp
                    ),
            ) {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                ) {
                    items(itemsList.size) {
                        Column {
                            Box {
                                Image(
                                    painter = painterResource(id = R.drawable.img_empty),
                                    contentDescription = "",
                                )
                            }

                            Text(
                                text = "&아트워크 타이틀",
                                modifier = Modifier.padding(bottom = 4.dp),
                                color = Title,
                                fontWeight = FontWeight(500),
                                fontSize = 16.sp,
                            )
                            Text(
                                text = "&아티스트 타이틀",
                                modifier = Modifier.padding(bottom = 4.dp),
                                color = SubTitle,
                                fontWeight = FontWeight(400),
                                fontSize = 14.sp,
                            )
                        } // 아이템 구성 UI
                    } // 뷰 모델에서 잔달받은 콘텐츠 사이즈만큼 아이템 생성
                } // 내적 Groove 좀 타볼까요 Row 리스트
            } // 내적 Groove 좀 타볼까요 UI

            Button(
                onClick = {},
                modifier = Modifier
                    .padding(bottom = 40.dp)
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
            } // 모든 아트워크 버튼 UI

            Text(
                text = "추천 아티스트",
                color = Title,
                fontWeight = FontWeight(700),
                fontSize = 20.sp,
            )

            Column(
                modifier = Modifier
                    .padding(
                        top = 8.dp, bottom = 40.dp
                    )
                    .fillMaxWidth(),
            ) {
                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                ) {
                    items(itemsList.size) {
                        Column {
                            Box {
                                Image(
                                    painter = painterResource(id = R.drawable.img_empty),
                                    contentDescription = "",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .size(200.dp)
                                        .clip(CircleShape),
                                )
                            }

                            Text(
                                text = "&아티스트 타이틀",
                                modifier = Modifier.padding(bottom = 4.dp),
                                color = Title,
                                fontWeight = FontWeight(500),
                                fontSize = 16.sp,
                                textAlign = TextAlign.Center,
                            )
                        } // 아이템 구성 UI
                    } // 뷰 모델에서 잔달받은 콘텐츠 사이즈만큼 아이템 생성
                } // 추천 아티스트 Row 리스트
            } // 추천 아티스트 UI

            Button(
                onClick = {},
                modifier = Modifier
                    .padding(bottom = 40.dp)
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
            } // 모든 아티스트 버튼 UI

            Box(
                modifier = Modifier.background(Color.White),
            ) {
                Column(
                    modifier = Modifier
                        .padding(
                            top = 40.dp, bottom = 40.dp, start = 20.dp, end = 20.dp
                        )
                        .fillMaxWidth(),
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(
                            17.dp, alignment = Alignment.Start
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
                            text = "사업자등록번호 : 489-88-00555 | 대표이사 : 이원준 |  통신판매업신고 : 제2017-제주이도2-0100호 사업자정보확인\n" + " 주소 : 서울특별시 서대문구 연희로 134-1 제임스빌 5층 | 대표전화 : 070 7724 1703",
                            color = FooterSubTitle,
                        )

                        Spacer(
                            modifier = Modifier.padding(top = 8.dp),
                        )

                        Text(
                            text = "고객 help@patron.digital ㅣ 작가 artist@patron.digital\n" + "전화 070-7724-1703 (주중 09:00 ~ 17:00)",
                            color = FooterSubTitle,
                        )
                    }
                } // 풋터 본문 레이아웃 끝
            } // 풋터 전체 영역 레이아웃 끝
        } // 메인페이지 상단 바 / 본문 / 풋터 구조를 잡기위한 레이아웃 끝
    } // Scaffold function end
} // MainView function end