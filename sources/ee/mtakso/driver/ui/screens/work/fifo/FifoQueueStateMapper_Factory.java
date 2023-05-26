package ee.mtakso.driver.ui.screens.work.fifo;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.ui.screens.earnings.v3.common.DriverButtonMapper;
import ee.mtakso.driver.ui.screens.earnings.v3.common.DriverImageMapper;
import ee.mtakso.driver.ui.screens.earnings.v3.common.DriverLottieMapper;
import eu.bolt.android.engine.html.HtmlEngine;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class FifoQueueStateMapper_Factory implements Factory<FifoQueueStateMapper> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverButtonMapper> f34080a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DriverImageMapper> f34081b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<DriverLottieMapper> f34082c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<HtmlEngine> f34083d;

    public FifoQueueStateMapper_Factory(Provider<DriverButtonMapper> provider, Provider<DriverImageMapper> provider2, Provider<DriverLottieMapper> provider3, Provider<HtmlEngine> provider4) {
        this.f34080a = provider;
        this.f34081b = provider2;
        this.f34082c = provider3;
        this.f34083d = provider4;
    }

    public static FifoQueueStateMapper_Factory a(Provider<DriverButtonMapper> provider, Provider<DriverImageMapper> provider2, Provider<DriverLottieMapper> provider3, Provider<HtmlEngine> provider4) {
        return new FifoQueueStateMapper_Factory(provider, provider2, provider3, provider4);
    }

    public static FifoQueueStateMapper c(DriverButtonMapper driverButtonMapper, DriverImageMapper driverImageMapper, DriverLottieMapper driverLottieMapper, HtmlEngine htmlEngine) {
        return new FifoQueueStateMapper(driverButtonMapper, driverImageMapper, driverLottieMapper, htmlEngine);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public FifoQueueStateMapper get() {
        return c(this.f34080a.get(), this.f34081b.get(), this.f34082c.get(), this.f34083d.get());
    }
}
