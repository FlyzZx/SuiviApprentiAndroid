package projet.suiviapprenti.views.activitys;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.concurrent.ExecutionException;

import projet.suiviapprenti.JSON.JSONDataParse;
import projet.suiviapprenti.R;
import projet.suiviapprenti.beans.Apprenti;
import projet.suiviapprenti.networks.SimpleHTTPGet;
import projet.suiviapprenti.utils.LoginForm;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edtMail, edtPassword;
    Button btnConnexion;
    LoginForm loginForm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginForm = new LoginForm();
        btnConnexion = (Button) findViewById(R.id.button_connexion);
        edtMail = (EditText) findViewById(R.id.editTextLogin_mail);
        edtPassword = (EditText) findViewById(R.id.editTextLogin_password);
        btnConnexion.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.button_connexion:
                try {
                    loginForm.sendConnection(edtMail.getText().toString(), edtPassword.getText().toString());
                    Intent intent = new Intent(this, LoggedActivity.class);
                    startActivity(intent);
                } catch (Exception e) {
                    Snackbar.make(v, e.getMessage(), Snackbar.LENGTH_LONG).show();
                }
                break;
        }



    }



}
