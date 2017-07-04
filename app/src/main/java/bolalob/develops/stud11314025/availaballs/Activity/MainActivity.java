package bolalob.develops.stud11314025.availaballs.Activity;

import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import bolalob.develops.stud11314025.availaballs.CustomView.RecyclerViewAdapter;
import bolalob.develops.stud11314025.availaballs.R;
import bolalob.develops.stud11314025.availaballs.Model.Lapangan;
import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Lapangan> dataSet;
    @Bind(R.id.rv_main)
     RecyclerView rvView;
    @Bind(R.id.emptyText)
     TextView emptyview;
    @Bind(R.id.imageView)
     ImageView imageView;
    @Bind(R.id.button1)
     Button btn1;
    @Bind(R.id.button2)
     Button btn2;
    @Bind(R.id.button3)
     Button btn3;
    @Bind(R.id.button4)
     Button btn4;
    @Bind(R.id.button5)
     Button btn5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ActionBar mActionBar =getSupportActionBar();
        mActionBar.setDisplayShowHomeEnabled(false);
        mActionBar.setDisplayShowTitleEnabled(false);
        LayoutInflater mInflater = LayoutInflater.from(this);


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
            btn1.setVisibility(View.GONE);
            btn2.setVisibility(View.GONE);
            btn3.setVisibility(View.GONE);
            btn4.setVisibility(View.GONE);
            btn5.setVisibility(View.GONE);

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
    private RecyclerView.OnScrollListener recyclerViewOnScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
        }

    };
}