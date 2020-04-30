package com.googlecustomsearch.googlecustomsearch;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import search.BusProvider;
import search.IViews;
import utilities.ProgressDialogBox;

public abstract class BaseParentActivity extends AppCompatActivity implements IViews {

    ProgressDialogBox mProgressDialogBox;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onCreateActivity(savedInstanceState);

    }

    @Override
    public void createLoading() {
        mProgressDialogBox = ProgressDialogBox
                .showProgressDialog(this);
    }

    @Override
    public void showLoading() {
        mProgressDialogBox.show();
    }

    @Override
    public void hideLoading() {
        if (mProgressDialogBox != null)
            mProgressDialogBox.dismiss();
    }

    @Override
    public void setCancelable(boolean isCancel) {

        if (isCancel) mProgressDialogBox.setCanceledOnTouchOutside(true);
        else mProgressDialogBox.setCanceledOnTouchOutside(false);

    }

    @Override
    public void onResume() {
        super.onResume();
        BusProvider.getInstance().register(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        BusProvider.getInstance().unregister(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mProgressDialogBox != null && mProgressDialogBox.isShowing()) {
            mProgressDialogBox.cancel();
        }
    }

    /**
     * Method use for call onCreate from Child Activity
     *
     * @param savedInstanceState
     */
    @SuppressWarnings({"JavaDoc"})
    public abstract void onCreateActivity(@Nullable Bundle savedInstanceState);


}
