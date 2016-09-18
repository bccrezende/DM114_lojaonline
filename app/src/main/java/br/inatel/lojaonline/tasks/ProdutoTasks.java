package br.inatel.lojaonline.tasks;

import android.content.Context;
import android.os.AsyncTask;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import br.inatel.lojaonline.models.Product;
import br.inatel.lojaonline.util.WSUtil;
import br.inatel.lojaonline.webservice.WebServiceClient;
import br.inatel.lojaonline.webservice.WebServiceResponse;

/**
 * Created by bccre on 29/06/2016.
 */
public class ProdutoTasks {
    private static final String GET_PRODUTOS = "/api/Products";
    private static final String GET_PRODUTOS_BY_ID = "/api/Products";
    private static final String POST_NOVO_PRODUTO = "/api/Products";
    private ProductsEvents productsEvents;
    private Context context;
    private String baseAddress;

    public ProdutoTasks(Context context, ProductsEvents productsEvents) {
        String host;
        int port;
        this.context = context;
        this.productsEvents = productsEvents;
        baseAddress = WSUtil.getHostAddress(context);
    }
    public void getProduto() {
        new AsyncTask<Void, Void, WebServiceResponse>() {
            @Override
            protected WebServiceResponse doInBackground(Void... params) {
                return WebServiceClient.get(context,
                        baseAddress + GET_PRODUTOS);
            }
            @Override
            protected void onPostExecute(
                    WebServiceResponse webServiceResponse) {
                if (webServiceResponse.getResponseCode() == 200) {
                    Gson gson = new Gson();
                    try {
                        List<Product> products = gson.fromJson(
                                webServiceResponse.getResultMessage(),
                                new TypeToken<List<Product>>() {
                                }.getType());
                        productsEvents.getProductsFinished(products);
                    } catch (Exception e) {
                        productsEvents.getProductsFailed(webServiceResponse);
                    }
                } else {
                    productsEvents.getProductsFailed(webServiceResponse);
                }
            }
        }.execute(null, null, null);
    }
    public void getProdutosById(int id) {
        new AsyncTask<Integer, Void, WebServiceResponse>() {
            @Override
            protected WebServiceResponse doInBackground(Integer... id) {
                return WebServiceClient.get(context,
                        baseAddress + GET_PRODUTOS_BY_ID + "/" +
                                Integer.toString(id[0]));
            }
            @Override
            protected void onPostExecute(
                    WebServiceResponse webServiceResponse) {
                if (webServiceResponse.getResponseCode() == 200) {
                    Gson gson = new Gson();
                    try {
                        Product product = gson.fromJson(
                                webServiceResponse.getResultMessage(),
                                Product.class);
                        productsEvents.getProductsByIdFinished(product);
                    } catch (Exception e) {
                        productsEvents.getProductsByIdFailed(webServiceResponse);
                    }
                } else {
                    productsEvents.getProductsByIdFailed(webServiceResponse);
                }
            }
        }.execute(id, null, null);
    }
    public void postNovoProduto(final Product product) {
        new AsyncTask<Integer, Void, WebServiceResponse>() {

            @Override
            protected WebServiceResponse doInBackground(Integer... id) {
                JSONObject productJson = new JSONObject();
                try {

                    productJson.put("codigo", product.getId());
                    productJson.put("nome", product.getNome());
                    productJson.put("preco", product.getPreco());

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return WebServiceClient.post(context,
                        baseAddress + POST_NOVO_PRODUTO, productJson.toString());


            }
            @Override
            protected void onPostExecute(
                    WebServiceResponse webServiceResponse) {
                if (webServiceResponse.getResponseCode() == 200) {
                    productsEvents.postProductFinished(webServiceResponse);
                } else {
                    productsEvents.postProductFailed(webServiceResponse);
                }
            }
        }.execute();
    }


}
