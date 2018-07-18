package by.yarik.meet_me_simply.view.login.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.yarik.meet_me_simply.R
import by.yarik.meet_me_simply.view.login.LoginActivity
import kotlinx.android.synthetic.main.fragment_authorization.*
import java.io.FileDescriptor
import java.io.PrintWriter

class AuthorizationFragment : Fragment() {

    companion object {
        var fragment: AuthorizationFragment? = null

        fun getInstance(): AuthorizationFragment? {
            if(fragment == null) {
                fragment = AuthorizationFragment()
            }
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_authorization, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnRegistration.setOnClickListener {
            //todo
            (activity as LoginActivity).setRegistrationFragment()
        }
    }
}