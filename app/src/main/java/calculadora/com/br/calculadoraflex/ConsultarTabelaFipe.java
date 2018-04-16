package calculadora.com.br.calculadoraflex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class ConsultarTabelaFipe extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private ListView listViewFipe;
    private BuscarFipeWS buscarTimesWS = new BuscarFipeWS(ConsultarTabelaFipe.this);
    private Fipe fipe;
    private Veiculo veiculo;
    private VeiculoModelo veiculoModelo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consultar__tabela__fipe);

        listViewFipe = (ListView) findViewById(R.id.listFipe);
        listViewFipe.setOnItemClickListener(this);
        buscarTimesWS.execute("http://fipeapi.appspot.com/api/1/carros/marcas.json-marca");
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView nomeVeiculo = (TextView) findViewById(R.id.nomeVeiculo);
        TextView nomeMarca = (TextView) findViewById(R.id.textViewNome);
        TextView nomeModelo = (TextView) findViewById(R.id.nomeModelo);

        if(nomeMarca != null) {
            System.out.println("Veiculo");
            fipe = (Fipe) parent.getItemAtPosition(position);
            buscarTimesWS = new BuscarFipeWS(ConsultarTabelaFipe.this);
            buscarTimesWS.execute("http://fipeapi.appspot.com/api/1/carros/veiculos/"+fipe.getId()+".json-veiculo");
        } else if(nomeVeiculo != null){
            veiculo = (Veiculo) parent.getItemAtPosition(position);
            buscarTimesWS = new BuscarFipeWS(ConsultarTabelaFipe.this);
            buscarTimesWS.execute("http://fipeapi.appspot.com/api/1/carros/veiculo/"+fipe.getId()+"/"+veiculo.getId()+".json-modelo");
        }else if(nomeModelo != null){
            veiculoModelo = (VeiculoModelo) parent.getItemAtPosition(position);
            buscarTimesWS = new BuscarFipeWS(ConsultarTabelaFipe.this);
            buscarTimesWS.execute("http://fipeapi.appspot.com/api/1/carros/veiculo/"+fipe.getId()+"/"+veiculo.getId()+"/"+veiculoModelo.getId()+".json-preco");
        }
    }
}
