package spice.lihachev.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Telephony;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private long backPressedTime;
    private Toast backToast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonStart =(Button)findViewById(R.id.buttonStart);
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Кнопка перехода к выбору уровня
                try {
                      Intent intent =new Intent(  MainActivity.this, GameLevels.class);
                      startActivity(intent);finish();

                }catch (Exception e){

                }
            }
        });
        //Растягивает приложение на весь экран
        Window w=getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
    //Системная кнопка назад
    //Ctrl+o

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if(backPressedTime+2000 > System.currentTimeMillis()){
            backToast.cancel();
            super.onBackPressed();
            return;


        }else {
            backToast=Toast.makeText(getBaseContext(),"Нажмите еще раз, чтобы выйти", Toast.LENGTH_SHORT);
            backToast.show();

        }
        backPressedTime=System.currentTimeMillis();
    }
}