package digital.patron.app_patronnativeapp.ui.search

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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import digital.patron.app_patronnativeapp.R
import digital.patron.app_patronnativeapp.ui.common.HomeContentsReady
import digital.patron.app_patronnativeapp.ui.theme.HomeButton
import digital.patron.app_patronnativeapp.ui.theme.SearchInputField
import digital.patron.app_patronnativeapp.ui.theme.SubTitle
import digital.patron.app_patronnativeapp.ui.theme.Title

@ExperimentalMaterial3Api
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SearchView(
    navController: NavController,
) {

    var searchText: String = ""

    val iconSearchBadge = @Composable {
        IconButton(
            onClick = {
                searchText = ""
            },
        ) {
            Image(
                painter = painterResource(id = R.drawable.icon_search),
                contentDescription = "search Icon.",
                colorFilter = ColorFilter.tint(Color.Gray),
            )
        }
    }

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
                            onClick = {
                                navController.navigate("home")
                            },
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
                .padding(start = 8.dp, end = 8.dp)
                .fillMaxSize(),
        ) {

            Spacer(modifier = Modifier.height(80.dp))

            Text(
                text = "검색",
                color = Title,
                fontWeight = FontWeight(700),
                fontSize = 32.sp,
            )
            TextField(
                value = searchText,
                onValueChange = { },
                modifier = Modifier
                    .padding(top = 8.dp, bottom = 8.dp)
                    .fillMaxWidth(),
                textStyle = TextStyle(color = SubTitle),
                placeholder = { Text(text = "어떤 예술을 찾으시나요") },
                leadingIcon = if (searchText.isBlank()) iconSearchBadge else null,
                colors = TextFieldDefaults.textFieldColors(containerColor = SearchInputField),
            )

            Text(
                text = "추천 검색어",
                modifier = Modifier
                    .padding(bottom = 8.dp),
                color = Title,
                fontWeight = FontWeight(500),
                fontSize = 14.sp,
            )

            Row(
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Button(
                    onClick = { },
                    modifier = Modifier
                        .weight(0.5f),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(HomeButton),
                ) {
                    Text(
                        text = "수채화",
                        modifier = Modifier
                            .padding(top = 4.dp, bottom = 4.dp),
                        color = Title,
                        fontWeight = FontWeight(500),
                        fontSize = 16.sp,
                    )
                }
                Button(
                    onClick = { },
                    modifier = Modifier
                        .weight(0.5f),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(HomeButton),
                ) {
                    Text(
                        text = "일러스트",
                        modifier = Modifier
                            .padding(top = 4.dp, bottom = 4.dp),
                        color = Title,
                        fontWeight = FontWeight(500),
                        fontSize = 16.sp,
                    )
                }
            }
            Row(
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Button(
                    onClick = { },
                    modifier = Modifier
                        .weight(0.5f),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(HomeButton),
                ) {
                    Text(
                        text = "정물화",
                        modifier = Modifier
                            .padding(top = 4.dp, bottom = 4.dp),
                        color = Title,
                        fontWeight = FontWeight(500),
                        fontSize = 16.sp,
                    )
                }
                Button(
                    onClick = { },
                    modifier = Modifier
                        .weight(0.5f),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(HomeButton),
                ) {
                    Text(
                        text = "신인상주의",
                        modifier = Modifier
                            .padding(top = 4.dp, bottom = 4.dp),
                        color = Title,
                        fontWeight = FontWeight(500),
                        fontSize = 16.sp,
                    )
                }
            }
            Row(
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Button(
                    onClick = { },
                    modifier = Modifier
                        .weight(0.5f),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(HomeButton),
                ) {
                    Text(
                        text = "배",
                        modifier = Modifier
                            .padding(top = 4.dp, bottom = 4.dp),
                        color = Title,
                        fontWeight = FontWeight(500),
                        fontSize = 16.sp,
                    )
                }
                Button(
                    onClick = { },
                    modifier = Modifier
                        .weight(0.5f),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(HomeButton),
                ) {
                    Text(
                        text = "가족",
                        modifier = Modifier
                            .padding(top = 4.dp, bottom = 4.dp),
                        color = Title,
                        fontWeight = FontWeight(500),
                        fontSize = 16.sp,
                    )
                }
            }
            Row(
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Button(
                    onClick = { },
                    modifier = Modifier
                        .weight(0.5f),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(HomeButton),
                ) {
                    Text(
                        text = "제주",
                        modifier = Modifier
                            .padding(top = 4.dp, bottom = 4.dp),
                        color = Title,
                        fontWeight = FontWeight(500),
                        fontSize = 16.sp,
                    )
                }
                Button(
                    onClick = { },
                    modifier = Modifier
                        .weight(0.5f),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(HomeButton),
                ) {
                    Text(
                        text = "산",
                        modifier = Modifier
                            .padding(top = 4.dp, bottom = 4.dp),
                        color = Title,
                        fontWeight = FontWeight(500),
                        fontSize = 16.sp,
                    )
                }
            }
            Row(
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Button(
                    onClick = { },
                    modifier = Modifier
                        .weight(0.5f),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(HomeButton),
                ) {
                    Text(
                        text = "서양화",
                        modifier = Modifier
                            .padding(top = 4.dp, bottom = 4.dp),
                        color = Title,
                        fontWeight = FontWeight(500),
                        fontSize = 16.sp,
                    )
                }
                Button(
                    onClick = { },
                    modifier = Modifier
                        .weight(0.5f),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(HomeButton),
                ) {
                    Text(
                        text = "한국화",
                        modifier = Modifier
                            .padding(top = 4.dp, bottom = 4.dp),
                        color = Title,
                        fontWeight = FontWeight(500),
                        fontSize = 16.sp,
                    )
                }
            }
            Row(
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Button(
                    onClick = { },
                    modifier = Modifier
                        .weight(0.5f),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(HomeButton),
                ) {
                    Text(
                        text = "서양화",
                        modifier = Modifier
                            .padding(top = 4.dp, bottom = 4.dp),
                        color = Title,
                        fontWeight = FontWeight(500),
                        fontSize = 16.sp,
                    )
                }
                Button(
                    onClick = { },
                    modifier = Modifier
                        .weight(0.5f),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(HomeButton),
                ) {
                    Text(
                        text = "한국화",
                        modifier = Modifier
                            .padding(top = 4.dp, bottom = 4.dp),
                        color = Title,
                        fontWeight = FontWeight(500),
                        fontSize = 16.sp,
                    )
                }
            }
        } // 본문 콘텐츠 UI 끝
    } // Scaffold UI 끝
}

@ExperimentalMaterial3Api
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview(showBackground = true)
@Composable
fun SearchView() {

    var searchText: String = ""

    val iconViewtest = @Composable {
        IconButton(
            onClick = {
                searchText = ""
            },
        ) {
            Image(
                painter = painterResource(id = R.drawable.icon_search),
                contentDescription = "search Icon.",
                colorFilter = ColorFilter.tint(Color.Gray),
            )
        }
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
                .padding(start = 8.dp, end = 8.dp)
                .fillMaxSize(),
        ) {

            Spacer(modifier = Modifier.height(80.dp))

            Text(
                text = "검색",
                color = Title,
                fontWeight = FontWeight(700),
                fontSize = 32.sp,
            )
            TextField(
                value = searchText,
                onValueChange = { },
                modifier = Modifier
                    .padding(top = 8.dp, bottom = 8.dp)
                    .fillMaxWidth(),
                textStyle = TextStyle(color = SubTitle),
                placeholder = { Text(text = "어떤 예술을 찾으시나요") },
                leadingIcon = if (searchText.isBlank()) iconViewtest else null,
                colors = TextFieldDefaults.textFieldColors(containerColor = SearchInputField),
            )

            Text(
                text = "추천 검색어",
                modifier = Modifier
                    .padding(bottom = 8.dp),
                color = Title,
                fontWeight = FontWeight(500),
                fontSize = 14.sp,
            )

            Row(
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Button(
                    onClick = { },
                    modifier = Modifier
                        .weight(0.5f),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(HomeButton),
                ) {
                    Text(
                        text = "수채화",
                        modifier = Modifier
                            .padding(top = 4.dp, bottom = 4.dp),
                        color = Title,
                        fontWeight = FontWeight(500),
                        fontSize = 16.sp,
                    )
                }
                Button(
                    onClick = { },
                    modifier = Modifier
                        .weight(0.5f),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(HomeButton),
                ) {
                    Text(
                        text = "일러스트",
                        modifier = Modifier
                            .padding(top = 4.dp, bottom = 4.dp),
                        color = Title,
                        fontWeight = FontWeight(500),
                        fontSize = 16.sp,
                    )
                }
            }
            Row(
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Button(
                    onClick = { },
                    modifier = Modifier
                        .weight(0.5f),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(HomeButton),
                ) {
                    Text(
                        text = "정물화",
                        modifier = Modifier
                            .padding(top = 4.dp, bottom = 4.dp),
                        color = Title,
                        fontWeight = FontWeight(500),
                        fontSize = 16.sp,
                    )
                }
                Button(
                    onClick = { },
                    modifier = Modifier
                        .weight(0.5f),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(HomeButton),
                ) {
                    Text(
                        text = "신인상주의",
                        modifier = Modifier
                            .padding(top = 4.dp, bottom = 4.dp),
                        color = Title,
                        fontWeight = FontWeight(500),
                        fontSize = 16.sp,
                    )
                }
            }
            Row(
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Button(
                    onClick = { },
                    modifier = Modifier
                        .weight(0.5f),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(HomeButton),
                ) {
                    Text(
                        text = "배",
                        modifier = Modifier
                            .padding(top = 4.dp, bottom = 4.dp),
                        color = Title,
                        fontWeight = FontWeight(500),
                        fontSize = 16.sp,
                    )
                }
                Button(
                    onClick = { },
                    modifier = Modifier
                        .weight(0.5f),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(HomeButton),
                ) {
                    Text(
                        text = "가족",
                        modifier = Modifier
                            .padding(top = 4.dp, bottom = 4.dp),
                        color = Title,
                        fontWeight = FontWeight(500),
                        fontSize = 16.sp,
                    )
                }
            }
            Row(
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Button(
                    onClick = { },
                    modifier = Modifier
                        .weight(0.5f),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(HomeButton),
                ) {
                    Text(
                        text = "제주",
                        modifier = Modifier
                            .padding(top = 4.dp, bottom = 4.dp),
                        color = Title,
                        fontWeight = FontWeight(500),
                        fontSize = 16.sp,
                    )
                }
                Button(
                    onClick = { },
                    modifier = Modifier
                        .weight(0.5f),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(HomeButton),
                ) {
                    Text(
                        text = "산",
                        modifier = Modifier
                            .padding(top = 4.dp, bottom = 4.dp),
                        color = Title,
                        fontWeight = FontWeight(500),
                        fontSize = 16.sp,
                    )
                }
            }
            Row(
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Button(
                    onClick = { },
                    modifier = Modifier
                        .weight(0.5f),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(HomeButton),
                ) {
                    Text(
                        text = "서양화",
                        modifier = Modifier
                            .padding(top = 4.dp, bottom = 4.dp),
                        color = Title,
                        fontWeight = FontWeight(500),
                        fontSize = 16.sp,
                    )
                }
                Button(
                    onClick = { },
                    modifier = Modifier
                        .weight(0.5f),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(HomeButton),
                ) {
                    Text(
                        text = "한국화",
                        modifier = Modifier
                            .padding(top = 4.dp, bottom = 4.dp),
                        color = Title,
                        fontWeight = FontWeight(500),
                        fontSize = 16.sp,
                    )
                }
            }
            Row(
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Button(
                    onClick = { },
                    modifier = Modifier
                        .weight(0.5f),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(HomeButton),
                ) {
                    Text(
                        text = "서양화",
                        modifier = Modifier
                            .padding(top = 4.dp, bottom = 4.dp),
                        color = Title,
                        fontWeight = FontWeight(500),
                        fontSize = 16.sp,
                    )
                }
                Button(
                    onClick = { },
                    modifier = Modifier
                        .weight(0.5f),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(HomeButton),
                ) {
                    Text(
                        text = "한국화",
                        modifier = Modifier
                            .padding(top = 4.dp, bottom = 4.dp),
                        color = Title,
                        fontWeight = FontWeight(500),
                        fontSize = 16.sp,
                    )
                }
            }
        } // 본문 콘텐츠 UI 끝
    } // Scaffold UI 끝
}