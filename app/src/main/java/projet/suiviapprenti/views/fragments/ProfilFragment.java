package projet.suiviapprenti.views.fragments;

import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import projet.suiviapprenti.R;
import projet.suiviapprenti.beans.Apprenti;
import projet.suiviapprenti.utils.ProfilForm;
import projet.suiviapprenti.views.activitys.LoggedActivity;
import projet.suiviapprenti.views.activitys.LoginActivity;

/**
 * Created by nicol on 29/05/2016.
 */
public class ProfilFragment extends Fragment implements View.OnClickListener {
    ProfilForm profilForm;
    TextView nom, prenom, classe, naissance, adresse, mail, tel, site, mission, nomEntreprise, brancheEntreprise, nbSalariesEntreprise;
    Button btnModif;
    Apprenti app;

    private void initialize(View v) {
        profilForm = new ProfilForm();

        btnModif = (Button) v.findViewById(R.id.button_infosProfil_modifier);
        btnModif.setOnClickListener(this);

        nom = (TextView) v.findViewById(R.id.textView_infosProfil_nom);
        prenom = (TextView) v.findViewById(R.id.textView_infosProfil_prenom);
        classe = (TextView) v.findViewById(R.id.textView_infosProfil_classe);
        naissance = (TextView) v.findViewById(R.id.textView_infosProfil_dateNaissance);
        adresse = (TextView) v.findViewById(R.id.textView_infosProfil_adresse);
        mail = (TextView) v.findViewById(R.id.textView_infosProfil_mail);
        tel = (TextView) v.findViewById(R.id.textView_infosProfil_tel);
        site = (TextView) v.findViewById(R.id.textView_infosProfil_site);
        mission = (TextView) v.findViewById(R.id.textView_infosProfil_mission);
        nomEntreprise = (TextView) v.findViewById(R.id.textView_infosProfil_nomEntreprise);
        brancheEntreprise = (TextView) v.findViewById(R.id.textView_infosProfil_bancheEntreprise);
        nbSalariesEntreprise = (TextView) v.findViewById(R.id.textView_infosProfil_nbSalariesEntreprise);
    }

    private void updateTextviews() {
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

        nomEntreprise.setText(app.getEntreprise().getNomEntreprise());
        brancheEntreprise.setText(app.getEntreprise().getBranche());
        nbSalariesEntreprise.setText(String.valueOf(app.getEntreprise().getNbSalaries()));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.infos_profil_fragment, container, false);
        initialize(v);
        app = (Apprenti) getArguments().get("Apprenti");
        updateTextviews();

        return v;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id) {
            case R.id.button_infosProfil_modifier:
                Snackbar.make(v, "CALLBACK MODIFIER PROFIL", Snackbar.LENGTH_LONG).show();
                ModifProfilFragment modifFragment = new ModifProfilFragment();
                modifFragment.setArguments(getArguments());
                getFragmentManager().beginTransaction().replace(R.id.fragment_container_profil, modifFragment).commit();
                break;

            default:
                break;
        }
    }
}
