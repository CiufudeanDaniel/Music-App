package com.example.musicapp.view_models

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.musicapp.repository.AlbumRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

private const val TAG = "AlbumViewModel"
class AlbumViewModel(application: Application, private val repository: AlbumRepository) : AndroidViewModel(application) {

    val albums: MutableLiveData<ArrayList<String>> by lazy {
        MutableLiveData<ArrayList<String>>().also {
            getAlbums()
        }
    }

    private fun getAlbums() {
        Log.v(TAG, "getAlbums()")
        viewModelScope.launch(Dispatchers.IO) {
            val result = repository.getAlbums()
            withContext(Dispatchers.Main) {
                albums.value = result
            }
        }
    }
}