package kotlin.text;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Indent.kt */
/* loaded from: classes5.dex */
public class StringsKt__IndentKt extends StringsKt__AppendableKt {
    private static final Function1<String, String> b(final String str) {
        boolean z7;
        if (str.length() == 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            return new Function1<String, String>() { // from class: kotlin.text.StringsKt__IndentKt$getIndentFunction$1
                @Override // kotlin.jvm.functions.Function1
                /* renamed from: b */
                public final String invoke(String line) {
                    Intrinsics.f(line, "line");
                    return line;
                }
            };
        }
        return new Function1<String, String>() { // from class: kotlin.text.StringsKt__IndentKt$getIndentFunction$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final String invoke(String line) {
                Intrinsics.f(line, "line");
                return str + line;
            }
        };
    }

    private static final int c(String str) {
        int length = str.length();
        int i8 = 0;
        while (true) {
            if (i8 < length) {
                if (!CharsKt.c(str.charAt(i8))) {
                    break;
                }
                i8++;
            } else {
                i8 = -1;
                break;
            }
        }
        if (i8 == -1) {
            return str.length();
        }
        return i8;
    }

    public static final String d(String str, String newIndent) {
        int i8;
        String invoke;
        Intrinsics.f(str, "<this>");
        Intrinsics.f(newIndent, "newIndent");
        List<String> k02 = StringsKt__StringsKt.k0(str);
        ArrayList<String> arrayList = new ArrayList();
        for (Object obj : k02) {
            if (!StringsKt.y((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.v(arrayList, 10));
        for (String str2 : arrayList) {
            arrayList2.add(Integer.valueOf(c(str2)));
        }
        Integer num = (Integer) CollectionsKt.k0(arrayList2);
        int i9 = 0;
        if (num != null) {
            i8 = num.intValue();
        } else {
            i8 = 0;
        }
        int length = str.length() + (newIndent.length() * k02.size());
        Function1<String, String> b8 = b(newIndent);
        int m8 = CollectionsKt.m(k02);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : k02) {
            int i10 = i9 + 1;
            if (i9 < 0) {
                CollectionsKt.u();
            }
            String str3 = (String) obj2;
            if ((i9 == 0 || i9 == m8) && StringsKt.y(str3)) {
                str3 = null;
            } else {
                String a12 = StringsKt.a1(str3, i8);
                if (a12 != null && (invoke = b8.invoke(a12)) != null) {
                    str3 = invoke;
                }
            }
            if (str3 != null) {
                arrayList3.add(str3);
            }
            i9 = i10;
        }
        String sb = ((StringBuilder) CollectionsKt.d0(arrayList3, new StringBuilder(length), "\n", null, null, 0, null, null, 124, null)).toString();
        Intrinsics.e(sb, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        return sb;
    }

    public static final String e(String str, String newIndent, String marginPrefix) {
        int i8;
        String invoke;
        Intrinsics.f(str, "<this>");
        Intrinsics.f(newIndent, "newIndent");
        Intrinsics.f(marginPrefix, "marginPrefix");
        if (!StringsKt.y(marginPrefix)) {
            List<String> k02 = StringsKt__StringsKt.k0(str);
            int length = str.length() + (newIndent.length() * k02.size());
            Function1<String, String> b8 = b(newIndent);
            int m8 = CollectionsKt.m(k02);
            ArrayList arrayList = new ArrayList();
            int i9 = 0;
            for (Object obj : k02) {
                int i10 = i9 + 1;
                if (i9 < 0) {
                    CollectionsKt.u();
                }
                String str2 = (String) obj;
                String str3 = null;
                if ((i9 == 0 || i9 == m8) && StringsKt.y(str2)) {
                    str2 = null;
                } else {
                    int length2 = str2.length();
                    int i11 = 0;
                    while (true) {
                        if (i11 < length2) {
                            if (!CharsKt.c(str2.charAt(i11))) {
                                i8 = i11;
                                break;
                            }
                            i11++;
                        } else {
                            i8 = -1;
                            break;
                        }
                    }
                    if (i8 != -1) {
                        int i12 = i8;
                        if (StringsKt.K(str2, marginPrefix, i8, false, 4, null)) {
                            Intrinsics.d(str2, "null cannot be cast to non-null type java.lang.String");
                            str3 = str2.substring(i12 + marginPrefix.length());
                            Intrinsics.e(str3, "this as java.lang.String).substring(startIndex)");
                        }
                    }
                    if (str3 != null && (invoke = b8.invoke(str3)) != null) {
                        str2 = invoke;
                    }
                }
                if (str2 != null) {
                    arrayList.add(str2);
                }
                i9 = i10;
            }
            String sb = ((StringBuilder) CollectionsKt.d0(arrayList, new StringBuilder(length), "\n", null, null, 0, null, null, 124, null)).toString();
            Intrinsics.e(sb, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
            return sb;
        }
        throw new IllegalArgumentException("marginPrefix must be non-blank string.".toString());
    }

    public static String f(String str) {
        Intrinsics.f(str, "<this>");
        return d(str, "");
    }

    public static final String g(String str, String marginPrefix) {
        Intrinsics.f(str, "<this>");
        Intrinsics.f(marginPrefix, "marginPrefix");
        return e(str, "", marginPrefix);
    }

    public static /* synthetic */ String h(String str, String str2, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str2 = "|";
        }
        return g(str, str2);
    }
}
