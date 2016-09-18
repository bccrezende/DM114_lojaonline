package br.inatel.lojaonline.adapters;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.inatel.lojaonline.R;
import br.inatel.lojaonline.models.Product;

/**
 * Created by bccre on 29/06/2016.
 */
public class ProdutoAdapter extends BaseAdapter {

    private final Activity activity;
    List<Product> products;

    public ProdutoAdapter(Activity activity, List<Product> products) {
        this.activity = activity;
        this.products = products;
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Object getItem(int position) {
        return products.get(position);
    }

    @Override
    public long getItemId(int position) {
        return products.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = activity.getLayoutInflater().inflate(
                R.layout.product_list_item, null);

        Product product = products.get(position);

       // Log.i("Teste", "ID:" + product.getId());
       // Log.i("Teste", "Nome:" + product.getNome());
       // Log.i("Teste", "Preço:" + product.getPreco());
        
        TextView productId = (TextView) view.findViewById(R.id.viewProductId);
        productId.setText(""+product.getId());

        TextView productNome = (TextView) view.findViewById(R.id.productNome);
        productNome.setText(product.getNome());

        TextView productPreco = (TextView) view.findViewById(R.id.productPreco);
        productPreco.setText("" + product.getPreco());

        return view;
    }
}

