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
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.unit.dp


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

@Composable //сегмент пользовательского интерфейа
fun DemoScreen(modifier: Modifier = Modifier) {
    //функция принимает модификатор по умолчанию, что позволяет настраивать ее извне

    val mymodifier = modifier
        .border(width = 2.dp, color = Color.Black) //черная рамка в 2 пикселя
        .padding(all = 10.dp) //отступы 10 px со всех сторон

    Text(
        "Hello Compose",
        modifier = mymodifier,
        fontSize = 40.sp, //размер 40 единиц
        fontWeight = FontWeight.Bold //жирный текст
    )
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