package by.yarik.meet_me_simply.view.login

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import by.yarik.meet_me_simply.R
import by.yarik.meet_me_simply.view.base.BaseActivity
import by.yarik.meet_me_simply.view.login.fragments.AuthorizationFragment
import by.yarik.meet_me_simply.view.login.fragments.RegistrationFragment
import io.github.inflationx.viewpump.ViewPumpContextWrapper



class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        if(savedInstanceState == null) {
            setRegistrationFragment()
        }
    }

    private fun setAuthorizationFragment() {
        setFragment(AuthorizationFragment.getInstance()!!, R.id.flContainer, false)
    }

    private fun setRegistrationFragment() {
        setFragment(RegistrationFragment.getInstance()!!, R.id.flContainer, false)
    }
}
