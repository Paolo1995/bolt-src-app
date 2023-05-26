package org.webrtc;

/* loaded from: classes4.dex */
class DynamicBitrateAdjuster extends BaseBitrateAdjuster {
    private static final double BITRATE_ADJUSTMENT_MAX_SCALE = 4.0d;
    private static final double BITRATE_ADJUSTMENT_SEC = 3.0d;
    private static final int BITRATE_ADJUSTMENT_STEPS = 20;
    private static final double BITS_PER_BYTE = 8.0d;
    private int bitrateAdjustmentScaleExp;
    private double deviationBytes;
    private double timeSinceLastAdjustmentMs;

    private double getBitrateAdjustmentScale() {
        return Math.pow(BITRATE_ADJUSTMENT_MAX_SCALE, this.bitrateAdjustmentScaleExp / 20.0d);
    }

    @Override // org.webrtc.BaseBitrateAdjuster, org.webrtc.BitrateAdjuster
    public int getAdjustedBitrateBps() {
        return (int) (this.targetBitrateBps * getBitrateAdjustmentScale());
    }

    @Override // org.webrtc.BaseBitrateAdjuster, org.webrtc.BitrateAdjuster
    public void reportEncodedFrame(int i8) {
        double d8 = this.targetFramerateFps;
        if (d8 == 0.0d) {
            return;
        }
        double d9 = this.targetBitrateBps / BITS_PER_BYTE;
        double d10 = this.deviationBytes + (i8 - (d9 / d8));
        this.deviationBytes = d10;
        this.timeSinceLastAdjustmentMs += 1000.0d / d8;
        double d11 = BITRATE_ADJUSTMENT_SEC * d9;
        double min = Math.min(d10, d11);
        this.deviationBytes = min;
        double max = Math.max(min, -d11);
        this.deviationBytes = max;
        if (this.timeSinceLastAdjustmentMs <= 3000.0d) {
            return;
        }
        if (max > d9) {
            int i9 = this.bitrateAdjustmentScaleExp - ((int) ((max / d9) + 0.5d));
            this.bitrateAdjustmentScaleExp = i9;
            this.bitrateAdjustmentScaleExp = Math.max(i9, -20);
            this.deviationBytes = d9;
        } else {
            double d12 = -d9;
            if (max < d12) {
                int i10 = this.bitrateAdjustmentScaleExp + ((int) (((-max) / d9) + 0.5d));
                this.bitrateAdjustmentScaleExp = i10;
                this.bitrateAdjustmentScaleExp = Math.min(i10, 20);
                this.deviationBytes = d12;
            }
        }
        this.timeSinceLastAdjustmentMs = 0.0d;
    }

    @Override // org.webrtc.BaseBitrateAdjuster, org.webrtc.BitrateAdjuster
    public void setTargets(int i8, double d8) {
        int i9 = this.targetBitrateBps;
        if (i9 > 0 && i8 < i9) {
            this.deviationBytes = (this.deviationBytes * i8) / i9;
        }
        super.setTargets(i8, d8);
    }
}
