package com.google.android.material.animation;

import android.graphics.drawable.Drawable;
import android.util.Property;
import androidx.annotation.NonNull;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class DrawableAlphaProperty extends Property<Drawable, Integer> {

    /* renamed from: b  reason: collision with root package name */
    public static final Property<Drawable, Integer> f12727b = new DrawableAlphaProperty();

    /* renamed from: a  reason: collision with root package name */
    private final WeakHashMap<Drawable, Integer> f12728a;

    private DrawableAlphaProperty() {
        super(Integer.class, "drawableAlphaCompat");
        this.f12728a = new WeakHashMap<>();
    }

    @Override // android.util.Property
    /* renamed from: a */
    public Integer get(@NonNull Drawable drawable) {
        return Integer.valueOf(drawable.getAlpha());
    }

    @Override // android.util.Property
    /* renamed from: b */
    public void set(@NonNull Drawable drawable, @NonNull Integer num) {
        drawable.setAlpha(num.intValue());
    }
}
