package ee.mtakso.driver.service.voip.effects;

import android.media.AudioAttributes;
import ee.mtakso.driver.utils.effects.SoundEffect;
import ee.mtakso.driver.utils.effects.VibrateEffect;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VoipEffectsFactory.kt */
/* loaded from: classes3.dex */
public final class VoipEffectsFactory {
    public final AudioAttributes a() {
        AudioAttributes build = new AudioAttributes.Builder().setContentType(2).setUsage(6).build();
        Intrinsics.e(build, "Builder()\n            .s…ONE)\n            .build()");
        return build;
    }

    public final SoundEffect.Source b() {
        return SoundEffect.Source.RING.f36414a;
    }

    public final int c() {
        return 2;
    }

    public final long[] d() {
        return VibrateEffect.Type.f36420j.f();
    }
}
