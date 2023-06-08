package digital.patron.app_patronnativeapp.domain.model

import digital.patron.app_patronnativeapp.data.network.model.entity.Exhibition
import java.util.Optional

data class ThemeResult(
    val theme1: Optional<Exhibition>,
    val theme1DurationTime: String,
    val theme2: Optional<Exhibition>,
    val theme2DurationTime: String,
    val theme3: Optional<Exhibition>,
    val theme3DurationTime: String,
    val theme4: Optional<Exhibition>,
    val theme4DurationTime: String,
    val theme5: Optional<Exhibition>,
    val theme5DurationTime: String,
)
