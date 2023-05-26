package com.clevertap.android.sdk;

import android.content.Context;
import com.clevertap.android.sdk.db.BaseDatabaseManager;
import com.clevertap.android.sdk.events.BaseEventQueueManager;
import com.clevertap.android.sdk.events.EventMediator;
import com.clevertap.android.sdk.inapp.InAppController;
import com.clevertap.android.sdk.login.LoginController;
import com.clevertap.android.sdk.network.BaseNetworkManager;
import com.clevertap.android.sdk.pushnotification.PushProviders;
import com.clevertap.android.sdk.task.MainLooperHandler;
import com.clevertap.android.sdk.validation.ValidationResultStack;

/* loaded from: classes.dex */
public class CoreState extends CleverTapState {

    /* renamed from: b  reason: collision with root package name */
    private BaseLocationManager f10970b;

    /* renamed from: c  reason: collision with root package name */
    private CleverTapInstanceConfig f10971c;

    /* renamed from: d  reason: collision with root package name */
    private CoreMetaData f10972d;

    /* renamed from: e  reason: collision with root package name */
    private BaseDatabaseManager f10973e;

    /* renamed from: f  reason: collision with root package name */
    private DeviceInfo f10974f;

    /* renamed from: g  reason: collision with root package name */
    private EventMediator f10975g;

    /* renamed from: h  reason: collision with root package name */
    private LocalDataStore f10976h;

    /* renamed from: i  reason: collision with root package name */
    private ActivityLifeCycleManager f10977i;

    /* renamed from: j  reason: collision with root package name */
    private AnalyticsManager f10978j;

    /* renamed from: k  reason: collision with root package name */
    private BaseEventQueueManager f10979k;

    /* renamed from: l  reason: collision with root package name */
    private CTLockManager f10980l;

    /* renamed from: m  reason: collision with root package name */
    private BaseCallbackManager f10981m;

    /* renamed from: n  reason: collision with root package name */
    private ControllerManager f10982n;

    /* renamed from: o  reason: collision with root package name */
    private InAppController f10983o;

    /* renamed from: p  reason: collision with root package name */
    private LoginController f10984p;

    /* renamed from: q  reason: collision with root package name */
    private SessionManager f10985q;

    /* renamed from: r  reason: collision with root package name */
    private ValidationResultStack f10986r;

    /* renamed from: s  reason: collision with root package name */
    private MainLooperHandler f10987s;

    /* renamed from: t  reason: collision with root package name */
    private BaseNetworkManager f10988t;

    /* renamed from: u  reason: collision with root package name */
    private PushProviders f10989u;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CoreState(Context context) {
        super(context);
    }

    public void A(LoginController loginController) {
        this.f10984p = loginController;
    }

    public void B(MainLooperHandler mainLooperHandler) {
        this.f10987s = mainLooperHandler;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void C(BaseNetworkManager baseNetworkManager) {
        this.f10988t = baseNetworkManager;
    }

    public void D(PushProviders pushProviders) {
        this.f10989u = pushProviders;
    }

    public void E(SessionManager sessionManager) {
        this.f10985q = sessionManager;
    }

    public void F(ValidationResultStack validationResultStack) {
        this.f10986r = validationResultStack;
    }

    public ActivityLifeCycleManager a() {
        return this.f10977i;
    }

    public AnalyticsManager b() {
        return this.f10978j;
    }

    public CTLockManager c() {
        return this.f10980l;
    }

    public BaseCallbackManager d() {
        return this.f10981m;
    }

    public CleverTapInstanceConfig e() {
        return this.f10971c;
    }

    public ControllerManager f() {
        return this.f10982n;
    }

    public DeviceInfo g() {
        return this.f10974f;
    }

    public InAppController h() {
        return this.f10983o;
    }

    public LocalDataStore i() {
        return this.f10976h;
    }

    public LoginController j() {
        return this.f10984p;
    }

    public PushProviders k() {
        return this.f10989u;
    }

    public SessionManager l() {
        return this.f10985q;
    }

    public void m(ActivityLifeCycleManager activityLifeCycleManager) {
        this.f10977i = activityLifeCycleManager;
    }

    public void n(AnalyticsManager analyticsManager) {
        this.f10978j = analyticsManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(BaseEventQueueManager baseEventQueueManager) {
        this.f10979k = baseEventQueueManager;
    }

    public void p(CTLockManager cTLockManager) {
        this.f10980l = cTLockManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(BaseCallbackManager baseCallbackManager) {
        this.f10981m = baseCallbackManager;
    }

    public void r(CleverTapInstanceConfig cleverTapInstanceConfig) {
        this.f10971c = cleverTapInstanceConfig;
    }

    public void s(ControllerManager controllerManager) {
        this.f10982n = controllerManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(CoreMetaData coreMetaData) {
        this.f10972d = coreMetaData;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(BaseDatabaseManager baseDatabaseManager) {
        this.f10973e = baseDatabaseManager;
    }

    public void v(DeviceInfo deviceInfo) {
        this.f10974f = deviceInfo;
    }

    public void w(EventMediator eventMediator) {
        this.f10975g = eventMediator;
    }

    public void x(InAppController inAppController) {
        this.f10983o = inAppController;
    }

    public void y(LocalDataStore localDataStore) {
        this.f10976h = localDataStore;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z(BaseLocationManager baseLocationManager) {
        this.f10970b = baseLocationManager;
    }
}
