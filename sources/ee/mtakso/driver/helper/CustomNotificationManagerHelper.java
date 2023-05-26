package ee.mtakso.driver.helper;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import ee.mtakso.driver.utils.AppResolver;
import java.util.List;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: CustomNotificationManagerHelper.kt */
/* loaded from: classes3.dex */
public final class CustomNotificationManagerHelper {

    /* renamed from: c  reason: collision with root package name */
    public static final Companion f20940c = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final AppResolver f20941a;

    /* renamed from: b  reason: collision with root package name */
    private final String f20942b;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum k uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:444)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:368)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:333)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:318)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:258)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:289)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: CustomNotificationManagerHelper.kt */
    /* loaded from: classes3.dex */
    public static final class BrandsWithNotificationManagerPackages {

        /* renamed from: j  reason: collision with root package name */
        public static final Companion f20943j;

        /* renamed from: k  reason: collision with root package name */
        public static final BrandsWithNotificationManagerPackages f20944k;

        /* renamed from: l  reason: collision with root package name */
        public static final BrandsWithNotificationManagerPackages f20945l;

        /* renamed from: m  reason: collision with root package name */
        public static final BrandsWithNotificationManagerPackages f20946m;

        /* renamed from: n  reason: collision with root package name */
        private static final /* synthetic */ BrandsWithNotificationManagerPackages[] f20947n;

        /* renamed from: f  reason: collision with root package name */
        private final String f20948f;

        /* renamed from: g  reason: collision with root package name */
        private final String f20949g;

        /* renamed from: h  reason: collision with root package name */
        private final List<String> f20950h;

        /* renamed from: i  reason: collision with root package name */
        private final List<String> f20951i;

        /* compiled from: CustomNotificationManagerHelper.kt */
        /* loaded from: classes3.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final BrandsWithNotificationManagerPackages a(String brandName) {
                BrandsWithNotificationManagerPackages[] values;
                boolean w7;
                Intrinsics.f(brandName, "brandName");
                for (BrandsWithNotificationManagerPackages brandsWithNotificationManagerPackages : BrandsWithNotificationManagerPackages.values()) {
                    w7 = StringsKt__StringsJVMKt.w(brandsWithNotificationManagerPackages.name(), brandName, true);
                    if (w7) {
                        return brandsWithNotificationManagerPackages;
                    }
                }
                return BrandsWithNotificationManagerPackages.f20946m;
            }
        }

        static {
            List e8;
            List e9;
            List e10;
            List e11;
            List k8;
            List k9;
            e8 = CollectionsKt__CollectionsJVMKt.e("com.huawei.systemmanager");
            e9 = CollectionsKt__CollectionsJVMKt.e("com.huawei.notificationmanager.ui.NotificationManagmentActivity");
            f20944k = new BrandsWithNotificationManagerPackages("HUAWEI", 0, null, null, e8, e9);
            e10 = CollectionsKt__CollectionsJVMKt.e("com.huawei.systemmanager");
            e11 = CollectionsKt__CollectionsJVMKt.e("com.huawei.notificationmanager.ui.NotificationManagmentActivity");
            f20945l = new BrandsWithNotificationManagerPackages("HONOR", 1, null, null, e10, e11);
            k8 = CollectionsKt__CollectionsKt.k();
            k9 = CollectionsKt__CollectionsKt.k();
            f20946m = new BrandsWithNotificationManagerPackages("UNDEFINED", 2, null, null, k8, k9);
            f20947n = a();
            f20943j = new Companion(null);
        }

        private BrandsWithNotificationManagerPackages(String str, int i8, String str2, String str3, List list, List list2) {
            this.f20948f = str2;
            this.f20949g = str3;
            this.f20950h = list;
            this.f20951i = list2;
        }

        private static final /* synthetic */ BrandsWithNotificationManagerPackages[] a() {
            return new BrandsWithNotificationManagerPackages[]{f20944k, f20945l, f20946m};
        }

        public static BrandsWithNotificationManagerPackages valueOf(String str) {
            return (BrandsWithNotificationManagerPackages) Enum.valueOf(BrandsWithNotificationManagerPackages.class, str);
        }

        public static BrandsWithNotificationManagerPackages[] values() {
            return (BrandsWithNotificationManagerPackages[]) f20947n.clone();
        }

        public final String c() {
            return this.f20948f;
        }

        public final String e() {
            return this.f20949g;
        }

        public final List<String> f() {
            return this.f20951i;
        }

        public final List<String> h() {
            return this.f20950h;
        }
    }

    /* compiled from: CustomNotificationManagerHelper.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Intent b(String str, BrandsWithNotificationManagerPackages brandsWithNotificationManagerPackages, AppResolver appResolver) {
            Bundle bundle = new Bundle();
            if (brandsWithNotificationManagerPackages.e() != null) {
                bundle.putString(brandsWithNotificationManagerPackages.e(), str);
            }
            for (String str2 : brandsWithNotificationManagerPackages.h()) {
                for (String str3 : brandsWithNotificationManagerPackages.f()) {
                    Intent b8 = appResolver.b(str2, str3, brandsWithNotificationManagerPackages.c(), bundle);
                    if (b8 != null) {
                        return b8;
                    }
                }
            }
            return null;
        }

        public final boolean c(String currentAppPackageName, AppResolver appResolver) {
            Intrinsics.f(currentAppPackageName, "currentAppPackageName");
            Intrinsics.f(appResolver, "appResolver");
            BrandsWithNotificationManagerPackages.Companion companion = BrandsWithNotificationManagerPackages.f20943j;
            String BRAND = Build.BRAND;
            Intrinsics.e(BRAND, "BRAND");
            BrandsWithNotificationManagerPackages a8 = companion.a(BRAND);
            if (a8 == BrandsWithNotificationManagerPackages.f20946m || b(currentAppPackageName, a8, appResolver) == null) {
                return false;
            }
            return true;
        }
    }

    @Inject
    public CustomNotificationManagerHelper(AppResolver appResolver, Context context) {
        Intrinsics.f(appResolver, "appResolver");
        Intrinsics.f(context, "context");
        this.f20941a = appResolver;
        String packageName = context.getPackageName();
        Intrinsics.e(packageName, "context.packageName");
        this.f20942b = packageName;
    }

    public final Intent a() {
        BrandsWithNotificationManagerPackages.Companion companion = BrandsWithNotificationManagerPackages.f20943j;
        String BRAND = Build.BRAND;
        Intrinsics.e(BRAND, "BRAND");
        BrandsWithNotificationManagerPackages a8 = companion.a(BRAND);
        if (a8 != BrandsWithNotificationManagerPackages.f20946m) {
            return f20940c.b(this.f20942b, a8, this.f20941a);
        }
        return null;
    }
}
