package ee.mtakso.driver.uikit.utils;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Margins.kt */
/* loaded from: classes5.dex */
public final class Margins {

    /* renamed from: a  reason: collision with root package name */
    private final int f36048a;

    /* renamed from: b  reason: collision with root package name */
    private final int f36049b;

    /* renamed from: c  reason: collision with root package name */
    private final int f36050c;

    /* renamed from: d  reason: collision with root package name */
    private final int f36051d;

    public Margins() {
        this(0, 0, 0, 0, 15, null);
    }

    public Margins(int i8, int i9, int i10, int i11) {
        this.f36048a = i8;
        this.f36049b = i9;
        this.f36050c = i10;
        this.f36051d = i11;
    }

    public final int a() {
        return this.f36051d;
    }

    public final int b() {
        return this.f36048a;
    }

    public final int c() {
        return this.f36050c;
    }

    public final int d() {
        return this.f36049b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Margins) {
            Margins margins = (Margins) obj;
            return this.f36048a == margins.f36048a && this.f36049b == margins.f36049b && this.f36050c == margins.f36050c && this.f36051d == margins.f36051d;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.f36048a * 31) + this.f36049b) * 31) + this.f36050c) * 31) + this.f36051d;
    }

    public String toString() {
        int i8 = this.f36048a;
        int i9 = this.f36049b;
        int i10 = this.f36050c;
        int i11 = this.f36051d;
        return "Margins(left=" + i8 + ", top=" + i9 + ", right=" + i10 + ", bottom=" + i11 + ")";
    }

    public /* synthetic */ Margins(int i8, int i9, int i10, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? 0 : i8, (i12 & 2) != 0 ? 0 : i9, (i12 & 4) != 0 ? 0 : i10, (i12 & 8) != 0 ? 0 : i11);
    }
}
