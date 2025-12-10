package com.example.hilt_room_notesapp.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase



@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun noteDao(): NoteDao                                                       // this extends "Dao" to be used elsewhere


    companion object {                                                                    // ensures single instance of DB is created

        @Volatile
        private var INSTANCE: NoteDatabase? = null

        fun getDatabase(context: Context): NoteDatabase {
            return INSTANCE ?: synchronized(this){                              // "synchronized" ensures that if the INSTANCE is null,
                                                                                       // only one thread can create the database instance -> thread safety
                // building the actual DB
                Room.databaseBuilder(
                    context = context.applicationContext,
                    klass = NoteDatabase::class.java,
                    name = "notes_database"
                ).build()                                                               // Creates the databases and initializes it. By default, all RoomDatabases use in memory storage
                                                                                        // for TEMP tables and enables recursive triggers. Returns: A new database instance.
                                                                                        // Throws: IllegalArgumentException - if the builder was misconfigured


            }
        }
    }
}







/*

What @Volatile Does:

1. When you annotate a property with @Volatile: Bypasses Cache: It tells the JVM, "Do not cache this variable in thread-local memory. Always read from and write directly to Main Memory.
2. Immediate Visibility: Any write to this variable by one thread is guaranteed to be immediately visible to all other threads.

*/


/*

exportSchema = false, in Kotlin Android development controls whether Room should export the database schema into a folder.

  */