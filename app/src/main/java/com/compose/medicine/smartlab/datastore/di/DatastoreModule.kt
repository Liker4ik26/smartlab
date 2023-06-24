package com.compose.medicine.smartlab.datastore.di

import com.compose.medicine.smartlab.datastore.repo.DatastoreRepo
import com.compose.medicine.smartlab.datastore.repo.DatastoreRepoImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
interface DatastoreModule {

    @Binds
    fun bindDatastoreRepo(datastoreRepoImpl: DatastoreRepoImpl): DatastoreRepo
}