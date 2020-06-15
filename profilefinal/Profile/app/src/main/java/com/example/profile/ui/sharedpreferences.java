package com.example.profile.ui;

import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.profile.R;

import static android.content.Context.MODE_PRIVATE;

public class sharedpreferences extends Fragment {

    private SharedpreferencesViewModel mViewModel;

    public static sharedpreferences newInstance() {
        return new sharedpreferences();
    }


    Button button2;
    TextView textView6 ;
    EditText editText ;
    Context context = getActivity();


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.sharedpreferences_fragment, container, false);

        editText = root.findViewById(R.id.editText10);
        button2 = root.findViewById(R.id.button10);

        textView6 = root.findViewById(R.id.textView10);







        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String msg = editText.getText().toString();

                // mode private means only this application can use this shared prefereces
                // name is name of shared preferences/file and this shared preferences can be accessed by only this application
                SharedPreferences shrd = getActivity().getApplicationContext().getSharedPreferences("demo", context.MODE_PRIVATE);
                System.out.println("clickeeeeaeeeeaaaaaaaaaaaaaaaafaefe");
                SharedPreferences.Editor editor = shrd.edit();
                editor.putString("str", msg); // stored data in android device as key value pair
                editor.apply();   // apply changes as we do commit in database to apply changes


                textView6.setText(msg);


            }

        });






        //// https://stackoverflow.com/questions/30953358/nullpointerexception-error-on-context-when-calling-sharedpref-from-fragment
           // get value of shared preferences back
        SharedPreferences getShared = getActivity().getApplicationContext().getSharedPreferences("demo", MODE_PRIVATE);
        String value = getShared.getString("str","Save a note and it wil display here");
        textView6.setText(value);





        //clear shared preferences.............................
        // search it on google.......

        return root;
    }





    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(SharedpreferencesViewModel.class);
        // TODO: Use the ViewModel
    }

}
