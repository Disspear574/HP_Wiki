package network

import io.ktor.client.HttpClient
import network.api.BooksApi
import network.api.CharactersApi
import network.impl.BooksApiImpl
import network.impl.CharactersApiImpl
import org.koin.dsl.module

val networkModule =
    module {
        single<HttpClient> {
            httpClient()
        }

        single<BooksApi> {
            BooksApiImpl(get())
        }

        single<CharactersApi> {
            CharactersApiImpl(get())
        }
    }
