package search;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;
import search.model.ItemArray;

public interface IGoogleSearchApi {

    /**
     * Method use for get Item data response
     *
     * @return
     */
    @SuppressWarnings("JavaDoc")
    @GET
    Call<ItemArray> getItemArrayFromGoogleSearchAPi(@Url String mUrl);
}
