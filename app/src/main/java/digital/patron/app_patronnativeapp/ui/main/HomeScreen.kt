package digital.patron.app_patronnativeapp.ui.main

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import coil.compose.AsyncImage

import digital.patron.app_patronnativeapp.R
import digital.patron.app_patronnativeapp.ui.common.HomeContentsReady

import digital.patron.app_patronnativeapp.ui.theme.BoxText
import digital.patron.app_patronnativeapp.ui.theme.FooterSubTitle
import digital.patron.app_patronnativeapp.ui.theme.FooterTitle
import digital.patron.app_patronnativeapp.ui.theme.HomeButton
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
fun HomeView(
    viewModel: HomeViewModel,
    navController: NavController,
) {
    val vtScrollState = rememberScrollState()

    val textStateFlow = viewModel.dataFlow.collectAsState().value

    // 추천 큐레이션 UI 데이터
    val itemsCurationThumb = viewModel.curationThumb.value
    val itemsCurationArtworkTitle = viewModel.curationArtworkTitle.value
    val itemsCurationArtistName = viewModel.curationArtistName.value
    val itemsCurationArtistCount = viewModel.curationArtistCount.value

    // 공개예정 큐레이션 UI 데이터
    val itemsWaitingThumbnail = viewModel.waitingThumbnail.value
    val itemsWaitingThumbArtworkTitle = viewModel.waitingThumbArtworkTitle.value
    val itemsWaitingArtistName = viewModel.waitingArtistName.value
    val itemsWaitingArtistCount = viewModel.waitingArtistCount.value

    // 새로운 아트워크 UI 데이터
    val itemsNewlyArtwork = viewModel.newlyArtworks.value

    // 테마1 UI 데이터
    val itemsTheme1ExhibitionTitle = viewModel.theme1ExhibitionTitle.value
    val itemsTheme1Thumbnail = viewModel.theme1Thumbnail.value
    val itemsTheme1ThumbArtworkTitle = viewModel.theme1ThumbArtworkTitle.value
    val itemsTheme1ThumbArtistTitle = viewModel.theme1ThumbArtistTitle.value

    // 테마2 UI 데이터
    val itemsTheme2ExhibitionTitle = viewModel.theme2ExhibitionTitle.value
    val itemsTheme2Thumbnail = viewModel.theme2Thumbnail.value
    val itemsTheme2ThumbArtworkTitle = viewModel.theme2ThumbArtworkTitle.value
    val itemsTheme2ThumbArtistTitle = viewModel.theme2ThumbArtistTitle.value

    // 테마3 UI 데이터
    val itemsTheme3ExhibitionTitle = viewModel.theme3ExhibitionTitle.value
    val itemsTheme3Thumbnail = viewModel.theme3Thumbnail.value
    val itemsTheme3ThumbArtworkTitle = viewModel.theme3ThumbArtworkTitle.value
    val itemsTheme3ThumbArtistTitle = viewModel.theme3ThumbArtistTitle.value

    // 테마4 UI 데이터
    val itemsTheme4ExhibitionTitle = viewModel.theme4ExhibitionTitle.value
    val itemsTheme4Thumbnail = viewModel.theme4Thumbnail.value
    val itemsTheme4ThumbArtworkTitle = viewModel.theme4ThumbArtworkTitle.value
    val itemsTheme4ThumbArtistTitle = viewModel.theme4ThumbArtistTitle.value

    // 테마5 UI 데이터
    val itemsTheme5ExhibitionTitle = viewModel.theme5ExhibitionTitle.value
    val itemsTheme5Thumbnail = viewModel.theme5Thumbnail.value
    val itemsTheme5ThumbArtworkTitle = viewModel.theme5ThumbArtworkTitle.value
    val itemsTheme5ThumbArtistTitle = viewModel.theme5ThumbArtistTitle.value

    // 추천 아티스트 UI 데이터
    val itemsArtistProfileImage = viewModel.artistProfileImage.value
    val itemsArtistNameRecommend =
        viewModel.artistNameRecommend.value

    val showDialog = remember { mutableStateOf(false) }
    if (showDialog.value) {
        HomeContentsReady(
            visible = showDialog.value,
            onDismissRequest = { showDialog.value = false })
    }


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
                    items(itemsCurationThumb.size) { it ->
                        Column {
                            Box {
                                AsyncImage(
                                    model = itemsCurationThumb[it],
                                    contentDescription = "추천 큐레이션",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .size(320.dp, 180.dp)
                                        .clip(RoundedCornerShape(16.dp))
                                        .clickable {
                                            navController.navigate("player")
                                        },
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
                                    text = "${it + 1}/8",
                                    modifier = Modifier
                                        .width(50.dp)
                                        .align(Alignment.BottomEnd)
                                        .padding(8.dp)
                                        .background(
                                            color = BoxText,
                                            shape = RoundedCornerShape(8.dp)
                                        ),
                                    color = Title,
                                    fontWeight = FontWeight(700),
                                    fontSize = 12.sp,
                                    textAlign = TextAlign.Center,
                                )
                            }

                            Text(
                                text = itemsCurationArtworkTitle[it],
                                modifier = Modifier.padding(
                                    bottom = 4.dp, top = 4.dp
                                ),
                                color = Title,
                                fontWeight = FontWeight(500),
                                fontSize = 16.sp,
                            )
                            if (itemsCurationArtistCount[it] > 0) {
                                Text(
                                    text = "${itemsCurationArtistName[it]} 외 ${itemsCurationArtistCount[it]}명",
                                    modifier = Modifier.padding(bottom = 4.dp),
                                    color = SubTitle,
                                    fontWeight = FontWeight(400),
                                    fontSize = 14.sp,
                                )
                            } else {
                                Text(
                                    text = itemsCurationArtistName[it],
                                    modifier = Modifier.padding(bottom = 4.dp),
                                    color = SubTitle,
                                    fontWeight = FontWeight(400),
                                    fontSize = 14.sp,
                                )
                            }

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
                    items(itemsNewlyArtwork.size) { it ->
                        Column {
                            Box {
                                AsyncImage(
                                    model = itemsNewlyArtwork[it],
                                    contentDescription = "새로운 아트워크",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .size(154.dp)
                                        .clip(RoundedCornerShape(16.dp)),
                                )
                                Text(
                                    text = "신규",
                                    modifier = Modifier
                                        .width(50.dp)
                                        .align(Alignment.BottomEnd)
                                        .padding(8.dp)
                                        .background(
                                            color = BoxText,
                                            shape = RoundedCornerShape(8.dp)
                                        ),
                                    color = Title,
                                    fontWeight = FontWeight(700),
                                    fontSize = 12.sp,
                                    textAlign = TextAlign.Center,
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
                text = itemsTheme1ExhibitionTitle,
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
                    items(itemsTheme1Thumbnail.size) {
                        Column {
                            Box {
                                AsyncImage(
                                    model = itemsTheme1Thumbnail[it],
                                    contentDescription = "테마1",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .size(154.dp)
                                        .clip(RoundedCornerShape(16.dp)),
                                )
                            }

                            Text(
                                text = itemsTheme1ThumbArtworkTitle[it],
                                modifier = Modifier
                                    .padding(
                                        top = 4.dp, bottom = 4.dp
                                    )
                                    .width(154.dp),
                                color = Title,
                                fontWeight = FontWeight(500),
                                fontSize = 16.sp,
                                overflow = TextOverflow.Ellipsis,
                                maxLines = 1,
                            )
                            Text(
                                text = itemsTheme1ThumbArtistTitle[it],
                                modifier = Modifier
                                    .padding(bottom = 4.dp)
                                    .width(154.dp),
                                color = SubTitle,
                                fontWeight = FontWeight(400),
                                fontSize = 14.sp,
                                overflow = TextOverflow.Ellipsis,
                                maxLines = 1,
                            )
                        } // 아이템 구성 UI
                    } // 뷰 모델에서 잔달받은 콘텐츠 사이즈만큼 아이템 생성
                } // 테마1 Row 리스트
            } // 테마1 UI 끝

            Text(
                text = itemsTheme2ExhibitionTitle,
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
                    items(itemsTheme2Thumbnail.size) {
                        Column {
                            Box {
                                AsyncImage(
                                    model = itemsTheme2Thumbnail[it],
                                    contentDescription = "테마2",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .size(154.dp)
                                        .clip(RoundedCornerShape(16.dp)),
                                )
                            }

                            Text(
                                text = itemsTheme2ThumbArtworkTitle[it],
                                modifier = Modifier
                                    .padding(
                                        top = 4.dp,
                                        bottom = 4.dp
                                    )
                                    .width(154.dp),
                                color = Title,
                                fontWeight = FontWeight(500),
                                fontSize = 16.sp,
                                overflow = TextOverflow.Ellipsis,
                                maxLines = 1,
                            )
                            Text(
                                text = itemsTheme2ThumbArtistTitle[it],
                                modifier = Modifier
                                    .padding(bottom = 4.dp)
                                    .width(154.dp),
                                color = SubTitle,
                                fontWeight = FontWeight(400),
                                fontSize = 14.sp,
                                overflow = TextOverflow.Ellipsis,
                                maxLines = 1,
                            )
                        } // 아이템 구성 UI
                    } // 뷰 모델에서 잔달받은 콘텐츠 사이즈만큼 아이템 생성
                } // 테마2 Row 리스트
            } // 테마2 UI 끝

            Text(
                text = "공개예정 큐레이션",
                color = Title,
                fontWeight = FontWeight(700),
                fontSize = 20.sp
            )

            Column(
                modifier = Modifier
                    .padding(
                        top = 8.dp, bottom = 40.dp
                    ),
            ) {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                ) {
                    items(itemsWaitingThumbnail.size) {
                        Column {
                            Box {
                                AsyncImage(
                                    model = itemsWaitingThumbnail[it],
                                    contentDescription = "공개예정 큐레이션",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .size(320.dp, 180.dp)
                                        .clip(RoundedCornerShape(16.dp))
                                        .clickable {
                                            navController.navigate("player")
                                        },
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

                            Row(
                                horizontalArrangement = Arrangement.SpaceBetween,
                                modifier = Modifier.width(320.dp),
                            ) {
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                ) {
                                    Column(
                                        modifier = Modifier
                                            .align(Alignment.CenterStart),
                                    ) {
                                        Text(
                                            text = itemsWaitingThumbArtworkTitle[it],
                                            modifier = Modifier
                                                .padding(
                                                    top = 4.dp,
                                                    bottom = 4.dp
                                                )
                                                .width(250.dp),
                                            color = Title,
                                            fontWeight = FontWeight(500),
                                            fontSize = 16.sp,
                                            overflow = TextOverflow.Ellipsis,
                                            maxLines = 1,
                                        )

                                        if (itemsWaitingArtistCount[it] > 0) {
                                            Text(
                                                text = "${itemsWaitingArtistName[it]} 외 ${itemsWaitingArtistCount[it]}명",
                                                modifier = Modifier
                                                    .padding(bottom = 4.dp)
                                                    .width(250.dp),
                                                color = SubTitle,
                                                fontWeight = FontWeight(400),
                                                fontSize = 14.sp,
                                                overflow = TextOverflow.Ellipsis,
                                                maxLines = 1,
                                            )
                                        } else {
                                            Text(
                                                text = itemsWaitingArtistName[it],
                                                modifier = Modifier
                                                    .padding(bottom = 4.dp)
                                                    .width(250.dp),
                                                color = SubTitle,
                                                fontWeight = FontWeight(400),
                                                fontSize = 14.sp,
                                                overflow = TextOverflow.Ellipsis,
                                                maxLines = 1,
                                            )
                                        }


                                    }
                                    Button(
                                        onClick = {},
                                        modifier = Modifier
                                            .align(Alignment.CenterEnd),
                                        shape = RoundedCornerShape(8.dp),
                                        colors = ButtonDefaults.buttonColors(Color.Blue),
                                    ) {
                                        Text(
                                            text = "저장",
                                            color = Color.White,
                                            fontWeight = FontWeight(500),
                                            fontSize = 14.sp,
                                        )
                                    }
                                }
                            }
                        }
                    } // 아이템 구성 UI
                } // 뷰 모델에서 잔달받은 콘텐츠 사이즈만큼 아이템 생성
            } // 공개예정 큐레이션 UI 끝

            Text(
                text = itemsTheme3ExhibitionTitle,
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
                    items(itemsTheme3Thumbnail.size) {
                        Column {
                            Box {
                                AsyncImage(
                                    model = itemsTheme3Thumbnail[it],
                                    contentDescription = "테마3",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .size(154.dp)
                                        .clip(RoundedCornerShape(16.dp)),
                                )
                            }

                            Text(
                                text = itemsTheme3ThumbArtworkTitle[it],
                                modifier = Modifier
                                    .padding(
                                        top = 4.dp,
                                        bottom = 4.dp
                                    )
                                    .width(154.dp),
                                color = Title,
                                fontWeight = FontWeight(500),
                                fontSize = 16.sp,
                                overflow = TextOverflow.Ellipsis,
                                maxLines = 1,
                            )
                            Text(
                                text = itemsTheme3ThumbArtistTitle[it],
                                modifier = Modifier.padding(bottom = 4.dp),
                                color = SubTitle,
                                fontWeight = FontWeight(400),
                                fontSize = 14.sp,
                                overflow = TextOverflow.Ellipsis,
                                maxLines = 1,
                            )
                        } // 아이템 구성 UI
                    } // 뷰 모델에서 잔달받은 콘텐츠 사이즈만큼 아이템 생성
                } // 테마3 Row 리스트
            } // 테마3 UI

            Text(
                text = itemsTheme4ExhibitionTitle,
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
                    items(itemsTheme4Thumbnail.size) {
                        Column {
                            Box {
                                AsyncImage(
                                    model = itemsTheme4Thumbnail[it],
                                    contentDescription = "테마4",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .size(154.dp)
                                        .clip(RoundedCornerShape(16.dp)),
                                )
                            }

                            Text(
                                text = itemsTheme4ThumbArtworkTitle[it],
                                modifier = Modifier
                                    .padding(
                                        top = 4.dp,
                                        bottom = 4.dp
                                    )
                                    .width(154.dp),
                                color = Title,
                                fontWeight = FontWeight(500),
                                fontSize = 16.sp,
                                overflow = TextOverflow.Ellipsis,
                                maxLines = 1,
                            )
                            Text(
                                text = itemsTheme4ThumbArtistTitle[it],
                                modifier = Modifier.padding(bottom = 4.dp),
                                color = SubTitle,
                                fontWeight = FontWeight(400),
                                fontSize = 14.sp,
                                overflow = TextOverflow.Ellipsis,
                                maxLines = 1,
                            )
                        } // 아이템 구성 UI
                    } // 뷰 모델에서 잔달받은 콘텐츠 사이즈만큼 아이템 생성
                } // 테마4 Row 리스트
            } // 테마4 UI 끝

            Text(
                text = itemsTheme5ExhibitionTitle,
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
                    items(itemsTheme5Thumbnail.size) {
                        Column {
                            Box {
                                AsyncImage(
                                    model = itemsTheme5Thumbnail[it],
                                    contentDescription = "테마5",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .size(154.dp)
                                        .clip(RoundedCornerShape(16.dp)),
                                )
                            }

                            Text(
                                text = itemsTheme5ThumbArtworkTitle[it],
                                modifier = Modifier
                                    .padding(
                                        top = 4.dp,
                                        bottom = 4.dp
                                    )
                                    .width(154.dp),
                                color = Title,
                                fontWeight = FontWeight(500),
                                fontSize = 16.sp,
                                overflow = TextOverflow.Ellipsis,
                                maxLines = 1,
                            )
                            Text(
                                text = itemsTheme5ThumbArtistTitle[it],
                                modifier = Modifier.padding(bottom = 4.dp),
                                color = SubTitle,
                                fontWeight = FontWeight(400),
                                fontSize = 14.sp,
                                overflow = TextOverflow.Ellipsis,
                                maxLines = 1,
                            )
                        } // 아이템 구성 UI
                    } // 뷰 모델에서 잔달받은 콘텐츠 사이즈만큼 아이템 생성
                } // 테마5 Row 리스트
            } // 테마5 UI 끝

            Button(
                onClick = {},
                modifier = Modifier
                    .padding(bottom = 40.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(HomeButton),
            ) {
                Text(
                    text = "모든 아트워크",
                    modifier = Modifier
                        .padding(top = 8.dp, bottom = 8.dp),
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
                        top = 8.dp, bottom = 60.dp
                    )
                    .fillMaxWidth(),
            ) {
                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                ) {
                    items(itemsArtistProfileImage.size) { it ->
                        Column {
                            Box {
                                AsyncImage(
                                    model = itemsArtistProfileImage[it],
                                    contentDescription = "추천 아티스트",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .size(154.dp)
                                        .clip(CircleShape),
                                )
                            }

                            Text(
                                text = itemsArtistNameRecommend[it],
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
                onClick = {
                },
                modifier = Modifier
                    .padding(bottom = 40.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(HomeButton),
            ) {
                Text(
                    text = "모든 아티스트",
                    modifier = Modifier
                        .padding(top = 8.dp, bottom = 8.dp),
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


@Preview(showBackground = true)
@Composable
fun HomeView() {
    val itemsList = (1..15).toList()

    Column(
        modifier = Modifier
            .padding(
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

                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.width(320.dp),
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth(),
                        ) {
                            Column(
                                modifier = Modifier
                                    .align(Alignment.CenterStart),
                            ) {
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
                            }
                            Button(
                                onClick = {},
                                modifier = Modifier
                                    .align(Alignment.CenterEnd),
                                shape = RoundedCornerShape(8.dp),
                                colors = ButtonDefaults.buttonColors(Color.Blue),
                            ) {
                                Text(
                                    text = "저장",
                                    color = Color.White,
                                    fontWeight = FontWeight(500),
                                    fontSize = 14.sp,
                                )
                            }
                        }
                    }
                }
            } // 아이템 구성 UI
        } // 뷰 모델에서 잔달받은 콘텐츠 사이즈만큼 아이템 생성
    } // 공개예정 큐레이션 UI
}