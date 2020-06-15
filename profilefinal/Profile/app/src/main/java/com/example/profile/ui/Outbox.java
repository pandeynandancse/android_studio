package com.example.profile.ui;

import androidx.lifecycle.ViewModelProviders;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.profile.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Outbox extends Fragment {

    private OutboxViewModel mViewModel;

    public static Outbox newInstance() {
        return new Outbox();
    }

    int number =0;



    public class BG extends AsyncTask<String,Void,String>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.d("NandanBG", "onPreExecute: ran");
        }

        @Override
        protected String doInBackground(String... urls) {
            Log.d("HarryBG", "doInBackground: ran");
            String result = "";
            URL url;
            HttpURLConnection conn;
            try {
                url = new URL(urls[0]);
                conn = (HttpURLConnection) url.openConnection();
                InputStream in = conn.getInputStream();
                InputStreamReader reader = new InputStreamReader(in);
                int data = reader.read();
                while (data != -1) {
                    char current = (char) data;
                    result += current;
                    data = reader.read();
                }
            }
            catch(Exception e){
                e.printStackTrace();
                return "Something went wrong";
            }
            return result;


        }


        // returned result from doInBackground is passed as argument s  in onPostExecute
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.d("HarryBG", "onPostExecute: ran");
            Log.d("HarryBG", s);

        }
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.outbox_fragment, container, false);
        BG myTask = new BG();
       // myTask.execute("https://www.codewithharry.com/");
//--------------------------------------------------------------------------------------------
 //       final Handler handler = new Handler();
//        Runnable run = new Runnable() {
//            @Override
//            public void run() {
//                number ++;
//                //  code to execute
//                Toast.makeText( getContext(), "helloo"  + number, Toast.LENGTH_SHORT).show();
//                handler.postDelayed(this,2000);
//            }
          // this whole code block continue running after each 2 seconds
//        };
//        handler.post(run);

//--------------------------------------------------------------------------------




        // runnable example countdowntimer
//        new CountDownTimer(35000,1000)
//        {
//            @Override
//            public void onTick(long millisUntilFinished) {
//                Log.d("nandan", 'count down timer is printing'); //runs this line after each 1 seconds in logcat because log is used and in dedbug dropdown of logcat beause d is used
//            }
//
//            @Override
//            public void onFinish() {
//                Log.d("nandan", 'finished'); // runs after 35 seconds , only one time
//            }
//
//
//
//        };

//---------------------------------------------------------------------------------


        Button leLo = (Button) root.findViewById(R.id.button);
        leLo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText( getContext(), "this will run when you click on button although in background url is being fetched", Toast.LENGTH_SHORT).show();
//                System.out.println("clicked");
            }
        });


        RequestQueue requestQueue;
        System.out.println("request queue reached");
        requestQueue = Volley.newRequestQueue(getContext());
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, "https://jsonplaceholder.typicode.com/todos/1", null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                try {
                    Log.d("my volley", "response is" + response.getString("title"));
                    System.out.println("worked  ");
                } catch (JSONException e) {
                    Log.d("Did not work","wrong");
                    System.out.println("exception occured ");
                    e.printStackTrace();
                }
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("my volley", "went wrong");
            }
        }

        );

        requestQueue.add(jsonObjectRequest);

        return root;

//        inflater.inflate(R.layout.outbox_fragment, container, false);
    }




    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(OutboxViewModel.class);
        // TODO: Use the ViewModel
    }



}
