package ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.helper;

import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.utils.StorageUtils;
import eu.bolt.android.audio_recording_engine.engine.OrderData;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AudioRecordingMapper.kt */
/* loaded from: classes3.dex */
public final class AudioRecordingMapper {
    public final String a(long j8, String stringKB, String stringMB, String stringGB) {
        Intrinsics.f(stringKB, "stringKB");
        Intrinsics.f(stringMB, "stringMB");
        Intrinsics.f(stringGB, "stringGB");
        return StorageUtils.f36324a.d(j8, stringKB, stringMB, stringGB);
    }

    public final OrderData b(OrderHandle orderHandle) {
        Intrinsics.f(orderHandle, "orderHandle");
        return new OrderData(orderHandle.c(), String.valueOf(orderHandle.a()), String.valueOf(orderHandle.b()));
    }
}
