package projet.suiviapprenti.views.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
        registerForContextMenu(listCursus);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.cursusformation_fragment, container, false);
        initialize(v);
        return v;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getActivity().getMenuInflater();
        AdapterView.AdapterContextMenuInfo infos = (AdapterView.AdapterContextMenuInfo) menuInfo;
        Cursusformation selectedItem = cursus.get(infos.position);
        menu.setHeaderTitle(selectedItem.getType());
        inflater.inflate(R.menu.contextmenu_list, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo infos = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        Cursusformation selectedCursus = cursus.get(infos.position);
        switch(item.getItemId()) {
            case R.id.contextmenu_modifier:
                Snackbar.make(getView(), "Modifier " + selectedCursus.getType(), Snackbar.LENGTH_LONG).show();
                return true;
            case R.id.contextmenu_supprimer:
                Snackbar.make(getView(), "Supprimer " + selectedCursus.getType(), Snackbar.LENGTH_LONG).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}
