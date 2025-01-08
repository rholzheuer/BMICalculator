package com.example.bmicalculator

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Bmi(modifier: Modifier = Modifier) {
    var heightInput by remember { mutableStateOf("") }
    var weightInput by remember { mutableStateOf("") }
    val height = heightInput.toFloatOrNull() ?: 0.0f
    val weight = weightInput.toIntOrNull() ?: 0
    val bmi = if (weight > 0 && height > 0) weight / (height * height) else 0.0f

    Column(modifier = modifier.padding(16.dp)) {
        Text(
            text = "Body mass index",
            fontSize = 24.sp,
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        )
        OutlinedTextField(
            value = heightInput,
            onValueChange = { heightInput = it.replace(',', '.') },
            label = { Text("Height (m)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        OutlinedTextField(
            value = weightInput,
            onValueChange = { weightInput = it.replace(',', '.') },
            label = { Text("Weight (kg)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        Text(
            text = "Your BMI is: %.2f".format(bmi),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        )
    }
}
