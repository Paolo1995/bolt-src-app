package com.yalantis.ucrop.util;

import android.view.MotionEvent;
import androidx.annotation.NonNull;

/* loaded from: classes3.dex */
public class RotationGestureDetector {
    private static final int INVALID_POINTER_INDEX = -1;
    private float fX;
    private float fY;
    private float mAngle;
    private boolean mIsFirstTouch;
    private OnRotationGestureListener mListener;
    private int mPointerIndex1 = -1;
    private int mPointerIndex2 = -1;
    private float sX;
    private float sY;

    /* loaded from: classes3.dex */
    public interface OnRotationGestureListener {
        boolean onRotation(RotationGestureDetector rotationGestureDetector);
    }

    /* loaded from: classes3.dex */
    public static class SimpleOnRotationGestureListener implements OnRotationGestureListener {
        @Override // com.yalantis.ucrop.util.RotationGestureDetector.OnRotationGestureListener
        public boolean onRotation(RotationGestureDetector rotationGestureDetector) {
            return false;
        }
    }

    public RotationGestureDetector(OnRotationGestureListener onRotationGestureListener) {
        this.mListener = onRotationGestureListener;
    }

    private float calculateAngleBetweenLines(float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15) {
        return calculateAngleDelta((float) Math.toDegrees((float) Math.atan2(f9 - f11, f8 - f10)), (float) Math.toDegrees((float) Math.atan2(f13 - f15, f12 - f14)));
    }

    private float calculateAngleDelta(float f8, float f9) {
        float f10 = (f9 % 360.0f) - (f8 % 360.0f);
        this.mAngle = f10;
        if (f10 < -180.0f) {
            this.mAngle = f10 + 360.0f;
        } else if (f10 > 180.0f) {
            this.mAngle = f10 - 360.0f;
        }
        return this.mAngle;
    }

    public float getAngle() {
        return this.mAngle;
    }

    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 5) {
                        if (actionMasked == 6) {
                            this.mPointerIndex2 = -1;
                        }
                    } else {
                        this.fX = motionEvent.getX();
                        this.fY = motionEvent.getY();
                        this.mPointerIndex2 = motionEvent.findPointerIndex(motionEvent.getPointerId(motionEvent.getActionIndex()));
                        this.mAngle = 0.0f;
                        this.mIsFirstTouch = true;
                    }
                } else if (this.mPointerIndex1 != -1 && this.mPointerIndex2 != -1 && motionEvent.getPointerCount() > this.mPointerIndex2) {
                    float x7 = motionEvent.getX(this.mPointerIndex1);
                    float y7 = motionEvent.getY(this.mPointerIndex1);
                    float x8 = motionEvent.getX(this.mPointerIndex2);
                    float y8 = motionEvent.getY(this.mPointerIndex2);
                    if (this.mIsFirstTouch) {
                        this.mAngle = 0.0f;
                        this.mIsFirstTouch = false;
                    } else {
                        calculateAngleBetweenLines(this.fX, this.fY, this.sX, this.sY, x8, y8, x7, y7);
                    }
                    OnRotationGestureListener onRotationGestureListener = this.mListener;
                    if (onRotationGestureListener != null) {
                        onRotationGestureListener.onRotation(this);
                    }
                    this.fX = x8;
                    this.fY = y8;
                    this.sX = x7;
                    this.sY = y7;
                }
            } else {
                this.mPointerIndex1 = -1;
            }
        } else {
            this.sX = motionEvent.getX();
            this.sY = motionEvent.getY();
            this.mPointerIndex1 = motionEvent.findPointerIndex(motionEvent.getPointerId(0));
            this.mAngle = 0.0f;
            this.mIsFirstTouch = true;
        }
        return true;
    }
}
