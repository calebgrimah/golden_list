package ng.thenorthstar.goldenlist.features.jobs.data.repository

import kotlinx.coroutines.withContext
import ng.thenorthstar.goldenlist.features.jobs.data.JobsApi
import ng.thenorthstar.goldenlist.util.DispatcherProvider

internal class JobRemoteSource(
    private val jobsApi: JobsApi,
    private val dispatcherProvider: DispatcherProvider
) {
    suspend fun fetchJobListings() =
        withContext(dispatcherProvider.io) {
            jobsApi.fetchJobListing()
        }
}