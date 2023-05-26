package ee.mtakso.driver.service.integration.mixpanel;

import ee.mtakso.driver.service.BaseService;
import ee.mtakso.driver.service.analytics.controller.MixpanelController;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MixpanelService.kt */
/* loaded from: classes3.dex */
public final class MixpanelService implements BaseService {

    /* renamed from: a  reason: collision with root package name */
    private final MixpanelController f24579a;

    @Inject
    public MixpanelService(MixpanelController mixpanelController) {
        Intrinsics.f(mixpanelController, "mixpanelController");
        this.f24579a = mixpanelController;
    }

    @Override // ee.mtakso.driver.service.BaseService
    public boolean start() {
        this.f24579a.d();
        this.f24579a.a();
        return true;
    }

    @Override // ee.mtakso.driver.service.BaseService
    public void stop() {
        this.f24579a.c();
    }
}
