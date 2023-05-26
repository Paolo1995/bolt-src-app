package io.ktor.http;

import io.ktor.util.StringValuesKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: URLUtils.kt */
/* loaded from: classes5.dex */
public final class URLUtilsKt {
    public static final URLBuilder a(Url url) {
        Intrinsics.f(url, "url");
        return i(new URLBuilder(null, null, 0, null, null, null, null, null, false, 511, null), url);
    }

    public static final URLBuilder b(String urlString) {
        Intrinsics.f(urlString, "urlString");
        return URLParserKt.j(new URLBuilder(null, null, 0, null, null, null, null, null, false, 511, null), urlString);
    }

    public static final Url c(URLBuilder builder) {
        Intrinsics.f(builder, "builder");
        return h(new URLBuilder(null, null, 0, null, null, null, null, null, false, 511, null), builder).b();
    }

    public static final Url d(String urlString) {
        Intrinsics.f(urlString, "urlString");
        return b(urlString).b();
    }

    public static final void e(Appendable appendable, String encodedPath, ParametersBuilder encodedQueryParameters, boolean z7) {
        boolean y7;
        int v7;
        List list;
        boolean L;
        Intrinsics.f(appendable, "<this>");
        Intrinsics.f(encodedPath, "encodedPath");
        Intrinsics.f(encodedQueryParameters, "encodedQueryParameters");
        y7 = StringsKt__StringsJVMKt.y(encodedPath);
        if (!y7) {
            L = StringsKt__StringsJVMKt.L(encodedPath, "/", false, 2, null);
            if (!L) {
                appendable.append('/');
            }
        }
        appendable.append(encodedPath);
        if (!encodedQueryParameters.isEmpty() || z7) {
            appendable.append("?");
        }
        Set<Map.Entry<String, List<String>>> a8 = encodedQueryParameters.a();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = a8.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String str = (String) entry.getKey();
            List<String> list2 = (List) entry.getValue();
            if (list2.isEmpty()) {
                list = CollectionsKt__CollectionsJVMKt.e(TuplesKt.a(str, null));
            } else {
                v7 = CollectionsKt__IterablesKt.v(list2, 10);
                ArrayList arrayList2 = new ArrayList(v7);
                for (String str2 : list2) {
                    arrayList2.add(TuplesKt.a(str, str2));
                }
                list = arrayList2;
            }
            CollectionsKt__MutableCollectionsKt.A(arrayList, list);
        }
        CollectionsKt___CollectionsKt.d0(arrayList, appendable, "&", null, null, 0, null, new Function1<Pair<? extends String, ? extends String>, CharSequence>() { // from class: io.ktor.http.URLUtilsKt$appendUrlFullPath$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final CharSequence invoke(Pair<String, String> it2) {
                Intrinsics.f(it2, "it");
                String d8 = it2.d();
                if (it2.e() != null) {
                    String valueOf = String.valueOf(it2.e());
                    return d8 + '=' + valueOf;
                }
                return d8;
            }
        }, 60, null);
    }

    public static final void f(StringBuilder sb, String str, String str2) {
        Intrinsics.f(sb, "<this>");
        if (str == null) {
            return;
        }
        sb.append(str);
        if (str2 != null) {
            sb.append(':');
            sb.append(str2);
        }
        sb.append("@");
    }

    public static final String g(Url url) {
        Intrinsics.f(url, "<this>");
        return url.g() + ':' + url.j();
    }

    public static final URLBuilder h(URLBuilder uRLBuilder, URLBuilder url) {
        Intrinsics.f(uRLBuilder, "<this>");
        Intrinsics.f(url, "url");
        uRLBuilder.y(url.o());
        uRLBuilder.w(url.j());
        uRLBuilder.x(url.n());
        uRLBuilder.u(url.g());
        uRLBuilder.v(url.h());
        uRLBuilder.t(url.f());
        ParametersBuilder b8 = ParametersKt.b(0, 1, null);
        StringValuesKt.c(b8, url.e());
        uRLBuilder.s(b8);
        uRLBuilder.r(url.d());
        uRLBuilder.z(url.p());
        return uRLBuilder;
    }

    public static final URLBuilder i(URLBuilder uRLBuilder, Url url) {
        Intrinsics.f(uRLBuilder, "<this>");
        Intrinsics.f(url, "url");
        uRLBuilder.y(url.k());
        uRLBuilder.w(url.g());
        uRLBuilder.x(url.j());
        URLBuilderKt.l(uRLBuilder, url.d());
        uRLBuilder.v(url.f());
        uRLBuilder.t(url.c());
        ParametersBuilder b8 = ParametersKt.b(0, 1, null);
        b8.d(QueryKt.d(url.e(), 0, 0, false, 6, null));
        uRLBuilder.s(b8);
        uRLBuilder.r(url.b());
        uRLBuilder.z(url.m());
        return uRLBuilder;
    }
}
