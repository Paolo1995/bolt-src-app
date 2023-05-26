package com.clevertap.android.sdk.pushnotification;

import androidx.annotation.NonNull;
import com.google.android.gms.measurement.AppMeasurement;

/* loaded from: classes.dex */
public interface PushConstants {

    /* renamed from: a  reason: collision with root package name */
    public static final String f11680a = PushType.FCM.toString();

    /* loaded from: classes.dex */
    public enum PushType {
        FCM(AppMeasurement.FCM_ORIGIN, "fcm_token", "com.clevertap.android.sdk.pushnotification.fcm.FcmPushProvider", "com.google.firebase.messaging.FirebaseMessagingService"),
        XPS("xps", "xps_token", "com.clevertap.android.xps.XiaomiPushProvider", "com.xiaomi.mipush.sdk.MiPushClient"),
        HPS("hps", "hps_token", "com.clevertap.android.hms.HmsPushProvider", "com.huawei.hms.push.HmsMessageService"),
        BPS("bps", "bps_token", "com.clevertap.android.bps.BaiduPushProvider", "com.baidu.android.pushservice.PushMessageReceiver"),
        ADM("adm", "adm_token", "com.clevertap.android.adm.AmazonPushProvider", "com.amazon.device.messaging.ADM");
        

        /* renamed from: f  reason: collision with root package name */
        private final String f11687f;

        /* renamed from: g  reason: collision with root package name */
        private final String f11688g;

        /* renamed from: h  reason: collision with root package name */
        private final String f11689h;

        /* renamed from: i  reason: collision with root package name */
        private final String f11690i;

        PushType(String str, String str2, String str3, String str4) {
            this.f11690i = str;
            this.f11689h = str2;
            this.f11687f = str3;
            this.f11688g = str4;
        }

        public String a() {
            return this.f11687f;
        }

        public String c() {
            return this.f11688g;
        }

        public String e() {
            return this.f11689h;
        }

        public String f() {
            return this.f11690i;
        }

        @Override // java.lang.Enum
        @NonNull
        public String toString() {
            return " [PushType:" + name() + "] ";
        }
    }
}
