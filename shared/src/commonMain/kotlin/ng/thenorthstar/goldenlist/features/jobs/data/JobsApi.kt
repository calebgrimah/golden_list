package ng.thenorthstar.goldenlist.features.jobs.data

import io.ktor.client.call.*
import io.ktor.client.request.*
import ng.thenorthstar.goldenlist.api.KtorApi
import ng.thenorthstar.goldenlist.features.jobs.data.model.JobListingNetworkResponse

internal class JobsApi : KtorApi() {
    suspend fun fetchJobListing(): JobListingNetworkResponse  =
        client.get {
            apiUrl("api/job-board-api",)
        }.body()
}
