package com.lucasmslima.apppedrapapeltesoura;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionarPedra(View view){
        verificarGanhador("pedra");
    }

    public void selecionarPapel(View view){
        verificarGanhador("papel");
    }

    public void selecionarTesoura(View view){
        verificarGanhador("tesoura");
    }

    private String gerarEscolhaAleatoriaAPP() {

        String[] opcoes = {
                "pedra",
                "papel",
                "tesoura"
        };
        int numeroAleatorio = new Random().nextInt(3);
        ImageView imagemAPP = findViewById(R.id.image_app);
        String escolhaAPP = opcoes [numeroAleatorio];
        switch (escolhaAPP){
            case "pedra":
                imagemAPP.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imagemAPP.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imagemAPP.setImageResource(R.drawable.tesoura);
                break;
        }
        return escolhaAPP;

    }


    private void verificarGanhador(String escolhaUsuario){
        
        String escolhaAPP = gerarEscolhaAleatoriaAPP();
        TextView textoResultado = findViewById(R.id.text_resultado);

        if (
            (escolhaAPP == "pedra" && escolhaUsuario == "tesoura") ||
            (escolhaAPP == "papel" && escolhaUsuario == "pedra") ||
            (escolhaAPP == "tesoura" && escolhaUsuario == "papel")
        ){//App Ganhador
            textoResultado.setText("Você perdeu :( ");
        } else if (
            (escolhaUsuario == "pedra" && escolhaAPP == "tesoura") ||
            (escolhaUsuario == "papel" && escolhaAPP == "pedra") ||
            (escolhaUsuario == "tesoura" && escolhaAPP == "papel")
        ) {//Usuario Ganhador
            textoResultado.setText("Você ganhou :) ");
        }else{//Empate
            textoResultado.setText("Empatamos ;) ");
        }

    }



}