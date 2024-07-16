package data.datastore

interface ConfigDataStore {
    fun save(value: Boolean)

    fun load(): Boolean
}
