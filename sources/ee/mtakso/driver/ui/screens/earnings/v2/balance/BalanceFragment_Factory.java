package ee.mtakso.driver.ui.screens.earnings.v2.balance;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorised"})
/* loaded from: classes3.dex */
public final class BalanceFragment_Factory implements Factory<BalanceFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f28567a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ReportPageMapper> f28568b;

    public BalanceFragment_Factory(Provider<BaseUiDependencies> provider, Provider<ReportPageMapper> provider2) {
        this.f28567a = provider;
        this.f28568b = provider2;
    }

    public static BalanceFragment_Factory a(Provider<BaseUiDependencies> provider, Provider<ReportPageMapper> provider2) {
        return new BalanceFragment_Factory(provider, provider2);
    }

    public static BalanceFragment c(BaseUiDependencies baseUiDependencies, ReportPageMapper reportPageMapper) {
        return new BalanceFragment(baseUiDependencies, reportPageMapper);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public BalanceFragment get() {
        return c(this.f28567a.get(), this.f28568b.get());
    }
}
