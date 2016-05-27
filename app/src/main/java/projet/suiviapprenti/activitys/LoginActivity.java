package projet.suiviapprenti.activitys;

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


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edtMail, edtPassword;
    Button btnConnexion, btndebug;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnConnexion = (Button) findViewById(R.id.button_connexion);
        edtMail = (EditText) findViewById(R.id.editTextLogin_mail);
        edtPassword = (EditText) findViewById(R.id.editTextLogin_password);
        btnConnexion.setOnClickListener(this);
        btndebug = (Button) findViewById(R.id.button);
        btndebug.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.button_connexion:
                try {
                    String ret = new SimpleHTTPGet().execute("http://192.168.0.6:8080/testRestAndroid/rest/login/" + edtMail.getText() + "/" + edtPassword.getText()).get(); //Connexion
                    Snackbar.make(v, ret, Snackbar.LENGTH_LONG).show();
                    Intent intent = getIntent();


                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.button:
                try {
                    String ret = new SimpleHTTPGet().execute("http://192.168.0.6:8080/testRestAndroid/rest/login/isConnected").get(); //Connexion
                    Snackbar.make(v, ret, Snackbar.LENGTH_LONG).show();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
        }



    }


}
