package androidx.work.impl.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import androidx.annotation.NonNull;
import androidx.work.Logger;

/* loaded from: classes.dex */
public class PackageManagerHelper {

    /* renamed from: a  reason: collision with root package name */
    private static final String f8690a = Logger.f("PackageManagerHelper");

    private PackageManagerHelper() {
    }

    public static void a(@NonNull Context context, @NonNull Class<?> cls, boolean z7) {
        int i8;
        Object obj;
        String str = "enabled";
        try {
            PackageManager packageManager = context.getPackageManager();
            ComponentName componentName = new ComponentName(context, cls.getName());
            if (z7) {
                i8 = 1;
            } else {
                i8 = 2;
            }
            packageManager.setComponentEnabledSetting(componentName, i8, 1);
            Logger c8 = Logger.c();
            String str2 = f8690a;
            Object[] objArr = new Object[2];
            objArr[0] = cls.getName();
            if (z7) {
                obj = "enabled";
            } else {
                obj = "disabled";
            }
            objArr[1] = obj;
            c8.a(str2, String.format("%s %s", objArr), new Throwable[0]);
        } catch (Exception e8) {
            Logger c9 = Logger.c();
            String str3 = f8690a;
            Object[] objArr2 = new Object[2];
            objArr2[0] = cls.getName();
            if (!z7) {
                str = "disabled";
            }
            objArr2[1] = str;
            c9.a(str3, String.format("%s could not be %s", objArr2), e8);
        }
    }
}
