package com.mysy.star_0733.mysy1;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottom = findViewById(R.id.bottom);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        bottom.setSelectedItemId(R.id.home);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame,new Fragment_home())
                .addToBackStack("home1")
                .commit();

        bottom.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction()
                            .replace(R.id.frame,new Fragment_home())
                            .commit();
                        bottom.setItemBackgroundResource(R.color.home);
                        break;

                    case R.id.calculate:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frame,new Fragment_calculate())
                                .addToBackStack("calculate")
                                .commit();
                        bottom.setItemBackgroundResource(R.color.colorPrimary);
                        break;

                    case R.id.video:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frame,new Fragment_video())
                                .addToBackStack("video")
                                .commit();
                        bottom.setItemBackgroundResource(R.color.youtube);
                        break;

                    case R.id.list:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frame,new Fragment_list())
                                .addToBackStack("list")
                                .commit();
                        bottom.setItemBackgroundResource(R.color.home);
                        break;

                    case R.id.step:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frame,new Fragment_step())
                                .addToBackStack("step")
                                .commit();
                        bottom.setItemBackgroundResource(R.color.home);
                        break;
                }
               return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
        if(bottom.getSelectedItemId() == R.id.home){
            finish();
        }
        else
        {
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            if(fm.getBackStackEntryCount() > 1)
            {
                fm.popBackStack("home1",0);
                bottom.setSelectedItemId(R.id.home);
                ft.commit();
            }
            else{
                finish();
            }
        }
    }
}
