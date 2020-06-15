package com.example.profile.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.profile.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    TextView textView;
    ListView listView;
    SeekBar seekbar;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        //final TextView textView = root.findViewById(R.id.text_home);
        //homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
        //    @Override
        //    public void onChanged(@Nullable String s) {
        //        textView.setText(s);
        //    }
        //});


        //ArrayList is passed into arrayadapter and then that arrayadapter is passed into ListView.

        ListView myListView = (ListView)root.findViewById(R.id.myListView);
        System.out.println(myListView);
        ArrayList<String> grocery = new ArrayList<>();
        grocery.add("Bhindi");
        //grocery.add("Pen");
        //grocery.add("apples");
        //grocery.add("tea leaves");
        System.out.println(grocery);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(),android.R.layout.simple_list_item_1,grocery);
        myListView.setAdapter(arrayAdapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String text = "Item" + position + " " + ((TextView) view).getText().toString(); // item_position item_name
                Toast.makeText( getContext(), text, Toast.LENGTH_SHORT).show();

            }
        });







        textView = root.findViewById(R.id.myTextViewmul);
        listView = root.findViewById(R.id.myListViewmul);
        seekbar = root.findViewById(R.id.mySeekBarmul);

        seekbar.setMax(20);

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Toast.makeText(getContext(), "Populating table of " + progress, Toast.LENGTH_SHORT).show();
                populate(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });




        return root;
    }

    public void populate(int table){

        ArrayList<String> mulTable  = new ArrayList<>();
        for (int i =1; i<=10;i++){
            mulTable.add(table + " X " + i + " = " + table*i);
        }
        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, mulTable);
        listView.setAdapter(arrayAdapter2);
        textView.setText("Multiplication Table of " + table);


    }
}
