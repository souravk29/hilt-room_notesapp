package com.example.hilt_room_notesapp.room

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "notes")                              // this directs to create a table named "notes"
data class Note(                                          // this data class holds note's data in four fields

    @PrimaryKey(autoGenerate = true) val id: Int = 0,                   // autogenerate automat. increases the value of is
    val title: String,                                                  // with each new column/instance of the Notes class created
    val content: String,
    val timestamp: Long

)




/*

Room maps this to a table schema, it tells room database that it is gonna use this class/template/type of data as entities,
so go and create a table that defines these above given four fields

*/