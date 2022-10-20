package br.ulbra.aula8salario;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity
{
    EditText edSalario;

    RadioGroup rgBotoes;

    Button btCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edSalario = findViewById(R.id.edSalario);
        rgBotoes = findViewById(R.id.rgBotoes);
        btCalcular = findViewById(R.id.btCalcular);

        btCalcular.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                double salario = Double.parseDouble(edSalario.getText().toString());
                int op = rgBotoes.getCheckedRadioButtonId();
                double novo_salario = 0;

                if (op == R.id.rb40)
                {
                    novo_salario = salario + (salario * 0.4);
                }
                else if (op == R.id.rb45)
                {
                    novo_salario = salario + (salario * 0.45);
                }
                else
                {
                    novo_salario = salario + (salario * 0.5);

                    AlertDialog.Builder dialogo = new AlertDialog.Builder(MainActivity.this);
                    dialogo.setTitle("Novo salário");
                    dialogo.setMessage("Seu novo salário é: R$" +String.valueOf(novo_salario));
                    dialogo.setNeutralButton("Fechar",null);
                    dialogo.show();
                }
            }
        });
    }
}