package com.example.telekomapp.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.telekomapp.R;
import com.example.telekomapp.databinding.FragmentDashboardBinding;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;
    private LinearLayout ordersContainer;
    private TextView btnCompleted;
    private TextView btnCancelled;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        ordersContainer = binding.ordersContainer;
        btnCompleted = binding.btnCompleted;
        btnCancelled = binding.btnCancelled;

        // Initially show completed orders
        showCompletedOrders();

        btnCompleted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCompletedOrders();
            }
        });

        btnCancelled.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCancelledOrders();
            }
        });

        return root;
    }

    private void showCompletedOrders() {
        btnCompleted.setTextColor(getResources().getColor(R.color.button));
        btnCancelled.setTextColor(getResources().getColor(R.color.nav_bar_item_color));
        ordersContainer.removeAllViews();

        LayoutInflater inflater = getLayoutInflater();
        for (int i = 1; i <= 6; i++) {
            View orderView = inflater.inflate(R.layout.order_item_completed, ordersContainer, false);
            ((TextView) orderView.findViewById(R.id.order_title)).setText("Заказ #" + i);
            ((TextView) orderView.findViewById(R.id.order_location)).setText("Местоположение #" + i);
            ((TextView) orderView.findViewById(R.id.order_date)).setText("01.01.2022 - 01.02.2022");
            ordersContainer.addView(orderView);
        }
    }

    private void showCancelledOrders() {
        btnCancelled.setTextColor(getResources().getColor(R.color.button));
        btnCompleted.setTextColor(getResources().getColor(R.color.nav_bar_item_color));
        ordersContainer.removeAllViews();

        LayoutInflater inflater = getLayoutInflater();
        for (int i = 1; i <= 6; i++) {
            View orderView = inflater.inflate(R.layout.order_item_cancelled, ordersContainer, false);
            ((TextView) orderView.findViewById(R.id.order_title)).setText("Заказ #" + (i + 6));
            ordersContainer.addView(orderView);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
