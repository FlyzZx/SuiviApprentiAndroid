package projet.suiviapprenti.views.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import projet.suiviapprenti.R;
import projet.suiviapprenti.beans.Entreprise;

/**
 * Created by nicol on 10/06/2016.
 */
public class AutoEntrepriseAdapter extends ArrayAdapter<Entreprise> {
    private final Context context;
    private final ArrayList<Entreprise> datas;
    private final ArrayList<Entreprise> suggestions;

    public Filter expeFilter = new Filter() { //Filtre pour l'entrée clavier
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults returnResults = new FilterResults();
            if(constraint != null) {
                suggestions.clear();
                for(Entreprise a : datas) {
                    if(a.getNomEntreprise().toLowerCase().startsWith(constraint.toString().toLowerCase())) { //On vérifie le début du mot taper avec les données
                        suggestions.add(a);
                    }
                }
                returnResults.values = suggestions;
                returnResults.count = suggestions.size();
            } else {
                returnResults = new FilterResults();
            }
            return returnResults;
        }

        @Override
        @SuppressWarnings("unchecked")
        protected void publishResults(CharSequence constraint, FilterResults results) {
            ArrayList<Entreprise> filterList = (ArrayList<Entreprise>) results.values;
            if(results.count > 0) {
                clear();
                for(Entreprise a : filterList) {
                    add(a);
                    notifyDataSetChanged();
                }
            }
        }

        @Override
        public CharSequence convertResultToString(Object resultValue) {
            String str = ((Entreprise)resultValue).getNomEntreprise();
            return str;
        }
    };

    public AutoEntrepriseAdapter(Context context, ArrayList<Entreprise> values) {
        super(context, R.layout.auto_ent, values);
        this.context = context;
        this.datas = values;
        suggestions = new ArrayList<>();
    }

    @Override
    public Filter getFilter() {
        return expeFilter;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        if(rowView == null) {
            LayoutInflater inflaterLayout = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflaterLayout.inflate(R.layout.auto_ent, parent, false);
        }
        Entreprise ent = getItem(position);
        if(ent != null) {
            TextView name = (TextView) rowView.findViewById(R.id.textView_auto_nameEnt);
            if (name != null) {
                name.setText(ent.getNomEntreprise());
            }
        }

        return rowView;
    }




}

