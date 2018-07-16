package by.yarik.meet_me_simply.view.base

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import io.github.inflationx.viewpump.ViewPumpContextWrapper

open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //AndroidUtils.hideKeyBoard(this)
    }

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase!!))
    }

    fun  setFragment(fragment: Fragment, container: Int, add: Boolean) {
        val tag = fragment.javaClass.name
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(container, fragment, tag)
        if(add) transaction.addToBackStack(tag)
        transaction.commit()
    }
}