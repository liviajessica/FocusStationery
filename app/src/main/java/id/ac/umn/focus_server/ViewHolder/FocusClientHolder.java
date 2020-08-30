package id.ac.umn.focus_server.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import id.ac.umn.focus_server.Interface.ItemClickListener;
import id.ac.umn.focus_server.R;

public class FocusClientHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public TextView focus_name;
    public ImageView focus_image;

    private ItemClickListener itemClickListener;

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public FocusClientHolder(View itemView) {
        super(itemView);

        focus_name =(TextView)itemView.findViewById(R.id.focus_name);
        focus_image = (ImageView)itemView.findViewById(R.id.focus_image);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        itemClickListener.onClick(view, getAdapterPosition(), false);

    }

}
