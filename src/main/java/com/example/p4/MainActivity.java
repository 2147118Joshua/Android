package com.example.p4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.p4.Adapter.BestSellerAdapter;
import com.example.p4.Adapter.ClothingAdapter;
import com.example.p4.Adapter.OfferAdapter;
import com.example.p4.Model.BestSeller;
import com.example.p4.Model.Clothing;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView offerRecyclerView , bestSellerRecyclerView , clothingRecyclerView , bestSellerRecyclerView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /// offer RecyclerView
        offerRecyclerView = findViewById(R.id.offerRecyclerView);
        offerRecyclerView.setHasFixedSize(true);
        offerRecyclerView.setLayoutManager(new LinearLayoutManager(this , LinearLayoutManager.HORIZONTAL , false));

        List<Integer> imageList = new ArrayList<>();

        imageList.add(R.drawable.offer_shoping);
        imageList.add(R.drawable.nikon_canon_offer);
        imageList.add(R.drawable.tv_offer);

        OfferAdapter offerAdapter = new OfferAdapter(imageList);

        offerRecyclerView.setAdapter(offerAdapter);

        // best RecyclerView

        bestSellerRecyclerView = findViewById(R.id.bestSellerRecyclerview);
        bestSellerRecyclerView.setHasFixedSize(true);
        bestSellerRecyclerView.setLayoutManager(new LinearLayoutManager(this , LinearLayoutManager.HORIZONTAL , false));

        List<BestSeller> bestSellerList = new ArrayList<>();

        bestSellerList.add(new BestSeller(R.drawable.bags , "Up to 20% off"));
        bestSellerList.add(new BestSeller(R.drawable.mobiles , "Up to 20% off"));
        bestSellerList.add(new BestSeller(R.drawable.watches , "Up to 20% off"));

        BestSellerAdapter bestSellerAdapter = new BestSellerAdapter(bestSellerList);

        bestSellerRecyclerView.setAdapter(bestSellerAdapter);


        // clothing RecyclerView

        clothingRecyclerView = findViewById(R.id.clothingRecyclerview);
        clothingRecyclerView.setHasFixedSize(true);
        clothingRecyclerView.setLayoutManager(new LinearLayoutManager(this , LinearLayoutManager.HORIZONTAL , false));

        List<Clothing> clothingList = new ArrayList<>();

        clothingList.add(new Clothing(R.drawable.levis_clothing , "Up to 30% off"));
        clothingList.add(new Clothing(R.drawable.women_clothing , "Up to 30% off"));
        clothingList.add(new Clothing(R.drawable.nikeshoes , "Up to 30% off"));

        ClothingAdapter clothingAdapter = new ClothingAdapter(clothingList);
        clothingRecyclerView.setAdapter(clothingAdapter);

        // best RecyclerView 2

        bestSellerRecyclerView2 = findViewById(R.id.bestSeller2RecyclerView);
        bestSellerRecyclerView2.setHasFixedSize(true);
        bestSellerRecyclerView2.setLayoutManager(new LinearLayoutManager(this , LinearLayoutManager.HORIZONTAL , false));

        bestSellerRecyclerView2.setAdapter(bestSellerAdapter);
    }

    @Override

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.map_options,menu);
        return  true;
    }

    @Override

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.all:

                Toast.makeText(MainActivity.this,"Going to home page",Toast.LENGTH_SHORT).show();
                 setprofile();


                return true;

            case R.id.apolo:

                Toast.makeText(MainActivity.this,"Thankyou ",Toast.LENGTH_SHORT).show();
                suggestion();

                return true;

            default:

                return super.onOptionsItemSelected(item);
        }
    }

    public void setprofile(){
        Intent intent = new Intent(this, setprofile.class);
        startActivity(intent);
    }

    public void suggestion(){
        Intent intent = new Intent(this, suggestion.class);
        startActivity(intent);
    }

}