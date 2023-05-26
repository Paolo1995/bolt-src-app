package ee.mtakso.driver.service.auth;

import ee.mtakso.driver.service.BaseService;
import eu.bolt.kalev.Kalev;
import eu.bolt.kalev.fast.FastLog;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AuthorisedServicesRunner.kt */
/* loaded from: classes3.dex */
public final class AuthorisedServicesRunner implements BaseService {

    /* renamed from: a  reason: collision with root package name */
    private final Set<BaseService> f23700a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f23701b;

    @Inject
    public AuthorisedServicesRunner(Set<BaseService> services) {
        Intrinsics.f(services, "services");
        this.f23700a = services;
    }

    @Override // ee.mtakso.driver.service.BaseService
    public boolean start() {
        synchronized (Boolean.valueOf(this.f23701b)) {
            if (this.f23701b) {
                return false;
            }
            for (BaseService baseService : this.f23700a) {
                FastLog g8 = Kalev.f41674e.g();
                if (g8 != null) {
                    String simpleName = baseService.getClass().getSimpleName();
                    FastLog.DefaultImpls.c(g8, "Starting " + simpleName, null, 2, null);
                }
                baseService.start();
            }
            this.f23701b = true;
            return true;
        }
    }

    @Override // ee.mtakso.driver.service.BaseService
    public void stop() {
        synchronized (Boolean.valueOf(this.f23701b)) {
            for (BaseService baseService : this.f23700a) {
                FastLog g8 = Kalev.f41674e.g();
                if (g8 != null) {
                    String simpleName = baseService.getClass().getSimpleName();
                    FastLog.DefaultImpls.c(g8, "Stopping " + simpleName, null, 2, null);
                }
                baseService.stop();
            }
            this.f23701b = false;
            Unit unit = Unit.f50853a;
        }
    }
}
