package ee.mtakso.driver.ui.screens.safety_toolkit.safety_toolkit_home;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: SafetyToolkitData.kt */
/* loaded from: classes3.dex */
public final class SafetyFeature {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f32764a;

    /* renamed from: b  reason: collision with root package name */
    private final SafetyFeatureData f32765b;

    public SafetyFeature(boolean z7, SafetyFeatureData data) {
        Intrinsics.f(data, "data");
        this.f32764a = z7;
        this.f32765b = data;
    }

    public final SafetyFeatureData a() {
        return this.f32765b;
    }

    public final boolean b() {
        return this.f32764a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SafetyFeature) {
            SafetyFeature safetyFeature = (SafetyFeature) obj;
            return this.f32764a == safetyFeature.f32764a && Intrinsics.a(this.f32765b, safetyFeature.f32765b);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z7 = this.f32764a;
        ?? r02 = z7;
        if (z7) {
            r02 = 1;
        }
        return (r02 * 31) + this.f32765b.hashCode();
    }

    public String toString() {
        boolean z7 = this.f32764a;
        SafetyFeatureData safetyFeatureData = this.f32765b;
        return "SafetyFeature(isEnabled=" + z7 + ", data=" + safetyFeatureData + ")";
    }
}
