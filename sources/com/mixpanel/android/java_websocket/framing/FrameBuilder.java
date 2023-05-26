package com.mixpanel.android.java_websocket.framing;

import com.mixpanel.android.java_websocket.exceptions.InvalidDataException;
import com.mixpanel.android.java_websocket.framing.Framedata;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public interface FrameBuilder extends Framedata {
    void c(boolean z7);

    void g(Framedata.Opcode opcode);

    void h(ByteBuffer byteBuffer) throws InvalidDataException;
}
