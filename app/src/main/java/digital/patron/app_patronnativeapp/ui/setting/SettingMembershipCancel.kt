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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import digital.patron.app_patronnativeapp.R
import digital.patron.app_patronnativeapp.ui.theme.HomeButton
import digital.patron.app_patronnativeapp.ui.theme.SubTitle
import digital.patron.app_patronnativeapp.ui.theme.Title

@ExperimentalMaterial3Api
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SettingMembershipCancel(
    navController: NavController,
) {
    val itemsMembershipCancelDate: String = "2024년 1월 26일"

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

                        Spacer(modifier = Modifier.weight(9f)) // 90% width as the parent

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
                text = "멤버십 해지",
                color = Title,
                fontWeight = FontWeight(700),
                fontSize = 32.sp,
            )

            Text(
                text = "파트론을 이용해주셔서 감사합니다. 멤버십을 해지하더라도 업로드한 데이터는 30일 동안 보관됩니다." +
                        "해당 기간 내에 멤버십 재시작시 업로드한 데이터를 복구 할 수 있습니다.",
                modifier = Modifier
                    .padding(top = 20.dp, bottom = 20.dp),
                color = Title,
                fontWeight = FontWeight(500),
                fontSize = 18.sp,
            )

            Text(
                text = "·\t\t업로드한 콘텐츠는 가입시 동의한 약관에 따라 30일 동안 암호화 처리되어 보관됩니다.",
                modifier = Modifier
                    .padding(bottom = 8.dp),
                color = SubTitle,
                fontWeight = FontWeight(300),
                fontSize = 14.sp,
            )

            Text(
                text = "·\t\t암호화 처리된 데이터는 서비스 어디에도 노출되지 않으며, 해당 기간 내에 멤버십을 재시작하시면 등록한 콘텐츠를 복구할 수 있습니다.",
                modifier = Modifier
                    .padding(bottom = 8.dp),
                color = SubTitle,
                fontWeight = FontWeight(300),
                fontSize = 14.sp,
            )

            Text(
                text = "·\t\t멤버십이 해지되는 일자로부터 등록된 아트워크 및 초대된 인원에 제한이 있을 수 있습니다.",
                modifier = Modifier
                    .padding(bottom = 8.dp),
                color = SubTitle,
                fontWeight = FontWeight(300),
                fontSize = 14.sp,
            )

            Text(
                text = "·\t\t다시 찾아주신다면 언제든 환영입니다. 계속 버튼을 눌러 멤버십 해지를 완료하세요.",
                modifier = Modifier
                    .padding(bottom = 16.dp),
                color = SubTitle,
                fontWeight = FontWeight(300),
                fontSize = 14.sp,
            )

            Text(
                text = "멤버십 혜택 이용 가능 : $itemsMembershipCancelDate 까지",
                color = Title,
                fontWeight = FontWeight(500),
                fontSize = 18.sp,
            )

            Spacer(
                modifier = Modifier
                    .height(120.dp),
            )

            Button(
                onClick = {},
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(Color.Blue),
            ) {
                Text(
                    text = "해지하기",
                    modifier = Modifier
                        .padding(top = 8.dp, bottom = 8.dp),
                    color = Title,
                    fontWeight = FontWeight(700),
                    fontSize = 20.sp,
                )
            }

            Button(
                onClick = {
                          navController.navigate("setting")
                },
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(HomeButton),
            ) {
                Text(
                    text = "취소",
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