package com.example.hilt_room_notesapp.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.example.hilt_room_notesapp.viewmodel.NoteViewModel


@Composable
fun NoteScreen( viewModel: NoteViewModel = hiltViewModel() ){

    val notes by viewModel.allNotes.collectAsState(initial = emptyList())

}