package calculadora.com.br.calculadoraflex;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AdapterFipe extends BaseAdapter {

    Context contexto;
    List<Fipe> fipes;

    public AdapterFipe(Context contexto, List<Fipe> fipes) {
        this.contexto = contexto;
        this.fipes = fipes;
    }

    @Override
    public int getCount() {
        return fipes.size();
    }

    @Override
    public Object getItem(int position) {
        return fipes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return fipes.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewLinha = LayoutInflater.from(contexto).inflate(R.layout.marcas_veiculo,parent,false);

        TextView marcaid = (TextView) viewLinha.findViewById(R.id.textViewID);
        TextView marcanome = (TextView) viewLinha.findViewById(R.id.textViewNome);

        Fipe fipe = fipes.get(position);
         marcaid.setText(fipe.getId().toString());
         marcanome.setText(fipe.getName());

        return viewLinha;
    }
}
