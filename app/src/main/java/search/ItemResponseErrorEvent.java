package search;

public class ItemResponseErrorEvent {


    private String errorCode;

    ItemResponseErrorEvent(String mErrorCode) {
        this.errorCode = mErrorCode;
    }

    /**
     * @return Gets the value of errorCode and returns errorCode
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * Sets the errorCode
     * You can use getErrorCode() to get the value of errorCode
     */
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
