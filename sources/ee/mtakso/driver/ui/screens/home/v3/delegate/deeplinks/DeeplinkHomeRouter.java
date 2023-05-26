package ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks;

import ee.mtakso.driver.deeplink.DeeplinkCall;
import ee.mtakso.driver.ui.screens.home.v3.HomeContainerRoutingCommand;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.NewsDeeplinkMapper;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.SettingsDeeplinkMapper;
import eu.bolt.kalev.Kalev;
import eu.bolt.kalev.fast.FastLog;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeeplinkHomeRouter.kt */
@Singleton
/* loaded from: classes3.dex */
public final class DeeplinkHomeRouter {

    /* renamed from: a  reason: collision with root package name */
    private final SettingsDeeplinkMapper f29958a;

    /* renamed from: b  reason: collision with root package name */
    private final NewsDeeplinkMapper f29959b;

    @Inject
    public DeeplinkHomeRouter(SettingsDeeplinkMapper settingsDeeplinkHandle, NewsDeeplinkMapper newsDeeplinkHandle) {
        Intrinsics.f(settingsDeeplinkHandle, "settingsDeeplinkHandle");
        Intrinsics.f(newsDeeplinkHandle, "newsDeeplinkHandle");
        this.f29958a = settingsDeeplinkHandle;
        this.f29959b = newsDeeplinkHandle;
    }

    public final HomeContainerRoutingCommand a(DeeplinkCall deeplink) {
        Intrinsics.f(deeplink, "deeplink");
        FastLog g8 = Kalev.f41674e.g();
        if (g8 != null) {
            FastLog.DefaultImpls.c(g8, "Executing pending deep link...", null, 2, null);
        }
        if (deeplink instanceof DeeplinkCall.Settings) {
            return this.f29958a.b(deeplink);
        }
        if (deeplink instanceof DeeplinkCall.News) {
            return this.f29959b.b(deeplink);
        }
        boolean z7 = deeplink instanceof DeeplinkCall.MagicLogin;
        return null;
    }
}
