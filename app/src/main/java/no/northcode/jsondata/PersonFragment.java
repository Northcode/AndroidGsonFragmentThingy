package no.northcode.jsondata;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.LayoutInflaterCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by andreas on 20/02/17.
 */

public class PersonFragment extends Fragment {

    Person toDisplay;

    public PersonFragment() {
        super();
    }

    @Override
    public void onCreate(Bundle savedInst) {
        super.onCreate(savedInst);

        Bundle bundle = getArguments();

        PersonParccel pack = bundle.getParcelable("person");
        toDisplay = pack.p;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInst) {
        View view = inflater.inflate(R.layout.details_person, container, false);

        TextView txt_uname = (TextView) view.findViewById(R.id.txt_uname);
        TextView txt_fname = (TextView) view.findViewById(R.id.txt_fname);
        TextView txt_lname = (TextView) view.findViewById(R.id.txt_lname);

        if (toDisplay != null) {
            txt_uname.setText(toDisplay.getUserName());
            txt_fname.setText(toDisplay.getFirstname());
            txt_lname.setText(toDisplay.getLastname());
        }

        return view;
    }

}
