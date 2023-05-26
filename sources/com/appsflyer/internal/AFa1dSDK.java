package com.appsflyer.internal;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.annotation.NonNull;
import com.appsflyer.AFLogger;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public final class AFa1dSDK {
    private static final BitSet AFLogger;
    private static volatile AFa1dSDK afDebugLog;
    final Runnable AFInAppEventParameterName;
    boolean AFInAppEventType;
    final Handler AFKeystoreWrapper;
    private long AFLogger$LogLevel;
    private int AFVersionDeclaration;
    private final Map<AFa1jSDK, Map<String, Object>> afErrorLog;
    private final SensorManager afErrorLogForExcManagerOnly;
    private final Map<AFa1jSDK, AFa1jSDK> afInfoLog;
    final Runnable afRDLog;
    private boolean afWarnLog;
    private final Runnable getLevel;
    final Object valueOf = new Object();
    final Runnable values;

    /* renamed from: com.appsflyer.internal.AFa1dSDK$9  reason: invalid class name */
    /* loaded from: classes.dex */
    final class AnonymousClass9 implements Runnable {
        AnonymousClass9() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (!AFa1dSDK.this.afInfoLog.isEmpty()) {
                    for (AFa1jSDK aFa1jSDK : AFa1dSDK.this.afInfoLog.values()) {
                        AFa1dSDK.this.afErrorLogForExcManagerOnly.unregisterListener(aFa1jSDK);
                        aFa1jSDK.values(AFa1dSDK.this.afErrorLog, true);
                    }
                }
            } catch (Throwable th) {
                AFLogger.afErrorLogForExcManagerOnly("error while unregistering listeners", th);
            }
            AFa1dSDK.this.AFVersionDeclaration = 0;
            AFa1dSDK.this.afWarnLog = false;
        }
    }

    static {
        BitSet bitSet = new BitSet(6);
        AFLogger = bitSet;
        bitSet.set(1);
        bitSet.set(2);
        bitSet.set(4);
    }

    private AFa1dSDK(@NonNull SensorManager sensorManager, Handler handler) {
        BitSet bitSet = AFLogger;
        this.afInfoLog = new HashMap(bitSet.size());
        this.afErrorLog = new ConcurrentHashMap(bitSet.size());
        this.values = new Runnable() { // from class: com.appsflyer.internal.AFa1dSDK.4
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (AFa1dSDK.this.valueOf) {
                    final AFa1dSDK aFa1dSDK = AFa1dSDK.this;
                    aFa1dSDK.AFKeystoreWrapper.post(new Runnable() { // from class: com.appsflyer.internal.AFa1dSDK.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            try {
                                for (Sensor sensor : AFa1dSDK.this.afErrorLogForExcManagerOnly.getSensorList(-1)) {
                                    if (AFa1dSDK.values(sensor.getType())) {
                                        AFa1jSDK aFa1jSDK = new AFa1jSDK(sensor);
                                        if (!AFa1dSDK.this.afInfoLog.containsKey(aFa1jSDK)) {
                                            AFa1dSDK.this.afInfoLog.put(aFa1jSDK, aFa1jSDK);
                                        }
                                        AFa1dSDK.this.afErrorLogForExcManagerOnly.registerListener((SensorEventListener) AFa1dSDK.this.afInfoLog.get(aFa1jSDK), sensor, 0, AFa1dSDK.this.AFKeystoreWrapper);
                                    }
                                }
                            } catch (Throwable th) {
                                AFLogger.afErrorLogForExcManagerOnly("registerListeners error", th);
                            }
                            AFa1dSDK.this.afWarnLog = true;
                        }
                    });
                    AFa1dSDK aFa1dSDK2 = AFa1dSDK.this;
                    aFa1dSDK2.AFKeystoreWrapper.postDelayed(aFa1dSDK2.getLevel, 100L);
                    AFa1dSDK.this.AFInAppEventType = true;
                }
            }
        };
        this.AFInAppEventParameterName = new Runnable() { // from class: com.appsflyer.internal.AFa1dSDK.3
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (AFa1dSDK.this.valueOf) {
                    AFa1dSDK aFa1dSDK = AFa1dSDK.this;
                    aFa1dSDK.AFKeystoreWrapper.post(new AnonymousClass9());
                }
            }
        };
        this.afRDLog = new Runnable() { // from class: com.appsflyer.internal.AFa1dSDK.2
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (AFa1dSDK.this.valueOf) {
                    AFa1dSDK aFa1dSDK = AFa1dSDK.this;
                    if (aFa1dSDK.AFInAppEventType) {
                        aFa1dSDK.AFKeystoreWrapper.removeCallbacks(aFa1dSDK.values);
                        AFa1dSDK aFa1dSDK2 = AFa1dSDK.this;
                        aFa1dSDK2.AFKeystoreWrapper.removeCallbacks(aFa1dSDK2.AFInAppEventParameterName);
                        AFa1dSDK aFa1dSDK3 = AFa1dSDK.this;
                        aFa1dSDK3.AFKeystoreWrapper.post(new AnonymousClass9());
                        AFa1dSDK.this.AFInAppEventType = false;
                    }
                }
            }
        };
        this.AFVersionDeclaration = 1;
        this.AFLogger$LogLevel = 0L;
        this.getLevel = new Runnable() { // from class: com.appsflyer.internal.AFa1dSDK.5
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (AFa1dSDK.this.valueOf) {
                    if (AFa1dSDK.this.AFVersionDeclaration == 0) {
                        AFa1dSDK.this.AFVersionDeclaration = 1;
                    }
                    AFa1dSDK aFa1dSDK = AFa1dSDK.this;
                    aFa1dSDK.AFKeystoreWrapper.postDelayed(aFa1dSDK.AFInAppEventParameterName, aFa1dSDK.AFVersionDeclaration * 500);
                }
            }
        };
        this.afErrorLogForExcManagerOnly = sensorManager;
        this.AFKeystoreWrapper = handler;
    }

    @NonNull
    private List<Map<String, Object>> valueOf() {
        synchronized (this.valueOf) {
            if (!this.afInfoLog.isEmpty() && this.afWarnLog) {
                for (AFa1jSDK aFa1jSDK : this.afInfoLog.values()) {
                    aFa1jSDK.values(this.afErrorLog, false);
                }
            }
            if (this.afErrorLog.isEmpty()) {
                return new CopyOnWriteArrayList(Collections.emptyList());
            }
            return new CopyOnWriteArrayList(this.afErrorLog.values());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean values(int i8) {
        return i8 >= 0 && AFLogger.get(i8);
    }

    private static AFa1dSDK AFInAppEventParameterName(SensorManager sensorManager, Handler handler) {
        if (afDebugLog == null) {
            synchronized (AFa1dSDK.class) {
                if (afDebugLog == null) {
                    afDebugLog = new AFa1dSDK(sensorManager, handler);
                }
            }
        }
        return afDebugLog;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AFa1dSDK AFInAppEventType(Context context) {
        if (afDebugLog != null) {
            return afDebugLog;
        }
        HandlerThread handlerThread = new HandlerThread("internal");
        handlerThread.start();
        return AFInAppEventParameterName((SensorManager) context.getApplicationContext().getSystemService("sensor"), new Handler(handlerThread.getLooper()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List<Map<String, Object>> AFKeystoreWrapper() {
        for (AFa1jSDK aFa1jSDK : this.afInfoLog.values()) {
            aFa1jSDK.values(this.afErrorLog, true);
        }
        Map<AFa1jSDK, Map<String, Object>> map = this.afErrorLog;
        if (map != null && !map.isEmpty()) {
            return new CopyOnWriteArrayList(this.afErrorLog.values());
        }
        return new CopyOnWriteArrayList(Collections.emptyList());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Map<String, Object> AFInAppEventParameterName() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        List<Map<String, Object>> valueOf = valueOf();
        if (!valueOf.isEmpty()) {
            concurrentHashMap.put("sensors", valueOf);
        } else {
            List<Map<String, Object>> AFKeystoreWrapper = AFKeystoreWrapper();
            if (!AFKeystoreWrapper.isEmpty()) {
                concurrentHashMap.put("sensors", AFKeystoreWrapper);
            }
        }
        return concurrentHashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void AFInAppEventType() {
        this.AFKeystoreWrapper.post(this.afRDLog);
    }
}
