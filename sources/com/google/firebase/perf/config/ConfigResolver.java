package com.google.firebase.perf.config;

import android.content.Context;
import com.google.firebase.perf.BuildConfig;
import com.google.firebase.perf.internal.RemoteConfigManager;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.util.ImmutableBundle;
import com.google.firebase.perf.util.Optional;
import com.google.firebase.perf.util.Utils;

/* loaded from: classes3.dex */
public class ConfigResolver {

    /* renamed from: d  reason: collision with root package name */
    private static final AndroidLogger f16652d = AndroidLogger.e();

    /* renamed from: e  reason: collision with root package name */
    private static volatile ConfigResolver f16653e;

    /* renamed from: a  reason: collision with root package name */
    private ImmutableBundle f16654a;

    /* renamed from: b  reason: collision with root package name */
    private RemoteConfigManager f16655b;

    /* renamed from: c  reason: collision with root package name */
    private DeviceCacheManager f16656c;

    public ConfigResolver(RemoteConfigManager remoteConfigManager, ImmutableBundle immutableBundle, DeviceCacheManager deviceCacheManager) {
        this.f16655b = remoteConfigManager == null ? RemoteConfigManager.getInstance() : remoteConfigManager;
        this.f16654a = immutableBundle == null ? new ImmutableBundle() : immutableBundle;
        this.f16656c = deviceCacheManager == null ? DeviceCacheManager.d() : deviceCacheManager;
    }

    private boolean F(long j8) {
        return j8 >= 0;
    }

    private boolean G(String str) {
        if (str.trim().isEmpty()) {
            return false;
        }
        for (String str2 : str.split(";")) {
            if (str2.trim().equals(BuildConfig.f16644b)) {
                return true;
            }
        }
        return false;
    }

    private boolean H(long j8) {
        return j8 >= 0;
    }

    private boolean J(float f8) {
        return 0.0f <= f8 && f8 <= 1.0f;
    }

    private boolean K(long j8) {
        return j8 > 0;
    }

    private boolean L(long j8) {
        return j8 > 0;
    }

    private Optional<Boolean> b(ConfigurationFlag<Boolean> configurationFlag) {
        return this.f16656c.a(configurationFlag.a());
    }

    private Optional<Float> c(ConfigurationFlag<Float> configurationFlag) {
        return this.f16656c.c(configurationFlag.a());
    }

    private Optional<Long> d(ConfigurationFlag<Long> configurationFlag) {
        return this.f16656c.e(configurationFlag.a());
    }

    private Optional<String> e(ConfigurationFlag<String> configurationFlag) {
        return this.f16656c.f(configurationFlag.a());
    }

    public static synchronized ConfigResolver f() {
        ConfigResolver configResolver;
        synchronized (ConfigResolver.class) {
            if (f16653e == null) {
                f16653e = new ConfigResolver(null, null, null);
            }
            configResolver = f16653e;
        }
        return configResolver;
    }

    private boolean i() {
        ConfigurationConstants$SdkEnabled e8 = ConfigurationConstants$SdkEnabled.e();
        Optional<Boolean> s7 = s(e8);
        if (s7.d()) {
            if (this.f16655b.isLastFetchFailed()) {
                return false;
            }
            this.f16656c.k(e8.a(), s7.c().booleanValue());
            return s7.c().booleanValue();
        }
        Optional<Boolean> b8 = b(e8);
        if (b8.d()) {
            return b8.c().booleanValue();
        }
        return e8.d().booleanValue();
    }

    private boolean j() {
        ConfigurationConstants$SdkDisabledVersions e8 = ConfigurationConstants$SdkDisabledVersions.e();
        Optional<String> v7 = v(e8);
        if (v7.d()) {
            this.f16656c.j(e8.a(), v7.c());
            return G(v7.c());
        }
        Optional<String> e9 = e(e8);
        if (e9.d()) {
            return G(e9.c());
        }
        return G(e8.d());
    }

    private Optional<Boolean> l(ConfigurationFlag<Boolean> configurationFlag) {
        return this.f16654a.b(configurationFlag.b());
    }

    private Optional<Float> m(ConfigurationFlag<Float> configurationFlag) {
        return this.f16654a.c(configurationFlag.b());
    }

    private Optional<Long> n(ConfigurationFlag<Long> configurationFlag) {
        return this.f16654a.e(configurationFlag.b());
    }

    private Optional<Boolean> s(ConfigurationFlag<Boolean> configurationFlag) {
        return this.f16655b.getBoolean(configurationFlag.c());
    }

    private Optional<Float> t(ConfigurationFlag<Float> configurationFlag) {
        return this.f16655b.getFloat(configurationFlag.c());
    }

    private Optional<Long> u(ConfigurationFlag<Long> configurationFlag) {
        return this.f16655b.getLong(configurationFlag.c());
    }

    private Optional<String> v(ConfigurationFlag<String> configurationFlag) {
        return this.f16655b.getString(configurationFlag.c());
    }

    public long A() {
        ConfigurationConstants$SessionsMemoryCaptureFrequencyForegroundMs e8 = ConfigurationConstants$SessionsMemoryCaptureFrequencyForegroundMs.e();
        Optional<Long> n8 = n(e8);
        if (n8.d() && H(n8.c().longValue())) {
            return n8.c().longValue();
        }
        Optional<Long> u7 = u(e8);
        if (u7.d() && H(u7.c().longValue())) {
            this.f16656c.i(e8.a(), u7.c().longValue());
            return u7.c().longValue();
        }
        Optional<Long> d8 = d(e8);
        if (d8.d() && H(d8.c().longValue())) {
            return d8.c().longValue();
        }
        return e8.d().longValue();
    }

    public float B() {
        ConfigurationConstants$SessionsSamplingRate e8 = ConfigurationConstants$SessionsSamplingRate.e();
        Optional<Float> m8 = m(e8);
        if (m8.d()) {
            float floatValue = m8.c().floatValue() / 100.0f;
            if (J(floatValue)) {
                return floatValue;
            }
        }
        Optional<Float> t7 = t(e8);
        if (t7.d() && J(t7.c().floatValue())) {
            this.f16656c.h(e8.a(), t7.c().floatValue());
            return t7.c().floatValue();
        }
        Optional<Float> c8 = c(e8);
        if (c8.d() && J(c8.c().floatValue())) {
            return c8.c().floatValue();
        }
        return e8.d().floatValue();
    }

    public long C() {
        ConfigurationConstants$TraceEventCountBackground e8 = ConfigurationConstants$TraceEventCountBackground.e();
        Optional<Long> u7 = u(e8);
        if (u7.d() && F(u7.c().longValue())) {
            this.f16656c.i(e8.a(), u7.c().longValue());
            return u7.c().longValue();
        }
        Optional<Long> d8 = d(e8);
        if (d8.d() && F(d8.c().longValue())) {
            return d8.c().longValue();
        }
        return e8.d().longValue();
    }

    public long D() {
        ConfigurationConstants$TraceEventCountForeground e8 = ConfigurationConstants$TraceEventCountForeground.e();
        Optional<Long> u7 = u(e8);
        if (u7.d() && F(u7.c().longValue())) {
            this.f16656c.i(e8.a(), u7.c().longValue());
            return u7.c().longValue();
        }
        Optional<Long> d8 = d(e8);
        if (d8.d() && F(d8.c().longValue())) {
            return d8.c().longValue();
        }
        return e8.d().longValue();
    }

    public float E() {
        ConfigurationConstants$TraceSamplingRate e8 = ConfigurationConstants$TraceSamplingRate.e();
        Optional<Float> t7 = t(e8);
        if (t7.d() && J(t7.c().floatValue())) {
            this.f16656c.h(e8.a(), t7.c().floatValue());
            return t7.c().floatValue();
        }
        Optional<Float> c8 = c(e8);
        if (c8.d() && J(c8.c().floatValue())) {
            return c8.c().floatValue();
        }
        return e8.d().floatValue();
    }

    public boolean I() {
        Boolean h8 = h();
        if ((h8 == null || h8.booleanValue()) && k()) {
            return true;
        }
        return false;
    }

    public void M(Context context) {
        f16652d.h(Utils.b(context));
        this.f16656c.g(context);
    }

    public void N(Context context) {
        M(context.getApplicationContext());
    }

    public void O(ImmutableBundle immutableBundle) {
        this.f16654a = immutableBundle;
    }

    public String a() {
        String f8;
        ConfigurationConstants$LogSourceName e8 = ConfigurationConstants$LogSourceName.e();
        if (BuildConfig.f16643a.booleanValue()) {
            return e8.d();
        }
        String c8 = e8.c();
        long j8 = -1;
        if (c8 != null) {
            j8 = ((Long) this.f16655b.getRemoteConfigValueOrDefault(c8, -1L)).longValue();
        }
        String a8 = e8.a();
        if (ConfigurationConstants$LogSourceName.g(j8) && (f8 = ConfigurationConstants$LogSourceName.f(j8)) != null) {
            this.f16656c.j(a8, f8);
            return f8;
        }
        Optional<String> e9 = e(e8);
        if (e9.d()) {
            return e9.c();
        }
        return e8.d();
    }

    public Boolean g() {
        ConfigurationConstants$CollectionDeactivated e8 = ConfigurationConstants$CollectionDeactivated.e();
        Optional<Boolean> l8 = l(e8);
        if (l8.d()) {
            return l8.c();
        }
        return e8.d();
    }

    public Boolean h() {
        if (g().booleanValue()) {
            return Boolean.FALSE;
        }
        ConfigurationConstants$CollectionEnabled d8 = ConfigurationConstants$CollectionEnabled.d();
        Optional<Boolean> b8 = b(d8);
        if (b8.d()) {
            return b8.c();
        }
        Optional<Boolean> l8 = l(d8);
        if (l8.d()) {
            return l8.c();
        }
        f16652d.a("CollectionEnabled metadata key unknown or value not found in manifest.");
        return null;
    }

    public boolean k() {
        if (i() && !j()) {
            return true;
        }
        return false;
    }

    public long o() {
        ConfigurationConstants$NetworkEventCountBackground e8 = ConfigurationConstants$NetworkEventCountBackground.e();
        Optional<Long> u7 = u(e8);
        if (u7.d() && F(u7.c().longValue())) {
            this.f16656c.i(e8.a(), u7.c().longValue());
            return u7.c().longValue();
        }
        Optional<Long> d8 = d(e8);
        if (d8.d() && F(d8.c().longValue())) {
            return d8.c().longValue();
        }
        return e8.d().longValue();
    }

    public long p() {
        ConfigurationConstants$NetworkEventCountForeground e8 = ConfigurationConstants$NetworkEventCountForeground.e();
        Optional<Long> u7 = u(e8);
        if (u7.d() && F(u7.c().longValue())) {
            this.f16656c.i(e8.a(), u7.c().longValue());
            return u7.c().longValue();
        }
        Optional<Long> d8 = d(e8);
        if (d8.d() && F(d8.c().longValue())) {
            return d8.c().longValue();
        }
        return e8.d().longValue();
    }

    public float q() {
        ConfigurationConstants$NetworkRequestSamplingRate e8 = ConfigurationConstants$NetworkRequestSamplingRate.e();
        Optional<Float> t7 = t(e8);
        if (t7.d() && J(t7.c().floatValue())) {
            this.f16656c.h(e8.a(), t7.c().floatValue());
            return t7.c().floatValue();
        }
        Optional<Float> c8 = c(e8);
        if (c8.d() && J(c8.c().floatValue())) {
            return c8.c().floatValue();
        }
        return e8.d().floatValue();
    }

    public long r() {
        ConfigurationConstants$RateLimitSec e8 = ConfigurationConstants$RateLimitSec.e();
        Optional<Long> u7 = u(e8);
        if (u7.d() && L(u7.c().longValue())) {
            this.f16656c.i(e8.a(), u7.c().longValue());
            return u7.c().longValue();
        }
        Optional<Long> d8 = d(e8);
        if (d8.d() && L(d8.c().longValue())) {
            return d8.c().longValue();
        }
        return e8.d().longValue();
    }

    public long w() {
        ConfigurationConstants$SessionsCpuCaptureFrequencyBackgroundMs e8 = ConfigurationConstants$SessionsCpuCaptureFrequencyBackgroundMs.e();
        Optional<Long> n8 = n(e8);
        if (n8.d() && H(n8.c().longValue())) {
            return n8.c().longValue();
        }
        Optional<Long> u7 = u(e8);
        if (u7.d() && H(u7.c().longValue())) {
            this.f16656c.i(e8.a(), u7.c().longValue());
            return u7.c().longValue();
        }
        Optional<Long> d8 = d(e8);
        if (d8.d() && H(d8.c().longValue())) {
            return d8.c().longValue();
        }
        return e8.d().longValue();
    }

    public long x() {
        ConfigurationConstants$SessionsCpuCaptureFrequencyForegroundMs e8 = ConfigurationConstants$SessionsCpuCaptureFrequencyForegroundMs.e();
        Optional<Long> n8 = n(e8);
        if (n8.d() && H(n8.c().longValue())) {
            return n8.c().longValue();
        }
        Optional<Long> u7 = u(e8);
        if (u7.d() && H(u7.c().longValue())) {
            this.f16656c.i(e8.a(), u7.c().longValue());
            return u7.c().longValue();
        }
        Optional<Long> d8 = d(e8);
        if (d8.d() && H(d8.c().longValue())) {
            return d8.c().longValue();
        }
        return e8.d().longValue();
    }

    public long y() {
        ConfigurationConstants$SessionsMaxDurationMinutes e8 = ConfigurationConstants$SessionsMaxDurationMinutes.e();
        Optional<Long> n8 = n(e8);
        if (n8.d() && K(n8.c().longValue())) {
            return n8.c().longValue();
        }
        Optional<Long> u7 = u(e8);
        if (u7.d() && K(u7.c().longValue())) {
            this.f16656c.i(e8.a(), u7.c().longValue());
            return u7.c().longValue();
        }
        Optional<Long> d8 = d(e8);
        if (d8.d() && K(d8.c().longValue())) {
            return d8.c().longValue();
        }
        return e8.d().longValue();
    }

    public long z() {
        ConfigurationConstants$SessionsMemoryCaptureFrequencyBackgroundMs e8 = ConfigurationConstants$SessionsMemoryCaptureFrequencyBackgroundMs.e();
        Optional<Long> n8 = n(e8);
        if (n8.d() && H(n8.c().longValue())) {
            return n8.c().longValue();
        }
        Optional<Long> u7 = u(e8);
        if (u7.d() && H(u7.c().longValue())) {
            this.f16656c.i(e8.a(), u7.c().longValue());
            return u7.c().longValue();
        }
        Optional<Long> d8 = d(e8);
        if (d8.d() && H(d8.c().longValue())) {
            return d8.c().longValue();
        }
        return e8.d().longValue();
    }
}
