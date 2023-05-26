package ee.mtakso.driver.utils.customtabs;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.net.Uri;
import androidx.browser.customtabs.CustomTabColorSchemeParams;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import androidx.browser.customtabs.CustomTabsSession;
import androidx.core.content.ContextCompat;
import ee.mtakso.driver.R;
import ee.mtakso.driver.utils.UrlLauncher;
import ee.mtakso.driver.utils.customtabs.CustomTabsUrlLauncher;
import eu.bolt.driver.core.ui.common.activity.DefaultActivityLifecycleCallback;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CustomTabsUrlLauncher.kt */
@Singleton
/* loaded from: classes5.dex */
public final class CustomTabsUrlLauncher extends DefaultActivityLifecycleCallback implements UrlLauncher {

    /* renamed from: f  reason: collision with root package name */
    private Warmer f36392f;

    /* renamed from: g  reason: collision with root package name */
    private Activity f36393g;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: CustomTabsUrlLauncher.kt */
    /* loaded from: classes5.dex */
    public static final class Warmer {

        /* renamed from: a  reason: collision with root package name */
        private final Context f36394a;

        /* renamed from: b  reason: collision with root package name */
        private CustomTabsClient f36395b;

        /* renamed from: c  reason: collision with root package name */
        private CustomTabsServiceConnection f36396c;

        /* renamed from: d  reason: collision with root package name */
        private CustomTabsSession f36397d;

        /* renamed from: e  reason: collision with root package name */
        private String f36398e;

        public Warmer(Context context) {
            Intrinsics.f(context, "context");
            this.f36394a = context.getApplicationContext();
        }

        public final CustomTabsSession c() {
            return this.f36397d;
        }

        public final String d() {
            return this.f36398e;
        }

        public final Warmer e() {
            this.f36396c = new CustomTabsServiceConnection() { // from class: ee.mtakso.driver.utils.customtabs.CustomTabsUrlLauncher$Warmer$warmUp$1
                @Override // androidx.browser.customtabs.CustomTabsServiceConnection
                public void a(ComponentName componentName, CustomTabsClient customTabsClient) {
                    Intrinsics.f(componentName, "componentName");
                    Intrinsics.f(customTabsClient, "customTabsClient");
                    CustomTabsUrlLauncher.Warmer.this.f36395b = customTabsClient;
                    customTabsClient.e(0L);
                    CustomTabsUrlLauncher.Warmer.this.f36397d = customTabsClient.c(null);
                }

                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName name) {
                    Intrinsics.f(name, "name");
                    CustomTabsUrlLauncher.Warmer.this.f36395b = null;
                }
            };
            ChromePackageHelper chromePackageHelper = ChromePackageHelper.f36390a;
            Context _context = this.f36394a;
            Intrinsics.e(_context, "_context");
            String a8 = chromePackageHelper.a(_context);
            this.f36398e = a8;
            if (a8 != null) {
                Context context = this.f36394a;
                CustomTabsServiceConnection customTabsServiceConnection = this.f36396c;
                Intrinsics.c(customTabsServiceConnection);
                CustomTabsClient.a(context, a8, customTabsServiceConnection);
            }
            return this;
        }
    }

    private final void c(Context context) {
        if (this.f36392f == null) {
            this.f36392f = new Warmer(context).e();
        }
    }

    @Override // ee.mtakso.driver.utils.UrlLauncher
    public boolean a(String url) {
        String str;
        Intrinsics.f(url, "url");
        Activity activity = this.f36393g;
        if (activity == null) {
            return false;
        }
        Uri parse = Uri.parse(url);
        Warmer warmer = this.f36392f;
        CustomTabsSession customTabsSession = null;
        if (warmer != null) {
            str = warmer.d();
        } else {
            str = null;
        }
        if (str == null) {
            return false;
        }
        Warmer warmer2 = this.f36392f;
        if (warmer2 != null) {
            customTabsSession = warmer2.c();
        }
        new CustomTabsIntent.Builder(customTabsSession).b(new CustomTabColorSchemeParams.Builder().b(ContextCompat.getColor(activity, R.color.green500)).a()).a().a(activity, parse);
        return true;
    }

    @Override // eu.bolt.driver.core.ui.common.activity.DefaultActivityLifecycleCallback, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Intrinsics.f(activity, "activity");
        super.onActivityPaused(activity);
        this.f36393g = null;
    }

    @Override // eu.bolt.driver.core.ui.common.activity.DefaultActivityLifecycleCallback, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Intrinsics.f(activity, "activity");
        super.onActivityResumed(activity);
        this.f36393g = activity;
    }

    @Override // eu.bolt.driver.core.ui.common.activity.DefaultActivityLifecycleCallback, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        Intrinsics.f(activity, "activity");
        super.onActivityStarted(activity);
        c(activity);
    }
}
