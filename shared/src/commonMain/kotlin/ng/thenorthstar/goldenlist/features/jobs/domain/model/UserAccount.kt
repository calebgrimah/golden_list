package ng.thenorthstar.goldenlist.features.jobs.domain.model
import kotlinx.serialization.Serializable

import kotlinx.serialization.SerialName


data class JobListing(
    val jobTitle : String,
    val jobDescription : String,
    val jobId : String,
    val companyName : String,
    val location : String,
    val dateCreated : String,
    val jobType : String,
    val isRemoteJob : Boolean,
    val tags : String,
    val url : String,
)

data class JobListingTest(
    val url : String,
)
