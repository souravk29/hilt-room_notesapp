package com.example.hilt_room_notesapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.hilt_room_notesapp.repo.NoteRepository
import com.example.hilt_room_notesapp.room.Note
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject


// suspend function can be called only through the other suspend function or the coroutine (eg. viewModelScope)


@HiltViewModel                                                                                           // tells hilt that this is VM class, inject Dependencies here automatically
class NoteViewModel @Inject constructor( private val repository: NoteRepository ) : ViewModel() {

    val allNotes: Flow<List<Note>> = repository.allNotesInDB

    fun insert(note: Note) = viewModelScope.launch {
        repository.insertNote(note)
    }

}




// "Flow" : Every time the screen (the Flow) updates, you get the entire list at that moment.