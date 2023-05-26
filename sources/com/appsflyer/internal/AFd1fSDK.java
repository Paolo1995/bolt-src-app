package com.appsflyer.internal;

import androidx.annotation.NonNull;
import com.appsflyer.deeplink.DeepLinkResult;

/* loaded from: classes.dex */
public final class AFd1fSDK extends AFd1pSDK<DeepLinkResult> {
    private final AFb1oSDK AFLogger;
    private DeepLinkResult afRDLog;

    /* renamed from: com.appsflyer.internal.AFd1fSDK$1  reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] AFInAppEventParameterName;

        static {
            int[] iArr = new int[DeepLinkResult.Status.values().length];
            AFInAppEventParameterName = iArr;
            try {
                iArr[DeepLinkResult.Status.FOUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                AFInAppEventParameterName[DeepLinkResult.Status.NOT_FOUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                AFInAppEventParameterName[DeepLinkResult.Status.ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public AFd1fSDK(@NonNull AFb1oSDK aFb1oSDK) {
        super(AFd1rSDK.DLSDK, new AFd1rSDK[]{AFd1rSDK.RC_CDN}, "DdlSdk");
        this.AFLogger = aFb1oSDK;
    }

    @Override // com.appsflyer.internal.AFd1pSDK
    @NonNull
    public final AFd1tSDK AFInAppEventType() throws Exception {
        DeepLinkResult afInfoLog = this.AFLogger.afInfoLog();
        this.afRDLog = afInfoLog;
        if (AnonymousClass1.AFInAppEventParameterName[afInfoLog.getStatus().ordinal()] != 1) {
            if (this.afRDLog.getError() == DeepLinkResult.Error.TIMEOUT) {
                return AFd1tSDK.TIMEOUT;
            }
            return AFd1tSDK.FAILURE;
        }
        return AFd1tSDK.SUCCESS;
    }

    @Override // com.appsflyer.internal.AFd1pSDK
    public final boolean AFKeystoreWrapper() {
        return false;
    }

    @Override // com.appsflyer.internal.AFd1pSDK
    public final long valueOf() {
        return 90000L;
    }
}
