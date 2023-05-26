package com.clevertap.android.sdk;

import android.content.Context;
import com.clevertap.android.sdk.db.DBManager;
import com.clevertap.android.sdk.events.EventMediator;
import com.clevertap.android.sdk.events.EventQueueManager;
import com.clevertap.android.sdk.featureFlags.CTFeatureFlagsFactory;
import com.clevertap.android.sdk.inapp.InAppController;
import com.clevertap.android.sdk.login.LoginController;
import com.clevertap.android.sdk.network.NetworkManager;
import com.clevertap.android.sdk.pushnotification.PushProviders;
import com.clevertap.android.sdk.task.MainLooperHandler;
import com.clevertap.android.sdk.validation.ValidationResultStack;
import com.clevertap.android.sdk.validation.Validator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class CleverTapFactory {
    CleverTapFactory() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CoreState a(Context context, CleverTapInstanceConfig cleverTapInstanceConfig, String str) {
        CoreState coreState = new CoreState(context);
        CoreMetaData coreMetaData = new CoreMetaData();
        coreState.t(coreMetaData);
        Validator validator = new Validator();
        ValidationResultStack validationResultStack = new ValidationResultStack();
        coreState.F(validationResultStack);
        CTLockManager cTLockManager = new CTLockManager();
        coreState.p(cTLockManager);
        MainLooperHandler mainLooperHandler = new MainLooperHandler();
        coreState.B(mainLooperHandler);
        CleverTapInstanceConfig cleverTapInstanceConfig2 = new CleverTapInstanceConfig(cleverTapInstanceConfig);
        coreState.r(cleverTapInstanceConfig2);
        EventMediator eventMediator = new EventMediator(context, cleverTapInstanceConfig2, coreMetaData);
        coreState.w(eventMediator);
        LocalDataStore localDataStore = new LocalDataStore(context, cleverTapInstanceConfig2);
        coreState.y(localDataStore);
        DeviceInfo deviceInfo = new DeviceInfo(context, cleverTapInstanceConfig2, str, coreMetaData);
        coreState.v(deviceInfo);
        CallbackManager callbackManager = new CallbackManager(cleverTapInstanceConfig2, deviceInfo);
        coreState.q(callbackManager);
        SessionManager sessionManager = new SessionManager(cleverTapInstanceConfig2, coreMetaData, validator, localDataStore);
        coreState.E(sessionManager);
        DBManager dBManager = new DBManager(cleverTapInstanceConfig2, cTLockManager);
        coreState.u(dBManager);
        ControllerManager controllerManager = new ControllerManager(context, cleverTapInstanceConfig2, cTLockManager, callbackManager, deviceInfo, dBManager);
        coreState.s(controllerManager);
        if (coreState.g() != null && coreState.g().x() != null && controllerManager.h() == null) {
            coreState.e().n().s(cleverTapInstanceConfig2.c() + ":async_deviceID", "Initializing InAppFC with device Id = " + coreState.g().x());
            controllerManager.p(new InAppFCManager(context, cleverTapInstanceConfig2, coreState.g().x()));
        }
        NetworkManager networkManager = new NetworkManager(context, cleverTapInstanceConfig2, deviceInfo, coreMetaData, validationResultStack, controllerManager, dBManager, callbackManager, cTLockManager, validator, localDataStore);
        coreState.C(networkManager);
        EventQueueManager eventQueueManager = new EventQueueManager(dBManager, context, cleverTapInstanceConfig2, eventMediator, sessionManager, callbackManager, mainLooperHandler, deviceInfo, validationResultStack, networkManager, coreMetaData, cTLockManager, localDataStore);
        coreState.o(eventQueueManager);
        AnalyticsManager analyticsManager = new AnalyticsManager(context, cleverTapInstanceConfig2, eventQueueManager, validator, validationResultStack, coreMetaData, localDataStore, deviceInfo, callbackManager, controllerManager, cTLockManager);
        coreState.n(analyticsManager);
        InAppController inAppController = new InAppController(context, cleverTapInstanceConfig2, mainLooperHandler, controllerManager, callbackManager, analyticsManager, coreMetaData);
        coreState.x(inAppController);
        coreState.f().o(inAppController);
        b(context, controllerManager, cleverTapInstanceConfig2, deviceInfo, callbackManager, analyticsManager);
        coreState.z(new LocationManager(context, cleverTapInstanceConfig2, coreMetaData, eventQueueManager));
        PushProviders J = PushProviders.J(context, cleverTapInstanceConfig2, dBManager, validationResultStack, analyticsManager, controllerManager);
        coreState.D(J);
        coreState.m(new ActivityLifeCycleManager(context, cleverTapInstanceConfig2, analyticsManager, coreMetaData, sessionManager, J, callbackManager, inAppController, eventQueueManager));
        coreState.A(new LoginController(context, cleverTapInstanceConfig2, deviceInfo, validationResultStack, eventQueueManager, analyticsManager, coreMetaData, controllerManager, sessionManager, localDataStore, callbackManager, dBManager, cTLockManager));
        return coreState;
    }

    static void b(Context context, ControllerManager controllerManager, CleverTapInstanceConfig cleverTapInstanceConfig, DeviceInfo deviceInfo, BaseCallbackManager baseCallbackManager, AnalyticsManager analyticsManager) {
        cleverTapInstanceConfig.n().s(cleverTapInstanceConfig.c() + ":async_deviceID", "Initializing Feature Flags with device Id = " + deviceInfo.x());
        if (cleverTapInstanceConfig.p()) {
            cleverTapInstanceConfig.n().f(cleverTapInstanceConfig.c(), "Feature Flag is not enabled for this instance");
            return;
        }
        controllerManager.l(CTFeatureFlagsFactory.a(context, deviceInfo.x(), cleverTapInstanceConfig, baseCallbackManager, analyticsManager));
        cleverTapInstanceConfig.n().s(cleverTapInstanceConfig.c() + ":async_deviceID", "Feature Flags initialized");
    }
}
