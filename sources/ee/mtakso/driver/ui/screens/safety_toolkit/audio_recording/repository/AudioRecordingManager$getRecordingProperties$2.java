package ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.repository;

import eu.bolt.android.audio_recording_engine.engine.AudioRecorderApi;
import eu.bolt.android.audio_recording_engine.engine.OrderData;
import eu.bolt.android.audio_recording_engine.engine.RecordingProperties;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AudioRecordingManager.kt */
@DebugMetadata(c = "ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.repository.AudioRecordingManager$getRecordingProperties$2", f = "AudioRecordingManager.kt", l = {39}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class AudioRecordingManager$getRecordingProperties$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super RecordingProperties>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f32605g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ AudioRecordingManager f32606h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ OrderData f32607i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AudioRecordingManager$getRecordingProperties$2(AudioRecordingManager audioRecordingManager, OrderData orderData, Continuation<? super AudioRecordingManager$getRecordingProperties$2> continuation) {
        super(2, continuation);
        this.f32606h = audioRecordingManager;
        this.f32607i = orderData;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AudioRecordingManager$getRecordingProperties$2(this.f32606h, this.f32607i, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: h */
    public final Object s(CoroutineScope coroutineScope, Continuation<? super RecordingProperties> continuation) {
        return ((AudioRecordingManager$getRecordingProperties$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        AudioRecorderApi audioRecorderApi;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f32605g;
        if (i8 != 0) {
            if (i8 == 1) {
                ResultKt.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.b(obj);
            audioRecorderApi = this.f32606h.f32601a;
            OrderData orderData = this.f32607i;
            this.f32605g = 1;
            obj = audioRecorderApi.a(orderData, this);
            if (obj == d8) {
                return d8;
            }
        }
        return obj;
    }
}
