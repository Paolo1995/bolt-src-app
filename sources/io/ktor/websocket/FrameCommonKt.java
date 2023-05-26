package io.ktor.websocket;

import io.ktor.utils.io.core.BytePacketBuilder;
import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.Input;
import io.ktor.utils.io.core.InputPrimitivesKt;
import io.ktor.utils.io.core.OutputKt;
import io.ktor.websocket.Frame;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FrameCommon.kt */
/* loaded from: classes5.dex */
public final class FrameCommonKt {
    public static final CloseReason a(Frame.Close close) {
        Intrinsics.f(close, "<this>");
        if (close.b().length < 2) {
            return null;
        }
        BytePacketBuilder bytePacketBuilder = new BytePacketBuilder(null, 1, null);
        try {
            OutputKt.d(bytePacketBuilder, close.b(), 0, 0, 6, null);
            ByteReadPacket K0 = bytePacketBuilder.K0();
            return new CloseReason(InputPrimitivesKt.a(K0), Input.Z0(K0, 0, 0, 3, null));
        } catch (Throwable th) {
            bytePacketBuilder.release();
            throw th;
        }
    }
}
