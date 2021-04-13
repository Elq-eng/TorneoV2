package com.example.torneov1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ElA6Activity extends AppCompatActivity {
    Fragment fraA, fraB;
    FragmentTransaction transt;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.nav_equi_1:
                            //Bundle bundle = new Bundle();
                            //bundle.putString("usuarionE", datoidx);

                            Toast.makeText(ElA6Activity.this, "Person", Toast.LENGTH_SHORT).show();
                            fraA=new ElA6CAFragment();

                            //fraA.setArguments(bundle);
                            transt= getSupportFragmentManager().beginTransaction();
                            transt.replace(R.id.nav_frame,fraA);
                            transt.commit();

                            return true;
                        case R.id.nav_equi_2:

                            //Bundle bundleB = new Bundle();
                            //bundleB.putString("usuarionE", datoidx);

                            Toast.makeText(ElA6Activity.this, "Refer", Toast.LENGTH_SHORT).show();
                            fraB=new ELA6CBFragment();
                            //fraB.setArguments(bundleB);
                            FragmentTransaction transtB= getSupportFragmentManager().beginTransaction();
                            transtB.replace(R.id.nav_frame,fraB);
                            transtB.commit();
                            return true;

                    }
                    return false;
                }
            };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_el_a6);
        BottomNavigationView nav=(BottomNavigationView) findViewById(R.id.nav_equi);
        nav.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        ElA6CAFragment fraA=new ElA6CAFragment();
        //fraA.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.nav_frame,fraA).commit();
    }
}