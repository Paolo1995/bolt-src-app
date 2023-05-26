package com.bumptech.glide.load.resource;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public final class UnitTransformation<T> implements Transformation<T> {

    /* renamed from: b  reason: collision with root package name */
    private static final Transformation<?> f10413b = new UnitTransformation();

    private UnitTransformation() {
    }

    @NonNull
    public static <T> UnitTransformation<T> c() {
        return (UnitTransformation) f10413b;
    }

    @Override // com.bumptech.glide.load.Transformation
    @NonNull
    public Resource<T> a(@NonNull Context context, @NonNull Resource<T> resource, int i8, int i9) {
        return resource;
    }

    @Override // com.bumptech.glide.load.Key
    public void b(@NonNull MessageDigest messageDigest) {
    }
}
