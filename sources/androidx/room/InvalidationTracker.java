package androidx.room;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;

/* loaded from: classes.dex */
public class InvalidationTracker {

    /* renamed from: o  reason: collision with root package name */
    private static final String[] f7472o = {"UPDATE", "DELETE", "INSERT"};

    /* renamed from: b  reason: collision with root package name */
    final String[] f7474b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private Map<String, Set<String>> f7475c;

    /* renamed from: e  reason: collision with root package name */
    final RoomDatabase f7477e;

    /* renamed from: h  reason: collision with root package name */
    volatile SupportSQLiteStatement f7480h;

    /* renamed from: i  reason: collision with root package name */
    private final ObservedTableTracker f7481i;

    /* renamed from: j  reason: collision with root package name */
    private final InvalidationLiveDataContainer f7482j;

    /* renamed from: l  reason: collision with root package name */
    private MultiInstanceInvalidationClient f7484l;

    /* renamed from: d  reason: collision with root package name */
    AutoCloser f7476d = null;

    /* renamed from: f  reason: collision with root package name */
    AtomicBoolean f7478f = new AtomicBoolean(false);

    /* renamed from: g  reason: collision with root package name */
    private volatile boolean f7479g = false;
    @SuppressLint({"RestrictedApi"})

    /* renamed from: k  reason: collision with root package name */
    final SafeIterableMap<Observer, ObserverWrapper> f7483k = new SafeIterableMap<>();

    /* renamed from: m  reason: collision with root package name */
    private final Object f7485m = new Object();

    /* renamed from: n  reason: collision with root package name */
    Runnable f7486n = new Runnable() { // from class: androidx.room.InvalidationTracker.1
        private Set<Integer> a() {
            HashSet hashSet = new HashSet();
            Cursor B = InvalidationTracker.this.f7477e.B(new SimpleSQLiteQuery("SELECT * FROM room_table_modification_log WHERE invalidated = 1;"));
            while (B.moveToNext()) {
                try {
                    hashSet.add(Integer.valueOf(B.getInt(0)));
                } catch (Throwable th) {
                    B.close();
                    throw th;
                }
            }
            B.close();
            if (!hashSet.isEmpty()) {
                InvalidationTracker.this.f7480h.x();
            }
            return hashSet;
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x0071, code lost:
            if (r0 != null) goto L31;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x0073, code lost:
            r0.b();
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x008f, code lost:
            if (r0 == null) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x0092, code lost:
            if (r1 == null) goto L51;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x0098, code lost:
            if (r1.isEmpty() != false) goto L50;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x009a, code lost:
            r0 = r5.f7487f.f7483k;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x009e, code lost:
            monitor-enter(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x009f, code lost:
            r2 = r5.f7487f.f7483k.iterator();
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x00ab, code lost:
            if (r2.hasNext() == false) goto L42;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x00ad, code lost:
            r2.next().getValue().a(r1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x00bd, code lost:
            monitor-exit(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x00c2, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:67:?, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:68:?, code lost:
            return;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                r5 = this;
                androidx.room.InvalidationTracker r0 = androidx.room.InvalidationTracker.this
                androidx.room.RoomDatabase r0 = r0.f7477e
                java.util.concurrent.locks.Lock r0 = r0.l()
                r0.lock()
                r1 = 0
                androidx.room.InvalidationTracker r2 = androidx.room.InvalidationTracker.this     // Catch: java.lang.Throwable -> L7c android.database.sqlite.SQLiteException -> L7e java.lang.IllegalStateException -> L80
                boolean r2 = r2.d()     // Catch: java.lang.Throwable -> L7c android.database.sqlite.SQLiteException -> L7e java.lang.IllegalStateException -> L80
                if (r2 != 0) goto L21
                r0.unlock()
                androidx.room.InvalidationTracker r0 = androidx.room.InvalidationTracker.this
                androidx.room.AutoCloser r0 = r0.f7476d
                if (r0 == 0) goto L20
                r0.b()
            L20:
                return
            L21:
                androidx.room.InvalidationTracker r2 = androidx.room.InvalidationTracker.this     // Catch: java.lang.Throwable -> L7c android.database.sqlite.SQLiteException -> L7e java.lang.IllegalStateException -> L80
                java.util.concurrent.atomic.AtomicBoolean r2 = r2.f7478f     // Catch: java.lang.Throwable -> L7c android.database.sqlite.SQLiteException -> L7e java.lang.IllegalStateException -> L80
                r3 = 1
                r4 = 0
                boolean r2 = r2.compareAndSet(r3, r4)     // Catch: java.lang.Throwable -> L7c android.database.sqlite.SQLiteException -> L7e java.lang.IllegalStateException -> L80
                if (r2 != 0) goto L3a
                r0.unlock()
                androidx.room.InvalidationTracker r0 = androidx.room.InvalidationTracker.this
                androidx.room.AutoCloser r0 = r0.f7476d
                if (r0 == 0) goto L39
                r0.b()
            L39:
                return
            L3a:
                androidx.room.InvalidationTracker r2 = androidx.room.InvalidationTracker.this     // Catch: java.lang.Throwable -> L7c android.database.sqlite.SQLiteException -> L7e java.lang.IllegalStateException -> L80
                androidx.room.RoomDatabase r2 = r2.f7477e     // Catch: java.lang.Throwable -> L7c android.database.sqlite.SQLiteException -> L7e java.lang.IllegalStateException -> L80
                boolean r2 = r2.s()     // Catch: java.lang.Throwable -> L7c android.database.sqlite.SQLiteException -> L7e java.lang.IllegalStateException -> L80
                if (r2 == 0) goto L51
                r0.unlock()
                androidx.room.InvalidationTracker r0 = androidx.room.InvalidationTracker.this
                androidx.room.AutoCloser r0 = r0.f7476d
                if (r0 == 0) goto L50
                r0.b()
            L50:
                return
            L51:
                androidx.room.InvalidationTracker r2 = androidx.room.InvalidationTracker.this     // Catch: java.lang.Throwable -> L7c android.database.sqlite.SQLiteException -> L7e java.lang.IllegalStateException -> L80
                androidx.room.RoomDatabase r2 = r2.f7477e     // Catch: java.lang.Throwable -> L7c android.database.sqlite.SQLiteException -> L7e java.lang.IllegalStateException -> L80
                androidx.sqlite.db.SupportSQLiteOpenHelper r2 = r2.n()     // Catch: java.lang.Throwable -> L7c android.database.sqlite.SQLiteException -> L7e java.lang.IllegalStateException -> L80
                androidx.sqlite.db.SupportSQLiteDatabase r2 = r2.H0()     // Catch: java.lang.Throwable -> L7c android.database.sqlite.SQLiteException -> L7e java.lang.IllegalStateException -> L80
                r2.M()     // Catch: java.lang.Throwable -> L7c android.database.sqlite.SQLiteException -> L7e java.lang.IllegalStateException -> L80
                java.util.Set r1 = r5.a()     // Catch: java.lang.Throwable -> L77
                r2.K()     // Catch: java.lang.Throwable -> L77
                r2.S()     // Catch: java.lang.Throwable -> L7c android.database.sqlite.SQLiteException -> L7e java.lang.IllegalStateException -> L80
                r0.unlock()
                androidx.room.InvalidationTracker r0 = androidx.room.InvalidationTracker.this
                androidx.room.AutoCloser r0 = r0.f7476d
                if (r0 == 0) goto L92
            L73:
                r0.b()
                goto L92
            L77:
                r3 = move-exception
                r2.S()     // Catch: java.lang.Throwable -> L7c android.database.sqlite.SQLiteException -> L7e java.lang.IllegalStateException -> L80
                throw r3     // Catch: java.lang.Throwable -> L7c android.database.sqlite.SQLiteException -> L7e java.lang.IllegalStateException -> L80
            L7c:
                r1 = move-exception
                goto Lc3
            L7e:
                r2 = move-exception
                goto L81
            L80:
                r2 = move-exception
            L81:
                java.lang.String r3 = "ROOM"
                java.lang.String r4 = "Cannot run invalidation tracker. Is the db closed?"
                android.util.Log.e(r3, r4, r2)     // Catch: java.lang.Throwable -> L7c
                r0.unlock()
                androidx.room.InvalidationTracker r0 = androidx.room.InvalidationTracker.this
                androidx.room.AutoCloser r0 = r0.f7476d
                if (r0 == 0) goto L92
                goto L73
            L92:
                if (r1 == 0) goto Lc2
                boolean r0 = r1.isEmpty()
                if (r0 != 0) goto Lc2
                androidx.room.InvalidationTracker r0 = androidx.room.InvalidationTracker.this
                androidx.arch.core.internal.SafeIterableMap<androidx.room.InvalidationTracker$Observer, androidx.room.InvalidationTracker$ObserverWrapper> r0 = r0.f7483k
                monitor-enter(r0)
                androidx.room.InvalidationTracker r2 = androidx.room.InvalidationTracker.this     // Catch: java.lang.Throwable -> Lbf
                androidx.arch.core.internal.SafeIterableMap<androidx.room.InvalidationTracker$Observer, androidx.room.InvalidationTracker$ObserverWrapper> r2 = r2.f7483k     // Catch: java.lang.Throwable -> Lbf
                java.util.Iterator r2 = r2.iterator()     // Catch: java.lang.Throwable -> Lbf
            La7:
                boolean r3 = r2.hasNext()     // Catch: java.lang.Throwable -> Lbf
                if (r3 == 0) goto Lbd
                java.lang.Object r3 = r2.next()     // Catch: java.lang.Throwable -> Lbf
                java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch: java.lang.Throwable -> Lbf
                java.lang.Object r3 = r3.getValue()     // Catch: java.lang.Throwable -> Lbf
                androidx.room.InvalidationTracker$ObserverWrapper r3 = (androidx.room.InvalidationTracker.ObserverWrapper) r3     // Catch: java.lang.Throwable -> Lbf
                r3.a(r1)     // Catch: java.lang.Throwable -> Lbf
                goto La7
            Lbd:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> Lbf
                goto Lc2
            Lbf:
                r1 = move-exception
                monitor-exit(r0)     // Catch: java.lang.Throwable -> Lbf
                throw r1
            Lc2:
                return
            Lc3:
                r0.unlock()
                androidx.room.InvalidationTracker r0 = androidx.room.InvalidationTracker.this
                androidx.room.AutoCloser r0 = r0.f7476d
                if (r0 == 0) goto Lcf
                r0.b()
            Lcf:
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.InvalidationTracker.AnonymousClass1.run():void");
        }
    };
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    final HashMap<String, Integer> f7473a = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class ObservedTableTracker {

        /* renamed from: a  reason: collision with root package name */
        final long[] f7488a;

        /* renamed from: b  reason: collision with root package name */
        final boolean[] f7489b;

        /* renamed from: c  reason: collision with root package name */
        final int[] f7490c;

        /* renamed from: d  reason: collision with root package name */
        boolean f7491d;

        ObservedTableTracker(int i8) {
            long[] jArr = new long[i8];
            this.f7488a = jArr;
            boolean[] zArr = new boolean[i8];
            this.f7489b = zArr;
            this.f7490c = new int[i8];
            Arrays.fill(jArr, 0L);
            Arrays.fill(zArr, false);
        }

        int[] a() {
            boolean z7;
            synchronized (this) {
                if (!this.f7491d) {
                    return null;
                }
                int length = this.f7488a.length;
                for (int i8 = 0; i8 < length; i8++) {
                    int i9 = 1;
                    if (this.f7488a[i8] > 0) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    boolean[] zArr = this.f7489b;
                    if (z7 != zArr[i8]) {
                        int[] iArr = this.f7490c;
                        if (!z7) {
                            i9 = 2;
                        }
                        iArr[i8] = i9;
                    } else {
                        this.f7490c[i8] = 0;
                    }
                    zArr[i8] = z7;
                }
                this.f7491d = false;
                return (int[]) this.f7490c.clone();
            }
        }

        boolean b(int... iArr) {
            boolean z7;
            synchronized (this) {
                z7 = false;
                for (int i8 : iArr) {
                    long[] jArr = this.f7488a;
                    long j8 = jArr[i8];
                    jArr[i8] = 1 + j8;
                    if (j8 == 0) {
                        this.f7491d = true;
                        z7 = true;
                    }
                }
            }
            return z7;
        }

        boolean c(int... iArr) {
            boolean z7;
            synchronized (this) {
                z7 = false;
                for (int i8 : iArr) {
                    long[] jArr = this.f7488a;
                    long j8 = jArr[i8];
                    jArr[i8] = j8 - 1;
                    if (j8 == 1) {
                        this.f7491d = true;
                        z7 = true;
                    }
                }
            }
            return z7;
        }

        void d() {
            synchronized (this) {
                Arrays.fill(this.f7489b, false);
                this.f7491d = true;
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Observer {

        /* renamed from: a  reason: collision with root package name */
        final String[] f7492a;

        public Observer(@NonNull String[] strArr) {
            this.f7492a = (String[]) Arrays.copyOf(strArr, strArr.length);
        }

        boolean a() {
            return false;
        }

        public abstract void b(@NonNull Set<String> set);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class ObserverWrapper {

        /* renamed from: a  reason: collision with root package name */
        final int[] f7493a;

        /* renamed from: b  reason: collision with root package name */
        private final String[] f7494b;

        /* renamed from: c  reason: collision with root package name */
        final Observer f7495c;

        /* renamed from: d  reason: collision with root package name */
        private final Set<String> f7496d;

        ObserverWrapper(Observer observer, int[] iArr, String[] strArr) {
            this.f7495c = observer;
            this.f7493a = iArr;
            this.f7494b = strArr;
            if (iArr.length == 1) {
                HashSet hashSet = new HashSet();
                hashSet.add(strArr[0]);
                this.f7496d = Collections.unmodifiableSet(hashSet);
                return;
            }
            this.f7496d = null;
        }

        void a(Set<Integer> set) {
            int length = this.f7493a.length;
            Set<String> set2 = null;
            for (int i8 = 0; i8 < length; i8++) {
                if (set.contains(Integer.valueOf(this.f7493a[i8]))) {
                    if (length == 1) {
                        set2 = this.f7496d;
                    } else {
                        if (set2 == null) {
                            set2 = new HashSet<>(length);
                        }
                        set2.add(this.f7494b[i8]);
                    }
                }
            }
            if (set2 != null) {
                this.f7495c.b(set2);
            }
        }

        void b(String[] strArr) {
            Set<String> set = null;
            if (this.f7494b.length == 1) {
                int length = strArr.length;
                int i8 = 0;
                while (true) {
                    if (i8 >= length) {
                        break;
                    } else if (strArr[i8].equalsIgnoreCase(this.f7494b[0])) {
                        set = this.f7496d;
                        break;
                    } else {
                        i8++;
                    }
                }
            } else {
                HashSet hashSet = new HashSet();
                for (String str : strArr) {
                    String[] strArr2 = this.f7494b;
                    int length2 = strArr2.length;
                    int i9 = 0;
                    while (true) {
                        if (i9 < length2) {
                            String str2 = strArr2[i9];
                            if (str2.equalsIgnoreCase(str)) {
                                hashSet.add(str2);
                                break;
                            }
                            i9++;
                        }
                    }
                }
                if (hashSet.size() > 0) {
                    set = hashSet;
                }
            }
            if (set != null) {
                this.f7495c.b(set);
            }
        }
    }

    public InvalidationTracker(RoomDatabase roomDatabase, Map<String, String> map, Map<String, Set<String>> map2, String... strArr) {
        this.f7477e = roomDatabase;
        this.f7481i = new ObservedTableTracker(strArr.length);
        this.f7475c = map2;
        this.f7482j = new InvalidationLiveDataContainer(roomDatabase);
        int length = strArr.length;
        this.f7474b = new String[length];
        for (int i8 = 0; i8 < length; i8++) {
            String str = strArr[i8];
            Locale locale = Locale.US;
            String lowerCase = str.toLowerCase(locale);
            this.f7473a.put(lowerCase, Integer.valueOf(i8));
            String str2 = map.get(strArr[i8]);
            if (str2 != null) {
                this.f7474b[i8] = str2.toLowerCase(locale);
            } else {
                this.f7474b[i8] = lowerCase;
            }
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            Locale locale2 = Locale.US;
            String lowerCase2 = entry.getValue().toLowerCase(locale2);
            if (this.f7473a.containsKey(lowerCase2)) {
                String lowerCase3 = entry.getKey().toLowerCase(locale2);
                HashMap<String, Integer> hashMap = this.f7473a;
                hashMap.put(lowerCase3, hashMap.get(lowerCase2));
            }
        }
    }

    private static void b(StringBuilder sb, String str, String str2) {
        sb.append("`");
        sb.append("room_table_modification_trigger_");
        sb.append(str);
        sb.append("_");
        sb.append(str2);
        sb.append("`");
    }

    private static void c(SupportSQLiteDatabase supportSQLiteDatabase) {
        if (supportSQLiteDatabase.d1()) {
            supportSQLiteDatabase.M();
        } else {
            supportSQLiteDatabase.n();
        }
    }

    private String[] j(String[] strArr) {
        HashSet hashSet = new HashSet();
        for (String str : strArr) {
            String lowerCase = str.toLowerCase(Locale.US);
            if (this.f7475c.containsKey(lowerCase)) {
                hashSet.addAll(this.f7475c.get(lowerCase));
            } else {
                hashSet.add(str);
            }
        }
        return (String[]) hashSet.toArray(new String[hashSet.size()]);
    }

    private void m(SupportSQLiteDatabase supportSQLiteDatabase, int i8) {
        String[] strArr;
        supportSQLiteDatabase.u("INSERT OR IGNORE INTO room_table_modification_log VALUES(" + i8 + ", 0)");
        String str = this.f7474b[i8];
        StringBuilder sb = new StringBuilder();
        for (String str2 : f7472o) {
            sb.setLength(0);
            sb.append("CREATE TEMP TRIGGER IF NOT EXISTS ");
            b(sb, str, str2);
            sb.append(" AFTER ");
            sb.append(str2);
            sb.append(" ON `");
            sb.append(str);
            sb.append("` BEGIN UPDATE ");
            sb.append("room_table_modification_log");
            sb.append(" SET ");
            sb.append("invalidated");
            sb.append(" = 1");
            sb.append(" WHERE ");
            sb.append("table_id");
            sb.append(" = ");
            sb.append(i8);
            sb.append(" AND ");
            sb.append("invalidated");
            sb.append(" = 0");
            sb.append("; END");
            supportSQLiteDatabase.u(sb.toString());
        }
    }

    private void n(SupportSQLiteDatabase supportSQLiteDatabase, int i8) {
        String[] strArr;
        String str = this.f7474b[i8];
        StringBuilder sb = new StringBuilder();
        for (String str2 : f7472o) {
            sb.setLength(0);
            sb.append("DROP TRIGGER IF EXISTS ");
            b(sb, str, str2);
            supportSQLiteDatabase.u(sb.toString());
        }
    }

    @SuppressLint({"RestrictedApi"})
    public void a(@NonNull Observer observer) {
        ObserverWrapper k8;
        String[] j8 = j(observer.f7492a);
        int[] iArr = new int[j8.length];
        int length = j8.length;
        for (int i8 = 0; i8 < length; i8++) {
            Integer num = this.f7473a.get(j8[i8].toLowerCase(Locale.US));
            if (num != null) {
                iArr[i8] = num.intValue();
            } else {
                throw new IllegalArgumentException("There is no table with name " + j8[i8]);
            }
        }
        ObserverWrapper observerWrapper = new ObserverWrapper(observer, iArr, j8);
        synchronized (this.f7483k) {
            k8 = this.f7483k.k(observer, observerWrapper);
        }
        if (k8 == null && this.f7481i.b(iArr)) {
            o();
        }
    }

    boolean d() {
        if (!this.f7477e.y()) {
            return false;
        }
        if (!this.f7479g) {
            this.f7477e.n().H0();
        }
        if (!this.f7479g) {
            Log.e("ROOM", "database is not initialized even though it is open");
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(SupportSQLiteDatabase supportSQLiteDatabase) {
        synchronized (this) {
            if (this.f7479g) {
                Log.e("ROOM", "Invalidation tracker is initialized twice :/.");
                return;
            }
            supportSQLiteDatabase.u("PRAGMA temp_store = MEMORY;");
            supportSQLiteDatabase.u("PRAGMA recursive_triggers='ON';");
            supportSQLiteDatabase.u("CREATE TEMP TABLE room_table_modification_log(table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)");
            p(supportSQLiteDatabase);
            this.f7480h = supportSQLiteDatabase.r0("UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1 ");
            this.f7479g = true;
        }
    }

    public void f(String... strArr) {
        synchronized (this.f7483k) {
            Iterator<Map.Entry<Observer, ObserverWrapper>> it = this.f7483k.iterator();
            while (it.hasNext()) {
                Map.Entry<Observer, ObserverWrapper> next = it.next();
                if (!next.getKey().a()) {
                    next.getValue().b(strArr);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g() {
        synchronized (this) {
            this.f7479g = false;
            this.f7481i.d();
        }
    }

    public void h() {
        if (this.f7478f.compareAndSet(false, true)) {
            AutoCloser autoCloser = this.f7476d;
            if (autoCloser != null) {
                autoCloser.e();
            }
            this.f7477e.o().execute(this.f7486n);
        }
    }

    @SuppressLint({"RestrictedApi"})
    public void i(@NonNull Observer observer) {
        ObserverWrapper m8;
        synchronized (this.f7483k) {
            m8 = this.f7483k.m(observer);
        }
        if (m8 != null && this.f7481i.c(m8.f7493a)) {
            o();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(AutoCloser autoCloser) {
        this.f7476d = autoCloser;
        autoCloser.h(new Runnable() { // from class: androidx.room.l
            @Override // java.lang.Runnable
            public final void run() {
                InvalidationTracker.this.g();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(Context context, String str, Intent intent) {
        this.f7484l = new MultiInstanceInvalidationClient(context, str, intent, this, this.f7477e.o());
    }

    void o() {
        if (!this.f7477e.y()) {
            return;
        }
        p(this.f7477e.n().H0());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(SupportSQLiteDatabase supportSQLiteDatabase) {
        if (supportSQLiteDatabase.T0()) {
            return;
        }
        try {
            Lock l8 = this.f7477e.l();
            l8.lock();
            try {
                synchronized (this.f7485m) {
                    int[] a8 = this.f7481i.a();
                    if (a8 == null) {
                        return;
                    }
                    int length = a8.length;
                    c(supportSQLiteDatabase);
                    for (int i8 = 0; i8 < length; i8++) {
                        int i9 = a8[i8];
                        if (i9 != 1) {
                            if (i9 == 2) {
                                n(supportSQLiteDatabase, i8);
                            }
                        } else {
                            m(supportSQLiteDatabase, i8);
                        }
                    }
                    supportSQLiteDatabase.K();
                    supportSQLiteDatabase.S();
                }
            } finally {
                l8.unlock();
            }
        } catch (SQLiteException | IllegalStateException e8) {
            Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e8);
        }
    }
}
