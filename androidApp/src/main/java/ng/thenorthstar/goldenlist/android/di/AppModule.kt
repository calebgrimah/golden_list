package ng.thenorthstar.goldenlist.android.di

import ng.thenorthstar.goldenlist.android.features.GoldenListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { GoldenListViewModel(get(), get(), get(), get(), get()) }
}