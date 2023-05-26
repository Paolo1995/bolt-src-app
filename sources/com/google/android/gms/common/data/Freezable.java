package com.google.android.gms.common.data;

import androidx.annotation.NonNull;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
/* loaded from: classes.dex */
public interface Freezable<T> {
    @NonNull
    T freeze();

    boolean isDataValid();
}
