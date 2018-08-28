package com.example.android.Bandroid;

/**
 * {@link Song} represents a song from a particular album and artist.
 * It contains Album Title, Artist, Song Title and an image of the Album.
 */
public class Song {

    /** Album Title */
    private String mAlbumTitle;

    /** Artist */
    private String mArtist;

    /** Song Title */
    private String mSongTitle;

    /** Image resource ID for the album cover art */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /** Constant value that represents no image was provided for this word */
    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * Create a new Word object.
     *
     * @param albumTitle is the title of the album
     * @param artist is the artist
     * @param songTitle is the title of the song
     * @param imageResourceId the resource ID for the image file associated with this album
     */
    public Song(String albumTitle, String artist, String songTitle, int imageResourceId) {
        mAlbumTitle = albumTitle;
        mArtist = artist;
        mSongTitle = songTitle;
        mImageResourceId = imageResourceId;
    }

    /**
     * Get the album title.
     */
    public String getAlbumTitle() {
        return mAlbumTitle;
    }

    /**
     * Get the artist.
     */
    public String getArtist() { return mArtist;
    }

    /**
     * Get the song title.
     */
    public String getSongTitle() {
        return mSongTitle;
    }

    /**
     * Return the image resource ID of the album art image.
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Returns whether or not there is an image for this album.
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

}