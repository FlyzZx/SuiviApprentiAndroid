package projet.suiviapprenti.activitys;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.concurrent.ExecutionException;

import projet.suiviapprenti.R;
import projet.suiviapprenti.networks.SimpleHTTPGet;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edtMail, edtPassword;
    Button btnConnexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnConnexion = (Button) findViewById(R.id.button_connexion);
        edtMail = (EditText) findViewById(R.id.editTextLogin_mail);
        edtPassword = (EditText) findViewById(R.id.editTextLogin_password);

        btnConnexion.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        try {
            String json = new SimpleHTTPGet().execute("http://192.168.0.6:8080/testRestAndroid/rest/login/" + edtMail.getText() + "/" + edtPassword.getText()).get();
            Snackbar.make(v, json, Snackbar.LENGTH_LONG).show();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
