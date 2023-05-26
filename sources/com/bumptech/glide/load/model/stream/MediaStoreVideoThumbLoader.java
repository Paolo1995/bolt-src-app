package com.bumptech.glide.load.model.stream;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.mediastore.MediaStoreUtil;
import com.bumptech.glide.load.data.mediastore.ThumbFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import com.bumptech.glide.signature.ObjectKey;
import java.io.InputStream;

/* loaded from: classes.dex */
public class MediaStoreVideoThumbLoader implements ModelLoader<Uri, InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f10383a;

    /* loaded from: classes.dex */
    public static class Factory implements ModelLoaderFactory<Uri, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final Context f10384a;

        public Factory(Context context) {
            this.f10384a = context;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        @NonNull
        public ModelLoader<Uri, InputStream> b(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new MediaStoreVideoThumbLoader(this.f10384a);
        }
    }

    public MediaStoreVideoThumbLoader(Context context) {
        this.f10383a = context.getApplicationContext();
    }

    private boolean e(Options options) {
        Long l8 = (Long) options.c(VideoDecoder.f10503d);
        if (l8 != null && l8.longValue() == -1) {
            return true;
        }
        return false;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    /* renamed from: c */
    public ModelLoader.LoadData<InputStream> b(@NonNull Uri uri, int i8, int i9, @NonNull Options options) {
        if (MediaStoreUtil.d(i8, i9) && e(options)) {
            return new ModelLoader.LoadData<>(new ObjectKey(uri), ThumbFetcher.g(this.f10383a, uri));
        }
        return null;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    /* renamed from: d */
    public boolean a(@NonNull Uri uri) {
        return MediaStoreUtil.c(uri);
    }
}
