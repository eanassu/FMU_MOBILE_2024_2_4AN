package br.fmu.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.NumberFormat;

public class GorjetaActivity extends AppCompatActivity {

    private EditText editTextNumber;
    private TextView textViewValor;
    private TextView textViewPorcentagem;
    private SeekBar seekBar;
    private TextView textViewGorjeta;
    private TextView textViewTotal;

    private double porcentagem = 0.0;
    private double valor = 0.0;

    private NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
    private NumberFormat percentFormat = NumberFormat.getPercentInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gorjeta);
        editTextNumber = findViewById(R.id.editTextNumber);
        textViewValor = findViewById(R.id.textViewValor);
        textViewPorcentagem = findViewById(R.id.textViewPorcentagem);
        seekBar = findViewById(R.id.seekBar);
        textViewGorjeta = findViewById(R.id.textViewGorjeta);
        textViewTotal = findViewById(R.id.textViewTotal);

        editTextNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                int valorInt;
                try {
                    valorInt = Integer.parseInt(editTextNumber.getText().toString());
                } catch ( NumberFormatException e ) {
                    valorInt = 0;
                }
                valor = valorInt/100.0;
                atualizarValores();
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                porcentagem = i/100d;
                atualizarValores();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }

    private void atualizarValores() {
        textViewValor.setText(currencyFormat.format(valor));
        textViewPorcentagem.setText(percentFormat.format(porcentagem));
        double gorjeta = valor * porcentagem;
        textViewGorjeta.setText(currencyFormat.format(gorjeta));
        double total = valor + gorjeta;
        textViewTotal.setText(currencyFormat.format(total));
    }
}