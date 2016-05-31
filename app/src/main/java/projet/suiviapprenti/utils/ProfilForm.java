package projet.suiviapprenti.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import projet.suiviapprenti.beans.Apprenti;
import projet.suiviapprenti.networks.SimpleHTTPGet;
import projet.suiviapprenti.networks.SimpleHTTPPost;

/**
 * Created by nicol on 29/05/2016.
 */
public class ProfilForm extends Form {
    private static final String PATH_INFOS_PERSO    = "/profil/infosPersonnelles";
    private static final String PATH_UPDT_PROFIL    = "/profil/modifierProfil";
    public static final String CHAMP_RUE		    = "rue";
    public static final String CHAMP_VILLE		    = "ville";
    public static final String CHAMP_POSTAL		    = "codePostal";
    public static final String CHAMP_MAIL		    = "email";
    public static final String CHAMP_TEL		    = "telephone";
    public static final String CHAMP_MOBILE		    = "mobile";
    public static final String CHAMP_SITE		    = "site";
    public static final String CHAMP_M_PRINCIP	    = "missionPrincipale";
    public static final String CHAMP_PASS		    = "password";
    public static final String CHAMP_PASS_VERIF	    = "passwordVerif";

    public ProfilForm() {

    }

    public Apprenti getInfosPersonnelles() throws Exception {
        String jsonRet = new SimpleHTTPGet().execute("http://" + IP_REST + PATH_INFOS_PERSO).get();
        Apprenti app = parser.getApprenti(jsonRet);

        if(app == null) throw new Exception(); ///Exception pour detecter le besoin d'une reconnection coté vue

        return app;
    }

    public String updateApprenti(List<String> values) {
        Map<String, String> params = new HashMap<>();
        String jsonRet = null;
        params.put(CHAMP_RUE, values.get(0));
        params.put(CHAMP_VILLE, values.get(1));
        params.put(CHAMP_POSTAL, values.get(2));
        params.put(CHAMP_MAIL, values.get(3));
        params.put(CHAMP_TEL, values.get(4));
        params.put(CHAMP_MOBILE, values.get(5));
        params.put(CHAMP_SITE, values.get(6));
        params.put(CHAMP_M_PRINCIP, values.get(7));
        params.put(CHAMP_PASS, "");
        params.put(CHAMP_PASS_VERIF, "");


        try {
            jsonRet = new SimpleHTTPPost().execute("http://" + IP_REST + PATH_UPDT_PROFIL, params).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return jsonRet;
    }
}
