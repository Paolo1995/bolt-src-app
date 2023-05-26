package com.google.android.gms.common;

import android.content.Intent;
import androidx.annotation.NonNull;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes.dex */
public class GooglePlayServicesRepairableException extends UserRecoverableException {
    private final int zza;

    public GooglePlayServicesRepairableException(int i8, @NonNull String str, @NonNull Intent intent) {
        super(str, intent);
        this.zza = i8;
    }

    public int getConnectionStatusCode() {
        return this.zza;
    }
}
