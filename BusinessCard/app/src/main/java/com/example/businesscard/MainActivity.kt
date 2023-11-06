package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFd2e8d4)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Info()
        Contacts()
    }
}

@Composable
private fun Info() {
    val image = painterResource(id = R.drawable.android_logo)
    val name = stringResource(id = R.string.name)
    val title = stringResource(id = R.string.title)
    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.5f)

    ) {
        Image(
            painter = image,
            contentDescription = "profile_photo",
            modifier = Modifier
                .background(Color(0xFF073042))
                .size(150.dp)
        )
        Text(
            text = name,
            textAlign = TextAlign.Center,
            fontSize = 36.sp
        )
        Text(
            text = title,
            textAlign = TextAlign.Center,
            color = Color(0xFF137546)
        )
    }
}

@Composable
private fun Contacts() {
    val phone = stringResource(id = R.string.phone)
    val github = stringResource(id = R.string.github)
    val email = stringResource(id = R.string.email)
    Column(
        modifier = Modifier
            .fillMaxHeight(0.5f),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Bottom
    ) {
        Row(
            modifier = Modifier.padding(6.dp)
        ) {
            Icon(
                Icons.Filled.Phone,
                contentDescription = "phone icon",
                tint = Color(0xFF137546)
            )
            Text(
                text = phone,
                modifier = Modifier.padding(start = 16.dp)
            )
        }
        Row(
            modifier = Modifier.padding(6.dp)
        ) {
            Icon(
                Icons.Filled.Info,
                contentDescription = "info icon",
                tint = Color(0xFF137546)
            )
            Text(
                text = github,
                modifier = Modifier.padding(start = 16.dp)
            )
        }
        Row(
            modifier = Modifier.padding(6.dp)
        ) {
            Icon(
                Icons.Filled.Email,
                contentDescription = "email icon",
                tint = Color(0xFF137546)
            )
            Text(
                text = email,
                modifier = Modifier.padding(start = 16.dp)
            )
        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}