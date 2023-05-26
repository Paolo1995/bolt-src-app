package org.webrtc;

/* loaded from: classes4.dex */
class BaseBitrateAdjuster implements BitrateAdjuster {
    public int targetBitrateBps;
    public double targetFramerateFps;

    @Override // org.webrtc.BitrateAdjuster
    public int getAdjustedBitrateBps() {
        return this.targetBitrateBps;
    }

    @Override // org.webrtc.BitrateAdjuster
    public double getAdjustedFramerateFps() {
        return this.targetFramerateFps;
    }

    @Override // org.webrtc.BitrateAdjuster
    public void reportEncodedFrame(int i8) {
    }

    @Override // org.webrtc.BitrateAdjuster
    public void setTargets(int i8, double d8) {
        this.targetBitrateBps = i8;
        this.targetFramerateFps = d8;
    }
}
