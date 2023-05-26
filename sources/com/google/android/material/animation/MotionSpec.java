package com.google.android.material.animation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.Property;
import androidx.annotation.NonNull;
import androidx.collection.SimpleArrayMap;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class MotionSpec {

    /* renamed from: a  reason: collision with root package name */
    private final SimpleArrayMap<String, MotionTiming> f12733a = new SimpleArrayMap<>();

    /* renamed from: b  reason: collision with root package name */
    private final SimpleArrayMap<String, PropertyValuesHolder[]> f12734b = new SimpleArrayMap<>();

    private static void a(@NonNull MotionSpec motionSpec, Animator animator) {
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            motionSpec.l(objectAnimator.getPropertyName(), objectAnimator.getValues());
            motionSpec.m(objectAnimator.getPropertyName(), MotionTiming.b(objectAnimator));
            return;
        }
        throw new IllegalArgumentException("Animator must be an ObjectAnimator: " + animator);
    }

    @NonNull
    private PropertyValuesHolder[] b(@NonNull PropertyValuesHolder[] propertyValuesHolderArr) {
        PropertyValuesHolder[] propertyValuesHolderArr2 = new PropertyValuesHolder[propertyValuesHolderArr.length];
        for (int i8 = 0; i8 < propertyValuesHolderArr.length; i8++) {
            propertyValuesHolderArr2[i8] = propertyValuesHolderArr[i8].clone();
        }
        return propertyValuesHolderArr2;
    }

    public static MotionSpec c(@NonNull Context context, @NonNull TypedArray typedArray, int i8) {
        int resourceId;
        if (typedArray.hasValue(i8) && (resourceId = typedArray.getResourceId(i8, 0)) != 0) {
            return d(context, resourceId);
        }
        return null;
    }

    public static MotionSpec d(@NonNull Context context, int i8) {
        try {
            Animator loadAnimator = AnimatorInflater.loadAnimator(context, i8);
            if (loadAnimator instanceof AnimatorSet) {
                return e(((AnimatorSet) loadAnimator).getChildAnimations());
            }
            if (loadAnimator == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(loadAnimator);
            return e(arrayList);
        } catch (Exception e8) {
            Log.w("MotionSpec", "Can't load animation resource ID #0x" + Integer.toHexString(i8), e8);
            return null;
        }
    }

    @NonNull
    private static MotionSpec e(@NonNull List<Animator> list) {
        MotionSpec motionSpec = new MotionSpec();
        int size = list.size();
        for (int i8 = 0; i8 < size; i8++) {
            a(motionSpec, list.get(i8));
        }
        return motionSpec;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MotionSpec)) {
            return false;
        }
        return this.f12733a.equals(((MotionSpec) obj).f12733a);
    }

    @NonNull
    public <T> ObjectAnimator f(@NonNull String str, @NonNull T t7, @NonNull Property<T, ?> property) {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(t7, g(str));
        ofPropertyValuesHolder.setProperty(property);
        h(str).a(ofPropertyValuesHolder);
        return ofPropertyValuesHolder;
    }

    @NonNull
    public PropertyValuesHolder[] g(String str) {
        if (j(str)) {
            return b(this.f12734b.get(str));
        }
        throw new IllegalArgumentException();
    }

    public MotionTiming h(String str) {
        if (k(str)) {
            return this.f12733a.get(str);
        }
        throw new IllegalArgumentException();
    }

    public int hashCode() {
        return this.f12733a.hashCode();
    }

    public long i() {
        int size = this.f12733a.size();
        long j8 = 0;
        for (int i8 = 0; i8 < size; i8++) {
            MotionTiming n8 = this.f12733a.n(i8);
            j8 = Math.max(j8, n8.c() + n8.d());
        }
        return j8;
    }

    public boolean j(String str) {
        if (this.f12734b.get(str) != null) {
            return true;
        }
        return false;
    }

    public boolean k(String str) {
        if (this.f12733a.get(str) != null) {
            return true;
        }
        return false;
    }

    public void l(String str, PropertyValuesHolder[] propertyValuesHolderArr) {
        this.f12734b.put(str, propertyValuesHolderArr);
    }

    public void m(String str, MotionTiming motionTiming) {
        this.f12733a.put(str, motionTiming);
    }

    @NonNull
    public String toString() {
        return '\n' + getClass().getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " timings: " + this.f12733a + "}\n";
    }
}
