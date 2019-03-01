package com.next.sheharyar.recylerviewudacityexample.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.next.sheharyar.recylerviewudacityexample.Interfaces.ListItemClickListener;
import com.next.sheharyar.recylerviewudacityexample.R;

import java.util.zip.Inflater;

/**
 * Created by sheharyar on 3/1/2019.
 */

public class GreenAdapter extends RecyclerView.Adapter<GreenAdapter.NumberViewHolder>{


    private static final String TAG = GreenAdapter.class.getName();

    private int mNumOfItems;

    final private ListItemClickListener mOnClickListener;

    private static int viewHolderCount;

    /**
     * Constructor for GreenAdapter that accepts a number of items to display and the specification
     * for the ListItemClickListener.
     *
     * @param numberOfItems Number of items to display in list
     */

    public GreenAdapter(int numberOfItems, ListItemClickListener clickListener){
        mNumOfItems = numberOfItems;
        mOnClickListener = clickListener;
        viewHolderCount = 0;
    }

    /**
     *
     * This gets called when each new ViewHolder is created. This happens when the RecyclerViewActivity
     * is laid out. Enough ViewHolders will be created to fill the screen and allow for scrolling.
     *
     * @param viewGroup The ViewGroup that these ViewHolders are contained within.
     * @param viewType  If your RecyclerViewActivity has more than one type of item (which ours doesn't) you
     *                  can use this viewType integer to provide a different layout. See
     *                  {@link android.support.v7.widget.RecyclerView.Adapter#getItemViewType(int)}
     *                  for more details.
     * @return A new NumberViewHolder that holds the View for each list item
     */

    @Override
    public GreenAdapter.NumberViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.number_list_item;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImedietly = false;
        View rootView = layoutInflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImedietly);
        NumberViewHolder viewHolder = new NumberViewHolder(rootView);
        return viewHolder;

    }

    /**
     * OnBindViewHolder is called by the RecyclerViewActivity to display the data at the specified
     * position. In this method, we update the contents of the ViewHolder to display the correct
     * indices in the list for this particular position, using the "position" argument that is conveniently
     * passed into us.
     *
     * @param holder   The ViewHolder which should be updated to represent the contents of the
     *                 item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */

    @Override
    public void onBindViewHolder(GreenAdapter.NumberViewHolder holder, int position) {

        Log.d(TAG, "#" + position);
        holder.bind(position);
    }



    /**
     * This method simply returns the number of items to display. It is used behind the scenes
     * to help layout our Views and for animations.
     *
     * @return The number of items available in our forecast
     */

    @Override
    public int getItemCount() {
        return mNumOfItems;
    }

    class NumberViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView listItemNumberView;
        // Will display which ViewHolder is displaying this data
        TextView viewHolderIndex;

        public NumberViewHolder(View itemView) {
            super(itemView);
            listItemNumberView = (TextView)itemView.findViewById(R.id.tv_item_number);
            itemView.setOnClickListener(this);
        }

        public void bind(int listIndex) {
            listItemNumberView.setText(String.valueOf(listIndex));
        }

        @Override
        public void onClick(View view) {
            int clikedPosition = getAdapterPosition();
            mOnClickListener.onItemClicked(clikedPosition);
        }
    }

}
