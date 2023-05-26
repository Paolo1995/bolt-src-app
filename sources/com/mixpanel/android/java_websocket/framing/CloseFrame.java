package com.mixpanel.android.java_websocket.framing;

import com.mixpanel.android.java_websocket.exceptions.InvalidDataException;
import com.mixpanel.android.java_websocket.exceptions.InvalidFrameException;

/* loaded from: classes3.dex */
public interface CloseFrame extends Framedata {
    int e() throws InvalidFrameException;

    String getMessage() throws InvalidDataException;
}
