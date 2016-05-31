package projet.suiviapprenti.views.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import projet.suiviapprenti.R;
import projet.suiviapprenti.beans.Apprenti;

/**
 * Created by nicol on 31/05/2016.
 */
public class ModifProfilFragment extends Fragment implements View.OnClickListener {
    EditText edtRue, edtVille, edtCodePostal, edtMail, edtTel, edtMobile, edtSite, edtMission;
    Button btnValidModif;
    Apprenti app;

    private void initialize(View v) {

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
                Snackbar.make(v, "VALIDATION MODIFICATIONS", Snackbar.LENGTH_LONG);
                break;
            default:
                break;
        }
    }
}
