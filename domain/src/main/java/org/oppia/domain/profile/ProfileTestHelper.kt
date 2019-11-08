package org.oppia.domain.profile

import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.oppia.app.model.ProfileId
import javax.inject.Inject

class ProfileTestHelper @Inject constructor(
  private val profileManagementController: ProfileManagementController
) {
  /** Create one admin profile and one user profile. */
  @ExperimentalCoroutinesApi
  fun initializeProfiles() {
    profileManagementController.addProfile("Sean", "12345", null, allowDownloadAccess = true, isAdmin = true)
    profileManagementController.addProfile("Ben", "123", null, allowDownloadAccess = false, isAdmin = false)
    profileManagementController.loginToProfile(ProfileId.newBuilder().setInternalId(0).build())
  }

  /** Create [numProfiles] number of user profiles. */
  @ExperimentalCoroutinesApi
  fun addMoreProfiles(numProfiles: Int) {
    for (x in 0 until numProfiles) {
      profileManagementController.addProfile((x+65).toChar().toString(), "123", null, allowDownloadAccess = false, isAdmin = false)
    }
  }

  /** Login to Admin profile. */
  @ExperimentalCoroutinesApi
  fun loginToAdmin() = profileManagementController.loginToProfile(ProfileId.newBuilder().setInternalId(0).build())

  /* Login to user profile. */
  @ExperimentalCoroutinesApi
  fun loginToUser() = profileManagementController.loginToProfile(ProfileId.newBuilder().setInternalId(1).build())
}