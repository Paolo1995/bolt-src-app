package kotlin;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* compiled from: KotlinVersion.kt */
/* loaded from: classes5.dex */
public final class KotlinVersion implements Comparable<KotlinVersion> {

    /* renamed from: j  reason: collision with root package name */
    public static final Companion f50804j = new Companion(null);

    /* renamed from: k  reason: collision with root package name */
    public static final KotlinVersion f50805k = KotlinVersionCurrentValue.a();

    /* renamed from: f  reason: collision with root package name */
    private final int f50806f;

    /* renamed from: g  reason: collision with root package name */
    private final int f50807g;

    /* renamed from: h  reason: collision with root package name */
    private final int f50808h;

    /* renamed from: i  reason: collision with root package name */
    private final int f50809i;

    /* compiled from: KotlinVersion.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public KotlinVersion(int i8, int i9, int i10) {
        this.f50806f = i8;
        this.f50807g = i9;
        this.f50808h = i10;
        this.f50809i = c(i8, i9, i10);
    }

    private final int c(int i8, int i9, int i10) {
        boolean z7 = false;
        if (new IntRange(0, 255).o(i8) && new IntRange(0, 255).o(i9) && new IntRange(0, 255).o(i10)) {
            z7 = true;
        }
        if (z7) {
            return (i8 << 16) + (i9 << 8) + i10;
        }
        throw new IllegalArgumentException(("Version components are out of range: " + i8 + '.' + i9 + '.' + i10).toString());
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(KotlinVersion other) {
        Intrinsics.f(other, "other");
        return this.f50809i - other.f50809i;
    }

    public boolean equals(Object obj) {
        KotlinVersion kotlinVersion;
        if (this == obj) {
            return true;
        }
        if (obj instanceof KotlinVersion) {
            kotlinVersion = (KotlinVersion) obj;
        } else {
            kotlinVersion = null;
        }
        if (kotlinVersion != null && this.f50809i == kotlinVersion.f50809i) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f50809i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f50806f);
        sb.append('.');
        sb.append(this.f50807g);
        sb.append('.');
        sb.append(this.f50808h);
        return sb.toString();
    }
}
