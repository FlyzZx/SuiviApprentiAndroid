package projet.suiviapprenti.views.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import projet.suiviapprenti.R;
import projet.suiviapprenti.beans.Cursusformation;
import projet.suiviapprenti.beans.ParcoursPostBts;

/**
 * Created by nicol on 30/05/2016.
 */
public class CursusAdapter extends BaseAdapter {
    private List<Cursusformation> cursus;
    private Context context;
    private LayoutInflater inflater;

    public CursusAdapter(Context context, List<Cursusformation> cursus) {
        this.context = context;
        this.cursus = cursus;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return cursus.size();
    }

    @Override
    public Object getItem(int position) {
        return cursus.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout layoutItem;

        if(convertView == null) {
            layoutItem = (LinearLayout) inflater.inflate(R.layout.row_cursus, parent, false);
        } else {
            layoutItem = (LinearLayout) convertView;
        }

        TextView type = (TextView) layoutItem.findViewById(R.id.textView_cursus_type);
        TextView complement = (TextView) layoutItem.findViewById(R.id.textView_cursus_complement);
        TextView annee = (TextView) layoutItem.findViewById(R.id.textView_cursus_annee);
        TextView obtention = (TextView) layoutItem.findViewById(R.id.textView_cursus_obtention);

        type.setText(cursus.get(position).getType());
        complement.setText(cursus.get(position).getTitreComplement());
        annee.setText(String.valueOf(cursus.get(position).getAnnee()));
        obtention.setText("Obtention : " + cursus.get(position).getTitreObtenu());

        return layoutItem;
    }
}
