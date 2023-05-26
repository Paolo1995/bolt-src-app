package ee.mtakso.driver.ui.screens.modal;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.ui.screens.home.v3.delegate.PromoDialogDelegate;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class ModalDelegate_Factory implements Factory<ModalDelegate> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<PromoDialogDelegate> f30888a;

    public ModalDelegate_Factory(Provider<PromoDialogDelegate> provider) {
        this.f30888a = provider;
    }

    public static ModalDelegate_Factory a(Provider<PromoDialogDelegate> provider) {
        return new ModalDelegate_Factory(provider);
    }

    public static ModalDelegate c(PromoDialogDelegate promoDialogDelegate) {
        return new ModalDelegate(promoDialogDelegate);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ModalDelegate get() {
        return c(this.f30888a.get());
    }
}
