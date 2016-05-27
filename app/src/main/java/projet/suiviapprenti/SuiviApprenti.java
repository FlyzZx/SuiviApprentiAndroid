package projet.suiviapprenti;

import android.app.Application;

import java.net.CookieHandler;
import java.net.CookieManager;

/**
 * Created by nicol on 27/05/2016.
 */
public class SuiviApprenti extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CookieManager cookieManager = new CookieManager();
        CookieHandler.setDefault(cookieManager);
    }
}
