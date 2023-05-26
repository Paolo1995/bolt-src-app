package ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers;

import android.os.Bundle;
import ee.mtakso.driver.deeplink.DeeplinkCall;
import ee.mtakso.driver.network.client.OrderHandleKt;
import ee.mtakso.driver.ui.screens.history.details.OrderHistoryDetailsFragment;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.SimpleDeeplinkMapper;
import javax.inject.Inject;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RideDetailsDeeplinkMapper.kt */
/* loaded from: classes3.dex */
public final class RideDetailsDeeplinkMapper extends SimpleDeeplinkMapper<DeeplinkCall.RideDetails> {
    @Inject
    public RideDetailsDeeplinkMapper() {
        super(OrderHistoryDetailsFragment.class, false, null, new Function1<DeeplinkCall.RideDetails, Bundle>() { // from class: ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.RideDetailsDeeplinkMapper.1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Bundle invoke(DeeplinkCall.RideDetails it) {
                Intrinsics.f(it, "it");
                return OrderHandleKt.d(it.b());
            }
        }, 6, null);
    }
}
