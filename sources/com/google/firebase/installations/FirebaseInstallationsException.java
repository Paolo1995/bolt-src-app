package com.google.firebase.installations;

import androidx.annotation.NonNull;
import com.google.firebase.FirebaseException;

/* loaded from: classes3.dex */
public class FirebaseInstallationsException extends FirebaseException {
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private final Status f16369f;

    /* loaded from: classes3.dex */
    public enum Status {
        BAD_CONFIG,
        UNAVAILABLE,
        TOO_MANY_REQUESTS
    }

    public FirebaseInstallationsException(@NonNull Status status) {
        this.f16369f = status;
    }

    public FirebaseInstallationsException(@NonNull String str, @NonNull Status status) {
        super(str);
        this.f16369f = status;
    }
}
