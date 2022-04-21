package com.example.iment;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class focus extends AppCompatActivity {

    TextView category;
    boolean[] selectedCategory;
    ArrayList<Integer> categorylist = new ArrayList<>();
    String[] categoryArray = {"Anger","Depression","Anxiety","Loneliness",
            "Sadness","Others"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_focus);

        Button mButton = (Button) findViewById(R.id.contbtn);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(focus.this, home.class));

            }
        });


        category = findViewById(R.id.cat_egory);

                selectedCategory = new boolean[categoryArray.length];

                category.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        AlertDialog.Builder builder = new AlertDialog.Builder(
                                focus.this
                        );
                        builder.setTitle("Select Category");

                        builder.setCancelable(false);

                        builder.setMultiChoiceItems(categoryArray, selectedCategory, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i, boolean b) {

                                if (b) {
                                    categorylist.add(i);

                                    Collections.sort(categorylist);
                                } else {
                                    categorylist.remove(i);
                                }
                            }
                        });
                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                StringBuilder stringBuilder = new StringBuilder();

                                for (int j = 0; j < categorylist.size(); j++) {
                                    stringBuilder.append(categoryArray[categorylist.get(j)]);

                                    if (j != categorylist.size() - 1) {
                                        stringBuilder.append(",");
                                    }
                                }
                                category.setText(stringBuilder.toString());
                            }
                        });
                        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                        builder.setNeutralButton("Clear All", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                for (int j = 0; j < selectedCategory.length; j++) {
                                    selectedCategory[j] = false;

                                    categorylist.clear();
                                    category.setText("");
                                }
                            }
                        });
                        builder.show();
                    }
                });


            }
            }