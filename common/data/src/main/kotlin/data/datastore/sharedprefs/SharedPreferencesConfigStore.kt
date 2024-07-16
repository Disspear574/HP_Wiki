package data.datastore.sharedprefs

import android.content.Context
import androidx.core.content.edit
import data.datastore.ConfigDataStore

class SharedPreferencesConfigStore(
    private val context: Context,
) : ConfigDataStore {
    private val preferences
        get() =
            context.getSharedPreferences(
                SHARED_PREF_NAME,
                Context.MODE_PRIVATE,
            )

    override fun save(value: Boolean) {
        preferences.edit {
            putBoolean("CREATED_DATABASE", value)
        }
    }

    override fun load(): Boolean = preferences.getBoolean(DB_SETTING_NAME, false)

    companion object {
        private const val SHARED_PREF_NAME = "HpPreferences"
        private const val DB_SETTING_NAME = "CREATED_DATABASE"
    }
}
