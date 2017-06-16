package bolalob.develops.stud11314025.availaballs;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

    @Bind(R.id.eTEmail)
    EditText etEmail;
    @Bind(R.id.eTPassword)
    EditText etPassword;
    @Bind(R.id.btnLogin)
    Button btnLgn;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);



        btnLgn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String tempUsername = etEmail.getText().toString();
                final String tempPassword = etPassword.getText().toString();
                if(tempUsername.equals("okta.p.nainggolan@gmail.com")&&tempPassword.equals("N4!n990l4n")){
                    Intent mainIntent =new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(mainIntent);
                }
                else if (tempPassword.isEmpty()||tempUsername.isEmpty()){
                    Snackbar snackbar = Snackbar.make(view, "Email atau Password Kosong", Snackbar.LENGTH_LONG)
                            .setAction("Action", null);
                    View sbView = snackbar.getView();
                    sbView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorSnackbar));
                    snackbar.show();
                }
                else {
                    Snackbar snackbar = Snackbar.make(view, "Akun Tidak Terdaftar", Snackbar.LENGTH_LONG)
                            .setAction("Action", null);
                    View sbView = snackbar.getView();
                    sbView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorSnackbar));
                    snackbar.show();
                }

            }
        });
    }
}