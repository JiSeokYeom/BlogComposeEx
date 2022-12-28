package com.example.blogexcompose

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.blogexcompose.ui.theme.BlogExComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BlogExComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ScaffoldTest()
                }
            }
        }
    }
}

@Composable
fun ScaffoldTest() {
    val context = LocalContext.current
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        // topBar 적용
        topBar = {
            CustomTopBar("이것은 CustomTopbar 타이틀 입니다",
            onClickBackButton = {
                Toast.makeText(context, "뒤로가기 클릭", Toast.LENGTH_SHORT).show()
            })
        },
        bottomBar = {

        }
    )
    {
        Text(text = "Content 입니다!")
    }
}

@Composable
fun CustomTopBar(
    title: String = "",
    onClickBackButton: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .height(56.dp)
            .fillMaxWidth()
            .background(Color.LightGray),
    ) {
        IconButton(
            modifier = Modifier.align(Alignment.CenterStart),
            onClick = {
                onClickBackButton.invoke()
            }
        ) {
            Icon(Icons.Default.ArrowBack, contentDescription = null)
        }
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = title,
            style = MaterialTheme.typography.subtitle1
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BlogExComposeTheme {
        ScaffoldTest()
    }
}