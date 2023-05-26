package com.clevertap.android.sdk.pushnotification.fcm;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.ManifestInfo;
import com.clevertap.android.sdk.Utils;
import com.clevertap.android.sdk.pushnotification.CTPushProviderListener;
import com.clevertap.android.sdk.pushnotification.PushConstants;
import com.clevertap.android.sdk.utils.PackageUtils;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

/* loaded from: classes.dex */
public class FcmSdkHandlerImpl implements IFcmSdkHandler {

    /* renamed from: a  reason: collision with root package name */
    private final CTPushProviderListener f11718a;

    /* renamed from: b  reason: collision with root package name */
    private final CleverTapInstanceConfig f11719b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f11720c;

    /* renamed from: d  reason: collision with root package name */
    private ManifestInfo f11721d;

    public FcmSdkHandlerImpl(CTPushProviderListener cTPushProviderListener, Context context, CleverTapInstanceConfig cleverTapInstanceConfig) {
        this.f11720c = context;
        this.f11719b = cleverTapInstanceConfig;
        this.f11718a = cTPushProviderListener;
        this.f11721d = ManifestInfo.i(context);
    }

    String c() {
        return this.f11721d.h();
    }

    String d() {
        String c8 = c();
        if (!TextUtils.isEmpty(c8)) {
            return c8;
        }
        return FirebaseApp.k().m().d();
    }

    @Override // com.clevertap.android.sdk.pushnotification.fcm.IFcmSdkHandler
    public PushConstants.PushType getPushType() {
        return PushConstants.PushType.FCM;
    }

    @Override // com.clevertap.android.sdk.pushnotification.fcm.IFcmSdkHandler
    public boolean isAvailable() {
        try {
            if (!PackageUtils.a(this.f11720c)) {
                CleverTapInstanceConfig cleverTapInstanceConfig = this.f11719b;
                cleverTapInstanceConfig.A("PushProvider", PushConstants.f11680a + "Google Play services is currently unavailable.");
                return false;
            } else if (TextUtils.isEmpty(d())) {
                CleverTapInstanceConfig cleverTapInstanceConfig2 = this.f11719b;
                cleverTapInstanceConfig2.A("PushProvider", PushConstants.f11680a + "The FCM sender ID is not set. Unable to register for FCM.");
                return false;
            } else {
                return true;
            }
        } catch (Throwable th) {
            CleverTapInstanceConfig cleverTapInstanceConfig3 = this.f11719b;
            cleverTapInstanceConfig3.B("PushProvider", PushConstants.f11680a + "Unable to register with FCM.", th);
            return false;
        }
    }

    @Override // com.clevertap.android.sdk.pushnotification.fcm.IFcmSdkHandler
    public boolean isSupported() {
        return PackageUtils.b(this.f11720c);
    }

    @Override // com.clevertap.android.sdk.pushnotification.fcm.IFcmSdkHandler
    public void requestToken() {
        if (!Utils.f11092b) {
            this.f11719b.n().f(this.f11719b.c(), "Downgrade you're FCM dependency to v20.2.4 or else CleverTap SDK will not be able to generate a token for this device.");
            this.f11718a.a(null, getPushType());
            return;
        }
        try {
            String o8 = Utils.o(this.f11720c, this.f11719b);
            if (!TextUtils.isEmpty(o8)) {
                CleverTapInstanceConfig cleverTapInstanceConfig = this.f11719b;
                cleverTapInstanceConfig.A("PushProvider", PushConstants.f11680a + "FCM token - " + o8);
                this.f11718a.a(o8, getPushType());
            } else {
                CleverTapInstanceConfig cleverTapInstanceConfig2 = this.f11719b;
                cleverTapInstanceConfig2.A("PushProvider", PushConstants.f11680a + "Requesting FCM token using googleservices.json");
                FirebaseInstanceId.i().j().addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() { // from class: com.clevertap.android.sdk.pushnotification.fcm.FcmSdkHandlerImpl.1
                    @Override // com.google.android.gms.tasks.OnCompleteListener
                    public void onComplete(@NonNull Task<InstanceIdResult> task) {
                        String str = null;
                        if (!task.isSuccessful()) {
                            CleverTapInstanceConfig cleverTapInstanceConfig3 = FcmSdkHandlerImpl.this.f11719b;
                            cleverTapInstanceConfig3.B("PushProvider", PushConstants.f11680a + "FCM token using googleservices.json failed", task.getException());
                            FcmSdkHandlerImpl.this.f11718a.a(null, FcmSdkHandlerImpl.this.getPushType());
                            return;
                        }
                        if (task.getResult() != null) {
                            str = task.getResult().a();
                        }
                        CleverTapInstanceConfig cleverTapInstanceConfig4 = FcmSdkHandlerImpl.this.f11719b;
                        cleverTapInstanceConfig4.A("PushProvider", PushConstants.f11680a + "FCM token using googleservices.json - " + str);
                        FcmSdkHandlerImpl.this.f11718a.a(str, FcmSdkHandlerImpl.this.getPushType());
                    }
                });
            }
        } catch (Throwable th) {
            CleverTapInstanceConfig cleverTapInstanceConfig3 = this.f11719b;
            cleverTapInstanceConfig3.B("PushProvider", PushConstants.f11680a + "Error requesting FCM token", th);
            this.f11718a.a(null, getPushType());
        }
    }
}
