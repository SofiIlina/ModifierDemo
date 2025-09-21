package com.example.modifierdemo //объявляет пакет, которому принадлежит файл

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.modifierdemo.ui.theme.ModifierDemoTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.foundation.border
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.*
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.draw.clip


class MainActivity : ComponentActivity() { //Activity, который является точкой входа в Android-приложение

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // функция позволяет вашему контенту рисоваться под системными барами
        setContent { //функция с описанием интерфейса
            ModifierDemoTheme { // сгенерированная тема приложения
                // Scaffold - макет для экрана
                //innerPadding — автоматически рассчитанные отступы
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    DemoScreen(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun CustomImage(image: Int,  modifier: Modifier = Modifier) {
    //параметр модификатора необязательный, чтобы ф-ю можно было вызвать без него
    Image(
        painter = painterResource(image),
        contentDescription = null,
        modifier
    )
}

@Composable //сегмент пользовательского интерфейа
fun DemoScreen(modifier: Modifier = Modifier) {
    //функция принимает модификатор по умолчанию, что позволяет настраивать ее извне

    val mymodifier = modifier //кастомный модификатор
        .padding(all = 10.dp) //отступы 10 px со всех сторон
        .border(width = 2.dp, color = Color.Black) //черная рамка в 2 пикселя
    val secondModifier = Modifier.height(100.dp)
    Column( //вертикальный контейнер
        Modifier.padding(20.dp), //отступы 20px
        horizontalAlignment = Alignment.CenterHorizontally, //горизонтальное центрирование
        verticalArrangement = Arrangement.Center // вертикальное центрирование
    ){
        Text(
            "Hello Compose",
            mymodifier.then(secondModifier),
            fontSize = 40.sp, //размер 40 единиц
            fontWeight = FontWeight.Bold //жирный текст
        )
    }
    Spacer(Modifier.height(16.dp)) //пустое пространство 16px
    CustomImage(R.drawable.vacation,
        Modifier
            .padding(16.dp)
            .width(270.dp)
            .clip(shape = RoundedCornerShape(30.dp)) //скругленные углы
            //clip - обрезка
    )//кастомное изображение из ресуросв
}

@Preview(showBackground = true) //предосмотр внутри студии
@Composable
fun DefaultPreview() {
    ModifierDemoTheme {
        DemoScreen()
    }
}

//При запуске приложения система создает MainActivity
//Вызывается метод onCreate
//setContent отрисовывает весь UI
//Scaffold создает базовый макет экрана и рассчитывает отступы
//Внутрь Scaffold помещается функция DemoScreen, которая и отображает текст "Hello Compose"
//Функция DefaultPreview не участвует в работе реального приложения