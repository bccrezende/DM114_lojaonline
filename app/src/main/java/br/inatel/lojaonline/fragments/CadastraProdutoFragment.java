package br.inatel.lojaonline.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


import java.util.List;

import br.inatel.lojaonline.R;
import br.inatel.lojaonline.models.Product;
import br.inatel.lojaonline.tasks.ProductsEvents;
import br.inatel.lojaonline.tasks.ProdutoTasks;
import br.inatel.lojaonline.webservice.WebServiceResponse;

/**
 * Created by bccre on 29/06/2016.
 */
public class CadastraProdutoFragment extends Fragment implements ProductsEvents, View.OnClickListener {

    private EditText IdNovoProduto;
    private EditText NomeNovoProduto;
    private EditText PrecoNovoProduto;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getActivity().setTitle("Lista de Desejos - Produtos");

        View rootView = inflater.inflate(R.layout.fragment_cadastra_produto, container, false);

        IdNovoProduto = (EditText) rootView.findViewById(R.id.idNovoProduto);
        NomeNovoProduto = (EditText) rootView.findViewById(R.id.nomeNovoProduto);
        PrecoNovoProduto = (EditText) rootView.findViewById(R.id.precoNovoProduto);

        Button btnCadastro = (Button) rootView.findViewById(R.id.btnCadastro);
        btnCadastro.setOnClickListener(this);


        return rootView;
    }

    @Override
    public void onClick(View v) {
        Product product = new Product();
        product.setId(Integer.parseInt(IdNovoProduto.getText().toString()));
        product.setNome(NomeNovoProduto.getText().toString());
        product.setPreco(Double.parseDouble(PrecoNovoProduto.getText().toString()));

        ProdutoTasks produtoTasks = new ProdutoTasks(getActivity(), this);
        produtoTasks.postNovoProduto(product);
    }

    @Override
    public void getProductsFinished(List<Product> products) {

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
        Log.i("DEU CERTO","DEU CERTO");
    }

    @Override
    public void postProductFailed(WebServiceResponse webServiceResponse) {

    }

}
