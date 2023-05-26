package androidx.core.provider;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.util.Preconditions;

/* loaded from: classes.dex */
public class FontsContractCompat {

    /* loaded from: classes.dex */
    public static class FontFamilyResult {

        /* renamed from: a  reason: collision with root package name */
        private final int f5848a;

        /* renamed from: b  reason: collision with root package name */
        private final FontInfo[] f5849b;

        @Deprecated
        public FontFamilyResult(int i8, FontInfo[] fontInfoArr) {
            this.f5848a = i8;
            this.f5849b = fontInfoArr;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static FontFamilyResult a(int i8, FontInfo[] fontInfoArr) {
            return new FontFamilyResult(i8, fontInfoArr);
        }

        public FontInfo[] b() {
            return this.f5849b;
        }

        public int c() {
            return this.f5848a;
        }
    }

    /* loaded from: classes.dex */
    public static class FontInfo {

        /* renamed from: a  reason: collision with root package name */
        private final Uri f5850a;

        /* renamed from: b  reason: collision with root package name */
        private final int f5851b;

        /* renamed from: c  reason: collision with root package name */
        private final int f5852c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f5853d;

        /* renamed from: e  reason: collision with root package name */
        private final int f5854e;

        @Deprecated
        public FontInfo(@NonNull Uri uri, int i8, int i9, boolean z7, int i10) {
            this.f5850a = (Uri) Preconditions.g(uri);
            this.f5851b = i8;
            this.f5852c = i9;
            this.f5853d = z7;
            this.f5854e = i10;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static FontInfo a(@NonNull Uri uri, int i8, int i9, boolean z7, int i10) {
            return new FontInfo(uri, i8, i9, z7, i10);
        }

        public int b() {
            return this.f5854e;
        }

        public int c() {
            return this.f5851b;
        }

        @NonNull
        public Uri d() {
            return this.f5850a;
        }

        public int e() {
            return this.f5852c;
        }

        public boolean f() {
            return this.f5853d;
        }
    }

    /* loaded from: classes.dex */
    public static class FontRequestCallback {
        public void a(int i8) {
        }

        public void b(Typeface typeface) {
        }
    }

    private FontsContractCompat() {
    }

    public static Typeface a(@NonNull Context context, CancellationSignal cancellationSignal, @NonNull FontInfo[] fontInfoArr) {
        return TypefaceCompat.b(context, cancellationSignal, fontInfoArr, 0);
    }

    @NonNull
    public static FontFamilyResult b(@NonNull Context context, CancellationSignal cancellationSignal, @NonNull FontRequest fontRequest) throws PackageManager.NameNotFoundException {
        return FontProvider.e(context, fontRequest, cancellationSignal);
    }

    public static Typeface c(@NonNull Context context, @NonNull FontRequest fontRequest, int i8, boolean z7, int i9, @NonNull Handler handler, @NonNull FontRequestCallback fontRequestCallback) {
        CallbackWithHandler callbackWithHandler = new CallbackWithHandler(fontRequestCallback, handler);
        if (z7) {
            return FontRequestWorker.e(context, fontRequest, callbackWithHandler, i8, i9);
        }
        return FontRequestWorker.d(context, fontRequest, i8, null, callbackWithHandler);
    }
}
