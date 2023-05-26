package ee.mtakso.driver.features;

import android.content.Context;
import ee.mtakso.driver.features.Feature;
import ee.mtakso.driver.network.client.targeting.TargetingParameters;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Features.kt */
@Singleton
/* loaded from: classes3.dex */
public final class Features {

    /* renamed from: a  reason: collision with root package name */
    private final FeatureStore f20907a;

    /* renamed from: b  reason: collision with root package name */
    private final List<Feature> f20908b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<Feature.Type, Feature> f20909c;

    @Inject
    public Features(Context context) {
        Intrinsics.f(context, "context");
        PrefsFeatureStore prefsFeatureStore = new PrefsFeatureStore(context);
        this.f20907a = prefsFeatureStore;
        List<Feature> a8 = Feature.f20881c.a(prefsFeatureStore);
        this.f20908b = a8;
        this.f20909c = new LinkedHashMap();
        for (Feature feature : a8) {
            this.f20909c.put(feature.e(), feature);
        }
    }

    public final List<Feature> a() {
        return this.f20908b;
    }

    public final boolean b(Feature.Type type) {
        Object g8;
        Intrinsics.f(type, "type");
        g8 = MapsKt__MapsKt.g(this.f20909c, type);
        return ((Feature) g8).f();
    }

    public final boolean c(Feature.Type type) {
        Object g8;
        Intrinsics.f(type, "type");
        g8 = MapsKt__MapsKt.g(this.f20909c, type);
        return ((Feature) g8).h();
    }

    public final void d(TargetingParameters targetingParameters) {
        Intrinsics.f(targetingParameters, "targetingParameters");
        for (Feature feature : this.f20908b) {
            feature.j(targetingParameters);
        }
    }
}
