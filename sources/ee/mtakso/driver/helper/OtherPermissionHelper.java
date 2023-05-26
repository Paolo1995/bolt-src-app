package ee.mtakso.driver.helper;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import ee.mtakso.driver.utils.AppResolver;
import eu.bolt.kalev.Kalev;
import java.util.List;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: OtherPermissionHelper.kt */
/* loaded from: classes3.dex */
public final class OtherPermissionHelper {

    /* renamed from: c  reason: collision with root package name */
    public static final Companion f20957c = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final AppResolver f20958a;

    /* renamed from: b  reason: collision with root package name */
    private final String f20959b;

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
    /* compiled from: OtherPermissionHelper.kt */
    /* loaded from: classes3.dex */
    public static final class BrandsWithOtherPermissionPackages {

        /* renamed from: j  reason: collision with root package name */
        public static final Companion f20960j;

        /* renamed from: k  reason: collision with root package name */
        public static final BrandsWithOtherPermissionPackages f20961k;

        /* renamed from: l  reason: collision with root package name */
        public static final BrandsWithOtherPermissionPackages f20962l;

        /* renamed from: m  reason: collision with root package name */
        public static final BrandsWithOtherPermissionPackages f20963m;

        /* renamed from: n  reason: collision with root package name */
        public static final BrandsWithOtherPermissionPackages f20964n;

        /* renamed from: o  reason: collision with root package name */
        public static final BrandsWithOtherPermissionPackages f20965o;

        /* renamed from: p  reason: collision with root package name */
        private static final /* synthetic */ BrandsWithOtherPermissionPackages[] f20966p;

        /* renamed from: f  reason: collision with root package name */
        private final String f20967f;

        /* renamed from: g  reason: collision with root package name */
        private final String f20968g;

        /* renamed from: h  reason: collision with root package name */
        private final List<String> f20969h;

        /* renamed from: i  reason: collision with root package name */
        private final List<String> f20970i;

        /* compiled from: OtherPermissionHelper.kt */
        /* loaded from: classes3.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final BrandsWithOtherPermissionPackages a(String brandName) {
                BrandsWithOtherPermissionPackages[] values;
                boolean w7;
                Intrinsics.f(brandName, "brandName");
                for (BrandsWithOtherPermissionPackages brandsWithOtherPermissionPackages : BrandsWithOtherPermissionPackages.values()) {
                    w7 = StringsKt__StringsJVMKt.w(brandsWithOtherPermissionPackages.name(), brandName, true);
                    if (w7) {
                        return brandsWithOtherPermissionPackages;
                    }
                }
                return BrandsWithOtherPermissionPackages.f20965o;
            }
        }

        static {
            List e8;
            List e9;
            List e10;
            List e11;
            List n8;
            List n9;
            List n10;
            List n11;
            List k8;
            List k9;
            e8 = CollectionsKt__CollectionsJVMKt.e("com.huawei.systemmanager");
            e9 = CollectionsKt__CollectionsJVMKt.e("com.huawei.systemmanager.addviewmonitor.AddViewMonitorActivity");
            f20961k = new BrandsWithOtherPermissionPackages("HUAWEI", 0, null, null, e8, e9);
            e10 = CollectionsKt__CollectionsJVMKt.e("com.meizu.safe");
            e11 = CollectionsKt__CollectionsJVMKt.e("com.meizu.safe.security.AppSecActivity");
            f20962l = new BrandsWithOtherPermissionPackages("MEIZU", 1, "com.meizu.safe.security.SHOW_APPSEC", "packageName", e10, e11);
            n8 = CollectionsKt__CollectionsKt.n("com.miui.securitycenter", "com.miui.permcenter");
            n9 = CollectionsKt__CollectionsKt.n("com.miui.permcenter.permissions.PermissionsEditorActivity", "com.miui.securitycenter.permission.AppPermissionsEditor", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
            f20963m = new BrandsWithOtherPermissionPackages("XIAOMI", 2, "miui.intent.action.APP_PERM_EDITOR", "extra_pkgname", n8, n9);
            n10 = CollectionsKt__CollectionsKt.n("com.coloros.safecenter", "com.oppo.safe");
            n11 = CollectionsKt__CollectionsKt.n("com.coloros.safecenter.sysfloatwindow.FloatWindowListActivity", "com.oppo.safe.sysfloatwindow.FloatWindowListActivity");
            f20964n = new BrandsWithOtherPermissionPackages("OPPO", 3, null, null, n10, n11);
            k8 = CollectionsKt__CollectionsKt.k();
            k9 = CollectionsKt__CollectionsKt.k();
            f20965o = new BrandsWithOtherPermissionPackages("UNDEFINED", 4, null, null, k8, k9);
            f20966p = a();
            f20960j = new Companion(null);
        }

        private BrandsWithOtherPermissionPackages(String str, int i8, String str2, String str3, List list, List list2) {
            this.f20967f = str2;
            this.f20968g = str3;
            this.f20969h = list;
            this.f20970i = list2;
        }

        private static final /* synthetic */ BrandsWithOtherPermissionPackages[] a() {
            return new BrandsWithOtherPermissionPackages[]{f20961k, f20962l, f20963m, f20964n, f20965o};
        }

        public static BrandsWithOtherPermissionPackages valueOf(String str) {
            return (BrandsWithOtherPermissionPackages) Enum.valueOf(BrandsWithOtherPermissionPackages.class, str);
        }

        public static BrandsWithOtherPermissionPackages[] values() {
            return (BrandsWithOtherPermissionPackages[]) f20966p.clone();
        }

        public final String c() {
            return this.f20967f;
        }

        public final String e() {
            return this.f20968g;
        }

        public final List<String> f() {
            return this.f20970i;
        }

        public final List<String> h() {
            return this.f20969h;
        }
    }

    /* compiled from: OtherPermissionHelper.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Intent b(String str, BrandsWithOtherPermissionPackages brandsWithOtherPermissionPackages, AppResolver appResolver) {
            Intent b8;
            Bundle bundle = new Bundle();
            if (brandsWithOtherPermissionPackages.e() != null) {
                bundle.putString(brandsWithOtherPermissionPackages.e(), str);
            }
            for (String str2 : brandsWithOtherPermissionPackages.h()) {
                for (String str3 : brandsWithOtherPermissionPackages.f()) {
                    try {
                        b8 = appResolver.b(str2, str3, brandsWithOtherPermissionPackages.c(), bundle);
                    } catch (Exception e8) {
                        Kalev.e(e8, "Not able to create intent for " + brandsWithOtherPermissionPackages);
                    }
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
            BrandsWithOtherPermissionPackages.Companion companion = BrandsWithOtherPermissionPackages.f20960j;
            String BRAND = Build.BRAND;
            Intrinsics.e(BRAND, "BRAND");
            BrandsWithOtherPermissionPackages a8 = companion.a(BRAND);
            if (a8 == BrandsWithOtherPermissionPackages.f20965o || b(currentAppPackageName, a8, appResolver) == null) {
                return false;
            }
            return true;
        }
    }

    @Inject
    public OtherPermissionHelper(AppResolver appResolver, Context context) {
        Intrinsics.f(appResolver, "appResolver");
        Intrinsics.f(context, "context");
        this.f20958a = appResolver;
        String packageName = context.getPackageName();
        Intrinsics.e(packageName, "context.packageName");
        this.f20959b = packageName;
    }

    public final Intent a() {
        BrandsWithOtherPermissionPackages.Companion companion = BrandsWithOtherPermissionPackages.f20960j;
        String BRAND = Build.BRAND;
        Intrinsics.e(BRAND, "BRAND");
        BrandsWithOtherPermissionPackages a8 = companion.a(BRAND);
        if (a8 != BrandsWithOtherPermissionPackages.f20965o) {
            return f20957c.b(this.f20959b, a8, this.f20958a);
        }
        return null;
    }
}
