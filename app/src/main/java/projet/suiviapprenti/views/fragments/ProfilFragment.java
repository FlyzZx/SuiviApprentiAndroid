package projet.suiviapprenti.views.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import projet.suiviapprenti.R;

/**
 * Created by nicol on 29/05/2016.
 */
public class ProfilFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.infos_profil_fragment, container, false);

        return v;
    }
}
