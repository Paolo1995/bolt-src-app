package eu.bolt.android.maps.core.animation;

import android.animation.TypeEvaluator;
import eu.bolt.android.maps.core.Locatable;
import eu.bolt.android.maps.core.MapPoint;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LinearPointEvaluator.kt */
/* loaded from: classes5.dex */
public final class LinearPointEvaluator implements TypeEvaluator<Locatable> {
    @Override // android.animation.TypeEvaluator
    /* renamed from: a */
    public Locatable evaluate(float f8, Locatable startValue, Locatable endValue) {
        Intrinsics.f(startValue, "startValue");
        Intrinsics.f(endValue, "endValue");
        double d8 = f8;
        return new MapPoint(((endValue.a() - startValue.a()) * d8) + startValue.a(), ((endValue.b() - startValue.b()) * d8) + startValue.b());
    }
}
