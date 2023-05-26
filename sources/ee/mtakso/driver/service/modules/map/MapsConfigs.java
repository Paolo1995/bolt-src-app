package ee.mtakso.driver.service.modules.map;

import ee.mtakso.driver.network.client.driver.DriverMapsConfigs;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MapsConfigs.kt */
/* loaded from: classes3.dex */
public final class MapsConfigs {

    /* renamed from: a  reason: collision with root package name */
    private final DriverMapsConfigs f24847a;

    public MapsConfigs(DriverMapsConfigs config) {
        Intrinsics.f(config, "config");
        this.f24847a = config;
    }

    public final DriverMapsConfigs a() {
        return this.f24847a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof MapsConfigs) && Intrinsics.a(this.f24847a, ((MapsConfigs) obj).f24847a);
    }

    public int hashCode() {
        return this.f24847a.hashCode();
    }

    public String toString() {
        DriverMapsConfigs driverMapsConfigs = this.f24847a;
        return "MapsConfigs(config=" + driverMapsConfigs + ")";
    }
}
