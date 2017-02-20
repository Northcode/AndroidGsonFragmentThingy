package no.northcode.jsondata;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

import java.util.ArrayList;

public class PersonFragment extends ListFragment {

    ArrayList<Person> person_array;
    PersonAdapter adapter;

    public PersonFragment() {
        super();
        person_array = new ArrayList<>();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        adapter = new PersonAdapter(getContext(), R.layout.fragment_person, person_array);
        setListAdapter(adapter);
        return inflater.inflate(R.layout.fragment_person_list, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        getUserData();
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Intent openintent = new Intent(this.getActivity(), PersonDetailActivity.class);
        Person person = (Person)v.getTag();
        PersonParccel pack = new PersonParccel(person);
        openintent.putExtra("person", pack);
        startActivity(openintent);
    }

    public void getUserData() {

        final String karkurl = "http://kark.hin.no:8088/d3330log_backend/getTestUsers";

        System.out.println(" !!!!!!!!!!!!!!!!!!!!!!!!!!!!11 -------------------------- CALLLLLLLLLLLLLLL !!!!!!!!!!!!!!!!!!!!!1");

        RequestQueue rqueue = Volley.newRequestQueue(getContext());
        JsonArrayRequest request = new JsonArrayRequest(karkurl,
                new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {
                        Gson gson = new Gson();
                        person_array = gson.fromJson(response.toString(), new TypeToken<ArrayList<Person>>() {}.getType());
                        person_array.addAll(person_array);
                        person_array.addAll(person_array);
                        person_array.addAll(person_array);
                        adapter = new PersonAdapter(getContext(), R.layout.fragment_person, person_array);
                        setListAdapter(adapter);
                        System.out.println("Got response, should be visible");
                    }
                },
                new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println("there was an error downloading: " + error.toString());
                    }
                }
        );

        rqueue.add(request);
        rqueue.start();

    }

}
