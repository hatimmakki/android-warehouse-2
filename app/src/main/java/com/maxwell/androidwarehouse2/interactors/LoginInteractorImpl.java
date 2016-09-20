package com.maxwell.androidwarehouse2.interactors;

import android.os.Handler;

import com.maxwell.androidwarehouse2.interfaces.LoginInteractor;
import com.maxwell.androidwarehouse2.interfaces.OnLoginFinishListener;

/**
 * Created by Maxwell on 20/09/2016.
 */

public class LoginInteractorImpl implements LoginInteractor {
    @Override
    public void validateUser(final String user, final String pass, final OnLoginFinishListener listener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(user.isEmpty()){
                    listener.userNameError();
                }else if(pass.isEmpty()){
                    listener.passwordError();
                }else{
                    listener.onSuccess();
                }
            }
        }, 2000);
    }
}
