package com.mixpanel.android.java_websocket.framing;

import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public interface Framedata {

    /* loaded from: classes3.dex */
    public enum Opcode {
        CONTINUOUS,
        TEXT,
        BINARY,
        PING,
        PONG,
        CLOSING
    }

    boolean a();

    Opcode b();

    boolean d();

    ByteBuffer f();
}
