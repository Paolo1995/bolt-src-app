package ee.mtakso.driver.platform.google.core;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import ee.mtakso.driver.platform.core.PlatformManager;
import ee.mtakso.driver.platform.core.PlatformType;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GmsPlatformManager.kt */
/* loaded from: classes3.dex */
public final class GmsPlatformManager implements PlatformManager {

    /* renamed from: a  reason: collision with root package name */
    private final Context f23297a;

    /* renamed from: b  reason: collision with root package name */
    private final PackageManager f23298b;

    @Inject
    public GmsPlatformManager(Context context) {
        Intrinsics.f(context, "context");
        this.f23297a = context;
        this.f23298b = context.getPackageManager();
    }

    @Override // ee.mtakso.driver.platform.core.PlatformManager
    public void a(String str) {
        if (str == null) {
            str = this.f23297a.getPackageName();
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + str));
        intent.setFlags(268435456);
        if (intent.resolveActivity(this.f23298b) != null) {
            this.f23297a.startActivity(intent);
            return;
        }
        Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + str));
        intent2.setFlags(268435456);
        this.f23297a.startActivity(intent2);
    }

    @Override // ee.mtakso.driver.platform.core.PlatformManager
    public PlatformType getType() {
        return PlatformType.GMS;
    }
}
