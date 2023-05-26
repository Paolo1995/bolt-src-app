package j$.util.concurrent;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Function;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import sun.misc.Unsafe;

/* loaded from: classes2.dex */
public class ConcurrentHashMap<K, V> extends AbstractMap<K, V> implements ConcurrentMap<K, V>, Serializable, v {
    private static final long ABASE;
    private static final int ASHIFT;
    private static final long BASECOUNT;
    private static final long CELLSBUSY;
    private static final long CELLVALUE;
    private static final int DEFAULT_CAPACITY = 16;
    private static final int DEFAULT_CONCURRENCY_LEVEL = 16;
    static final int HASH_BITS = Integer.MAX_VALUE;
    private static final float LOAD_FACTOR = 0.75f;
    private static final int MAXIMUM_CAPACITY = 1073741824;
    static final int MAX_ARRAY_SIZE = 2147483639;
    private static final int MIN_TRANSFER_STRIDE = 16;
    static final int MIN_TREEIFY_CAPACITY = 64;
    static final int MOVED = -1;
    static final int RESERVED = -3;
    private static int RESIZE_STAMP_BITS = 16;
    private static final long SIZECTL;
    private static final long TRANSFERINDEX;
    static final int TREEBIN = -2;
    static final int TREEIFY_THRESHOLD = 8;
    private static final Unsafe U;
    static final int UNTREEIFY_THRESHOLD = 6;
    private static final ObjectStreamField[] serialPersistentFields;
    private static final long serialVersionUID = 7249069246763182397L;
    private volatile transient long baseCount;
    private volatile transient int cellsBusy;
    private volatile transient d[] counterCells;
    private transient f entrySet;
    private transient j keySet;
    private volatile transient m[] nextTable;
    private volatile transient int sizeCtl;
    volatile transient m[] table;
    private volatile transient int transferIndex;
    private transient t values;
    private static final int MAX_RESIZERS = (1 << (32 - 16)) - 1;
    private static final int RESIZE_STAMP_SHIFT = 32 - 16;
    static final int NCPU = Runtime.getRuntime().availableProcessors();

    static {
        Class cls = Integer.TYPE;
        serialPersistentFields = new ObjectStreamField[]{new ObjectStreamField("segments", o[].class), new ObjectStreamField("segmentMask", cls), new ObjectStreamField("segmentShift", cls)};
        try {
            Unsafe c8 = w.c();
            U = c8;
            SIZECTL = c8.objectFieldOffset(ConcurrentHashMap.class.getDeclaredField("sizeCtl"));
            TRANSFERINDEX = c8.objectFieldOffset(ConcurrentHashMap.class.getDeclaredField("transferIndex"));
            BASECOUNT = c8.objectFieldOffset(ConcurrentHashMap.class.getDeclaredField("baseCount"));
            CELLSBUSY = c8.objectFieldOffset(ConcurrentHashMap.class.getDeclaredField("cellsBusy"));
            CELLVALUE = c8.objectFieldOffset(d.class.getDeclaredField(AppMeasurementSdk.ConditionalUserProperty.VALUE));
            ABASE = c8.arrayBaseOffset(m[].class);
            int arrayIndexScale = c8.arrayIndexScale(m[].class);
            if (((arrayIndexScale - 1) & arrayIndexScale) != 0) {
                throw new Error("data type scale not a power of two");
            }
            ASHIFT = 31 - Integer.numberOfLeadingZeros(arrayIndexScale);
        } catch (Exception e8) {
            throw new Error(e8);
        }
    }

    public ConcurrentHashMap() {
    }

    public ConcurrentHashMap(int i8) {
        if (i8 < 0) {
            throw new IllegalArgumentException();
        }
        this.sizeCtl = i8 >= 536870912 ? 1073741824 : tableSizeFor(i8 + (i8 >>> 1) + 1);
    }

    public ConcurrentHashMap(int i8, float f8) {
        this(i8, f8, 1);
    }

    public ConcurrentHashMap(int i8, float f8, int i9) {
        if (f8 <= 0.0f || i8 < 0 || i9 <= 0) {
            throw new IllegalArgumentException();
        }
        long j8 = (long) (((i8 < i9 ? i9 : i8) / f8) + 1.0d);
        this.sizeCtl = j8 >= 1073741824 ? 1073741824 : tableSizeFor((int) j8);
    }

    public ConcurrentHashMap(Map<? extends K, ? extends V> map) {
        this.sizeCtl = 16;
        putAll(map);
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0012, code lost:
        if (r1.compareAndSwapLong(r11, r3, r5, r9) == false) goto L53;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void addCount(long r12, int r14) {
        /*
            r11 = this;
            j$.util.concurrent.d[] r0 = r11.counterCells
            if (r0 != 0) goto L14
            sun.misc.Unsafe r1 = j$.util.concurrent.ConcurrentHashMap.U
            long r3 = j$.util.concurrent.ConcurrentHashMap.BASECOUNT
            long r5 = r11.baseCount
            long r9 = r5 + r12
            r2 = r11
            r7 = r9
            boolean r1 = r1.compareAndSwapLong(r2, r3, r5, r7)
            if (r1 != 0) goto L3b
        L14:
            r1 = 1
            if (r0 == 0) goto L96
            int r2 = r0.length
            int r2 = r2 - r1
            if (r2 < 0) goto L96
            int r3 = j$.util.concurrent.ThreadLocalRandom.b()
            r2 = r2 & r3
            r4 = r0[r2]
            if (r4 == 0) goto L96
            sun.misc.Unsafe r3 = j$.util.concurrent.ConcurrentHashMap.U
            long r5 = j$.util.concurrent.ConcurrentHashMap.CELLVALUE
            long r7 = r4.value
            long r9 = r7 + r12
            boolean r0 = r3.compareAndSwapLong(r4, r5, r7, r9)
            if (r0 != 0) goto L34
            r1 = r0
            goto L96
        L34:
            if (r14 > r1) goto L37
            return
        L37:
            long r9 = r11.sumCount()
        L3b:
            if (r14 < 0) goto L95
        L3d:
            int r4 = r11.sizeCtl
            long r12 = (long) r4
            int r14 = (r9 > r12 ? 1 : (r9 == r12 ? 0 : -1))
            if (r14 < 0) goto L95
            j$.util.concurrent.m[] r12 = r11.table
            if (r12 == 0) goto L95
            int r13 = r12.length
            r14 = 1073741824(0x40000000, float:2.0)
            if (r13 >= r14) goto L95
            int r13 = resizeStamp(r13)
            if (r4 >= 0) goto L7c
            int r14 = j$.util.concurrent.ConcurrentHashMap.RESIZE_STAMP_SHIFT
            int r14 = r4 >>> r14
            if (r14 != r13) goto L95
            int r14 = r13 + 1
            if (r4 == r14) goto L95
            int r14 = j$.util.concurrent.ConcurrentHashMap.MAX_RESIZERS
            int r13 = r13 + r14
            if (r4 == r13) goto L95
            j$.util.concurrent.m[] r13 = r11.nextTable
            if (r13 == 0) goto L95
            int r14 = r11.transferIndex
            if (r14 > 0) goto L6b
            goto L95
        L6b:
            sun.misc.Unsafe r0 = j$.util.concurrent.ConcurrentHashMap.U
            long r2 = j$.util.concurrent.ConcurrentHashMap.SIZECTL
            int r5 = r4 + 1
            r1 = r11
            boolean r14 = r0.compareAndSwapInt(r1, r2, r4, r5)
            if (r14 == 0) goto L90
            r11.transfer(r12, r13)
            goto L90
        L7c:
            sun.misc.Unsafe r0 = j$.util.concurrent.ConcurrentHashMap.U
            long r2 = j$.util.concurrent.ConcurrentHashMap.SIZECTL
            int r14 = j$.util.concurrent.ConcurrentHashMap.RESIZE_STAMP_SHIFT
            int r13 = r13 << r14
            int r5 = r13 + 2
            r1 = r11
            boolean r13 = r0.compareAndSwapInt(r1, r2, r4, r5)
            if (r13 == 0) goto L90
            r13 = 0
            r11.transfer(r12, r13)
        L90:
            long r9 = r11.sumCount()
            goto L3d
        L95:
            return
        L96:
            r11.fullAddCount(r12, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.ConcurrentHashMap.addCount(long, int):void");
    }

    static final <K, V> boolean casTabAt(m[] mVarArr, int i8, m mVar, m mVar2) {
        return AbstractC0109a.a(U, mVarArr, (i8 << ASHIFT) + ABASE, mVar, mVar2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Class<?> comparableClassFor(Object obj) {
        Type[] actualTypeArguments;
        if (obj instanceof Comparable) {
            Class<?> cls = obj.getClass();
            if (cls == String.class) {
                return cls;
            }
            Type[] genericInterfaces = cls.getGenericInterfaces();
            if (genericInterfaces != null) {
                for (Type type : genericInterfaces) {
                    if (type instanceof ParameterizedType) {
                        ParameterizedType parameterizedType = (ParameterizedType) type;
                        if (parameterizedType.getRawType() == Comparable.class && (actualTypeArguments = parameterizedType.getActualTypeArguments()) != null && actualTypeArguments.length == 1 && actualTypeArguments[0] == cls) {
                            return cls;
                        }
                    }
                }
                return null;
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int compareComparables(Class<?> cls, Object obj, Object obj2) {
        if (obj2 == null || obj2.getClass() != cls) {
            return 0;
        }
        return ((Comparable) obj).compareTo(obj2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x009d, code lost:
        if (r24.counterCells != r7) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x009f, code lost:
        r1 = new j$.util.concurrent.d[r8 << 1];
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00a4, code lost:
        if (r2 >= r8) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00a6, code lost:
        r1[r2] = r7[r2];
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00ad, code lost:
        r24.counterCells = r1;
     */
    /* JADX WARN: Removed duplicated region for block: B:108:0x001b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0102 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void fullAddCount(long r25, boolean r27) {
        /*
            Method dump skipped, instructions count: 259
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.ConcurrentHashMap.fullAddCount(long, boolean):void");
    }

    private final m[] initTable() {
        while (true) {
            m[] mVarArr = this.table;
            if (mVarArr != null && mVarArr.length != 0) {
                return mVarArr;
            }
            int i8 = this.sizeCtl;
            if (i8 < 0) {
                Thread.yield();
            } else if (U.compareAndSwapInt(this, SIZECTL, i8, -1)) {
                try {
                    m[] mVarArr2 = this.table;
                    if (mVarArr2 == null || mVarArr2.length == 0) {
                        int i9 = i8 > 0 ? i8 : 16;
                        m[] mVarArr3 = new m[i9];
                        this.table = mVarArr3;
                        i8 = i9 - (i9 >>> 2);
                        mVarArr2 = mVarArr3;
                    }
                    this.sizeCtl = i8;
                    return mVarArr2;
                } catch (Throwable th) {
                    this.sizeCtl = i8;
                    throw th;
                }
            }
        }
    }

    private void readObject(ObjectInputStream objectInputStream) {
        long j8;
        int tableSizeFor;
        boolean z7;
        Object obj;
        this.sizeCtl = -1;
        objectInputStream.defaultReadObject();
        long j9 = 0;
        long j10 = 0;
        m mVar = null;
        while (true) {
            Object readObject = objectInputStream.readObject();
            Object readObject2 = objectInputStream.readObject();
            j8 = 1;
            if (readObject == null || readObject2 == null) {
                break;
            }
            j10++;
            mVar = new m(spread(readObject.hashCode()), readObject, readObject2, mVar);
        }
        if (j10 == 0) {
            this.sizeCtl = 0;
            return;
        }
        if (j10 >= 536870912) {
            tableSizeFor = 1073741824;
        } else {
            int i8 = (int) j10;
            tableSizeFor = tableSizeFor(i8 + (i8 >>> 1) + 1);
        }
        m[] mVarArr = new m[tableSizeFor];
        int i9 = tableSizeFor - 1;
        while (mVar != null) {
            m mVar2 = mVar.f50225d;
            int i10 = mVar.f50222a;
            int i11 = i10 & i9;
            m tabAt = tabAt(mVarArr, i11);
            if (tabAt == null) {
                z7 = true;
            } else {
                Object obj2 = mVar.f50223b;
                if (tabAt.f50222a >= 0) {
                    int i12 = 0;
                    for (m mVar3 = tabAt; mVar3 != null; mVar3 = mVar3.f50225d) {
                        if (mVar3.f50222a == i10 && ((obj = mVar3.f50223b) == obj2 || (obj != null && obj2.equals(obj)))) {
                            z7 = false;
                            break;
                        }
                        i12++;
                    }
                    z7 = true;
                    if (z7 && i12 >= 8) {
                        j9++;
                        mVar.f50225d = tabAt;
                        m mVar4 = mVar;
                        s sVar = null;
                        s sVar2 = null;
                        while (mVar4 != null) {
                            long j11 = j9;
                            s sVar3 = new s(mVar4.f50222a, mVar4.f50223b, mVar4.f50224c, null, null);
                            sVar3.f50246h = sVar2;
                            if (sVar2 == null) {
                                sVar = sVar3;
                            } else {
                                sVar2.f50225d = sVar3;
                            }
                            mVar4 = mVar4.f50225d;
                            sVar2 = sVar3;
                            j9 = j11;
                        }
                        setTabAt(mVarArr, i11, new r(sVar));
                    }
                } else if (((r) tabAt).f(i10, obj2, mVar.f50224c) == null) {
                    j9 += j8;
                }
                z7 = false;
            }
            if (z7) {
                j9++;
                mVar.f50225d = tabAt;
                setTabAt(mVarArr, i11, mVar);
            }
            j8 = 1;
            mVar = mVar2;
        }
        this.table = mVarArr;
        this.sizeCtl = tableSizeFor - (tableSizeFor >>> 2);
        this.baseCount = j9;
    }

    static final int resizeStamp(int i8) {
        return Integer.numberOfLeadingZeros(i8) | (1 << (RESIZE_STAMP_BITS - 1));
    }

    static final <K, V> void setTabAt(m[] mVarArr, int i8, m mVar) {
        U.putObjectVolatile(mVarArr, (i8 << ASHIFT) + ABASE, mVar);
    }

    static final int spread(int i8) {
        return (i8 ^ (i8 >>> 16)) & Integer.MAX_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final <K, V> m tabAt(m[] mVarArr, int i8) {
        return (m) U.getObjectVolatile(mVarArr, (i8 << ASHIFT) + ABASE);
    }

    private static final int tableSizeFor(int i8) {
        int i9 = i8 - 1;
        int i10 = i9 | (i9 >>> 1);
        int i11 = i10 | (i10 >>> 2);
        int i12 = i11 | (i11 >>> 4);
        int i13 = i12 | (i12 >>> 8);
        int i14 = i13 | (i13 >>> 16);
        if (i14 < 0) {
            return 1;
        }
        if (i14 >= 1073741824) {
            return 1073741824;
        }
        return 1 + i14;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v15, types: [j$.util.concurrent.m] */
    /* JADX WARN: Type inference failed for: r15v17, types: [j$.util.concurrent.m] */
    /* JADX WARN: Type inference failed for: r6v17, types: [j$.util.concurrent.m] */
    /* JADX WARN: Type inference failed for: r6v22, types: [j$.util.concurrent.m] */
    private final void transfer(m[] mVarArr, m[] mVarArr2) {
        m[] mVarArr3;
        ConcurrentHashMap<K, V> concurrentHashMap;
        m[] mVarArr4;
        int i8;
        int i9;
        h hVar;
        ConcurrentHashMap<K, V> concurrentHashMap2;
        int i10;
        s sVar;
        s sVar2;
        ConcurrentHashMap<K, V> concurrentHashMap3 = this;
        int length = mVarArr.length;
        int i11 = NCPU;
        int i12 = i11 > 1 ? (length >>> 3) / i11 : length;
        int i13 = i12 < 16 ? 16 : i12;
        if (mVarArr2 == null) {
            try {
                m[] mVarArr5 = new m[length << 1];
                concurrentHashMap3.nextTable = mVarArr5;
                concurrentHashMap3.transferIndex = length;
                mVarArr3 = mVarArr5;
            } catch (Throwable unused) {
                concurrentHashMap3.sizeCtl = Integer.MAX_VALUE;
                return;
            }
        } else {
            mVarArr3 = mVarArr2;
        }
        int length2 = mVarArr3.length;
        h hVar2 = new h(mVarArr3);
        m[] mVarArr6 = mVarArr;
        ConcurrentHashMap<K, V> concurrentHashMap4 = concurrentHashMap3;
        int i14 = 0;
        int i15 = 0;
        boolean z7 = true;
        boolean z8 = false;
        while (true) {
            if (z7) {
                int i16 = i14 - 1;
                if (i16 >= i15 || z8) {
                    concurrentHashMap = concurrentHashMap4;
                    mVarArr4 = mVarArr6;
                    i14 = i16;
                    i15 = i15;
                } else {
                    int i17 = concurrentHashMap4.transferIndex;
                    if (i17 <= 0) {
                        concurrentHashMap = concurrentHashMap4;
                        mVarArr4 = mVarArr6;
                        i14 = -1;
                    } else {
                        Unsafe unsafe = U;
                        long j8 = TRANSFERINDEX;
                        int i18 = i17 > i13 ? i17 - i13 : 0;
                        concurrentHashMap = concurrentHashMap4;
                        mVarArr4 = mVarArr6;
                        int i19 = i15;
                        if (unsafe.compareAndSwapInt(this, j8, i17, i18)) {
                            i14 = i17 - 1;
                            i15 = i18;
                        } else {
                            mVarArr6 = mVarArr4;
                            i14 = i16;
                            i15 = i19;
                            concurrentHashMap4 = concurrentHashMap;
                        }
                    }
                }
                mVarArr6 = mVarArr4;
                concurrentHashMap4 = concurrentHashMap;
                z7 = false;
            } else {
                ConcurrentHashMap<K, V> concurrentHashMap5 = concurrentHashMap4;
                m[] mVarArr7 = mVarArr6;
                int i20 = i15;
                s sVar3 = null;
                if (i14 < 0 || i14 >= length || (i10 = i14 + length) >= length2) {
                    i8 = i13;
                    i9 = length2;
                    hVar = hVar2;
                    if (z8) {
                        this.nextTable = null;
                        this.table = mVarArr3;
                        this.sizeCtl = (length << 1) - (length >>> 1);
                        return;
                    }
                    concurrentHashMap2 = this;
                    Unsafe unsafe2 = U;
                    long j9 = SIZECTL;
                    int i21 = concurrentHashMap2.sizeCtl;
                    int i22 = i14;
                    if (!unsafe2.compareAndSwapInt(this, j9, i21, i21 - 1)) {
                        concurrentHashMap4 = concurrentHashMap2;
                        mVarArr6 = mVarArr7;
                        i14 = i22;
                    } else if (i21 - 2 != (resizeStamp(length) << RESIZE_STAMP_SHIFT)) {
                        return;
                    } else {
                        i14 = length;
                        concurrentHashMap4 = concurrentHashMap2;
                        mVarArr6 = mVarArr7;
                        z7 = true;
                        z8 = true;
                    }
                } else {
                    m tabAt = tabAt(mVarArr7, i14);
                    if (tabAt == null) {
                        z7 = casTabAt(mVarArr7, i14, null, hVar2);
                        i8 = i13;
                        i9 = length2;
                        hVar = hVar2;
                        mVarArr6 = mVarArr7;
                        concurrentHashMap4 = concurrentHashMap5;
                    } else {
                        int i23 = tabAt.f50222a;
                        if (i23 == -1) {
                            concurrentHashMap2 = concurrentHashMap3;
                            i8 = i13;
                            i9 = length2;
                            hVar = hVar2;
                            mVarArr6 = mVarArr7;
                            concurrentHashMap4 = concurrentHashMap5;
                            z7 = true;
                        } else {
                            synchronized (tabAt) {
                                if (tabAt(mVarArr7, i14) == tabAt) {
                                    if (i23 >= 0) {
                                        int i24 = i23 & length;
                                        s sVar4 = tabAt;
                                        for (s sVar5 = tabAt.f50225d; sVar5 != null; sVar5 = sVar5.f50225d) {
                                            int i25 = sVar5.f50222a & length;
                                            if (i25 != i24) {
                                                sVar4 = sVar5;
                                                i24 = i25;
                                            }
                                        }
                                        if (i24 == 0) {
                                            sVar = sVar4;
                                        } else {
                                            sVar = null;
                                            sVar3 = sVar4;
                                        }
                                        m mVar = tabAt;
                                        while (mVar != sVar4) {
                                            int i26 = mVar.f50222a;
                                            int i27 = i13;
                                            Object obj = mVar.f50223b;
                                            int i28 = length2;
                                            Object obj2 = mVar.f50224c;
                                            if ((i26 & length) == 0) {
                                                sVar2 = sVar4;
                                                sVar = new m(i26, obj, obj2, sVar);
                                            } else {
                                                sVar2 = sVar4;
                                                sVar3 = new m(i26, obj, obj2, sVar3);
                                            }
                                            mVar = mVar.f50225d;
                                            i13 = i27;
                                            length2 = i28;
                                            sVar4 = sVar2;
                                        }
                                        i8 = i13;
                                        i9 = length2;
                                        setTabAt(mVarArr3, i14, sVar);
                                        setTabAt(mVarArr3, i10, sVar3);
                                        setTabAt(mVarArr7, i14, hVar2);
                                        hVar = hVar2;
                                    } else {
                                        i8 = i13;
                                        i9 = length2;
                                        if (tabAt instanceof r) {
                                            r rVar = (r) tabAt;
                                            s sVar6 = null;
                                            s sVar7 = null;
                                            m mVar2 = rVar.f50241f;
                                            int i29 = 0;
                                            int i30 = 0;
                                            s sVar8 = null;
                                            while (mVar2 != null) {
                                                r rVar2 = rVar;
                                                int i31 = mVar2.f50222a;
                                                h hVar3 = hVar2;
                                                s sVar9 = new s(i31, mVar2.f50223b, mVar2.f50224c, null, null);
                                                if ((i31 & length) == 0) {
                                                    sVar9.f50246h = sVar7;
                                                    if (sVar7 == null) {
                                                        sVar3 = sVar9;
                                                    } else {
                                                        sVar7.f50225d = sVar9;
                                                    }
                                                    i29++;
                                                    sVar7 = sVar9;
                                                } else {
                                                    sVar9.f50246h = sVar6;
                                                    if (sVar6 == null) {
                                                        sVar8 = sVar9;
                                                    } else {
                                                        sVar6.f50225d = sVar9;
                                                    }
                                                    i30++;
                                                    sVar6 = sVar9;
                                                }
                                                mVar2 = mVar2.f50225d;
                                                rVar = rVar2;
                                                hVar2 = hVar3;
                                            }
                                            r rVar3 = rVar;
                                            h hVar4 = hVar2;
                                            m untreeify = i29 <= 6 ? untreeify(sVar3) : i30 != 0 ? new r(sVar3) : rVar3;
                                            m untreeify2 = i30 <= 6 ? untreeify(sVar8) : i29 != 0 ? new r(sVar8) : rVar3;
                                            setTabAt(mVarArr3, i14, untreeify);
                                            setTabAt(mVarArr3, i10, untreeify2);
                                            hVar = hVar4;
                                            setTabAt(mVarArr, i14, hVar);
                                            mVarArr7 = mVarArr;
                                        }
                                    }
                                    z7 = true;
                                } else {
                                    i8 = i13;
                                    i9 = length2;
                                }
                                hVar = hVar2;
                            }
                            concurrentHashMap4 = this;
                            mVarArr6 = mVarArr7;
                        }
                    }
                    concurrentHashMap2 = this;
                }
                hVar2 = hVar;
                concurrentHashMap3 = concurrentHashMap2;
                i15 = i20;
                i13 = i8;
                length2 = i9;
            }
        }
    }

    private final void treeifyBin(m[] mVarArr, int i8) {
        if (mVarArr != null) {
            int length = mVarArr.length;
            if (length < 64) {
                tryPresize(length << 1);
                return;
            }
            m tabAt = tabAt(mVarArr, i8);
            if (tabAt == null || tabAt.f50222a < 0) {
                return;
            }
            synchronized (tabAt) {
                if (tabAt(mVarArr, i8) == tabAt) {
                    s sVar = null;
                    m mVar = tabAt;
                    s sVar2 = null;
                    while (mVar != null) {
                        s sVar3 = new s(mVar.f50222a, mVar.f50223b, mVar.f50224c, null, null);
                        sVar3.f50246h = sVar2;
                        if (sVar2 == null) {
                            sVar = sVar3;
                        } else {
                            sVar2.f50225d = sVar3;
                        }
                        mVar = mVar.f50225d;
                        sVar2 = sVar3;
                    }
                    setTabAt(mVarArr, i8, new r(sVar));
                }
            }
        }
    }

    private final void tryPresize(int i8) {
        int length;
        m[] mVarArr;
        int tableSizeFor = i8 >= 536870912 ? 1073741824 : tableSizeFor(i8 + (i8 >>> 1) + 1);
        while (true) {
            int i9 = this.sizeCtl;
            if (i9 < 0) {
                return;
            }
            m[] mVarArr2 = this.table;
            if (mVarArr2 == null || (length = mVarArr2.length) == 0) {
                int i10 = i9 > tableSizeFor ? i9 : tableSizeFor;
                if (U.compareAndSwapInt(this, SIZECTL, i9, -1)) {
                    try {
                        if (this.table == mVarArr2) {
                            this.table = new m[i10];
                            i9 = i10 - (i10 >>> 2);
                        }
                    } finally {
                        this.sizeCtl = i9;
                    }
                } else {
                    continue;
                }
            } else if (tableSizeFor <= i9 || length >= 1073741824) {
                return;
            } else {
                if (mVarArr2 == this.table) {
                    int resizeStamp = resizeStamp(length);
                    if (i9 < 0) {
                        if ((i9 >>> RESIZE_STAMP_SHIFT) != resizeStamp || i9 == resizeStamp + 1 || i9 == resizeStamp + MAX_RESIZERS || (mVarArr = this.nextTable) == null || this.transferIndex <= 0) {
                            return;
                        }
                        if (U.compareAndSwapInt(this, SIZECTL, i9, i9 + 1)) {
                            transfer(mVarArr2, mVarArr);
                        }
                    } else if (U.compareAndSwapInt(this, SIZECTL, i9, (resizeStamp << RESIZE_STAMP_SHIFT) + 2)) {
                        transfer(mVarArr2, null);
                    }
                } else {
                    continue;
                }
            }
        }
    }

    static <K, V> m untreeify(m mVar) {
        m mVar2 = null;
        m mVar3 = null;
        while (mVar != null) {
            m mVar4 = new m(mVar.f50222a, mVar.f50223b, mVar.f50224c, null);
            if (mVar3 == null) {
                mVar2 = mVar4;
            } else {
                mVar3.f50225d = mVar4;
            }
            mVar = mVar.f50225d;
            mVar3 = mVar4;
        }
        return mVar2;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        int i8 = 1;
        int i9 = 0;
        while (i8 < 16) {
            i9++;
            i8 <<= 1;
        }
        int i10 = 32 - i9;
        int i11 = i8 - 1;
        o[] oVarArr = new o[16];
        for (int i12 = 0; i12 < 16; i12++) {
            oVarArr[i12] = new o();
        }
        objectOutputStream.putFields().put("segments", oVarArr);
        objectOutputStream.putFields().put("segmentShift", i10);
        objectOutputStream.putFields().put("segmentMask", i11);
        objectOutputStream.writeFields();
        m[] mVarArr = this.table;
        if (mVarArr != null) {
            q qVar = new q(mVarArr, mVarArr.length, 0, mVarArr.length);
            while (true) {
                m e8 = qVar.e();
                if (e8 == null) {
                    break;
                }
                objectOutputStream.writeObject(e8.f50223b);
                objectOutputStream.writeObject(e8.f50224c);
            }
        }
        objectOutputStream.writeObject(null);
        objectOutputStream.writeObject(null);
    }

    @Override // java.util.AbstractMap, java.util.Map, j$.util.Map
    public void clear() {
        m tabAt;
        m[] mVarArr = this.table;
        long j8 = 0;
        loop0: while (true) {
            int i8 = 0;
            while (mVarArr != null && i8 < mVarArr.length) {
                tabAt = tabAt(mVarArr, i8);
                if (tabAt == null) {
                    i8++;
                } else {
                    int i9 = tabAt.f50222a;
                    if (i9 == -1) {
                        break;
                    }
                    synchronized (tabAt) {
                        if (tabAt(mVarArr, i8) == tabAt) {
                            for (m mVar = i9 >= 0 ? tabAt : tabAt instanceof r ? ((r) tabAt).f50241f : null; mVar != null; mVar = mVar.f50225d) {
                                j8--;
                            }
                            setTabAt(mVarArr, i8, null);
                            i8++;
                        }
                    }
                }
            }
            mVarArr = helpTransfer(mVarArr, tabAt);
        }
        if (j8 != 0) {
            addCount(j8, -1);
        }
    }

    @Override // j$.util.Map
    public V compute(K k8, BiFunction<? super K, ? super V, ? extends V> biFunction) {
        int i8;
        m mVar;
        V v7;
        Object obj;
        if (k8 == null || biFunction == null) {
            throw null;
        }
        int spread = spread(k8.hashCode());
        m[] mVarArr = this.table;
        int i9 = 0;
        V v8 = null;
        int i10 = 0;
        while (true) {
            if (mVarArr != null) {
                int length = mVarArr.length;
                if (length != 0) {
                    int i11 = (length - 1) & spread;
                    m tabAt = tabAt(mVarArr, i11);
                    if (tabAt == null) {
                        n nVar = new n();
                        synchronized (nVar) {
                            if (casTabAt(mVarArr, i11, null, nVar)) {
                                V apply = biFunction.apply(k8, null);
                                if (apply != null) {
                                    mVar = new m(spread, k8, apply, null);
                                    i8 = 1;
                                } else {
                                    i8 = i10;
                                    mVar = null;
                                }
                                setTabAt(mVarArr, i11, mVar);
                                i10 = i8;
                                v8 = apply;
                                i9 = 1;
                            }
                        }
                        if (i9 != 0) {
                            break;
                        }
                    } else {
                        int i12 = tabAt.f50222a;
                        if (i12 == -1) {
                            mVarArr = helpTransfer(mVarArr, tabAt);
                        } else {
                            synchronized (tabAt) {
                                if (tabAt(mVarArr, i11) == tabAt) {
                                    if (i12 >= 0) {
                                        m mVar2 = null;
                                        m mVar3 = tabAt;
                                        i9 = 1;
                                        while (true) {
                                            if (mVar3.f50222a != spread || ((obj = mVar3.f50223b) != k8 && (obj == null || !k8.equals(obj)))) {
                                                m mVar4 = mVar3.f50225d;
                                                if (mVar4 == null) {
                                                    V apply2 = biFunction.apply(k8, null);
                                                    if (apply2 != null) {
                                                        mVar3.f50225d = new m(spread, k8, apply2, null);
                                                        v7 = apply2;
                                                        i10 = 1;
                                                    } else {
                                                        v7 = apply2;
                                                    }
                                                } else {
                                                    i9++;
                                                    mVar2 = mVar3;
                                                    mVar3 = mVar4;
                                                }
                                            }
                                        }
                                        v7 = biFunction.apply(k8, (Object) mVar3.f50224c);
                                        if (v7 != null) {
                                            mVar3.f50224c = v7;
                                        } else {
                                            m mVar5 = mVar3.f50225d;
                                            if (mVar2 != null) {
                                                mVar2.f50225d = mVar5;
                                            } else {
                                                setTabAt(mVarArr, i11, mVar5);
                                            }
                                            i10 = -1;
                                        }
                                        v8 = v7;
                                    } else if (tabAt instanceof r) {
                                        r rVar = (r) tabAt;
                                        s sVar = rVar.f50240e;
                                        s b8 = sVar != null ? sVar.b(spread, k8, null) : null;
                                        V apply3 = biFunction.apply(k8, b8 == null ? (Object) null : (Object) b8.f50224c);
                                        if (apply3 == null) {
                                            if (b8 != null) {
                                                if (rVar.g(b8)) {
                                                    setTabAt(mVarArr, i11, untreeify(rVar.f50241f));
                                                }
                                                v8 = apply3;
                                                i9 = 1;
                                                i10 = -1;
                                            }
                                            v8 = apply3;
                                            i9 = 1;
                                        } else if (b8 != null) {
                                            b8.f50224c = apply3;
                                            v8 = apply3;
                                            i9 = 1;
                                        } else {
                                            rVar.f(spread, k8, apply3);
                                            v8 = apply3;
                                            i9 = 1;
                                            i10 = 1;
                                        }
                                    }
                                }
                            }
                            if (i9 != 0) {
                                if (i9 >= 8) {
                                    treeifyBin(mVarArr, i11);
                                }
                            }
                        }
                    }
                }
            }
            mVarArr = initTable();
        }
        if (i10 != 0) {
            addCount(i10, i9);
        }
        return v8;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public /* synthetic */ Object compute(Object obj, java.util.function.BiFunction biFunction) {
        return compute((ConcurrentHashMap<K, V>) obj, (BiFunction<? super ConcurrentHashMap<K, V>, ? super V, ? extends V>) BiFunction.VivifiedWrapper.convert(biFunction));
    }

    @Override // j$.util.concurrent.v, j$.util.Map
    public V computeIfAbsent(K k8, Function<? super K, ? extends V> function) {
        s b8;
        Object obj;
        Object obj2;
        Object obj3;
        if (k8 == null || function == null) {
            throw null;
        }
        int spread = spread(k8.hashCode());
        m[] mVarArr = this.table;
        V v7 = null;
        int i8 = 0;
        while (true) {
            if (mVarArr != null) {
                int length = mVarArr.length;
                if (length != 0) {
                    int i9 = (length - 1) & spread;
                    m tabAt = tabAt(mVarArr, i9);
                    boolean z7 = true;
                    if (tabAt == null) {
                        n nVar = new n();
                        synchronized (nVar) {
                            if (casTabAt(mVarArr, i9, null, nVar)) {
                                V apply = function.apply(k8);
                                setTabAt(mVarArr, i9, apply != null ? new m(spread, k8, apply, null) : null);
                                v7 = apply;
                                i8 = 1;
                            }
                        }
                        if (i8 != 0) {
                            break;
                        }
                    } else {
                        int i10 = tabAt.f50222a;
                        if (i10 == -1) {
                            mVarArr = helpTransfer(mVarArr, tabAt);
                        } else {
                            synchronized (tabAt) {
                                if (tabAt(mVarArr, i9) == tabAt) {
                                    if (i10 >= 0) {
                                        m mVar = tabAt;
                                        int i11 = 1;
                                        while (true) {
                                            if (mVar.f50222a != spread || ((obj3 = mVar.f50223b) != k8 && (obj3 == null || !k8.equals(obj3)))) {
                                                m mVar2 = mVar.f50225d;
                                                if (mVar2 == null) {
                                                    Object apply2 = function.apply(k8);
                                                    if (apply2 != null) {
                                                        mVar.f50225d = new m(spread, k8, apply2, null);
                                                        obj2 = apply2;
                                                    } else {
                                                        obj = apply2;
                                                    }
                                                } else {
                                                    i11++;
                                                    mVar = mVar2;
                                                }
                                            }
                                        }
                                        obj = mVar.f50224c;
                                        z7 = false;
                                        obj2 = obj;
                                        int i12 = i11;
                                        v7 = (V) obj2;
                                        i8 = i12;
                                    } else if (tabAt instanceof r) {
                                        i8 = 2;
                                        r rVar = (r) tabAt;
                                        s sVar = rVar.f50240e;
                                        if (sVar == null || (b8 = sVar.b(spread, k8, null)) == null) {
                                            V apply3 = function.apply(k8);
                                            if (apply3 != null) {
                                                rVar.f(spread, k8, apply3);
                                                v7 = apply3;
                                            } else {
                                                v7 = apply3;
                                            }
                                        } else {
                                            v7 = (V) b8.f50224c;
                                        }
                                    }
                                }
                                z7 = false;
                            }
                            if (i8 != 0) {
                                if (i8 >= 8) {
                                    treeifyBin(mVarArr, i9);
                                }
                                if (!z7) {
                                    return v7;
                                }
                            }
                        }
                    }
                }
            }
            mVarArr = initTable();
        }
        if (v7 != null) {
            addCount(1L, i8);
        }
        return v7;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public /* synthetic */ Object computeIfAbsent(Object obj, java.util.function.Function function) {
        return computeIfAbsent((ConcurrentHashMap<K, V>) obj, (Function<? super ConcurrentHashMap<K, V>, ? extends V>) Function.VivifiedWrapper.convert(function));
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x004a, code lost:
        r5 = r15.apply(r14, (java.lang.Object) r8.f50224c);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0050, code lost:
        if (r5 == null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0052, code lost:
        r8.f50224c = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0055, code lost:
        r3 = r8.f50225d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0057, code lost:
        if (r10 == null) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0059, code lost:
        r10.f50225d = r3;
     */
    @Override // j$.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public V computeIfPresent(K r14, j$.util.function.BiFunction<? super K, ? super V, ? extends V> r15) {
        /*
            r13 = this;
            r0 = 0
            if (r14 == 0) goto La7
            if (r15 == 0) goto La7
            int r1 = r14.hashCode()
            int r1 = spread(r1)
            j$.util.concurrent.m[] r2 = r13.table
            r3 = 0
            r5 = r0
            r4 = 0
        L12:
            if (r2 == 0) goto La1
            int r6 = r2.length
            if (r6 != 0) goto L19
            goto La1
        L19:
            int r6 = r6 + (-1)
            r6 = r6 & r1
            j$.util.concurrent.m r7 = tabAt(r2, r6)
            if (r7 != 0) goto L24
            goto L97
        L24:
            int r8 = r7.f50222a
            r9 = -1
            if (r8 != r9) goto L2e
            j$.util.concurrent.m[] r2 = r13.helpTransfer(r2, r7)
            goto L12
        L2e:
            monitor-enter(r7)
            j$.util.concurrent.m r10 = tabAt(r2, r6)     // Catch: java.lang.Throwable -> L9e
            if (r10 != r7) goto L94
            if (r8 < 0) goto L67
            r4 = 1
            r10 = r0
            r8 = r7
        L3a:
            int r11 = r8.f50222a     // Catch: java.lang.Throwable -> L9e
            if (r11 != r1) goto L5c
            java.lang.Object r11 = r8.f50223b     // Catch: java.lang.Throwable -> L9e
            if (r11 == r14) goto L4a
            if (r11 == 0) goto L5c
            boolean r11 = r14.equals(r11)     // Catch: java.lang.Throwable -> L9e
            if (r11 == 0) goto L5c
        L4a:
            java.lang.Object r5 = r8.f50224c     // Catch: java.lang.Throwable -> L9e
            java.lang.Object r5 = r15.apply(r14, r5)     // Catch: java.lang.Throwable -> L9e
            if (r5 == 0) goto L55
            r8.f50224c = r5     // Catch: java.lang.Throwable -> L9e
            goto L94
        L55:
            j$.util.concurrent.m r3 = r8.f50225d     // Catch: java.lang.Throwable -> L9e
            if (r10 == 0) goto L90
            r10.f50225d = r3     // Catch: java.lang.Throwable -> L9e
            goto L93
        L5c:
            j$.util.concurrent.m r10 = r8.f50225d     // Catch: java.lang.Throwable -> L9e
            if (r10 != 0) goto L61
            goto L94
        L61:
            int r4 = r4 + 1
            r12 = r10
            r10 = r8
            r8 = r12
            goto L3a
        L67:
            boolean r8 = r7 instanceof j$.util.concurrent.r     // Catch: java.lang.Throwable -> L9e
            if (r8 == 0) goto L94
            r4 = 2
            r8 = r7
            j$.util.concurrent.r r8 = (j$.util.concurrent.r) r8     // Catch: java.lang.Throwable -> L9e
            j$.util.concurrent.s r10 = r8.f50240e     // Catch: java.lang.Throwable -> L9e
            if (r10 == 0) goto L94
            j$.util.concurrent.s r10 = r10.b(r1, r14, r0)     // Catch: java.lang.Throwable -> L9e
            if (r10 == 0) goto L94
            java.lang.Object r5 = r10.f50224c     // Catch: java.lang.Throwable -> L9e
            java.lang.Object r5 = r15.apply(r14, r5)     // Catch: java.lang.Throwable -> L9e
            if (r5 == 0) goto L84
            r10.f50224c = r5     // Catch: java.lang.Throwable -> L9e
            goto L94
        L84:
            boolean r3 = r8.g(r10)     // Catch: java.lang.Throwable -> L9e
            if (r3 == 0) goto L93
            j$.util.concurrent.s r3 = r8.f50241f     // Catch: java.lang.Throwable -> L9e
            j$.util.concurrent.m r3 = untreeify(r3)     // Catch: java.lang.Throwable -> L9e
        L90:
            setTabAt(r2, r6, r3)     // Catch: java.lang.Throwable -> L9e
        L93:
            r3 = -1
        L94:
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L9e
            if (r4 == 0) goto L12
        L97:
            if (r3 == 0) goto L9d
            long r14 = (long) r3
            r13.addCount(r14, r4)
        L9d:
            return r5
        L9e:
            r14 = move-exception
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L9e
            throw r14
        La1:
            j$.util.concurrent.m[] r2 = r13.initTable()
            goto L12
        La7:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.ConcurrentHashMap.computeIfPresent(java.lang.Object, j$.util.function.BiFunction):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public /* synthetic */ Object computeIfPresent(Object obj, java.util.function.BiFunction biFunction) {
        return computeIfPresent((ConcurrentHashMap<K, V>) obj, (BiFunction<? super ConcurrentHashMap<K, V>, ? super V, ? extends V>) BiFunction.VivifiedWrapper.convert(biFunction));
    }

    public boolean contains(Object obj) {
        return containsValue(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map, j$.util.Map
    public boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map, j$.util.Map
    public boolean containsValue(Object obj) {
        obj.getClass();
        m[] mVarArr = this.table;
        if (mVarArr != null) {
            q qVar = new q(mVarArr, mVarArr.length, 0, mVarArr.length);
            while (true) {
                m e8 = qVar.e();
                if (e8 == null) {
                    break;
                }
                Object obj2 = e8.f50224c;
                if (obj2 == obj) {
                    return true;
                }
                if (obj2 != null && obj.equals(obj2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public Enumeration<V> elements() {
        m[] mVarArr = this.table;
        int length = mVarArr == null ? 0 : mVarArr.length;
        return new i(mVarArr, length, length, this, 1);
    }

    @Override // java.util.AbstractMap, java.util.Map, j$.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        f fVar = this.entrySet;
        if (fVar != null) {
            return fVar;
        }
        f fVar2 = new f(this);
        this.entrySet = fVar2;
        return fVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map, j$.util.Map
    public boolean equals(Object obj) {
        V value;
        V v7;
        if (obj != this) {
            if (obj instanceof Map) {
                Map map = (Map) obj;
                m[] mVarArr = this.table;
                int length = mVarArr == null ? 0 : mVarArr.length;
                q qVar = new q(mVarArr, length, 0, length);
                while (true) {
                    m e8 = qVar.e();
                    if (e8 == null) {
                        for (Map.Entry<K, V> entry : map.entrySet()) {
                            K key = entry.getKey();
                            if (key == null || (value = entry.getValue()) == null || (v7 = get(key)) == null || (value != v7 && !value.equals(v7))) {
                                return false;
                            }
                        }
                        return true;
                    }
                    Object obj2 = e8.f50224c;
                    Object obj3 = map.get(e8.f50223b);
                    if (obj3 == null || (obj3 != obj2 && !obj3.equals(obj2))) {
                        break;
                    }
                }
                return false;
            }
            return false;
        }
        return true;
    }

    @Override // j$.util.concurrent.v, j$.util.Map
    public void forEach(BiConsumer<? super K, ? super V> biConsumer) {
        biConsumer.getClass();
        m[] mVarArr = this.table;
        if (mVarArr == null) {
            return;
        }
        q qVar = new q(mVarArr, mVarArr.length, 0, mVarArr.length);
        while (true) {
            m e8 = qVar.e();
            if (e8 == null) {
                return;
            }
            biConsumer.accept((Object) e8.f50223b, (Object) e8.f50224c);
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public /* synthetic */ void forEach(java.util.function.BiConsumer biConsumer) {
        forEach(BiConsumer.VivifiedWrapper.convert(biConsumer));
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x004d, code lost:
        return (V) r1.f50224c;
     */
    @Override // java.util.AbstractMap, java.util.Map, j$.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public V get(java.lang.Object r5) {
        /*
            r4 = this;
            int r0 = r5.hashCode()
            int r0 = spread(r0)
            j$.util.concurrent.m[] r1 = r4.table
            r2 = 0
            if (r1 == 0) goto L4e
            int r3 = r1.length
            if (r3 <= 0) goto L4e
            int r3 = r3 + (-1)
            r3 = r3 & r0
            j$.util.concurrent.m r1 = tabAt(r1, r3)
            if (r1 == 0) goto L4e
            int r3 = r1.f50222a
            if (r3 != r0) goto L2c
            java.lang.Object r3 = r1.f50223b
            if (r3 == r5) goto L29
            if (r3 == 0) goto L37
            boolean r3 = r5.equals(r3)
            if (r3 == 0) goto L37
        L29:
            java.lang.Object r5 = r1.f50224c
            return r5
        L2c:
            if (r3 >= 0) goto L37
            j$.util.concurrent.m r5 = r1.a(r0, r5)
            if (r5 == 0) goto L36
            java.lang.Object r2 = r5.f50224c
        L36:
            return r2
        L37:
            j$.util.concurrent.m r1 = r1.f50225d
            if (r1 == 0) goto L4e
            int r3 = r1.f50222a
            if (r3 != r0) goto L37
            java.lang.Object r3 = r1.f50223b
            if (r3 == r5) goto L4b
            if (r3 == 0) goto L37
            boolean r3 = r5.equals(r3)
            if (r3 == 0) goto L37
        L4b:
            java.lang.Object r5 = r1.f50224c
            return r5
        L4e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.ConcurrentHashMap.get(java.lang.Object):java.lang.Object");
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.Map
    public V getOrDefault(Object obj, V v7) {
        V v8 = get(obj);
        return v8 == null ? v7 : v8;
    }

    @Override // java.util.AbstractMap, java.util.Map, j$.util.Map
    public int hashCode() {
        m[] mVarArr = this.table;
        int i8 = 0;
        if (mVarArr != null) {
            q qVar = new q(mVarArr, mVarArr.length, 0, mVarArr.length);
            while (true) {
                m e8 = qVar.e();
                if (e8 == null) {
                    break;
                }
                i8 += e8.f50224c.hashCode() ^ e8.f50223b.hashCode();
            }
        }
        return i8;
    }

    final m[] helpTransfer(m[] mVarArr, m mVar) {
        m[] mVarArr2;
        int i8;
        if (mVarArr == null || !(mVar instanceof h) || (mVarArr2 = ((h) mVar).f50215e) == null) {
            return this.table;
        }
        int resizeStamp = resizeStamp(mVarArr.length);
        while (true) {
            if (mVarArr2 != this.nextTable || this.table != mVarArr || (i8 = this.sizeCtl) >= 0 || (i8 >>> RESIZE_STAMP_SHIFT) != resizeStamp || i8 == resizeStamp + 1 || i8 == MAX_RESIZERS + resizeStamp || this.transferIndex <= 0) {
                break;
            } else if (U.compareAndSwapInt(this, SIZECTL, i8, i8 + 1)) {
                transfer(mVarArr, mVarArr2);
                break;
            }
        }
        return mVarArr2;
    }

    @Override // java.util.AbstractMap, java.util.Map, j$.util.Map
    public boolean isEmpty() {
        return sumCount() <= 0;
    }

    @Override // java.util.AbstractMap, java.util.Map, j$.util.Map
    public Set<K> keySet() {
        j jVar = this.keySet;
        if (jVar != null) {
            return jVar;
        }
        j jVar2 = new j(this);
        this.keySet = jVar2;
        return jVar2;
    }

    public Enumeration<K> keys() {
        m[] mVarArr = this.table;
        int length = mVarArr == null ? 0 : mVarArr.length;
        return new i(mVarArr, length, length, this, 0);
    }

    public long mappingCount() {
        long sumCount = sumCount();
        if (sumCount < 0) {
            return 0L;
        }
        return sumCount;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v2 */
    @Override // j$.util.Map
    public V merge(K k8, V v7, BiFunction<? super V, ? super V, ? extends V> biFunction) {
        int i8;
        V v8;
        Object obj;
        V v9 = v7;
        if (k8 == null || v9 == null || biFunction == null) {
            throw null;
        }
        int spread = spread(k8.hashCode());
        m[] mVarArr = this.table;
        int i9 = 0;
        V v10 = null;
        int i10 = 0;
        while (true) {
            if (mVarArr != null) {
                int length = mVarArr.length;
                if (length != 0) {
                    int i11 = (length - 1) & spread;
                    m tabAt = tabAt(mVarArr, i11);
                    i8 = 1;
                    if (tabAt != null) {
                        int i12 = tabAt.f50222a;
                        if (i12 == -1) {
                            mVarArr = helpTransfer(mVarArr, tabAt);
                        } else {
                            synchronized (tabAt) {
                                if (tabAt(mVarArr, i11) == tabAt) {
                                    if (i12 >= 0) {
                                        m mVar = null;
                                        m mVar2 = tabAt;
                                        int i13 = 1;
                                        while (true) {
                                            if (mVar2.f50222a != spread || ((obj = mVar2.f50223b) != k8 && (obj == null || !k8.equals(obj)))) {
                                                m mVar3 = mVar2.f50225d;
                                                if (mVar3 == null) {
                                                    mVar2.f50225d = new m(spread, k8, v9, null);
                                                    v8 = v9;
                                                    i10 = 1;
                                                    break;
                                                }
                                                i13++;
                                                mVar = mVar2;
                                                mVar2 = mVar3;
                                            }
                                        }
                                        v8 = biFunction.apply((Object) mVar2.f50224c, v9);
                                        if (v8 != null) {
                                            mVar2.f50224c = v8;
                                        } else {
                                            m mVar4 = mVar2.f50225d;
                                            if (mVar != null) {
                                                mVar.f50225d = mVar4;
                                            } else {
                                                setTabAt(mVarArr, i11, mVar4);
                                            }
                                            i10 = -1;
                                        }
                                        i9 = i13;
                                        v10 = v8;
                                    } else if (tabAt instanceof r) {
                                        i9 = 2;
                                        r rVar = (r) tabAt;
                                        s sVar = rVar.f50240e;
                                        s b8 = sVar == null ? null : sVar.b(spread, k8, null);
                                        V apply = b8 == null ? v9 : biFunction.apply((Object) b8.f50224c, v9);
                                        if (apply == null) {
                                            if (b8 != null) {
                                                if (rVar.g(b8)) {
                                                    setTabAt(mVarArr, i11, untreeify(rVar.f50241f));
                                                }
                                                v10 = apply;
                                                i10 = -1;
                                            }
                                            v10 = apply;
                                        } else if (b8 != null) {
                                            b8.f50224c = apply;
                                            v10 = apply;
                                        } else {
                                            rVar.f(spread, k8, apply);
                                            v10 = apply;
                                            i10 = 1;
                                        }
                                    }
                                }
                            }
                            if (i9 != 0) {
                                if (i9 >= 8) {
                                    treeifyBin(mVarArr, i11);
                                }
                                i8 = i10;
                                v9 = v10;
                            }
                        }
                    } else if (casTabAt(mVarArr, i11, null, new m(spread, k8, v9, null))) {
                        break;
                    }
                }
            }
            mVarArr = initTable();
        }
        if (i8 != 0) {
            addCount(i8, i9);
        }
        return v9;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public /* synthetic */ Object merge(Object obj, Object obj2, java.util.function.BiFunction biFunction) {
        return merge((ConcurrentHashMap<K, V>) obj, obj2, BiFunction.VivifiedWrapper.convert(biFunction));
    }

    @Override // java.util.AbstractMap, java.util.Map, j$.util.Map
    public V put(K k8, V v7) {
        return putVal(k8, v7, false);
    }

    @Override // java.util.AbstractMap, java.util.Map, j$.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        tryPresize(map.size());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            putVal(entry.getKey(), entry.getValue(), false);
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.Map
    public V putIfAbsent(K k8, V v7) {
        return putVal(k8, v7, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0053, code lost:
        if (r11 == false) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final V putVal(K r9, V r10, boolean r11) {
        /*
            r8 = this;
            r0 = 0
            if (r9 == 0) goto L98
            if (r10 == 0) goto L98
            int r1 = r9.hashCode()
            int r1 = spread(r1)
            r2 = 0
            j$.util.concurrent.m[] r3 = r8.table
        L10:
            if (r3 == 0) goto L92
            int r4 = r3.length
            if (r4 != 0) goto L17
            goto L92
        L17:
            int r4 = r4 + (-1)
            r4 = r4 & r1
            j$.util.concurrent.m r5 = tabAt(r3, r4)
            if (r5 != 0) goto L2c
            j$.util.concurrent.m r5 = new j$.util.concurrent.m
            r5.<init>(r1, r9, r10, r0)
            boolean r4 = casTabAt(r3, r4, r0, r5)
            if (r4 == 0) goto L10
            goto L89
        L2c:
            int r6 = r5.f50222a
            r7 = -1
            if (r6 != r7) goto L36
            j$.util.concurrent.m[] r3 = r8.helpTransfer(r3, r5)
            goto L10
        L36:
            monitor-enter(r5)
            j$.util.concurrent.m r7 = tabAt(r3, r4)     // Catch: java.lang.Throwable -> L8f
            if (r7 != r5) goto L7b
            if (r6 < 0) goto L68
            r2 = 1
            r6 = r5
        L41:
            int r7 = r6.f50222a     // Catch: java.lang.Throwable -> L8f
            if (r7 != r1) goto L58
            java.lang.Object r7 = r6.f50223b     // Catch: java.lang.Throwable -> L8f
            if (r7 == r9) goto L51
            if (r7 == 0) goto L58
            boolean r7 = r9.equals(r7)     // Catch: java.lang.Throwable -> L8f
            if (r7 == 0) goto L58
        L51:
            java.lang.Object r7 = r6.f50224c     // Catch: java.lang.Throwable -> L8f
            if (r11 != 0) goto L7c
        L55:
            r6.f50224c = r10     // Catch: java.lang.Throwable -> L8f
            goto L7c
        L58:
            j$.util.concurrent.m r7 = r6.f50225d     // Catch: java.lang.Throwable -> L8f
            if (r7 != 0) goto L64
            j$.util.concurrent.m r7 = new j$.util.concurrent.m     // Catch: java.lang.Throwable -> L8f
            r7.<init>(r1, r9, r10, r0)     // Catch: java.lang.Throwable -> L8f
            r6.f50225d = r7     // Catch: java.lang.Throwable -> L8f
            goto L7b
        L64:
            int r2 = r2 + 1
            r6 = r7
            goto L41
        L68:
            boolean r6 = r5 instanceof j$.util.concurrent.r     // Catch: java.lang.Throwable -> L8f
            if (r6 == 0) goto L7b
            r2 = 2
            r6 = r5
            j$.util.concurrent.r r6 = (j$.util.concurrent.r) r6     // Catch: java.lang.Throwable -> L8f
            j$.util.concurrent.s r6 = r6.f(r1, r9, r10)     // Catch: java.lang.Throwable -> L8f
            if (r6 == 0) goto L7b
            java.lang.Object r7 = r6.f50224c     // Catch: java.lang.Throwable -> L8f
            if (r11 != 0) goto L7c
            goto L55
        L7b:
            r7 = r0
        L7c:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L8f
            if (r2 == 0) goto L10
            r9 = 8
            if (r2 < r9) goto L86
            r8.treeifyBin(r3, r4)
        L86:
            if (r7 == 0) goto L89
            return r7
        L89:
            r9 = 1
            r8.addCount(r9, r2)
            return r0
        L8f:
            r9 = move-exception
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L8f
            throw r9
        L92:
            j$.util.concurrent.m[] r3 = r8.initTable()
            goto L10
        L98:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.ConcurrentHashMap.putVal(java.lang.Object, java.lang.Object, boolean):java.lang.Object");
    }

    @Override // java.util.AbstractMap, java.util.Map, j$.util.Map
    public V remove(Object obj) {
        return replaceNode(obj, null, null);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.Map
    public boolean remove(Object obj, Object obj2) {
        obj.getClass();
        return (obj2 == null || replaceNode(obj, null, obj2) == null) ? false : true;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.Map
    public V replace(K k8, V v7) {
        if (k8 == null || v7 == null) {
            throw null;
        }
        return replaceNode(k8, v7, null);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.Map
    public boolean replace(K k8, V v7, V v8) {
        if (k8 == null || v7 == null || v8 == null) {
            throw null;
        }
        return replaceNode(k8, v8, v7) != null;
    }

    @Override // j$.util.Map
    public void replaceAll(BiFunction<? super K, ? super V, ? extends V> biFunction) {
        biFunction.getClass();
        m[] mVarArr = this.table;
        if (mVarArr == null) {
            return;
        }
        q qVar = new q(mVarArr, mVarArr.length, 0, mVarArr.length);
        while (true) {
            m e8 = qVar.e();
            if (e8 == null) {
                return;
            }
            V v7 = (Object) e8.f50224c;
            Object obj = (Object) e8.f50223b;
            do {
                V apply = biFunction.apply(obj, v7);
                apply.getClass();
                if (replaceNode(obj, apply, v7) == null) {
                    v7 = get(obj);
                }
            } while (v7 != null);
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public /* synthetic */ void replaceAll(java.util.function.BiFunction biFunction) {
        replaceAll(BiFunction.VivifiedWrapper.convert(biFunction));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final V replaceNode(Object obj, V v7, Object obj2) {
        int length;
        int i8;
        m tabAt;
        V v8;
        s b8;
        m untreeify;
        Object obj3;
        int spread = spread(obj.hashCode());
        m[] mVarArr = this.table;
        while (true) {
            if (mVarArr == null || (length = mVarArr.length) == 0 || (tabAt = tabAt(mVarArr, (i8 = (length - 1) & spread))) == null) {
                break;
            }
            int i9 = tabAt.f50222a;
            if (i9 == -1) {
                mVarArr = helpTransfer(mVarArr, tabAt);
            } else {
                boolean z7 = false;
                synchronized (tabAt) {
                    if (tabAt(mVarArr, i8) == tabAt) {
                        if (i9 >= 0) {
                            m mVar = null;
                            m mVar2 = tabAt;
                            while (true) {
                                if (mVar2.f50222a != spread || ((obj3 = mVar2.f50223b) != obj && (obj3 == null || !obj.equals(obj3)))) {
                                    m mVar3 = mVar2.f50225d;
                                    if (mVar3 == null) {
                                        break;
                                    }
                                    mVar = mVar2;
                                    mVar2 = mVar3;
                                }
                            }
                            v8 = (V) mVar2.f50224c;
                            if (obj2 == null || obj2 == v8 || (v8 != null && obj2.equals(v8))) {
                                if (v7 != null) {
                                    mVar2.f50224c = v7;
                                } else if (mVar != null) {
                                    mVar.f50225d = mVar2.f50225d;
                                } else {
                                    untreeify = mVar2.f50225d;
                                    setTabAt(mVarArr, i8, untreeify);
                                }
                                z7 = true;
                            }
                            v8 = (V) null;
                            z7 = true;
                        } else if (tabAt instanceof r) {
                            r rVar = (r) tabAt;
                            s sVar = rVar.f50240e;
                            if (sVar != null && (b8 = sVar.b(spread, obj, null)) != null) {
                                v8 = b8.f50224c;
                                if (obj2 == null || obj2 == v8 || (v8 != null && obj2.equals(v8))) {
                                    if (v7 != null) {
                                        b8.f50224c = v7;
                                    } else if (rVar.g(b8)) {
                                        untreeify = untreeify(rVar.f50241f);
                                        setTabAt(mVarArr, i8, untreeify);
                                    }
                                    z7 = true;
                                }
                            }
                            v8 = (V) null;
                            z7 = true;
                        }
                    }
                    v8 = null;
                }
                if (z7) {
                    if (v8 != null) {
                        if (v7 == null) {
                            addCount(-1L, -1);
                        }
                        return v8;
                    }
                }
            }
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map, j$.util.Map
    public int size() {
        long sumCount = sumCount();
        if (sumCount < 0) {
            return 0;
        }
        if (sumCount > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) sumCount;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long sumCount() {
        d[] dVarArr = this.counterCells;
        long j8 = this.baseCount;
        if (dVarArr != null) {
            for (d dVar : dVarArr) {
                if (dVar != null) {
                    j8 += dVar.value;
                }
            }
        }
        return j8;
    }

    @Override // java.util.AbstractMap
    public String toString() {
        m[] mVarArr = this.table;
        int length = mVarArr == null ? 0 : mVarArr.length;
        q qVar = new q(mVarArr, length, 0, length);
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        m e8 = qVar.e();
        if (e8 != null) {
            while (true) {
                Object obj = e8.f50223b;
                Object obj2 = e8.f50224c;
                if (obj == this) {
                    obj = "(this Map)";
                }
                sb.append(obj);
                sb.append('=');
                if (obj2 == this) {
                    obj2 = "(this Map)";
                }
                sb.append(obj2);
                e8 = qVar.e();
                if (e8 == null) {
                    break;
                }
                sb.append(',');
                sb.append(' ');
            }
        }
        sb.append('}');
        return sb.toString();
    }

    @Override // java.util.AbstractMap, java.util.Map, j$.util.Map
    public Collection<V> values() {
        t tVar = this.values;
        if (tVar != null) {
            return tVar;
        }
        t tVar2 = new t(this);
        this.values = tVar2;
        return tVar2;
    }
}
