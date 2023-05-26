package com.google.android.gms.common.api;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Result;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes.dex */
public abstract class ResultCallbacks<R extends Result> implements ResultCallback<R> {
    public abstract void onFailure(@NonNull Status status);

    @Override // com.google.android.gms.common.api.ResultCallback
    @KeepForSdk
    public final void onResult(@NonNull R r7) {
        Status status = r7.getStatus();
        if (status.isSuccess()) {
            onSuccess(r7);
            return;
        }
        onFailure(status);
        if (r7 instanceof Releasable) {
            try {
                ((Releasable) r7).release();
            } catch (RuntimeException e8) {
                Log.w("ResultCallbacks", "Unable to release ".concat(String.valueOf(r7)), e8);
            }
        }
    }

    public abstract void onSuccess(@NonNull R r7);
}
