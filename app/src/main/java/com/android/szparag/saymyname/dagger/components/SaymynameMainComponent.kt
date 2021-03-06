package com.android.szparag.saymyname.dagger.components

import com.android.szparag.saymyname.dagger.modules.SaymynameMainModule
import com.android.szparag.saymyname.services.SaymynameImageRecognitionNetworkService
import com.android.szparag.saymyname.views.activities.RealtimeCameraPreviewActivity
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Przemyslaw Jablonski (github.com/sharaquss, pszemek.me) on 7/5/2017.
 */
@Singleton @Component(modules = arrayOf(SaymynameMainModule::class))
interface SaymynameMainComponent {

  fun inject(target: RealtimeCameraPreviewActivity)
  fun inject(target: SaymynameImageRecognitionNetworkService)

}