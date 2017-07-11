package bolalob.develops.stud11314025.availaballs.Activity;

import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import bolalob.develops.stud11314025.availaballs.Adapter.RecyclerViewAdapter;
import bolalob.develops.stud11314025.availaballs.R;
import bolalob.develops.stud11314025.availaballs.Model.Lapangan;
import bolalob.develops.stud11314025.availaballs.Service.API;
import bolalob.develops.stud11314025.availaballs.Service.Service;
import bolalob.develops.stud11314025.availaballs.Widget.CustomFontTextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerViewAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    //    private ArrayList<Lapangan> dataSet;
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
    @Bind(R.id.TextNo)
    TextView LabelNo;
    @Bind(R.id.TvNamaLapangan)
    TextView LabelNamaLap;
    @Bind(R.id.customFontTextView)
    CustomFontTextView LabelLokasi;
    @Bind(R.id.navigation)
    BottomNavigationView test;
    @Bind(R.id.progressBar)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setDisplayShowHomeEnabled(false);
        mActionBar.setDisplayShowTitleEnabled(false);
        LayoutInflater mInflater = LayoutInflater.from(this);

        View mCustomView = mInflater.inflate(R.layout.custom_actionbar, null);
        TextView mTitleTextView = (TextView) mCustomView.findViewById(R.id.title_text);
        mTitleTextView.setText("List Lapangan");

        mActionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.clrNavigation)));
        mActionBar.setCustomView(mCustomView);
        mActionBar.setDisplayShowCustomEnabled(true);

        progressBar.setVisibility(View.VISIBLE);
//        dataSet = new ArrayList<>();
//        initDataset();

        API client = Service.createService(API.class);
        Call<List<Lapangan>> call = client.getAllLapangan();
        call.enqueue(new Callback<List<Lapangan>>() {
            @Override
            public void onResponse(Call<List<Lapangan>> call, Response<List<Lapangan>> response) {
                progressBar.setVisibility(View.GONE);
                List<Lapangan> repos = response.body();

//                String NamaLapngan = repos.get(0).getFieldName();
//                String Location = repos.get(1).getLocation();
//                String Photo =repos.get(2).getLocation();
//                String PhoneNum = repos.get(3).getPhoneNumber();
//                Integer JumlahLpngn = repos.get(4).getNumberOfField();
//                String OpeningHour = repos.get(5).getOpeningHours();
//                String ClosingHour =repos.get(6).getClosingHours();
//                String Harga = repos.get(7).getPrice();
//
//                Toast.makeText(getApplicationContext(),repos.get(0).getFieldName(),Toast.LENGTH_LONG).show();
                adapter = new RecyclerViewAdapter(MainActivity.this,repos);
                layoutManager = new LinearLayoutManager(MainActivity.this);
                rvView.setLayoutManager(layoutManager);
                rvView.setAdapter(adapter);
                if (repos.isEmpty()) {
                    rvView.setVisibility(View.GONE);
                    imageView.setVisibility(View.VISIBLE);
                    emptyview.setVisibility(View.VISIBLE);
                    btn1.setVisibility(View.GONE);
                    btn2.setVisibility(View.GONE);
                    btn3.setVisibility(View.GONE);
                    btn4.setVisibility(View.GONE);
                    btn5.setVisibility(View.GONE);
                    LabelLokasi.setVisibility(View.GONE);
                    LabelNo.setVisibility(View.GONE);
                    LabelNamaLap.setVisibility(View.GONE);
                } else {
                    imageView.setVisibility(View.GONE);
                    rvView.setVisibility(View.VISIBLE);
                    emptyview.setVisibility(View.GONE);
                    btn1.setVisibility(View.VISIBLE);
                    btn2.setVisibility(View.VISIBLE);
                    btn3.setVisibility(View.VISIBLE);
                    btn4.setVisibility(View.VISIBLE);
                    btn5.setVisibility(View.VISIBLE);
                    LabelLokasi.setVisibility(View.VISIBLE);
                    LabelNo.setVisibility(View.VISIBLE);
                    LabelNamaLap.setVisibility(View.VISIBLE);
                }


            }

            @Override
            public void onFailure(Call<List<Lapangan>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });


        /**
         * Kita menggunakan LinearLayoutManager untuk list standar
         * yang hanya berisi daftar item
         * disusun dari atas ke bawah
         */


//      adapter = new RecyclerViewAdapter(dataSet);
//        rvView.setAdapter(adapter);
//
//        if (dataSet.isEmpty()) {
//            rvView.setVisibility(View.GONE);
//            imageView.setVisibility(View.VISIBLE);
//            emptyview.setVisibility(View.VISIBLE);
//            btn1.setVisibility(View.GONE);
//            btn2.setVisibility(View.GONE);
//            btn3.setVisibility(View.GONE);
//            btn4.setVisibility(View.GONE);
//            btn5.setVisibility(View.GONE);
//
//        } else {
//            imageView.setVisibility(View.GONE);
//            rvView.setVisibility(View.VISIBLE);
//            emptyview.setVisibility(View.GONE);
//        }

    }

//    private void initDataset() {
//
//
//        for (int i = 1; i < 21; i++) {
//            dataSet.add(new Lapangan(i, "Futsal Bolalob"+i, "Wisma77Tower"+i,i,i,"jam"+i,"jam"+i,"jam"+i,new Account(i)));
//        }
//
//    }

    private RecyclerView.OnScrollListener recyclerViewOnScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
        }

    };
}