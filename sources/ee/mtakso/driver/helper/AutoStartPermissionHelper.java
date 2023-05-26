package ee.mtakso.driver.helper;

import android.content.Intent;
import android.os.Build;
import ee.mtakso.driver.utils.AppResolver;
import eu.bolt.kalev.Kalev;
import java.util.List;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: AutoStartPermissionHelper.kt */
/* loaded from: classes3.dex */
public final class AutoStartPermissionHelper {

    /* renamed from: b  reason: collision with root package name */
    public static final Companion f20912b = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final AppResolver f20913a;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum i uses external variables
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
    /* compiled from: AutoStartPermissionHelper.kt */
    /* loaded from: classes3.dex */
    public static final class BrandsWithAutoStartPackages {

        /* renamed from: h  reason: collision with root package name */
        public static final Companion f20914h;

        /* renamed from: i  reason: collision with root package name */
        public static final BrandsWithAutoStartPackages f20915i;

        /* renamed from: j  reason: collision with root package name */
        public static final BrandsWithAutoStartPackages f20916j;

        /* renamed from: k  reason: collision with root package name */
        public static final BrandsWithAutoStartPackages f20917k;

        /* renamed from: l  reason: collision with root package name */
        public static final BrandsWithAutoStartPackages f20918l;

        /* renamed from: m  reason: collision with root package name */
        public static final BrandsWithAutoStartPackages f20919m;

        /* renamed from: n  reason: collision with root package name */
        public static final BrandsWithAutoStartPackages f20920n;

        /* renamed from: o  reason: collision with root package name */
        public static final BrandsWithAutoStartPackages f20921o;

        /* renamed from: p  reason: collision with root package name */
        public static final BrandsWithAutoStartPackages f20922p;

        /* renamed from: q  reason: collision with root package name */
        public static final BrandsWithAutoStartPackages f20923q;

        /* renamed from: r  reason: collision with root package name */
        public static final BrandsWithAutoStartPackages f20924r;

        /* renamed from: s  reason: collision with root package name */
        private static final /* synthetic */ BrandsWithAutoStartPackages[] f20925s;

        /* renamed from: f  reason: collision with root package name */
        private final List<String> f20926f;

        /* renamed from: g  reason: collision with root package name */
        private final List<String> f20927g;

        /* compiled from: AutoStartPermissionHelper.kt */
        /* loaded from: classes3.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final BrandsWithAutoStartPackages a(String brandName) {
                BrandsWithAutoStartPackages[] values;
                boolean w7;
                Intrinsics.f(brandName, "brandName");
                for (BrandsWithAutoStartPackages brandsWithAutoStartPackages : BrandsWithAutoStartPackages.values()) {
                    w7 = StringsKt__StringsJVMKt.w(brandsWithAutoStartPackages.name(), brandName, true);
                    if (w7) {
                        return brandsWithAutoStartPackages;
                    }
                }
                return BrandsWithAutoStartPackages.f20924r;
            }
        }

        static {
            List e8;
            List e9;
            List e10;
            List e11;
            List e12;
            List e13;
            List e14;
            List n8;
            List e15;
            List n9;
            List e16;
            List e17;
            List n10;
            List n11;
            List n12;
            List n13;
            List e18;
            List e19;
            List k8;
            List k9;
            e8 = CollectionsKt__CollectionsJVMKt.e("com.miui.securitycenter");
            e9 = CollectionsKt__CollectionsJVMKt.e("com.miui.permcenter.autostart.AutoStartManagementActivity");
            f20915i = new BrandsWithAutoStartPackages("XIAOMI", 0, e8, e9);
            e10 = CollectionsKt__CollectionsJVMKt.e("com.miui.securitycenter");
            e11 = CollectionsKt__CollectionsJVMKt.e("com.miui.permcenter.autostart.AutoStartManagementActivity");
            f20916j = new BrandsWithAutoStartPackages("REDMI", 1, e10, e11);
            e12 = CollectionsKt__CollectionsJVMKt.e("com.letv.android.letvsafe");
            e13 = CollectionsKt__CollectionsJVMKt.e("com.letv.android.letvsafe.AutobootManageActivity");
            f20917k = new BrandsWithAutoStartPackages("LETV", 2, e12, e13);
            e14 = CollectionsKt__CollectionsJVMKt.e("com.asus.mobilemanager");
            n8 = CollectionsKt__CollectionsKt.n("com.asus.mobilemanager.powersaver.PowerSaverSettings", "com.asus.mobilemanager.autostart.AutoStartActivity");
            f20918l = new BrandsWithAutoStartPackages("ASUS", 3, e14, n8);
            e15 = CollectionsKt__CollectionsJVMKt.e("com.huawei.systemmanager");
            n9 = CollectionsKt__CollectionsKt.n("com.huawei.systemmanager.optimize.process.ProtectActivity", "com.huawei.systemmanager.startupmgr.ui.StartupNormalAppListActivity");
            f20919m = new BrandsWithAutoStartPackages("HONOR", 4, e15, n9);
            e16 = CollectionsKt__CollectionsJVMKt.e("com.huawei.systemmanager");
            e17 = CollectionsKt__CollectionsJVMKt.e("com.huawei.systemmanager.optimize.process.ProtectActivity");
            f20920n = new BrandsWithAutoStartPackages("HUAWEI", 5, e16, e17);
            n10 = CollectionsKt__CollectionsKt.n("com.coloros.safecenter", "com.oppo.safe", "com.color.safecenter");
            n11 = CollectionsKt__CollectionsKt.n("com.coloros.safecenter.permission.startup.StartupAppListActivity", "com.oppo.safe.permission.startup.StartupAppListActivity", "com.coloros.safecenter.startupapp.StartupAppListActivity");
            f20921o = new BrandsWithAutoStartPackages("OPPO", 6, n10, n11);
            n12 = CollectionsKt__CollectionsKt.n("com.iqoo.secure", "com.vivo.permissionmanager");
            n13 = CollectionsKt__CollectionsKt.n("com.iqoo.secure.ui.phoneoptimize.AddWhiteListActivity", "com.vivo.permissionmanager.activity.BgStartUpManagerActivity", "com.iqoo.secure.ui.phoneoptimize.BgStartUpManager");
            f20922p = new BrandsWithAutoStartPackages("VIVO", 7, n12, n13);
            e18 = CollectionsKt__CollectionsJVMKt.e("com.evenwell.powersaving.g3");
            e19 = CollectionsKt__CollectionsJVMKt.e("com.evenwell.powersaving.g3.exception.PowerSaverExceptionActivity");
            f20923q = new BrandsWithAutoStartPackages("NOKIA", 8, e18, e19);
            k8 = CollectionsKt__CollectionsKt.k();
            k9 = CollectionsKt__CollectionsKt.k();
            f20924r = new BrandsWithAutoStartPackages("UNDEFINED", 9, k8, k9);
            f20925s = a();
            f20914h = new Companion(null);
        }

        private BrandsWithAutoStartPackages(String str, int i8, List list, List list2) {
            this.f20926f = list;
            this.f20927g = list2;
        }

        private static final /* synthetic */ BrandsWithAutoStartPackages[] a() {
            return new BrandsWithAutoStartPackages[]{f20915i, f20916j, f20917k, f20918l, f20919m, f20920n, f20921o, f20922p, f20923q, f20924r};
        }

        public static BrandsWithAutoStartPackages valueOf(String str) {
            return (BrandsWithAutoStartPackages) Enum.valueOf(BrandsWithAutoStartPackages.class, str);
        }

        public static BrandsWithAutoStartPackages[] values() {
            return (BrandsWithAutoStartPackages[]) f20925s.clone();
        }

        public final List<String> c() {
            return this.f20927g;
        }

        public final List<String> e() {
            return this.f20926f;
        }
    }

    /* compiled from: AutoStartPermissionHelper.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Intent b(AppResolver appResolver, BrandsWithAutoStartPackages brandsWithAutoStartPackages) {
            Intent b8;
            for (String str : brandsWithAutoStartPackages.e()) {
                for (String str2 : brandsWithAutoStartPackages.c()) {
                    try {
                        b8 = appResolver.b(str, str2, null, null);
                    } catch (Exception e8) {
                        Kalev.e(e8, "Not able to create intent for " + brandsWithAutoStartPackages);
                    }
                    if (b8 != null) {
                        return b8;
                    }
                }
            }
            return null;
        }

        public final boolean c(AppResolver appResolver) {
            Intrinsics.f(appResolver, "appResolver");
            BrandsWithAutoStartPackages.Companion companion = BrandsWithAutoStartPackages.f20914h;
            String BRAND = Build.BRAND;
            Intrinsics.e(BRAND, "BRAND");
            BrandsWithAutoStartPackages a8 = companion.a(BRAND);
            if (a8 == BrandsWithAutoStartPackages.f20924r || b(appResolver, a8) == null) {
                return false;
            }
            return true;
        }
    }

    @Inject
    public AutoStartPermissionHelper(AppResolver appResolver) {
        Intrinsics.f(appResolver, "appResolver");
        this.f20913a = appResolver;
    }

    public final Intent a() {
        BrandsWithAutoStartPackages.Companion companion = BrandsWithAutoStartPackages.f20914h;
        String BRAND = Build.BRAND;
        Intrinsics.e(BRAND, "BRAND");
        BrandsWithAutoStartPackages a8 = companion.a(BRAND);
        if (a8 != BrandsWithAutoStartPackages.f20924r) {
            return f20912b.b(this.f20913a, a8);
        }
        return null;
    }
}
