package projet.suiviapprenti.utils;

import projet.suiviapprenti.JSON.JSONDataParse;

/**
 * Created by nicol on 29/05/2016.
 */
public class Form {
    protected JSONDataParse parser;
    protected static final String IP_REST  = "192.168.0.6:8080/testRestAndroid/rest";

    public Form() {
        parser = new JSONDataParse();
    }
}
