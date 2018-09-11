package com.example.android.tourguide;

public class PointOfInterest {

    /**
     * String resource ID for the name of the point of interest
     */
    private int mPointOfInterestName;

    /**
     * String resource ID for the address of the point of interest
     */
    private int mPointOfInterestAddress;

    /**
     * String resource ID for the phone number of the point of interest
     */
    private int mPointOfInterestPhone;

    /**
     * String resource ID for the website address of the point of interest
     */
    private int mPointOfInterestWeb;

    /**
     * Image resource ID for the word
     */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /**
     * Constant value that represents no image was provided for this point of interest
     */
    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * Create a new Point Of Interest object.
     *
     * @param PointOfInterestName    is the string resource ID for the name of a point of interest
     * @param PointOfInterestAddress is the string resource ID for the address of a point of interest
     * @param PointOfInterestPhone   is the string resource Id for the phone number of a point of interest
     * @param PointOfInterestWeb     is the string resource ID for the website of a point of interest
     */
    public PointOfInterest(int PointOfInterestName, int PointOfInterestAddress, int PointOfInterestPhone, int PointOfInterestWeb) {
        mPointOfInterestName = PointOfInterestName;
        mPointOfInterestAddress = PointOfInterestAddress;
        mPointOfInterestPhone = PointOfInterestPhone;
        mPointOfInterestWeb = PointOfInterestWeb;
    }

    /**
     * Create a new Point Of Interest object with an image.
     *
     * @param PointOfInterestName    is the string resource ID for the name of a point of interest
     * @param PointOfInterestAddress is the string resource ID for the address of a point of interest
     * @param PointOfInterestPhone   is the string resource Id for the phone number of a point of interest
     * @param PointOfInterestWeb     is the string resource ID for the website of a point of interest
     * @param PointOfInterestWeb     is the image resource ID for the image of a point of interest
     */
    public PointOfInterest(int PointOfInterestName, int PointOfInterestAddress, int PointOfInterestPhone, int PointOfInterestWeb, int ImageResourceId) {
        mPointOfInterestName = PointOfInterestName;
        mPointOfInterestAddress = PointOfInterestAddress;
        mPointOfInterestPhone = PointOfInterestPhone;
        mPointOfInterestWeb = PointOfInterestWeb;
        mImageResourceId = ImageResourceId;
    }

    /**
     * Get the string resource ID for the name of the point of interest.
     */
    public int getPointOfInterestName() {
        return mPointOfInterestName;
    }

    /**
     * Get the string resource ID for the address of the point of interest.
     */
    public int getPointOfInterestAddress() {
        return mPointOfInterestAddress;
    }

    /**
     * Return the string resource ID for the telephone number of the point of interest.
     */
    public int getPointOfInterestPhone() {
        return mPointOfInterestPhone;
    }

    /**
     * Return the string resource ID for the web address of the point of interest.
     */
    public int getPointOfInterestWeb() {
        return mPointOfInterestWeb;
    }

    /**
     * Return the image resource ID of the point of interest.
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Returns whether or not there is an image for this point of interest.
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

}
