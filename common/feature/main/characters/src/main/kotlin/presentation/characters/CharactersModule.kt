package presentation.characters

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import presentation.characters.detail.DetailViewModel
import presentation.characters.library.LibraryViewModel

val charactersModule =
    module {
        viewModel {
            LibraryViewModel(get())
        }

        viewModel { (id: Int) ->
            DetailViewModel(id, get())
        }
    }
