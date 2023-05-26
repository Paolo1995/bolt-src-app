package ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers;

import ee.mtakso.driver.deeplink.DeeplinkCall;
import ee.mtakso.driver.utils.UrlFactory;
import ee.mtakso.driver.utils.urlcomand.DriverPortalUrlRoutingCommand;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverPortalDeeplinkMapper.kt */
/* loaded from: classes3.dex */
public final class DriverPortalDeeplinkMapper {

    /* renamed from: a  reason: collision with root package name */
    private final UrlFactory f29979a;

    @Inject
    public DriverPortalDeeplinkMapper(UrlFactory urlFactory) {
        Intrinsics.f(urlFactory, "urlFactory");
        this.f29979a = urlFactory;
    }

    public DriverPortalUrlRoutingCommand a(DeeplinkCall.DriverPortal deeplink) {
        Intrinsics.f(deeplink, "deeplink");
        return new DriverPortalUrlRoutingCommand(this.f29979a.d(deeplink.b(), "deeplink"), null, 2, null);
    }
}
