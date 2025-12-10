package com.example.hilt_room_notesapp.repo

import com.example.hilt_room_notesapp.room.Note
import com.example.hilt_room_notesapp.room.NoteDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


// "repo" is the bridge between the viewmodel and the room database

/*

1. Abstracts the data sources (Room, network,...),
2. Exposes clean methods to the ViewModel/UI,
3. Makes easy to mock/fake data during testing,
4. Decouples app layers.

*/

class NoteRepository @Inject constructor(private val noteDao: NoteDao) {

    // calling functions from the room database's "Dao"
    suspend fun insertNote(note: Note){
        noteDao.insert(note)
    }

    val allNotesInDB: Flow<List<Note>> = noteDao.getAllNotes()




}



// "Flow" is asynchronous and lifecycle aware