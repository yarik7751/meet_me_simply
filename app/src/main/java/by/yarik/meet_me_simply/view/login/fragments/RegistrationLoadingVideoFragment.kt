package by.yarik.meet_me_simply.view.login.fragments

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import by.yarik.meet_me_simply.R
import by.yarik.meet_me_simply.api.FirebaseStorage
import by.yarik.meet_me_simply.presenter.RegistrationLoadingVideoPresenter
import by.yarik.meet_me_simply.relations.RegistrationLoadingVideoRelations
import by.yarik.meet_me_simply.utils.PermissionUtils
import by.yarik.meet_me_simply.view.base.BaseFragment
import by.yarik.meet_me_simply.view.login.fragments.adapters.AnswersAdapter
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import kotlinx.android.synthetic.main.fragment_registration_loading_video.*

class RegistrationLoadingVideoFragment : BaseFragment(), RegistrationLoadingVideoRelations.IView {

    private val TAG = "RegFragLoadVideo_log"

    private val RECORD_REQUEST_CODE = 102
    private val VIDEO_CAPTURE = 101

    companion object {
        var fragment: RegistrationLoadingVideoFragment? = null

        fun getInstance(): RegistrationLoadingVideoFragment? {
            if(fragment == null) {
                fragment = RegistrationLoadingVideoFragment()
            }
            return fragment
        }
    }

    lateinit var presenter: RegistrationLoadingVideoPresenter
    lateinit var adapter: AnswersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = RegistrationLoadingVideoPresenter(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_registration_loading_video, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imgRecVideo.setOnClickListener {
            requestCameraPermissions()
        }

        btnAnswers.setOnClickListener {
            loadAnswerAnimations()
        }

        adapter = AnswersAdapter(context!!);
        vpAnswers.adapter = adapter
        inkIndicator.setViewPager(vpAnswers)
    }

    private fun loadAnswerAnimations() {
        var btnAnimation = AnimationUtils.loadAnimation(context, R.anim.fade_out)

        btnAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationRepeat(animation: Animation?) {}

            override fun onAnimationEnd(animation: Animation?) {
                btnAnswers.alpha = 0f;
                btnAnswers.visibility = View.GONE
                vpAnswers.visibility = View.VISIBLE
                inkIndicator.visibility = View.VISIBLE
                vpAnswers.currentItem = 0;
            }

            override fun onAnimationStart(animation: Animation?) {}
        })
        btnAnswers.startAnimation(btnAnimation)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode) {
            RECORD_REQUEST_CODE -> {
                if(PermissionUtils.isAllPermissionsGranted(grantResults)) {
                    openCameraActivity()
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK && requestCode == VIDEO_CAPTURE) {
            var uri = data!!.data;
            var path = getRealPathFromURI(context!!, uri)
            //todo test adding video
            Log.d(TAG, "path: $path")
            FirebaseStorage.uploadVideo(path,
                    OnSuccessListener {
                        Log.d(TAG, "OnSuccessListener")
                    }, OnFailureListener {
                Log.d(TAG, "OnFailureListener: ${it.localizedMessage}")
            })
        }
    }

    private fun getRealPathFromURI(context: Context, contentUri: Uri): String {
        var cursor: Cursor? = null
        try {
            val proj = arrayOf(MediaStore.Images.Media.DATA)
            cursor = context.getContentResolver().query(contentUri, proj, null, null, null)
            val column_index = cursor!!.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
            cursor!!.moveToFirst()
            return cursor!!.getString(column_index)
        } catch (e: Exception) {
            Log.e(TAG, "getRealPathFromURI Exception : " + e.toString())
            return ""
        } finally {
            if (cursor != null) {
                cursor!!.close()
            }
        }
    }

    private fun requestCameraPermissions() {
        requestPermissions(
                arrayOf(
                        Manifest.permission.CAMERA,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.RECORD_AUDIO
                ),
                RECORD_REQUEST_CODE)
    }

    private fun openCameraActivity() {
        var intent = Intent(MediaStore.ACTION_VIDEO_CAPTURE)
        startActivityForResult(intent, VIDEO_CAPTURE)
    }
}