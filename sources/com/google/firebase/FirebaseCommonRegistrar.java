package com.google.firebase;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.heartbeatinfo.DefaultHeartBeatController;
import com.google.firebase.platforminfo.DefaultUserAgentPublisher;
import com.google.firebase.platforminfo.KotlinDetector;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class FirebaseCommonRegistrar implements ComponentRegistrar {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String e(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo != null) {
            return String.valueOf(applicationInfo.targetSdkVersion);
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String f(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo != null && Build.VERSION.SDK_INT >= 24) {
            return String.valueOf(applicationInfo.minSdkVersion);
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String g(Context context) {
        int i8 = Build.VERSION.SDK_INT;
        if (context.getPackageManager().hasSystemFeature("android.hardware.type.television")) {
            return "tv";
        }
        if (context.getPackageManager().hasSystemFeature("android.hardware.type.watch")) {
            return "watch";
        }
        if (i8 >= 23 && context.getPackageManager().hasSystemFeature("android.hardware.type.automotive")) {
            return "auto";
        }
        if (i8 >= 26 && context.getPackageManager().hasSystemFeature("android.hardware.type.embedded")) {
            return "embedded";
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String h(Context context) {
        String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
        if (installerPackageName != null) {
            return i(installerPackageName);
        }
        return "";
    }

    private static String i(String str) {
        return str.replace(' ', '_').replace('/', '_');
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<Component<?>> getComponents() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(DefaultUserAgentPublisher.c());
        arrayList.add(DefaultHeartBeatController.h());
        arrayList.add(LibraryVersionComponent.b("fire-android", String.valueOf(Build.VERSION.SDK_INT)));
        arrayList.add(LibraryVersionComponent.b("fire-core", "20.1.1"));
        arrayList.add(LibraryVersionComponent.b("device-name", i(Build.PRODUCT)));
        arrayList.add(LibraryVersionComponent.b("device-model", i(Build.DEVICE)));
        arrayList.add(LibraryVersionComponent.b("device-brand", i(Build.BRAND)));
        arrayList.add(LibraryVersionComponent.c("android-target-sdk", new LibraryVersionComponent.VersionExtractor() { // from class: com.google.firebase.c
            @Override // com.google.firebase.platforminfo.LibraryVersionComponent.VersionExtractor
            public final String a(Object obj) {
                String e8;
                e8 = FirebaseCommonRegistrar.e((Context) obj);
                return e8;
            }
        }));
        arrayList.add(LibraryVersionComponent.c("android-min-sdk", new LibraryVersionComponent.VersionExtractor() { // from class: com.google.firebase.d
            @Override // com.google.firebase.platforminfo.LibraryVersionComponent.VersionExtractor
            public final String a(Object obj) {
                String f8;
                f8 = FirebaseCommonRegistrar.f((Context) obj);
                return f8;
            }
        }));
        arrayList.add(LibraryVersionComponent.c("android-platform", new LibraryVersionComponent.VersionExtractor() { // from class: com.google.firebase.e
            @Override // com.google.firebase.platforminfo.LibraryVersionComponent.VersionExtractor
            public final String a(Object obj) {
                String g8;
                g8 = FirebaseCommonRegistrar.g((Context) obj);
                return g8;
            }
        }));
        arrayList.add(LibraryVersionComponent.c("android-installer", new LibraryVersionComponent.VersionExtractor() { // from class: com.google.firebase.f
            @Override // com.google.firebase.platforminfo.LibraryVersionComponent.VersionExtractor
            public final String a(Object obj) {
                String h8;
                h8 = FirebaseCommonRegistrar.h((Context) obj);
                return h8;
            }
        }));
        String a8 = KotlinDetector.a();
        if (a8 != null) {
            arrayList.add(LibraryVersionComponent.b("kotlin", a8));
        }
        return arrayList;
    }
}
