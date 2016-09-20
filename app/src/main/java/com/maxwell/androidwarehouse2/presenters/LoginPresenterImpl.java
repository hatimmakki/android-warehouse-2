package com.maxwell.androidwarehouse2.presenters;

import com.maxwell.androidwarehouse2.interactors.LoginInteractorImpl;
import com.maxwell.androidwarehouse2.interfaces.LoginInteractor;
import com.maxwell.androidwarehouse2.interfaces.LoginPresenter;
import com.maxwell.androidwarehouse2.interfaces.LoginView;
import com.maxwell.androidwarehouse2.interfaces.OnLoginFinishListener;

/**
 * Created by Maxwell on 20/09/2016.
 */

public class LoginPresenterImpl implements LoginPresenter, OnLoginFinishListener {

    private LoginView view;
    private LoginInteractor interactor;

    public LoginPresenterImpl(LoginView view) {
        this.view = view;
        this.interactor = new LoginInteractorImpl();
    }

    @Override
    public void validateUser(String user, String pass) {
        if (view != null) {
            view.showProgress();
            interactor.validateUser(user, pass, this);
        }
    }

    @Override
    public void userNameError() {
        if (view != null) {
            view.showProgress();
            view.setErrorUser();
        }
    }

    @Override
    public void passwordError() {
        if (view != null) {
            view.showProgress();
            view.setErrorPassword();
        }
    }

    @Override
    public void onSuccess() {
        if (view != null) {
            view.showProgress();
            view.navigateToHome();
        }
    }
}
