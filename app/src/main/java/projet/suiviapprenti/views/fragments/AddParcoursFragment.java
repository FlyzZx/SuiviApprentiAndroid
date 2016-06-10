package projet.suiviapprenti.views.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import java.util.ArrayList;
import java.util.List;

import projet.suiviapprenti.R;
import projet.suiviapprenti.beans.Entreprise;
import projet.suiviapprenti.networks.SimpleHTTPGet;
import projet.suiviapprenti.utils.EntrepriseForm;
import projet.suiviapprenti.views.adapters.AutoEntrepriseAdapter;

/**
 * Created by nicol on 06/06/2016.
 */
public class AddParcoursFragment extends Fragment implements TextWatcher {
    Spinner fonctions;
    AutoCompleteTextView autoNomEnt;
    AutoEntrepriseAdapter adapterEnt;
    ArrayList<Entreprise> list_Ent;
    ArrayAdapter spAdapt;
    String[] listFonctions = {"Développeur", "Ingénieur", "Webmaster"};

    private void initialize(View v) {
        fonctions = (Spinner) v.findViewById(R.id.spinner_parcours_fonction);
        spAdapt = new ArrayAdapter<String>(v.getContext(), android.R.layout.simple_spinner_dropdown_item, listFonctions);
        fonctions.setAdapter(spAdapt);
        list_Ent = new ArrayList<>();
        autoNomEnt = (AutoCompleteTextView) v.findViewById(R.id.autoCompleteTextView_parcours_nomEnt);
        adapterEnt = new AutoEntrepriseAdapter(v.getContext(), list_Ent);

        autoNomEnt.addTextChangedListener(this);
        autoNomEnt.setThreshold(1);
        autoNomEnt.setAdapter(adapterEnt);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.modifier_parcours_fragment, container, false);
        initialize(v);

        return v;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        EntrepriseForm entForm = new EntrepriseForm();
        adapterEnt.clear();
        adapterEnt.addAll(entForm.getEntrepriseBeginWith(s.toString()));
        int a = 2;
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
