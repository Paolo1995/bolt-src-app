package ee.mtakso.driver.param;

import android.content.Context;
import ee.mtakso.driver.network.client.targeting.TargetingParameters;
import ee.mtakso.driver.param.storage.BoltPrefsStorageMigration;
import eu.bolt.driver.core.storage.BoltPrefsStorage;
import eu.bolt.driver.core.storage.BoltSharedPrefs;
import eu.bolt.driver.core.storage.OnStorageVersionUpgradedListener;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverProvider.kt */
@Singleton
/* loaded from: classes3.dex */
public final class DriverProvider {

    /* renamed from: a  reason: collision with root package name */
    private final Context f23140a;

    /* renamed from: b  reason: collision with root package name */
    private final BoltPrefsStorageMigration f23141b;

    /* renamed from: c  reason: collision with root package name */
    private final DeviceSettings f23142c;

    /* renamed from: d  reason: collision with root package name */
    private final DriverProvider$storageMigrator$1 f23143d;

    /* renamed from: e  reason: collision with root package name */
    private final int f23144e;

    /* renamed from: f  reason: collision with root package name */
    private BoltPrefsStorage f23145f;

    /* renamed from: g  reason: collision with root package name */
    private MutableDriverConfig f23146g;

    /* renamed from: h  reason: collision with root package name */
    private DriverConfig f23147h;

    /* renamed from: i  reason: collision with root package name */
    private TempDriverData f23148i;

    /* renamed from: j  reason: collision with root package name */
    private DriverSettings f23149j;

    /* renamed from: k  reason: collision with root package name */
    private DriverFeatures f23150k;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DriverProvider.kt */
    /* loaded from: classes3.dex */
    public static final class TempDriverData {

        /* renamed from: a  reason: collision with root package name */
        private final long f23151a;

        /* renamed from: b  reason: collision with root package name */
        private final String f23152b;

        public TempDriverData(long j8, String country) {
            Intrinsics.f(country, "country");
            this.f23151a = j8;
            this.f23152b = country;
        }

        public final String a() {
            return this.f23152b;
        }

        public final long b() {
            return this.f23151a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof TempDriverData) {
                TempDriverData tempDriverData = (TempDriverData) obj;
                return this.f23151a == tempDriverData.f23151a && Intrinsics.a(this.f23152b, tempDriverData.f23152b);
            }
            return false;
        }

        public int hashCode() {
            return (i0.a.a(this.f23151a) * 31) + this.f23152b.hashCode();
        }

        public String toString() {
            long j8 = this.f23151a;
            String str = this.f23152b;
            return "TempDriverData(driverId=" + j8 + ", country=" + str + ")";
        }
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [ee.mtakso.driver.param.DriverProvider$storageMigrator$1] */
    @Inject
    public DriverProvider(Context context, BoltPrefsStorageMigration migration, DeviceSettings deviceSettings) {
        Intrinsics.f(context, "context");
        Intrinsics.f(migration, "migration");
        Intrinsics.f(deviceSettings, "deviceSettings");
        this.f23140a = context;
        this.f23141b = migration;
        this.f23142c = deviceSettings;
        this.f23143d = new OnStorageVersionUpgradedListener() { // from class: ee.mtakso.driver.param.DriverProvider$storageMigrator$1
            @Override // eu.bolt.driver.core.storage.OnStorageVersionUpgradedListener
            public void a(int i8, int i9, BoltPrefsStorage storage) {
                BoltPrefsStorageMigration boltPrefsStorageMigration;
                Intrinsics.f(storage, "storage");
                boltPrefsStorageMigration = DriverProvider.this.f23141b;
                boltPrefsStorageMigration.d(i8, i9, storage);
            }
        };
        this.f23144e = 3;
    }

    private final BoltPrefsStorage b(long j8) {
        Context context = this.f23140a;
        return new BoltSharedPrefs(context, "mtakso" + j8, this.f23144e, this.f23143d);
    }

    private final void i(long j8) {
        Context context = this.f23140a;
        this.f23150k = new DriverFeatures(new BoltSharedPrefs(context, "targeting_" + j8, 1, null));
    }

    public final String c() {
        String j8;
        DriverConfig d8 = d();
        if (d8 == null || (j8 = d8.j()) == null) {
            TempDriverData tempDriverData = this.f23148i;
            if (tempDriverData != null) {
                return tempDriverData.a();
            }
            return "";
        }
        return j8;
    }

    public final DriverConfig d() {
        return this.f23147h;
    }

    public final DriverFeatures e() {
        return this.f23150k;
    }

    public final String f() {
        String l8;
        DriverConfig d8 = d();
        if (d8 == null || (l8 = Long.valueOf(d8.t()).toString()) == null) {
            TempDriverData tempDriverData = this.f23148i;
            if (tempDriverData != null) {
                return Long.valueOf(tempDriverData.b()).toString();
            }
            return "";
        }
        return l8;
    }

    public final MutableDriverConfig g() {
        MutableDriverConfig mutableDriverConfig = this.f23146g;
        if (mutableDriverConfig != null) {
            return mutableDriverConfig;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public final DriverFeatures h() {
        boolean z7;
        if (this.f23150k == null) {
            Long valueOf = Long.valueOf(this.f23142c.h().a());
            if (valueOf.longValue() != -1) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (!z7) {
                valueOf = null;
            }
            if (valueOf != null) {
                i(valueOf.longValue());
            }
        }
        return this.f23150k;
    }

    public final void j(long j8) {
        BoltPrefsStorage b8 = b(j8);
        MutableDriverConfig mutableDriverConfig = new MutableDriverConfig(b8);
        DriverConfig driverConfig = new DriverConfig(mutableDriverConfig);
        this.f23145f = b8;
        this.f23146g = mutableDriverConfig;
        this.f23147h = driverConfig;
        this.f23149j = new DriverSettings(b8, driverConfig);
        i(j8);
        this.f23148i = null;
    }

    public final void k() {
        this.f23146g = null;
        this.f23147h = null;
        this.f23149j = null;
        this.f23148i = null;
    }

    public final void l(TargetingParameters targetingParameters) {
        Intrinsics.f(targetingParameters, "targetingParameters");
        p().P(targetingParameters);
    }

    public final DriverConfig m() {
        boolean z7;
        if (this.f23147h == null) {
            Long valueOf = Long.valueOf(this.f23142c.h().a());
            if (valueOf.longValue() != -1) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (!z7) {
                valueOf = null;
            }
            if (valueOf != null) {
                j(valueOf.longValue());
            }
        }
        DriverConfig driverConfig = this.f23147h;
        if (driverConfig != null) {
            return driverConfig;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public final DriverConfig n() {
        DriverConfig driverConfig = this.f23147h;
        if (driverConfig != null) {
            return driverConfig;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public final DriverConfig o() {
        boolean z7;
        if (this.f23147h == null) {
            Long valueOf = Long.valueOf(this.f23142c.h().a());
            if (valueOf.longValue() != -1) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (!z7) {
                valueOf = null;
            }
            if (valueOf != null) {
                j(valueOf.longValue());
            }
        }
        DriverConfig driverConfig = this.f23147h;
        if (driverConfig != null) {
            return driverConfig;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public final DriverFeatures p() {
        DriverFeatures h8 = h();
        if (h8 != null) {
            return h8;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public final DriverFeatures q() {
        DriverFeatures driverFeatures = this.f23150k;
        if (driverFeatures != null) {
            return driverFeatures;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public final DriverFeatures r() {
        boolean z7;
        if (this.f23149j == null) {
            Long valueOf = Long.valueOf(this.f23142c.h().a());
            if (valueOf.longValue() != -1) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (!z7) {
                valueOf = null;
            }
            if (valueOf != null) {
                i(valueOf.longValue());
            }
        }
        DriverFeatures driverFeatures = this.f23150k;
        if (driverFeatures != null) {
            return driverFeatures;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public final BoltPrefsStorage s() {
        boolean z7;
        if (this.f23145f == null) {
            Long valueOf = Long.valueOf(this.f23142c.h().a());
            if (valueOf.longValue() != -1) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (!z7) {
                valueOf = null;
            }
            if (valueOf != null) {
                j(valueOf.longValue());
            }
        }
        BoltPrefsStorage boltPrefsStorage = this.f23145f;
        if (boltPrefsStorage != null) {
            return boltPrefsStorage;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public final DriverSettings t() {
        boolean z7;
        if (this.f23149j == null) {
            Long valueOf = Long.valueOf(this.f23142c.h().a());
            if (valueOf.longValue() != -1) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (!z7) {
                valueOf = null;
            }
            if (valueOf != null) {
                j(valueOf.longValue());
            }
        }
        DriverSettings driverSettings = this.f23149j;
        if (driverSettings != null) {
            return driverSettings;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public final DriverSettings u(long j8) {
        BoltPrefsStorage b8 = b(j8);
        return new DriverSettings(b8, new DriverConfig(new MutableDriverConfig(b8)));
    }

    public final DriverSettings v() {
        DriverSettings driverSettings = this.f23149j;
        if (driverSettings != null) {
            return driverSettings;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public final DriverSettings w() {
        boolean z7;
        if (this.f23149j == null) {
            Long valueOf = Long.valueOf(this.f23142c.h().a());
            if (valueOf.longValue() != -1) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (!z7) {
                valueOf = null;
            }
            if (valueOf != null) {
                j(valueOf.longValue());
            }
        }
        DriverSettings driverSettings = this.f23149j;
        if (driverSettings != null) {
            return driverSettings;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public final void x(long j8, String country) {
        Intrinsics.f(country, "country");
        this.f23148i = new TempDriverData(j8, country);
    }

    public final DriverSettings y() {
        return this.f23149j;
    }
}
