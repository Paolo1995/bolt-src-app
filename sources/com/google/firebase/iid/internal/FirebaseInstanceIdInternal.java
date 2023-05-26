package com.google.firebase.iid.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.firebase:firebase-iid-interop@@17.1.0 */
@KeepForSdk
/* loaded from: classes3.dex */
public interface FirebaseInstanceIdInternal {

    /* compiled from: com.google.firebase:firebase-iid-interop@@17.1.0 */
    @KeepForSdk
    /* loaded from: classes3.dex */
    public interface NewTokenListener {
        @KeepForSdk
        void a(String str);
    }

    @KeepForSdk
    String a();

    @NonNull
    @KeepForSdk
    Task<String> b();

    @KeepForSdk
    void c(NewTokenListener newTokenListener);
}
