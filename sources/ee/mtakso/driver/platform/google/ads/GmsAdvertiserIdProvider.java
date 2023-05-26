package ee.mtakso.driver.platform.google.ads;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import ee.mtakso.driver.platform.ads.AdvertiserIdProvider;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GmsAdvertiserIdProvider.kt */
/* loaded from: classes3.dex */
public final class GmsAdvertiserIdProvider implements AdvertiserIdProvider {

    /* renamed from: a  reason: collision with root package name */
    private final Context f23286a;

    @Inject
    public GmsAdvertiserIdProvider(Context context) {
        Intrinsics.f(context, "context");
        this.f23286a = context;
    }

    @Override // ee.mtakso.driver.platform.ads.AdvertiserIdProvider
    public String a() {
        AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.f23286a);
        if (advertisingIdInfo != null) {
            return advertisingIdInfo.getId();
        }
        return null;
    }
}
