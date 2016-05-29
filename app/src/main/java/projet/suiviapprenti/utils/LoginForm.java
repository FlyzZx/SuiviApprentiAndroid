package projet.suiviapprenti.utils;

import java.util.concurrent.ExecutionException;

import projet.suiviapprenti.JSON.JSONDataParse;
import projet.suiviapprenti.networks.SimpleHTTPGet;

/**
 * Created by nicol on 29/05/2016.
 */
public class LoginForm {
    private JSONDataParse parser;

    public LoginForm() {
        parser = new JSONDataParse();
    }

    /**
     *
     * @param mail
     * @param mdp
     * @return true if connected, false is not connected
     */
    public void sendConnection(String mail, String mdp) throws Exception {
        //TODO Fonction verifier Mail et verifier Mot de passe (SECURITE)
        try {
            String ret = new SimpleHTTPGet().execute("http://192.168.0.6:8080/testRestAndroid/rest/login/" + mail + "/" + mdp).get(); //Connexion
            if(!ret.equals("")) throw new Exception("Email ou mot de passe invalide"); //Levé d'exception en cas d'erreur de mdp
        } catch (InterruptedException e) {
            throw new Exception(e.getMessage());
        } catch (ExecutionException e) {
            throw new Exception(e.getMessage());
        }
    }
}
