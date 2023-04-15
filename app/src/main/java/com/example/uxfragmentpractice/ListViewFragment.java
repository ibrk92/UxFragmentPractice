package com.example.uxfragmentpractice;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.example.uxfragmentpractice.databinding.FragmentListViewBinding;

import java.util.ArrayList;
import java.util.List;


public class ListViewFragment extends Fragment {

    FragmentListViewBinding binding;
    ColorSpecViewModel colorSpecViewModel;
    List<ColorSpec> FragColors = new ArrayList<>();

    public ListViewFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentListViewBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        colorSpecViewModel = new ViewModelProvider(requireActivity()).get(ColorSpecViewModel.class);
        colorSpecViewModel.getColors().observe(getViewLifecycleOwner(), new Observer<List<ColorSpec>>() {
            @Override
            public void onChanged(List<ColorSpec> colorSpecs) {
                FragColors = colorSpecs;
                ColorSpecAdapter colorSpecAdapter = new ColorSpecAdapter(FragColors);
                binding.listViewColors.setAdapter(colorSpecAdapter);
            }
        });

        binding.listViewColors.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Bundle bundle = new Bundle();
                bundle.putInt("COLORVAL", FragColors.get(position).getColorVal());
                NavHostFragment.findNavController(ListViewFragment.this).navigate(R.id.action_listViewFragment_to_secondFragment, bundle);

            }
        });


    }
}