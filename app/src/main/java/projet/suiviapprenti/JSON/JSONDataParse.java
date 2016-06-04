package projet.suiviapprenti.JSON;



import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;

import projet.suiviapprenti.beans.Apprenti;

/**
 * Created by nicol on 27/05/2016.
 */
public class JSONDataParse {
    private static final String ERR_PARSE   = "Format d'entrée JSON incorrect..";

    public Apprenti getApprenti(String json) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Apprenti app = null;
        try {
            app = mapper.readValue(json, Apprenti.class);
        } catch (IOException e) {
            throw new Exception(ERR_PARSE);
        }

        return app;
    }

    public Boolean isConnected(String json) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Boolean connected = null;
        try {
            connected = mapper.readValue(json, Boolean.class);
        } catch (IOException e) {
            throw new Exception(ERR_PARSE);
        }

        return connected;
    }

    public HashMap<String, String> getErreurs(String json) throws Exception {
        HashMap<String, String> erreurs = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.readValue(json, erreurs.getClass());
        } catch (IOException e) {
            throw new Exception(ERR_PARSE);
        }

        return erreurs;
    }
}
