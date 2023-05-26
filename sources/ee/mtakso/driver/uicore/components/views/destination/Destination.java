package ee.mtakso.driver.uicore.components.views.destination;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Destination.kt */
/* loaded from: classes5.dex */
public final class Destination {

    /* renamed from: d  reason: collision with root package name */
    public static final Companion f35575d = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final int f35576a;

    /* renamed from: b  reason: collision with root package name */
    private final StopType f35577b;

    /* renamed from: c  reason: collision with root package name */
    private final String f35578c;

    /* compiled from: Destination.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: Destination.kt */
    /* loaded from: classes5.dex */
    public enum StopType {
        DESTINATION_ONLY,
        DESTINATION,
        NEXT_STOP,
        COMMON
    }

    public final String a() {
        return this.f35578c;
    }

    public final int b() {
        return this.f35576a;
    }

    public final StopType c() {
        return this.f35577b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Destination) {
            Destination destination = (Destination) obj;
            return this.f35576a == destination.f35576a && this.f35577b == destination.f35577b && Intrinsics.a(this.f35578c, destination.f35578c);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((this.f35576a * 31) + this.f35577b.hashCode()) * 31;
        String str = this.f35578c;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        int i8 = this.f35576a;
        StopType stopType = this.f35577b;
        String str = this.f35578c;
        return "Destination(id=" + i8 + ", type=" + stopType + ", address=" + str + ")";
    }
}
