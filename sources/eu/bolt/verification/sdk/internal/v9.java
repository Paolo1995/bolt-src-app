package eu.bolt.verification.sdk.internal;

import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public interface v9 {

    /* loaded from: classes5.dex */
    public static abstract class a implements v9 {
        @Override // eu.bolt.verification.sdk.internal.v9
        public void a(Throwable error) {
            Intrinsics.f(error, "error");
        }

        @Override // eu.bolt.verification.sdk.internal.v9
        public void b(Drawable image) {
            Intrinsics.f(image, "image");
        }
    }

    void a(Throwable th);

    void b(Drawable drawable);
}
