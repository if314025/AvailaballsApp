package bolalob.develops.stud11314025.availaballs.Activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import bolalob.develops.stud11314025.availaballs.LoginMVP.LoginPresenter;
import bolalob.develops.stud11314025.availaballs.LoginMVP.LoginPresenterImp;
import bolalob.develops.stud11314025.availaballs.LoginMVP.LoginView;
import bolalob.develops.stud11314025.availaballs.R;
import butterknife.Bind;
import butterknife.ButterKnife;

//import android.support.design.R;

public class LoginActivity extends AppCompatActivity implements LoginView {

    @Bind(R.id.eTEmail)
    EditText etEmail;
    @Bind(R.id.eTPassword)
    EditText etPassword;
    @Bind(R.id.btnLogin)
    Button btnLgn;
    private LoginPresenter presenter;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        presenter = new LoginPresenterImp(this);

        btnLgn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.login(etEmail.getText().toString(), etPassword.getText().toString());
            }
        });
    }

    @Override
    public void showValidationError() {
        Snackbar snackbar = Snackbar.make(findViewById(R.id.activity_login), "Email atau Password Kosong", Snackbar.LENGTH_LONG)
                .setAction("Action", null);
        View sbView = snackbar.getView();
        sbView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorSnackbar));

        TextView tv = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1)
            tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        else
            tv.setGravity(Gravity.CENTER_HORIZONTAL);
        snackbar.show();
    }

    @Override
    public void loginSucess() {
        Intent mainIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(mainIntent);
    }

    @Override
    public void loginError() {
        Snackbar snackbar = Snackbar
                .make(findViewById(R.id.activity_login), "Akun Tidak Terdaftar", Snackbar.LENGTH_SHORT)
                .setAction("Action", null);
        View sbView = snackbar.getView();
        sbView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorSnackbar));

        TextView tv = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1)
            tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        else
            tv.setGravity(Gravity.CENTER_HORIZONTAL);
        snackbar.show();

    }
}