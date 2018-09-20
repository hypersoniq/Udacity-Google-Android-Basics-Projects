package com.example.android.newsreaderv2;

/**
 * An {@link News} object contains information related to a single news article.
 */
public class News {

    /**
     * Section the article can be found in
     */
    private String mSection;

    /**
     * Headline of the article
     */
    private String mHeadline;

    /**
     * Author(s) of the article
     */
    private String mAuthor;

    /**
     * Date of the article's publication
     */
    private String mDate;

    /**
     * Website URL of the article
     */
    private String mUrl;

    /**
     * Constructs a new {@link News} object.
     *
     * @param section  is the section where the story can be found
     * @param headline is the headline of the story
     * @param author   is the author(s) of the story
     * @param date     is the date of publication of the article
     * @param url      is the website URL to read the article
     */
    public News(String section, String headline, String author, String date, String url) {
        mSection = section;
        mHeadline = headline;
        mAuthor = author;
        mDate = date;
        mUrl = url;
    }

    /**
     * Returns the section where the story can be found.
     */
    public String getSection() {
        return mSection;
    }

    /**
     * Returns the headline of the article.
     */
    public String getHeadline() {
        return mHeadline;
    }

    /**
     * Returns the author(s) of the article.
     */
    public String getAuthor() {
        return mAuthor;
    }

    /**
     * Returns the date of the article's publication.
     */
    public String getDate() {
        return mDate;
    }

    /**
     * Returns the website URL to read the article.
     */
    public String getUrl() {
        return mUrl;
    }
}

