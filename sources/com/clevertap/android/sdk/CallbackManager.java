package com.clevertap.android.sdk;

import com.clevertap.android.sdk.displayunits.DisplayUnitListener;
import com.clevertap.android.sdk.displayunits.model.CleverTapDisplayUnit;
import com.clevertap.android.sdk.interfaces.OnInitCleverTapIDListener;
import com.clevertap.android.sdk.product_config.CTProductConfigListener;
import com.clevertap.android.sdk.pushnotification.CTPushNotificationListener;
import com.clevertap.android.sdk.pushnotification.amp.CTPushAmpListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class CallbackManager extends BaseCallbackManager {

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<DisplayUnitListener> f10857a;

    /* renamed from: b  reason: collision with root package name */
    private GeofenceCallback f10858b;

    /* renamed from: c  reason: collision with root package name */
    private WeakReference<InAppNotificationButtonListener> f10859c;

    /* renamed from: d  reason: collision with root package name */
    private InAppNotificationListener f10860d;

    /* renamed from: e  reason: collision with root package name */
    private CTInboxListener f10861e;

    /* renamed from: f  reason: collision with root package name */
    private final CleverTapInstanceConfig f10862f;

    /* renamed from: g  reason: collision with root package name */
    private final DeviceInfo f10863g;

    /* renamed from: h  reason: collision with root package name */
    private FailureFlushListener f10864h;

    /* renamed from: i  reason: collision with root package name */
    private WeakReference<CTFeatureFlagsListener> f10865i;

    /* renamed from: j  reason: collision with root package name */
    private OnInitCleverTapIDListener f10866j;

    /* renamed from: k  reason: collision with root package name */
    private WeakReference<CTProductConfigListener> f10867k;

    /* renamed from: l  reason: collision with root package name */
    private CTPushAmpListener f10868l = null;

    /* renamed from: m  reason: collision with root package name */
    private CTPushNotificationListener f10869m = null;

    /* renamed from: n  reason: collision with root package name */
    private SyncListener f10870n = null;

    public CallbackManager(CleverTapInstanceConfig cleverTapInstanceConfig, DeviceInfo deviceInfo) {
        this.f10862f = cleverTapInstanceConfig;
        this.f10863g = deviceInfo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.clevertap.android.sdk.BaseCallbackManager
    public void a() {
        CTInboxListener cTInboxListener = this.f10861e;
        if (cTInboxListener != null) {
            cTInboxListener.b();
        }
    }

    @Override // com.clevertap.android.sdk.BaseCallbackManager
    public void b() {
        if (this.f10861e != null) {
            Utils.v(new Runnable() { // from class: com.clevertap.android.sdk.CallbackManager.1
                @Override // java.lang.Runnable
                public void run() {
                    if (CallbackManager.this.f10861e != null) {
                        CallbackManager.this.f10861e.a();
                    }
                }
            });
        }
    }

    @Override // com.clevertap.android.sdk.BaseCallbackManager
    public FailureFlushListener c() {
        return this.f10864h;
    }

    @Override // com.clevertap.android.sdk.BaseCallbackManager
    public CTFeatureFlagsListener d() {
        WeakReference<CTFeatureFlagsListener> weakReference = this.f10865i;
        if (weakReference != null && weakReference.get() != null) {
            return this.f10865i.get();
        }
        return null;
    }

    @Override // com.clevertap.android.sdk.BaseCallbackManager
    public GeofenceCallback e() {
        return this.f10858b;
    }

    @Override // com.clevertap.android.sdk.BaseCallbackManager
    public InAppNotificationButtonListener f() {
        WeakReference<InAppNotificationButtonListener> weakReference = this.f10859c;
        if (weakReference != null && weakReference.get() != null) {
            return this.f10859c.get();
        }
        return null;
    }

    @Override // com.clevertap.android.sdk.BaseCallbackManager
    public InAppNotificationListener g() {
        return this.f10860d;
    }

    @Override // com.clevertap.android.sdk.BaseCallbackManager
    public OnInitCleverTapIDListener h() {
        return this.f10866j;
    }

    @Override // com.clevertap.android.sdk.BaseCallbackManager
    public CTProductConfigListener i() {
        WeakReference<CTProductConfigListener> weakReference = this.f10867k;
        if (weakReference != null && weakReference.get() != null) {
            return this.f10867k.get();
        }
        return null;
    }

    @Override // com.clevertap.android.sdk.BaseCallbackManager
    public CTPushAmpListener j() {
        return this.f10868l;
    }

    @Override // com.clevertap.android.sdk.BaseCallbackManager
    public CTPushNotificationListener k() {
        return this.f10869m;
    }

    @Override // com.clevertap.android.sdk.BaseCallbackManager
    public SyncListener l() {
        return this.f10870n;
    }

    @Override // com.clevertap.android.sdk.BaseCallbackManager
    public void m(final ArrayList<CleverTapDisplayUnit> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            WeakReference<DisplayUnitListener> weakReference = this.f10857a;
            if (weakReference != null && weakReference.get() != null) {
                Utils.v(new Runnable() { // from class: com.clevertap.android.sdk.CallbackManager.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (CallbackManager.this.f10857a != null && CallbackManager.this.f10857a.get() != null) {
                            ((DisplayUnitListener) CallbackManager.this.f10857a.get()).a(arrayList);
                        }
                    }
                });
                return;
            } else {
                this.f10862f.n().s(this.f10862f.c(), "DisplayUnit : No registered listener, failed to notify");
                return;
            }
        }
        this.f10862f.n().s(this.f10862f.c(), "DisplayUnit : No Display Units found");
    }

    @Override // com.clevertap.android.sdk.BaseCallbackManager
    public void n(String str) {
        if (str == null) {
            str = this.f10863g.x();
        }
        if (str == null) {
            return;
        }
        try {
            SyncListener l8 = l();
            if (l8 != null) {
                l8.b(str);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.clevertap.android.sdk.BaseCallbackManager
    public void o(FailureFlushListener failureFlushListener) {
        this.f10864h = failureFlushListener;
    }

    @Override // com.clevertap.android.sdk.BaseCallbackManager
    public void p(CTInboxListener cTInboxListener) {
        this.f10861e = cTInboxListener;
    }
}
