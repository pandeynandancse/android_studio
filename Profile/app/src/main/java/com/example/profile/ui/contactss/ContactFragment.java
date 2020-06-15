package com.example.profile.ui.contactss;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.profile.R;
import com.example.profile.adapter.RecyclerViewAdapter;
import com.example.profile.data.MyDbHandler;
import com.example.profile.model.Contact;
import com.example.profile.params.Params;

import java.util.ArrayList;
import java.util.List;

public class ContactFragment extends Fragment {

    private ContactViewModel mViewModel;

    public static ContactFragment newInstance() {
        return new ContactFragment();
    }


    //ListView listView;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private  ArrayList<Contact> contactArrayList;
    private ArrayAdapter<String> arrayAdapter;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root =  inflater.inflate(R.layout.contact_fragment, container, false);



        //Recyclerview initialization
        recyclerView = root.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));








        //getContext().deleteDatabase(Params.DB_NAME);  // to delete database
        MyDbHandler db = new MyDbHandler(getContext());











//        ArrayList<String> contacts = new ArrayList<>();
//        //listView = root.findViewById(R.id.listView2);
//
//
//
//
//
//
//        // Creating a contact object for the db
//        Contact NANDAN = new Contact();
//        NANDAN.setPhoneNumber("9090909090");
//        NANDAN.setName("NANDAN");
//        // Adding a contact to the db
//        db.addContact(NANDAN);
//
//
//
//
//
//
//
//        // Creating a contact object for the db
//        Contact PANDEY = new Contact();
//        PANDEY.setPhoneNumber("9090459090");
//        PANDEY.setName("PANDEY");
//        // Adding a contact to the db
//        db.addContact(PANDEY);
//
//
//
//
//
//
//
//        // Creating a contact object for the db
//        Contact YEESHU = new Contact();
//        YEESHU.setPhoneNumber("9090675409");
//        YEESHU.setName("YEESHU");
//        // Adding a contact to the db
//        db.addContact(YEESHU);
//
//
//
//
//
//
//        Contact nandan = new Contact();
//        nandan.setPhoneNumber("9090909090");
//        nandan.setName("NANDAN");
//        // Adding a contact to the db
//        db.addContact(nandan);
//
//
//
//
//
//
//        // Creating a contact object for the db
//        Contact pandey = new Contact();
//        pandey.setPhoneNumber("9090459090");
//        pandey.setName("PANDEY");
//        // Adding a contact to the db
//        db.addContact(PANDEY);
//
//
//
//
//
//
//        // Creating a contact object for the db
//        Contact home= new Contact();
//        home.setPhoneNumber("9090675409");
//        home.setName("YEESHU");
//        // Adding a contact to the db
//        db.addContact(home);
//
//
//
//
//
//        Contact house = new Contact();
//        house.setPhoneNumber("9090909090");
//        house.setName("NANDAN");
//        // Adding a contact to the db
//        db.addContact(house);
//
//
//
//
//        // Creating a contact object for the db
//        Contact gaon = new Contact();
//        gaon.setPhoneNumber("9090459090");
//        gaon.setName("PANDEY");
//        // Adding a contact to the db
//        db.addContact(gaon);
//
//
//
//
//        // Creating a contact object for the db
//        Contact sahar = new Contact();
//        sahar.setPhoneNumber("9090675409");
//        sahar.setName("YEESHU");
//        // Adding a contact to the db
//        db.addContact(sahar);
//
//
//
//
//
//        // for updation in  database
////        YEESHU.setId(46);
////        YEESHU.setName("Changed YEESHU");
////        YEESHU.setPhoneNumber("0000000000");
////        int affectedRows = db.updateContact(YEESHU);
//
//
//
//
//
//
////        Log.d("dbNANDAN", "No of affected rows are: " + affectedRows);
////        db.deleteContactById(1);
////        db.deleteContactById(12);
////        db.deleteContactById(5);
//
//
//
//
//
//
//
//        // Get all contacts
//        List<Contact> allContacts = db.getAllContacts();






















//        for(Contact contact: allContacts){
//
//            Log.d("dbnandan", "\nId: " + contact.getId() + "\n" +
//                    "Name: " + contact.getName() + "\n"+
//                    "Phone Number: " + contact.getPhoneNumber() + "\n" );
//
//            contacts.add(contact.getName() + " (" + contact.getPhoneNumber() + ")");
//        }





       // ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, contacts);

        //listView.setAdapter(arrayAdapter);







































        Contact nandan = new Contact();
        nandan.setPhoneNumber("9090909090");
        nandan.setName("nandan");
        Contact nandan2 = new Contact();
        nandan2.setPhoneNumber("8090909090");
        nandan2.setName("pandey");

        // Adding a contact to the db
        db.addContact(nandan2);
        db.addContact(nandan);
        db.addContact(nandan);
        db.addContact(nandan);
        db.addContact(nandan);
        db.addContact(nandan);
        db.addContact(nandan);
        db.addContact(nandan);
        db.addContact(nandan);
        db.addContact(nandan);
        db.addContact(nandan);
        db.addContact(nandan);
        db.addContact(nandan);
        db.addContact(nandan);
        db.addContact(nandan);
        db.addContact(nandan);
        db.addContact(nandan);
        db.addContact(nandan);


        contactArrayList = new ArrayList<>();


        // Get all contacts
        List<Contact> contactList = db.getAllContacts();
        for(Contact contact: contactList){

            Log.d("dbnandan", "\nId: " + contact.getId() + "\n" +
                    "Name: " + contact.getName() + "\n"+
                    "Phone Number: " + contact.getPhoneNumber() + "\n" );

            contactArrayList.add(contact);
        }

//        Use your recyclerView
        recyclerViewAdapter = new RecyclerViewAdapter(getContext(), contactArrayList);
        recyclerView.setAdapter(recyclerViewAdapter);

        Log.d("dbnandan", "Bro you have "+ db.getCount()+ " contacts in your database");








        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ContactViewModel.class);
        // TODO: Use the ViewModel
    }

}
