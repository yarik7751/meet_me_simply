package by.yarik.meet_me_simply.view.login.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.yarik.meet_me_simply.R
import by.yarik.meet_me_simply.presenter.AuthorizationPresenter
import by.yarik.meet_me_simply.relations.AuthorizationRelations
import by.yarik.meet_me_simply.router.AuthorizationRouter
import by.yarik.meet_me_simply.view.base.BaseFragment
import by.yarik.meet_me_simply.view.login.LoginActivity
import kotlinx.android.synthetic.main.fragment_authorization.*
import java.io.FileDescriptor
import java.io.PrintWriter

class AuthorizationFragment : BaseFragment(), AuthorizationRelations.IView {

    companion object {
        var fragment: AuthorizationFragment? = null

        fun getInstance(): AuthorizationFragment? {
            if(fragment == null) {
                fragment = AuthorizationFragment()
            }
            return fragment
        }
    }

    lateinit var presenter: AuthorizationPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = AuthorizationPresenter(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_authorization, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnRegistration.setOnClickListener {
            presenter.onRegClickButton()
        }
    }

    override fun showError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showEmptyDataError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}