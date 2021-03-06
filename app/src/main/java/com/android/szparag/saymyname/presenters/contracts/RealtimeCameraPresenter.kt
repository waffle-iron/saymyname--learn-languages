package com.android.szparag.saymyname.presenters.contracts

import com.android.szparag.saymyname.models.contracts.ImageRecognitionModel
import com.android.szparag.saymyname.models.contracts.Model
import com.android.szparag.saymyname.models.contracts.TranslationModel

/**
 * Created by Przemyslaw Jablonski (github.com/sharaquss, pszemek.me) on 7/5/2017.
 */
interface RealtimeCameraPresenter : CameraPresenter, ImageProcessingPresenter {

  val imageRecognitionModel: ImageRecognitionModel
  val translationModel : TranslationModel
}