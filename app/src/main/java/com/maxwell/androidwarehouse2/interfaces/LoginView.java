package com.maxwell.androidwarehouse2.interfaces;

/**
 * Created by Maxwell on 20/09/2016.
 */

public interface LoginView {
    void showProgress();
    void hideProgress();

    void setErrorUser();
    void setErrorPassword();

    void navigateToHome();
}
