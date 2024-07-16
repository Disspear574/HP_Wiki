package presentation.books

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import presentation.books.detail.DetailViewModel
import presentation.books.library.LibraryViewModel

val booksModule =
    module {
        viewModel {
            LibraryViewModel(get())
        }

        viewModel { (id: Int) ->
            DetailViewModel(id, get())
        }
    }
