package br.inatel.lojaonline.adapters;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.inatel.lojaonline.R;
import br.inatel.lojaonline.models.Order;

/**
 * Created by bccre on 22/06/2016.
 */
public class OrderAdapter extends BaseAdapter {

    private final Activity activity;
    List<Order> orders;

    public OrderAdapter(Activity activity, List<Order> orders) {
        this.activity = activity;
        this.orders = orders;
    }

    @Override
    public int getCount() {
        return orders.size();
    }

    @Override
    public Object getItem(int position) {
        return orders.get(position);
    }

    @Override
    public long getItemId(int position) {
        return orders.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = activity.getLayoutInflater().inflate(
                R.layout.order_list_item, null);

        Order order = orders.get(position);

        TextView orderListItemNumber = (TextView) view.
                findViewById(R.id.orderListItemNumber);
        orderListItemNumber.setText(Integer.toString(position + 1));

        TextView orderListItemId = (TextView) view.
                findViewById(R.id.orderListItemId);
        orderListItemId.setText(Integer.toString(order.getId()));

        TextView orderListItemUser = (TextView) view.
                findViewById(R.id.orderListItemUser);
        orderListItemUser.setText(order.getUserName());

        return view;
    }
}