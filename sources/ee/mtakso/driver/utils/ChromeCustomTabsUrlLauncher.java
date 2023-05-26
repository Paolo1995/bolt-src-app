package ee.mtakso.driver.utils;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.net.Uri;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.core.content.ContextCompat;
import ee.mtakso.driver.R;
import eu.bolt.kalev.Kalev;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UrlLauncher.kt */
/* loaded from: classes5.dex */
public final class ChromeCustomTabsUrlLauncher implements UrlLauncher {

    /* renamed from: f  reason: collision with root package name */
    private final Context f36291f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f36292g;

    @Inject
    public ChromeCustomTabsUrlLauncher(Context context) {
        Intrinsics.f(context, "context");
        this.f36291f = context;
        this.f36292g = true;
    }

    @Override // ee.mtakso.driver.utils.UrlLauncher
    public boolean a(String url) {
        Intrinsics.f(url, "url");
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        builder.e(ContextCompat.getColor(this.f36291f, R.color.green500));
        CustomTabsIntent a8 = builder.a();
        Intrinsics.e(a8, "builder.build()");
        if (this.f36292g || !(this.f36291f instanceof Activity)) {
            a8.f2353a.setFlags(268435456);
        }
        try {
            a8.a(this.f36291f, Uri.parse(url));
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        } catch (SecurityException e8) {
            Kalev.e(e8, "Chrome Custom Tab Url Launcher cannot open browser.");
            return false;
        }
    }

    public final void b(boolean z7) {
        this.f36292g = z7;
    }
}
