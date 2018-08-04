package by.yarik.meet_me_simply.router

import android.app.Activity
import by.yarik.meet_me_simply.relations.AuthorizationRelations
import by.yarik.meet_me_simply.view.login.LoginActivity

class AuthorizationRouter(var activity: Activity) : AuthorizationRelations.IRouter {

    override fun openHome() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun openRegistration() {
        (activity as LoginActivity).setRegistrationFragment()
    }
}