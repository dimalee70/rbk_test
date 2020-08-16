package kz.v.main.presentation.ui.camera

import android.content.ContentValues
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Size
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.FileProvider
import kotlinx.android.synthetic.main.fragment_camera.*
import kz.v.main.R
import kz.v.ui_components.base.BaseFragment
import timber.log.Timber
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

class CameraFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Timber.i("onCreateView")
        return inflater.inflate(R.layout.fragment_camera, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Timber.i("onViewCreated")
        super.onViewCreated(view, savedInstanceState)
        make_photo_btn.setOnClickListener {
            openCamera()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        Timber.i("onActivityResult")
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            REQUEST_IMAGE_CAPTURE -> {
                image_view.setImageURI(photoURI)
                photoURI?.let {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                        val thumbnail: Bitmap =
                            requireContext().contentResolver.loadThumbnail(
                                it, Size(640, 480), null
                            )
                    } else {
                    }
                }
            }
        }
    }

    private fun getPhotoFileUri(): Uri {
        Timber.i("getPhotoFileUri")
        val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
        val fileName = "IMG_${timeStamp}.jpg"

        var uri: Uri? = null
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val resolver = requireContext().contentResolver
            val contentValues = ContentValues().apply {
                put(MediaStore.MediaColumns.DISPLAY_NAME, fileName)
                put(MediaStore.MediaColumns.MIME_TYPE, "image/jpeg")
                put(MediaStore.MediaColumns.RELATIVE_PATH, "DCIM/kz.v.rbk_test/")
            }

            uri = resolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues)
        }

        return uri ?: getUriForPreQ(fileName)
    }


    private fun getUriForPreQ(fileName: String): Uri {
        Timber.i("getUriForPreQ, &fileName")
        val dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM)
        val photoFile = File(dir, "/kz.v.rbk_test/$fileName")
        if (photoFile.parentFile?.exists() == false) photoFile.parentFile?.mkdir()
        return FileProvider.getUriForFile(
            requireContext(),
            "kz.v.rbk_test.fileprovider",
            photoFile
        )
    }


    private var photoURI: Uri? = null

    private fun openCamera() {
        Timber.i("openCamera")
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            photoURI = getPhotoFileUri()
            takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
            takePictureIntent.resolveActivity(requireActivity().packageManager)?.also {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
            }
        }
    }

    val REQUEST_IMAGE_CAPTURE = 1
}