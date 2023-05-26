package ee.mtakso.driver.ui.screens.order.incoming.v2;

import ee.mtakso.driver.R;
import ee.mtakso.driver.param.AppConfig;
import ee.mtakso.driver.utils.effects.Effect;
import ee.mtakso.driver.utils.effects.EffectRequest;
import ee.mtakso.driver.utils.effects.EffectsFactory;
import ee.mtakso.driver.utils.effects.SoundEffect;
import ee.mtakso.driver.utils.effects.VibrateEffect;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IncomingOrderSoundController.kt */
/* loaded from: classes3.dex */
public final class IncomingOrderSoundController {

    /* renamed from: a  reason: collision with root package name */
    private final EffectsFactory f31394a;

    /* renamed from: b  reason: collision with root package name */
    private Effect f31395b;

    @Inject
    public IncomingOrderSoundController(EffectsFactory effectsFactory) {
        Intrinsics.f(effectsFactory, "effectsFactory");
        this.f31394a = effectsFactory;
    }

    public final void a() {
        if (!AppConfig.f23070a.a().a().booleanValue() || this.f31395b != null) {
            return;
        }
        Effect a8 = this.f31394a.a(new EffectRequest.Builder().d(new SoundEffect.Source.RawResource(R.raw.driverbell)).e(VibrateEffect.Type.f36421k).a());
        a8.a();
        this.f31395b = a8;
    }

    public final void b() {
        Effect effect = this.f31395b;
        if (effect != null) {
            effect.cancel();
        }
        this.f31395b = null;
    }
}
