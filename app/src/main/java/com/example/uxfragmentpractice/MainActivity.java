package com.example.uxfragmentpractice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.uxfragmentpractice.databinding.ActivityMainBinding;
import com.google.android.material.color.ColorRoles;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private ColorSpecViewModel colorSpecViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.fab.setBackgroundTintList(ColorStateList.valueOf(Color.LTGRAY));

        ConstraintLayout mainLayout = binding.mainLayout;
        mainLayout.setBackgroundColor(Color.parseColor("#FFFF00"));

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColorDrawable colorDrawable = (ColorDrawable) mainLayout.getBackground();
                int colorId = colorDrawable.getColor();

                if (colorId != Color.LTGRAY) {
                    mainLayout.setBackgroundColor(Color.LTGRAY); // eger ekran gri degilse ekrani gri yap
                    binding.fab.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FAFAFA"))); // butonu da beyaz yap

                }else{
                    mainLayout.setBackgroundColor(Color.parseColor("#FFFF00")); // eger ekran griyse sari yap
                    binding.fab.setBackgroundTintList(ColorStateList.valueOf(Color.LTGRAY)); // butonu da gri yap
                }

                Snackbar.make(v, "Like the new color?", Snackbar.LENGTH_LONG).setAction("Undo", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (colorId == Color.LTGRAY){
                            mainLayout.setBackgroundColor(Color.LTGRAY);
                            binding.fab.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FAFAFA")));
                        }else{
                            mainLayout.setBackgroundColor(Color.parseColor("#FFFF00"));
                            binding.fab.setBackgroundTintList(ColorStateList.valueOf(Color.LTGRAY));
                        }

                    }
                }).show();

            }
        });

        List<ColorSpec> ColorSpecs = new ArrayList<>();
        List<String> ColorDescs = new ArrayList<>(Arrays.asList("BLACK", "ORANGE", "PURPLE"));
        List<Integer> ColorVals = new ArrayList<>(Arrays.asList(R.color.black,
                Color.rgb(255,165,0),
                Color.parseColor("#800080")));
        for (int i = 0; i < ColorDescs.size(); i++){
            ColorSpec eachColor = new ColorSpec(ColorDescs.get(i), ColorVals.get(i));
            ColorSpecs.add(eachColor);
        }

        colorSpecViewModel = new ViewModelProvider(this).get(ColorSpecViewModel.class);
        colorSpecViewModel.loadColors(ColorSpecs);










    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //*** Burasi menunun ortaya cikmasini sagliyor !!***
        // menu'yu inflate edelim. Simdi action bara menu itemlarini ekleyelim.
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //*** Menu'deki aytimlara tiklaninca ne olacagini buradaki kisimda yaziyoruz ***

        int id = item.getItemId();

        if (id == R.id.action_settings ) {
            Toast.makeText(this, "Clicked on Settings", Toast.LENGTH_SHORT).show();
            return true;
        }else if (id == R.id.action_search){
            Toast.makeText(this, "Clicked on Search", Toast.LENGTH_SHORT).show();
            return true;

        }else if (id == R.id.action_userprofile){
            Toast.makeText(this, "Clicked on User Profile", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }




}