package data.repository

import data.datastore.ConfigDataStore
import domain.repository.ConfigRepository

class ConfigRepositoryImpl(
    private val storage: ConfigDataStore,
) : ConfigRepository {
    override var createdDatabase: Boolean
        get() = storage.load()
        set(value) {
            storage.save(value)
        }
}
