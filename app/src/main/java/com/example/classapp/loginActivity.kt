package com.example.classapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawTransform
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.nio.file.WatchEvent

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold { innerPadding ->
                LoginBody(innerPadding)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginBody(innerPadding: PaddingValues) {

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    var passwordVisibility by remember { mutableStateOf(false) }
    var rememberMe by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(50.dp))

        Image(
            painter = painterResource(com.example.classapp.R.drawable.lap),
            contentDescription = null,
            modifier = Modifier
                .height(250.dp)
                .width(250.dp)
        )

        Spacer(modifier = Modifier.height(50.dp))

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            shape = RoundedCornerShape(12.dp),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            ),
            label = {
                Text("Email")
            },
            placeholder = {
                Text("abc@gmail.com")
            },
            value = username,
            onValueChange = { input ->
                username = input
            }
        )


        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            shape = RoundedCornerShape(12.dp),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            ),
            label = {
                Text("Password")
            },
            value = password,
            onValueChange = { input ->
                password = input
            },

            )
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth().padding(10.dp, 0.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Checkbox(
                    checked = rememberMe,
                    onCheckedChange = {
                        rememberMe = !rememberMe
                    },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color.Green,
                        checkmarkColor = Color.White
                    )
                )
                Text(text = "remember me")
            }
            Row {
                Text(text = "Forget Password?")
            }
        }

        Row(){
            Spacer(modifier = Modifier.height(20.dp))
            ElevatedButton(onClick ={},
                modifier = Modifier.width(200.dp).height(70.dp)
                    .padding(20.dp,0.dp)) {
                Text(text = "login")
            }


        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(modifier = Modifier,
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically) {
            Text(modifier = Modifier.clickable{},
                text = "New User Register Now"
            )


        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier,
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(text="------------------other options-------------------")

        }
        Spacer(modifier = Modifier.height(16.dp))
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(painter = painterResource(R.drawable.fac),
                contentDescription = null,
                modifier = Modifier.height(50.dp).width(50.dp))
            Image(painter =painterResource(R.drawable.fac),
                contentDescription = null,
                modifier = Modifier.height(50.dp).width(50.dp))
            Image(painter = painterResource(R.drawable.fac),
                contentDescription = null,
                modifier = Modifier.height(70.dp).width(70.dp)
            )

        }
    }
}


@Preview
@Composable
fun LoginPreviewBody() {
    LoginBody(innerPadding = PaddingValues(0.dp))
}