package androidx.core.provider;

import android.graphics.Typeface;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.core.provider.FontRequestWorker;
import androidx.core.provider.FontsContractCompat;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class CallbackWithHandler {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final FontsContractCompat.FontRequestCallback f5817a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final Handler f5818b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CallbackWithHandler(@NonNull FontsContractCompat.FontRequestCallback fontRequestCallback, @NonNull Handler handler) {
        this.f5817a = fontRequestCallback;
        this.f5818b = handler;
    }

    private void a(final int i8) {
        final FontsContractCompat.FontRequestCallback fontRequestCallback = this.f5817a;
        this.f5818b.post(new Runnable() { // from class: androidx.core.provider.CallbackWithHandler.2
            @Override // java.lang.Runnable
            public void run() {
                fontRequestCallback.a(i8);
            }
        });
    }

    private void c(@NonNull final Typeface typeface) {
        final FontsContractCompat.FontRequestCallback fontRequestCallback = this.f5817a;
        this.f5818b.post(new Runnable() { // from class: androidx.core.provider.CallbackWithHandler.1
            @Override // java.lang.Runnable
            public void run() {
                fontRequestCallback.b(typeface);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(@NonNull FontRequestWorker.TypefaceResult typefaceResult) {
        if (typefaceResult.a()) {
            c(typefaceResult.f5846a);
        } else {
            a(typefaceResult.f5847b);
        }
    }
}
