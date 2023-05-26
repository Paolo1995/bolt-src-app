package com.bumptech.glide.load.resource.drawable;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;

/* loaded from: classes.dex */
public class UnitDrawableDecoder implements ResourceDecoder<Drawable, Drawable> {
    @Override // com.bumptech.glide.load.ResourceDecoder
    /* renamed from: c */
    public Resource<Drawable> b(@NonNull Drawable drawable, int i8, int i9, @NonNull Options options) {
        return NonOwnedDrawableResource.f(drawable);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    /* renamed from: d */
    public boolean a(@NonNull Drawable drawable, @NonNull Options options) {
        return true;
    }
}
