package mifta.code.dispendukproject1.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
import mifta.code.dispendukproject1.activity.KkDesaActivity;
import mifta.code.dispendukproject1.api.tampil;

public class KkAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final Context context;
    private final List<tampil> results;

    public KkAdapter(Context context, List<tampil> results) {
        this.context = context;
        this.results = results;
        setHasStableIds(true);
    }

    @Override
    public long getItemId(int position) {
        return results.get(position).getNO_KEC();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_layout, null);
        MyHolder holder = new MyHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyHolder myHolder = (MyHolder) holder;
        tampil result = results.get(position);
        myHolder.nama_kec.setText("KECAMATAN " + result.getNAMA_KEC());
        myHolder.total_kec.setText(result.getJUMLAH());
        myHolder.jenis.setText("Kartu Keluarga");
        Glide.with(myHolder.itemView.getContext())
                .load(R.drawable.ic_kk)
                .placeholder(R.drawable.ic_loading)
                .error(R.drawable.ic_loading)
                .into(myHolder.ic);
        myHolder.crd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = view.getContext().getSharedPreferences("myproject", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("no_kec", result.getNO_KEC());
                editor.commit();
                Intent intent = new Intent(view.getContext(), KkDesaActivity.class);
                Integer no_kec = Integer.valueOf(result.getNO_KEC());
                String nama_kec = String.valueOf(result.getNAMA_KEC());
                String tot_kec = String.valueOf(result.getJUMLAH());
                intent.putExtra("no_kec", no_kec);
                intent.putExtra("nama_kec", nama_kec);
                intent.putExtra("tot_kec", tot_kec);
                context.startActivity(intent);
            }
        });
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
