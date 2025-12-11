package com.example.hilt_room_notesapp

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
import com.example.hilt_room_notesapp.screen.NoteScreen
import com.example.hilt_room_notesapp.ui.theme.Hiltroom_notesappTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint                                                      // necessary when using hilt and di
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            NoteScreen()                        // we do not need to pass "viewmodel", hilt does that automatically

        }
    }
}