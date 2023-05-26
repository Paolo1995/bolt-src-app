package ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers;

import ee.mtakso.driver.deeplink.DeeplinkCall;
import ee.mtakso.driver.utils.UrlFactory;
import ee.mtakso.driver.utils.urlcomand.DriverPortalUrlRoutingCommand;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverPortalRootDeeplinkMapper.kt */
/* loaded from: classes3.dex */
public final class DriverPortalRootDeeplinkMapper {

    /* renamed from: a  reason: collision with root package name */
    private final UrlFactory f29980a;

    @Inject
    public DriverPortalRootDeeplinkMapper(UrlFactory urlFactory) {
        Intrinsics.f(urlFactory, "urlFactory");
        this.f29980a = urlFactory;
    }

    public DriverPortalUrlRoutingCommand a(DeeplinkCall.DriverPortalRoot deeplink) {
        Intrinsics.f(deeplink, "deeplink");
        return new DriverPortalUrlRoutingCommand(this.f29980a.i(), null, 2, null);
    }
}
