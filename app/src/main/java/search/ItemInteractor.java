package search;

import android.content.Context;
import android.support.annotation.Nullable;

import com.googlecustomsearch.googlecustomsearch.R;
import com.squareup.otto.Produce;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import search.model.ItemArray;
import search.model.ItemResponse;

public class ItemInteractor implements IBaseApi {

    private IViews iViews;
    private Context context;

    /**
     * Method use for get Google Search Api response from GET request
     *
     * @param mContext
     * @param mIViews
     * @param mSearchStringNoSpaces
     * @param mBrowserKey
     * @param mSearchEngineId
     */
    @SuppressWarnings({"JavaDoc", "unused", "ConstantConditions"})
    public void getGoogleSearchApiGet(Context mContext,
                                      IViews mIViews,
                                      String mSearchStringNoSpaces,
                                      String mBrowserKey,
                                      String mSearchEngineId) {
        context = mContext;
        iViews = mIViews;
        iViews.createLoading();
        iViews.showLoading();
        String mUrl = mBaseUrl
                + mBaseSearchDataKey
                + mSearchStringNoSpaces
                + mBaseApiKeyUrl
                + mBrowserKey
                + mBaseSearchEngineIdUrl
                + mSearchEngineId
                + mBaseJsonAlt;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(mBaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        IGoogleSearchApi iGoogleSearchApi = retrofit.create(IGoogleSearchApi.class);
        Call<ItemArray> itemResponseCall = iGoogleSearchApi.getItemArrayFromGoogleSearchAPi(mUrl);
        itemResponseCall.enqueue(new Callback<ItemArray>() {
            @Override
            public void onResponse(@Nullable Call<ItemArray> call,
                                   @Nullable Response<ItemArray> response) {

                iViews.hideLoading();
                if (response.body() != null) {


                    BusProvider.getInstance()
                            .post(itemResponseEvent(response.body().getItems()));


                } else {

                    BusProvider.getInstance()
                            .post(itemResponseErrorEvent(String.valueOf(response.raw().code())));

                }


            }

            @Override
            public void onFailure(@Nullable Call<ItemArray> call, @Nullable Throwable t) {

                iViews.hideLoading();
                BusProvider.getInstance().post(itemResponseErrorEvent(
                        context.getResources().getString(R.string.oops_something_went_wrong)));

            }
        });


    }


    @Produce
    private ItemResponseEvent itemResponseEvent(List<ItemResponse> itemResponse) {

        return new ItemResponseEvent(itemResponse);

    }

    @Produce
    private ItemResponseErrorEvent itemResponseErrorEvent(String mErrorCode) {
        return new ItemResponseErrorEvent(mErrorCode);

    }
}
