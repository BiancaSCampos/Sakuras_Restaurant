package com.uniso.lpdm.sakurarestaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class VerHorasActivity extends AppCompatActivity {

    private int segundos = 0;
    private boolean executando;
    private boolean estava_executando;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_horas);
        Intent intecaoRecebida = getIntent();
        executando=true;
        estava_executando=true;

        /* Aqui crio um if para verificar se o savedInstancaState não é nulo, pois se se não for,
        que dizer que a aplicação já estava rodando antes e salvamos o estado dela.
         */
        if (savedInstanceState != null){
            segundos = savedInstanceState.getInt("segundos");
            executando = savedInstanceState.getBoolean("executando");
            estava_executando= savedInstanceState.getBoolean("estava_executando");
        }

        executarTemporizador();
    }

    //Para salvarmos o estado do cronometro, criamos essa função, ela será chamda antes da aplicação ser destruida
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putInt("segundos", segundos);
        savedInstanceState.putBoolean("executando", executando);
        savedInstanceState.putBoolean("estavaExecutadando", estava_executando);
        super.onSaveInstanceState(savedInstanceState);
    }

    //Metodos executados sempre quando a aplicação perde o foco

    @Override
    public void onPause(){
        super.onPause();
        estava_executando = executando;
        executando = false;
    }

    @Override
    public void onResume(){
        super.onResume();
        executando = estava_executando;
    }

    //Evento onClick onde inicia a contagem
    public void onClickIniciar(View view){
        executando = true;
    }

    //Evento onClick onde para a contagem
    public void onClickParar (View view){
        executando = false;
    }

    //Evento onClick onde zera a contagem
    public void onClickZerar(View view){
        executando = false;
        segundos = 0;
    }

    private void executarTemporizador(){

        final TextView textView = (TextView) findViewById(R.id.txtTempo);
        final Handler handler = new Handler();

        handler.post(new Runnable() {

            @Override
            public void run() {
                //Transformamos os segundos em horas e minutos

                int horas = segundos / 3600;
                int minutos = (segundos % 3600) / 60;
                int segundos_internos = segundos % 60;


                //Formato para que apareça na tela da forma que desejo
                String tempo = String.format(Locale.getDefault(), "%d:%02d:%02d", horas, minutos, segundos_internos);

                //Hora de colocar o texto no textView
                textView.setText(tempo);

                //Incrementamos os segundos, caso o executando seja verdadeiro
                if (executando) {
                    segundos++;
                }

                //Fazemos com que nosso codigo seja executado depos de 1 seg
                handler.postDelayed(this, 1000);
            }

        }
        );
    }
}