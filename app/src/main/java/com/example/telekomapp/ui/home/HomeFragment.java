package com.example.telekomapp.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.telekomapp.R;
import com.example.telekomapp.databinding.FragmentHomeBinding;
import com.example.telekomapp.ui.NewOrderFragment;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Пример обработчика клика по блоку заказа #1
        binding.order3Block.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(requireContext(), "Нажат заказ #1", Toast.LENGTH_SHORT).show();
                // Добавьте код для обработки клика на заказ #1
            }
        });

        // Пример обработчика клика по блоку заказа #2
        binding.order3Block.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(requireContext(), "Нажат заказ #2", Toast.LENGTH_SHORT).show();
                // Добавьте код для обработки клика на заказ #2
            }
        });

        // Пример обработчика клика по блоку заказа #3
        binding.order3Block.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(requireContext(), "Нажат заказ #3", Toast.LENGTH_SHORT).show();
                // Добавьте код для обработки клика на заказ #3
            }
        });

        // Пример обработчика клика по блоку заказа #4
        binding.order4Block.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(requireContext(), "Нажат заказ #4", Toast.LENGTH_SHORT).show();
                // Добавьте код для обработки клика на заказ #4
            }
        });

        // Пример обработчика клика по блоку "История заказов"
        binding.historyOrdersBlock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(requireContext(), "Нажат блок История заказов", Toast.LENGTH_SHORT).show();
                // Добавьте код для обработки клика на блок "История заказов"
            }
        });

        // Обработчик для кнопки перехода на fragment_new_order
        Button goToOrderButton = root.findViewById(R.id.button_go_to_order);
        goToOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Навигация к NewOrderFragment через NavController
                Navigation.findNavController(v).navigate(R.id.action_navigation_home_to_newOrderFragment);
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
