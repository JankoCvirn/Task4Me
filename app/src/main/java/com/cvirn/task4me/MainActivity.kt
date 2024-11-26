package com.cvirn.task4me

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.cvirn.task4me.navigation.AppNavigation
import com.cvirn.task4me.ui.theme.Task4Me

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class) // Opt-in for Experimental APIs
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Optional for edge-to-edge support, depending on design

        setContent {
            Task4Me {
                Surface(modifier = Modifier.fillMaxSize()) {
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                title = { Text(getString(R.string.app_name)) },
                                actions = {
                                }
                            )
                        },
                        content = { padding ->
                            AppNavigation(padding)
                        }
                    )
                }
            }
        }
    }
}
