package bolalob.develops.stud11314025.availaballs.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

import javax.inject.Inject;

import bolalob.develops.stud11314025.availaballs.Application.LapanganApplication;
import bolalob.develops.stud11314025.availaballs.Base.LapanganPresenter;
import bolalob.develops.stud11314025.availaballs.Model.LapanganResponse;
import bolalob.develops.stud11314025.availaballs.R;
import bolalob.develops.stud11314025.availaballs.Service.LapanganService;
import bolalob.develops.stud11314025.availaballs.Service.LapanganViewInterface;

public class MainActivity extends AppCompatActivity implements LapanganViewInterface {
    //    private RecyclerView.Adapter adapter;
//    private RecyclerView.LayoutManager layoutManager;
//    private ArrayList<Lapangan> dataSet;
//    @Bind(R.id.rv_main)
//     RecyclerView rvView;
//    @Bind(R.id.emptyText)
//     TextView emptyview;
//    @Bind(R.id.imageView)
//     ImageView imageView;
//    @Bind(R.id.button1)
//     Button btn1;
//    @Bind(R.id.button2)
//     Button btn2;
//    @Bind(R.id.button3)
//     Button btn3;
//    @Bind(R.id.button4)
//     Button btn4;
//    @Bind(R.id.button5)
//     Button btn5;
    @Inject
    LapanganService service;

    private LapanganPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((LapanganApplication) getApplication())
                .getApiComponent()
                .inject(MainActivity.this);

        mPresenter = new LapanganPresenter(MainActivity.this);
        mPresenter.onCreate();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.onResume();
        mPresenter.fetchLapangan();
    }

    @Override
    public void completed() {

    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void onLapangan(List<LapanganResponse> lapanganResponseList) {

    }
//        ButterKnife.bind(this);
//        ActionBar mActionBar =getSupportActionBar();
//        mActionBar.setDisplayShowHomeEnabled(false);
//        mActionBar.setDisplayShowTitleEnabled(false);
//        LayoutInflater mInflater = LayoutInflater.from(this);

//        View mCustomView = mInflater.inflate(R.layout.custom_actionbar, null);
//        TextView mTitleTextView = (TextView) mCustomView.findViewById(R.id.title_text);
//        mTitleTextView.setText("List Lapangan");
//
//        mActionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.clrNavigation)));
//        mActionBar.setCustomView(mCustomView);
//        mActionBar.setDisplayShowCustomEnabled(true);
//        dataSet = new ArrayList<>();
//        initDataset();
//
//        rvView = (RecyclerView) findViewById(R.id.rv_main);
//        rvView.setHasFixedSize(true);

        /**
         * Kita menggunakan LinearLayoutManager untuk list standar
         * yang hanya berisi daftar item
         * disusun dari atas ke bawah
         */
//        layoutManager = new LinearLayoutManager(this);
//        rvView.setLayoutManager(layoutManager);
//
//        adapter = new RecyclerViewAdapter(dataSet);
//        rvView.setAdapter(adapter);
//
//        if (dataSet.isEmpty()){
//            rvView.setVisibility(View.GONE);
//            imageView.setVisibility(View.VISIBLE);
//            emptyview.setVisibility(View.VISIBLE);
//            btn1.setVisibility(View.GONE);
//            btn2.setVisibility(View.GONE);
//            btn3.setVisibility(View.GONE);
//            btn4.setVisibility(View.GONE);
//            btn5.setVisibility(View.GONE);
//
//        }else{
//            imageView.setVisibility(View.GONE);
//            rvView.setVisibility(View.VISIBLE);
//            emptyview.setVisibility(View.GONE);
//        }
//
//    }
//    private void initDataset(){
//
//        for (int i=1;i<21;i++){
//            dataSet.add(new Lapangan(i,"Futsal Bolalob","Wisma77Tower2"));
//        }
//
//    }
//    private RecyclerView.OnScrollListener recyclerViewOnScrollListener = new RecyclerView.OnScrollListener() {
//        @Override
//        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
//            super.onScrollStateChanged(recyclerView, newState);
//        }
//
//    };
}