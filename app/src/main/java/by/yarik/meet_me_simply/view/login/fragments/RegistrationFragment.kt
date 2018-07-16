package by.yarik.meet_me_simply.view.login.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.yarik.meet_me_simply.R

class RegistrationFragment : Fragment() {

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