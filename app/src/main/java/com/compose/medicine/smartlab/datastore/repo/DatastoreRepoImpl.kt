package com.compose.medicine.smartlab.datastore.repo

import com.compose.medicine.smartlab.datastore.Datastore
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DatastoreRepoImpl @Inject constructor(
    private val datastore: Datastore
) : DatastoreRepo {

    override fun showOnboard(): Flow<Boolean> {
        return datastore.showOnboard
    }

    override suspend fun changeShowOnboard() {
        datastore.changeShowOnboard(false)
    }
}