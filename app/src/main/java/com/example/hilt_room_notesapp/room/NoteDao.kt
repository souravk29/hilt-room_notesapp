package com.example.hilt_room_notesapp.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

/*


this interface contains the method to interact with the database, defining how your
       app will read/write data to the "note" table that you created earlier


 */


@Dao
interface NoteDao {

    @Insert
    suspend fun insert(note: Note)                                          // tells room to add a new note to the database, this insertion is done in the background thread (coroutines handle it)
                                                                            // without blocking main thread

    @Query("SELECT * FROM notes ORDER BY timestamp DESC")
    fun getAllNotes(): Flow<List<Note>>                                       // fetching all notes from notes table,
                                                                                // this function will return a flow of list of notes in real time

}








/*

 A suspending function is a special type of function in Kotlin that can be paused and resumed at a later time.
 This is the foundational element of Kotlin Coroutines. Suspending functions are designed to perform long-running tasks
 (like database operations, network calls, or intensive calculations) without blocking the main thread (e.g., the UI
 thread in an Android application).

*/