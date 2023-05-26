package com.yalantis.ucrop.callback;

import android.net.Uri;
import androidx.annotation.NonNull;

/* loaded from: classes3.dex */
public interface BitmapCropCallback {
    void onBitmapCropped(@NonNull Uri uri, int i8, int i9, int i10, int i11);

    void onCropFailure(@NonNull Throwable th);
}
