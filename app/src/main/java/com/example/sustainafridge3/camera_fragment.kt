package com.example.sustainafridge3

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.camera.core.CameraSelector
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.core.content.ContextCompat

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [camera_fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class camera_fragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_camera_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewFinder: PreviewView = view.findViewById(R.id.camera_view)
        val cameraProviderFuture = ProcessCameraProvider.getInstance(view.context)

        cameraProviderFuture.addListener({
            // Get the CameraProvider
            val cameraProvider = cameraProviderFuture.get()

            // Set up your use cases, e.g., Preview, ImageCapture, etc.
            val preview = Preview.Builder().build()

            // Connect the preview to the camera
            preview.setSurfaceProvider(viewFinder.createSurfaceProvider())

            // Create a camera selector (e.g., front or back camera)
            val cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA

            // Bind the use cases to the lifecycle
            try {
                cameraProvider.unbindAll()
                cameraProvider.bindToLifecycle(this, cameraSelector, preview)
            } catch (exception: Exception) {
                //Log.e(TAG, "Use case binding failed", exception)
            }
        }, ContextCompat.getMainExecutor(requireContext()))

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment camera_fragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            camera_fragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}