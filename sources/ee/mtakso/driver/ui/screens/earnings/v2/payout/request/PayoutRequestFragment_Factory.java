package ee.mtakso.driver.ui.screens.earnings.v2.payout.request;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.common.mapping.FlatGenericSectionsMapper;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorised"})
/* loaded from: classes3.dex */
public final class PayoutRequestFragment_Factory implements Factory<PayoutRequestFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f28741a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<FlatGenericSectionsMapper> f28742b;

    public PayoutRequestFragment_Factory(Provider<BaseUiDependencies> provider, Provider<FlatGenericSectionsMapper> provider2) {
        this.f28741a = provider;
        this.f28742b = provider2;
    }

    public static PayoutRequestFragment_Factory a(Provider<BaseUiDependencies> provider, Provider<FlatGenericSectionsMapper> provider2) {
        return new PayoutRequestFragment_Factory(provider, provider2);
    }

    public static PayoutRequestFragment c(BaseUiDependencies baseUiDependencies, FlatGenericSectionsMapper flatGenericSectionsMapper) {
        return new PayoutRequestFragment(baseUiDependencies, flatGenericSectionsMapper);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public PayoutRequestFragment get() {
        return c(this.f28741a.get(), this.f28742b.get());
    }
}
