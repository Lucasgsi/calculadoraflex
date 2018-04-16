package calculadora.com.br.calculadoraflex;

import android.app.Activity;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class BuscarFipeWS extends AsyncTask<String, Integer, String>{

    Activity activity;
    ProgressBar progressBar;
    private String tipoConversao = "marca";

    public BuscarFipeWS(Activity activity) {
        this.activity = activity;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Gson gson = new Gson();
        if(tipoConversao.equals("marca")) {

            List<Fipe> fipes = gson.fromJson(s, new TypeToken<List<Fipe>>() {
            }.getType());
            AdapterFipe adapterFipes = new AdapterFipe(activity, tipoConversao, fipes, null,null, null);
            ListView listView = (ListView) activity.findViewById(R.id.listFipe);
            listView.setAdapter(adapterFipes);
        }else if (tipoConversao.equals("veiculo")){

            List<Veiculo> veiculos = gson.fromJson(s, new TypeToken<List<Veiculo>>() {
            }.getType());
            AdapterFipe adapterFipes = new AdapterFipe(activity, tipoConversao, null, veiculos,null, null);
            ListView listView = (ListView) activity.findViewById(R.id.listFipe);
            listView.setAdapter(adapterFipes);
        }else if (tipoConversao.equals("modelo")) {
            List<VeiculoModelo> veiculoModelos = gson.fromJson(s, new TypeToken<List<VeiculoModelo>>() {
            }.getType());
            AdapterFipe adapterFipes = new AdapterFipe(activity, tipoConversao, null, null,veiculoModelos, null);
            ListView listView = (ListView) activity.findViewById(R.id.listFipe);
            listView.setAdapter(adapterFipes);
        }else if (tipoConversao.equals("preco")) {
            VeiculoModeloPreco veiculoModeloPreco = gson.fromJson(s, new TypeToken<VeiculoModeloPreco>() {
            }.getType());
            AdapterFipe adapterFipes = new AdapterFipe(activity, tipoConversao, null, null,null,veiculoModeloPreco);
            ListView listView = (ListView) activity.findViewById(R.id.listFipe);
            listView.setAdapter(adapterFipes);
        }



        //progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected String doInBackground(String... strings) {
        String jsonRetorno = null;
        try {

            if(strings[0].contains("-marca")){

                tipoConversao = "marca";
                strings[0] = strings[0].replace("-marca", "");
            } else if(strings[0].contains("-veiculo")){

                tipoConversao = "veiculo";
                strings[0] = strings[0].replace("-veiculo", "");
            } else if(strings[0].contains("-modelo")){

                tipoConversao = "modelo";
                strings[0] = strings[0].replace("-modelo", "");
            } else if(strings[0].contains("-preco")){

                tipoConversao = "preco";
                strings[0] = strings[0].replace("-preco", "");
            }

            URL url = new URL(strings[0]);
            InputStream stream = url.openStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stream));
            StringBuilder builder = new StringBuilder();
            String linha;
            while ((linha = bufferedReader.readLine())!=null) {
                builder.append(linha);
            }
            jsonRetorno = builder.toString();
        }catch (MalformedURLException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return jsonRetorno;
    }
}
