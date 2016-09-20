package com.maxwell.androidwarehouse2.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.maxwell.androidwarehouse2.R;
import com.maxwell.androidwarehouse2.interfaces.LoginPresenter;
import com.maxwell.androidwarehouse2.interfaces.LoginView;
import com.maxwell.androidwarehouse2.presenters.LoginPresenterImpl;

import butterknife.Bind;
import butterknife.ButterKnife;

public class Login extends AppCompatActivity implements LoginView {
    @Bind(R.id.etUser)
    EditText etUser;
    @Bind(R.id.etPass)
    EditText etPass;
    @Bind(R.id.pbLoading)
    ProgressBar pbLoading;

    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        ButterKnife.bind(this);

        presenter = new LoginPresenterImpl(this);
    }

    @Override
    public void showProgress() {
        pbLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        pbLoading.setVisibility(View.GONE);
    }

    @Override
    public void setErrorUser() {
        etUser.setError("Campo Obligatorio");
    }

    @Override
    public void setErrorPassword() {
        etPass.setError("Campo Obligatorio");
    }

    @Override
    public void navigateToHome() {
        startActivity(new Intent(Login.this, PrincipalMenu.class));
    }

    public void validation(View v) {
        String user = etUser.getText().toString();
        String pass = etPass.getText().toString();

        presenter.validateUser(user, pass);
    }
}
