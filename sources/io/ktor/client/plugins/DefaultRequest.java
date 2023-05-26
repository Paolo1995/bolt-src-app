package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestPipeline;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpMessageBuilder;
import io.ktor.http.ParametersBuilder;
import io.ktor.http.ParametersKt;
import io.ktor.http.URLBuilder;
import io.ktor.http.URLProtocol;
import io.ktor.http.URLUtilsKt;
import io.ktor.http.Url;
import io.ktor.util.AttributeKey;
import io.ktor.util.Attributes;
import io.ktor.util.AttributesJvmKt;
import io.ktor.util.StringValuesKt;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DefaultRequest.kt */
/* loaded from: classes5.dex */
public final class DefaultRequest {

    /* renamed from: b  reason: collision with root package name */
    public static final Plugin f46241b = new Plugin(null);

    /* renamed from: c  reason: collision with root package name */
    private static final AttributeKey<DefaultRequest> f46242c = new AttributeKey<>("DefaultRequest");

    /* renamed from: a  reason: collision with root package name */
    private final Function1<DefaultRequestBuilder, Unit> f46243a;

    /* compiled from: DefaultRequest.kt */
    /* loaded from: classes5.dex */
    public static final class DefaultRequestBuilder implements HttpMessageBuilder {

        /* renamed from: a  reason: collision with root package name */
        private final HeadersBuilder f46244a = new HeadersBuilder(0, 1, null);

        /* renamed from: b  reason: collision with root package name */
        private final URLBuilder f46245b = new URLBuilder(null, null, 0, null, null, null, null, null, false, 511, null);

        /* renamed from: c  reason: collision with root package name */
        private final Attributes f46246c = AttributesJvmKt.a(true);

        public final Attributes a() {
            return this.f46246c;
        }

        public final URLBuilder b() {
            return this.f46245b;
        }

        public final void c(Function1<? super URLBuilder, Unit> block) {
            Intrinsics.f(block, "block");
            block.invoke(this.f46245b);
        }

        @Override // io.ktor.http.HttpMessageBuilder
        public HeadersBuilder getHeaders() {
            return this.f46244a;
        }
    }

    /* compiled from: DefaultRequest.kt */
    /* loaded from: classes5.dex */
    public static final class Plugin implements HttpClientPlugin<DefaultRequestBuilder, DefaultRequest> {
        private Plugin() {
        }

        public /* synthetic */ Plugin(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final List<String> d(List<String> list, List<String> list2) {
            Object W;
            boolean z7;
            List d8;
            List<String> a8;
            if (list2.isEmpty()) {
                return list;
            }
            if (list.isEmpty()) {
                return list2;
            }
            W = CollectionsKt___CollectionsKt.W(list2);
            if (((CharSequence) W).length() == 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7) {
                return list2;
            }
            d8 = CollectionsKt__CollectionsJVMKt.d((list.size() + list2.size()) - 1);
            int size = list.size() - 1;
            for (int i8 = 0; i8 < size; i8++) {
                d8.add(list.get(i8));
            }
            d8.addAll(list2);
            a8 = CollectionsKt__CollectionsJVMKt.a(d8);
            return a8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void f(Url url, URLBuilder uRLBuilder) {
            boolean z7;
            boolean z8;
            if (Intrinsics.a(uRLBuilder.o(), URLProtocol.f46905c.c())) {
                uRLBuilder.y(url.k());
            }
            if (uRLBuilder.j().length() > 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7) {
                return;
            }
            URLBuilder a8 = URLUtilsKt.a(url);
            a8.y(uRLBuilder.o());
            if (uRLBuilder.n() != 0) {
                a8.x(uRLBuilder.n());
            }
            a8.u(DefaultRequest.f46241b.d(a8.g(), uRLBuilder.g()));
            if (uRLBuilder.d().length() > 0) {
                z8 = true;
            } else {
                z8 = false;
            }
            if (z8) {
                a8.r(uRLBuilder.d());
            }
            ParametersBuilder b8 = ParametersKt.b(0, 1, null);
            StringValuesKt.c(b8, a8.e());
            a8.s(uRLBuilder.e());
            Iterator<T> it = b8.a().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                String str = (String) entry.getKey();
                List list = (List) entry.getValue();
                if (!a8.e().contains(str)) {
                    a8.e().e(str, list);
                }
            }
            URLUtilsKt.h(uRLBuilder, a8);
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        /* renamed from: e */
        public void a(DefaultRequest plugin, HttpClient scope) {
            Intrinsics.f(plugin, "plugin");
            Intrinsics.f(scope, "scope");
            scope.k().l(HttpRequestPipeline.f46627h.a(), new DefaultRequest$Plugin$install$1(plugin, null));
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        /* renamed from: g */
        public DefaultRequest b(Function1<? super DefaultRequestBuilder, Unit> block) {
            Intrinsics.f(block, "block");
            return new DefaultRequest(block, null);
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public AttributeKey<DefaultRequest> getKey() {
            return DefaultRequest.f46242c;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private DefaultRequest(Function1<? super DefaultRequestBuilder, Unit> function1) {
        this.f46243a = function1;
    }

    public /* synthetic */ DefaultRequest(Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1);
    }
}
