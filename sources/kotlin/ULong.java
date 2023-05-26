package kotlin;

import i0.a;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ULong.kt */
/* loaded from: classes5.dex */
public final class ULong implements Comparable<ULong> {

    /* renamed from: g  reason: collision with root package name */
    public static final Companion f50842g = new Companion(null);

    /* renamed from: f  reason: collision with root package name */
    private final long f50843f;

    /* compiled from: ULong.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private /* synthetic */ ULong(long j8) {
        this.f50843f = j8;
    }

    public static final /* synthetic */ ULong a(long j8) {
        return new ULong(j8);
    }

    public static long c(long j8) {
        return j8;
    }

    public static boolean e(long j8, Object obj) {
        return (obj instanceof ULong) && j8 == ((ULong) obj).j();
    }

    public static int f(long j8) {
        return a.a(j8);
    }

    public static String h(long j8) {
        return UnsignedKt.c(j8);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(ULong uLong) {
        return UnsignedKt.b(j(), uLong.j());
    }

    public boolean equals(Object obj) {
        return e(this.f50843f, obj);
    }

    public int hashCode() {
        return f(this.f50843f);
    }

    public final /* synthetic */ long j() {
        return this.f50843f;
    }

    public String toString() {
        return h(this.f50843f);
    }
}
