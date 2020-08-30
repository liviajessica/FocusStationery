package id.ac.umn.focus_server.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import id.ac.umn.focus_server.Common.Common;
import id.ac.umn.focus_server.Interface.ItemClickListener;
import id.ac.umn.focus_server.R;

public class FocusViewHolder extends RecyclerView.ViewHolder implements
        View.OnClickListener,
        View.OnCreateContextMenuListener

{

    public TextView focus_name;
    public ImageView focus_image;

    private ItemClickListener itemClickListener;

    public FocusViewHolder(View itemView){
        super(itemView);

        focus_name = itemView.findViewById(R.id.focus_name);
        focus_image = itemView.findViewById(R.id.focus_image);

        itemView.setOnCreateContextMenuListener(this);
        itemView.setOnClickListener(this);

    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View view)
    {
        itemClickListener.onClick(view, getAdapterPosition(), false);
    }

    @Override
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        contextMenu.setHeaderTitle("Select the action");

        contextMenu.add(0,0,getAdapterPosition(), Common.UPDATE);
        contextMenu.add(0,0,getAdapterPosition(), Common.DELETE);
    }
}
