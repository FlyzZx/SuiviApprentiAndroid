package projet.suiviapprenti.views.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import projet.suiviapprenti.R;

/**
 * Created by nicol on 06/06/2016.
 */
public class AddParcoursFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.modifier_parcours_fragment, container, false);

        return v;
    }
}
