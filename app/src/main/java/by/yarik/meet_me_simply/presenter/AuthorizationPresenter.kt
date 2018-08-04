package by.yarik.meet_me_simply.presenter

import by.yarik.meet_me_simply.interactor.AuthorizationInteractor
import by.yarik.meet_me_simply.relations.AuthorizationRelations
import by.yarik.meet_me_simply.router.AuthorizationRouter
import by.yarik.meet_me_simply.view.login.LoginActivity
import by.yarik.meet_me_simply.view.login.fragments.AuthorizationFragment

class AuthorizationPresenter(var view: AuthorizationRelations.IView) : AuthorizationRelations.IPresenter,
        AuthorizationRelations.IInteractorOutput {

    var router: AuthorizationRouter
    var interactor: AuthorizationInteractor
    init {
        router = AuthorizationRouter((view as AuthorizationFragment).activity!!)
        interactor = AuthorizationInteractor(this)
    }

    override fun onLoginClickButton(login: String, password: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onRegClickButton() {
        router.openRegistration()
    }

    override fun loginSuccess(login: String, password: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loginError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}