package com.example.fragmentdemo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Fragment extends androidx.fragment.app.Fragment {
    ListView listView;
    String[] strings = {"Cupcake", "Donuts", "Eclairs", "Froyo", "GingerBread", "HoneyComb", "Ice Cream Sandwich", "Jelly Bean", "KitKat", "Lollipop", "Marshmallow", "Nougat", "Oreo"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment, container, false);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, strings);
        listView = view.findViewById(R.id.list_view);
        listView.setAdapter(arrayAdapter);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        listView.setOnItemClickListener((parent, view1, position, id) -> {
            String selectedItem = listView.getItemAtPosition(position).toString();
            Toast.makeText(getContext(), "" + selectedItem, Toast.LENGTH_SHORT).show();
        });
        super.onViewCreated(view, savedInstanceState);
    }
}
