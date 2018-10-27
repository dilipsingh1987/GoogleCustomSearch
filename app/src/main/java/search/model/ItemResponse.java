package search.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ItemResponse {

    @SerializedName("kind")
    @Expose
    private String kind;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("htmlTitle")
    @Expose
    private String htmlTitle;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("displayLink")
    @Expose
    private String displayLink;
    @SerializedName("snippet")
    @Expose
    private String snippet;
    @SerializedName("htmlSnippet")
    @Expose
    private String htmlSnippet;
    @SerializedName("formattedUrl")
    @Expose
    private String formattedUrl;
    @SerializedName("htmlFormattedUrl")
    @Expose
    private String htmlFormattedUrl;
    @SerializedName("cacheId")
    @Expose
    private String cacheId;

    /**
     * @return Gets the value of kind and returns kind
     */
    public String getKind() {
        return kind;
    }

    /**
     * Sets the kind
     * You can use getKind() to get the value of kind
     */
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     * @return Gets the value of title and returns title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title
     * You can use getTitle() to get the value of title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return Gets the value of htmlTitle and returns htmlTitle
     */
    public String getHtmlTitle() {
        return htmlTitle;
    }

    /**
     * Sets the htmlTitle
     * You can use getHtmlTitle() to get the value of htmlTitle
     */
    public void setHtmlTitle(String htmlTitle) {
        this.htmlTitle = htmlTitle;
    }

    /**
     * @return Gets the value of link and returns link
     */
    public String getLink() {
        return link;
    }

    /**
     * Sets the link
     * You can use getLink() to get the value of link
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     * @return Gets the value of displayLink and returns displayLink
     */
    public String getDisplayLink() {
        return displayLink;
    }

    /**
     * Sets the displayLink
     * You can use getDisplayLink() to get the value of displayLink
     */
    public void setDisplayLink(String displayLink) {
        this.displayLink = displayLink;
    }

    /**
     * @return Gets the value of snippet and returns snippet
     */
    public String getSnippet() {
        return snippet;
    }

    /**
     * Sets the snippet
     * You can use getSnippet() to get the value of snippet
     */
    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }

    /**
     * @return Gets the value of htmlSnippet and returns htmlSnippet
     */
    public String getHtmlSnippet() {
        return htmlSnippet;
    }

    /**
     * Sets the htmlSnippet
     * You can use getHtmlSnippet() to get the value of htmlSnippet
     */
    public void setHtmlSnippet(String htmlSnippet) {
        this.htmlSnippet = htmlSnippet;
    }

    /**
     * @return Gets the value of formattedUrl and returns formattedUrl
     */
    public String getFormattedUrl() {
        return formattedUrl;
    }

    /**
     * Sets the formattedUrl
     * You can use getFormattedUrl() to get the value of formattedUrl
     */
    public void setFormattedUrl(String formattedUrl) {
        this.formattedUrl = formattedUrl;
    }

    /**
     * @return Gets the value of htmlFormattedUrl and returns htmlFormattedUrl
     */
    public String getHtmlFormattedUrl() {
        return htmlFormattedUrl;
    }

    /**
     * Sets the htmlFormattedUrl
     * You can use getHtmlFormattedUrl() to get the value of htmlFormattedUrl
     */
    public void setHtmlFormattedUrl(String htmlFormattedUrl) {
        this.htmlFormattedUrl = htmlFormattedUrl;
    }

    /**
     * @return Gets the value of cacheId and returns cacheId
     */
    public String getCacheId() {
        return cacheId;
    }

    /**
     * Sets the cacheId
     * You can use getCacheId() to get the value of cacheId
     */
    public void setCacheId(String cacheId) {
        this.cacheId = cacheId;
    }


}
