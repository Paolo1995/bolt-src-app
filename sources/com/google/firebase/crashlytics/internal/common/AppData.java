package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.google.firebase.crashlytics.internal.DevelopmentPlatformProvider;

/* loaded from: classes3.dex */
public class AppData {

    /* renamed from: a  reason: collision with root package name */
    public final String f15559a;

    /* renamed from: b  reason: collision with root package name */
    public final String f15560b;

    /* renamed from: c  reason: collision with root package name */
    public final String f15561c;

    /* renamed from: d  reason: collision with root package name */
    public final String f15562d;

    /* renamed from: e  reason: collision with root package name */
    public final String f15563e;

    /* renamed from: f  reason: collision with root package name */
    public final String f15564f;

    /* renamed from: g  reason: collision with root package name */
    public final DevelopmentPlatformProvider f15565g;

    public AppData(String str, String str2, String str3, String str4, String str5, String str6, DevelopmentPlatformProvider developmentPlatformProvider) {
        this.f15559a = str;
        this.f15560b = str2;
        this.f15561c = str3;
        this.f15562d = str4;
        this.f15563e = str5;
        this.f15564f = str6;
        this.f15565g = developmentPlatformProvider;
    }

    public static AppData a(Context context, IdManager idManager, String str, String str2, DevelopmentPlatformProvider developmentPlatformProvider) throws PackageManager.NameNotFoundException {
        String packageName = context.getPackageName();
        String g8 = idManager.g();
        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
        String num = Integer.toString(packageInfo.versionCode);
        String str3 = packageInfo.versionName;
        if (str3 == null) {
            str3 = "0.0";
        }
        return new AppData(str, str2, g8, packageName, num, str3, developmentPlatformProvider);
    }
}
