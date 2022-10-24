package ng.thenorthstar.goldenlist.features.jobs.domain.usecases

import ng.thenorthstar.goldenlist.features.jobs.data.repository.JobRepository
import ng.thenorthstar.goldenlist.features.jobs.domain.model.JobListing
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MarkJobListingAsFavoriteUseCase : KoinComponent {
    private val jobRepository: JobRepository by inject()
    suspend fun invoke(jobListing: JobListing) = jobRepository.markFavorite(jobListing)
}