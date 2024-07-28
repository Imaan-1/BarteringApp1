package com.example.barteringapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class ListProducts extends AppCompatActivity {

    private Spinner spinnerItemDesired;
    private Button imageButtonCancel1, buttonGoBack;
    Button buttonBarter;

    EditText textViewItemNeeded, textViewLocation, textViewItemToGive;
    FirebaseDatabase rtnode;
    DatabaseReference rref;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_products);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            buttonBarter = findViewById(R.id.buttonBarter);

            buttonBarter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    rtnode = FirebaseDatabase.getInstance();
                    rref = rtnode.getReference("products");


                    rref.setValue("database");
                    String ItemDesired = ((EditText)findViewById(R.id.textViewItemNeeded)).getText().toString();
                    String Location = ((EditText)findViewById(R.id.textViewLocation)).getText().toString();
                    String ItemToBarter= ((EditText)findViewById(R.id.textViewItemToGive)).getText().toString();


                    ProductsHelper product = new ProductsHelper(ItemDesired, Location, ItemToBarter);
                    rref.setValue(product);

                    ///Intent intent = new Intent(ListProducts.this, ListProducts.class);

                   // startActivity(intent);


                }
            });







            return insets;
        });
    }
}


    /*
    private void setupSpinner() {
        // Initialise the spinner with a preset list of items
        List<String> categories = new ArrayList<>();
        categories.add("All");
        categories.add("Crops and vegetables");
        categories.add("Farming Tools");
        categories.add("Vegetable");

        // Create an ArrayAdapter for the spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categories);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerItemDesired.setAdapter(adapter);

        // Set up the listener for spinner item selection
        spinnerItemDesired.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedCategory = (String) parent.getItemAtPosition(position);
                //filterRecyclerView(selectedCategory);
            });

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }

        }


    }
}*/


