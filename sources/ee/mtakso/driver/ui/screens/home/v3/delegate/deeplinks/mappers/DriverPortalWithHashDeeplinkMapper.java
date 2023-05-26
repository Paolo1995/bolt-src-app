package ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers;

import ee.mtakso.driver.deeplink.DeeplinkCall;
import ee.mtakso.driver.utils.UrlFactory;
import ee.mtakso.driver.utils.urlcomand.DriverPortalUrlRoutingCommand;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverPortalWithHashDeeplinkMapper.kt */
/* loaded from: classes3.dex */
public final class DriverPortalWithHashDeeplinkMapper {

    /* renamed from: a  reason: collision with root package name */
    private final UrlFactory f29981a;

    @Inject
    public DriverPortalWithHashDeeplinkMapper(UrlFactory urlFactory) {
        Intrinsics.f(urlFactory, "urlFactory");
        this.f29981a = urlFactory;
    }

    public DriverPortalUrlRoutingCommand a(DeeplinkCall.DriverPortalWithHash deeplink) {
        Intrinsics.f(deeplink, "deeplink");
        UrlFactory urlFactory = this.f29981a;
        String c8 = deeplink.c();
        String b8 = deeplink.b();
        return new DriverPortalUrlRoutingCommand(urlFactory.d(c8 + "/" + b8, "deeplink"), null, 2, null);
    }
}
