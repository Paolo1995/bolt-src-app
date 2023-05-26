package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.DevelopmentPlatformProvider;

/* loaded from: classes3.dex */
public abstract class StaticSessionData {

    /* loaded from: classes3.dex */
    public static abstract class AppData {
        public static AppData b(String str, String str2, String str3, String str4, int i8, DevelopmentPlatformProvider developmentPlatformProvider) {
            return new AutoValue_StaticSessionData_AppData(str, str2, str3, str4, i8, developmentPlatformProvider);
        }

        public abstract String a();

        public abstract int c();

        public abstract DevelopmentPlatformProvider d();

        public abstract String e();

        public abstract String f();

        public abstract String g();
    }

    /* loaded from: classes3.dex */
    public static abstract class DeviceData {
        public static DeviceData c(int i8, String str, int i9, long j8, long j9, boolean z7, int i10, String str2, String str3) {
            return new AutoValue_StaticSessionData_DeviceData(i8, str, i9, j8, j9, z7, i10, str2, str3);
        }

        public abstract int a();

        public abstract int b();

        public abstract long d();

        public abstract boolean e();

        public abstract String f();

        public abstract String g();

        public abstract String h();

        public abstract int i();

        public abstract long j();
    }

    /* loaded from: classes3.dex */
    public static abstract class OsData {
        public static OsData a(String str, String str2, boolean z7) {
            return new AutoValue_StaticSessionData_OsData(str, str2, z7);
        }

        public abstract boolean b();

        public abstract String c();

        public abstract String d();
    }

    public static StaticSessionData b(AppData appData, OsData osData, DeviceData deviceData) {
        return new AutoValue_StaticSessionData(appData, osData, deviceData);
    }

    public abstract AppData a();

    public abstract DeviceData c();

    public abstract OsData d();
}
