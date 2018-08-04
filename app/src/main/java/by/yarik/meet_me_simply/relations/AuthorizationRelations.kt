package by.yarik.meet_me_simply.relations

object AuthorizationRelations {
    interface IView {
        fun showError()
        fun showEmptyDataError()
    }

    interface IPresenter {
        fun onLoginClickButton(login: String, password: String)
        fun onRegClickButton()
    }

    interface IInteractor {
        fun login(login: String, password: String)
    }

    interface IInteractorOutput {
        fun loginSuccess(login: String, password: String)
        fun loginError()
    }

    interface IRouter {
        fun openHome()
        fun openRegistration()
    }
}