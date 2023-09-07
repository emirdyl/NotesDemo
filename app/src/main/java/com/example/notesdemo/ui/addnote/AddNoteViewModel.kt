package com.example.notesdemo.ui.addnote

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notesdemo.database.NoteDatabase
import com.example.notesdemo.database.NoteEntity
import com.example.notesdemo.ext.toLiveData
import com.example.notesdemo.ui.model.Note
import kotlinx.coroutines.launch

class AddNoteViewModel(val app: Application) : AndroidViewModel(app) {

    private val _saveStateLiveData = MutableLiveData<Boolean>()
    val saveStateLiveData = _saveStateLiveData.toLiveData()

    fun saveNote(title: String, desc: String) {
        viewModelScope.launch {

            try {
                val noteEntity = NoteEntity(noteTitle = title, noteDesc = desc)
                NoteDatabase.getInstance(app.applicationContext).notedao().insert(noteEntity)
                _saveStateLiveData.value=true
            } catch (e: Exception) {
                _saveStateLiveData.value=false
            }


        }
    }
}