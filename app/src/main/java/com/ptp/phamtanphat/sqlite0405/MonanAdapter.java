package com.ptp.phamtanphat.sqlite0405;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class MonanAdapter extends ArrayAdapter<Monan> {
    public MonanAdapter(@NonNull Context context, int resource, @NonNull List<Monan> objects) {
        super(context, resource, objects);
    }

    class ViewHolder{
        TextView txtTenMonan,txtGiamonan,txtDiachi;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            convertView = layoutInflater.inflate(R.layout.dong_item_monan,null);
            viewHolder = new ViewHolder();
            viewHolder.txtDiachi = convertView.findViewById(R.id.textviewDiachi);
            viewHolder.txtGiamonan = convertView.findViewById(R.id.textviewGiamonan);
            viewHolder.txtTenMonan = convertView.findViewById(R.id.textviewTenmonan);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Monan monan = getItem(position);
        viewHolder.txtTenMonan.setText(monan.getTenmonan());
        viewHolder.txtGiamonan.setText(monan.getGiamonan() + " Dong");
        viewHolder.txtDiachi.setText(monan.getDiachi());
        return convertView;
    }

}
