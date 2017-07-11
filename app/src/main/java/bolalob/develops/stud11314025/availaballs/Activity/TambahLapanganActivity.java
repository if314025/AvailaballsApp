package bolalob.develops.stud11314025.availaballs.Activity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import bolalob.develops.stud11314025.availaballs.R;

public class TambahLapanganActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_lapangan);

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

    public void nextStep(View view){
        Intent intent = new Intent(TambahLapanganActivity.this, TambahLapanganStepDuaActivity.class);
        startActivity(intent);
    }


}
