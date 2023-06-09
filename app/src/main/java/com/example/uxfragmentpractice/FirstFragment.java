package com.example.uxfragmentpractice;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import android.renderscript.ScriptGroup;
import android.service.controls.actions.ControlAction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.uxfragmentpractice.databinding.FragmentFirstBinding;

import java.nio.BufferUnderflowException;
import java.util.ArrayList;
import java.util.List;


public class FirstFragment extends Fragment {

private FragmentFirstBinding binding;
private ColorSpecViewModel colorSpecViewModel;
List<ColorSpec> FragColors = new ArrayList<>(); // empty to prevent null error

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

        // Hatirlarsan bu kisimda eger bir canli veri tutacaksak yani View modelimizi yazdigimiz yer !!
        // Oncelikle colorSpecViewModeli'ni bir al;

        colorSpecViewModel = new ViewModelProvider(requireActivity()).get(ColorSpecViewModel.class);
        colorSpecViewModel.getColors().observe(getViewLifecycleOwner(), new Observer<List<ColorSpec>>() {
            @Override
            public void onChanged(List<ColorSpec> colorSpecs) {

                FragColors = colorSpecs;
                ColorSpecAdapter colorSpecAdapter = new ColorSpecAdapter(FragColors);
                binding.spinnerColors.setAdapter(colorSpecAdapter);

            }
        });

        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                goToSecond(view);

            }
        });

    }

    public void goToSecond(View view){

        Bundle bundle = new Bundle();
        bundle.putInt("COLORVAL", FragColors.get(binding.spinnerColors.getSelectedItemPosition()).getColorVal());
        NavHostFragment.findNavController(FirstFragment.this).navigate(R.id.action_firstFragment_to_secondFragment, bundle);

    }
}