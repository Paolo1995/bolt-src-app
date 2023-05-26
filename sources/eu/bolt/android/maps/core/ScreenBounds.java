package eu.bolt.android.maps.core;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ScreenBounds.kt */
/* loaded from: classes5.dex */
public final class ScreenBounds {

    /* renamed from: a  reason: collision with root package name */
    private final int f36946a;

    /* renamed from: b  reason: collision with root package name */
    private final int f36947b;

    /* renamed from: c  reason: collision with root package name */
    private final int f36948c;

    /* renamed from: d  reason: collision with root package name */
    private final int f36949d;

    public ScreenBounds() {
        this(0, 0, 0, 0, 15, null);
    }

    public ScreenBounds(int i8, int i9, int i10, int i11) {
        this.f36946a = i8;
        this.f36947b = i9;
        this.f36948c = i10;
        this.f36949d = i11;
    }

    public static /* synthetic */ ScreenBounds b(ScreenBounds screenBounds, int i8, int i9, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i8 = screenBounds.f36946a;
        }
        if ((i12 & 2) != 0) {
            i9 = screenBounds.f36947b;
        }
        if ((i12 & 4) != 0) {
            i10 = screenBounds.f36948c;
        }
        if ((i12 & 8) != 0) {
            i11 = screenBounds.f36949d;
        }
        return screenBounds.a(i8, i9, i10, i11);
    }

    public final ScreenBounds a(int i8, int i9, int i10, int i11) {
        return new ScreenBounds(i8, i9, i10, i11);
    }

    public final int c() {
        return this.f36949d;
    }

    public final int d() {
        return this.f36946a;
    }

    public final int e() {
        return this.f36948c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ScreenBounds) {
            ScreenBounds screenBounds = (ScreenBounds) obj;
            return this.f36946a == screenBounds.f36946a && this.f36947b == screenBounds.f36947b && this.f36948c == screenBounds.f36948c && this.f36949d == screenBounds.f36949d;
        }
        return false;
    }

    public final int f() {
        return this.f36947b;
    }

    public int hashCode() {
        return (((((this.f36946a * 31) + this.f36947b) * 31) + this.f36948c) * 31) + this.f36949d;
    }

    public String toString() {
        return "ScreenBounds(left=" + this.f36946a + ", top=" + this.f36947b + ", right=" + this.f36948c + ", bottom=" + this.f36949d + ')';
    }

    public /* synthetic */ ScreenBounds(int i8, int i9, int i10, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? 0 : i8, (i12 & 2) != 0 ? 0 : i9, (i12 & 4) != 0 ? 0 : i10, (i12 & 8) != 0 ? 0 : i11);
    }
}
