package com.compose.medicine.smartlab.datastore

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@InstallIn(SingletonComponent::class)
@Module
class Datastore @Inject constructor(@ApplicationContext private val context: Context) {
    private val Context.dataStore by preferencesDataStore(
        name = "settings",
        scope = CoroutineScope(Dispatchers.IO + Job())
    )

    companion object {
        val SHOW_ONBOARD = booleanPreferencesKey(name = "show_onboard")
    }

    val showOnboard: Flow<Boolean> = context.dataStore.data.map { pref ->
        pref[SHOW_ONBOARD] ?: true
    }

    suspend fun changeShowOnboard(value: Boolean) {
        context.dataStore.edit { it[SHOW_ONBOARD] = value }
    }
}