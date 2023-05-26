package com.google.firebase.crashlytics.internal.common;

import android.content.Context;

/* loaded from: classes3.dex */
class InstallerPackageNameProvider {

    /* renamed from: a  reason: collision with root package name */
    private String f15715a;

    private static String b(Context context) {
        String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
        if (installerPackageName == null) {
            return "";
        }
        return installerPackageName;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized String a(Context context) {
        String str;
        if (this.f15715a == null) {
            this.f15715a = b(context);
        }
        if ("".equals(this.f15715a)) {
            str = null;
        } else {
            str = this.f15715a;
        }
        return str;
    }
}
