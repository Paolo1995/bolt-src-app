package ee.mtakso.driver.param;

import android.content.Context;
import ee.mtakso.driver.network.client.targeting.TargetingParameters;
import ee.mtakso.driver.network.client.targeting.TargetingParametersKt;
import eu.bolt.driver.core.field.OverridableField;
import eu.bolt.driver.core.field.io.BooleanReadWrite;
import eu.bolt.driver.core.field.io.StringSetReadWrite;
import eu.bolt.driver.core.storage.BoltPrefsStorage;
import eu.bolt.driver.core.storage.BoltSharedPrefs;
import eu.bolt.driver.core.storage.OnStorageVersionUpgradedListener;
import java.util.Set;
import javax.inject.Inject;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* compiled from: DeviceFeatures.kt */
/* loaded from: classes3.dex */
public final class DeviceFeatures {

    /* renamed from: j  reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f23075j = {Reflection.d(new MutablePropertyReference1Impl(DeviceFeatures.class, "appLogMonitoringInMemory", "getAppLogMonitoringInMemory()Ljava/util/Set;", 0)), Reflection.d(new MutablePropertyReference1Impl(DeviceFeatures.class, "newAuthenticationEnabled", "getNewAuthenticationEnabled()Z", 0)), Reflection.d(new MutablePropertyReference1Impl(DeviceFeatures.class, "loginV3Enabled", "getLoginV3Enabled()Z", 0)), Reflection.d(new MutablePropertyReference1Impl(DeviceFeatures.class, "authorisedActivityEnabled", "getAuthorisedActivityEnabled()Z", 0)), Reflection.d(new MutablePropertyReference1Impl(DeviceFeatures.class, "isClientSecretRequired", "isClientSecretRequired()Z", 0))};

    /* renamed from: a  reason: collision with root package name */
    private final DeviceFeatures$storageMigrator$1 f23076a;

    /* renamed from: b  reason: collision with root package name */
    private final BoltPrefsStorage f23077b;

    /* renamed from: c  reason: collision with root package name */
    private final StringSetReadWrite f23078c;

    /* renamed from: d  reason: collision with root package name */
    private final BooleanReadWrite f23079d;

    /* renamed from: e  reason: collision with root package name */
    private final OverridableField<Set<String>> f23080e;

    /* renamed from: f  reason: collision with root package name */
    private final OverridableField<Boolean> f23081f;

    /* renamed from: g  reason: collision with root package name */
    private final OverridableField<Boolean> f23082g;

    /* renamed from: h  reason: collision with root package name */
    private final OverridableField<Boolean> f23083h;

    /* renamed from: i  reason: collision with root package name */
    private final OverridableField<Boolean> f23084i;

    /* JADX WARN: Type inference failed for: r0v1, types: [eu.bolt.driver.core.storage.OnStorageVersionUpgradedListener, ee.mtakso.driver.param.DeviceFeatures$storageMigrator$1] */
    @Inject
    public DeviceFeatures(Context context) {
        Set b8;
        Intrinsics.f(context, "context");
        ?? r02 = new OnStorageVersionUpgradedListener() { // from class: ee.mtakso.driver.param.DeviceFeatures$storageMigrator$1
            @Override // eu.bolt.driver.core.storage.OnStorageVersionUpgradedListener
            public void a(int i8, int i9, BoltPrefsStorage storage) {
                Intrinsics.f(storage, "storage");
            }
        };
        this.f23076a = r02;
        BoltSharedPrefs boltSharedPrefs = new BoltSharedPrefs(context, "device_targeting", 0, r02);
        this.f23077b = boltSharedPrefs;
        StringSetReadWrite stringSetReadWrite = new StringSetReadWrite(boltSharedPrefs);
        this.f23078c = stringSetReadWrite;
        BooleanReadWrite booleanReadWrite = new BooleanReadWrite(boltSharedPrefs);
        this.f23079d = booleanReadWrite;
        b8 = SetsKt__SetsKt.b();
        this.f23080e = new OverridableField<>("monitoring_applog_in_memory", b8, stringSetReadWrite);
        this.f23081f = new OverridableField<>("eng_is_2fa_enabled", Boolean.TRUE, booleanReadWrite);
        Boolean bool = Boolean.FALSE;
        this.f23082g = new OverridableField<>("prod_is_new_login_flow_enabled", bool, booleanReadWrite);
        this.f23083h = new OverridableField<>("eng_is_authorised_activity_enabled", bool, booleanReadWrite);
        this.f23084i = new OverridableField<>("is_client_secret_required", bool, booleanReadWrite);
    }

    private final void f(Set<String> set) {
        this.f23080e.e(this, f23075j[0], set);
    }

    private final void g(boolean z7) {
        this.f23083h.e(this, f23075j[3], Boolean.valueOf(z7));
    }

    private final void h(boolean z7) {
        this.f23084i.e(this, f23075j[4], Boolean.valueOf(z7));
    }

    private final void i(boolean z7) {
        this.f23082g.e(this, f23075j[2], Boolean.valueOf(z7));
    }

    private final void j(boolean z7) {
        this.f23081f.e(this, f23075j[1], Boolean.valueOf(z7));
    }

    public final Set<String> a() {
        return this.f23080e.d(this, f23075j[0]);
    }

    public final boolean b() {
        return this.f23082g.d(this, f23075j[2]).booleanValue();
    }

    public final boolean c() {
        return this.f23081f.d(this, f23075j[1]).booleanValue();
    }

    public final boolean d() {
        return this.f23084i.d(this, f23075j[4]).booleanValue();
    }

    public final void e(TargetingParameters config) {
        Intrinsics.f(config, "config");
        f(TargetingParametersKt.c(config, this.f23080e));
        j(TargetingParametersKt.a(config, this.f23081f));
        g(TargetingParametersKt.a(config, this.f23083h));
        i(TargetingParametersKt.a(config, this.f23082g));
        h(TargetingParametersKt.a(config, this.f23084i));
    }
}
