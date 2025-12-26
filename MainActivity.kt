package com.example.ca2

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FeedbackApp()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FeedbackApp() {

    val context = LocalContext.current

    var name by remember { mutableStateOf("") }
    var feedback by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Feedback",
                        modifier = Modifier.fillMaxWidth()
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        Toast.makeText(
                            context,
                            "Navigation icon clicked",
                            Toast.LENGTH_SHORT
                        ).show()
                    }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Navigation")
                    }
                },
                actions = {
                    IconButton(onClick = {
                        Toast.makeText(
                            context,
                            "Settings icon clicked",
                            Toast.LENGTH_SHORT
                        ).show()
                    }) {
                        Icon(Icons.Default.Settings, contentDescription = "Settings")
                    }
                }
            )
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            TextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Enter Name") },
            )

            Spacer(modifier = Modifier.height(12.dp))

            TextField(
                value = feedback,
                onValueChange = { feedback = it },
                label = { Text("Enter Feedback") },
            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = {
                if (name.isNotBlank() && feedback.isNotBlank()) {
                    Toast.makeText(
                        context,
                        "Feedback submitted successfully.",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(
                        context,
                        "Please enter valid details in both fields.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }) {
                Text("Submit")
            }
        }
    }
}
