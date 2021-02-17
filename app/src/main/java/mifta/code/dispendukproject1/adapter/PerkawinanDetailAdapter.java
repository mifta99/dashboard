package mifta.code.dispendukproject1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import mifta.code.dispendukproject1.R;
import mifta.code.dispendukproject1.api.tampil;

public class PerkawinanDetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final Context context;
    private final List<tampil> results;

    public PerkawinanDetailAdapter(Context context, List<tampil> results) {
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
        PerkawinanDetailAdapter.MyHolder holder = new PerkawinanDetailAdapter.MyHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        PerkawinanDetailAdapter.MyHolder myHolder = (PerkawinanDetailAdapter.MyHolder) holder;
        tampil result = results.get(position);
        myHolder.user.setText(result.getREQ_BY());
        myHolder.niks.setText(result.getNIK_SUAMI());
        myHolder.nms.setText(result.getNAMA_SUAMI());
        myHolder.niki.setText(result.getNIK_ISTRI());
        myHolder.tgl.setText(result.getTGL_KAWIN());
        myHolder.nmi.setText(result.getNAMA_ISTRI());
        myHolder.no_doc.setText(result.getNO_DOC());

    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {
        TextView user, niks, nms, niki, tgl, nmi, no_doc;
        LinearLayout ly_doc, ly_nik, ly_kk, ly_nama, ly_tgl, ly_alamat, ly_niks, ly_niki, ly_nms, ly_nmi, ly_kawin, ly_cerai;

        public MyHolder(View itemView) {
            super(itemView);
            user = itemView.findViewById(R.id.tvx_user);
            niks = itemView.findViewById(R.id.tvx_nik_suami);
            nms = itemView.findViewById(R.id.tvx_nama_suami);
            niki = itemView.findViewById(R.id.tvx_nik_istri);
            tgl = itemView.findViewById(R.id.tvx_tgl_kawin);
            nmi = itemView.findViewById(R.id.tvx_nama_istri);
            no_doc = itemView.findViewById(R.id.tvx_no_doc);

            ly_doc = itemView.findViewById(R.id.ly_no_doc);
            ly_nik = itemView.findViewById(R.id.ly_nik);
            ly_kk = itemView.findViewById(R.id.ly_no_kk);
            ly_nama = itemView.findViewById(R.id.ly_nama);
            ly_tgl = itemView.findViewById(R.id.ly_tgl);
            ly_alamat = itemView.findViewById(R.id.ly_alamat);
            ly_niks = itemView.findViewById(R.id.ly_nik_suami);
            ly_nms = itemView.findViewById(R.id.ly_nama_suami);
            ly_niki = itemView.findViewById(R.id.ly_nik_istri);
            ly_nmi = itemView.findViewById(R.id.ly_nama_istri);
            ly_kawin = itemView.findViewById(R.id.ly_tgl_kawin);

            ly_doc.setVisibility(View.VISIBLE);
            ly_nik.setVisibility(View.GONE);
            ly_kk.setVisibility(View.GONE);
            ly_nama.setVisibility(View.GONE);
            ly_tgl.setVisibility(View.GONE);
            ly_alamat.setVisibility(View.GONE);
            ly_niks.setVisibility(View.VISIBLE);
            ly_nms.setVisibility(View.VISIBLE);
            ly_niki.setVisibility(View.VISIBLE);
            ly_nmi.setVisibility(View.VISIBLE);
            ly_kawin.setVisibility(View.VISIBLE);

        }
    }

}
