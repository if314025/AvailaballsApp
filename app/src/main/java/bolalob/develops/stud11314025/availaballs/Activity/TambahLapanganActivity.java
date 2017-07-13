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
import android.widget.EditText;
import android.widget.TextView;

import bolalob.develops.stud11314025.availaballs.R;
import butterknife.Bind;

public class TambahLapanganActivity extends AppCompatActivity {

    @Bind(R.id.eTNamaLapangan)
    EditText etNamaLapangan;
    @Bind(R.id.eTTipeLapangan)
    EditText etNamaTipeLapangan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_lapangan);

        final View llnamalapangan= findViewById(R.id.layoutNamaLapangan);
        final View lltipelapangan= findViewById(R.id.layoutTipeLapangan);

        TextWatcher namaLapanganWatcher = new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                llnamalapangan.setAlpha(0.5f);
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                llnamalapangan.setAlpha(1.0f);
            }

            public void afterTextChanged(Editable s) {
                llnamalapangan.setAlpha(1.0f);
            }
        };
        etNamaLapangan.addTextChangedListener(namaLapanganWatcher);

        TextWatcher tipeLapanganWatcher = new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                lltipelapangan.setAlpha(0.5f);
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                lltipelapangan.setAlpha(1.0f);
            }

            public void afterTextChanged(Editable s) {
                lltipelapangan.setAlpha(1.0f);
            }
        };
        etNamaTipeLapangan.addTextChangedListener(tipeLapanganWatcher);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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

    }

    public void nextStep(View view) {
        Intent intent = new Intent(TambahLapanganActivity.this, TambahLapanganStepDuaActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }


}
