package ee.mtakso.voip_client;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VoipAudioManager.kt */
/* loaded from: classes5.dex */
public /* synthetic */ class VoipAudioManager$audioFocusChangedListener$1 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public VoipAudioManager$audioFocusChangedListener$1(Object obj) {
        super(1, obj, VoipAudioManager.class, "onAudioFocusChange", "onAudioFocusChange(I)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        j(num.intValue());
        return Unit.f50853a;
    }

    public final void j(int i8) {
        ((VoipAudioManager) this.f50989g).l(i8);
    }
}
