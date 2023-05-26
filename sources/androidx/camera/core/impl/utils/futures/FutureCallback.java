package androidx.camera.core.impl.utils.futures;

import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public interface FutureCallback<V> {
    void onFailure(@NonNull Throwable th);

    void onSuccess(V v7);
}
