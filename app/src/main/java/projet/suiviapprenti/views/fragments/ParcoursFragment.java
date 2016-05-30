package projet.suiviapprenti.views.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
        //Activation du menu contextuel
        registerForContextMenu(listParcours);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.parcourspostbts_fragment, container, false);
        initialize(v);
        return v;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getActivity().getMenuInflater();
        AdapterView.AdapterContextMenuInfo infos = (AdapterView.AdapterContextMenuInfo) menuInfo;
        ParcoursPostBts selectedItem = parcours.get(infos.position);
        menu.setHeaderTitle(selectedItem.getFonction() + " à " + selectedItem.getEntreprise().getNomEntreprise());
        inflater.inflate(R.menu.contextmenu_list, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo infos = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        ParcoursPostBts selectedParcours = parcours.get(infos.position);
        switch(item.getItemId()) {
            case R.id.contextmenu_modifier:
                Snackbar.make(getView(), "Modifier " + selectedParcours.getFonction(), Snackbar.LENGTH_LONG).show();
                return true;
            case R.id.contextmenu_supprimer:
                Snackbar.make(getView(), "Supprimer " + selectedParcours.getFonction(), Snackbar.LENGTH_LONG).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}
