package com.maxwell.androidwarehouse2.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.maxwell.androidwarehouse2.R;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Maxwell on 02/10/2015.
 */
public class DialogUtils extends Dialog implements View.OnClickListener {
    public Activity activity;
    Class toActivity;
    List<String> content;
    @Bind(R.id.tvTitleDialog)
    TextView tvTitleDialog;
    @Bind(R.id.tvDescDialog)
    TextView tvDescDialog;
    @Bind(R.id.btPos)
    Button btPos;
    @Bind(R.id.tvNegative)
    TextView tvNegative;

    /*
     * Content(0) = Titulo
     * Content(1) = Descripcion
     * Content(2) = Boton Positivo
     * Content(3) = Boton Negativo
     */
    public DialogUtils(Activity fromActivity, Class toActivity, List<String> content) {
        super(fromActivity);
        this.activity = fromActivity;
        this.toActivity = toActivity;
        this.content = content;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_layout);

        ButterKnife.bind(this);

        tvTitleDialog.setText(content.get(0));
        tvDescDialog.setText(content.get(1));
        btPos.setText(content.get(2));
        tvNegative.setText(content.get(3));

        btPos.setOnClickListener(this);
        tvNegative.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btPos:
                activity.startActivity(new Intent(activity, toActivity));
                break;
            case R.id.tvNegative:
                dismiss();
                break;
            default:
                break;
        }
        dismiss();
    }
}
