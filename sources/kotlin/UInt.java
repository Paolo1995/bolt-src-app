package kotlin;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: UInt.kt */
/* loaded from: classes5.dex */
public final class UInt implements Comparable<UInt> {

    /* renamed from: g  reason: collision with root package name */
    public static final Companion f50837g = new Companion(null);

    /* renamed from: f  reason: collision with root package name */
    private final int f50838f;

    /* compiled from: UInt.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private /* synthetic */ UInt(int i8) {
        this.f50838f = i8;
    }

    public static final /* synthetic */ UInt a(int i8) {
        return new UInt(i8);
    }

    public static int c(int i8) {
        return i8;
    }

    public static boolean e(int i8, Object obj) {
        return (obj instanceof UInt) && i8 == ((UInt) obj).j();
    }

    public static int f(int i8) {
        return i8;
    }

    public static String h(int i8) {
        return String.valueOf(i8 & 4294967295L);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(UInt uInt) {
        return UnsignedKt.a(j(), uInt.j());
    }

    public boolean equals(Object obj) {
        return e(this.f50838f, obj);
    }

    public int hashCode() {
        return f(this.f50838f);
    }

    public final /* synthetic */ int j() {
        return this.f50838f;
    }

    public String toString() {
        return h(this.f50838f);
    }
}
