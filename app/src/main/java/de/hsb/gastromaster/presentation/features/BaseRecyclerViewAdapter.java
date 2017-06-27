/*
 * @author Christian Schaf
 * @author Roman Quistler
 * @author Nassim Bendida
 *
 * Date: 27.6.2017
 * Copyright (c) by Hochschule Bremen
 */

package de.hsb.gastromaster.presentation.features;

import android.support.annotation.StringDef;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Base recycler view adapter.
 *
 * @param <T> the type parameter
 */
public abstract class BaseRecyclerViewAdapter<T> extends
        RecyclerView.Adapter<BaseRecyclerViewAdapter.BaseViewHolder> {

    private IOnItemClick listener;
    private List<T> itemList = new ArrayList<>();


    /**
     * Instantiates a new Base recycler view adapter.
     *
     * @param itemList the item list
     * @param listener the listener
     */
    public BaseRecyclerViewAdapter(List<T> itemList,
                                   IOnItemClick listener) {

        this.itemList.addAll(itemList);
        this.listener = listener;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new BaseViewHolder(createView(parent, viewType), listener);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder baseViewHolder,
                                 int position) {

        bindItem(itemList.get(position), baseViewHolder);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    /**
     * Sets on click listener.
     *
     * @param listener the listener
     */
    public void setOnClickListener(IOnItemClick listener) {
        this.listener = listener;
    }

    /**
     * Add items.
     *
     * @param position the position
     * @param items    the items
     */
    public void addItems(@ListPosition String position,
                         ArrayList<T> items) {

        for (T item : items) {
            addItem(position, item);
        }
    }

    /**
     * Add item.
     *
     * @param position the position
     * @param item     the item
     */
    public void addItem(@ListPosition String position, T item) {

        if (itemList.contains(item)) {
            return;
        }

        switch (position) {
            case TOP:
                itemList.add(0, item);
                notifyItemInserted(0);
                break;
            case BOTTOM:
                itemList.add(item);
                notifyItemInserted(itemList.size() - 1);
                break;
        }
        //notifyDataSetChanged();
    }

    /**
     * Gets item list item.
     *
     * @param position the position
     * @return the item list item
     */
    public T getItemListItem(int position) {

        return ((itemList != null
                && position < itemList.size())
                ? itemList.get(position) : null);
    }

    /**
     * Sets list.
     *
     * @param itemList the item list
     */
    public void setList(List<T> itemList) {
        this.itemList = itemList;
        notifyDataSetChanged();
    }

    /**
     * Gets item list.
     *
     * @return the item list
     */
    public List<T> getItemList() {
        return itemList;
    }

    /**
     * Remove item at position boolean.
     *
     * @param position the position
     * @return the boolean
     */
    public boolean removeItemAtPosition(int position) {

        if (position >= itemList.size()) {
            return false;
        }

        itemList.remove(position);
        notifyItemRemoved(position);

        return true;
    }

    /**
     * Create view view.
     *
     * @param parent   the parent
     * @param viewType the view type
     * @return the view
     */
    protected abstract View createView(ViewGroup parent, int viewType);

    /**
     * Bind item.
     *
     * @param item       the item
     * @param viewHolder the view holder
     */
    protected abstract void bindItem(T item, RecyclerView.ViewHolder viewHolder);


    /**
     * The type Base view holder.
     */
// --------------------
    // ViewHolder
    // --------------------
    public static class BaseViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener, View.OnLongClickListener {

        private IOnItemClick listener;

        /**
         * Instantiates a new Base view holder.
         *
         * @param itemView the item view
         * @param listener the listener
         */
        public BaseViewHolder(View itemView, IOnItemClick listener) {
            super(itemView);

            this.listener = listener;

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onClick(view, getAdapterPosition());
        }

        @Override
        public boolean onLongClick(View view) {
            if (view == null) return false;
            listener.onLongClick(view, getAdapterPosition());
            return true;
        }
    }

    /**
     * The interface On item click.
     */
    public interface IOnItemClick {
        /**
         * On click.
         *
         * @param view     the view
         * @param position the position
         */
        void onClick(View view, int position);

        /**
         * On long click.
         *
         * @param view     the view
         * @param position the position
         */
        void onLongClick(View view, int position);
    }


    /**
     * The interface List position.
     */
    @StringDef({TOP, BOTTOM})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ListPosition {
    }

    /**
     * The constant TOP.
     */
    public static final String TOP = "TOP";
    /**
     * The constant BOTTOM.
     */
    public static final String BOTTOM = "Bottom";
}
