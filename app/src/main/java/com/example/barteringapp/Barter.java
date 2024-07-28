package com.example.barteringapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Barter extends Fragment {

    private Button buttonViewItems, buttonListItems;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_barter, container, false);


        buttonViewItems = view.findViewById(R.id.buttonViewItems);
        buttonListItems = view.findViewById(R.id.buttonListItems);

        buttonViewItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Using the getActivity() to get context since this is a fragment
                Intent intent = new Intent(getActivity(), AvailableProducts.class);
                startActivity(intent);
            }
        });

       buttonListItems.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               // Using the getActivity() to get context since this is a fragment
               Intent intent = new Intent(getActivity(), ListProducts.class);
               startActivity(intent);
           }
       });



        return view;
    }
}
