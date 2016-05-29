package projet.suiviapprenti.JSON;



import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

import projet.suiviapprenti.beans.Apprenti;

/**
 * Created by nicol on 27/05/2016.
 */
public class JSONDataParse {

    public Apprenti getApprenti(String json) {
        ObjectMapper mapper = new ObjectMapper();
        Apprenti app = null;
        try {
            app = mapper.readValue(json, Apprenti.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return app;
    }

    public Boolean isConnected(String json) {
        ObjectMapper mapper = new ObjectMapper();
        Boolean connected = null;
        try {
            connected = mapper.readValue(json, Boolean.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return connected;
    }
}
