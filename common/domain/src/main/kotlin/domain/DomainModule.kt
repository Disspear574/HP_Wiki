package domain

import domain.usecase.GetAllBooksUseCase
import domain.usecase.GetAllCharactersUseCase
import domain.usecase.GetBookByIdUseCase
import domain.usecase.GetCharacterByIdUseCase
import domain.usecase.GetDataUseCase
import org.koin.dsl.module

val domainModule =
    module {
        factory<GetAllBooksUseCase> {
            GetAllBooksUseCase(get())
        }

        factory<GetAllCharactersUseCase> {
            GetAllCharactersUseCase(get())
        }

        factory<GetBookByIdUseCase> {
            GetBookByIdUseCase(get())
        }

        factory<GetCharacterByIdUseCase> {
            GetCharacterByIdUseCase(get())
        }

        factory<GetDataUseCase> {
            GetDataUseCase(
                bookRepository = get(),
                characterRepository = get(),
                configRepository = get(),
            )
        }
    }
