package com.vladimirdanielyan.customviews.activities;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.vladimirdanielyan.customviews.R;
import com.vladimirdanielyan.customviews.views.EditTextViewWithIcon;
import com.vladimirdanielyan.firebasesupportlibrary.activities.Authentication;


@SuppressWarnings("unused")
public abstract class LoginActivity extends Authentication {

    private final static String TAG = LoginActivity.class.getSimpleName();

    EditTextViewWithIcon firstRowOfEditTextView, secondRowOfEditTextView;

    RelativeLayout loginActivityRelativeLayout;

    ImageView logoImageView;

    TextView loginTextView, forgotPasswordTextView;

    Button buttonView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firstRowOfEditTextView = (EditTextViewWithIcon) findViewById(R.id.user_name_edit_text);
        secondRowOfEditTextView = (EditTextViewWithIcon) findViewById(R.id.user_password_edit_text);
        loginActivityRelativeLayout = (RelativeLayout) findViewById(R.id.login_activity_top_view);
        logoImageView = (ImageView) findViewById(R.id.logo_image_view);
        loginTextView = (TextView) findViewById(R.id.login_text_view);
        buttonView = (Button) findViewById(R.id.login_button_view);
        forgotPasswordTextView = (TextView) findViewById(R.id.forgot_password_text_view);
    }

    public void authUser(View view) {
        Log.d(TAG, "Trying To Authenticate");
        if (firstRowOfEditTextView != null && secondRowOfEditTextView != null) {
            signIn(firstRowOfEditTextView.getText(), secondRowOfEditTextView.getText());
        } else {
            Log.d(TAG, "Cannot Take UserName And Password");
        }
    }

    public abstract void requestNewPassword(View view);

    public void setBackground(Drawable drawable) {
        loginActivityRelativeLayout.setBackground(drawable);
    }

    public void setBackground(int colorId) {
        loginActivityRelativeLayout.setBackgroundColor(colorId);
    }

    public void setLogo(Drawable drawable) {
        logoImageView.setImageDrawable(drawable);
    }

    public void setLoginText(String loginText) {
        loginTextView.setText(loginText);
    }

    public void setLoginTextViewColor(int colorId) {
        loginTextView.setTextColor(colorId);
    }

    public void setFirstRowOfEditTextViewHintText(String hintText) {
        firstRowOfEditTextView.setHint(hintText);
    }

    public void setSecondRowOfEditTextViewHintText(String hintText) {
        secondRowOfEditTextView.setHint(hintText);
    }

    public void setFirstRowOfEditTextViewTextType(int textType) {
        firstRowOfEditTextView.setTextType(textType);
    }

    public void setSecondRowOfEditTextViewTextType(int textType) {
        secondRowOfEditTextView.setTextType(textType);
    }

    public void setFirstRowOfEditTextViewIcon(Drawable icon) {
        firstRowOfEditTextView.setIcon(icon);
    }

    public void setSecondRowOfEditTextViewIcon(Drawable icon) {
        secondRowOfEditTextView.setIcon(icon);
    }

    public void setButtonViewText(String text) {
        buttonView.setText(text);
    }

    public void setButtonViewBackground(Drawable background) {
        buttonView.setBackground(background);
    }

    public void setForgotPasswordTextView(String text) {
        forgotPasswordTextView.setText(text);
    }
}
