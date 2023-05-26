package ee.mtakso.driver.param;

import android.content.Context;
import ee.mtakso.driver.network.usage.NetworkUsageUpload;
import ee.mtakso.driver.param.field.BooleanSettingsField;
import ee.mtakso.driver.param.field.LongSettingsField;
import ee.mtakso.driver.param.field.StringSettingsField;
import ee.mtakso.driver.param.storage.BoltPrefsStorageMigration;
import eu.bolt.driver.core.field.SimpleField;
import eu.bolt.driver.core.field.io.JsonReadWrite;
import eu.bolt.driver.core.field.io.StringReadWrite;
import eu.bolt.driver.core.storage.BoltPrefsStorage;
import eu.bolt.driver.core.storage.BoltSharedPrefs;
import eu.bolt.driver.core.storage.KVStorage;
import eu.bolt.driver.core.storage.OnStorageVersionUpgradedListener;
import eu.bolt.driver.core.storage.StorageFactory;
import eu.bolt.driver.core.storage.StorageMigration;
import eu.bolt.driver.core.storage.field.NullableStringReadWrite;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* compiled from: DeviceSettings.kt */
@Singleton
/* loaded from: classes3.dex */
public final class DeviceSettings {

    /* renamed from: a  reason: collision with root package name */
    private final BoltPrefsStorageMigration f23088a;

    /* renamed from: b  reason: collision with root package name */
    private final DeviceSettings$storageMigrator$1 f23089b;

    /* renamed from: c  reason: collision with root package name */
    private final int f23090c;

    /* renamed from: d  reason: collision with root package name */
    private final BoltPrefsStorage f23091d;

    /* renamed from: e  reason: collision with root package name */
    private final KVStorage f23092e;

    /* renamed from: f  reason: collision with root package name */
    private final StringReadWrite f23093f;

    /* renamed from: g  reason: collision with root package name */
    private final NullableStringReadWrite f23094g;

    /* renamed from: h  reason: collision with root package name */
    private final JsonReadWrite<NetworkUsageUpload> f23095h;

    /* renamed from: i  reason: collision with root package name */
    private final StringSettingsField f23096i;

    /* renamed from: j  reason: collision with root package name */
    private final StringSettingsField f23097j;

    /* renamed from: k  reason: collision with root package name */
    private final SimpleField f23098k;

    /* renamed from: l  reason: collision with root package name */
    private final SimpleField f23099l;

    /* renamed from: m  reason: collision with root package name */
    private final LongSettingsField f23100m;

    /* renamed from: n  reason: collision with root package name */
    private final StringSettingsField f23101n;

    /* renamed from: o  reason: collision with root package name */
    private final eu.bolt.driver.core.storage.field.SimpleField f23102o;

    /* renamed from: p  reason: collision with root package name */
    private final SimpleField f23103p;

    /* renamed from: q  reason: collision with root package name */
    private final StringSettingsField f23104q;

    /* renamed from: r  reason: collision with root package name */
    private final BooleanSettingsField f23105r;

    /* renamed from: s  reason: collision with root package name */
    private final SimpleField f23106s;

    /* renamed from: t  reason: collision with root package name */
    private final BooleanSettingsField f23107t;

    /* renamed from: v  reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f23087v = {Reflection.d(new MutablePropertyReference1Impl(DeviceSettings.class, "lastLoginPhone", "getLastLoginPhone()Ljava/lang/String;", 0)), Reflection.d(new MutablePropertyReference1Impl(DeviceSettings.class, "lastLoginPhonePrefix", "getLastLoginPhonePrefix()Ljava/lang/String;", 0)), Reflection.d(new MutablePropertyReference1Impl(DeviceSettings.class, "encryptedToken", "getEncryptedToken()Ljava/lang/String;", 0)), Reflection.d(new MutablePropertyReference1Impl(DeviceSettings.class, "partnerRefreshToken", "getPartnerRefreshToken()Ljava/lang/String;", 0)), Reflection.d(new MutablePropertyReference1Impl(DeviceSettings.class, "lastNetworkUsageUpload", "getLastNetworkUsageUpload()Lee/mtakso/driver/network/usage/NetworkUsageUpload;", 0))};

    /* renamed from: u  reason: collision with root package name */
    public static final Companion f23086u = new Companion(null);

    /* compiled from: DeviceSettings.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Type inference failed for: r9v1, types: [eu.bolt.driver.core.storage.OnStorageVersionUpgradedListener, ee.mtakso.driver.param.DeviceSettings$storageMigrator$1] */
    @Inject
    public DeviceSettings(Context context, BoltPrefsStorageMigration migration, StorageFactory storageFactory) {
        List<? extends StorageMigration> k8;
        Intrinsics.f(context, "context");
        Intrinsics.f(migration, "migration");
        Intrinsics.f(storageFactory, "storageFactory");
        this.f23088a = migration;
        ?? r9 = new OnStorageVersionUpgradedListener() { // from class: ee.mtakso.driver.param.DeviceSettings$storageMigrator$1
            @Override // eu.bolt.driver.core.storage.OnStorageVersionUpgradedListener
            public void a(int i8, int i9, BoltPrefsStorage storage) {
                BoltPrefsStorageMigration boltPrefsStorageMigration;
                Intrinsics.f(storage, "storage");
                boltPrefsStorageMigration = DeviceSettings.this.f23088a;
                boltPrefsStorageMigration.e(i8, i9, storage);
            }
        };
        this.f23089b = r9;
        this.f23090c = 3;
        BoltSharedPrefs boltSharedPrefs = new BoltSharedPrefs(context, "mtakso", 3, r9);
        this.f23091d = boltSharedPrefs;
        k8 = CollectionsKt__CollectionsKt.k();
        KVStorage a8 = storageFactory.a("bolt", k8);
        this.f23092e = a8;
        StringReadWrite stringReadWrite = new StringReadWrite(boltSharedPrefs);
        this.f23093f = stringReadWrite;
        NullableStringReadWrite nullableStringReadWrite = new NullableStringReadWrite(a8);
        this.f23094g = nullableStringReadWrite;
        JsonReadWrite<NetworkUsageUpload> jsonReadWrite = new JsonReadWrite<>(boltSharedPrefs, NetworkUsageUpload.class);
        this.f23095h = jsonReadWrite;
        this.f23096i = new StringSettingsField("device_uuid", null, boltSharedPrefs);
        this.f23097j = new StringSettingsField("last_logged_in_driver_user_name", null, boltSharedPrefs);
        this.f23098k = new SimpleField("last_logged_in_driver_user_phome", "", stringReadWrite);
        this.f23099l = new SimpleField("last_logged_in_driver_user_phome_country", "", stringReadWrite);
        this.f23100m = new LongSettingsField("last_logged_in_driver_id", -1L, boltSharedPrefs);
        this.f23101n = new StringSettingsField("driver_refresh_token", null, boltSharedPrefs);
        this.f23102o = new eu.bolt.driver.core.storage.field.SimpleField("REFRESH_TOKEN", null, nullableStringReadWrite);
        this.f23103p = new SimpleField("partner_refresh_token", "", stringReadWrite);
        this.f23104q = new StringSettingsField("driver_registration_token", null, boltSharedPrefs);
        this.f23105r = new BooleanSettingsField("NewLoginFlow", false, boltSharedPrefs);
        this.f23106s = new SimpleField("last_network_usage_upload_time_ms", null, jsonReadWrite);
        this.f23107t = new BooleanSettingsField("session_expired", false, boltSharedPrefs);
    }

    private final String d() {
        return (String) this.f23102o.a(this, f23087v[2]);
    }

    private final void o(String str) {
        this.f23102o.b(this, f23087v[2], str);
    }

    public final BoltPrefsStorage b() {
        return this.f23091d;
    }

    public final StringSettingsField c() {
        return this.f23096i;
    }

    public final String e() {
        return (String) this.f23098k.a(this, f23087v[0]);
    }

    public final String f() {
        return (String) this.f23099l.a(this, f23087v[1]);
    }

    public final NetworkUsageUpload g() {
        return (NetworkUsageUpload) this.f23106s.a(this, f23087v[4]);
    }

    public final LongSettingsField h() {
        return this.f23100m;
    }

    public final StringSettingsField i() {
        return this.f23097j;
    }

    public final String j() {
        return (String) this.f23103p.a(this, f23087v[3]);
    }

    public final BooleanSettingsField k() {
        return this.f23107t;
    }

    public final String l() {
        String a8 = this.f23101n.a();
        if (a8 != null) {
            o(a8);
            this.f23101n.b(null);
        }
        return d();
    }

    public final StringSettingsField m() {
        return this.f23104q;
    }

    public final void n() {
        t(null);
    }

    public final void p(String str) {
        Intrinsics.f(str, "<set-?>");
        this.f23098k.b(this, f23087v[0], str);
    }

    public final void q(String str) {
        Intrinsics.f(str, "<set-?>");
        this.f23099l.b(this, f23087v[1], str);
    }

    public final void r(NetworkUsageUpload networkUsageUpload) {
        this.f23106s.b(this, f23087v[4], networkUsageUpload);
    }

    public final void s(String str) {
        Intrinsics.f(str, "<set-?>");
        this.f23103p.b(this, f23087v[3], str);
    }

    public final void t(String str) {
        o(str);
    }
}
