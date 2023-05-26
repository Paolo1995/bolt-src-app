package ee.mtakso.driver.ui.screens.order.incoming.v2;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.utils.effects.EffectsFactory;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class IncomingOrderSoundController_Factory implements Factory<IncomingOrderSoundController> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<EffectsFactory> f31396a;

    public IncomingOrderSoundController_Factory(Provider<EffectsFactory> provider) {
        this.f31396a = provider;
    }

    public static IncomingOrderSoundController_Factory a(Provider<EffectsFactory> provider) {
        return new IncomingOrderSoundController_Factory(provider);
    }

    public static IncomingOrderSoundController c(EffectsFactory effectsFactory) {
        return new IncomingOrderSoundController(effectsFactory);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public IncomingOrderSoundController get() {
        return c(this.f31396a.get());
    }
}
