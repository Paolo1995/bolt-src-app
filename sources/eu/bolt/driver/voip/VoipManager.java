package eu.bolt.driver.voip;

import ee.mtakso.voip_client.VoipClientFactory;
import ee.mtakso.voip_client.VoipLogger;
import ee.mtakso.voip_client.VoipPushServiceType;
import eu.bolt.driver.core.permission.PermissionManager;
import eu.bolt.driver.core.service.BaseService;
import eu.bolt.driver.voip.service.call.log.CallLoggerService;
import eu.bolt.driver.voip.service.call.tone.ToneManager;
import eu.bolt.driver.voip.service.call.tone.ToneService;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VoipManager.kt */
/* loaded from: classes5.dex */
public final class VoipManager {

    /* renamed from: a  reason: collision with root package name */
    private final VoipClientFactory f41609a;

    /* renamed from: b  reason: collision with root package name */
    private final PermissionManager f41610b;

    /* renamed from: c  reason: collision with root package name */
    private final VoipLogger f41611c;

    /* renamed from: d  reason: collision with root package name */
    private VoipSession f41612d;

    /* renamed from: e  reason: collision with root package name */
    private Set<? extends BaseService> f41613e;

    /* compiled from: VoipManager.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f41614a;

        static {
            int[] iArr = new int[PushServiceType.values().length];
            try {
                iArr[PushServiceType.GMS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PushServiceType.HMS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f41614a = iArr;
        }
    }

    public VoipManager(VoipClientFactory clientFactory, PermissionManager permissionManager, VoipLogger logger) {
        Set<? extends BaseService> b8;
        Intrinsics.f(clientFactory, "clientFactory");
        Intrinsics.f(permissionManager, "permissionManager");
        Intrinsics.f(logger, "logger");
        this.f41609a = clientFactory;
        this.f41610b = permissionManager;
        this.f41611c = logger;
        b8 = SetsKt__SetsKt.b();
        this.f41613e = b8;
    }

    public final VoipSession a(VoipUserConfig user) {
        VoipPushServiceType voipPushServiceType;
        Set<? extends BaseService> f8;
        Intrinsics.f(user, "user");
        VoipLogger voipLogger = this.f41611c;
        voipLogger.c("Creating user session... " + user, new Object[0]);
        int i8 = WhenMappings.f41614a[user.c().ordinal()];
        if (i8 != 1) {
            if (i8 == 2) {
                voipPushServiceType = VoipPushServiceType.HMS;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else {
            voipPushServiceType = VoipPushServiceType.GMS;
        }
        VoipSession voipSession = new VoipSession(this.f41609a.a(user.e(), user.a(), user.d(), voipPushServiceType, user.b()), this.f41610b, this.f41611c);
        f8 = SetsKt__SetsKt.f(new CallLoggerService(voipSession, this.f41611c), new ToneService(voipSession, new ToneManager()));
        this.f41613e = f8;
        for (BaseService baseService : f8) {
            VoipLogger voipLogger2 = this.f41611c;
            voipLogger2.c("Starting " + baseService, new Object[0]);
            baseService.start();
        }
        this.f41612d = voipSession;
        return voipSession;
    }

    public final VoipSession b() {
        return this.f41612d;
    }

    public final void c() {
        Set<? extends BaseService> b8;
        this.f41611c.c("Terminating user session...", new Object[0]);
        for (BaseService baseService : this.f41613e) {
            VoipLogger voipLogger = this.f41611c;
            voipLogger.c("Stopping " + baseService, new Object[0]);
            baseService.stop();
        }
        b8 = SetsKt__SetsKt.b();
        this.f41613e = b8;
        VoipSession voipSession = this.f41612d;
        if (voipSession != null) {
            voipSession.close();
        }
        this.f41612d = null;
    }
}
