package ng.thenorthstar.goldenlist.features.jobs.domain.usecases

import ng.thenorthstar.goldenlist.features.jobs.data.model.getJobListing
import ng.thenorthstar.goldenlist.features.jobs.data.repository.JobRepository
import ng.thenorthstar.goldenlist.features.jobs.domain.model.JobListing
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class FetchJobListingsUseCase : KoinComponent {
    private val jobRepository: JobRepository by inject()
    suspend fun invoke(): List<JobListing?>? =
        jobRepository.fetchJobListings().data?.map { it?.getJobListing() }
}
