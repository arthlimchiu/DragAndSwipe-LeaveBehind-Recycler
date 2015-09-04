package com.arthlimchiu.dragandswiperecycler;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by shang on 8/11/2015.
 */
public class RecyclerListAdapter extends RecyclerView.Adapter<ItemViewHolder> implements ItemTouchHelperAdapter {

    private final OnItemSwipedListener mOnItemSwipedListener;

    private static final String[] STRINGS = new String[]{
            "One", "Two", "Three",
            "Four", "Five", "Six",
            "Seven", "Eight", "Nine",
            "Ten", "Eleven", "Twelve",
            "Thirteen", "Fourteen", "Fifteen",
            "Sixteen", "Seventeen", "Eighteen",
            "Nineteen", "Twenty", "Twenty-One"
    };

    private final List<String> mItems = new ArrayList<>();

    public RecyclerListAdapter(OnItemSwipedListener onItemSwipedListener) {
        mOnItemSwipedListener = onItemSwipedListener;
        mItems.addAll(Arrays.asList(STRINGS));
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_main, viewGroup, false);

        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ItemViewHolder itemViewHolder, int position) {
        itemViewHolder.textView.setTranslationX(0.0f);
        itemViewHolder.textView.setText(mItems.get(position));
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        if (fromPosition < toPosition) {
            for (int i = fromPosition; i < toPosition; i++) {
                Collections.swap(mItems, i, i + 1);
            }
        } else {
            for (int i = fromPosition; i > toPosition; i--) {
                Collections.swap(mItems, i, i - 1);
            }
        }
        notifyItemMoved(fromPosition, toPosition);
        return true;
    }

    @Override
    public void onItemDismiss(int position, int direction) {
        String item = mItems.remove(position);
        notifyItemRemoved(position);
        if (direction == ItemTouchHelper.END) {
            mOnItemSwipedListener.onItemConverted(item, position);
        } else if (direction == ItemTouchHelper.START) {
            mOnItemSwipedListener.onItemDeleted(item, position);
        }
    }

    public void undoAction(String item, int position) {
        mItems.add(position, item);
        notifyItemInserted(position);
    }
}
