package ee.mtakso.driver.utils;

import ee.mtakso.driver.param.DeviceSettings;
import java.util.UUID;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeviceUuidManager.kt */
@Singleton
/* loaded from: classes5.dex */
public final class DeviceUuidManager {

    /* renamed from: a  reason: collision with root package name */
    private final DeviceSettings f36304a;

    @Inject
    public DeviceUuidManager(DeviceSettings deviceSettings) {
        Intrinsics.f(deviceSettings, "deviceSettings");
        this.f36304a = deviceSettings;
    }

    private final String a() {
        synchronized (this) {
            if (this.f36304a.c().a() == null) {
                this.f36304a.c().b(UUID.randomUUID().toString());
            }
            Unit unit = Unit.f50853a;
        }
        String a8 = this.f36304a.c().a();
        AssertUtils.c(a8, "UUID is null");
        Intrinsics.c(a8);
        return a8;
    }

    public final String b() {
        return a();
    }
}
