package mifta.code.dispendukproject1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import mifta.code.dispendukproject1.R;
import mifta.code.dispendukproject1.api.tampil;

public class KkDesaAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final Context context;
    private final List<tampil> results;

    public KkDesaAdapter(Context context, List<tampil> results) {
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
        KkDesaAdapter.MyHolder holder = new KkDesaAdapter.MyHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        KkDesaAdapter.MyHolder myHolder = (KkDesaAdapter.MyHolder) holder;
        tampil result = results.get(position);
        myHolder.nama_kec.setText("DESA " + result.getNAMA_KEL());
        myHolder.total_kec.setText(result.getJUMLAH());
        myHolder.jenis.setText("Kartu Keluarga");
        Glide.with(myHolder.itemView.getContext())
                .load(R.drawable.ic_kk)
                .placeholder(R.drawable.ic_loading)
                .error(R.drawable.ic_loading)
                .into(myHolder.ic);
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {
        TextView nama_kec, total_kec, jenis;
        ImageView ic;

        public MyHolder(View itemView) {
            super(itemView);
            nama_kec = itemView.findViewById(R.id.tvx_kec);
            total_kec = itemView.findViewById(R.id.tvx_totalKec);
            jenis = itemView.findViewById(R.id.tvx_jenis);
            ic = itemView.findViewById(R.id.imx_icpict);
        }
    }

}