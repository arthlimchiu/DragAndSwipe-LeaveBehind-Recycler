package com.arthlimchiu.dragandswiperecycler;

/**
 * Created by shang on 8/11/2015.
 */
public interface ItemTouchHelperAdapter {
    //void onItemMove(int fromPosition, int toPosition);

    boolean onItemMove(int fromPosition, int toPosition);

    void onItemDismiss(int position, int direction);
}
