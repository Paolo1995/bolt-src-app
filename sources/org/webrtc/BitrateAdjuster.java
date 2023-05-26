package org.webrtc;

/* loaded from: classes4.dex */
interface BitrateAdjuster {
    int getAdjustedBitrateBps();

    double getAdjustedFramerateFps();

    void reportEncodedFrame(int i8);

    void setTargets(int i8, double d8);
}
