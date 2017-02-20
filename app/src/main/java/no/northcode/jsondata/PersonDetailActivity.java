package no.northcode.jsondata;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by andreas on 20/02/17.
 */

public class PersonDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_person);

        PersonParccel pack = (PersonParccel) getIntent().getParcelableExtra("person");
        Person p = pack.p;

        TextView txt_uname = (TextView) this.findViewById(R.id.txt_uname);
        TextView txt_fname = (TextView) this.findViewById(R.id.txt_fname);
        TextView txt_lname = (TextView) this.findViewById(R.id.txt_lname);

        txt_uname.setText(p.getUserName());
        txt_fname.setText(p.getFirstname());
        txt_lname.setText(p.getLastname());
    }

}
