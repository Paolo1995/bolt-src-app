package org.webrtc;

import android.content.Context;

/* loaded from: classes4.dex */
public interface VideoCapturer {
    void changeCaptureFormat(int i8, int i9, int i10);

    void dispose();

    void initialize(SurfaceTextureHelper surfaceTextureHelper, Context context, CapturerObserver capturerObserver);

    boolean isScreencast();

    void startCapture(int i8, int i9, int i10);

    void stopCapture() throws InterruptedException;
}
