package com.appsflyer.internal;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.Looper;
import androidx.annotation.NonNull;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class AFa1jSDK implements SensorEventListener {
    @NonNull
    private final String AFInAppEventParameterName;
    @NonNull
    private final String AFKeystoreWrapper;
    private double AFLogger;
    private long afErrorLog;
    private final int afInfoLog;
    private Executor afRDLog;
    private final int values;
    private final float[][] AFInAppEventType = new float[2];
    private final long[] valueOf = new long[2];

    /* JADX INFO: Access modifiers changed from: package-private */
    public AFa1jSDK(Sensor sensor) {
        int type = sensor.getType();
        this.values = type;
        String name = sensor.getName();
        name = name == null ? "" : name;
        this.AFKeystoreWrapper = name;
        String vendor = sensor.getVendor();
        String str = vendor != null ? vendor : "";
        this.AFInAppEventParameterName = str;
        this.afInfoLog = ((((type + 31) * 31) + name.hashCode()) * 31) + str.hashCode();
    }

    private boolean AFInAppEventParameterName(int i8, @NonNull String str, @NonNull String str2) {
        if (this.values == i8 && this.AFKeystoreWrapper.equals(str) && this.AFInAppEventParameterName.equals(str2)) {
            return true;
        }
        return false;
    }

    private static double AFInAppEventType(@NonNull float[] fArr, @NonNull float[] fArr2) {
        int min = Math.min(fArr.length, fArr2.length);
        double d8 = 0.0d;
        for (int i8 = 0; i8 < min; i8++) {
            d8 += StrictMath.pow(fArr[i8] - fArr2[i8], 2.0d);
        }
        return Math.sqrt(d8);
    }

    private boolean AFKeystoreWrapper() {
        if (this.AFInAppEventType[0] == null) {
            return false;
        }
        return true;
    }

    @NonNull
    private synchronized Executor valueOf() {
        if (this.afRDLog == null) {
            this.afRDLog = Executors.newSingleThreadExecutor();
        }
        return this.afRDLog;
    }

    @NonNull
    private static List<Float> values(@NonNull float[] fArr) {
        ArrayList arrayList = new ArrayList(fArr.length);
        for (float f8 : fArr) {
            arrayList.add(Float.valueOf(f8));
        }
        return arrayList;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AFa1jSDK) {
            AFa1jSDK aFa1jSDK = (AFa1jSDK) obj;
            return AFInAppEventParameterName(aFa1jSDK.values, aFa1jSDK.AFKeystoreWrapper, aFa1jSDK.AFInAppEventParameterName);
        }
        return false;
    }

    public final int hashCode() {
        return this.afInfoLog;
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i8) {
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(final SensorEvent sensorEvent) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            valueOf().execute(new Runnable() { // from class: com.appsflyer.internal.a
                @Override // java.lang.Runnable
                public final void run() {
                    AFa1jSDK.this.values(sensorEvent);
                }
            });
        } else {
            values(sensorEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: AFInAppEventType */
    public void values(SensorEvent sensorEvent) {
        long j8 = sensorEvent.timestamp;
        float[] fArr = sensorEvent.values;
        long currentTimeMillis = System.currentTimeMillis();
        float[][] fArr2 = this.AFInAppEventType;
        float[] fArr3 = fArr2[0];
        if (fArr3 == null) {
            fArr2[0] = Arrays.copyOf(fArr, fArr.length);
            this.valueOf[0] = currentTimeMillis;
            return;
        }
        float[] fArr4 = fArr2[1];
        if (fArr4 == null) {
            float[] copyOf = Arrays.copyOf(fArr, fArr.length);
            this.AFInAppEventType[1] = copyOf;
            this.valueOf[1] = currentTimeMillis;
            this.AFLogger = AFInAppEventType(fArr3, copyOf);
        } else if (50000000 <= j8 - this.afErrorLog) {
            this.afErrorLog = j8;
            if (Arrays.equals(fArr4, fArr)) {
                this.valueOf[1] = currentTimeMillis;
                return;
            }
            double AFInAppEventType = AFInAppEventType(fArr3, fArr);
            if (AFInAppEventType > this.AFLogger) {
                this.AFInAppEventType[1] = Arrays.copyOf(fArr, fArr.length);
                this.valueOf[1] = currentTimeMillis;
                this.AFLogger = AFInAppEventType;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void values(@NonNull Map<AFa1jSDK, Map<String, Object>> map, boolean z7) {
        if (AFKeystoreWrapper()) {
            map.put(this, values());
            if (z7) {
                int length = this.AFInAppEventType.length;
                for (int i8 = 0; i8 < length; i8++) {
                    this.AFInAppEventType[i8] = null;
                }
                int length2 = this.valueOf.length;
                for (int i9 = 0; i9 < length2; i9++) {
                    this.valueOf[i9] = 0;
                }
                this.AFLogger = 0.0d;
                this.afErrorLog = 0L;
            }
        } else if (!map.containsKey(this)) {
            map.put(this, values());
        }
    }

    @NonNull
    private Map<String, Object> values() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(7);
        concurrentHashMap.put("sT", Integer.valueOf(this.values));
        concurrentHashMap.put("sN", this.AFKeystoreWrapper);
        concurrentHashMap.put("sV", this.AFInAppEventParameterName);
        float[] fArr = this.AFInAppEventType[0];
        if (fArr != null) {
            concurrentHashMap.put("sVS", values(fArr));
        }
        float[] fArr2 = this.AFInAppEventType[1];
        if (fArr2 != null) {
            concurrentHashMap.put("sVE", values(fArr2));
        }
        return concurrentHashMap;
    }
}
