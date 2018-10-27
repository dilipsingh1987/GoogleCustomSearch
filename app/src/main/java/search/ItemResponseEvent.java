package search;

import java.util.List;

import search.model.ItemResponse;

public class ItemResponseEvent {

    private List<ItemResponse> itemResponse;

    ItemResponseEvent(List<ItemResponse> mItemResponse) {
        this.itemResponse = mItemResponse;

    }


    /**
     * @return Gets the value of itemResponse and returns itemResponse
     */
    public List<ItemResponse> getItemResponse() {
        return itemResponse;
    }

    /**
     * Sets the itemResponse
     * You can use getItemResponse() to get the value of itemResponse
     */
    public void setItemResponse(List<ItemResponse> itemResponse) {
        this.itemResponse = itemResponse;
    }


}
