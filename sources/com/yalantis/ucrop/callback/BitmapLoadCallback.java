package com.yalantis.ucrop.callback;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.yalantis.ucrop.model.ExifInfo;

/* loaded from: classes3.dex */
public interface BitmapLoadCallback {
    void onBitmapLoaded(@NonNull Bitmap bitmap, @NonNull ExifInfo exifInfo, @NonNull String str, String str2);

    void onFailure(@NonNull Exception exc);
}
