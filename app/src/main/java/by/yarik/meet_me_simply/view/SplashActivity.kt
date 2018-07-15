package by.yarik.meet_me_simply.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import by.yarik.meet_me_simply.view.login.LoginActivity
import org.jetbrains.anko.startActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity<LoginActivity>()
        finish()
    }
}
