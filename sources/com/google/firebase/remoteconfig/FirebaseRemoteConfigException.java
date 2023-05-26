package com.google.firebase.remoteconfig;

import androidx.annotation.NonNull;
import com.google.firebase.FirebaseException;

/* loaded from: classes3.dex */
public class FirebaseRemoteConfigException extends FirebaseException {
    public FirebaseRemoteConfigException(@NonNull String str) {
        super(str);
    }

    public FirebaseRemoteConfigException(@NonNull String str, Throwable th) {
        super(str, th);
    }
}
