package kotlin;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UShort.kt */
/* loaded from: classes5.dex */
public final class UShort implements Comparable<UShort> {

    /* renamed from: g  reason: collision with root package name */
    public static final Companion f50848g = new Companion(null);

    /* renamed from: f  reason: collision with root package name */
    private final short f50849f;

    /* compiled from: UShort.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private /* synthetic */ UShort(short s7) {
        this.f50849f = s7;
    }

    public static final /* synthetic */ UShort a(short s7) {
        return new UShort(s7);
    }

    public static short c(short s7) {
        return s7;
    }

    public static boolean e(short s7, Object obj) {
        return (obj instanceof UShort) && s7 == ((UShort) obj).j();
    }

    public static int f(short s7) {
        return s7;
    }

    public static String h(short s7) {
        return String.valueOf(s7 & 65535);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(UShort uShort) {
        return Intrinsics.h(j() & 65535, uShort.j() & 65535);
    }

    public boolean equals(Object obj) {
        return e(this.f50849f, obj);
    }

    public int hashCode() {
        return f(this.f50849f);
    }

    public final /* synthetic */ short j() {
        return this.f50849f;
    }

    public String toString() {
        return h(this.f50849f);
    }
}
