package ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.repository;

import android.net.Uri;
import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.helper.AudioRecordingMapper;
import eu.bolt.android.audio_recording_engine.engine.AudioRecorderApi;
import eu.bolt.android.audio_recording_engine.engine.OrderData;
import eu.bolt.android.audio_recording_engine.engine.RecorderState;
import eu.bolt.android.audio_recording_engine.engine.RecordingProperties;
import eu.bolt.android.audio_recording_engine.engine.UploadParams;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.rx2.RxConvertKt;

/* compiled from: AudioRecordingManager.kt */
/* loaded from: classes3.dex */
public final class AudioRecordingManager {

    /* renamed from: a  reason: collision with root package name */
    private final AudioRecorderApi f32601a;

    /* renamed from: b  reason: collision with root package name */
    private final CoroutineDispatcher f32602b;

    /* renamed from: c  reason: collision with root package name */
    private final AudioRecordingMapper f32603c;

    /* renamed from: d  reason: collision with root package name */
    private OrderHandle f32604d;

    @Inject
    public AudioRecordingManager(AudioRecorderApi audioRecorderApi, CoroutineDispatcher dispatcher, AudioRecordingMapper audioRecordingMapper) {
        Intrinsics.f(audioRecorderApi, "audioRecorderApi");
        Intrinsics.f(dispatcher, "dispatcher");
        Intrinsics.f(audioRecordingMapper, "audioRecordingMapper");
        this.f32601a = audioRecorderApi;
        this.f32602b = dispatcher;
        this.f32603c = audioRecordingMapper;
    }

    public final Object b(OrderData orderData, String str, int i8, Continuation<? super Uri> continuation) {
        return this.f32601a.g(orderData, str, i8, continuation);
    }

    public final Object c(OrderData orderData, Continuation<? super RecordingProperties> continuation) {
        return BuildersKt.g(this.f32602b, new AudioRecordingManager$getRecordingProperties$2(this, orderData, null), continuation);
    }

    public final Object d(OrderData orderData, Continuation<? super List<UploadParams>> continuation) {
        return BuildersKt.g(this.f32602b, new AudioRecordingManager$getUploadParams$2(this, orderData, null), continuation);
    }

    public final Object e(Continuation<? super Unit> continuation) {
        Object d8;
        Object c8 = this.f32601a.c(continuation);
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        if (c8 == d8) {
            return c8;
        }
        return Unit.f50853a;
    }

    public final Observable<RecorderState> f() {
        return RxConvertKt.e(this.f32601a.e(), null, 1, null);
    }

    public final Object g(OrderData orderData, int i8, Continuation<? super Unit> continuation) {
        Object d8;
        Object b8 = this.f32601a.b(orderData, i8, continuation);
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        if (b8 == d8) {
            return b8;
        }
        return Unit.f50853a;
    }

    public final void h(OrderHandle orderHandle, String cryptoKey) {
        Intrinsics.f(orderHandle, "orderHandle");
        Intrinsics.f(cryptoKey, "cryptoKey");
        this.f32604d = orderHandle;
        this.f32601a.h(this.f32603c.b(orderHandle), cryptoKey);
    }

    public final Object i(OrderHandle orderHandle, Continuation<? super Unit> continuation) {
        Object d8;
        if (Intrinsics.a(this.f32604d, orderHandle)) {
            Object f8 = this.f32601a.f(continuation);
            d8 = IntrinsicsKt__IntrinsicsKt.d();
            if (f8 == d8) {
                return f8;
            }
            return Unit.f50853a;
        }
        return Unit.f50853a;
    }
}
