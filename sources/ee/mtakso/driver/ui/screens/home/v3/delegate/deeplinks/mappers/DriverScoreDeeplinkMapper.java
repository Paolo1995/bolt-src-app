package ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers;

import ee.mtakso.driver.deeplink.DeeplinkCall;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.SimpleDeeplinkMapper;
import ee.mtakso.driver.ui.screens.score.DriverScoreFragment;
import javax.inject.Inject;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverScoreDeeplinkMapper.kt */
/* loaded from: classes3.dex */
public final class DriverScoreDeeplinkMapper extends SimpleDeeplinkMapper<DeeplinkCall.DriverScoreDetails> {

    /* renamed from: e  reason: collision with root package name */
    private final DriverProvider f29982e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public DriverScoreDeeplinkMapper(final DriverProvider driverProvider) {
        super(DriverScoreFragment.class, true, new Function1<DeeplinkCall, Boolean>() { // from class: ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.DriverScoreDeeplinkMapper.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(DeeplinkCall it) {
                Intrinsics.f(it, "it");
                return Boolean.valueOf(DriverProvider.this.q().k());
            }
        }, null, 8, null);
        Intrinsics.f(driverProvider, "driverProvider");
        this.f29982e = driverProvider;
    }
}
