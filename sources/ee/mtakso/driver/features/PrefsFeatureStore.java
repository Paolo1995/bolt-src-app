package ee.mtakso.driver.features;

import android.content.Context;
import android.content.SharedPreferences;
import ee.mtakso.driver.features.FeatureStore;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PrefsFeatureStore.kt */
/* loaded from: classes3.dex */
public final class PrefsFeatureStore implements FeatureStore {

    /* renamed from: a  reason: collision with root package name */
    private final SharedPreferences f20911a;

    public PrefsFeatureStore(Context context) {
        Intrinsics.f(context, "context");
        this.f20911a = context.getSharedPreferences("prefs.features", 0);
    }

    @Override // ee.mtakso.driver.features.FeatureStore
    public void a(String name, FeatureStore.Result status) {
        boolean z7;
        Intrinsics.f(name, "name");
        Intrinsics.f(status, "status");
        if (status == FeatureStore.Result.NOT_SET) {
            this.f20911a.edit().remove(name).apply();
            return;
        }
        if (status == FeatureStore.Result.ENABLED) {
            z7 = true;
        } else {
            z7 = false;
        }
        this.f20911a.edit().putBoolean(name, z7).apply();
    }

    @Override // ee.mtakso.driver.features.FeatureStore
    public FeatureStore.Result b(String name) {
        Intrinsics.f(name, "name");
        if (!this.f20911a.contains(name)) {
            return FeatureStore.Result.NOT_SET;
        }
        if (this.f20911a.getBoolean(name, false)) {
            return FeatureStore.Result.ENABLED;
        }
        return FeatureStore.Result.DISABLED;
    }
}
