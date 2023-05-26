package kotlin;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UByte.kt */
/* loaded from: classes5.dex */
public final class UByte implements Comparable<UByte> {

    /* renamed from: g  reason: collision with root package name */
    public static final Companion f50832g = new Companion(null);

    /* renamed from: f  reason: collision with root package name */
    private final byte f50833f;

    /* compiled from: UByte.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private /* synthetic */ UByte(byte b8) {
        this.f50833f = b8;
    }

    public static final /* synthetic */ UByte a(byte b8) {
        return new UByte(b8);
    }

    public static byte c(byte b8) {
        return b8;
    }

    public static boolean e(byte b8, Object obj) {
        return (obj instanceof UByte) && b8 == ((UByte) obj).j();
    }

    public static int f(byte b8) {
        return b8;
    }

    public static String h(byte b8) {
        return String.valueOf(b8 & 255);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(UByte uByte) {
        return Intrinsics.h(j() & 255, uByte.j() & 255);
    }

    public boolean equals(Object obj) {
        return e(this.f50833f, obj);
    }

    public int hashCode() {
        return f(this.f50833f);
    }

    public final /* synthetic */ byte j() {
        return this.f50833f;
    }

    public String toString() {
        return h(this.f50833f);
    }
}
