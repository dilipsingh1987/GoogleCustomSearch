package search.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ItemArray {



    @SerializedName("items")
    @Expose
    private List<ItemResponse> items = null;

    /**
     * @return Gets the value of items and returns items
     */
    public List<ItemResponse> getItems() {
        return items;
    }

    /**
     * Sets the items
     * You can use getItems() to get the value of items
     */
    public void setItems(List<ItemResponse> items) {
        this.items = items;
    }


}
