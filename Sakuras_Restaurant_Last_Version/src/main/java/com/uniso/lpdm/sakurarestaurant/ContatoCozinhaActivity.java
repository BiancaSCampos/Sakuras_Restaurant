package com.uniso.lpdm.sakurarestaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class ContatoCozinhaActivity extends AppCompatActivity {

    /*Para mostrar o que iremos esperar quando a outra atividade enviar uma mensagem
      para a atividade ContatoCozinhaActivity utilizamos uma constante*/
    public static final String MENSAGEMCOZINHA_EXTRA = "texto";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contato_cozinha);

        //Aqui recuperamos a intenção criada na outra activity 
        Intent intecaoRecebida = getIntent();
        String mensagem_cozinha = intecaoRecebida.getStringExtra(MENSAGEMCOZINHA_EXTRA);
    }


    //Nesse metodo, programo o evento onClick do botão
    public void onClickEnviarMensagem(View view){

        //Aqui pegamos o texto que estava no editText
        EditText editText =(EditText) findViewById(R.id.editContatarCozinha);
        String mensagem = editText.getText().toString();

        /*
        Aqui programo uma inteção para que ela abra os aplicativos que podem mandar a mensagem do celular no qual a aplicação
        está rodando
         */
        Intent intencao = new Intent(Intent.ACTION_SEND);
        intencao.setType("text/plain");
        intencao.putExtra(Intent.EXTRA_TEXT, mensagem);
        intencao.putExtra(Intent.EXTRA_SUBJECT, "Assunto");

        startActivity(intencao);
    }

}