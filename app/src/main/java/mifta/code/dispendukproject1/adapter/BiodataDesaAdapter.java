package mifta.code.dispendukproject1.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import mifta.code.dispendukproject1.R;
import mifta.code.dispendukproject1.activity.BiodataDesaActivity;
import mifta.code.dispendukproject1.activity.BiodataDetailActivity;
import mifta.code.dispendukproject1.api.tampil;

public class BiodataDesaAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final Context context;
    private final List<tampil> results;

    public BiodataDesaAdapter(Context context, List<tampil> results) {
        this.context = context;
        this.results = results;
        setHasStableIds(true);
    }

    @Override
    public long getItemId(int position) {
        return results.get(position).getNO_KEL();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_layout, null);
        BiodataDesaAdapter.MyHolder holder = new BiodataDesaAdapter.MyHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        BiodataDesaAdapter.MyHolder myHolder = (BiodataDesaAdapter.MyHolder) holder;
        tampil result = results.get(position);
        myHolder.nama_kec.setText("DESA " + result.getNAMA_KEL());
        myHolder.total_kec.setText(result.getJUMLAH());
        myHolder.jenis.setText("Biodata");
        Glide.with(myHolder.itemView.getContext())
                .load(R.drawable.ic_biodata)
                .placeholder(R.drawable.ic_loading)
                .error(R.drawable.ic_loading)
                .into(myHolder.ic);
        if (Integer.valueOf(result.getJUMLAH()) != 0){
            myHolder.crd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(view.getContext(), BiodataDetailActivity.class);
                    Integer no_kel = Integer.valueOf(result.getNO_KEL());
                    String nama_kel = String.valueOf(result.getNAMA_KEL());
                    String tot_kel = String.valueOf(result.getJUMLAH());
                    intent.putExtra("no_kel", no_kel);
                    intent.putExtra("nama_kel", nama_kel);
                    intent.putExtra("tot_kel", tot_kel);
                    context.startActivity(intent);
                }
            });
        }else {
            myHolder.crd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(), "DATA TIDAK ADA!", Toast.LENGTH_SHORT).show();
                }
            });

        }
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {
        TextView nama_kec, total_kec, jenis;
        ImageView ic;
        CardView crd;

        public MyHolder(View itemView) {
            super(itemView);
            nama_kec = itemView.findViewById(R.id.tvx_kec);
            total_kec = itemView.findViewById(R.id.tvx_totalKec);
            jenis = itemView.findViewById(R.id.tvx_jenis);
            ic = itemView.findViewById(R.id.imx_icpict);
            crd = itemView.findViewById(R.id.crd);
        }
    }

}