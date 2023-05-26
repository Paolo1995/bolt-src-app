package org.webrtc;

import android.graphics.Matrix;
import android.graphics.Point;
import android.view.View;
import com.google.android.gms.common.api.Api;

/* loaded from: classes4.dex */
public class RendererCommon {
    private static float BALANCED_VISIBLE_FRACTION = 0.5625f;

    /* renamed from: org.webrtc.RendererCommon$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$org$webrtc$RendererCommon$ScalingType;

        static {
            int[] iArr = new int[ScalingType.values().length];
            $SwitchMap$org$webrtc$RendererCommon$ScalingType = iArr;
            try {
                iArr[ScalingType.SCALE_ASPECT_FIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$webrtc$RendererCommon$ScalingType[ScalingType.SCALE_ASPECT_FILL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$webrtc$RendererCommon$ScalingType[ScalingType.SCALE_ASPECT_BALANCED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface GlDrawer {
        void drawOes(int i8, float[] fArr, int i9, int i10, int i11, int i12, int i13, int i14);

        void drawRgb(int i8, float[] fArr, int i9, int i10, int i11, int i12, int i13, int i14);

        void drawYuv(int[] iArr, float[] fArr, int i8, int i9, int i10, int i11, int i12, int i13);

        void release();
    }

    /* loaded from: classes4.dex */
    public interface RendererEvents {
        void onFirstFrameRendered();

        void onFrameResolutionChanged(int i8, int i9, int i10);
    }

    /* loaded from: classes4.dex */
    public enum ScalingType {
        SCALE_ASPECT_FIT,
        SCALE_ASPECT_FILL,
        SCALE_ASPECT_BALANCED
    }

    /* loaded from: classes4.dex */
    public static class VideoLayoutMeasure {
        private float visibleFractionMatchOrientation;
        private float visibleFractionMismatchOrientation;

        public VideoLayoutMeasure() {
            ScalingType scalingType = ScalingType.SCALE_ASPECT_BALANCED;
            this.visibleFractionMatchOrientation = RendererCommon.convertScalingTypeToVisibleFraction(scalingType);
            this.visibleFractionMismatchOrientation = RendererCommon.convertScalingTypeToVisibleFraction(scalingType);
        }

        public Point measure(int i8, int i9, int i10, int i11) {
            int defaultSize = View.getDefaultSize(Api.BaseClientBuilder.API_PRIORITY_OTHER, i8);
            int defaultSize2 = View.getDefaultSize(Api.BaseClientBuilder.API_PRIORITY_OTHER, i9);
            if (i10 == 0 || i11 == 0 || defaultSize == 0 || defaultSize2 == 0) {
                return new Point(defaultSize, defaultSize2);
            }
            float f8 = i10 / i11;
            Point displaySize = RendererCommon.getDisplaySize(((f8 > 1.0f ? 1 : (f8 == 1.0f ? 0 : -1)) > 0) == (((float) defaultSize) / ((float) defaultSize2) > 1.0f) ? this.visibleFractionMatchOrientation : this.visibleFractionMismatchOrientation, f8, defaultSize, defaultSize2);
            if (View.MeasureSpec.getMode(i8) == 1073741824) {
                displaySize.x = defaultSize;
            }
            if (View.MeasureSpec.getMode(i9) == 1073741824) {
                displaySize.y = defaultSize2;
            }
            return displaySize;
        }

        public void setScalingType(ScalingType scalingType) {
            setScalingType(scalingType, scalingType);
        }

        public void setScalingType(ScalingType scalingType, ScalingType scalingType2) {
            this.visibleFractionMatchOrientation = RendererCommon.convertScalingTypeToVisibleFraction(scalingType);
            this.visibleFractionMismatchOrientation = RendererCommon.convertScalingTypeToVisibleFraction(scalingType2);
        }

        public void setVisibleFraction(float f8, float f9) {
            this.visibleFractionMatchOrientation = f8;
            this.visibleFractionMismatchOrientation = f9;
        }
    }

    private static void adjustOrigin(float[] fArr) {
        float f8 = fArr[12] - ((fArr[0] + fArr[4]) * 0.5f);
        fArr[12] = f8;
        float f9 = fArr[13] - ((fArr[1] + fArr[5]) * 0.5f);
        fArr[13] = f9;
        fArr[12] = f8 + 0.5f;
        fArr[13] = f9 + 0.5f;
    }

    public static float[] convertMatrixFromAndroidGraphicsMatrix(Matrix matrix) {
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        return new float[]{fArr[0], fArr[3], 0.0f, fArr[6], fArr[1], fArr[4], 0.0f, fArr[7], 0.0f, 0.0f, 1.0f, 0.0f, fArr[2], fArr[5], 0.0f, fArr[8]};
    }

    public static Matrix convertMatrixToAndroidGraphicsMatrix(float[] fArr) {
        float[] fArr2 = {fArr[0], fArr[4], fArr[12], fArr[1], fArr[5], fArr[13], fArr[3], fArr[7], fArr[15]};
        Matrix matrix = new Matrix();
        matrix.setValues(fArr2);
        return matrix;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static float convertScalingTypeToVisibleFraction(ScalingType scalingType) {
        int i8 = AnonymousClass1.$SwitchMap$org$webrtc$RendererCommon$ScalingType[scalingType.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 == 3) {
                    return BALANCED_VISIBLE_FRACTION;
                }
                throw new IllegalArgumentException();
            }
            return 0.0f;
        }
        return 1.0f;
    }

    public static Point getDisplaySize(float f8, float f9, int i8, int i9) {
        return (f8 == 0.0f || f9 == 0.0f) ? new Point(i8, i9) : new Point(Math.min(i8, Math.round((i9 / f8) * f9)), Math.min(i9, Math.round((i8 / f8) / f9)));
    }

    public static Point getDisplaySize(ScalingType scalingType, float f8, int i8, int i9) {
        return getDisplaySize(convertScalingTypeToVisibleFraction(scalingType), f8, i8, i9);
    }

    public static float[] getLayoutMatrix(boolean z7, float f8, float f9) {
        float f10;
        float f11;
        if (f9 > f8) {
            f11 = f8 / f9;
            f10 = 1.0f;
        } else {
            f10 = f9 / f8;
            f11 = 1.0f;
        }
        if (z7) {
            f10 *= -1.0f;
        }
        float[] fArr = new float[16];
        android.opengl.Matrix.setIdentityM(fArr, 0);
        android.opengl.Matrix.scaleM(fArr, 0, f10, f11, 1.0f);
        adjustOrigin(fArr);
        return fArr;
    }
}
