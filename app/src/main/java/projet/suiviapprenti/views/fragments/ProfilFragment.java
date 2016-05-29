package projet.suiviapprenti.views.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import projet.suiviapprenti.R;
import projet.suiviapprenti.beans.Apprenti;
import projet.suiviapprenti.utils.ProfilForm;
import projet.suiviapprenti.views.activitys.LoggedActivity;
import projet.suiviapprenti.views.activitys.LoginActivity;

/**
 * Created by nicol on 29/05/2016.
 */
public class ProfilFragment extends Fragment {
    ProfilForm profilForm;
    TextView nom, prenom, classe, naissance, adresse, mail, tel, site, mission;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.infos_profil_fragment, container, false);
        profilForm = new ProfilForm();
        nom = (TextView) v.findViewById(R.id.textView_infosProfil_nom);
        prenom = (TextView) v.findViewById(R.id.textView_infosProfil_prenom);
        classe = (TextView) v.findViewById(R.id.textView_infosProfil_classe);
        naissance = (TextView) v.findViewById(R.id.textView_infosProfil_dateNaissance);
        adresse = (TextView) v.findViewById(R.id.textView_infosProfil_adresse);
        mail = (TextView) v.findViewById(R.id.textView_infosProfil_mail);
        tel = (TextView) v.findViewById(R.id.textView_infosProfil_tel);
        site = (TextView) v.findViewById(R.id.textView_infosProfil_site);
        mission = (TextView) v.findViewById(R.id.textView_infosProfil_mission);
        try {
            Apprenti app = profilForm.getInfosPersonnelles();
            //MAJ TEXTVIEWS
            nom.setText(app.getNom());
            prenom.setText(app.getPrenom());
            classe.setText(app.getClasse().getNom() + " - " + app.getClasse().getAnnee());
            naissance.setText(app.getDateNaissance().toString());
            adresse.setText(app.getCoordonnees().getRue() + " " + app.getCoordonnees().getCodePostal() + " " + app.getCoordonnees().getVille());
            mail.setText(app.getCoordonnees().getEmail());
            tel.setText(app.getCoordonnees().getTelephone() + " / " + app.getCoordonnees().getMobile());
            site.setText(app.getCoordonnees().getSite());
            mission.setText(app.getMissionPrincipale());
        } catch (Exception e) {
            Intent intent = new Intent(v.getContext(), LoginActivity.class);
            startActivity(intent);
        }

        return v;
    }
}
