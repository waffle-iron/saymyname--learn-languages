package com.android.szparag.saymyname

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.hardware.Camera
import android.hardware.Camera.ShutterCallback
import java.io.ByteArrayOutputStream


/**
 * Created by Przemyslaw Jablonski (github.com/sharaquss, pszemek.me) on 7/1/2017.
 */

//todo: this is memory inneficient, think about different implementation
public fun Bitmap.createBitmap(source: Bitmap, angle: Float): Bitmap {
  val matrix = Matrix()
  matrix.postRotate(angle)
  return Bitmap.createBitmap(source, 0, 0, source.width, source.height, matrix, true)
}

//todo: this should not be as extension function, it does too much and has hardcoded shit in it
fun Camera.takePicture(shutterCallback: ShutterCallback, pictureCallback: PictureBitmapCallback) {
  this.takePicture(
      shutterCallback,
      null,
      android.hardware.Camera.PictureCallback {
        data, camera ->
        pictureCallback.onPictureTaken(BitmapFactory.decodeByteArray(data, 0, data.size), data, camera)
      })
}

//fun BitmapFactory.compressToStream(compressFormat : Bitmap.CompressFormat, qualityPercent : Int): ByteArrayOutputStream {
//  val compressedStream = ByteArrayOutputStream()
//  Bitma(compressFormat, qualityPercent, compressedStream)
//  return compressedStream
//}

//fun Bitmap.compress(compressFormat : Bitmap.CompressFormat, qualityPercent : Int): Bitmap? {
//  val compressedStream = ByteArrayOutputStream()
//  this.compress(compressFormat, qualityPercent, compressedStream)
//  return BitmapFactory.decodeByteArray(compressedStream.toByteArray(), 0, compressedStream.toByteArray().size)
//}


//
///**
// * This method is responsible for solving the rotation issue if exist. Also scale the images to
// * 1024x1024 resolution
// * @param context       The current context
// * @param selectedImage The Image URI
// * @return Bitmap image results
// * @throws IOException
// */
//fun Bitmap.adjustResolution(dimensionX: Int, dimensionY: Int): Bitmap {
//  val MAX_HEIGHT = dimensionX
//  val MAX_WIDTH = dimensionY
//
//  // First decode with inJustDecodeBounds=true to check dimensions
//  val options = BitmapFactory.Options()
//  options.inJustDecodeBounds = true
//  var imageStream = context.getContentResolver().openInputStream(selectedImage)
//  BitmapFactory.decodeStream(imageStream, null, options)
//  imageStream.close()
//
//  // Calculate inSampleSize
//  options.inSampleSize = calculateInSampleSize(options, MAX_WIDTH, MAX_HEIGHT)
//
//  // Decode bitmap with inSampleSize set
//  options.inJustDecodeBounds = false
//  imageStream = context.getContentResolver().openInputStream(selectedImage)
//  var img = BitmapFactory.decodeStream(imageStream, null, options)
//
//  img = rotateImageIfRequired(img, selectedImage)
//  return img
//}


interface PictureBitmapCallback {
  fun onPictureTaken(bitmap: Bitmap?, pictureBytesArray: ByteArray, camera: Camera)
}