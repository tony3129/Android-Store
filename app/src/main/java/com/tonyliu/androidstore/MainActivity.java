package com.tonyliu.androidstore;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        //use layout designed in activity_main.xml
        setContentView(R.layout.activity_main);

        RecyclerView rvProducts = findViewById(R.id.rvProducts);
        //create arraylist to hold product data
        ArrayList<Product> productArrayList = new ArrayList<>();
        //example items to populate recyclerView
        productArrayList.add(new Product(
                R.drawable.ic_launcher_background,
                "Shoes",
                "Shoes for Running",
                "$59.99"
        ));
        productArrayList.add(new Product(
                R.drawable.ic_launcher_background,
                "Shirt",
                "Kirkland Branded",
                "$19.99"
        ));
        productArrayList.add(new Product(
                R.drawable.ic_launcher_background,
                "Glasses",
                "To help you see",
                "$99.99"
        ));
        productArrayList.add(new Product(
                R.drawable.ic_launcher_background,
                "Sweater",
                "Will keep you warm",
                "$59.99"
        ));
        productArrayList.add(new Product(
                R.drawable.ic_launcher_background,
                "Socks",
                "Comfy socks",
                "$10.99"
        ));
        // to fill out rest of prodcts for recyclerView
        for (int i = 6; i < 40; i++){
            productArrayList.add(new Product(
                    R.drawable.ic_launcher_background,
                    "Generic Product" + i,
                    "Description",
                    "$0.00"
            ));
        }
        //adapter to pass product data to recyclerView
        ProductAdapter productAdapter = new ProductAdapter(this, productArrayList);
        rvProducts.setAdapter(productAdapter);
        //to arrange items in vertical list
        rvProducts.setLayoutManager(new LinearLayoutManager(this));

        productAdapter.setOnItemClickListener(product -> {
            Intent intent = new Intent(MainActivity.this, ProductDetails.class);
            //pass product details to ProductDetails
            intent.putExtra("productName", product.getProdName());
            intent.putExtra("productDesc", product.getProdDesc());
            intent.putExtra("productPrice", product.getProdPrice());
            intent.putExtra("productImage", product.getImgID());

            startActivity(intent);
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}