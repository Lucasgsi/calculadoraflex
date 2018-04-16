package calculadora.com.br.calculadoraflex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class Calculadoraflex extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private android.widget.ListView listViewCarros;
    private String resultadoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculadoraflex);

        Button buttonCalcular = (Button) findViewById(R.id.buttonCalcular);
        EditText etanolIn = (EditText) findViewById(R.id.editEtanol);
        EditText gasolinaIn = (EditText) findViewById(R.id.editGasolina);
        TextView labelEtanol = (TextView) findViewById(R.id.textViewInfEtanol);
        TextView labelGasolina = (TextView) findViewById(R.id.textViewInfGaso);

        buttonCalcular.setVisibility(View.INVISIBLE);
        etanolIn.setVisibility(View.INVISIBLE);
        gasolinaIn.setVisibility(View.INVISIBLE);
        labelEtanol.setVisibility(View.INVISIBLE);
        labelGasolina.setVisibility(View.INVISIBLE);

        listViewCarros = (android.widget.ListView) findViewById(R.id.listCarros);

        String carros[] = {"GOL", "Astra"};

        ArrayAdapter<String> adapterTimes = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, carros);
        listViewCarros.setAdapter(adapterTimes);
        listViewCarros.setOnItemClickListener(this);
    }

    public void calcular(View view){
        Button buttonCalcular = (Button) findViewById(R.id.buttonCalcular);

        EditText etanolIn = (EditText) findViewById(R.id.editEtanol);
        EditText gasolinaIn = (EditText) findViewById(R.id.editGasolina);

        TextView resultadoFinal = (TextView) findViewById(R.id.textViewResultado);
        TextView labelEtanol = (TextView) findViewById(R.id.textViewInfEtanol);
        TextView labelGasolina = (TextView) findViewById(R.id.textViewInfGaso);

        if(buttonCalcular.getText().toString().equals("Calcular Novamente")){
            etanolIn.setText("");
            gasolinaIn.setText("");
            resultadoFinal.setText("");
            buttonCalcular.setVisibility(View.INVISIBLE);
            etanolIn.setVisibility(View.INVISIBLE);
            gasolinaIn.setVisibility(View.INVISIBLE);
            labelEtanol.setVisibility(View.INVISIBLE);
            labelGasolina.setVisibility(View.INVISIBLE);
            etanolIn.setEnabled(true);
            gasolinaIn.setEnabled(true);
            buttonCalcular.setText("Calcular");
        } else {

            Double etanol = Double.parseDouble(etanolIn.getText().toString());
            Double gasolina = Double.parseDouble(gasolinaIn.getText().toString());

            Double resultado = etanol / gasolina;

            DecimalFormat df = new DecimalFormat("#.00");


            if (resultado < 0.70) {
                resultadoFinal.setText("Abastecer o " + resultadoList + " com Etanol.");
            } else {
                resultadoFinal.setText("Abastecer o " + resultadoList + " com Gasolina.");
            }
            buttonCalcular.setText("Calcular Novamente");
            etanolIn.setEnabled(false);
            gasolinaIn.setEnabled(false);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        EditText etanolIn = (EditText) findViewById(R.id.editEtanol);
        EditText gasolinaIn = (EditText) findViewById(R.id.editGasolina);

        TextView labelEtanol = (TextView) findViewById(R.id.textViewInfEtanol);
        TextView labelGasolina = (TextView) findViewById(R.id.textViewInfGaso);

        Button buttonCalcular = (Button) findViewById(R.id.buttonCalcular);

        buttonCalcular.setVisibility(View.VISIBLE);
        etanolIn.setVisibility(View.VISIBLE);
        gasolinaIn.setVisibility(View.VISIBLE);
        labelEtanol.setVisibility(View.VISIBLE);
        labelGasolina.setVisibility(View.VISIBLE);

        resultadoList = parent.getItemAtPosition(position).toString();
    }
}
