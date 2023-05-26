package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.1.0 */
/* loaded from: classes.dex */
public interface zzcc extends IInterface {
    void beginAdUnitExposure(String str, long j8) throws RemoteException;

    void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException;

    void clearMeasurementEnabled(long j8) throws RemoteException;

    void endAdUnitExposure(String str, long j8) throws RemoteException;

    void generateEventId(zzcf zzcfVar) throws RemoteException;

    void getAppInstanceId(zzcf zzcfVar) throws RemoteException;

    void getCachedAppInstanceId(zzcf zzcfVar) throws RemoteException;

    void getConditionalUserProperties(String str, String str2, zzcf zzcfVar) throws RemoteException;

    void getCurrentScreenClass(zzcf zzcfVar) throws RemoteException;

    void getCurrentScreenName(zzcf zzcfVar) throws RemoteException;

    void getGmpAppId(zzcf zzcfVar) throws RemoteException;

    void getMaxUserProperties(String str, zzcf zzcfVar) throws RemoteException;

    void getTestFlag(zzcf zzcfVar, int i8) throws RemoteException;

    void getUserProperties(String str, String str2, boolean z7, zzcf zzcfVar) throws RemoteException;

    void initForTests(Map map) throws RemoteException;

    void initialize(IObjectWrapper iObjectWrapper, zzcl zzclVar, long j8) throws RemoteException;

    void isDataCollectionEnabled(zzcf zzcfVar) throws RemoteException;

    void logEvent(String str, String str2, Bundle bundle, boolean z7, boolean z8, long j8) throws RemoteException;

    void logEventAndBundle(String str, String str2, Bundle bundle, zzcf zzcfVar, long j8) throws RemoteException;

    void logHealthData(int i8, String str, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException;

    void onActivityCreated(IObjectWrapper iObjectWrapper, Bundle bundle, long j8) throws RemoteException;

    void onActivityDestroyed(IObjectWrapper iObjectWrapper, long j8) throws RemoteException;

    void onActivityPaused(IObjectWrapper iObjectWrapper, long j8) throws RemoteException;

    void onActivityResumed(IObjectWrapper iObjectWrapper, long j8) throws RemoteException;

    void onActivitySaveInstanceState(IObjectWrapper iObjectWrapper, zzcf zzcfVar, long j8) throws RemoteException;

    void onActivityStarted(IObjectWrapper iObjectWrapper, long j8) throws RemoteException;

    void onActivityStopped(IObjectWrapper iObjectWrapper, long j8) throws RemoteException;

    void performAction(Bundle bundle, zzcf zzcfVar, long j8) throws RemoteException;

    void registerOnMeasurementEventListener(zzci zzciVar) throws RemoteException;

    void resetAnalyticsData(long j8) throws RemoteException;

    void setConditionalUserProperty(Bundle bundle, long j8) throws RemoteException;

    void setConsent(Bundle bundle, long j8) throws RemoteException;

    void setConsentThirdParty(Bundle bundle, long j8) throws RemoteException;

    void setCurrentScreen(IObjectWrapper iObjectWrapper, String str, String str2, long j8) throws RemoteException;

    void setDataCollectionEnabled(boolean z7) throws RemoteException;

    void setDefaultEventParameters(Bundle bundle) throws RemoteException;

    void setEventInterceptor(zzci zzciVar) throws RemoteException;

    void setInstanceIdProvider(zzck zzckVar) throws RemoteException;

    void setMeasurementEnabled(boolean z7, long j8) throws RemoteException;

    void setMinimumSessionDuration(long j8) throws RemoteException;

    void setSessionTimeoutDuration(long j8) throws RemoteException;

    void setUserId(String str, long j8) throws RemoteException;

    void setUserProperty(String str, String str2, IObjectWrapper iObjectWrapper, boolean z7, long j8) throws RemoteException;

    void unregisterOnMeasurementEventListener(zzci zzciVar) throws RemoteException;
}
