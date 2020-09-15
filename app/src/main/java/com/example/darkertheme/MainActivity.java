package com.example.darkertheme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Switch aSwitch;
    TextView textView;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            setTheme(R.style.darkTheme);

        }else setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
callFragment();
        setContentView(R.layout.activity_main);
        aSwitch=(Switch)findViewById(R.id.switch1);
textView = (TextView)findViewById(R.id.textViewer);
if (AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_YES){
    aSwitch.setChecked(true);
}
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
     if(isChecked){
    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
    textView.setText("enabled");
         Toast.makeText(getApplicationContext(),"dark mode enabled",Toast.LENGTH_SHORT).show();
    recreate();

}else {
    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
         Toast.makeText(getApplicationContext(),"dark mode not enabled",Toast.LENGTH_SHORT).show();
    textView.setText("disabled");
    recreate();

}
            }

        });
    }
    public void restart(){
        Intent a= new Intent(getApplicationContext(),MainActivity.class);
        startActivity(a);
        finish();
    }

    public void toSecond(View view) {
        Intent a= new Intent(getApplicationContext(),second.class);
        startActivity(a);
        finish();
    }
    public void callFragment(){
        getSupportFragmentManager().beginTransaction()
                .add(R.id.framer, new FragmentOne()).commit();
    }
}