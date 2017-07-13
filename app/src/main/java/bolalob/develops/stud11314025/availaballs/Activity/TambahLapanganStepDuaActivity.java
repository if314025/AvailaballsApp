package bolalob.develops.stud11314025.availaballs.Activity;

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
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import bolalob.develops.stud11314025.availaballs.R;
import butterknife.Bind;
import butterknife.ButterKnife;

public class TambahLapanganStepDuaActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Bind(R.id.eTLokasi)
    EditText etLokasi;
    @Bind(R.id.eTTelepon)
    EditText etTelepon;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah__lapangan__step__dua);
        ButterKnife.bind(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final View lllokasi= findViewById(R.id.layoutLokasi);
        final View lltelepon= findViewById(R.id.layoutTelepon);

        TextWatcher lokasiWatcher = new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                lllokasi.setAlpha(0.5f);
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                lllokasi.setAlpha(1.0f);
            }

            public void afterTextChanged(Editable s) {
                lllokasi.setAlpha(1.0f);
            }
        };
        etLokasi.addTextChangedListener(lokasiWatcher);

        TextWatcher teleponWatcher = new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                lltelepon.setAlpha(0.5f);
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                lltelepon.setAlpha(1.0f);
            }

            public void afterTextChanged(Editable s) {
                lltelepon.setAlpha(1.0f);
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
        Intent intentMap = new Intent(TambahLapanganStepDuaActivity.this, MapsActivity.class);
        startActivity(intentMap);
    }
}
