package com.bumptech.glide.load.engine;

import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.resource.UnitTransformation;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class DecodeHelper<Transcode> {

    /* renamed from: a  reason: collision with root package name */
    private final List<ModelLoader.LoadData<?>> f10003a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private final List<Key> f10004b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private GlideContext f10005c;

    /* renamed from: d  reason: collision with root package name */
    private Object f10006d;

    /* renamed from: e  reason: collision with root package name */
    private int f10007e;

    /* renamed from: f  reason: collision with root package name */
    private int f10008f;

    /* renamed from: g  reason: collision with root package name */
    private Class<?> f10009g;

    /* renamed from: h  reason: collision with root package name */
    private DecodeJob.DiskCacheProvider f10010h;

    /* renamed from: i  reason: collision with root package name */
    private Options f10011i;

    /* renamed from: j  reason: collision with root package name */
    private Map<Class<?>, Transformation<?>> f10012j;

    /* renamed from: k  reason: collision with root package name */
    private Class<Transcode> f10013k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f10014l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f10015m;

    /* renamed from: n  reason: collision with root package name */
    private Key f10016n;

    /* renamed from: o  reason: collision with root package name */
    private Priority f10017o;

    /* renamed from: p  reason: collision with root package name */
    private DiskCacheStrategy f10018p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f10019q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f10020r;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f10005c = null;
        this.f10006d = null;
        this.f10016n = null;
        this.f10009g = null;
        this.f10013k = null;
        this.f10011i = null;
        this.f10017o = null;
        this.f10012j = null;
        this.f10018p = null;
        this.f10003a.clear();
        this.f10014l = false;
        this.f10004b.clear();
        this.f10015m = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayPool b() {
        return this.f10005c.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Key> c() {
        if (!this.f10015m) {
            this.f10015m = true;
            this.f10004b.clear();
            List<ModelLoader.LoadData<?>> g8 = g();
            int size = g8.size();
            for (int i8 = 0; i8 < size; i8++) {
                ModelLoader.LoadData<?> loadData = g8.get(i8);
                if (!this.f10004b.contains(loadData.f10335a)) {
                    this.f10004b.add(loadData.f10335a);
                }
                for (int i9 = 0; i9 < loadData.f10336b.size(); i9++) {
                    if (!this.f10004b.contains(loadData.f10336b.get(i9))) {
                        this.f10004b.add(loadData.f10336b.get(i9));
                    }
                }
            }
        }
        return this.f10004b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DiskCache d() {
        return this.f10010h.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DiskCacheStrategy e() {
        return this.f10018p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f() {
        return this.f10008f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ModelLoader.LoadData<?>> g() {
        if (!this.f10014l) {
            this.f10014l = true;
            this.f10003a.clear();
            List i8 = this.f10005c.i().i(this.f10006d);
            int size = i8.size();
            for (int i9 = 0; i9 < size; i9++) {
                ModelLoader.LoadData<?> b8 = ((ModelLoader) i8.get(i9)).b(this.f10006d, this.f10007e, this.f10008f, this.f10011i);
                if (b8 != null) {
                    this.f10003a.add(b8);
                }
            }
        }
        return this.f10003a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <Data> LoadPath<Data, ?, Transcode> h(Class<Data> cls) {
        return this.f10005c.i().h(cls, this.f10009g, this.f10013k);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class<?> i() {
        return this.f10006d.getClass();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ModelLoader<File, ?>> j(File file) throws Registry.NoModelLoaderAvailableException {
        return this.f10005c.i().i(file);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Options k() {
        return this.f10011i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Priority l() {
        return this.f10017o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Class<?>> m() {
        return this.f10005c.i().j(this.f10006d.getClass(), this.f10009g, this.f10013k);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <Z> ResourceEncoder<Z> n(Resource<Z> resource) {
        return this.f10005c.i().k(resource);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Key o() {
        return this.f10016n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <X> Encoder<X> p(X x7) throws Registry.NoSourceEncoderAvailableException {
        return this.f10005c.i().m(x7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class<?> q() {
        return (Class<Transcode>) this.f10013k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <Z> Transformation<Z> r(Class<Z> cls) {
        Transformation<Z> transformation = (Transformation<Z>) this.f10012j.get(cls);
        if (transformation == null) {
            Iterator<Map.Entry<Class<?>, Transformation<?>>> it = this.f10012j.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<Class<?>, Transformation<?>> next = it.next();
                if (next.getKey().isAssignableFrom(cls)) {
                    transformation = (Transformation<Z>) next.getValue();
                    break;
                }
            }
        }
        if (transformation == null) {
            if (this.f10012j.isEmpty() && this.f10019q) {
                throw new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
            }
            return UnitTransformation.c();
        }
        return transformation;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int s() {
        return this.f10007e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean t(Class<?> cls) {
        if (h(cls) != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public <R> void u(GlideContext glideContext, Object obj, Key key, int i8, int i9, DiskCacheStrategy diskCacheStrategy, Class<?> cls, Class<R> cls2, Priority priority, Options options, Map<Class<?>, Transformation<?>> map, boolean z7, boolean z8, DecodeJob.DiskCacheProvider diskCacheProvider) {
        this.f10005c = glideContext;
        this.f10006d = obj;
        this.f10016n = key;
        this.f10007e = i8;
        this.f10008f = i9;
        this.f10018p = diskCacheStrategy;
        this.f10009g = cls;
        this.f10010h = diskCacheProvider;
        this.f10013k = cls2;
        this.f10017o = priority;
        this.f10011i = options;
        this.f10012j = map;
        this.f10019q = z7;
        this.f10020r = z8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean v(Resource<?> resource) {
        return this.f10005c.i().n(resource);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean w() {
        return this.f10020r;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean x(Key key) {
        List<ModelLoader.LoadData<?>> g8 = g();
        int size = g8.size();
        for (int i8 = 0; i8 < size; i8++) {
            if (g8.get(i8).f10335a.equals(key)) {
                return true;
            }
        }
        return false;
    }
}
