package com.example.notesdemo.ui.home

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notesdemo.database.NoteDatabase
import com.example.notesdemo.ext.toLiveData
import com.example.notesdemo.ui.model.Note
import kotlinx.coroutines.launch

class HomeViewModel(val app: Application) : AndroidViewModel(app) {

    private val _allNotesLiveData = MutableLiveData<List<Note>>()
    val allNotesLiveData = _allNotesLiveData.toLiveData()


    fun getAllNotes() {
        viewModelScope.launch {
            val noteEntities =
                NoteDatabase.getInstance(app.applicationContext).notedao().getAllNotes()
            val notes = arrayListOf<Note>()
            noteEntities.forEach {
                val note = Note(it.noteId, it.noteTitle, it.noteDesc)
                notes.add(note)
            }
            _allNotesLiveData.value = notes
        }
    }
}