package br.inatel.lojaonline.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.inatel.lojaonline.R;
import br.inatel.lojaonline.models.Order;
import br.inatel.lojaonline.tasks.OrderEvents;
import br.inatel.lojaonline.tasks.OrderTasks;
import br.inatel.lojaonline.util.CheckNetworkConnection;
import br.inatel.lojaonline.webservice.WebServiceResponse;

/**
 * Created by bccre on 22/06/2016.
 */
public class OrderDetailFragment extends Fragment implements OrderEvents{

    private  TextView ListaDetails;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getActivity().setTitle("Order detail");

        View rootView = inflater.inflate(R.layout.fragment_order_details,container,false);
        ListaDetails = (TextView) rootView.findViewById(R.id.OrderDetails);
        int orderId;
        Bundle bundle = this.getArguments();
        if ((bundle != null) && (bundle.containsKey("order_id"))) {
            orderId = bundle.getInt("order_id");

            if(CheckNetworkConnection.isNetworkConnected(getActivity())){
                OrderTasks orderTasks = new OrderTasks(getActivity(), this);
                orderTasks.getOrderById(orderId);
            }
        }



        return rootView;
    }

    @Override
    public void getOrdersFinished(List<Order> orders) {

    }

    @Override
    public void getOrdersFailed(WebServiceResponse webServiceResponse) {

    }

    @Override
    public void getOrderByIdFinished(Order order) {
        ListaDetails.setText("ID:" + order.getId() + "User:" + order.userName + "Frete:" + order.precoFrete);

    }

    @Override
    public void getOrderByIdFailed(WebServiceResponse webServiceResponse) {

    }
}

