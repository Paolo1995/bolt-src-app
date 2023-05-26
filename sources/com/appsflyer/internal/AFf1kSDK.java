package com.appsflyer.internal;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

/* loaded from: classes.dex */
public abstract class AFf1kSDK extends Observable {
    public final String AFLogger;
    long afInfoLog;
    public final String valueOf;
    final Runnable values;
    public final Map<String, Object> AFInAppEventType = new HashMap();
    public AFa1wSDK afRDLog = AFa1wSDK.NOT_STARTED;

    /* renamed from: com.appsflyer.internal.AFf1kSDK$2  reason: invalid class name */
    /* loaded from: classes.dex */
    final class AnonymousClass2 implements Observer {
        /* JADX INFO: Access modifiers changed from: package-private */
        public AnonymousClass2() {
        }

        @Override // java.util.Observer
        public final void update(Observable observable, Object obj) {
            AFf1kSDK.this.values.run();
        }
    }

    /* loaded from: classes.dex */
    public enum AFa1wSDK {
        NOT_STARTED,
        STARTED,
        FINISHED
    }

    public AFf1kSDK(String str, String str2, Runnable runnable) {
        this.values = runnable;
        this.valueOf = str2;
        this.AFLogger = str;
    }

    public final void AFInAppEventType() {
        this.AFInAppEventType.put("source", this.valueOf);
        this.AFInAppEventType.put("type", this.AFLogger);
        this.AFInAppEventType.put("latency", Long.valueOf(System.currentTimeMillis() - this.afInfoLog));
        this.afRDLog = AFa1wSDK.FINISHED;
        setChanged();
        notifyObservers();
    }

    public abstract void valueOf(Context context);
}
