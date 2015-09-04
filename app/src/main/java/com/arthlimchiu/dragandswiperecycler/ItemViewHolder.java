package com.arthlimchiu.dragandswiperecycler;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by shang on 8/11/2015.
 */
public class ItemViewHolder extends RecyclerView.ViewHolder implements ItemTouchHelperViewHolder{

    public final TextView textView;
    public final View itemView;
    public LinearLayout deleteView;
    public LinearLayout undoView;
    public LinearLayout todoView;

    public ItemViewHolder(View itemView) {
        super(itemView);
        textView = (TextView) itemView.findViewById(R.id.text);
        deleteView = (LinearLayout) itemView.findViewById(R.id.item_main_delete);
        todoView = (LinearLayout) itemView.findViewById(R.id.item_main_todo);
        undoView = (LinearLayout) itemView.findViewById(R.id.item_main_undo);
        this.itemView = itemView;
    }

    @Override
    public void onItemSelected() {
        textView.setBackgroundColor(Color.LTGRAY);
    }

    @Override
    public void onItemClear() {
        textView.setBackgroundColor(Color.WHITE);
    }

}
