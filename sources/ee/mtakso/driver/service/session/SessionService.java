package ee.mtakso.driver.service.session;

import ee.mtakso.driver.param.DriverConfig;
import ee.mtakso.driver.service.BaseService;
import java.util.Arrays;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: SessionService.kt */
/* loaded from: classes3.dex */
public final class SessionService implements BaseService {

    /* renamed from: a  reason: collision with root package name */
    private final SessionProvider f25921a;

    /* renamed from: b  reason: collision with root package name */
    private final DriverConfig f25922b;

    @Inject
    public SessionService(SessionProvider sessionProvider, DriverConfig driver) {
        Intrinsics.f(sessionProvider, "sessionProvider");
        Intrinsics.f(driver, "driver");
        this.f25921a = sessionProvider;
        this.f25922b = driver;
    }

    @Override // ee.mtakso.driver.service.BaseService
    public boolean start() {
        SessionProvider sessionProvider = this.f25921a;
        StringCompanionObject stringCompanionObject = StringCompanionObject.f51021a;
        String format = String.format("%d", Arrays.copyOf(new Object[]{Long.valueOf(this.f25922b.t())}, 1));
        Intrinsics.e(format, "format(format, *args)");
        sessionProvider.i(format);
        this.f25921a.h();
        return true;
    }

    @Override // ee.mtakso.driver.service.BaseService
    public void stop() {
        this.f25921a.i(null);
        this.f25921a.h();
    }
}
