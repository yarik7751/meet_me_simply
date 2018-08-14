package by.yarik.meet_me_simply.view.login

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import by.yarik.meet_me_simply.R
import by.yarik.meet_me_simply.relations.AuthorizationRelations
import by.yarik.meet_me_simply.view.base.BaseActivity
import by.yarik.meet_me_simply.view.login.fragments.AuthorizationFragment
import by.yarik.meet_me_simply.view.login.fragments.RegistrationFragment
import by.yarik.meet_me_simply.view.login.fragments.RegistrationLoadingVideoFragment
import io.github.inflationx.viewpump.ViewPumpContextWrapper



class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        if(savedInstanceState == null) {
            setAuthorizationFragment()
        }
    }

    fun setAuthorizationFragment() {
        setFragment(AuthorizationFragment.getInstance()!!, R.id.flContainer, false)
    }

    fun setRegistrationFragment() {
        setFragment(RegistrationLoadingVideoFragment.getInstance()!!, R.id.flContainer, true)
    }
}
