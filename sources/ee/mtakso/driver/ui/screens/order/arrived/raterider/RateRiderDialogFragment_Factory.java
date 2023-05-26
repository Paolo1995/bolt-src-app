package ee.mtakso.driver.ui.screens.order.arrived.raterider;

import androidx.fragment.app.FragmentFactory;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class RateRiderDialogFragment_Factory implements Factory<RateRiderDialogFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<FragmentFactory> f31185a;

    public RateRiderDialogFragment_Factory(Provider<FragmentFactory> provider) {
        this.f31185a = provider;
    }

    public static RateRiderDialogFragment_Factory a(Provider<FragmentFactory> provider) {
        return new RateRiderDialogFragment_Factory(provider);
    }

    public static RateRiderDialogFragment c(FragmentFactory fragmentFactory) {
        return new RateRiderDialogFragment(fragmentFactory);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public RateRiderDialogFragment get() {
        return c(this.f31185a.get());
    }
}
