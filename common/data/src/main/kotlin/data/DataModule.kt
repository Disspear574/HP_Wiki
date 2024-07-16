package data

import data.datastore.ConfigDataStore
import data.datastore.sharedprefs.SharedPreferencesConfigStore
import data.repository.BookRepositoryImpl
import data.repository.CharacterRepositoryImpl
import data.repository.ConfigRepositoryImpl
import domain.repository.BookRepository
import domain.repository.CharacterRepository
import domain.repository.ConfigRepository
import org.koin.dsl.module

val dataModule =
    module {

        single<ConfigDataStore> {
            SharedPreferencesConfigStore(get())
        }
        single<BookRepository> {
            BookRepositoryImpl(get())
        }

        single<CharacterRepository> {
            CharacterRepositoryImpl(get())
        }

        single<ConfigRepository> {
            ConfigRepositoryImpl(get())
        }
    }
