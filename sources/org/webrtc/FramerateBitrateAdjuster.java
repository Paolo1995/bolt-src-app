package org.webrtc;

/* loaded from: classes4.dex */
class FramerateBitrateAdjuster extends BaseBitrateAdjuster {
    private static final int DEFAULT_FRAMERATE_FPS = 30;

    @Override // org.webrtc.BaseBitrateAdjuster, org.webrtc.BitrateAdjuster
    public void setTargets(int i8, double d8) {
        this.targetFramerateFps = 30.0d;
        this.targetBitrateBps = (int) ((i8 * 30) / d8);
    }
}
