package adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.googlecustomsearch.googlecustomsearch.R;

import java.util.ArrayList;
import java.util.List;

import search.model.ItemResponse;

public class GoogleSearchResultAdapter extends RecyclerView
        .Adapter<GoogleSearchResultAdapter.ViewHolder> {

    private final Context mContext;
    private List<ItemResponse> itemArrayArrayList;


    /**
     * Method use for show request detail data in {@link RecyclerView}
     *
     * @param context
     * @param mItemArrayArrayList
     */
    @SuppressWarnings("JavaDoc")
    public GoogleSearchResultAdapter(Context context,
                                     List<ItemResponse> mItemArrayArrayList) {

        this.mContext = context;
        this.itemArrayArrayList = mItemArrayArrayList;

    }

    @NonNull
    @Override
    public ViewHolder
    onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View mView = LayoutInflater.from(mContext).
                inflate(R.layout.list_item_custom_search, parent, false);

        return new ViewHolder(mView);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {


        viewHolder.mTextTitle
                .setText(itemArrayArrayList.get(position).getTitle());
        viewHolder.mTextLink
                .setText(itemArrayArrayList.get(position).getLink());
        viewHolder.mTextDesc
                .setText(itemArrayArrayList.get(position).getSnippet());


    }


    @Override
    public int getItemCount() {
        return itemArrayArrayList.size();
    }

    /**
     * Method use speed up rendering of {@link ArrayList}
     */
    static class ViewHolder extends RecyclerView.ViewHolder {


        final TextView mTextTitle;
        final TextView mTextLink;
        final TextView mTextDesc;

        /**
         * Use for hold the item views
         *
         * @param convertView
         */
        @SuppressWarnings({"JavaDoc"})
        ViewHolder(View convertView) {

            super(convertView);
            mTextTitle = convertView
                    .findViewById(R.id.title_text);
            mTextLink = convertView
                    .findViewById(R.id.link_text);
            mTextDesc = convertView
                    .findViewById(R.id.desc_text);
        }
    }

}

