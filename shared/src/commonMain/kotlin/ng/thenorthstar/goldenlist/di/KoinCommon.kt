package ng.thenorthstar.goldenlist.di

import ng.thenorthstar.goldenlist.db.createDriver
import ng.thenorthstar.goldenlist.features.jobs.data.JobsApi
import ng.thenorthstar.goldenlist.features.jobs.data.repository.AppSettings
import ng.thenorthstar.goldenlist.features.jobs.data.repository.JobLocalSource
import ng.thenorthstar.goldenlist.features.jobs.data.repository.JobRemoteSource
import ng.thenorthstar.goldenlist.features.jobs.data.repository.JobRepository
import ng.thenorthstar.goldenlist.features.jobs.domain.usecases.*
import ng.thenorthstar.goldenlist.goldenlistDb
import ng.thenorthstar.goldenlist.util.getDispatcherProvider
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

expect fun settingsModule(): Module

//private val coreModule = module {
//    factory { Platform() }
//}
private val utilityModule = module {
    factory { getDispatcherProvider() }
    single { goldenlistDb(createDriver("goldenlistDb.db")) }
    single { AppSettings(get()) }
}

private val apiModule = module {
    factory { JobsApi() }
}

private val repositoryModule = module {
//    single { PostsRepository(get(), get()) }
//    factory { AccountRepository(get(),) }
//    factory { AccountRemoteSource(get(), get()) }
}

private val jobsModule = module {
    factory { JobLocalSource(get(), get()) }
    single { JobRepository(get(), get()) }
    factory {
        JobRemoteSource(get(), get())
    }
}
private val useCaseModule = module {
    factory { MarkJobListingAsFavoriteUseCase() }
    factory { FetchJobListingsUseCase() }
    factory { SetOnboardingStateAsViewedUseCase() }
    factory { HasViewedOnboardingUseCase() }
    factory { FetchFavoriteJobListingsUseCase() }
}

private val sharedModules =
    listOf(useCaseModule, repositoryModule, apiModule, utilityModule, jobsModule, settingsModule())

fun initKoin(appDeclaration: KoinAppDeclaration) = startKoin {
    appDeclaration()
    modules(sharedModules)
}

//called by iOS
fun initKoin() = initKoin() {}