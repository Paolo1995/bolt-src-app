package com.sinch.android.rtc.internal;

/* loaded from: classes3.dex */
public enum ManagedPushVendor {
    FCM("vendor-fcm"),
    HMS("huawei-hms");
    
    private final String vendorID;

    ManagedPushVendor(String str) {
        this.vendorID = str;
    }

    public String getVendorID() {
        return this.vendorID;
    }
}
