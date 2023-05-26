package eu.bolt.android.audio_recording_engine.engine;

import android.net.Uri;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* compiled from: AudioRecorderApi.kt */
/* loaded from: classes5.dex */
public interface AudioRecorderApi {
    Object a(OrderData orderData, Continuation<? super RecordingProperties> continuation);

    Object b(OrderData orderData, int i8, Continuation<? super Unit> continuation);

    Object c(Continuation<? super Unit> continuation);

    Object d(OrderData orderData, Continuation<? super List<UploadParams>> continuation);

    Flow<RecorderState> e();

    Object f(Continuation<? super Unit> continuation);

    Object g(OrderData orderData, String str, int i8, Continuation<? super Uri> continuation);

    void h(OrderData orderData, String str);
}
