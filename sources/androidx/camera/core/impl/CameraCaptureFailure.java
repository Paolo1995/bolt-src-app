package androidx.camera.core.impl;

import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public class CameraCaptureFailure {

    /* renamed from: a  reason: collision with root package name */
    private final Reason f3550a;

    /* loaded from: classes.dex */
    public enum Reason {
        ERROR
    }

    public CameraCaptureFailure(@NonNull Reason reason) {
        this.f3550a = reason;
    }

    @NonNull
    public Reason a() {
        return this.f3550a;
    }
}
