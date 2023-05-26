package ee.mtakso.driver.utils.effects;

import android.content.Context;
import android.media.AudioManager;
import android.os.Vibrator;
import ee.mtakso.driver.utils.effects.SoundEffect;
import ee.mtakso.driver.utils.effects.VibrateEffect;
import java.util.List;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.webrtc.MediaStreamTrack;

/* compiled from: EffectsFactory.kt */
/* loaded from: classes5.dex */
public final class EffectsFactory {

    /* renamed from: a  reason: collision with root package name */
    private final Context f36408a;

    /* renamed from: b  reason: collision with root package name */
    private final Vibrator f36409b;

    /* renamed from: c  reason: collision with root package name */
    private final AudioManager f36410c;

    @Inject
    public EffectsFactory(Context context) {
        Intrinsics.f(context, "context");
        this.f36408a = context;
        Object systemService = context.getSystemService("vibrator");
        Intrinsics.d(systemService, "null cannot be cast to non-null type android.os.Vibrator");
        this.f36409b = (Vibrator) systemService;
        Object systemService2 = context.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        Intrinsics.d(systemService2, "null cannot be cast to non-null type android.media.AudioManager");
        this.f36410c = (AudioManager) systemService2;
    }

    public final Effect a(EffectRequest request) {
        SoundEffect soundEffect;
        List p8;
        Intrinsics.f(request, "request");
        Effect[] effectArr = new Effect[2];
        SoundEffect.Source a8 = request.a();
        VibrateEffect vibrateEffect = null;
        if (a8 != null) {
            soundEffect = new SoundEffect(this.f36408a, a8);
        } else {
            soundEffect = null;
        }
        effectArr[0] = soundEffect;
        VibrateEffect.Type b8 = request.b();
        if (b8 != null) {
            vibrateEffect = new VibrateEffect(this.f36409b, this.f36410c, b8);
        }
        effectArr[1] = vibrateEffect;
        p8 = CollectionsKt__CollectionsKt.p(effectArr);
        return new ComposedEffect(p8);
    }
}
