package ee.mtakso.driver.network.client.targeting;

import eu.bolt.driver.core.field.OverridableField;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TargetingParameters.kt */
/* loaded from: classes3.dex */
public final class TargetingParametersKt {
    public static final boolean a(TargetingParameters targetingParameters, OverridableField<Boolean> overridableField) {
        Intrinsics.f(targetingParameters, "<this>");
        Intrinsics.f(overridableField, "overridableField");
        return b(targetingParameters, overridableField.b(), overridableField.a().booleanValue());
    }

    public static final boolean b(TargetingParameters targetingParameters, String key, boolean z7) {
        Intrinsics.f(targetingParameters, "<this>");
        Intrinsics.f(key, "key");
        if (targetingParameters.a().get(key) instanceof Boolean) {
            Object obj = targetingParameters.a().get(key);
            Intrinsics.d(obj, "null cannot be cast to non-null type kotlin.Boolean");
            return ((Boolean) obj).booleanValue();
        }
        return z7;
    }

    public static final Set<String> c(TargetingParameters targetingParameters, OverridableField<Set<String>> overridableField) {
        Intrinsics.f(targetingParameters, "<this>");
        Intrinsics.f(overridableField, "overridableField");
        Set<String> d8 = d(targetingParameters, overridableField.b());
        if (d8.isEmpty()) {
            return overridableField.a();
        }
        return d8;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x001c, code lost:
        r1 = kotlin.collections.CollectionsKt___CollectionsKt.L0(r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.util.Set<java.lang.String> d(ee.mtakso.driver.network.client.targeting.TargetingParameters r1, java.lang.String r2) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.f(r1, r0)
            java.lang.String r0 = "parameterName"
            kotlin.jvm.internal.Intrinsics.f(r2, r0)
            java.util.Map r1 = r1.a()
            java.lang.Object r1 = r1.get(r2)
            boolean r2 = r1 instanceof java.util.List
            if (r2 == 0) goto L19
            java.util.List r1 = (java.util.List) r1
            goto L1a
        L19:
            r1 = 0
        L1a:
            if (r1 == 0) goto L22
            java.util.Set r1 = kotlin.collections.CollectionsKt.L0(r1)
            if (r1 != 0) goto L26
        L22:
            java.util.Set r1 = kotlin.collections.SetsKt.b()
        L26:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.network.client.targeting.TargetingParametersKt.d(ee.mtakso.driver.network.client.targeting.TargetingParameters, java.lang.String):java.util.Set");
    }
}
