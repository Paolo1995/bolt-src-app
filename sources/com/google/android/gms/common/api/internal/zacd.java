package com.google.android.gms.common.api.internal;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ConnectionTelemetryConfiguration;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.RootTelemetryConfigManager;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
/* loaded from: classes.dex */
public final class zacd implements OnCompleteListener {
    private final GoogleApiManager zaa;
    private final int zab;
    private final ApiKey zac;
    private final long zad;
    private final long zae;

    @VisibleForTesting
    zacd(GoogleApiManager googleApiManager, int i8, ApiKey apiKey, long j8, long j9, String str, String str2) {
        this.zaa = googleApiManager;
        this.zab = i8;
        this.zac = apiKey;
        this.zad = j8;
        this.zae = j9;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zacd zaa(GoogleApiManager googleApiManager, int i8, ApiKey apiKey) {
        boolean z7;
        long j8;
        long j9;
        if (!googleApiManager.zaF()) {
            return null;
        }
        RootTelemetryConfiguration config = RootTelemetryConfigManager.getInstance().getConfig();
        if (config != null) {
            if (!config.getMethodInvocationTelemetryEnabled()) {
                return null;
            }
            z7 = config.getMethodTimingTelemetryEnabled();
            zabq zak = googleApiManager.zak(apiKey);
            if (zak != null) {
                if (!(zak.zaf() instanceof BaseGmsClient)) {
                    return null;
                }
                BaseGmsClient baseGmsClient = (BaseGmsClient) zak.zaf();
                if (baseGmsClient.hasConnectionInfo() && !baseGmsClient.isConnecting()) {
                    ConnectionTelemetryConfiguration zab = zab(zak, baseGmsClient, i8);
                    if (zab == null) {
                        return null;
                    }
                    zak.zaq();
                    z7 = zab.getMethodTimingTelemetryEnabled();
                }
            }
        } else {
            z7 = true;
        }
        if (z7) {
            j8 = System.currentTimeMillis();
        } else {
            j8 = 0;
        }
        if (z7) {
            j9 = SystemClock.elapsedRealtime();
        } else {
            j9 = 0;
        }
        return new zacd(googleApiManager, i8, apiKey, j8, j9, null, null);
    }

    private static ConnectionTelemetryConfiguration zab(zabq zabqVar, BaseGmsClient baseGmsClient, int i8) {
        int[] methodInvocationMethodKeyAllowlist;
        int[] methodInvocationMethodKeyDisallowlist;
        ConnectionTelemetryConfiguration telemetryConfiguration = baseGmsClient.getTelemetryConfiguration();
        if (telemetryConfiguration == null || !telemetryConfiguration.getMethodInvocationTelemetryEnabled() || ((methodInvocationMethodKeyAllowlist = telemetryConfiguration.getMethodInvocationMethodKeyAllowlist()) != null ? !ArrayUtils.contains(methodInvocationMethodKeyAllowlist, i8) : !((methodInvocationMethodKeyDisallowlist = telemetryConfiguration.getMethodInvocationMethodKeyDisallowlist()) == null || !ArrayUtils.contains(methodInvocationMethodKeyDisallowlist, i8))) || zabqVar.zac() >= telemetryConfiguration.getMaxMethodInvocationsLogged()) {
            return null;
        }
        return telemetryConfiguration;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(@NonNull Task task) {
        zabq zak;
        boolean z7;
        int i8;
        int i9;
        int i10;
        int i11;
        int errorCode;
        int i12;
        long j8;
        long j9;
        int i13;
        if (!this.zaa.zaF()) {
            return;
        }
        RootTelemetryConfiguration config = RootTelemetryConfigManager.getInstance().getConfig();
        if ((config == null || config.getMethodInvocationTelemetryEnabled()) && (zak = this.zaa.zak(this.zac)) != null && (zak.zaf() instanceof BaseGmsClient)) {
            BaseGmsClient baseGmsClient = (BaseGmsClient) zak.zaf();
            boolean z8 = true;
            if (this.zad > 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            int gCoreServiceId = baseGmsClient.getGCoreServiceId();
            if (config != null) {
                z7 &= config.getMethodTimingTelemetryEnabled();
                int batchPeriodMillis = config.getBatchPeriodMillis();
                int maxMethodInvocationsInBatch = config.getMaxMethodInvocationsInBatch();
                i8 = config.getVersion();
                if (baseGmsClient.hasConnectionInfo() && !baseGmsClient.isConnecting()) {
                    ConnectionTelemetryConfiguration zab = zab(zak, baseGmsClient, this.zab);
                    if (zab == null) {
                        return;
                    }
                    z8 = (!zab.getMethodTimingTelemetryEnabled() || this.zad <= 0) ? false : false;
                    maxMethodInvocationsInBatch = zab.getMaxMethodInvocationsLogged();
                    z7 = z8;
                }
                i9 = batchPeriodMillis;
                i10 = maxMethodInvocationsInBatch;
            } else {
                i8 = 0;
                i9 = 5000;
                i10 = 100;
            }
            GoogleApiManager googleApiManager = this.zaa;
            if (task.isSuccessful()) {
                i11 = 0;
                i12 = 0;
            } else {
                if (task.isCanceled()) {
                    i11 = 100;
                } else {
                    Exception exception = task.getException();
                    if (exception instanceof ApiException) {
                        Status status = ((ApiException) exception).getStatus();
                        int statusCode = status.getStatusCode();
                        ConnectionResult connectionResult = status.getConnectionResult();
                        if (connectionResult == null) {
                            errorCode = -1;
                        } else {
                            errorCode = connectionResult.getErrorCode();
                        }
                        i12 = errorCode;
                        i11 = statusCode;
                    } else {
                        i11 = 101;
                    }
                }
                i12 = -1;
            }
            if (z7) {
                long j10 = this.zad;
                j9 = System.currentTimeMillis();
                j8 = j10;
                i13 = (int) (SystemClock.elapsedRealtime() - this.zae);
            } else {
                j8 = 0;
                j9 = 0;
                i13 = -1;
            }
            googleApiManager.zay(new MethodInvocation(this.zab, i11, i12, j8, j9, null, null, gCoreServiceId, i13), i8, i9, i10);
        }
    }
}
