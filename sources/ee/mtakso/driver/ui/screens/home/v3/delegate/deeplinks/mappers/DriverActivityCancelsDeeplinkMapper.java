package ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers;

import android.os.Bundle;
import ee.mtakso.driver.deeplink.DeeplinkCall;
import ee.mtakso.driver.ui.screens.home.v2.subpage.activity.ActivityMode;
import ee.mtakso.driver.ui.screens.home.v2.subpage.activity.DriverActivityFragment;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.SimpleDeeplinkMapper;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverActivityCancelsDeeplinkMapper.kt */
@Singleton
/* loaded from: classes3.dex */
public final class DriverActivityCancelsDeeplinkMapper extends SimpleDeeplinkMapper<DeeplinkCall.ActivityCancels> {
    @Inject
    public DriverActivityCancelsDeeplinkMapper() {
        super(DriverActivityFragment.class, true, null, new Function1<DeeplinkCall.ActivityCancels, Bundle>() { // from class: ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.DriverActivityCancelsDeeplinkMapper.1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Bundle invoke(DeeplinkCall.ActivityCancels deepLink) {
                Intrinsics.f(deepLink, "deepLink");
                return DriverActivityFragment.f29623u.a(ActivityMode.CANCELS);
            }
        }, 4, null);
    }
}
