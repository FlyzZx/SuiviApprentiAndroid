package projet.suiviapprenti.views.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import projet.suiviapprenti.R;
import projet.suiviapprenti.beans.Apprenti;
import projet.suiviapprenti.beans.Cursusformation;
import projet.suiviapprenti.beans.ParcoursPostBts;
import projet.suiviapprenti.views.adapters.CursusAdapter;
import projet.suiviapprenti.views.adapters.ParcoursAdapter;

/**
 * Created by nicol on 30/05/2016.
 */
public class CursusFragment extends Fragment {
    ListView listCursus;
    CursusAdapter adapter;
    Apprenti app;
    List<Cursusformation> cursus;

    private void initialize(View v) {
        app = (Apprenti) getArguments().get("Apprenti");
        listCursus = (ListView) v.findViewById(R.id.listView_cursus);
        cursus = new ArrayList<>();
        cursus.addAll(app.getCursusformations());
        adapter = new CursusAdapter(v.getContext(), cursus);
        listCursus.setAdapter(adapter);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.cursusformation_fragment, container, false);
        initialize(v);
        return v;
    }
}
