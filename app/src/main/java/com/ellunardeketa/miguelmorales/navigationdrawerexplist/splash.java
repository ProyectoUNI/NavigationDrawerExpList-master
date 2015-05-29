package com.ellunardeketa.miguelmorales.navigationdrawerexplist;

import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;


public class splash extends ActionBarActivity
{
    public static final int segundos = 8;
    public static final int milisegundos = 1000;
    private ProgressBar phprogreso;
    public static final int delay = 2;
    public void onCreate (Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

        phprogreso = (ProgressBar) findViewById(R.id.progressBar);

        phprogreso.setMax(maximo_progreso());
        empezarSplash();
    }

    public void empezarSplash(){
        new CountDownTimer(milisegundos,10000){

            public void onTick(long millsUtilFinished){
                phprogreso.setProgress(barraProgreso(millsUtilFinished));
            }
            public void onFinish(){

                Intent nuevo = new Intent(splash.this, MainActivity.class);
                startActivity(nuevo);
                finish();
            }
        }.start();


    }

    public  int barraProgreso(long miliseconds){

        return (int)((milisegundos-miliseconds)/1000);

    }
    public int maximo_progreso(){
        return segundos-delay;
    }
}
