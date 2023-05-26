package ee.mtakso.driver.utils;

import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UrlLauncher.kt */
/* loaded from: classes5.dex */
public final class CompositeChromeFirstUrlLauncher implements UrlLauncher {

    /* renamed from: f  reason: collision with root package name */
    private final SystemUrlLauncher f36296f;

    /* renamed from: g  reason: collision with root package name */
    private final ChromeUrlLauncher f36297g;

    @Inject
    public CompositeChromeFirstUrlLauncher(SystemUrlLauncher systemUrlLauncher, ChromeUrlLauncher chromeUrlLauncher) {
        Intrinsics.f(systemUrlLauncher, "systemUrlLauncher");
        Intrinsics.f(chromeUrlLauncher, "chromeUrlLauncher");
        this.f36296f = systemUrlLauncher;
        this.f36297g = chromeUrlLauncher;
    }

    @Override // ee.mtakso.driver.utils.UrlLauncher
    public boolean a(String url) {
        Intrinsics.f(url, "url");
        if (!this.f36297g.a(url) && !this.f36296f.a(url)) {
            return false;
        }
        return true;
    }
}
