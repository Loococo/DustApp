package app.loococo.presentation.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import app.loococo.presentation.theme.Black

@Composable
fun DustLabelText(
    text: String,
    modifier: Modifier = Modifier,
    fontWeight: FontWeight = FontWeight.Normal,
    textDecoration: TextDecoration = TextDecoration.None,
    textAlign: TextAlign = TextAlign.Center,
    color: Color = Black
) {
    Text(
        text = text,
        modifier = modifier,
        fontSize = 14.sp,
        fontWeight = fontWeight,
        textAlign = textAlign,
        textDecoration = textDecoration,
        color = color
    )
}

@Composable
fun DustBodyText(
    text: String,
    modifier: Modifier = Modifier,
    fontWeight: FontWeight = FontWeight.Normal,
    textDecoration: TextDecoration = TextDecoration.None,
    textAlign: TextAlign = TextAlign.Start,
    color: Color = Black,
) {
    Text(
        text = text,
        modifier = modifier,
        fontSize = 16.sp,
        fontWeight = fontWeight,
        textAlign = textAlign,
        textDecoration = textDecoration,
        color = color
    )
}

@Composable
fun DustTitleText(
    text: String,
    modifier: Modifier = Modifier,
    fontWeight: FontWeight = FontWeight.Normal,
    textDecoration: TextDecoration = TextDecoration.None,
    textAlign: TextAlign = TextAlign.Start,
    color: Color = Black
) {
    Text(
        text = text,
        modifier = modifier,
        fontSize = 20.sp,
        fontWeight = fontWeight,
        textAlign = textAlign,
        textDecoration = textDecoration,
        color = color
    )
}