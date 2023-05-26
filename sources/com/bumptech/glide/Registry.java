package com.bumptech.glide;

import androidx.annotation.NonNull;
import androidx.core.util.Pools$Pool;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.data.DataRewinderRegistry;
import com.bumptech.glide.load.engine.DecodePath;
import com.bumptech.glide.load.engine.LoadPath;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.ModelLoaderRegistry;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.load.resource.transcode.TranscoderRegistry;
import com.bumptech.glide.provider.EncoderRegistry;
import com.bumptech.glide.provider.ImageHeaderParserRegistry;
import com.bumptech.glide.provider.LoadPathCache;
import com.bumptech.glide.provider.ModelToResourceClassCache;
import com.bumptech.glide.provider.ResourceDecoderRegistry;
import com.bumptech.glide.provider.ResourceEncoderRegistry;
import com.bumptech.glide.util.pool.FactoryPools;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class Registry {

    /* renamed from: a  reason: collision with root package name */
    private final ModelLoaderRegistry f9780a;

    /* renamed from: b  reason: collision with root package name */
    private final EncoderRegistry f9781b;

    /* renamed from: c  reason: collision with root package name */
    private final ResourceDecoderRegistry f9782c;

    /* renamed from: d  reason: collision with root package name */
    private final ResourceEncoderRegistry f9783d;

    /* renamed from: e  reason: collision with root package name */
    private final DataRewinderRegistry f9784e;

    /* renamed from: f  reason: collision with root package name */
    private final TranscoderRegistry f9785f;

    /* renamed from: g  reason: collision with root package name */
    private final ImageHeaderParserRegistry f9786g;

    /* renamed from: h  reason: collision with root package name */
    private final ModelToResourceClassCache f9787h = new ModelToResourceClassCache();

    /* renamed from: i  reason: collision with root package name */
    private final LoadPathCache f9788i = new LoadPathCache();

    /* renamed from: j  reason: collision with root package name */
    private final Pools$Pool<List<Throwable>> f9789j;

    /* loaded from: classes.dex */
    public static class MissingComponentException extends RuntimeException {
        public MissingComponentException(@NonNull String str) {
            super(str);
        }
    }

    /* loaded from: classes.dex */
    public static final class NoImageHeaderParserException extends MissingComponentException {
        public NoImageHeaderParserException() {
            super("Failed to find image header parser.");
        }
    }

    /* loaded from: classes.dex */
    public static class NoModelLoaderAvailableException extends MissingComponentException {
        public NoModelLoaderAvailableException(@NonNull Object obj) {
            super("Failed to find any ModelLoaders registered for model class: " + obj.getClass());
        }

        public <M> NoModelLoaderAvailableException(@NonNull M m8, @NonNull List<ModelLoader<M, ?>> list) {
            super("Found ModelLoaders for model class: " + list + ", but none that handle this specific model instance: " + m8);
        }

        public NoModelLoaderAvailableException(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            super("Failed to find any ModelLoaders for model: " + cls + " and data: " + cls2);
        }
    }

    /* loaded from: classes.dex */
    public static class NoResultEncoderAvailableException extends MissingComponentException {
        public NoResultEncoderAvailableException(@NonNull Class<?> cls) {
            super("Failed to find result encoder for resource class: " + cls + ", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.");
        }
    }

    /* loaded from: classes.dex */
    public static class NoSourceEncoderAvailableException extends MissingComponentException {
        public NoSourceEncoderAvailableException(@NonNull Class<?> cls) {
            super("Failed to find source encoder for data class: " + cls);
        }
    }

    public Registry() {
        Pools$Pool<List<Throwable>> e8 = FactoryPools.e();
        this.f9789j = e8;
        this.f9780a = new ModelLoaderRegistry(e8);
        this.f9781b = new EncoderRegistry();
        this.f9782c = new ResourceDecoderRegistry();
        this.f9783d = new ResourceEncoderRegistry();
        this.f9784e = new DataRewinderRegistry();
        this.f9785f = new TranscoderRegistry();
        this.f9786g = new ImageHeaderParserRegistry();
        r(Arrays.asList("Gif", "Bitmap", "BitmapDrawable"));
    }

    @NonNull
    private <Data, TResource, Transcode> List<DecodePath<Data, TResource, Transcode>> f(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull Class<Transcode> cls3) {
        ArrayList arrayList = new ArrayList();
        for (Class cls4 : this.f9782c.d(cls, cls2)) {
            for (Class cls5 : this.f9785f.b(cls4, cls3)) {
                arrayList.add(new DecodePath(cls, cls4, cls5, this.f9782c.b(cls, cls4), this.f9785f.a(cls4, cls5), this.f9789j));
            }
        }
        return arrayList;
    }

    @NonNull
    public <Data> Registry a(@NonNull Class<Data> cls, @NonNull Encoder<Data> encoder) {
        this.f9781b.a(cls, encoder);
        return this;
    }

    @NonNull
    public <TResource> Registry b(@NonNull Class<TResource> cls, @NonNull ResourceEncoder<TResource> resourceEncoder) {
        this.f9783d.a(cls, resourceEncoder);
        return this;
    }

    @NonNull
    public <Data, TResource> Registry c(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull ResourceDecoder<Data, TResource> resourceDecoder) {
        e("legacy_append", cls, cls2, resourceDecoder);
        return this;
    }

    @NonNull
    public <Model, Data> Registry d(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull ModelLoaderFactory<Model, Data> modelLoaderFactory) {
        this.f9780a.a(cls, cls2, modelLoaderFactory);
        return this;
    }

    @NonNull
    public <Data, TResource> Registry e(@NonNull String str, @NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull ResourceDecoder<Data, TResource> resourceDecoder) {
        this.f9782c.a(str, resourceDecoder, cls, cls2);
        return this;
    }

    @NonNull
    public List<ImageHeaderParser> g() {
        List<ImageHeaderParser> b8 = this.f9786g.b();
        if (!b8.isEmpty()) {
            return b8;
        }
        throw new NoImageHeaderParserException();
    }

    public <Data, TResource, Transcode> LoadPath<Data, TResource, Transcode> h(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull Class<Transcode> cls3) {
        LoadPath<Data, TResource, Transcode> a8 = this.f9788i.a(cls, cls2, cls3);
        if (this.f9788i.c(a8)) {
            return null;
        }
        if (a8 == null) {
            List<DecodePath<Data, TResource, Transcode>> f8 = f(cls, cls2, cls3);
            if (f8.isEmpty()) {
                a8 = null;
            } else {
                a8 = new LoadPath<>(cls, cls2, cls3, f8, this.f9789j);
            }
            this.f9788i.d(cls, cls2, cls3, a8);
        }
        return a8;
    }

    @NonNull
    public <Model> List<ModelLoader<Model, ?>> i(@NonNull Model model) {
        return this.f9780a.d(model);
    }

    @NonNull
    public <Model, TResource, Transcode> List<Class<?>> j(@NonNull Class<Model> cls, @NonNull Class<TResource> cls2, @NonNull Class<Transcode> cls3) {
        List<Class<?>> a8 = this.f9787h.a(cls, cls2, cls3);
        if (a8 == null) {
            a8 = new ArrayList<>();
            for (Class<?> cls4 : this.f9780a.c(cls)) {
                for (Class<?> cls5 : this.f9782c.d(cls4, cls2)) {
                    if (!this.f9785f.b(cls5, cls3).isEmpty() && !a8.contains(cls5)) {
                        a8.add(cls5);
                    }
                }
            }
            this.f9787h.b(cls, cls2, cls3, Collections.unmodifiableList(a8));
        }
        return a8;
    }

    @NonNull
    public <X> ResourceEncoder<X> k(@NonNull Resource<X> resource) throws NoResultEncoderAvailableException {
        ResourceEncoder<X> b8 = this.f9783d.b(resource.d());
        if (b8 != null) {
            return b8;
        }
        throw new NoResultEncoderAvailableException(resource.d());
    }

    @NonNull
    public <X> DataRewinder<X> l(@NonNull X x7) {
        return this.f9784e.a(x7);
    }

    @NonNull
    public <X> Encoder<X> m(@NonNull X x7) throws NoSourceEncoderAvailableException {
        Encoder<X> b8 = this.f9781b.b(x7.getClass());
        if (b8 != null) {
            return b8;
        }
        throw new NoSourceEncoderAvailableException(x7.getClass());
    }

    public boolean n(@NonNull Resource<?> resource) {
        if (this.f9783d.b(resource.d()) != null) {
            return true;
        }
        return false;
    }

    @NonNull
    public Registry o(@NonNull ImageHeaderParser imageHeaderParser) {
        this.f9786g.a(imageHeaderParser);
        return this;
    }

    @NonNull
    public Registry p(@NonNull DataRewinder.Factory<?> factory) {
        this.f9784e.b(factory);
        return this;
    }

    @NonNull
    public <TResource, Transcode> Registry q(@NonNull Class<TResource> cls, @NonNull Class<Transcode> cls2, @NonNull ResourceTranscoder<TResource, Transcode> resourceTranscoder) {
        this.f9785f.c(cls, cls2, resourceTranscoder);
        return this;
    }

    @NonNull
    public final Registry r(@NonNull List<String> list) {
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.add("legacy_prepend_all");
        for (String str : list) {
            arrayList.add(str);
        }
        arrayList.add("legacy_append");
        this.f9782c.e(arrayList);
        return this;
    }
}
