package com.clevertap.android.sdk;

import android.content.Context;
import com.clevertap.android.sdk.db.BaseDatabaseManager;
import com.clevertap.android.sdk.displayunits.CTDisplayUnitController;
import com.clevertap.android.sdk.featureFlags.CTFeatureFlagsController;
import com.clevertap.android.sdk.inapp.InAppController;
import com.clevertap.android.sdk.inbox.CTInboxController;
import com.clevertap.android.sdk.product_config.CTProductConfigController;
import com.clevertap.android.sdk.pushnotification.PushProviders;
import com.clevertap.android.sdk.task.CTExecutorFactory;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public class ControllerManager {

    /* renamed from: a  reason: collision with root package name */
    private InAppFCManager f10930a;

    /* renamed from: b  reason: collision with root package name */
    private final BaseDatabaseManager f10931b;

    /* renamed from: c  reason: collision with root package name */
    private CTDisplayUnitController f10932c;

    /* renamed from: d  reason: collision with root package name */
    private CTFeatureFlagsController f10933d;

    /* renamed from: e  reason: collision with root package name */
    private CTInboxController f10934e;

    /* renamed from: f  reason: collision with root package name */
    private final CTLockManager f10935f;

    /* renamed from: g  reason: collision with root package name */
    private CTProductConfigController f10936g;

    /* renamed from: h  reason: collision with root package name */
    private final BaseCallbackManager f10937h;

    /* renamed from: i  reason: collision with root package name */
    private final CleverTapInstanceConfig f10938i;

    /* renamed from: j  reason: collision with root package name */
    private final Context f10939j;

    /* renamed from: k  reason: collision with root package name */
    private final DeviceInfo f10940k;

    /* renamed from: l  reason: collision with root package name */
    private InAppController f10941l;

    /* renamed from: m  reason: collision with root package name */
    private PushProviders f10942m;

    public ControllerManager(Context context, CleverTapInstanceConfig cleverTapInstanceConfig, CTLockManager cTLockManager, BaseCallbackManager baseCallbackManager, DeviceInfo deviceInfo, BaseDatabaseManager baseDatabaseManager) {
        this.f10938i = cleverTapInstanceConfig;
        this.f10935f = cTLockManager;
        this.f10937h = baseCallbackManager;
        this.f10940k = deviceInfo;
        this.f10939j = context;
        this.f10931b = baseDatabaseManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        synchronized (this.f10935f.b()) {
            if (e() != null) {
                this.f10937h.a();
                return;
            }
            if (this.f10940k.x() != null) {
                m(new CTInboxController(this.f10938i, this.f10940k.x(), this.f10931b.c(this.f10939j), this.f10935f, this.f10937h, Utils.f11091a));
                this.f10937h.a();
            } else {
                this.f10938i.n().l("CRITICAL : No device ID found!");
            }
        }
    }

    public CTDisplayUnitController c() {
        return this.f10932c;
    }

    public CTFeatureFlagsController d() {
        return this.f10933d;
    }

    public CTInboxController e() {
        return this.f10934e;
    }

    public CTProductConfigController f() {
        return this.f10936g;
    }

    public InAppController g() {
        return this.f10941l;
    }

    public InAppFCManager h() {
        return this.f10930a;
    }

    public PushProviders i() {
        return this.f10942m;
    }

    public void j() {
        if (this.f10938i.p()) {
            this.f10938i.n().f(this.f10938i.c(), "Instance is analytics only, not initializing Notification Inbox");
        } else {
            CTExecutorFactory.a(this.f10938i).c().d("initializeInbox", new Callable<Void>() { // from class: com.clevertap.android.sdk.ControllerManager.1
                @Override // java.util.concurrent.Callable
                /* renamed from: a */
                public Void call() {
                    ControllerManager.this.a();
                    return null;
                }
            });
        }
    }

    public void k(CTDisplayUnitController cTDisplayUnitController) {
        this.f10932c = cTDisplayUnitController;
    }

    public void l(CTFeatureFlagsController cTFeatureFlagsController) {
        this.f10933d = cTFeatureFlagsController;
    }

    public void m(CTInboxController cTInboxController) {
        this.f10934e = cTInboxController;
    }

    public void n(CTProductConfigController cTProductConfigController) {
        this.f10936g = cTProductConfigController;
    }

    public void o(InAppController inAppController) {
        this.f10941l = inAppController;
    }

    public void p(InAppFCManager inAppFCManager) {
        this.f10930a = inAppFCManager;
    }

    public void q(PushProviders pushProviders) {
        this.f10942m = pushProviders;
    }
}
