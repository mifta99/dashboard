package mifta.code.dispendukproject1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import mifta.code.dispendukproject1.R;
import mifta.code.dispendukproject1.api.tampil;

public class BiodataDetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final Context context;
    private final List<tampil> results;

    public BiodataDetailAdapter(Context context, List<tampil> results) {
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
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.detail_layout, null);
        BiodataDetailAdapter.MyHolder holder = new BiodataDetailAdapter.MyHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        BiodataDetailAdapter.MyHolder myHolder = (BiodataDetailAdapter.MyHolder) holder;
        tampil result = results.get(position);
        myHolder.user.setText(result.getREQ_BY());
        myHolder.nik.setText(result.getNIK());
        myHolder.no_kk.setText(result.getNO_KK());
        myHolder.nama.setText(result.getNAMA_LGKP());
        myHolder.tgl.setText(result.getTGL_LHR());
        myHolder.alamat.setText(result.getALAMAT());

    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {
        TextView user, nik, no_kk, nama, tgl, alamat;

        public MyHolder(View itemView) {
            super(itemView);
            user = itemView.findViewById(R.id.tvx_user);
            nik = itemView.findViewById(R.id.tvx_nik);
            no_kk = itemView.findViewById(R.id.tvx_no_kk);
            nama = itemView.findViewById(R.id.tvx_nama);
            tgl = itemView.findViewById(R.id.tvx_tgl);
            alamat = itemView.findViewById(R.id.tvx_alamat);
        }
    }

}
