package io.ktor.http;

import io.ktor.http.Parameters;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: Query.kt */
/* loaded from: classes5.dex */
public final class QueryKt {
    private static final void a(ParametersBuilder parametersBuilder, String str, int i8, int i9, int i10, boolean z7) {
        String substring;
        String substring2;
        String substring3;
        List k8;
        if (i9 == -1) {
            int f8 = f(i8, i10, str);
            int e8 = e(f8, i10, str);
            if (e8 > f8) {
                if (z7) {
                    substring3 = CodecsKt.k(str, f8, e8, false, null, 12, null);
                } else {
                    substring3 = str.substring(f8, e8);
                    Intrinsics.e(substring3, "this as java.lang.String…ing(startIndex, endIndex)");
                }
                k8 = CollectionsKt__CollectionsKt.k();
                parametersBuilder.e(substring3, k8);
                return;
            }
            return;
        }
        int f9 = f(i8, i9, str);
        int e9 = e(f9, i9, str);
        if (e9 > f9) {
            if (z7) {
                substring = CodecsKt.k(str, f9, e9, false, null, 12, null);
            } else {
                substring = str.substring(f9, e9);
                Intrinsics.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            }
            int f10 = f(i9 + 1, i10, str);
            int e10 = e(f10, i10, str);
            if (z7) {
                substring2 = CodecsKt.k(str, f10, e10, true, null, 8, null);
            } else {
                substring2 = str.substring(f10, e10);
                Intrinsics.e(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
            }
            parametersBuilder.f(substring, substring2);
        }
    }

    private static final void b(ParametersBuilder parametersBuilder, String str, int i8, int i9, boolean z7) {
        int V;
        int i10;
        int i11;
        V = StringsKt__StringsKt.V(str);
        int i12 = 0;
        if (i8 <= V) {
            int i13 = i8;
            int i14 = i13;
            int i15 = -1;
            int i16 = 0;
            while (i16 != i9) {
                char charAt = str.charAt(i13);
                if (charAt == '&') {
                    a(parametersBuilder, str, i14, i15, i13, z7);
                    i16++;
                    i14 = i13 + 1;
                    i15 = -1;
                } else if (charAt == '=' && i15 == -1) {
                    i15 = i13;
                }
                if (i13 != V) {
                    i13++;
                } else {
                    i10 = i14;
                    i11 = i15;
                    i12 = i16;
                }
            }
            return;
        }
        i10 = i8;
        i11 = -1;
        if (i12 == i9) {
            return;
        }
        a(parametersBuilder, str, i10, i11, str.length(), z7);
    }

    public static final Parameters c(String query, int i8, int i9, boolean z7) {
        int V;
        Intrinsics.f(query, "query");
        V = StringsKt__StringsKt.V(query);
        if (i8 > V) {
            return Parameters.f46888b.a();
        }
        Parameters.Companion companion = Parameters.f46888b;
        ParametersBuilder b8 = ParametersKt.b(0, 1, null);
        b(b8, query, i8, i9, z7);
        return b8.build();
    }

    public static /* synthetic */ Parameters d(String str, int i8, int i9, boolean z7, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            i8 = 0;
        }
        if ((i10 & 4) != 0) {
            i9 = 1000;
        }
        if ((i10 & 8) != 0) {
            z7 = true;
        }
        return c(str, i8, i9, z7);
    }

    private static final int e(int i8, int i9, CharSequence charSequence) {
        boolean c8;
        while (i9 > i8) {
            c8 = CharsKt__CharJVMKt.c(charSequence.charAt(i9 - 1));
            if (!c8) {
                break;
            }
            i9--;
        }
        return i9;
    }

    private static final int f(int i8, int i9, CharSequence charSequence) {
        boolean c8;
        while (i8 < i9) {
            c8 = CharsKt__CharJVMKt.c(charSequence.charAt(i8));
            if (!c8) {
                break;
            }
            i8++;
        }
        return i8;
    }
}
