package bolalob.develops.stud11314025.availaballs;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Okta on 19/06/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private ArrayList<Lapangan>lapangans;

    public RecyclerViewAdapter(ArrayList<Lapangan> inputdata){
        lapangans = inputdata;
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        public  TextView tvNo;
        public TextView tvNamaLapangan;
        public TextView tvLokasi;

        public ViewHolder(View v){
            super(v);
            tvNo = (TextView)v.findViewById(R.id.tvNo);
            tvNamaLapangan = (TextView)v.findViewById(R.id.tvNamaLapangan);
            tvLokasi = (TextView) v.findViewById(R.id.tvLokasi);
        }

    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // membuat view baru
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listlapangan_item, parent, false);
        // mengeset ukuran view, margin, padding, dan parameter layout lainnya
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.ViewHolder holder, int position) {
        Lapangan lap;
        final String name = lapangans.get(position).getNo().toString();
        holder.tvNo.setText(lapangans.get(position).getNo().toString());
        holder.tvNamaLapangan.setText(lapangans.get(position).getNamaLapangan().toString());
        holder.tvLokasi.setText(lapangans.get(position).getLokasi().toString());
        //holder.tvNamaLapangan.setText(lapangans.get(position).toString());
        //holder.tvLokasi.setText(lapangans.get(position).toString());
    }




    @Override
    public int getItemCount() {
        return lapangans.size();
    }
}
