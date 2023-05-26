package ee.mtakso.driver.ui.screens.earnings.v2.pay_to_bolt;

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
public final class PayToBoltFragment_Factory implements Factory<PayToBoltFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f28630a;

    public PayToBoltFragment_Factory(Provider<BaseUiDependencies> provider) {
        this.f28630a = provider;
    }

    public static PayToBoltFragment_Factory a(Provider<BaseUiDependencies> provider) {
        return new PayToBoltFragment_Factory(provider);
    }

    public static PayToBoltFragment c(BaseUiDependencies baseUiDependencies) {
        return new PayToBoltFragment(baseUiDependencies);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public PayToBoltFragment get() {
        return c(this.f28630a.get());
    }
}
