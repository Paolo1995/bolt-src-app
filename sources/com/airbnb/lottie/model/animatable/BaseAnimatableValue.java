package com.airbnb.lottie.model.animatable;

import com.airbnb.lottie.value.Keyframe;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
abstract class BaseAnimatableValue<V, O> implements AnimatableValue<V, O> {

    /* renamed from: a  reason: collision with root package name */
    final List<Keyframe<V>> f9318a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseAnimatableValue(List<Keyframe<V>> list) {
        this.f9318a = list;
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public List<Keyframe<V>> b() {
        return this.f9318a;
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public boolean c() {
        if (!this.f9318a.isEmpty() && (this.f9318a.size() != 1 || !this.f9318a.get(0).h())) {
            return false;
        }
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.f9318a.isEmpty()) {
            sb.append("values=");
            sb.append(Arrays.toString(this.f9318a.toArray()));
        }
        return sb.toString();
    }
}
