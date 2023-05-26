package ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.repository;

import eu.bolt.android.audio_recording_engine.engine.AudioRecorderApi;
import eu.bolt.android.audio_recording_engine.engine.OrderData;
import eu.bolt.android.audio_recording_engine.engine.UploadParams;
import java.util.List;
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
@DebugMetadata(c = "ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.repository.AudioRecordingManager$getUploadParams$2", f = "AudioRecordingManager.kt", l = {45}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class AudioRecordingManager$getUploadParams$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends UploadParams>>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f32608g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ AudioRecordingManager f32609h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ OrderData f32610i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AudioRecordingManager$getUploadParams$2(AudioRecordingManager audioRecordingManager, OrderData orderData, Continuation<? super AudioRecordingManager$getUploadParams$2> continuation) {
        super(2, continuation);
        this.f32609h = audioRecordingManager;
        this.f32610i = orderData;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AudioRecordingManager$getUploadParams$2(this.f32609h, this.f32610i, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: h */
    public final Object s(CoroutineScope coroutineScope, Continuation<? super List<UploadParams>> continuation) {
        return ((AudioRecordingManager$getUploadParams$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        AudioRecorderApi audioRecorderApi;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f32608g;
        if (i8 != 0) {
            if (i8 == 1) {
                ResultKt.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.b(obj);
            audioRecorderApi = this.f32609h.f32601a;
            OrderData orderData = this.f32610i;
            this.f32608g = 1;
            obj = audioRecorderApi.d(orderData, this);
            if (obj == d8) {
                return d8;
            }
        }
        return obj;
    }
}
