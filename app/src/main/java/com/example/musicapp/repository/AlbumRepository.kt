package com.example.musicapp.repository

import android.util.Log

private const val TAG = "AlbumRepository"
class AlbumRepository {

    fun getAlbums(): ArrayList<String> {
        Log.v(TAG,"getAlbums()")
        return arrayListOf()
    }
}