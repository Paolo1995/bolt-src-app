package com.google.android.gms.maps.model;

import androidx.annotation.NonNull;

/* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
/* loaded from: classes.dex */
public final class Gap extends PatternItem {
    public final float length;

    public Gap(float f8) {
        super(2, Float.valueOf(Math.max(f8, 0.0f)));
        this.length = Math.max(f8, 0.0f);
    }

    @Override // com.google.android.gms.maps.model.PatternItem
    @NonNull
    public String toString() {
        float f8 = this.length;
        return "[Gap: length=" + f8 + "]";
    }
}
