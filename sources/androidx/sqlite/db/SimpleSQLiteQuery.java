package androidx.sqlite.db;

/* loaded from: classes.dex */
public final class SimpleSQLiteQuery implements SupportSQLiteQuery {

    /* renamed from: f  reason: collision with root package name */
    private final String f7737f;

    /* renamed from: g  reason: collision with root package name */
    private final Object[] f7738g;

    public SimpleSQLiteQuery(String str, Object[] objArr) {
        this.f7737f = str;
        this.f7738g = objArr;
    }

    private static void b(SupportSQLiteProgram supportSQLiteProgram, int i8, Object obj) {
        long j8;
        if (obj == null) {
            supportSQLiteProgram.Q0(i8);
        } else if (obj instanceof byte[]) {
            supportSQLiteProgram.F0(i8, (byte[]) obj);
        } else if (obj instanceof Float) {
            supportSQLiteProgram.z(i8, ((Float) obj).floatValue());
        } else if (obj instanceof Double) {
            supportSQLiteProgram.z(i8, ((Double) obj).doubleValue());
        } else if (obj instanceof Long) {
            supportSQLiteProgram.B0(i8, ((Long) obj).longValue());
        } else if (obj instanceof Integer) {
            supportSQLiteProgram.B0(i8, ((Integer) obj).intValue());
        } else if (obj instanceof Short) {
            supportSQLiteProgram.B0(i8, ((Short) obj).shortValue());
        } else if (obj instanceof Byte) {
            supportSQLiteProgram.B0(i8, ((Byte) obj).byteValue());
        } else if (obj instanceof String) {
            supportSQLiteProgram.q0(i8, (String) obj);
        } else if (obj instanceof Boolean) {
            if (((Boolean) obj).booleanValue()) {
                j8 = 1;
            } else {
                j8 = 0;
            }
            supportSQLiteProgram.B0(i8, j8);
        } else {
            throw new IllegalArgumentException("Cannot bind " + obj + " at index " + i8 + " Supported types: null, byte[], float, double, long, int, short, byte, string");
        }
    }

    public static void d(SupportSQLiteProgram supportSQLiteProgram, Object[] objArr) {
        if (objArr == null) {
            return;
        }
        int length = objArr.length;
        int i8 = 0;
        while (i8 < length) {
            Object obj = objArr[i8];
            i8++;
            b(supportSQLiteProgram, i8, obj);
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public String a() {
        return this.f7737f;
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public void c(SupportSQLiteProgram supportSQLiteProgram) {
        d(supportSQLiteProgram, this.f7738g);
    }

    public SimpleSQLiteQuery(String str) {
        this(str, null);
    }
}
