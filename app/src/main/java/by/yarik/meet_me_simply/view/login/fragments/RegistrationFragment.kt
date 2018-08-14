package by.yarik.meet_me_simply.view.login.fragments

import android.Manifest
import android.app.Activity.RESULT_OK
import android.content.Context
import android.content.Intent
import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.yarik.meet_me_simply.R
import by.yarik.meet_me_simply.api.FirebaseStorage
import by.yarik.meet_me_simply.utils.PermissionUtils
import by.yarik.meet_me_simply.view.base.BaseFragment
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import kotlinx.android.synthetic.main.fragment_registration.*



class RegistrationFragment : BaseFragment() {

    companion object {
        var fragment: RegistrationFragment? = null

        fun getInstance(): RegistrationFragment? {
            if(fragment == null) {
                fragment = RegistrationFragment()
            }
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_registration, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


}