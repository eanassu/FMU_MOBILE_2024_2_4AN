package br.fmu.helloworld;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
public class MainActivity extends AppCompatActivity {
    private EditText editTextNumber1;
    private EditText editTextNumber2;
    private EditText editTextNumber3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextNumber1 = findViewById(R.id.editTextNumber1);
        editTextNumber2 = findViewById(R.id.editTextNumber2);
        editTextNumber3 = findViewById(R.id.editTextNumber3);
    }
    public void somar(View view) {
        int x = Integer.parseInt(editTextNumber1.getText().toString());
        int y = Integer.parseInt(editTextNumber2.getText().toString());
        int soma = x + y;
        editTextNumber3.setText(Integer.toString(soma));
    }

    public void abrirJanela(View view) {
        int x = Integer.parseInt(editTextNumber1.getText().toString());
        int y = Integer.parseInt(editTextNumber2.getText().toString());
        int soma = x + y;
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("soma", soma );
        startActivity(intent);
    }

    public void abrirGorjeta( View view ) {
        Intent intent = new Intent(this, GorjetaActivity.class);
        startActivity(intent);
    }

    public void abrirBancoDeDados( View view ) {
        Intent intent = new Intent(this, DatabaseActivity.class);
        startActivity(intent);
    }

    public void abrirDesenho(View view) {
        Intent intent = new Intent(this, DesenhoActivity.class);
        startActivity(intent);
    }

    public void abrirSensores(View view) {
        Intent intent = new Intent(this, SensorActivity.class);
        startActivity(intent);
    }

    public void abrirHttp(View view) {
        Intent intent = new Intent(this, HttpActivity.class);
        startActivity(intent);
    }

    public void abrirMapas(View view) {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }
}

