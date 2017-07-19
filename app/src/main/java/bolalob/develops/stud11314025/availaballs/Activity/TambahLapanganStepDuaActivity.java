package bolalob.develops.stud11314025.availaballs.Activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import bolalob.develops.stud11314025.availaballs.R;
import bolalob.develops.stud11314025.availaballs.Widget.CustomFontTextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TambahLapanganStepDuaActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @BindView(R.id.eTLokasi)
    EditText etLokasi;
    @BindView(R.id.eTTelepon)
    EditText etTelepon;
    @BindView(R.id.iconTeleponAdd)
    CustomFontTextView addTlp;
    Context context;
    @BindView(R.id.lytlp)
    LinearLayout ly;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah__lapangan__step__dua);
        ButterKnife.bind(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final View lllokasi = findViewById(R.id.layoutLokasi);
        final View lltelepon = findViewById(R.id.layoutTelepon);

        TextWatcher lokasiWatcher = new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                lllokasi.setAlpha(0.5f);
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int length = etLokasi.getText().length();
                if( length == 0){
                    lllokasi.setAlpha(0.5f);
                }
                else lllokasi.setAlpha(1.0f);
            }

            public void afterTextChanged(Editable s) {
                int length = etLokasi.getText().length();
                if( length == 0){
                    lllokasi.setAlpha(0.5f);
                }
                else lllokasi.setAlpha(1.0f);
            }
        };
        etLokasi.addTextChangedListener(lokasiWatcher);

        TextWatcher teleponWatcher = new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                lltelepon.setAlpha(0.5f);
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int length = etTelepon.getText().length();
                if( length == 0){
                    lltelepon.setAlpha(0.5f);
                }
                else lltelepon.setAlpha(1.0f);
            }

            public void afterTextChanged(Editable s) {
                int length = etTelepon.getText().length();
                if( length == 0){
                    lltelepon.setAlpha(0.5f);
                }
                else lltelepon.setAlpha(1.0f);
            }
        };
        etTelepon.addTextChangedListener(teleponWatcher);

        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setDisplayShowHomeEnabled(false);
        mActionBar.setDisplayShowTitleEnabled(false);
        LayoutInflater mInflater = LayoutInflater.from(this);

        View mCustomView = mInflater.inflate(R.layout.custom_actionbar, null);
        TextView mTitleTextView = (TextView) mCustomView.findViewById(R.id.title_text);
        mTitleTextView.setText("Daftarkan Lapangan");

        mActionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.clrNavigation)));
        mActionBar.setCustomView(mCustomView);
        mActionBar.setDisplayShowCustomEnabled(true);

        Spinner spinner = (Spinner) findViewById(R.id.spinnerJumlahLapangan);

        spinner.setOnItemSelectedListener(this);

        List<String> categories = new ArrayList<String>();
        categories.add("1");
        categories.add("2");
        categories.add("3");
        categories.add("4");
        categories.add("5");
        categories.add("6");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void nextStep(View view) {
        Intent intent = new Intent(TambahLapanganStepDuaActivity.this, TambahLapanganStepTigaActivity.class);
        startActivity(intent);
    }

    public void openMap(View view) {
        Intent intentMap = new Intent(TambahLapanganStepDuaActivity.this, MapsCurrentPlaceActivity.class);
        startActivity(intentMap);
    }

    @OnClick(R.id.iconTeleponAdd)
    void addTelepon(){
        LinearLayout ly = (LinearLayout) findViewById(R.id.lytlp);

        View tv = LayoutInflater.from(this).inflate(R.layout.listedittext_telepon, null);

        int count = ly.getChildCount();

        if (count < 5){
            ly.addView(tv);
        }
        else {
            Toast.makeText(ly.getContext(), "Hanya dapat menambahkan 5 nomor telepon." , Toast.LENGTH_LONG).show();
        }
    }

}
