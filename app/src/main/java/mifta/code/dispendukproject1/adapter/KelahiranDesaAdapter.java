package mifta.code.dispendukproject1.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import mifta.code.dispendukproject1.R;
import mifta.code.dispendukproject1.activity.KelahiranDetailActivity;
import mifta.code.dispendukproject1.activity.KkDetailActivity;
import mifta.code.dispendukproject1.api.tampil;

public class KelahiranDesaAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final Context context;
    private final List<tampil> results;

    public KelahiranDesaAdapter(Context context, List<tampil> results) {
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
        KelahiranDesaAdapter.MyHolder holder = new KelahiranDesaAdapter.MyHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        KelahiranDesaAdapter.MyHolder myHolder = (KelahiranDesaAdapter.MyHolder) holder;
        tampil result = results.get(position);
        myHolder.nama_kec.setText("DESA " + result.getNAMA_KEL());
        myHolder.total_kec.setText(result.getJUMLAH());
        myHolder.jenis.setText("Akta Kelahiran");
        Glide.with(myHolder.itemView.getContext())
                .load(R.drawable.ic_kelahiran)
                .placeholder(R.drawable.ic_loading)
                .error(R.drawable.ic_loading)
                .into(myHolder.ic);
        if (Integer.valueOf(result.getJUMLAH()) != 0){
            myHolder.crd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(view.getContext(), KelahiranDetailActivity.class);
                    Integer no_kel = Integer.valueOf(result.getNO_KEL());
                    String nama_kel = String.valueOf(result.getNAMA_KEL());
                    String tot_kel = String.valueOf(result.getJUMLAH());
                    intent.putExtra("no_kel", no_kel);
                    intent.putExtra("nama_kel", nama_kel);
                    intent.putExtra("tot_kel", tot_kel);
                    context.startActivity(intent);
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