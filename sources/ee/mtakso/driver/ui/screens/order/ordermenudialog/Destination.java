package ee.mtakso.driver.ui.screens.order.ordermenudialog;

import i0.a;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Destination.kt */
/* loaded from: classes3.dex */
public final class Destination {

    /* renamed from: d  reason: collision with root package name */
    public static final Companion f31524d = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final long f31525a;

    /* renamed from: b  reason: collision with root package name */
    private final StopType f31526b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f31527c;

    /* compiled from: Destination.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final StopType a(int i8, int i9) {
            if (i9 == 1) {
                return StopType.DESTINATION_ONLY;
            }
            if (i8 == 0) {
                return StopType.NEXT_STOP;
            }
            if (i8 == i9 - 1) {
                return StopType.DESTINATION;
            }
            return StopType.COMMON;
        }
    }

    /* compiled from: Destination.kt */
    /* loaded from: classes3.dex */
    public enum StopType {
        DESTINATION_ONLY,
        DESTINATION,
        NEXT_STOP,
        COMMON
    }

    public Destination(long j8, StopType type, boolean z7) {
        Intrinsics.f(type, "type");
        this.f31525a = j8;
        this.f31526b = type;
        this.f31527c = z7;
    }

    public final boolean a() {
        return this.f31527c;
    }

    public final long b() {
        return this.f31525a;
    }

    public final StopType c() {
        return this.f31526b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Destination) {
            Destination destination = (Destination) obj;
            return this.f31525a == destination.f31525a && this.f31526b == destination.f31526b && this.f31527c == destination.f31527c;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int a8 = ((a.a(this.f31525a) * 31) + this.f31526b.hashCode()) * 31;
        boolean z7 = this.f31527c;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        return a8 + i8;
    }

    public String toString() {
        long j8 = this.f31525a;
        StopType stopType = this.f31526b;
        boolean z7 = this.f31527c;
        return "Destination(id=" + j8 + ", type=" + stopType + ", hasDestinationAddress=" + z7 + ")";
    }
}
