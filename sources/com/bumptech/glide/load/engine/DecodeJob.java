package com.bumptech.glide.load.engine;

import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools$Pool;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.engine.DataFetcherGenerator;
import com.bumptech.glide.load.engine.DecodePath;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.GlideTrace;
import com.bumptech.glide.util.pool.StateVerifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
class DecodeJob<R> implements DataFetcherGenerator.FetcherReadyCallback, Runnable, Comparable<DecodeJob<?>>, FactoryPools.Poolable {
    private Object A;
    private Thread B;
    private Key C;
    private Key D;
    private Object E;
    private DataSource F;
    private DataFetcher<?> G;
    private volatile DataFetcherGenerator H;
    private volatile boolean I;
    private volatile boolean J;
    private boolean K;

    /* renamed from: i  reason: collision with root package name */
    private final DiskCacheProvider f10024i;

    /* renamed from: j  reason: collision with root package name */
    private final Pools$Pool<DecodeJob<?>> f10025j;

    /* renamed from: m  reason: collision with root package name */
    private GlideContext f10028m;

    /* renamed from: n  reason: collision with root package name */
    private Key f10029n;

    /* renamed from: o  reason: collision with root package name */
    private Priority f10030o;

    /* renamed from: p  reason: collision with root package name */
    private EngineKey f10031p;

    /* renamed from: q  reason: collision with root package name */
    private int f10032q;

    /* renamed from: r  reason: collision with root package name */
    private int f10033r;

    /* renamed from: s  reason: collision with root package name */
    private DiskCacheStrategy f10034s;

    /* renamed from: t  reason: collision with root package name */
    private Options f10035t;

    /* renamed from: u  reason: collision with root package name */
    private Callback<R> f10036u;

    /* renamed from: v  reason: collision with root package name */
    private int f10037v;

    /* renamed from: w  reason: collision with root package name */
    private Stage f10038w;

    /* renamed from: x  reason: collision with root package name */
    private RunReason f10039x;

    /* renamed from: y  reason: collision with root package name */
    private long f10040y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f10041z;

    /* renamed from: f  reason: collision with root package name */
    private final DecodeHelper<R> f10021f = new DecodeHelper<>();

    /* renamed from: g  reason: collision with root package name */
    private final List<Throwable> f10022g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    private final StateVerifier f10023h = StateVerifier.a();

    /* renamed from: k  reason: collision with root package name */
    private final DeferredEncodeManager<?> f10026k = new DeferredEncodeManager<>();

    /* renamed from: l  reason: collision with root package name */
    private final ReleaseManager f10027l = new ReleaseManager();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bumptech.glide.load.engine.DecodeJob$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f10042a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f10043b;

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ int[] f10044c;

        static {
            int[] iArr = new int[EncodeStrategy.values().length];
            f10044c = iArr;
            try {
                iArr[EncodeStrategy.SOURCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10044c[EncodeStrategy.TRANSFORMED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[Stage.values().length];
            f10043b = iArr2;
            try {
                iArr2[Stage.RESOURCE_CACHE.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10043b[Stage.DATA_CACHE.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f10043b[Stage.SOURCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f10043b[Stage.FINISHED.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f10043b[Stage.INITIALIZE.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr3 = new int[RunReason.values().length];
            f10042a = iArr3;
            try {
                iArr3[RunReason.INITIALIZE.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f10042a[RunReason.SWITCH_TO_SOURCE_SERVICE.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f10042a[RunReason.DECODE_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface Callback<R> {
        void c(Resource<R> resource, DataSource dataSource, boolean z7);

        void d(GlideException glideException);

        void f(DecodeJob<?> decodeJob);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class DecodeCallback<Z> implements DecodePath.DecodeCallback<Z> {

        /* renamed from: a  reason: collision with root package name */
        private final DataSource f10045a;

        DecodeCallback(DataSource dataSource) {
            this.f10045a = dataSource;
        }

        @Override // com.bumptech.glide.load.engine.DecodePath.DecodeCallback
        @NonNull
        public Resource<Z> a(@NonNull Resource<Z> resource) {
            return DecodeJob.this.B(this.f10045a, resource);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class DeferredEncodeManager<Z> {

        /* renamed from: a  reason: collision with root package name */
        private Key f10047a;

        /* renamed from: b  reason: collision with root package name */
        private ResourceEncoder<Z> f10048b;

        /* renamed from: c  reason: collision with root package name */
        private LockedResource<Z> f10049c;

        DeferredEncodeManager() {
        }

        void a() {
            this.f10047a = null;
            this.f10048b = null;
            this.f10049c = null;
        }

        void b(DiskCacheProvider diskCacheProvider, Options options) {
            GlideTrace.a("DecodeJob.encode");
            try {
                diskCacheProvider.a().a(this.f10047a, new DataCacheWriter(this.f10048b, this.f10049c, options));
            } finally {
                this.f10049c.h();
                GlideTrace.d();
            }
        }

        boolean c() {
            if (this.f10049c != null) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        <X> void d(Key key, ResourceEncoder<X> resourceEncoder, LockedResource<X> lockedResource) {
            this.f10047a = key;
            this.f10048b = resourceEncoder;
            this.f10049c = lockedResource;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface DiskCacheProvider {
        DiskCache a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class ReleaseManager {

        /* renamed from: a  reason: collision with root package name */
        private boolean f10050a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f10051b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f10052c;

        ReleaseManager() {
        }

        private boolean a(boolean z7) {
            if ((this.f10052c || z7 || this.f10051b) && this.f10050a) {
                return true;
            }
            return false;
        }

        synchronized boolean b() {
            this.f10051b = true;
            return a(false);
        }

        synchronized boolean c() {
            this.f10052c = true;
            return a(false);
        }

        synchronized boolean d(boolean z7) {
            this.f10050a = true;
            return a(z7);
        }

        synchronized void e() {
            this.f10051b = false;
            this.f10050a = false;
            this.f10052c = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum RunReason {
        INITIALIZE,
        SWITCH_TO_SOURCE_SERVICE,
        DECODE_DATA
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum Stage {
        INITIALIZE,
        RESOURCE_CACHE,
        DATA_CACHE,
        SOURCE,
        ENCODE,
        FINISHED
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DecodeJob(DiskCacheProvider diskCacheProvider, Pools$Pool<DecodeJob<?>> pools$Pool) {
        this.f10024i = diskCacheProvider;
        this.f10025j = pools$Pool;
    }

    private void A() {
        if (this.f10027l.c()) {
            D();
        }
    }

    private void D() {
        this.f10027l.e();
        this.f10026k.a();
        this.f10021f.a();
        this.I = false;
        this.f10028m = null;
        this.f10029n = null;
        this.f10035t = null;
        this.f10030o = null;
        this.f10031p = null;
        this.f10036u = null;
        this.f10038w = null;
        this.H = null;
        this.B = null;
        this.C = null;
        this.E = null;
        this.F = null;
        this.G = null;
        this.f10040y = 0L;
        this.J = false;
        this.A = null;
        this.f10022g.clear();
        this.f10025j.a(this);
    }

    private void E() {
        this.B = Thread.currentThread();
        this.f10040y = LogTime.b();
        boolean z7 = false;
        while (!this.J && this.H != null && !(z7 = this.H.b())) {
            this.f10038w = q(this.f10038w);
            this.H = p();
            if (this.f10038w == Stage.SOURCE) {
                c();
                return;
            }
        }
        if ((this.f10038w == Stage.FINISHED || this.J) && !z7) {
            y();
        }
    }

    private <Data, ResourceType> Resource<R> F(Data data, DataSource dataSource, LoadPath<Data, ResourceType, R> loadPath) throws GlideException {
        Options r7 = r(dataSource);
        DataRewinder<Data> l8 = this.f10028m.i().l(data);
        try {
            return loadPath.a(l8, r7, this.f10032q, this.f10033r, new DecodeCallback(dataSource));
        } finally {
            l8.b();
        }
    }

    private void G() {
        int i8 = AnonymousClass1.f10042a[this.f10039x.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 == 3) {
                    m();
                    return;
                }
                throw new IllegalStateException("Unrecognized run reason: " + this.f10039x);
            }
            E();
            return;
        }
        this.f10038w = q(Stage.INITIALIZE);
        this.H = p();
        E();
    }

    private void H() {
        Throwable th;
        this.f10023h.c();
        if (this.I) {
            if (this.f10022g.isEmpty()) {
                th = null;
            } else {
                List<Throwable> list = this.f10022g;
                th = list.get(list.size() - 1);
            }
            throw new IllegalStateException("Already notified", th);
        }
        this.I = true;
    }

    private <Data> Resource<R> k(DataFetcher<?> dataFetcher, Data data, DataSource dataSource) throws GlideException {
        if (data == null) {
            return null;
        }
        try {
            long b8 = LogTime.b();
            Resource<R> l8 = l(data, dataSource);
            if (Log.isLoggable("DecodeJob", 2)) {
                u("Decoded result " + l8, b8);
            }
            return l8;
        } finally {
            dataFetcher.b();
        }
    }

    private <Data> Resource<R> l(Data data, DataSource dataSource) throws GlideException {
        return F(data, dataSource, (LoadPath<Data, ?, R>) this.f10021f.h(data.getClass()));
    }

    private void m() {
        if (Log.isLoggable("DecodeJob", 2)) {
            long j8 = this.f10040y;
            v("Retrieved data", j8, "data: " + this.E + ", cache key: " + this.C + ", fetcher: " + this.G);
        }
        Resource<R> resource = null;
        try {
            resource = k(this.G, this.E, this.F);
        } catch (GlideException e8) {
            e8.i(this.D, this.F);
            this.f10022g.add(e8);
        }
        if (resource != null) {
            x(resource, this.F, this.K);
        } else {
            E();
        }
    }

    private DataFetcherGenerator p() {
        int i8 = AnonymousClass1.f10043b[this.f10038w.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 != 3) {
                    if (i8 == 4) {
                        return null;
                    }
                    throw new IllegalStateException("Unrecognized stage: " + this.f10038w);
                }
                return new SourceGenerator(this.f10021f, this);
            }
            return new DataCacheGenerator(this.f10021f, this);
        }
        return new ResourceCacheGenerator(this.f10021f, this);
    }

    private Stage q(Stage stage) {
        int i8 = AnonymousClass1.f10043b[stage.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 != 3 && i8 != 4) {
                    if (i8 == 5) {
                        if (this.f10034s.b()) {
                            return Stage.RESOURCE_CACHE;
                        }
                        return q(Stage.RESOURCE_CACHE);
                    }
                    throw new IllegalArgumentException("Unrecognized stage: " + stage);
                }
                return Stage.FINISHED;
            } else if (this.f10041z) {
                return Stage.FINISHED;
            } else {
                return Stage.SOURCE;
            }
        } else if (this.f10034s.a()) {
            return Stage.DATA_CACHE;
        } else {
            return q(Stage.DATA_CACHE);
        }
    }

    @NonNull
    private Options r(DataSource dataSource) {
        boolean z7;
        Options options = this.f10035t;
        if (Build.VERSION.SDK_INT < 26) {
            return options;
        }
        if (dataSource != DataSource.RESOURCE_DISK_CACHE && !this.f10021f.w()) {
            z7 = false;
        } else {
            z7 = true;
        }
        Option<Boolean> option = Downsampler.f10450j;
        Boolean bool = (Boolean) options.c(option);
        if (bool != null && (!bool.booleanValue() || z7)) {
            return options;
        }
        Options options2 = new Options();
        options2.d(this.f10035t);
        options2.e(option, Boolean.valueOf(z7));
        return options2;
    }

    private int s() {
        return this.f10030o.ordinal();
    }

    private void u(String str, long j8) {
        v(str, j8, null);
    }

    private void v(String str, long j8, String str2) {
        String str3;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" in ");
        sb.append(LogTime.a(j8));
        sb.append(", load key: ");
        sb.append(this.f10031p);
        if (str2 != null) {
            str3 = ", " + str2;
        } else {
            str3 = "";
        }
        sb.append(str3);
        sb.append(", thread: ");
        sb.append(Thread.currentThread().getName());
        Log.v("DecodeJob", sb.toString());
    }

    private void w(Resource<R> resource, DataSource dataSource, boolean z7) {
        H();
        this.f10036u.c(resource, dataSource, z7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void x(Resource<R> resource, DataSource dataSource, boolean z7) {
        if (resource instanceof Initializable) {
            ((Initializable) resource).a();
        }
        LockedResource lockedResource = 0;
        if (this.f10026k.c()) {
            resource = LockedResource.f(resource);
            lockedResource = resource;
        }
        w(resource, dataSource, z7);
        this.f10038w = Stage.ENCODE;
        try {
            if (this.f10026k.c()) {
                this.f10026k.b(this.f10024i, this.f10035t);
            }
            z();
        } finally {
            if (lockedResource != 0) {
                lockedResource.h();
            }
        }
    }

    private void y() {
        H();
        this.f10036u.d(new GlideException("Failed to load resource", new ArrayList(this.f10022g)));
        A();
    }

    private void z() {
        if (this.f10027l.b()) {
            D();
        }
    }

    @NonNull
    <Z> Resource<Z> B(DataSource dataSource, @NonNull Resource<Z> resource) {
        Resource<Z> resource2;
        Transformation<Z> transformation;
        EncodeStrategy encodeStrategy;
        Key dataCacheKey;
        Class<?> cls = resource.get().getClass();
        ResourceEncoder<Z> resourceEncoder = null;
        if (dataSource != DataSource.RESOURCE_DISK_CACHE) {
            Transformation<Z> r7 = this.f10021f.r(cls);
            transformation = r7;
            resource2 = r7.a(this.f10028m, resource, this.f10032q, this.f10033r);
        } else {
            resource2 = resource;
            transformation = null;
        }
        if (!resource.equals(resource2)) {
            resource.c();
        }
        if (this.f10021f.v(resource2)) {
            resourceEncoder = this.f10021f.n(resource2);
            encodeStrategy = resourceEncoder.b(this.f10035t);
        } else {
            encodeStrategy = EncodeStrategy.NONE;
        }
        ResourceEncoder resourceEncoder2 = resourceEncoder;
        if (this.f10034s.d(!this.f10021f.x(this.C), dataSource, encodeStrategy)) {
            if (resourceEncoder2 != null) {
                int i8 = AnonymousClass1.f10044c[encodeStrategy.ordinal()];
                if (i8 != 1) {
                    if (i8 == 2) {
                        dataCacheKey = new ResourceCacheKey(this.f10021f.b(), this.C, this.f10029n, this.f10032q, this.f10033r, transformation, cls, this.f10035t);
                    } else {
                        throw new IllegalArgumentException("Unknown strategy: " + encodeStrategy);
                    }
                } else {
                    dataCacheKey = new DataCacheKey(this.C, this.f10029n);
                }
                LockedResource f8 = LockedResource.f(resource2);
                this.f10026k.d(dataCacheKey, resourceEncoder2, f8);
                return f8;
            }
            throw new Registry.NoResultEncoderAvailableException(resource2.get().getClass());
        }
        return resource2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void C(boolean z7) {
        if (this.f10027l.d(z7)) {
            D();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean I() {
        Stage q8 = q(Stage.INITIALIZE);
        if (q8 != Stage.RESOURCE_CACHE && q8 != Stage.DATA_CACHE) {
            return false;
        }
        return true;
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback
    public void a(Key key, Exception exc, DataFetcher<?> dataFetcher, DataSource dataSource) {
        dataFetcher.b();
        GlideException glideException = new GlideException("Fetching data failed", exc);
        glideException.j(key, dataSource, dataFetcher.a());
        this.f10022g.add(glideException);
        if (Thread.currentThread() != this.B) {
            this.f10039x = RunReason.SWITCH_TO_SOURCE_SERVICE;
            this.f10036u.f(this);
            return;
        }
        E();
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback
    public void c() {
        this.f10039x = RunReason.SWITCH_TO_SOURCE_SERVICE;
        this.f10036u.f(this);
    }

    @Override // com.bumptech.glide.util.pool.FactoryPools.Poolable
    @NonNull
    public StateVerifier e() {
        return this.f10023h;
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback
    public void f(Key key, Object obj, DataFetcher<?> dataFetcher, DataSource dataSource, Key key2) {
        this.C = key;
        this.E = obj;
        this.G = dataFetcher;
        this.F = dataSource;
        this.D = key2;
        boolean z7 = false;
        if (key != this.f10021f.c().get(0)) {
            z7 = true;
        }
        this.K = z7;
        if (Thread.currentThread() != this.B) {
            this.f10039x = RunReason.DECODE_DATA;
            this.f10036u.f(this);
            return;
        }
        GlideTrace.a("DecodeJob.decodeFromRetrievedData");
        try {
            m();
        } finally {
            GlideTrace.d();
        }
    }

    public void h() {
        this.J = true;
        DataFetcherGenerator dataFetcherGenerator = this.H;
        if (dataFetcherGenerator != null) {
            dataFetcherGenerator.cancel();
        }
    }

    @Override // java.lang.Comparable
    /* renamed from: j */
    public int compareTo(@NonNull DecodeJob<?> decodeJob) {
        int s7 = s() - decodeJob.s();
        if (s7 == 0) {
            return this.f10037v - decodeJob.f10037v;
        }
        return s7;
    }

    @Override // java.lang.Runnable
    public void run() {
        GlideTrace.b("DecodeJob#run(model=%s)", this.A);
        DataFetcher<?> dataFetcher = this.G;
        try {
            try {
                if (this.J) {
                    y();
                    if (dataFetcher != null) {
                        dataFetcher.b();
                    }
                    GlideTrace.d();
                    return;
                }
                G();
                if (dataFetcher != null) {
                    dataFetcher.b();
                }
                GlideTrace.d();
            } catch (CallbackException e8) {
                throw e8;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DecodeJob<R> t(GlideContext glideContext, Object obj, EngineKey engineKey, Key key, int i8, int i9, Class<?> cls, Class<R> cls2, Priority priority, DiskCacheStrategy diskCacheStrategy, Map<Class<?>, Transformation<?>> map, boolean z7, boolean z8, boolean z9, Options options, Callback<R> callback, int i10) {
        this.f10021f.u(glideContext, obj, key, i8, i9, diskCacheStrategy, cls, cls2, priority, options, map, z7, z8, this.f10024i);
        this.f10028m = glideContext;
        this.f10029n = key;
        this.f10030o = priority;
        this.f10031p = engineKey;
        this.f10032q = i8;
        this.f10033r = i9;
        this.f10034s = diskCacheStrategy;
        this.f10041z = z9;
        this.f10035t = options;
        this.f10036u = callback;
        this.f10037v = i10;
        this.f10039x = RunReason.INITIALIZE;
        this.A = obj;
        return this;
    }
}
