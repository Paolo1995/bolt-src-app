package kotlinx.coroutines.internal;

import com.google.android.gms.common.api.Api;
import kotlin.text.StringsKt__StringNumberConversionsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SystemProps.common.kt */
/* loaded from: classes5.dex */
public final /* synthetic */ class SystemPropsKt__SystemProps_commonKt {
    public static final int a(String str, int i8, int i9, int i10) {
        return (int) SystemPropsKt.c(str, i8, i9, i10);
    }

    public static final long b(String str, long j8, long j9, long j10) {
        Long o8;
        String d8 = SystemPropsKt.d(str);
        if (d8 == null) {
            return j8;
        }
        o8 = StringsKt__StringNumberConversionsKt.o(d8);
        if (o8 != null) {
            long longValue = o8.longValue();
            boolean z7 = false;
            if (j9 <= longValue && longValue <= j10) {
                z7 = true;
            }
            if (z7) {
                return longValue;
            }
            throw new IllegalStateException(("System property '" + str + "' should be in range " + j9 + ".." + j10 + ", but is '" + longValue + '\'').toString());
        }
        throw new IllegalStateException(("System property '" + str + "' has unrecognized value '" + d8 + '\'').toString());
    }

    public static final boolean c(String str, boolean z7) {
        String d8 = SystemPropsKt.d(str);
        if (d8 != null) {
            return Boolean.parseBoolean(d8);
        }
        return z7;
    }

    public static /* synthetic */ int d(String str, int i8, int i9, int i10, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            i9 = 1;
        }
        if ((i11 & 8) != 0) {
            i10 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        }
        return SystemPropsKt.b(str, i8, i9, i10);
    }

    public static /* synthetic */ long e(String str, long j8, long j9, long j10, int i8, Object obj) {
        if ((i8 & 4) != 0) {
            j9 = 1;
        }
        long j11 = j9;
        if ((i8 & 8) != 0) {
            j10 = Long.MAX_VALUE;
        }
        return SystemPropsKt.c(str, j8, j11, j10);
    }
}
