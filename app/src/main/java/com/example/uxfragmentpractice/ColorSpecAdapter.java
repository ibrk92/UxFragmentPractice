package com.example.uxfragmentpractice;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.uxfragmentpractice.databinding.LayoutColoritemBinding;

import java.util.List;

public class ColorSpecAdapter extends BaseAdapter {
    // i need;
    // data
    List<ColorSpec> adapterColors;
    LayoutColoritemBinding binding;


    // constructor,customize over-ridden methods
    // no inner class in BaseAdapter.

// constructor
    public ColorSpecAdapter(List<ColorSpec> adapterColors) {
        this.adapterColors = adapterColors;
    }

    @Override
    public int getCount() {
        return adapterColors.size(); // size of your data - similar to getItemCount()
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // getView is a combination of onCreateViewHolder & onBindViewHolder.
        //from recycler view adapter

        if (convertView == null){
            binding = LayoutColoritemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        }

        binding.textViewColorItem.setText(adapterColors.get(position).getColorDesc());
        binding.textViewColorItem.setTextColor(adapterColors.get(position).getColorVal());
        binding.textViewColorItem.setGravity(Gravity.CENTER);
        return binding.getRoot();
    }
}
