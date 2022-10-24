package ng.thenorthstar.goldenlist.features.jobs.data.repository

import com.squareup.sqldelight.runtime.coroutines.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToList
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import ng.thenorthstar.goldenlist.features.jobs.domain.model.JobListing
import ng.thenorthstar.goldenlist.goldenlistDb
import ng.thenorthstar.goldenlist.util.DispatcherProvider

internal class JobLocalSource(
    database: goldenlistDb,
    private val dispatcherProvider: DispatcherProvider
) {
    private val dao = database.tableQueries
    val jobs = dao.selectAll().asFlow().mapToList()
        .map { listings ->
            listings.map {
                JobListing(
                    it.jobTitle,
                    it.jobDescription,
                    it.jobId,
                    it.companyName,
                    it.location,
                    it.createdAt,
                    it.jobType, it.isRemote ?: false,
                    it.tags,
                    it.url
                )
            }
        }

    suspend fun selectAll() =
        withContext(dispatcherProvider.io) {
            dao.selectAll().executeAsList()
        }

    suspend fun insert(jobListing: JobListing) =
        withContext(dispatcherProvider.io) {
            dao.insert(
                jobListing.jobTitle,
                jobListing.jobDescription,
                jobListing.jobId,
                jobListing.companyName,
                jobListing.location,
                jobListing.dateCreated,
                jobListing.jobType,
                jobListing.url,
                jobListing.tags,
                jobListing.isRemoteJob
            )
        }

//    suspend fun update(jobListing: JobListing) =
//        withContext(dispatcherProvider.io) {
//            dao.update(
//                jobListing.jobTitle,
//                jobListing.jobDescription,
//                jobListing.jobId,
//                jobListing.companyName,
//                jobListing.location,
//                jobListing.dateCreated,
//                jobListing.jobId,
//                jobListing.jobType,
//                jobListing.tags,
//                jobListing.isRemoteJob
//            )
//        }

    suspend fun clear() =
        withContext(dispatcherProvider.io) {
            dao.clear()
        }
}