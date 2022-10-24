package ng.thenorthstar.goldenlist.features.jobs.data.repository

import com.russhwolf.settings.ExperimentalSettingsApi
import com.russhwolf.settings.ObservableSettings
import com.russhwolf.settings.coroutines.getBooleanFlow
import kotlinx.coroutines.flow.Flow

@OptIn(ExperimentalSettingsApi::class)
class AppSettings(val settings: ObservableSettings) {

    val hasViewedOnboarding: Flow<Boolean> =
        settings.getBooleanFlow(HAS_VIEWED_ONBOARDING, false)

//    init {
////        if (!settings.getBoolean(HAS_VIEWED_ONBOARDING, false)) {
////            settings.putBoolean(HAS_VIEWED_ONBOARDING, false)
////        }
//    }

    fun updateOnboardingState(hasViewedOnboarding: Boolean) {
        settings.putBoolean(HAS_VIEWED_ONBOARDING, hasViewedOnboarding)
    }

    companion object {
        const val HAS_VIEWED_ONBOARDING = "has_viewed_onboarding"
    }

}