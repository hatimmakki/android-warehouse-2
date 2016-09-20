package com.maxwell.androidwarehouse2.interfaces;

/**
 * Created by Maxwell on 20/09/2016.
 */

public interface LoginInteractor {
    void validateUser(String user, String pass, OnLoginFinishListener listener);
}
