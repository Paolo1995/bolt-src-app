package ee.mtakso.driver.service.integration.appsflyer;

import android.content.Context;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import eu.bolt.kalev.Kalev;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AppsflyerManager.kt */
@Singleton
/* loaded from: classes3.dex */
public final class AppsflyerManager {

    /* renamed from: a  reason: collision with root package name */
    private final Context f24524a;

    @Inject
    public AppsflyerManager(Context context) {
        Intrinsics.f(context, "context");
        this.f24524a = context;
    }

    public final String a() {
        return AppsFlyerProperties.getInstance().getString("advertiserId");
    }

    public final String b() {
        return AppsFlyerLib.getInstance().getAppsFlyerUID(this.f24524a);
    }

    public final void c() {
        Kalev.b("AppsFlyer initialisation started");
        AppsFlyerLib.getInstance().init("ZQvYzyFSoUheQxE3zroTbU", null, this.f24524a);
        AppsFlyerLib.getInstance().start(this.f24524a, "ZQvYzyFSoUheQxE3zroTbU", new AppsFlyerRequestListener() { // from class: ee.mtakso.driver.service.integration.appsflyer.AppsflyerManager$initialize$1
            @Override // com.appsflyer.attribution.AppsFlyerRequestListener
            public void onError(int i8, String msg) {
                Intrinsics.f(msg, "msg");
                Kalev.e(new IllegalStateException("AppsFlyer init onError: " + i8 + ", " + msg + ")"), "AppsFlyer init onError");
            }

            @Override // com.appsflyer.attribution.AppsFlyerRequestListener
            public void onSuccess() {
                Kalev.b("AppsFlyer init onSuccess");
            }
        });
        String b8 = b();
        Kalev.b("AppsFlyer id = " + b8);
    }
}
