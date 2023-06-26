package digital.patron.app_patronnativeapp.ui.player.curation

import android.annotation.SuppressLint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import digital.patron.app_patronnativeapp.R
import digital.patron.app_patronnativeapp.ui.theme.SubTitle
import digital.patron.app_patronnativeapp.ui.theme.Title

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@ExperimentalMaterial3Api
@Composable
fun CurationView() {
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
                                painter = painterResource(id = R.drawable.icon_go_back),
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
                                painter = painterResource(id = R.drawable.icon_library),
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
                .verticalScroll(vtScrollState)
                .fillMaxSize(),
        ) {

            Spacer(modifier = Modifier.height(80.dp))

            Box(
                modifier = Modifier
                    .height(360.dp)
                    .fillMaxWidth(),
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img_empty),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize(),
                )

                IconButton(
                    onClick = {},
                    modifier = Modifier
                        .align(Center),
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.icon_player_play),
                        contentDescription = "Player Run.",
                        modifier = Modifier
                            .size(56.dp),
                        colorFilter = ColorFilter.tint(Color.White),
                    )
                }
            } // 플레이어 UI 끝

            Text(
                text = "&큐레이션 타이틀",
                modifier = Modifier
                    .padding(top = 8.dp, start = 16.dp, end = 16.dp),
                color = Title,
                fontWeight = FontWeight(700),
                fontSize = 20.sp,
            )

            Text(
                text = "&작가이름",
                modifier = Modifier
                    .padding(top = 4.dp, start = 16.dp, end = 16.dp),
                color = SubTitle,
                fontWeight = FontWeight(400),
                fontSize = 16.sp,
            )

            Text(
                text = "&작품수 · &작품감상시간",
                modifier = Modifier
                    .padding(top = 4.dp, start = 16.dp, end = 16.dp),
                color = SubTitle,
                fontWeight = FontWeight(400),
                fontSize = 12.sp,
            )

            Text(
                text = "&작품인트로",
                modifier = Modifier
                    .padding(top = 4.dp, start = 16.dp, end = 16.dp),
                color = SubTitle,
                fontWeight = FontWeight(400),
                fontSize = 12.sp,
            )

            Row(
                modifier = Modifier
                    .padding(top = 16.dp, bottom = 16.dp, start = 16.dp, end = 16.dp)
                    .fillMaxWidth(),
            ) {
                IconButton(
                    onClick = {},
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.icon_save_collection),
                        contentDescription = "save collection.",
                        colorFilter = ColorFilter.tint(Color.White),
                    )
                }
                IconButton(
                    onClick = {},
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.icon_like),
                        contentDescription = "user like.",
                        colorFilter = ColorFilter.tint(Color.White),
                    )
                }
                IconButton(
                    onClick = {},
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.icon_share),
                        contentDescription = "user share.",
                        colorFilter = ColorFilter.tint(Color.White),
                    )
                }
                IconButton(
                    onClick = {},
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.icon_show_option_white),
                        contentDescription = "show option.",
                        colorFilter = ColorFilter.tint(Color.White),
                    )
                }
            } // 아이콘 UI 4개

            for (i in 1..15) {
                Row(
                    modifier = Modifier
                        .padding(start = 16.dp, end = 16.dp, bottom = 8.dp)
                        .height(45.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start,
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.img_empty),
                        contentDescription = "player list.",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(45.dp, 45.dp)
                            .clip(RoundedCornerShape(4.dp)),
                    )
                    Column(
                        modifier = Modifier
                            .align(CenterVertically)
                            .weight(0.7f)
                            .padding(start = 8.dp),
                    ) {
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
                    Image(
                        painter = painterResource(id = R.drawable.icon_show_option_white),
                        contentDescription = "player list.",
                        modifier = Modifier
                            .align(CenterVertically)
                            .weight(0.1f),
                        colorFilter = ColorFilter.tint(Color.White),
                    )
                }
            } // 아트워크 리스트 UI 끝

            Spacer(modifier = Modifier.height(32.dp))


            Text(
                text = "참여 아티스트",
                modifier = Modifier.padding(
                    bottom = 8.dp, start = 16.dp, end = 16.dp
                ),
                color = Title,
                fontWeight = FontWeight(500),
                fontSize = 18.sp,
            )
            LazyRow(
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                items(15) {
                    Column {
                        Image(
                            painter = painterResource(id = R.drawable.img_empty),
                            contentDescription = "",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(154.dp)
                                .clip(CircleShape),
                        )
                        Text(
                            text = "&아티스트 이름",
                            modifier = Modifier
                                .width(154.dp)
                                .padding(top = 4.dp),
                            color = Title,
                            fontWeight = FontWeight(500),
                            fontSize = 16.sp,
                            textAlign = TextAlign.Center,
                        )
                    }
                }
            }

            Spacer(
                modifier = Modifier
                    .height(80.dp)
            )

        } // 콘텐츠 전체 UI 끝
    } // Scaffold UI 끝
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun CureationView() {
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
                                painter = painterResource(id = R.drawable.icon_go_back),
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
                                painter = painterResource(id = R.drawable.icon_library),
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
    } // Scaffold UI 끝
}