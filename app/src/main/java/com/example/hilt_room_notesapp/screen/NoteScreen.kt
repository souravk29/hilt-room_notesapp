package com.example.hilt_room_notesapp.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.example.hilt_room_notesapp.room.Note
import com.example.hilt_room_notesapp.viewmodel.NoteViewModel


@Composable
fun NoteScreen( viewModel: NoteViewModel = hiltViewModel() ){

    val notes by viewModel.allNotes.collectAsState(initial = emptyList())

    var title by remember{ mutableStateOf("") }

    var content by remember{ mutableStateOf("") }


    Column ( modifier = Modifier.padding(16.dp) ){

        TextField(
            value = title,
            onValueChange = {title = it},
            label = {Text(text = "Title")},
            modifier = Modifier.fillMaxWidth()
        )

        Spacer( modifier = Modifier.height(8.dp) )

        TextField(
            value = content,
            onValueChange = {content = it},
            label = {Text(text = "Label")},
            modifier = Modifier.fillMaxWidth()
        )

        Spacer( modifier = Modifier.height(16.dp) )

        Button(
            onClick = {
                viewModel.insert( Note(0, title, content, System.currentTimeMillis() ))                                     // calls insert function inside the viewmodel
                            title = ""
                            content = ""
                      },
            modifier = Modifier.fillMaxWidth()

        ) {

            Text(text = "Add Note")

            Spacer(modifier = Modifier.height(16.dp))

            // display all notes in DB
            LazyColumn {
                items(notes){ note ->
                    NoteItem(note)

                }
            }



        }


    }

}