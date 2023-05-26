package com.bumptech.glide;

import android.content.Context;
import android.content.ContextWrapper;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.ImageViewTargetFactory;
import com.bumptech.glide.request.target.ViewTarget;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class GlideContext extends ContextWrapper {

    /* renamed from: k  reason: collision with root package name */
    static final TransitionOptions<?, ?> f9757k = new GenericTransitionOptions();

    /* renamed from: a  reason: collision with root package name */
    private final ArrayPool f9758a;

    /* renamed from: b  reason: collision with root package name */
    private final Registry f9759b;

    /* renamed from: c  reason: collision with root package name */
    private final ImageViewTargetFactory f9760c;

    /* renamed from: d  reason: collision with root package name */
    private final Glide.RequestOptionsFactory f9761d;

    /* renamed from: e  reason: collision with root package name */
    private final List<RequestListener<Object>> f9762e;

    /* renamed from: f  reason: collision with root package name */
    private final Map<Class<?>, TransitionOptions<?, ?>> f9763f;

    /* renamed from: g  reason: collision with root package name */
    private final Engine f9764g;

    /* renamed from: h  reason: collision with root package name */
    private final GlideExperiments f9765h;

    /* renamed from: i  reason: collision with root package name */
    private final int f9766i;

    /* renamed from: j  reason: collision with root package name */
    private RequestOptions f9767j;

    public GlideContext(@NonNull Context context, @NonNull ArrayPool arrayPool, @NonNull Registry registry, @NonNull ImageViewTargetFactory imageViewTargetFactory, @NonNull Glide.RequestOptionsFactory requestOptionsFactory, @NonNull Map<Class<?>, TransitionOptions<?, ?>> map, @NonNull List<RequestListener<Object>> list, @NonNull Engine engine, @NonNull GlideExperiments glideExperiments, int i8) {
        super(context.getApplicationContext());
        this.f9758a = arrayPool;
        this.f9759b = registry;
        this.f9760c = imageViewTargetFactory;
        this.f9761d = requestOptionsFactory;
        this.f9762e = list;
        this.f9763f = map;
        this.f9764g = engine;
        this.f9765h = glideExperiments;
        this.f9766i = i8;
    }

    @NonNull
    public <X> ViewTarget<ImageView, X> a(@NonNull ImageView imageView, @NonNull Class<X> cls) {
        return this.f9760c.a(imageView, cls);
    }

    @NonNull
    public ArrayPool b() {
        return this.f9758a;
    }

    public List<RequestListener<Object>> c() {
        return this.f9762e;
    }

    public synchronized RequestOptions d() {
        if (this.f9767j == null) {
            this.f9767j = this.f9761d.build().S();
        }
        return this.f9767j;
    }

    @NonNull
    public <T> TransitionOptions<?, T> e(@NonNull Class<T> cls) {
        TransitionOptions<?, T> transitionOptions = (TransitionOptions<?, T>) this.f9763f.get(cls);
        if (transitionOptions == null) {
            for (Map.Entry<Class<?>, TransitionOptions<?, ?>> entry : this.f9763f.entrySet()) {
                if (entry.getKey().isAssignableFrom(cls)) {
                    transitionOptions = (TransitionOptions<?, T>) entry.getValue();
                }
            }
        }
        return transitionOptions == null ? (TransitionOptions<?, T>) f9757k : transitionOptions;
    }

    @NonNull
    public Engine f() {
        return this.f9764g;
    }

    public GlideExperiments g() {
        return this.f9765h;
    }

    public int h() {
        return this.f9766i;
    }

    @NonNull
    public Registry i() {
        return this.f9759b;
    }
}
