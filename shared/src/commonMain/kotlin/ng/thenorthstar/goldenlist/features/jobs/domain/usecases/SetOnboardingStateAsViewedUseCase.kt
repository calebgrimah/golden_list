package ng.thenorthstar.goldenlist.features.jobs.domain.usecases

import ng.thenorthstar.goldenlist.features.jobs.data.repository.JobRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class SetOnboardingStateAsViewedUseCase : KoinComponent {
    private val jobRepository: JobRepository by inject()
    suspend fun invoke(hasViewedOnboarding: Boolean) =
        jobRepository.setHasViewedOnboarding(hasViewedOnboarding)
}