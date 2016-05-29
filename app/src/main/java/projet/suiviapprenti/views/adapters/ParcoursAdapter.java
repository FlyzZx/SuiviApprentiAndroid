package projet.suiviapprenti.views.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;
import java.util.Set;

import projet.suiviapprenti.R;
import projet.suiviapprenti.beans.ParcoursPostBts;

/**
 * Created by nicol on 29/05/2016.
 */
public class ParcoursAdapter extends BaseAdapter {
    private List<ParcoursPostBts> lParcours;
    private Context context;
    private LayoutInflater inflater;

    public ParcoursAdapter(Context context, List<ParcoursPostBts> parcours) {
        this.context = context;
        this.lParcours = parcours;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return lParcours.size();
    }

    @Override
    public Object getItem(int position) {
        return lParcours.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout layoutItem;

        if(convertView == null) {
            layoutItem = (LinearLayout) inflater.inflate(R.layout.row_parcours, parent, false);
        } else {
            layoutItem = (LinearLayout) convertView;
        }

        TextView nomEntreprise = (TextView) layoutItem.findViewById(R.id.textView_row_parcours_nomEntreprise);
        TextView fonction = (TextView) layoutItem.findViewById(R.id.textView_row_parcours_fonction);
        TextView annee = (TextView) layoutItem.findViewById(R.id.textView_row_parcours_annee);

        nomEntreprise.setText(lParcours.get(position).getEntreprise().getNomEntreprise());
        fonction.setText(lParcours.get(position).getFonction());
        annee.setText(String.valueOf(lParcours.get(position).getDateDebut().toString()));

        return layoutItem;
    }
}
