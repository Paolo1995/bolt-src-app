package androidx.camera.core;

import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public class ImageCaptureException extends Exception {

    /* renamed from: f  reason: collision with root package name */
    private final int f3187f;

    public ImageCaptureException(int i8, @NonNull String str, Throwable th) {
        super(str, th);
        this.f3187f = i8;
    }

    public int a() {
        return this.f3187f;
    }
}
