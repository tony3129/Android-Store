package com.tonyliu.androidstore;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ProductDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        //set layout to design within activity_product_details
        setContentView(R.layout.activity_product_details);

        ImageView ivProdImgDetails = findViewById(R.id.ivProdImgDetails);
        TextView tvProdNameDetails = findViewById(R.id.tvProdNameDetails);
        TextView tvProdDescDetails = findViewById(R.id.tvProdDescDetails);
        TextView tvProdPriceDetails = findViewById(R.id.tvProdPriceDetails);
        Button btnAddToCart = findViewById(R.id.btnAddToCart);
        //get products passed from MainActivity
        Bundle productDetails = getIntent().getExtras();
        //set product details retrieved from MainActivity to UI elements
        tvProdNameDetails.setText(productDetails.getString("productName"));
        tvProdDescDetails.setText(productDetails.getString("productDesc"));
        tvProdPriceDetails.setText(productDetails.getString("productPrice"));
        ivProdImgDetails.setImageResource(productDetails.getInt("productImage"));

        //show toast message when added to cart (cart functionality isn't implemented)
        btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ProductDetails.this,tvProdNameDetails.getText().toString() + " Added to Cart", Toast.LENGTH_SHORT).show();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}