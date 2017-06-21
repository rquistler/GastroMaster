package de.hsb.gastromaster.presentation.features;

import android.support.annotation.StringDef;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseRecyclerViewAdapter<T> extends
        RecyclerView.Adapter<BaseRecyclerViewAdapter.BaseViewHolder> {

    private IOnItemClick listener;
    private List<T> itemList = new ArrayList<>();


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

    public void setOnClickListener(IOnItemClick listener) {
        this.listener = listener;
    }

    public void addItems(@ListPosition String position,
                         ArrayList<T> items) {

        for (T item : items) {
            addItem(position, item);
        }
    }

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

    public T getItemListItem(int position) {

        return ((itemList != null
                && position < itemList.size())
                ? itemList.get(position) : null);
    }

    public void setList(List<T> itemList) {
        this.itemList = itemList;
        notifyDataSetChanged();
    }

    public List<T> getItemList() {
        return itemList;
    }

    public boolean removeItemAtPosition(int position) {

        if (position >= itemList.size()) {
            return false;
        }

        itemList.remove(position);
        notifyItemRemoved(position);

        return true;
    }

    protected abstract View createView(ViewGroup parent, int viewType);

    protected abstract void bindItem(T item, RecyclerView.ViewHolder viewHolder);


    // --------------------
    // ViewHolder
    // --------------------
    public static class BaseViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        private IOnItemClick listener;

        public BaseViewHolder(View itemView, IOnItemClick listener) {
            super(itemView);

            this.listener = listener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            System.out.println("Click");
            listener.onClick(view, getAdapterPosition());
        }
    }

    public interface IOnItemClick {
        void onClick(View view, int position);
    }


    @StringDef({TOP, BOTTOM})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ListPosition {
    }

    public static final String TOP = "TOP";
    public static final String BOTTOM = "Bottom";
}
