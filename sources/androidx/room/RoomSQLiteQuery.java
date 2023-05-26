package androidx.room;

import androidx.sqlite.db.SupportSQLiteProgram;
import androidx.sqlite.db.SupportSQLiteQuery;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes.dex */
public class RoomSQLiteQuery implements SupportSQLiteQuery, SupportSQLiteProgram {

    /* renamed from: n  reason: collision with root package name */
    static final TreeMap<Integer, RoomSQLiteQuery> f7588n = new TreeMap<>();

    /* renamed from: f  reason: collision with root package name */
    private volatile String f7589f;

    /* renamed from: g  reason: collision with root package name */
    final long[] f7590g;

    /* renamed from: h  reason: collision with root package name */
    final double[] f7591h;

    /* renamed from: i  reason: collision with root package name */
    final String[] f7592i;

    /* renamed from: j  reason: collision with root package name */
    final byte[][] f7593j;

    /* renamed from: k  reason: collision with root package name */
    private final int[] f7594k;

    /* renamed from: l  reason: collision with root package name */
    final int f7595l;

    /* renamed from: m  reason: collision with root package name */
    int f7596m;

    private RoomSQLiteQuery(int i8) {
        this.f7595l = i8;
        int i9 = i8 + 1;
        this.f7594k = new int[i9];
        this.f7590g = new long[i9];
        this.f7591h = new double[i9];
        this.f7592i = new String[i9];
        this.f7593j = new byte[i9];
    }

    public static RoomSQLiteQuery e(String str, int i8) {
        TreeMap<Integer, RoomSQLiteQuery> treeMap = f7588n;
        synchronized (treeMap) {
            Map.Entry<Integer, RoomSQLiteQuery> ceilingEntry = treeMap.ceilingEntry(Integer.valueOf(i8));
            if (ceilingEntry != null) {
                treeMap.remove(ceilingEntry.getKey());
                RoomSQLiteQuery value = ceilingEntry.getValue();
                value.g(str, i8);
                return value;
            }
            RoomSQLiteQuery roomSQLiteQuery = new RoomSQLiteQuery(i8);
            roomSQLiteQuery.g(str, i8);
            return roomSQLiteQuery;
        }
    }

    private static void h() {
        TreeMap<Integer, RoomSQLiteQuery> treeMap = f7588n;
        if (treeMap.size() > 15) {
            int size = treeMap.size() - 10;
            Iterator<Integer> it = treeMap.descendingKeySet().iterator();
            while (true) {
                int i8 = size - 1;
                if (size > 0) {
                    it.next();
                    it.remove();
                    size = i8;
                } else {
                    return;
                }
            }
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void B0(int i8, long j8) {
        this.f7594k[i8] = 2;
        this.f7590g[i8] = j8;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void F0(int i8, byte[] bArr) {
        this.f7594k[i8] = 5;
        this.f7593j[i8] = bArr;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void Q0(int i8) {
        this.f7594k[i8] = 1;
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public String a() {
        return this.f7589f;
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public void c(SupportSQLiteProgram supportSQLiteProgram) {
        for (int i8 = 1; i8 <= this.f7596m; i8++) {
            int i9 = this.f7594k[i8];
            if (i9 != 1) {
                if (i9 != 2) {
                    if (i9 != 3) {
                        if (i9 != 4) {
                            if (i9 == 5) {
                                supportSQLiteProgram.F0(i8, this.f7593j[i8]);
                            }
                        } else {
                            supportSQLiteProgram.q0(i8, this.f7592i[i8]);
                        }
                    } else {
                        supportSQLiteProgram.z(i8, this.f7591h[i8]);
                    }
                } else {
                    supportSQLiteProgram.B0(i8, this.f7590g[i8]);
                }
            } else {
                supportSQLiteProgram.Q0(i8);
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    void g(String str, int i8) {
        this.f7589f = str;
        this.f7596m = i8;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void q0(int i8, String str) {
        this.f7594k[i8] = 4;
        this.f7592i[i8] = str;
    }

    public void release() {
        TreeMap<Integer, RoomSQLiteQuery> treeMap = f7588n;
        synchronized (treeMap) {
            treeMap.put(Integer.valueOf(this.f7595l), this);
            h();
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void z(int i8, double d8) {
        this.f7594k[i8] = 3;
        this.f7591h[i8] = d8;
    }
}
