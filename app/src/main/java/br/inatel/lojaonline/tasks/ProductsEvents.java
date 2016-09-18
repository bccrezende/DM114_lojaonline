package br.inatel.lojaonline.tasks;

import java.util.List;

import br.inatel.lojaonline.models.Order;
import br.inatel.lojaonline.webservice.WebServiceResponse;
import br.inatel.lojaonline.models.Product;

/**
 * Created by bccre on 29/06/2016.
 */

public interface ProductsEvents {
    void getProductsFinished(List<Product> products);
    void getProductsFailed(WebServiceResponse webServiceResponse);
    void getProductsByIdFinished(br.inatel.lojaonline.models.Product products);
    void getProductsByIdFailed(WebServiceResponse webServiceResponse);
    void postProductFinished(WebServiceResponse webServiceResponse);
    void postProductFailed(WebServiceResponse webServiceResponse);

}
