package com.bumptech.glide.load.model;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.InputStream;

/* loaded from: classes.dex */
public class ResourceLoader<Data> implements ModelLoader<Integer, Data> {

    /* renamed from: a  reason: collision with root package name */
    private final ModelLoader<Uri, Data> f10360a;

    /* renamed from: b  reason: collision with root package name */
    private final Resources f10361b;

    /* loaded from: classes.dex */
    public static final class AssetFileDescriptorFactory implements ModelLoaderFactory<Integer, AssetFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        private final Resources f10362a;

        public AssetFileDescriptorFactory(Resources resources) {
            this.f10362a = resources;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader<Integer, AssetFileDescriptor> b(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ResourceLoader(this.f10362a, multiModelLoaderFactory.d(Uri.class, AssetFileDescriptor.class));
        }
    }

    /* loaded from: classes.dex */
    public static class FileDescriptorFactory implements ModelLoaderFactory<Integer, ParcelFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        private final Resources f10363a;

        public FileDescriptorFactory(Resources resources) {
            this.f10363a = resources;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        @NonNull
        public ModelLoader<Integer, ParcelFileDescriptor> b(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ResourceLoader(this.f10363a, multiModelLoaderFactory.d(Uri.class, ParcelFileDescriptor.class));
        }
    }

    /* loaded from: classes.dex */
    public static class StreamFactory implements ModelLoaderFactory<Integer, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final Resources f10364a;

        public StreamFactory(Resources resources) {
            this.f10364a = resources;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        @NonNull
        public ModelLoader<Integer, InputStream> b(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ResourceLoader(this.f10364a, multiModelLoaderFactory.d(Uri.class, InputStream.class));
        }
    }

    /* loaded from: classes.dex */
    public static class UriFactory implements ModelLoaderFactory<Integer, Uri> {

        /* renamed from: a  reason: collision with root package name */
        private final Resources f10365a;

        public UriFactory(Resources resources) {
            this.f10365a = resources;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        @NonNull
        public ModelLoader<Integer, Uri> b(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ResourceLoader(this.f10365a, UnitModelLoader.c());
        }
    }

    public ResourceLoader(Resources resources, ModelLoader<Uri, Data> modelLoader) {
        this.f10361b = resources;
        this.f10360a = modelLoader;
    }

    private Uri d(Integer num) {
        try {
            return Uri.parse("android.resource://" + this.f10361b.getResourcePackageName(num.intValue()) + '/' + this.f10361b.getResourceTypeName(num.intValue()) + '/' + this.f10361b.getResourceEntryName(num.intValue()));
        } catch (Resources.NotFoundException e8) {
            if (Log.isLoggable("ResourceLoader", 5)) {
                Log.w("ResourceLoader", "Received invalid resource id: " + num, e8);
                return null;
            }
            return null;
        }
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    /* renamed from: c */
    public ModelLoader.LoadData<Data> b(@NonNull Integer num, int i8, int i9, @NonNull Options options) {
        Uri d8 = d(num);
        if (d8 == null) {
            return null;
        }
        return this.f10360a.b(d8, i8, i9, options);
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    /* renamed from: e */
    public boolean a(@NonNull Integer num) {
        return true;
    }
}
