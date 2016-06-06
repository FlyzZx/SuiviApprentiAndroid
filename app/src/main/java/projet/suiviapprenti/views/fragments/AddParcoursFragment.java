package projet.suiviapprenti.views.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import projet.suiviapprenti.R;

/**
 * Created by nicol on 06/06/2016.
 */
public class AddParcoursFragment extends Fragment {
    Spinner fonctions;
    ArrayAdapter spAdapt;
    String[] listFonctions = {"Développeur", "Ingénieur", "Webmaster"};

    private void initialize(View v) {
        fonctions = (Spinner) v.findViewById(R.id.spinner_parcours_fonction);
        spAdapt = new ArrayAdapter<String>(v.getContext(), android.R.layout.simple_spinner_dropdown_item, listFonctions);
        fonctions.setAdapter(spAdapt);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.modifier_parcours_fragment, container, false);
        initialize(v);

        return v;
    }
}
