package com.example.telekomapp.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.telekomapp.R;

import java.util.ArrayList;
import java.util.List;

public class NewOrderFragment extends Fragment {

    private LinearLayout operationsContainer;
    private AutoCompleteTextView operationAutoComplete;
    private ArrayAdapter<String> operationAdapter;
    private List<String> operationList;

    private List<String> materialList;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_new_order, container, false);

        // Находим AutoCompleteTextView для выбора операций
        operationAutoComplete = root.findViewById(R.id.operation_autocomplete);

        // Инициализируем список операций
        operationList = new ArrayList<>();
        operationList.add("Замена шаровой опоры 1");
        operationList.add("Замена шаровой опоры 2");

        // Создаем адаптер для AutoCompleteTextView операций
        operationAdapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_dropdown_item_1line, operationList);
        operationAutoComplete.setAdapter(operationAdapter);

        // Находим кнопку добавления операции
        Button addOperationButton = root.findViewById(R.id.add_operation_button);
        addOperationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedOperation = operationAutoComplete.getText().toString();
                if (!selectedOperation.isEmpty()) {
                    addOperationView(selectedOperation);
                    operationAutoComplete.setText(""); // Очищаем поле после добавления
                } else {
                    Toast.makeText(requireContext(), "Выберите или введите операцию", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Находим контейнер для операций
        operationsContainer = root.findViewById(R.id.operations_container);

        // Инициализируем список материалов
        materialList = new ArrayList<>();
        materialList.add("Графит");
        materialList.add("Кремень");
        materialList.add("Гранит");

        return root;
    }

    private void addOperationView(String operationTitle) {
        // Создаем новую операцию из layout item_operation.xml
        View operationView = getLayoutInflater().inflate(R.layout.item_operation, null);

        // Находим элементы в новой операции
        TextView operationTitleTextView = operationView.findViewById(R.id.operation_title);
        Button deleteOperationButton = operationView.findViewById(R.id.delete_operation_button);
        LinearLayout materialsContainer = operationView.findViewById(R.id.materials_container);
        Button addMaterialButton = operationView.findViewById(R.id.add_material_button);
        EditText commentEditText = operationView.findViewById(R.id.comment_edittext);

        // Устанавливаем название операции
        operationTitleTextView.setText(operationTitle);

        // Добавляем слушатель для кнопки удаления операции
        deleteOperationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Удаляем операцию из контейнера
                operationsContainer.removeView(operationView);
            }
        });

        // Добавляем слушатель для кнопки добавления материалов
        addMaterialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Создаем новый вид материала
                addMaterialView(materialsContainer);
            }
        });

        // Добавляем операцию в начало контейнера
        operationsContainer.addView(operationView, 0);
    }

    private void addMaterialView(LinearLayout materialsContainer) {
        // Создаем новый вид материала из layout item_material.xml
        View materialView = getLayoutInflater().inflate(R.layout.item_material, null);

        // Находим элементы в новом виде материала
        Button deleteMaterialButton = materialView.findViewById(R.id.delete_material_button);

        AutoCompleteTextView materialAutoComplete = materialView.findViewById(R.id.material_auto_complete);
        // Создаем адаптер для AutoCompleteTextView материалов
        ArrayAdapter<String> materialAdapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_dropdown_item_1line, materialList);
        materialAutoComplete.setAdapter(materialAdapter);

        // Добавляем слушатель для кнопки удаления материала
        deleteMaterialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Удаляем материал из контейнера
                materialsContainer.removeView(materialView);
            }
        });

        // Добавляем материал в контейнер материалов операции
        materialsContainer.addView(materialView);
    }
}
