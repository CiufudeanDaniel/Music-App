package com.example.musicapp

import com.example.musicapp.repository.AlbumRepository
import com.example.musicapp.view_models.AlbumViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module


val viewModelModule = module {
    viewModelOf(::AlbumViewModel)
}

val repositoryModule = module {
    singleOf(::AlbumRepository)
}

val parentModule = module {
    includes(viewModelModule, repositoryModule)
}