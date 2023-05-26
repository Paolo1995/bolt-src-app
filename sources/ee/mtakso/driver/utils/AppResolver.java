package ee.mtakso.driver.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import ee.mtakso.driver.platform.core.PlatformManager;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AppResolver.kt */
/* loaded from: classes5.dex */
public final class AppResolver {

    /* renamed from: a  reason: collision with root package name */
    private final Context f36276a;

    /* renamed from: b  reason: collision with root package name */
    private final PlatformManager f36277b;

    /* renamed from: c  reason: collision with root package name */
    private final PackageManager f36278c;

    @Inject
    public AppResolver(Context context, PlatformManager platformManager) {
        Intrinsics.f(context, "context");
        Intrinsics.f(platformManager, "platformManager");
        this.f36276a = context;
        this.f36277b = platformManager;
        this.f36278c = context.getPackageManager();
    }

    public final void a() {
        PlatformManager.DefaultImpls.a(this.f36277b, null, 1, null);
    }

    public final Intent b(String packageName, String componentName, String str, Bundle bundle) {
        Intrinsics.f(packageName, "packageName");
        Intrinsics.f(componentName, "componentName");
        Intent intent = new Intent();
        if (str != null) {
            intent.setAction(str);
        }
        intent.setComponent(new ComponentName(packageName, componentName));
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        try {
            ActivityInfo resolveActivityInfo = intent.resolveActivityInfo(this.f36278c, 0);
            if (resolveActivityInfo != null) {
                if (resolveActivityInfo.exported) {
                    return intent;
                }
                return null;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public final boolean c(Intent intent) {
        Intrinsics.f(intent, "intent");
        if (intent.resolveActivity(this.f36276a.getPackageManager()) != null) {
            return true;
        }
        return false;
    }
}
