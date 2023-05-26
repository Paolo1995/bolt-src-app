package com.sinch.android.rtc.internal.client.audio;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import org.webrtc.ThreadUtils;
import org.webrtc.audio.WebRtcAudioUtils;

/* loaded from: classes3.dex */
public class WebRtcProximitySensor implements SensorEventListener {
    private static final String TAG = "WebRtcProximitySensor";
    private final Runnable onSensorStateListener;
    private final SensorManager sensorManager;
    private final ThreadUtils.ThreadChecker threadChecker = new ThreadUtils.ThreadChecker();
    private Sensor proximitySensor = null;
    private boolean lastStateReportIsNear = false;

    private WebRtcProximitySensor(Context context, Runnable runnable) {
        Log.d(TAG, TAG + WebRtcAudioUtils.getThreadInfo());
        this.onSensorStateListener = runnable;
        this.sensorManager = (SensorManager) context.getSystemService("sensor");
    }

    public static WebRtcProximitySensor create(Context context, Runnable runnable) {
        return new WebRtcProximitySensor(context, runnable);
    }

    private boolean initDefaultSensor() {
        if (this.proximitySensor != null) {
            return true;
        }
        Sensor defaultSensor = this.sensorManager.getDefaultSensor(8);
        this.proximitySensor = defaultSensor;
        if (defaultSensor == null) {
            return false;
        }
        logProximitySensorInfo();
        return true;
    }

    private void logProximitySensorInfo() {
        if (this.proximitySensor == null) {
            return;
        }
        Log.d(TAG, "Proximity sensor: name=" + this.proximitySensor.getName() + ", vendor: " + this.proximitySensor.getVendor() + ", power: " + this.proximitySensor.getPower() + ", resolution: " + this.proximitySensor.getResolution() + ", max range: " + this.proximitySensor.getMaximumRange() + ", min delay: " + this.proximitySensor.getMinDelay() + ", type: " + this.proximitySensor.getStringType() + ", max delay: " + this.proximitySensor.getMaxDelay() + ", reporting mode: " + this.proximitySensor.getReportingMode() + ", isWakeUpSensor: " + this.proximitySensor.isWakeUpSensor());
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i8) {
        this.threadChecker.checkIsOnValidThread();
        WebRtcAudioUtils.assertIsTrue(sensor.getType() == 8);
        if (i8 == 0) {
            Log.e(TAG, "The values returned by this sensor cannot be trusted");
        }
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        this.threadChecker.checkIsOnValidThread();
        WebRtcAudioUtils.assertIsTrue(sensorEvent.sensor.getType() == 8);
        if (sensorEvent.values[0] < this.proximitySensor.getMaximumRange()) {
            Log.d(TAG, "Proximity sensor => NEAR state");
            this.lastStateReportIsNear = true;
        } else {
            Log.d(TAG, "Proximity sensor => FAR state");
            this.lastStateReportIsNear = false;
        }
        Runnable runnable = this.onSensorStateListener;
        if (runnable != null) {
            runnable.run();
        }
        Log.d(TAG, "onSensorChanged" + WebRtcAudioUtils.getThreadInfo() + ": accuracy=" + sensorEvent.accuracy + ", timestamp=" + sensorEvent.timestamp + ", distance=" + sensorEvent.values[0]);
    }

    public boolean sensorReportsNearState() {
        this.threadChecker.checkIsOnValidThread();
        return this.lastStateReportIsNear;
    }

    public boolean start() {
        this.threadChecker.checkIsOnValidThread();
        Log.d(TAG, "start" + WebRtcAudioUtils.getThreadInfo());
        if (initDefaultSensor()) {
            this.sensorManager.registerListener(this, this.proximitySensor, 3);
            return true;
        }
        return false;
    }

    public void stop() {
        this.threadChecker.checkIsOnValidThread();
        Log.d(TAG, "stop" + WebRtcAudioUtils.getThreadInfo());
        Sensor sensor = this.proximitySensor;
        if (sensor == null) {
            return;
        }
        this.sensorManager.unregisterListener(this, sensor);
    }
}
