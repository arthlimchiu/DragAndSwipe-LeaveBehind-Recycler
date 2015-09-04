package com.arthlimchiu.dragandswiperecycler;

/**
 * Created by shang on 8/13/2015.
 */
public interface OnItemSwipedListener {
    void onItemDeleted(String item, int position);
    void onItemConverted(String item, int position);
}
