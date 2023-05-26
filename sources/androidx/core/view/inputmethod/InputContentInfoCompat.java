package androidx.core.view.inputmethod;

import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.view.inputmethod.InputContentInfo;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public final class InputContentInfoCompat {

    /* renamed from: a  reason: collision with root package name */
    private final InputContentInfoCompatImpl f6078a;

    /* loaded from: classes.dex */
    private static final class InputContentInfoCompatBaseImpl implements InputContentInfoCompatImpl {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        private final Uri f6080a;
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        private final ClipDescription f6081b;

        /* renamed from: c  reason: collision with root package name */
        private final Uri f6082c;

        InputContentInfoCompatBaseImpl(@NonNull Uri uri, @NonNull ClipDescription clipDescription, Uri uri2) {
            this.f6080a = uri;
            this.f6081b = clipDescription;
            this.f6082c = uri2;
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public void a() {
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public Object b() {
            return null;
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        @NonNull
        public Uri c() {
            return this.f6080a;
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public Uri d() {
            return this.f6082c;
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        @NonNull
        public ClipDescription e() {
            return this.f6081b;
        }
    }

    /* loaded from: classes.dex */
    private interface InputContentInfoCompatImpl {
        void a();

        Object b();

        @NonNull
        Uri c();

        Uri d();

        @NonNull
        ClipDescription e();
    }

    public InputContentInfoCompat(@NonNull Uri uri, @NonNull ClipDescription clipDescription, Uri uri2) {
        if (Build.VERSION.SDK_INT >= 25) {
            this.f6078a = new InputContentInfoCompatApi25Impl(uri, clipDescription, uri2);
        } else {
            this.f6078a = new InputContentInfoCompatBaseImpl(uri, clipDescription, uri2);
        }
    }

    public static InputContentInfoCompat f(Object obj) {
        if (obj == null || Build.VERSION.SDK_INT < 25) {
            return null;
        }
        return new InputContentInfoCompat(new InputContentInfoCompatApi25Impl(obj));
    }

    @NonNull
    public Uri a() {
        return this.f6078a.c();
    }

    @NonNull
    public ClipDescription b() {
        return this.f6078a.e();
    }

    public Uri c() {
        return this.f6078a.d();
    }

    public void d() {
        this.f6078a.a();
    }

    public Object e() {
        return this.f6078a.b();
    }

    /* loaded from: classes.dex */
    private static final class InputContentInfoCompatApi25Impl implements InputContentInfoCompatImpl {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        final InputContentInfo f6079a;

        InputContentInfoCompatApi25Impl(@NonNull Object obj) {
            this.f6079a = (InputContentInfo) obj;
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public void a() {
            this.f6079a.requestPermission();
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        @NonNull
        public Object b() {
            return this.f6079a;
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        @NonNull
        public Uri c() {
            return this.f6079a.getContentUri();
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public Uri d() {
            return this.f6079a.getLinkUri();
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        @NonNull
        public ClipDescription e() {
            return this.f6079a.getDescription();
        }

        InputContentInfoCompatApi25Impl(@NonNull Uri uri, @NonNull ClipDescription clipDescription, Uri uri2) {
            this.f6079a = new InputContentInfo(uri, clipDescription, uri2);
        }
    }

    private InputContentInfoCompat(@NonNull InputContentInfoCompatImpl inputContentInfoCompatImpl) {
        this.f6078a = inputContentInfoCompatImpl;
    }
}
