package com.compose.medicine.smartlab.datastore.repo

import kotlinx.coroutines.flow.Flow

interface DatastoreRepo {
    fun showOnboard(): Flow<Boolean>
    suspend fun changeShowOnboard()
}