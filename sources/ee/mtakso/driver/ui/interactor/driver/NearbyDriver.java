package ee.mtakso.driver.ui.interactor.driver;

import eu.bolt.android.maps.core.Locatable;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NearbyDriversInteractor.kt */
/* loaded from: classes3.dex */
public final class NearbyDriver {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f26503a;

    /* renamed from: b  reason: collision with root package name */
    private final Locatable f26504b;

    /* renamed from: c  reason: collision with root package name */
    private final double f26505c;

    public NearbyDriver(boolean z7, Locatable position, double d8) {
        Intrinsics.f(position, "position");
        this.f26503a = z7;
        this.f26504b = position;
        this.f26505c = d8;
    }

    public final double a() {
        return this.f26505c;
    }

    public final Locatable b() {
        return this.f26504b;
    }

    public final boolean c() {
        return this.f26503a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof NearbyDriver) {
            NearbyDriver nearbyDriver = (NearbyDriver) obj;
            return this.f26503a == nearbyDriver.f26503a && Intrinsics.a(this.f26504b, nearbyDriver.f26504b) && Double.compare(this.f26505c, nearbyDriver.f26505c) == 0;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z7 = this.f26503a;
        ?? r02 = z7;
        if (z7) {
            r02 = 1;
        }
        return (((r02 * 31) + this.f26504b.hashCode()) * 31) + q1.a.a(this.f26505c);
    }

    public String toString() {
        boolean z7 = this.f26503a;
        Locatable locatable = this.f26504b;
        double d8 = this.f26505c;
        return "NearbyDriver(isSameFleet=" + z7 + ", position=" + locatable + ", bearing=" + d8 + ")";
    }
}
