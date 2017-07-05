package bolalob.develops.stud11314025.availaballs.Activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import bolalob.develops.stud11314025.availaballs.Application.LapanganApplication;
import bolalob.develops.stud11314025.availaballs.Base.LapanganPresenter;
import bolalob.develops.stud11314025.availaballs.Model.LapanganAdapter;
import bolalob.develops.stud11314025.availaballs.Model.LapanganResponse;
import bolalob.develops.stud11314025.availaballs.R;
import bolalob.develops.stud11314025.availaballs.Service.LapanganService;
import bolalob.develops.stud11314025.availaballs.Service.LapanganViewInterface;
import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Observable;

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
    LapanganService mService;

    private LapanganPresenter mPresenter;

    @Bind(R.id.recyclerView)
    RecyclerView mRecyclerView;
    private LapanganAdapter mAdapter;

    private ProgressDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_test);

        resolveDependency();

        ButterKnife.bind(MainActivity.this);
        configViews();
        mPresenter = new LapanganPresenter(MainActivity.this);
        mPresenter.onCreate();
    }

    private void resolveDependency() {
        ((LapanganApplication) getApplication())
                .getApiComponent()
                .inject(MainActivity.this);
    }

    private void configViews() {
        mRecyclerView.setRecycledViewPool(new RecyclerView.RecycledViewPool());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new LapanganAdapter(getLayoutInflater());
        mRecyclerView.setAdapter(mAdapter);

    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.onResume();
        mPresenter.fetchLapangan();
        mDialog = new ProgressDialog(MainActivity.this);
        mDialog.setIndeterminate(true);
        mDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mDialog.setTitle("Downloading Data");
        mDialog.setMessage("Please wait...");
        mDialog.show();
    }

    @Override
    public void completed() {
        mDialog.dismiss();
    }

    @Override
    public void onError(String message) {
        mDialog.dismiss();
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLapangan(List<LapanganResponse> lapanganResponseList) {
        mAdapter.addLapangan(lapanganResponseList);
    }

    @Override
    public Observable<List<LapanganResponse>> getLapangan() {
        return mService.getLapangan();
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