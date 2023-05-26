package com.mixpanel.android.viewcrawler;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.mixpanel.android.util.MPLog;

/* loaded from: classes3.dex */
class FlipGesture implements SensorEventListener {

    /* renamed from: a  reason: collision with root package name */
    private int f19474a = -1;

    /* renamed from: b  reason: collision with root package name */
    private int f19475b = 0;

    /* renamed from: c  reason: collision with root package name */
    private long f19476c = -1;

    /* renamed from: d  reason: collision with root package name */
    private final float[] f19477d = new float[3];

    /* renamed from: e  reason: collision with root package name */
    private final OnFlipGestureListener f19478e;

    /* loaded from: classes3.dex */
    public interface OnFlipGestureListener {
        void a();
    }

    public FlipGesture(OnFlipGestureListener onFlipGestureListener) {
        this.f19478e = onFlipGestureListener;
    }

    private float[] a(float[] fArr) {
        float f8;
        for (int i8 = 0; i8 < 3; i8++) {
            float[] fArr2 = this.f19477d;
            if (i8 < fArr2.length) {
                f8 = fArr2[i8];
            } else {
                f8 = 0.0f;
            }
            fArr2[i8] = f8 + ((fArr[i8] - f8) * 0.7f);
        }
        return this.f19477d;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i8) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        float[] a8 = a(sensorEvent.values);
        int i8 = this.f19475b;
        float f8 = a8[0];
        float f9 = a8[1];
        float f10 = a8[2];
        float f11 = (f8 * f8) + (f9 * f9) + (f10 * f10);
        this.f19475b = 0;
        if (f10 > 7.8f && f10 < 11.8f) {
            this.f19475b = -1;
        }
        if (f10 < -7.8f && f10 > -11.8f) {
            this.f19475b = 1;
        }
        if (f11 < 60.840004f || f11 > 139.24f) {
            this.f19475b = 0;
        }
        int i9 = this.f19475b;
        if (i8 != i9) {
            this.f19476c = sensorEvent.timestamp;
        }
        long j8 = sensorEvent.timestamp - this.f19476c;
        if (i9 != -1) {
            if (i9 != 0) {
                if (i9 == 1 && j8 > 250000000 && this.f19474a == 0) {
                    MPLog.i("MixpanelAPI.FlipGesture", "Flip gesture begun");
                    this.f19474a = 1;
                }
            } else if (j8 > 1000000000 && this.f19474a != 0) {
                MPLog.i("MixpanelAPI.FlipGesture", "Flip gesture abandoned");
                this.f19474a = 0;
            }
        } else if (j8 > 250000000 && this.f19474a == 1) {
            MPLog.i("MixpanelAPI.FlipGesture", "Flip gesture completed");
            this.f19474a = 0;
            this.f19478e.a();
        }
    }
}
