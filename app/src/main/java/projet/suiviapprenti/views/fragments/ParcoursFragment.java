package projet.suiviapprenti.views.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.List;

import projet.suiviapprenti.R;
import projet.suiviapprenti.beans.Apprenti;
import projet.suiviapprenti.beans.ParcoursPostBts;
import projet.suiviapprenti.views.adapters.ParcoursAdapter;

/**
 * Created by nicol on 29/05/2016.
 */
public class ParcoursFragment extends Fragment {

    ListView listParcours;
    ParcoursAdapter adapter;
    Apprenti app;
    List<ParcoursPostBts> parcours;

    private void initialize(View v) {
        app = (Apprenti) getArguments().get("Apprenti");
        parcours = new ArrayList<>();
        parcours.addAll(app.getParcoursPostBtses());
        listParcours = (ListView) v.findViewById(R.id.listView_parcours);
        adapter = new ParcoursAdapter(v.getContext(), parcours);
        listParcours.setAdapter(adapter);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.parcourspostbts_fragment, container, false);
        initialize(v);
        return v;
    }
}
