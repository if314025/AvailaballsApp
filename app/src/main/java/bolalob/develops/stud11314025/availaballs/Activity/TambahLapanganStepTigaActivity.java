package bolalob.develops.stud11314025.availaballs.Activity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import bolalob.develops.stud11314025.availaballs.R;

public class TambahLapanganStepTigaActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private RadioGroup radioGroupHari;
    private RadioButton radioButtonNb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_lapangan_step_tiga);

        radioGroupHari = (RadioGroup) findViewById(R.id.radioGroupHari);


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

        Spinner spinnerJamBuka = (Spinner) findViewById(R.id.spinnerJamBuka);
        Spinner spinnerJamTutup = (Spinner) findViewById(R.id.spinnerJamTutup);

        spinnerJamBuka.setOnItemSelectedListener(this);
        spinnerJamTutup.setOnItemSelectedListener(this);

        List<String> categories = new ArrayList<String>();
        categories.add("08:00");
        categories.add("00:00");
        categories.add("01:00");
        categories.add("02:00");
        categories.add("03:00");
        categories.add("04:00");
        categories.add("05:00");
        categories.add("06:00");
        categories.add("07:00");
        categories.add("09:00");
        categories.add("10:00");
        categories.add("11:00");
        categories.add("12:00");
        categories.add("13:00");
        categories.add("14:00");
        categories.add("15:00");
        categories.add("16:00");
        categories.add("17:00");
        categories.add("18:00");
        categories.add("19:00");
        categories.add("20:00");
        categories.add("21:00");
        categories.add("22:00");
        categories.add("23:00");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerJamBuka.setAdapter(dataAdapter);
        spinnerJamTutup.setAdapter(dataAdapter);
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
}
