package com.example.uxfragmentpractice;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.uxfragmentpractice.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;




    public SecondFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getArguments() != null) {
            int colorVal = getArguments().getInt("COLORVAL", Color.BLACK);
            binding.textViewSecond.setTextColor(colorVal);
            //binding.textViewSecond.setText(R.string.txt_secondFragment); // not needed, bacause we already did in xml.
        }

        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                goToFirst(view);

            }
        });

        binding.buttontoListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToList(view);
            }
        });
    }

    public void goToFirst(View view){

        NavHostFragment.findNavController(SecondFragment.this).navigate(R.id.action_secondFragment_to_firstFragment);



    }

    public void goToList(View view){

        NavHostFragment.findNavController(SecondFragment.this).navigate(R.id.action_secondFragment_to_listViewFragment);


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}