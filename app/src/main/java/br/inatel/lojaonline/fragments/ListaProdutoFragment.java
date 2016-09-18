package br.inatel.lojaonline.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import br.inatel.lojaonline.R;
import br.inatel.lojaonline.adapters.ProdutoAdapter;
import br.inatel.lojaonline.models.Order;
import br.inatel.lojaonline.models.Product;
import br.inatel.lojaonline.tasks.OrderTasks;
import br.inatel.lojaonline.tasks.ProductsEvents;
import br.inatel.lojaonline.tasks.ProdutoTasks;
import br.inatel.lojaonline.util.CheckNetworkConnection;
import br.inatel.lojaonline.webservice.WebServiceResponse;

/**
 * Created by bccre on 28/06/2016.
 */
public class ListaProdutoFragment extends Fragment implements ProductsEvents {

    private ListView listViewProducts;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getActivity().setTitle("Lista de Pedidos");

        View rootView = inflater.inflate(R.layout.fragment_produto, container, false);

        listViewProducts = (ListView) rootView.
                findViewById(R.id.list_produtos);

        if (CheckNetworkConnection.isNetworkConnected(getActivity())) {
            ProdutoTasks produtoTasks = new ProdutoTasks(getActivity(), this);
            produtoTasks.getProduto();
        }
        return rootView;
    }

    @Override
    public void getProductsFinished(List<Product> products) {
        ProdutoAdapter productAdapter = new ProdutoAdapter(getActivity(), products);
        listViewProducts.setAdapter(productAdapter);
    }

    @Override
    public void getProductsFailed(WebServiceResponse webServiceResponse) {

    }

    @Override
    public void getProductsByIdFinished(Product products) {

    }

    @Override
    public void getProductsByIdFailed(WebServiceResponse webServiceResponse) {

    }

    @Override
    public void postProductFinished(WebServiceResponse webServiceResponse) {

    }

    @Override
    public void postProductFailed(WebServiceResponse webServiceResponse) {

    }
}