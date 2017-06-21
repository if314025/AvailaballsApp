package bolalob.develops.stud11314025.availaballs.Activity;

import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import bolalob.develops.stud11314025.availaballs.CustomView.RecyclerViewAdapter;
import bolalob.develops.stud11314025.availaballs.R;
import bolalob.develops.stud11314025.availaballs.model.Lapangan;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Lapangan> dataSet;
    private TextView emptyview;
    private ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar mActionBar =getSupportActionBar();
        mActionBar.setDisplayShowHomeEnabled(false);
        mActionBar.setDisplayShowTitleEnabled(false);
        LayoutInflater mInflater = LayoutInflater.from(this);
        emptyview =(TextView)findViewById(R.id.emptyText);
        imageView = (ImageView)findViewById(R.id.imageView);


        View mCustomView = mInflater.inflate(R.layout.custom_actionbar, null);
        TextView mTitleTextView = (TextView) mCustomView.findViewById(R.id.title_text);
        mTitleTextView.setText("List Lapangan");


        mActionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.clrNavigation)));
        mActionBar.setCustomView(mCustomView);
        mActionBar.setDisplayShowCustomEnabled(true);
        dataSet = new ArrayList<>();
        initDataset();

        rvView = (RecyclerView) findViewById(R.id.rv_main);
        rvView.setHasFixedSize(true);

        /**
         * Kita menggunakan LinearLayoutManager untuk list standar
         * yang hanya berisi daftar item
         * disusun dari atas ke bawah
         */
        layoutManager = new LinearLayoutManager(this);
        rvView.setLayoutManager(layoutManager);

        adapter = new RecyclerViewAdapter(dataSet);
        rvView.setAdapter(adapter);

        if (dataSet.isEmpty()){
            rvView.setVisibility(View.GONE);
            imageView.setVisibility(View.VISIBLE);
            emptyview.setVisibility(View.VISIBLE);

        }else{
            imageView.setVisibility(View.GONE);
            rvView.setVisibility(View.VISIBLE);
            emptyview.setVisibility(View.GONE);
        }



    }
    private void initDataset(){

        for (int i=1;i<21;i++){
            dataSet.add(new Lapangan(i,"Futsal Bolalob","Wisma77Tower2"));
        }


    }
}