package calculadora.com.br.calculadoraflex;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AdapterFipe extends BaseAdapter {

    String tipo;
    Context contexto;
    List<Fipe> fipes;
    List<Veiculo> veiculos;
    List<VeiculoModelo> veiculoModelos;
    VeiculoModeloPreco veiculoModeloPreco;

    public AdapterFipe(Context contexto, String tipo, List<Fipe> fipes, List<Veiculo> veiculos, List<VeiculoModelo> veiculoModelos, VeiculoModeloPreco veiculoModeloPreco) {
        this.contexto = contexto;
        this.tipo = tipo;
        this.fipes = fipes;
        this.veiculos = veiculos;
        this.veiculoModelos = veiculoModelos;
        this.veiculoModeloPreco = veiculoModeloPreco;
    }

    @Override
    public int getCount() {
        if(tipo.equals("veiculo")){
            return veiculos.size();
        }else if(tipo.equals("modelo")) {
            return  veiculoModelos.size();
        }else if(tipo.equals("preco")) {
            return  1;
        }else {
            return fipes.size();
        }
    }

    @Override
    public Object getItem(int position) {
        if(tipo.equals("veiculo")){
            return veiculos.get(position);
        }else if (tipo.equals("modelo")) {
            return veiculoModelos.get(position);
        }else if (tipo.equals("preco")) {
            return veiculoModeloPreco;
        }else {
            return fipes.get(position);
        }
    }

    @Override
    public long getItemId(int position) {
        if(tipo.equals("veiculo")){
            return veiculos.get(position).getId();
        }else if (tipo.equals("modelo")) {
            return Integer.valueOf(veiculoModelos.get(position).getId().replace("-","").trim());
        }else if (tipo.equals("preco")) {
            return Integer.valueOf(veiculoModeloPreco.getId());
        }else {
            return fipes.get(position).getId();
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View viewLinha = null;
        if(tipo.equals("marca")) {
            viewLinha = LayoutInflater.from(contexto).inflate(R.layout.marcas_veiculo, parent, false);
            TextView marcaid = (TextView) viewLinha.findViewById(R.id.textViewID);
            TextView marcanome = (TextView) viewLinha.findViewById(R.id.textViewNome);
            Fipe fipe = fipes.get(position);
            marcaid.setText(fipe.getId().toString());
            marcanome.setText(fipe.getName());
        }else if (tipo.equals("veiculo")){
            viewLinha = LayoutInflater.from(contexto).inflate(R.layout.linhas_veiculo, parent, false);
            TextView nomeVeiculo = (TextView) viewLinha.findViewById(R.id.nomeVeiculo);
            Veiculo veiculo = veiculos.get(position);
            nomeVeiculo.setText(veiculo.getName());
        }else if (tipo.equals("modelo")){
            viewLinha = LayoutInflater.from(contexto).inflate(R.layout.linhas_modelo, parent, false);
            TextView nomeModelo = (TextView) viewLinha.findViewById(R.id.nomeModelo);
            TextView anoModelo = (TextView) viewLinha.findViewById(R.id.anoModelo);
            VeiculoModelo veiculoModelo = veiculoModelos.get(position);
            nomeModelo.setText(veiculoModelo.getVeiculo());
            anoModelo.setText(veiculoModelo.getName());
        }else if (tipo.equals("preco")){
            viewLinha = LayoutInflater.from(contexto).inflate(R.layout.linhas_modelo_preco, parent, false);
            TextView modeloPrecoNome = (TextView) viewLinha.findViewById(R.id.modeloPrecoNome);
            TextView modeloPreco = (TextView) viewLinha.findViewById(R.id.modeloPreco);
            modeloPrecoNome.setText(veiculoModeloPreco.getName());
            modeloPreco.setText(veiculoModeloPreco.getPreco());
        }

        return viewLinha;
    }
}
