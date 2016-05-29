package projet.suiviapprenti.utils;

import projet.suiviapprenti.beans.Apprenti;
import projet.suiviapprenti.networks.SimpleHTTPGet;

/**
 * Created by nicol on 29/05/2016.
 */
public class ProfilForm extends Form {
    private static final String PATH_INFOS_PERSO    = "/profil/infosPersonnelles";

    public ProfilForm() {

    }

    public Apprenti getInfosPersonnelles() throws Exception {
        String jsonRet = new SimpleHTTPGet().execute("http://" + IP_REST + PATH_INFOS_PERSO).get();
        Apprenti app = parser.getApprenti(jsonRet);

        if(app == null) throw new Exception(); ///Exception pour detecter le besoin d'une reconnection coté vue

        return app;
    }
}
