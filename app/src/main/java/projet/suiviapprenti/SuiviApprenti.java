package projet.suiviapprenti;

import android.app.Application;

import java.net.CookieHandler;
import java.net.CookieManager;

/**
 * Created by nicol on 27/05/2016.
 */
public class SuiviApprenti extends Application {

    /**
     * Lancé au début de l'appli, cette methode permet d'executer ce qui doit l'etre une seule et unique fois
     */
    @Override
    public void onCreate() {
        super.onCreate();
        //Persistance des cookies
        CookieManager cookieManager = new CookieManager();
        CookieHandler.setDefault(cookieManager);
    }
}
