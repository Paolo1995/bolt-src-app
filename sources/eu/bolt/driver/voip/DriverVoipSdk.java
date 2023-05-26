package eu.bolt.driver.voip;

import android.content.Context;
import ee.mtakso.voip_client.VoipClientFactory;
import ee.mtakso.voip_client.VoipLogger;
import eu.bolt.driver.core.permission.PermissionManager;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverVoipSdk.kt */
/* loaded from: classes5.dex */
public final class DriverVoipSdk {

    /* renamed from: a  reason: collision with root package name */
    public static final DriverVoipSdk f41604a = new DriverVoipSdk();

    /* renamed from: b  reason: collision with root package name */
    private static volatile VoipManager f41605b;

    private DriverVoipSdk() {
    }

    public final synchronized VoipManager a(Context context, PermissionManager permissionManager, VoipLogger logger) {
        Intrinsics.f(context, "context");
        Intrinsics.f(permissionManager, "permissionManager");
        Intrinsics.f(logger, "logger");
        VoipManager voipManager = f41605b;
        if (voipManager != null) {
            return voipManager;
        }
        VoipManager voipManager2 = new VoipManager(new VoipClientFactory(context, logger), permissionManager, logger);
        f41605b = voipManager2;
        return voipManager2;
    }

    public final synchronized VoipManager b() {
        VoipManager voipManager;
        voipManager = f41605b;
        if (voipManager == null) {
            throw new IllegalStateException("VoIP Manager is not initialized yet. Call createVoipManager to initialize it".toString());
        }
        return voipManager;
    }
}
