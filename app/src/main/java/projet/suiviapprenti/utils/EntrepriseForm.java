package projet.suiviapprenti.utils;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.type.TypeReference;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import projet.suiviapprenti.JSON.JSONViews;
import projet.suiviapprenti.beans.Entreprise;
import projet.suiviapprenti.networks.SimpleHTTPGet;

/**
 * Created by nicol on 10/06/2016.
 */
public class EntrepriseForm extends Form {
    private static final String PATH_ENT_AUTO   = "/entreprise/autocomplete?term=";

    public List<Entreprise> getEntrepriseBeginWith(String begin) {
        List<Entreprise> retour = null;
        try {
            String json = new SimpleHTTPGet().execute("http://" + Form.IP_REST + PATH_ENT_AUTO + begin.toLowerCase()).get();
            ObjectMapper mapper = new ObjectMapper();
            retour = new ArrayList<>();
            retour = mapper.readValue(json, new TypeReference<List<Entreprise>>() {});
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return retour;
    }
}
