package androidx.core.graphics;

import android.graphics.Rect;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public final class Insets {
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public static final Insets f5736e = new Insets(0, 0, 0, 0);

    /* renamed from: a  reason: collision with root package name */
    public final int f5737a;

    /* renamed from: b  reason: collision with root package name */
    public final int f5738b;

    /* renamed from: c  reason: collision with root package name */
    public final int f5739c;

    /* renamed from: d  reason: collision with root package name */
    public final int f5740d;

    /* loaded from: classes.dex */
    static class Api29Impl {
        private Api29Impl() {
        }

        static android.graphics.Insets a(int i8, int i9, int i10, int i11) {
            return android.graphics.Insets.of(i8, i9, i10, i11);
        }
    }

    private Insets(int i8, int i9, int i10, int i11) {
        this.f5737a = i8;
        this.f5738b = i9;
        this.f5739c = i10;
        this.f5740d = i11;
    }

    @NonNull
    public static Insets a(@NonNull Insets insets, @NonNull Insets insets2) {
        return b(Math.max(insets.f5737a, insets2.f5737a), Math.max(insets.f5738b, insets2.f5738b), Math.max(insets.f5739c, insets2.f5739c), Math.max(insets.f5740d, insets2.f5740d));
    }

    @NonNull
    public static Insets b(int i8, int i9, int i10, int i11) {
        if (i8 == 0 && i9 == 0 && i10 == 0 && i11 == 0) {
            return f5736e;
        }
        return new Insets(i8, i9, i10, i11);
    }

    @NonNull
    public static Insets c(@NonNull Rect rect) {
        return b(rect.left, rect.top, rect.right, rect.bottom);
    }

    @NonNull
    public static Insets d(@NonNull android.graphics.Insets insets) {
        return b(insets.left, insets.top, insets.right, insets.bottom);
    }

    @NonNull
    public android.graphics.Insets e() {
        return Api29Impl.a(this.f5737a, this.f5738b, this.f5739c, this.f5740d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Insets.class != obj.getClass()) {
            return false;
        }
        Insets insets = (Insets) obj;
        if (this.f5740d == insets.f5740d && this.f5737a == insets.f5737a && this.f5739c == insets.f5739c && this.f5738b == insets.f5738b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.f5737a * 31) + this.f5738b) * 31) + this.f5739c) * 31) + this.f5740d;
    }

    @NonNull
    public String toString() {
        return "Insets{left=" + this.f5737a + ", top=" + this.f5738b + ", right=" + this.f5739c + ", bottom=" + this.f5740d + '}';
    }
}
