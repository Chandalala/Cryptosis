package com.chandalala.cryptosis

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.chandalala.cryptosis.presentation.ui.theme.CryptosisTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptosisTheme {
                Surface(color = MaterialTheme.colors.background) {

                }
            }
        }
    }
}