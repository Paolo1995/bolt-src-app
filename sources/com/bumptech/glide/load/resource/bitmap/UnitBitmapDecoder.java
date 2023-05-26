package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Util;

/* loaded from: classes.dex */
public final class UnitBitmapDecoder implements ResourceDecoder<Bitmap, Bitmap> {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class NonOwnedBitmapResource implements Resource<Bitmap> {

        /* renamed from: f  reason: collision with root package name */
        private final Bitmap f10502f;

        NonOwnedBitmapResource(@NonNull Bitmap bitmap) {
            this.f10502f = bitmap;
        }

        @Override // com.bumptech.glide.load.engine.Resource
        @NonNull
        /* renamed from: a */
        public Bitmap get() {
            return this.f10502f;
        }

        @Override // com.bumptech.glide.load.engine.Resource
        public int b() {
            return Util.h(this.f10502f);
        }

        @Override // com.bumptech.glide.load.engine.Resource
        public void c() {
        }

        @Override // com.bumptech.glide.load.engine.Resource
        @NonNull
        public Class<Bitmap> d() {
            return Bitmap.class;
        }
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    /* renamed from: c */
    public Resource<Bitmap> b(@NonNull Bitmap bitmap, int i8, int i9, @NonNull Options options) {
        return new NonOwnedBitmapResource(bitmap);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    /* renamed from: d */
    public boolean a(@NonNull Bitmap bitmap, @NonNull Options options) {
        return true;
    }
}
