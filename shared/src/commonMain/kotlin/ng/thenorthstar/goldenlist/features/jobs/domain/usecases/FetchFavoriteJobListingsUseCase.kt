package ng.thenorthstar.goldenlist.features.jobs.domain.usecases

import kotlinx.coroutines.flow.Flow
import ng.thenorthstar.goldenlist.features.jobs.data.model.getJobListing
import ng.thenorthstar.goldenlist.features.jobs.data.repository.JobRepository
import ng.thenorthstar.goldenlist.features.jobs.domain.model.JobListing
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject


class FetchFavoriteJobListingsUseCase : KoinComponent {
    private val jobRepository: JobRepository by inject()
    suspend fun invoke(): List<JobListing> =
        jobRepository.fetchFavoriteListings()
}
