package com.example.hilt_room_notesapp.di

import android.content.Context
import com.example.hilt_room_notesapp.room.NoteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


/*

                   Hilt Module is class where you define how build and provide dependencies ( objects like Room, Dao,Repositories, Retrofit, etc), annotated with "@Module".

                   @Module : annotate to register it as a Hilt component provider. Functions inside this AppModule are annotated with "@Provides" to tell hilt how to create instances.

*/



@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase( @ApplicationContext context: Context ): NoteDatabase {

        return NoteDatabase.getDatabase(context)

    }

    @Provides
    @Singleton
    fun ProvideNoteDao(noteDatabase: NoteDatabase) = noteDatabase.noteDao()



}