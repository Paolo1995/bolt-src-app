package com.yalantis.ucrop.model;

import android.graphics.Bitmap;

/* loaded from: classes3.dex */
public class CropParameters {
    private Bitmap.CompressFormat mCompressFormat;
    private int mCompressQuality;
    private ExifInfo mExifInfo;
    private String mImageInputPath;
    private String mImageOutputPath;
    private int mMaxResultImageSizeX;
    private int mMaxResultImageSizeY;

    public CropParameters(int i8, int i9, Bitmap.CompressFormat compressFormat, int i10, String str, String str2, ExifInfo exifInfo) {
        this.mMaxResultImageSizeX = i8;
        this.mMaxResultImageSizeY = i9;
        this.mCompressFormat = compressFormat;
        this.mCompressQuality = i10;
        this.mImageInputPath = str;
        this.mImageOutputPath = str2;
        this.mExifInfo = exifInfo;
    }

    public Bitmap.CompressFormat getCompressFormat() {
        return this.mCompressFormat;
    }

    public int getCompressQuality() {
        return this.mCompressQuality;
    }

    public ExifInfo getExifInfo() {
        return this.mExifInfo;
    }

    public String getImageInputPath() {
        return this.mImageInputPath;
    }

    public String getImageOutputPath() {
        return this.mImageOutputPath;
    }

    public int getMaxResultImageSizeX() {
        return this.mMaxResultImageSizeX;
    }

    public int getMaxResultImageSizeY() {
        return this.mMaxResultImageSizeY;
    }
}
