package kotlinx.serialization.json.internal;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;

/* compiled from: CharArrayPool.kt */
/* loaded from: classes5.dex */
public final class CharArrayPool {

    /* renamed from: a  reason: collision with root package name */
    public static final CharArrayPool f52371a = new CharArrayPool();

    /* renamed from: b  reason: collision with root package name */
    private static final ArrayDeque<char[]> f52372b = new ArrayDeque<>();

    /* renamed from: c  reason: collision with root package name */
    private static int f52373c;

    /* renamed from: d  reason: collision with root package name */
    private static final int f52374d;

    static {
        Object b8;
        int i8;
        Integer m8;
        try {
            Result.Companion companion = Result.f50818g;
            String property = System.getProperty("kotlinx.serialization.json.pool.size");
            Intrinsics.e(property, "getProperty(\"kotlinx.ser…lization.json.pool.size\")");
            m8 = StringsKt__StringNumberConversionsKt.m(property);
            b8 = Result.b(m8);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.f50818g;
            b8 = Result.b(ResultKt.a(th));
        }
        if (Result.g(b8)) {
            b8 = null;
        }
        Integer num = (Integer) b8;
        if (num != null) {
            i8 = num.intValue();
        } else {
            i8 = 1048576;
        }
        f52374d = i8;
    }

    private CharArrayPool() {
    }

    public final void a(char[] array) {
        Intrinsics.f(array, "array");
        synchronized (this) {
            int i8 = f52373c;
            if (array.length + i8 < f52374d) {
                f52373c = i8 + array.length;
                f52372b.addLast(array);
            }
            Unit unit = Unit.f50853a;
        }
    }

    public final char[] b() {
        char[] u7;
        synchronized (this) {
            u7 = f52372b.u();
            if (u7 != null) {
                f52373c -= u7.length;
            } else {
                u7 = null;
            }
        }
        if (u7 == null) {
            return new char[128];
        }
        return u7;
    }
}
