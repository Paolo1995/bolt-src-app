package ee.mtakso.driver.utils;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import eu.bolt.kalev.Kalev;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UrlLauncher.kt */
/* loaded from: classes5.dex */
public final class SystemUrlLauncher implements UrlLauncher {

    /* renamed from: f  reason: collision with root package name */
    private final Context f36326f;

    @Inject
    public SystemUrlLauncher(Context context) {
        Intrinsics.f(context, "context");
        this.f36326f = context;
    }

    @Override // ee.mtakso.driver.utils.UrlLauncher
    public boolean a(String url) {
        Intrinsics.f(url, "url");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(url));
        intent.setFlags(268435456);
        ActivityInfo resolveActivityInfo = intent.resolveActivityInfo(this.f36326f.getPackageManager(), 0);
        try {
            this.f36326f.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        } catch (SecurityException e8) {
            boolean z7 = resolveActivityInfo.exported;
            String str = resolveActivityInfo.packageName;
            Kalev.e(e8, "System Url Launcher cannot open browser. IsExported: " + z7 + ", PackageName: " + str);
            return false;
        }
    }
}
