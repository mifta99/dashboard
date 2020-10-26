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

public class SuratPindahAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<tampil> results;

    public SuratPindahAdapter(Context context, List<tampil> results) {
        this.context = context;
        this.results = results;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_surat_pindah, null);
        SuratPindahAdapter.MyHolder holder = new SuratPindahAdapter.MyHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        SuratPindahAdapter.MyHolder myHolder = (SuratPindahAdapter.MyHolder) holder;
        tampil result = results.get(position);
        myHolder.nama_kec.setText("KECAMATAN "+result.getNAMA_KEC());
        myHolder.total_kec.setText(result.getJUMLAH());
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {
        TextView nama_kec, total_kec;

        public MyHolder(View itemView) {
            super(itemView);
            nama_kec = itemView.findViewById(R.id.tvx_kec);
            total_kec = itemView.findViewById(R.id.tvx_totalKec);
        }
    }

}
