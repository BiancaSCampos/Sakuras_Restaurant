//Bianca da Silva Campos RA 98059
package com.uniso.lpdm.sakurarestaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Sakura_MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sakura);
    }

    //Aqui eu programo o evento do click no botão para mudar o TextView chamado campo_de_modificacoes para "Registrando Pedido"
    public void onClickFazerPedido(View view){
        TextView fazer_pedido = (TextView) findViewById(R.id.campo_de_modificacoes);
        fazer_pedido.setText("Registrando pedido");
    }

    //Aqui eu programo o evento do click no botão para chamar a atividade VerHorasActivity"
    public void onClickConsultarHoras(View view){
        Intent intencao_consular_horas = new Intent(this, VerHorasActivity.class);
        startActivity(intencao_consular_horas);
    }
    //Aqui eu programo o evento do click no botão para chamar a atividade ContatoCozinhaActivity
    public void onClickContatarCozinha(View view){
        Intent intencao_contatar_cozinha = new Intent(this, ContatoCozinhaActivity.class);
        startActivity(intencao_contatar_cozinha);
    }
}