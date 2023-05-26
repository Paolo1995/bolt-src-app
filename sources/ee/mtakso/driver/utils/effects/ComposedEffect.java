package ee.mtakso.driver.utils.effects;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ComposedEffect.kt */
/* loaded from: classes5.dex */
public final class ComposedEffect implements Effect {

    /* renamed from: a  reason: collision with root package name */
    private final List<Effect> f36403a;

    /* JADX WARN: Multi-variable type inference failed */
    public ComposedEffect(List<? extends Effect> effects) {
        Intrinsics.f(effects, "effects");
        this.f36403a = effects;
    }

    @Override // ee.mtakso.driver.utils.effects.Effect
    public void a() {
        for (Effect effect : this.f36403a) {
            effect.a();
        }
    }

    @Override // ee.mtakso.driver.utils.effects.Effect
    public void cancel() {
        for (Effect effect : this.f36403a) {
            effect.cancel();
        }
    }
}
