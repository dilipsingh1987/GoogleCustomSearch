package com.googlecustomsearch.googlecustomsearch;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.otto.Subscribe;

import java.util.List;

import adapter.GoogleSearchResultAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import search.ItemInteractor;
import search.ItemResponseErrorEvent;
import search.ItemResponseEvent;
import search.model.ItemResponse;
import utilities.Constants;
import utilities.Utils;


public class GoogleCustomSearchActivity extends BaseParentActivity {

    private ItemInteractor itemInteractor;

    @BindView(R.id.search_edit_text)
    EditText mEditTextSearch;

    @BindView(R.id.search_button)
    ImageButton mImageButtonSearch;

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    @BindView(R.id.coordinatorLayout)
    CoordinatorLayout mCoordinatorLayout;

    @Override
    public void onCreateActivity(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_google_custom_search);
        ButterKnife.bind(GoogleCustomSearchActivity.this);
        itemInteractor = new ItemInteractor();

    }

    @OnClick({
            R.id.search_button})
    public void onClicks(View view) {

        switch (view.getId()) {

            case R.id.search_button:
                Utils.hideSoftKeyboard(this);
                if (mEditTextSearch.getText().toString().isEmpty()) {
                    Utils.showSnackBar(mCoordinatorLayout,
                            getResources().getString(R.string.enter_for_search));
                } else {
                    callGoogleSearchApi(mEditTextSearch.getText().toString()
                                    .replace(" ", "+"),
                            Constants.BROWSER_KEY, Constants.SERACH_ENGINE_ID);
                }

                break;
        }
    }

    /**
     * Method use for pass data as required for google GET api
     *
     * @param mSearchStringNoSpaces
     * @param mBrowserKey
     * @param mSearchEngineId
     */
    @SuppressWarnings({"JavaDoc"})
    private void callGoogleSearchApi(String mSearchStringNoSpaces,
                                     String mBrowserKey,
                                     String mSearchEngineId) {
        itemInteractor.getGoogleSearchApiGet(this, this,
                mSearchStringNoSpaces,
                mBrowserKey,
                mSearchEngineId);
    }

    @Subscribe
    public void onGoogleSearchApiResponseEvent(ItemResponseEvent itemResponseEvent) {

        setGoogleSearchResultAdapter(mRecyclerView, itemResponseEvent.getItemResponse());
    }

    @Subscribe
    public void onGoogleSearchApiErrorEvent(ItemResponseErrorEvent itemResponseErrorEvent) {

        Utils.showSnackBar(mCoordinatorLayout, itemResponseErrorEvent.getErrorCode());

    }

    @SuppressWarnings({"JavaDoc"})
    private void setGoogleSearchResultAdapter(RecyclerView mRecyclerView,
                                              List<ItemResponse> mItemArrayArrayList) {

        //set recycler view on adapter
        Context context = getApplicationContext();
        RecyclerView.LayoutManager recyclerViewLayoutManager =
                new LinearLayoutManager(context);
        mRecyclerView.setLayoutManager(recyclerViewLayoutManager);
        GoogleSearchResultAdapter mGoogleSearchResultAdapter =
                new GoogleSearchResultAdapter(this, mItemArrayArrayList);
        mRecyclerView.setAdapter(mGoogleSearchResultAdapter);
        mRecyclerView.setNestedScrollingEnabled(true);

    }

}
