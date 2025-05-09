package com.example.classapp

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.LocalActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SelectableDates
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import com.example.classapp.ui.theme.ClassAppTheme

class Register : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold { innerPaddling ->
                Register( innerPaddling)

            }
        }
    }
}

@Composable
fun Register( innerPaddingValues: PaddingValues){
    var firstName by remember { mutableStateOf("") }
    var lastName by  remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var countryExpand by remember { mutableStateOf(false) }
    var selectedTextOptinText by remember { mutableStateOf("Select country") }
    val countryOptions = listOf("country1","country2","country3");
    var textFieldSize by remember { mutableStateOf(androidx.compose.ui.geometry.Size.Zero) }
    val context = LocalContext.current
    val  calendar = Calendar.getInstance()
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)
    var selectedDates by remember { mutableStateOf("") }
    val datePickerDialog = DatePickerDialog (context,
        { _, selectedYear,selectedMonth,selectedDay ->
            selectedDates = "$selectedDay/$selectedMonth/$selectedYear"
        },
        year,
        month,
        day)

    Column(modifier = Modifier.fillMaxSize()

    ){
        Text("Register",
            modifier = Modifier.fillMaxWidth(),
            fontSize = 20.sp,
            textAlign = TextAlign.Center
            )
        Row (modifier = Modifier,
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically){
            OutlinedTextField(
                value = firstName,
                onValueChange = {firstName= it},
                label = {Text("Firstname")},
                modifier = Modifier.weight(0.5f),

            )
            Spacer(modifier = Modifier.width(10.dp))
            OutlinedTextField(
                value = lastName,
                onValueChange = {lastName= it},
                label = {Text("Lastname")},
                modifier = Modifier.weight(0.5f),

                )


        }

        Column(modifier = Modifier.fillMaxSize().padding(10.dp)){OutlinedTextField(
            value = email,
            onValueChange = {email= it},
            label = {Text("email")},
            modifier = Modifier.width(400.dp),

            )
            Spacer(modifier = Modifier.height(10.dp))


            Box(modifier = Modifier.fillMaxWidth().width(400.dp)){

                OutlinedTextField(

                    modifier = Modifier.clickable{countryExpand =true}

                        .onGloballyPositioned(){coordinates ->

                            textFieldSize = coordinates.size.toSize()

                        }

                        .fillMaxWidth(),

                    value = selectedTextOptinText,

                    onValueChange = {},

                    placeholder = {Text("Select Country")},

                    enabled = false,

                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowDown,
                            contentDescription = null
                        )

                    }

                )
                DropdownMenu (

                    expanded = countryExpand,

                    onDismissRequest = {countryExpand = false},

                    modifier = Modifier.width(with(LocalDensity.current){textFieldSize.width.toDp()})

                ) {

                    countryOptions.forEach { option ->

                        DropdownMenuItem(

                            text = {Text(option)},

                            onClick = {

                                selectedTextOptinText = option

                                countryExpand =false

                            }

                        )

                    }

                }

            }

            Spacer(modifier = Modifier.height(10.dp))
            Box (
                modifier = Modifier.fillMaxWidth().clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null
                )
            { datePickerDialog.show() } ){
                OutlinedTextField(
                    placeholder = {Text("DOB")},
                    modifier = Modifier.fillMaxWidth(),
                    value = selectedDates,
                    shape = RoundedCornerShape(10.dp),
                    colors = TextFieldDefaults.colors(
                        disabledContainerColor = Color.Gray.copy(alpha = 0.3f),
                        disabledIndicatorColor = Color.Transparent,
                        disabledTextColor = Color.Black
                    ),
                    enabled = false,
                    onValueChange = {},

                    // testing comments is here.
                )
            }


        }
        
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterPreview2() {
    Register(innerPaddingValues = PaddingValues(0.dp))
}