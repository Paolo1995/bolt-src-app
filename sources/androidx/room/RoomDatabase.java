package androidx.room;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.CancellationSignal;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.arch.core.util.Function;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteCompat$Api19Impl;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory;
import j$.util.DesugarCollections;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes.dex */
public abstract class RoomDatabase {
    @Deprecated

    /* renamed from: a  reason: collision with root package name */
    protected volatile SupportSQLiteDatabase f7537a;

    /* renamed from: b  reason: collision with root package name */
    private Executor f7538b;

    /* renamed from: c  reason: collision with root package name */
    private Executor f7539c;

    /* renamed from: d  reason: collision with root package name */
    private SupportSQLiteOpenHelper f7540d;

    /* renamed from: f  reason: collision with root package name */
    private boolean f7542f;

    /* renamed from: g  reason: collision with root package name */
    boolean f7543g;
    @Deprecated

    /* renamed from: h  reason: collision with root package name */
    protected List<Callback> f7544h;

    /* renamed from: k  reason: collision with root package name */
    private AutoCloser f7547k;

    /* renamed from: j  reason: collision with root package name */
    private final ReentrantReadWriteLock f7546j = new ReentrantReadWriteLock();

    /* renamed from: l  reason: collision with root package name */
    private final ThreadLocal<Integer> f7548l = new ThreadLocal<>();

    /* renamed from: m  reason: collision with root package name */
    private final Map<String, Object> f7549m = DesugarCollections.synchronizedMap(new HashMap());

    /* renamed from: e  reason: collision with root package name */
    private final InvalidationTracker f7541e = g();

    /* renamed from: n  reason: collision with root package name */
    private final Map<Class<?>, Object> f7550n = new HashMap();
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    protected Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> f7545i = new HashMap();

    /* loaded from: classes.dex */
    public static class Builder<T extends RoomDatabase> {

        /* renamed from: a  reason: collision with root package name */
        private final Class<T> f7551a;

        /* renamed from: b  reason: collision with root package name */
        private final String f7552b;

        /* renamed from: c  reason: collision with root package name */
        private final Context f7553c;

        /* renamed from: d  reason: collision with root package name */
        private ArrayList<Callback> f7554d;

        /* renamed from: e  reason: collision with root package name */
        private PrepackagedDatabaseCallback f7555e;

        /* renamed from: f  reason: collision with root package name */
        private QueryCallback f7556f;

        /* renamed from: g  reason: collision with root package name */
        private Executor f7557g;

        /* renamed from: h  reason: collision with root package name */
        private List<Object> f7558h;

        /* renamed from: i  reason: collision with root package name */
        private List<AutoMigrationSpec> f7559i;

        /* renamed from: j  reason: collision with root package name */
        private Executor f7560j;

        /* renamed from: k  reason: collision with root package name */
        private Executor f7561k;

        /* renamed from: l  reason: collision with root package name */
        private SupportSQLiteOpenHelper.Factory f7562l;

        /* renamed from: m  reason: collision with root package name */
        private boolean f7563m;

        /* renamed from: o  reason: collision with root package name */
        private Intent f7565o;

        /* renamed from: q  reason: collision with root package name */
        private boolean f7567q;

        /* renamed from: s  reason: collision with root package name */
        private TimeUnit f7569s;

        /* renamed from: u  reason: collision with root package name */
        private Set<Integer> f7571u;

        /* renamed from: v  reason: collision with root package name */
        private Set<Integer> f7572v;

        /* renamed from: w  reason: collision with root package name */
        private String f7573w;

        /* renamed from: x  reason: collision with root package name */
        private File f7574x;

        /* renamed from: y  reason: collision with root package name */
        private Callable<InputStream> f7575y;

        /* renamed from: r  reason: collision with root package name */
        private long f7568r = -1;

        /* renamed from: n  reason: collision with root package name */
        private JournalMode f7564n = JournalMode.AUTOMATIC;

        /* renamed from: p  reason: collision with root package name */
        private boolean f7566p = true;

        /* renamed from: t  reason: collision with root package name */
        private final MigrationContainer f7570t = new MigrationContainer();

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder(@NonNull Context context, @NonNull Class<T> cls, String str) {
            this.f7553c = context;
            this.f7551a = cls;
            this.f7552b = str;
        }

        @NonNull
        public Builder<T> a(@NonNull Callback callback) {
            if (this.f7554d == null) {
                this.f7554d = new ArrayList<>();
            }
            this.f7554d.add(callback);
            return this;
        }

        @NonNull
        public Builder<T> b(@NonNull Migration... migrationArr) {
            if (this.f7572v == null) {
                this.f7572v = new HashSet();
            }
            for (Migration migration : migrationArr) {
                this.f7572v.add(Integer.valueOf(migration.f7646a));
                this.f7572v.add(Integer.valueOf(migration.f7647b));
            }
            this.f7570t.b(migrationArr);
            return this;
        }

        @NonNull
        public Builder<T> c() {
            this.f7563m = true;
            return this;
        }

        @NonNull
        @SuppressLint({"RestrictedApi"})
        public T d() {
            Executor executor;
            int i8;
            int i9;
            QueryInterceptorOpenHelperFactory queryInterceptorOpenHelperFactory;
            if (this.f7553c != null) {
                if (this.f7551a != null) {
                    Executor executor2 = this.f7560j;
                    if (executor2 == null && this.f7561k == null) {
                        Executor d8 = ArchTaskExecutor.d();
                        this.f7561k = d8;
                        this.f7560j = d8;
                    } else if (executor2 != null && this.f7561k == null) {
                        this.f7561k = executor2;
                    } else if (executor2 == null && (executor = this.f7561k) != null) {
                        this.f7560j = executor;
                    }
                    Set<Integer> set = this.f7572v;
                    if (set != null && this.f7571u != null) {
                        for (Integer num : set) {
                            if (this.f7571u.contains(num)) {
                                throw new IllegalArgumentException("Inconsistency detected. A Migration was supplied to addMigration(Migration... migrations) that has a start or end version equal to a start version supplied to fallbackToDestructiveMigrationFrom(int... startVersions). Start version: " + num);
                            }
                        }
                    }
                    AutoClosingRoomOpenHelperFactory autoClosingRoomOpenHelperFactory = this.f7562l;
                    if (autoClosingRoomOpenHelperFactory == null) {
                        autoClosingRoomOpenHelperFactory = new FrameworkSQLiteOpenHelperFactory();
                    }
                    long j8 = this.f7568r;
                    if (j8 > 0) {
                        if (this.f7552b != null) {
                            autoClosingRoomOpenHelperFactory = new AutoClosingRoomOpenHelperFactory(autoClosingRoomOpenHelperFactory, new AutoCloser(j8, this.f7569s, this.f7561k));
                        } else {
                            throw new IllegalArgumentException("Cannot create auto-closing database for an in-memory database.");
                        }
                    }
                    String str = this.f7573w;
                    if (str != null || this.f7574x != null || this.f7575y != null) {
                        if (this.f7552b != null) {
                            int i10 = 0;
                            if (str == null) {
                                i8 = 0;
                            } else {
                                i8 = 1;
                            }
                            File file = this.f7574x;
                            if (file == null) {
                                i9 = 0;
                            } else {
                                i9 = 1;
                            }
                            int i11 = i8 + i9;
                            Callable<InputStream> callable = this.f7575y;
                            if (callable != null) {
                                i10 = 1;
                            }
                            if (i11 + i10 == 1) {
                                autoClosingRoomOpenHelperFactory = new SQLiteCopyOpenHelperFactory(str, file, callable, autoClosingRoomOpenHelperFactory);
                            } else {
                                throw new IllegalArgumentException("More than one of createFromAsset(), createFromInputStream(), and createFromFile() were called on this Builder, but the database can only be created using one of the three configurations.");
                            }
                        } else {
                            throw new IllegalArgumentException("Cannot create from asset or file for an in-memory database.");
                        }
                    }
                    QueryCallback queryCallback = this.f7556f;
                    if (queryCallback != null) {
                        queryInterceptorOpenHelperFactory = new QueryInterceptorOpenHelperFactory(autoClosingRoomOpenHelperFactory, queryCallback, this.f7557g);
                    } else {
                        queryInterceptorOpenHelperFactory = autoClosingRoomOpenHelperFactory;
                    }
                    Context context = this.f7553c;
                    DatabaseConfiguration databaseConfiguration = new DatabaseConfiguration(context, this.f7552b, queryInterceptorOpenHelperFactory, this.f7570t, this.f7554d, this.f7563m, this.f7564n.c(context), this.f7560j, this.f7561k, this.f7565o, this.f7566p, this.f7567q, this.f7571u, this.f7573w, this.f7574x, this.f7575y, this.f7555e, this.f7558h, this.f7559i);
                    T t7 = (T) Room.b(this.f7551a, "_Impl");
                    t7.t(databaseConfiguration);
                    return t7;
                }
                throw new IllegalArgumentException("Must provide an abstract class that extends RoomDatabase");
            }
            throw new IllegalArgumentException("Cannot provide null context for the database.");
        }

        @NonNull
        public Builder<T> e() {
            this.f7566p = false;
            this.f7567q = true;
            return this;
        }

        @NonNull
        public Builder<T> f(SupportSQLiteOpenHelper.Factory factory) {
            this.f7562l = factory;
            return this;
        }

        @NonNull
        public Builder<T> g(@NonNull Executor executor) {
            this.f7560j = executor;
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Callback {
        public void a(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
        }

        public void b(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
        }

        public void c(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
        }
    }

    /* loaded from: classes.dex */
    public enum JournalMode {
        AUTOMATIC,
        TRUNCATE,
        WRITE_AHEAD_LOGGING;

        private static boolean a(@NonNull ActivityManager activityManager) {
            return SupportSQLiteCompat$Api19Impl.b(activityManager);
        }

        JournalMode c(Context context) {
            if (this != AUTOMATIC) {
                return this;
            }
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager != null && !a(activityManager)) {
                return WRITE_AHEAD_LOGGING;
            }
            return TRUNCATE;
        }
    }

    /* loaded from: classes.dex */
    public static class MigrationContainer {

        /* renamed from: a  reason: collision with root package name */
        private HashMap<Integer, TreeMap<Integer, Migration>> f7580a = new HashMap<>();

        private void a(Migration migration) {
            int i8 = migration.f7646a;
            int i9 = migration.f7647b;
            TreeMap<Integer, Migration> treeMap = this.f7580a.get(Integer.valueOf(i8));
            if (treeMap == null) {
                treeMap = new TreeMap<>();
                this.f7580a.put(Integer.valueOf(i8), treeMap);
            }
            Migration migration2 = treeMap.get(Integer.valueOf(i9));
            if (migration2 != null) {
                Log.w("ROOM", "Overriding migration " + migration2 + " with " + migration);
            }
            treeMap.put(Integer.valueOf(i9), migration);
        }

        /* JADX WARN: Removed duplicated region for block: B:31:0x0016 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0017  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private java.util.List<androidx.room.migration.Migration> d(java.util.List<androidx.room.migration.Migration> r7, boolean r8, int r9, int r10) {
            /*
                r6 = this;
            L0:
                if (r8 == 0) goto L5
                if (r9 >= r10) goto L5a
                goto L7
            L5:
                if (r9 <= r10) goto L5a
            L7:
                java.util.HashMap<java.lang.Integer, java.util.TreeMap<java.lang.Integer, androidx.room.migration.Migration>> r0 = r6.f7580a
                java.lang.Integer r1 = java.lang.Integer.valueOf(r9)
                java.lang.Object r0 = r0.get(r1)
                java.util.TreeMap r0 = (java.util.TreeMap) r0
                r1 = 0
                if (r0 != 0) goto L17
                return r1
            L17:
                if (r8 == 0) goto L1e
                java.util.NavigableSet r2 = r0.descendingKeySet()
                goto L22
            L1e:
                java.util.Set r2 = r0.keySet()
            L22:
                java.util.Iterator r2 = r2.iterator()
            L26:
                boolean r3 = r2.hasNext()
                r4 = 1
                r5 = 0
                if (r3 == 0) goto L56
                java.lang.Object r3 = r2.next()
                java.lang.Integer r3 = (java.lang.Integer) r3
                int r3 = r3.intValue()
                if (r8 == 0) goto L40
                if (r3 > r10) goto L45
                if (r3 <= r9) goto L45
            L3e:
                r5 = 1
                goto L45
            L40:
                if (r3 < r10) goto L45
                if (r3 >= r9) goto L45
                goto L3e
            L45:
                if (r5 == 0) goto L26
                java.lang.Integer r9 = java.lang.Integer.valueOf(r3)
                java.lang.Object r9 = r0.get(r9)
                androidx.room.migration.Migration r9 = (androidx.room.migration.Migration) r9
                r7.add(r9)
                r9 = r3
                goto L57
            L56:
                r4 = 0
            L57:
                if (r4 != 0) goto L0
                return r1
            L5a:
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.RoomDatabase.MigrationContainer.d(java.util.List, boolean, int, int):java.util.List");
        }

        public void b(@NonNull Migration... migrationArr) {
            for (Migration migration : migrationArr) {
                a(migration);
            }
        }

        public List<Migration> c(int i8, int i9) {
            boolean z7;
            if (i8 == i9) {
                return Collections.emptyList();
            }
            if (i9 > i8) {
                z7 = true;
            } else {
                z7 = false;
            }
            return d(new ArrayList(), z7, i8, i9);
        }

        @NonNull
        public Map<Integer, Map<Integer, Migration>> e() {
            return Collections.unmodifiableMap(this.f7580a);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class PrepackagedDatabaseCallback {
        public void a(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
        }
    }

    /* loaded from: classes.dex */
    public interface QueryCallback {
        void a(@NonNull String str, @NonNull List<Object> list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object A(SupportSQLiteDatabase supportSQLiteDatabase) {
        v();
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> T F(Class<T> cls, SupportSQLiteOpenHelper supportSQLiteOpenHelper) {
        if (cls.isInstance(supportSQLiteOpenHelper)) {
            return supportSQLiteOpenHelper;
        }
        if (supportSQLiteOpenHelper instanceof DelegatingOpenHelper) {
            return (T) F(cls, ((DelegatingOpenHelper) supportSQLiteOpenHelper).e());
        }
        return null;
    }

    private void u() {
        c();
        SupportSQLiteDatabase H0 = this.f7540d.H0();
        this.f7541e.p(H0);
        if (H0.d1()) {
            H0.M();
        } else {
            H0.n();
        }
    }

    private void v() {
        this.f7540d.H0().S();
        if (!s()) {
            this.f7541e.h();
        }
    }

    private static boolean x() {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object z(SupportSQLiteDatabase supportSQLiteDatabase) {
        u();
        return null;
    }

    @NonNull
    public Cursor B(@NonNull SupportSQLiteQuery supportSQLiteQuery) {
        return C(supportSQLiteQuery, null);
    }

    @NonNull
    public Cursor C(@NonNull SupportSQLiteQuery supportSQLiteQuery, CancellationSignal cancellationSignal) {
        c();
        d();
        if (cancellationSignal != null) {
            return this.f7540d.H0().C(supportSQLiteQuery, cancellationSignal);
        }
        return this.f7540d.H0().a0(supportSQLiteQuery);
    }

    public void D(@NonNull Runnable runnable) {
        e();
        try {
            runnable.run();
            E();
        } finally {
            i();
        }
    }

    @Deprecated
    public void E() {
        this.f7540d.H0().K();
    }

    public void c() {
        if (this.f7542f || !x()) {
            return;
        }
        throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.");
    }

    public void d() {
        if (!s() && this.f7548l.get() != null) {
            throw new IllegalStateException("Cannot access database on a different coroutine context inherited from a suspending transaction.");
        }
    }

    @Deprecated
    public void e() {
        c();
        AutoCloser autoCloser = this.f7547k;
        if (autoCloser == null) {
            u();
        } else {
            autoCloser.c(new Function() { // from class: androidx.room.x
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    Object z7;
                    z7 = RoomDatabase.this.z((SupportSQLiteDatabase) obj);
                    return z7;
                }
            });
        }
    }

    public SupportSQLiteStatement f(@NonNull String str) {
        c();
        d();
        return this.f7540d.H0().r0(str);
    }

    @NonNull
    protected abstract InvalidationTracker g();

    @NonNull
    protected abstract SupportSQLiteOpenHelper h(DatabaseConfiguration databaseConfiguration);

    @Deprecated
    public void i() {
        AutoCloser autoCloser = this.f7547k;
        if (autoCloser == null) {
            v();
        } else {
            autoCloser.c(new Function() { // from class: androidx.room.y
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    Object A;
                    A = RoomDatabase.this.A((SupportSQLiteDatabase) obj);
                    return A;
                }
            });
        }
    }

    @NonNull
    public List<Migration> j(@NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> map) {
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, Object> k() {
        return this.f7549m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Lock l() {
        return this.f7546j.readLock();
    }

    @NonNull
    public InvalidationTracker m() {
        return this.f7541e;
    }

    @NonNull
    public SupportSQLiteOpenHelper n() {
        return this.f7540d;
    }

    @NonNull
    public Executor o() {
        return this.f7538b;
    }

    @NonNull
    public Set<Class<? extends AutoMigrationSpec>> p() {
        return Collections.emptySet();
    }

    @NonNull
    protected Map<Class<?>, List<Class<?>>> q() {
        return Collections.emptyMap();
    }

    @NonNull
    public Executor r() {
        return this.f7539c;
    }

    public boolean s() {
        return this.f7540d.H0().T0();
    }

    public void t(@NonNull DatabaseConfiguration databaseConfiguration) {
        boolean z7;
        this.f7540d = h(databaseConfiguration);
        Set<Class<? extends AutoMigrationSpec>> p8 = p();
        BitSet bitSet = new BitSet();
        Iterator<Class<? extends AutoMigrationSpec>> it = p8.iterator();
        while (true) {
            int i8 = -1;
            if (it.hasNext()) {
                Class<? extends AutoMigrationSpec> next = it.next();
                int size = databaseConfiguration.f7450h.size() - 1;
                while (true) {
                    if (size < 0) {
                        break;
                    } else if (next.isAssignableFrom(databaseConfiguration.f7450h.get(size).getClass())) {
                        bitSet.set(size);
                        i8 = size;
                        break;
                    } else {
                        size--;
                    }
                }
                if (i8 >= 0) {
                    this.f7545i.put(next, databaseConfiguration.f7450h.get(i8));
                } else {
                    throw new IllegalArgumentException("A required auto migration spec (" + next.getCanonicalName() + ") is missing in the database configuration.");
                }
            } else {
                for (int size2 = databaseConfiguration.f7450h.size() - 1; size2 >= 0; size2--) {
                    if (!bitSet.get(size2)) {
                        throw new IllegalArgumentException("Unexpected auto migration specs found. Annotate AutoMigrationSpec implementation with @ProvidedAutoMigrationSpec annotation or remove this spec from the builder.");
                    }
                }
                Iterator<Migration> it2 = j(this.f7545i).iterator();
                while (true) {
                    z7 = false;
                    if (!it2.hasNext()) {
                        break;
                    }
                    Migration next2 = it2.next();
                    if (!databaseConfiguration.f7446d.e().containsKey(Integer.valueOf(next2.f7646a))) {
                        databaseConfiguration.f7446d.b(next2);
                    }
                }
                SQLiteCopyOpenHelper sQLiteCopyOpenHelper = (SQLiteCopyOpenHelper) F(SQLiteCopyOpenHelper.class, this.f7540d);
                if (sQLiteCopyOpenHelper != null) {
                    sQLiteCopyOpenHelper.h(databaseConfiguration);
                }
                AutoClosingRoomOpenHelper autoClosingRoomOpenHelper = (AutoClosingRoomOpenHelper) F(AutoClosingRoomOpenHelper.class, this.f7540d);
                if (autoClosingRoomOpenHelper != null) {
                    AutoCloser a8 = autoClosingRoomOpenHelper.a();
                    this.f7547k = a8;
                    this.f7541e.k(a8);
                }
                if (databaseConfiguration.f7452j == JournalMode.WRITE_AHEAD_LOGGING) {
                    z7 = true;
                }
                this.f7540d.setWriteAheadLoggingEnabled(z7);
                this.f7544h = databaseConfiguration.f7447e;
                this.f7538b = databaseConfiguration.f7453k;
                this.f7539c = new TransactionExecutor(databaseConfiguration.f7454l);
                this.f7542f = databaseConfiguration.f7451i;
                this.f7543g = z7;
                Intent intent = databaseConfiguration.f7456n;
                if (intent != null) {
                    this.f7541e.l(databaseConfiguration.f7444b, databaseConfiguration.f7445c, intent);
                }
                Map<Class<?>, List<Class<?>>> q8 = q();
                BitSet bitSet2 = new BitSet();
                for (Map.Entry<Class<?>, List<Class<?>>> entry : q8.entrySet()) {
                    Class<?> key = entry.getKey();
                    for (Class<?> cls : entry.getValue()) {
                        int size3 = databaseConfiguration.f7449g.size() - 1;
                        while (true) {
                            if (size3 >= 0) {
                                if (cls.isAssignableFrom(databaseConfiguration.f7449g.get(size3).getClass())) {
                                    bitSet2.set(size3);
                                    break;
                                }
                                size3--;
                            } else {
                                size3 = -1;
                                break;
                            }
                        }
                        if (size3 >= 0) {
                            this.f7550n.put(cls, databaseConfiguration.f7449g.get(size3));
                        } else {
                            throw new IllegalArgumentException("A required type converter (" + cls + ") for " + key.getCanonicalName() + " is missing in the database configuration.");
                        }
                    }
                }
                for (int size4 = databaseConfiguration.f7449g.size() - 1; size4 >= 0; size4--) {
                    if (!bitSet2.get(size4)) {
                        throw new IllegalArgumentException("Unexpected type converter " + databaseConfiguration.f7449g.get(size4) + ". Annotate TypeConverter class with @ProvidedTypeConverter annotation or remove this converter from the builder.");
                    }
                }
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void w(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
        this.f7541e.e(supportSQLiteDatabase);
    }

    public boolean y() {
        AutoCloser autoCloser = this.f7547k;
        if (autoCloser != null) {
            return autoCloser.g();
        }
        SupportSQLiteDatabase supportSQLiteDatabase = this.f7537a;
        if (supportSQLiteDatabase != null && supportSQLiteDatabase.isOpen()) {
            return true;
        }
        return false;
    }
}
