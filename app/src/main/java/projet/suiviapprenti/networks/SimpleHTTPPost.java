package projet.suiviapprenti.networks;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by nicol on 31/05/2016.
 */
public class SimpleHTTPPost extends AsyncTask<Object, Integer, String> {
    StringBuilder retour;
    HttpURLConnection conn;
    String param;
    @Override
    protected String doInBackground(Object... params) {
        retour = new StringBuilder();

        try {
            URL url = new URL((String) params[0]);
            conn = (HttpURLConnection) url.openConnection();
            Map<String, String> parameters = (HashMap<String, String>) params[1];

            conn.setRequestMethod("POST");
            conn.setDoInput(true);
            conn.setDoOutput(true);
            param = makeUrlParameters(parameters);
            conn.connect();

            DataOutputStream dataStreamOutput = new DataOutputStream(conn.getOutputStream());

            dataStreamOutput.writeBytes(param);
            dataStreamOutput.flush();
            dataStreamOutput.close();

            // read the output from the server
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String line = null;
            while ((line = reader.readLine()) != null)
            {
                retour.append(line + "\n");
            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            conn.disconnect();
        }

        return retour.toString();
    }

    private String makeUrlParameters(Map<String, String> parameters) {
        StringBuilder resultParams = new StringBuilder();
        Boolean first = true;
        Iterator i = parameters.keySet().iterator();

        while(i.hasNext()) {
            if(first) {
                first = false;
            } else {
                resultParams.append("&");
            }
            String key = (String) i.next();
            resultParams.append(key + "=" + parameters.get(key));
        }

        return resultParams.toString();
    }
}
