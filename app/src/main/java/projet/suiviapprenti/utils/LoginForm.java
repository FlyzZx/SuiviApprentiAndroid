package projet.suiviapprenti.utils;

import java.util.concurrent.ExecutionException;

import projet.suiviapprenti.JSON.JSONDataParse;
import projet.suiviapprenti.networks.SimpleHTTPGet;

/**
 * Created by nicol on 29/05/2016.
 */
public class LoginForm extends Form{
    private static final String PATH_LOGIN   = "/login/";
    private static final String EXC_LOG      = "Email ou mot de passe invalide";

    public LoginForm() {

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
            String ret = new SimpleHTTPGet().execute("http://" + IP_REST + PATH_LOGIN + mail + "/" + mdp).get(); //Connexion
            if(!ret.equals("")) throw new Exception(EXC_LOG); //Levé d'exception en cas d'erreur de mdp
        } catch (InterruptedException e) {
            throw new Exception(e.getMessage());
        } catch (ExecutionException e) {
            throw new Exception(e.getMessage());
        }
    }
}
