package projet.suiviapprenti.utils;

import projet.suiviapprenti.JSON.JSONDataParse;

/**
 * Created by nicol on 29/05/2016.
 */
public class Form {
    protected JSONDataParse parser;
    protected static final String IP_REST  = "82.240.139.63:8080/SuiviApprenti/rest";

    public Form() {
        parser = new JSONDataParse();
    }
}
