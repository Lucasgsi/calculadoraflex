package calculadora.com.br.calculadoraflex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class ConsultarTabelaFipe extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private ListView listViewFipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consultar__tabela__fipe);

        listViewFipe = (ListView) findViewById(R.id.listFipe);
        listViewFipe.setOnItemClickListener(this);

        BuscarFipeWS buscarTimesWS = new BuscarFipeWS(ConsultarTabelaFipe.this);
        buscarTimesWS.execute("http://fipeapi.appspot.com/api/1/carros/marcas.json");
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.i("Consultar_Tabela_Fipe", parent.getItemAtPosition(position).toString());
    }
}
