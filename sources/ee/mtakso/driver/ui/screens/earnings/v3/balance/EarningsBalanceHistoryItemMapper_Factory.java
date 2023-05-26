package ee.mtakso.driver.ui.screens.earnings.v3.balance;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.ui.screens.earnings.v3.common.DriverContentTypeMapper;
import eu.bolt.android.engine.html.HtmlEngine;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class EarningsBalanceHistoryItemMapper_Factory implements Factory<EarningsBalanceHistoryItemMapper> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverContentTypeMapper> f28824a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<HtmlEngine> f28825b;

    public EarningsBalanceHistoryItemMapper_Factory(Provider<DriverContentTypeMapper> provider, Provider<HtmlEngine> provider2) {
        this.f28824a = provider;
        this.f28825b = provider2;
    }

    public static EarningsBalanceHistoryItemMapper_Factory a(Provider<DriverContentTypeMapper> provider, Provider<HtmlEngine> provider2) {
        return new EarningsBalanceHistoryItemMapper_Factory(provider, provider2);
    }

    public static EarningsBalanceHistoryItemMapper c(DriverContentTypeMapper driverContentTypeMapper, HtmlEngine htmlEngine) {
        return new EarningsBalanceHistoryItemMapper(driverContentTypeMapper, htmlEngine);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public EarningsBalanceHistoryItemMapper get() {
        return c(this.f28824a.get(), this.f28825b.get());
    }
}
