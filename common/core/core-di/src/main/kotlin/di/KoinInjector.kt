package di

import data.dataModule
import database.databaseModule
import domain.domainModule
import network.networkModule
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin
import presentation.books.booksModule
import presentation.characters.charactersModule
import presentation.splash.splashModule

object KoinInjector {
    val koinApp =
        startKoin {
            loadKoinModules(
                listOf(
                    coilModule,
                    networkModule,
                    dataModule,
                    domainModule,
                    databaseModule,
                    splashModule,
                    booksModule,
                    charactersModule,
                ),
            )
        }
}
