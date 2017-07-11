package bolalob.develops.stud11314025.availaballs;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import bolalob.develops.stud11314025.availaballs.Activity.MainActivity;
import bolalob.develops.stud11314025.availaballs.Adapter.RecyclerViewAdapter;
import bolalob.develops.stud11314025.availaballs.Model.Lapangan;
import butterknife.Bind;
import butterknife.ButterKnife;

public class DetailLapanganActivity extends AppCompatActivity {

    @Bind(R.id.TvHarga)
    TextView tvHrg;
    @Bind(R.id.TvNoHp)
    TextView tvNoHp;
    @Bind(R.id.TvAlamat)
    TextView tvAlmt;
    @Bind(R.id.TvJlhLpng)
    TextView tvJmlhLap;
    @Bind(R.id.TvNamaLap)
    TextView tvNmLap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_lapangan);
        ButterKnife.bind(this);
        Intent intent = this.getIntent();
        String namalap = intent.getExtras().getString("NAMALAP_KEY");
        String loklap = intent.getExtras().getString("LOKASI_KEY");
        String phonenum = intent.getExtras().getString("PHONENUM_KEY");
        String jmlhlap = intent.getExtras().getString("JUMLAHLAP_KEY");
        String price = intent.getExtras().getString("PRICE_KEY");
        tvNmLap.setText(namalap);
        tvAlmt.setText(loklap);
        tvNoHp.setText(phonenum);
        tvJmlhLap.setText(jmlhlap);
        tvHrg.setText("Rp." + price);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            // This ID represents the Home or Up button. In the case of this
            // activity, the Up button is shown. For
            // more details, see the Navigation pattern on Android Design:
            //
            // http://developer.android.com/design/patterns/navigation.html#up-vs-back
            //
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                navigateUpTo(new Intent(this, MainActivity.class));
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
