package com.example.hot_food_delivery_pmo.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.hot_food_delivery_pmo.Adapter.CategoryAdapter;
import com.example.hot_food_delivery_pmo.Adapter.RecommendedAdapter;
import com.example.hot_food_delivery_pmo.Domain.CategoryDomain;
import com.example.hot_food_delivery_pmo.Domain.FoodDomain;
import com.example.hot_food_delivery_pmo.R;

import java.util.ArrayList;

public class IntroActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter,adapter2;
    private RecyclerView recyclerViewCategoryList,recyclerViewPopularList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        recyclerViewCategory();
        recyclerViewPopular();
        bottomNavigation();
    }

    private void bottomNavigation() {
        LinearLayout homeBtn=findViewById(R.id.homeBtn);
        LinearLayout cartBtn=findViewById(R.id.cartBtn);
        LinearLayout cameraBtn=findViewById(R.id.cameraBtn);
        LinearLayout mappBtn=findViewById(R.id.mappBtn);

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(IntroActivity.this,IntroActivity.class));
            }
        });
        cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(IntroActivity.this,CartActivity.class));
            }
        });
        cameraBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(IntroActivity.this,CameraActivity.class));
            }
        });
        mappBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(IntroActivity.this,MappActivity.class));
            }
        });
    }

    private void recyclerViewPopular() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        RecyclerView recyclerViewPopularList = findViewById(R.id.view2);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<FoodDomain> foodList = new ArrayList<>();
        foodList.add(new FoodDomain("Pizza Pepperoni", "pizza1", "Part de pepperoni, Fromage mozarella, Origan frais, Poivre Noir moulu, Sauce à pizza",13.0,5,20,1000));
        foodList.add(new FoodDomain("Cheese Burger", "burger", "Boeuf, Fromage Gouda, Sauce special, Laitue, Tomate ",15.20,4,18,1500));
        foodList.add(new FoodDomain("Pizza Vegetan", "pizza3", "Huile d'olive, Huile vegetal, Kalamata dénoyautée, Tomates-cerises, Origan frais, Basilic ",11.0,5,16,800));

        RecommendedAdapter adapter2 = new RecommendedAdapter(foodList);
        recyclerViewPopularList.setAdapter(adapter2);
    }

    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager( this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerViewCategoryList = findViewById(R.id.view1);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> categoryList = new ArrayList<>();

        categoryList.add(new CategoryDomain("Hotdog", "Cat_3"));
        categoryList.add(new CategoryDomain("Burger", "Cat_2"));
        categoryList.add(new CategoryDomain("Pizza", "Cat_1"));
        categoryList.add(new CategoryDomain("Donut","Cat_5"));
        categoryList.add(new CategoryDomain("Boisson", "Cat_4"));


        CategoryAdapter adapter = new CategoryAdapter(categoryList);
        recyclerViewCategoryList.setAdapter(adapter);
    }
}