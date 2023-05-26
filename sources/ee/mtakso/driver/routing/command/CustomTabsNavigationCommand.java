package ee.mtakso.driver.routing.command;

import android.content.Context;
import ee.mtakso.driver.utils.ChromeCustomTabsUrlLauncher;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContextNavigationCommand.kt */
/* loaded from: classes3.dex */
public final class CustomTabsNavigationCommand extends ContextNavigationCommand {

    /* renamed from: a  reason: collision with root package name */
    private final String f23360a;

    /* renamed from: b  reason: collision with root package name */
    private final ChromeCustomTabsUrlLauncher f23361b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomTabsNavigationCommand(String url, ChromeCustomTabsUrlLauncher chromeCustomTabsUrlLauncher) {
        super(null);
        Intrinsics.f(url, "url");
        Intrinsics.f(chromeCustomTabsUrlLauncher, "chromeCustomTabsUrlLauncher");
        this.f23360a = url;
        this.f23361b = chromeCustomTabsUrlLauncher;
    }

    @Override // ee.mtakso.driver.routing.command.NavigationCommand
    /* renamed from: b */
    public void a(Context context) {
        Intrinsics.f(context, "context");
        this.f23361b.a(this.f23360a);
    }
}
