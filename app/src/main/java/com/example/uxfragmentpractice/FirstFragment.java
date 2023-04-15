package com.example.uxfragmentpractice;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.renderscript.ScriptGroup;
import android.service.controls.actions.ControlAction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.uxfragmentpractice.databinding.FragmentFirstBinding;


public class FirstFragment extends Fragment {

private FragmentFirstBinding binding;




    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                goToSecond(view);

            }
        });
    }

    public void goToSecond(View view){

        NavHostFragment.findNavController(FirstFragment.this).navigate(R.id.action_firstFragment_to_secondFragment);


    }


}