package ee.mtakso.driver.utils;

import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UrlLauncher.kt */
/* loaded from: classes5.dex */
public final class CompositeUrlLauncher implements UrlLauncher {

    /* renamed from: f  reason: collision with root package name */
    private final ChromeCustomTabsUrlLauncher f36300f;

    /* renamed from: g  reason: collision with root package name */
    private final SystemUrlLauncher f36301g;

    @Inject
    public CompositeUrlLauncher(ChromeCustomTabsUrlLauncher chromeCustomTabsUrlLauncher, SystemUrlLauncher systemUrlLauncher) {
        Intrinsics.f(chromeCustomTabsUrlLauncher, "chromeCustomTabsUrlLauncher");
        Intrinsics.f(systemUrlLauncher, "systemUrlLauncher");
        this.f36300f = chromeCustomTabsUrlLauncher;
        this.f36301g = systemUrlLauncher;
    }

    @Override // ee.mtakso.driver.utils.UrlLauncher
    public boolean a(String url) {
        Intrinsics.f(url, "url");
        if (!this.f36300f.a(url) && !this.f36301g.a(url)) {
            return false;
        }
        return true;
    }
}
