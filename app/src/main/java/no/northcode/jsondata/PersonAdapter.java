package no.northcode.jsondata;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PersonAdapter extends ArrayAdapter<Person> {



    public PersonAdapter(Context context, int resource, List<Person> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View covertView, ViewGroup parent) {
        if (covertView == null) {
            covertView = View.inflate(this.getContext(), R.layout.fragment_person, null);
        }

        TextView txt_id = (TextView)covertView.findViewById(R.id.id);
        TextView txt_data = (TextView)covertView.findViewById(R.id.content);

        Person p = this.getItem(position);
        txt_id.setText(p.getUserName());
        txt_data.setText(p.getPhone());

        covertView.setTag(p);

        return covertView;
    }
}
