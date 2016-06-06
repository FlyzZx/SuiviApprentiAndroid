package projet.suiviapprenti.views.fragments;

import android.app.Fragment;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import projet.suiviapprenti.JSON.JSONDataParse;
import projet.suiviapprenti.R;
import projet.suiviapprenti.beans.Apprenti;
import projet.suiviapprenti.networks.SimpleHTTPPost;
import projet.suiviapprenti.utils.ProfilForm;

/**
 * Created by nicol on 31/05/2016.
 */
public class ModifProfilFragment extends Fragment implements View.OnClickListener {
    EditText edtRue, edtVille, edtCodePostal, edtMail, edtTel, edtMobile, edtSite, edtMission;
    Button btnValidModif;
    Apprenti app;
    ProfilForm profilForm;

    private void initialize(View v) {

        profilForm = new ProfilForm();

        edtRue = (EditText) v.findViewById(R.id.editText_profil_rue);
        edtVille = (EditText) v.findViewById(R.id.editText_profil_ville);
        edtCodePostal = (EditText) v.findViewById(R.id.editText_profil_codePostal);
        edtMail = (EditText) v.findViewById(R.id.editText_profil_mail);
        edtTel = (EditText) v.findViewById(R.id.editText_profil_phone);
        edtMobile = (EditText) v.findViewById(R.id.editText_profil_mobile);
        edtSite = (EditText) v.findViewById(R.id.editText_profil_site);
        edtMission = (EditText) v.findViewById(R.id.editText_profil_mission);

        btnValidModif = (Button) v.findViewById(R.id.button_profil_validModif);
        btnValidModif.setOnClickListener(this);
    }

    private void updateEditText() {
        edtRue.setText(app.getCoordonnees().getRue());
        edtVille.setText(app.getCoordonnees().getVille());
        edtCodePostal.setText(app.getCoordonnees().getCodePostal());
        edtMail.setText(app.getCoordonnees().getEmail());
        edtTel.setText(app.getCoordonnees().getTelephone());
        edtMobile.setText(app.getCoordonnees().getMobile());
        edtSite.setText(app.getCoordonnees().getSite());
        edtMission.setText(app.getMissionPrincipale());
    }

    private List<String> getValuesEdt() {
        List<String> values = new ArrayList<>();
        values.add(edtRue.getText().toString());
        values.add(edtVille.getText().toString());
        values.add(edtCodePostal.getText().toString());
        values.add(edtMail.getText().toString());
        values.add(edtTel.getText().toString());
        values.add(edtMobile.getText().toString());
        values.add(edtSite.getText().toString());
        values.add(edtMission.getText().toString());

        return values;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.modifier_profil_fragment, container, false);
        app = (Apprenti) getArguments().get("Apprenti");
        initialize(v);
        updateEditText();
        return v;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch(id) {
            case R.id.button_profil_validModif:
                String ret = profilForm.updateApprenti(getValuesEdt());
                if(ret.equals("")) {
                    ProfilFragment profilFragment = new ProfilFragment();
                    try {
                        app = profilForm.getInfosPersonnelles();    //Mise à jour de l'apprenti
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("Apprenti", app);
                        profilFragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.fragment_container_profil, profilFragment).commit();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                } else {
                    JSONDataParse jsonParser = new JSONDataParse();
                    try {
                        HashMap<String, String> erreurs = jsonParser.getErreurs(ret);
                        showErrors(v, erreurs);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                break;
            default:
                break;
        }
    }

    private void showErrors(View v, HashMap<String, String> erreurs) {
        Iterator keys = erreurs.keySet().iterator();
        Toast.makeText(v.getContext(), "Il y a des erreurs de saisies", Toast.LENGTH_LONG).show();
        while(keys.hasNext()) {
            switch((String) keys.next()) {
                case ProfilForm.CHAMP_RUE:
                    edtRue.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
                    break;
                case ProfilForm.CHAMP_VILLE:
                    edtVille.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
                    break;
                case ProfilForm.CHAMP_POSTAL:
                    edtCodePostal.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
                    break;
                case ProfilForm.CHAMP_MAIL:
                    edtMail.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
                    break;
                case ProfilForm.CHAMP_TEL:
                    edtTel.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
                    break;
                case ProfilForm.CHAMP_MOBILE:
                    edtMobile.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
                    break;
                case ProfilForm.CHAMP_SITE:
                    edtSite.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
                    break;
                case ProfilForm.CHAMP_M_PRINCIP:
                    edtMission.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
                    break;
                default:

                    break;
            }
        }
    }
}
