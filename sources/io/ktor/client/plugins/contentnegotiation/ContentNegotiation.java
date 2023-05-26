package io.ktor.client.plugins.contentnegotiation;

import io.ktor.client.HttpClient;
import io.ktor.client.plugins.HttpClientPlugin;
import io.ktor.client.request.HttpRequestPipeline;
import io.ktor.client.statement.HttpResponsePipeline;
import io.ktor.http.ContentType;
import io.ktor.http.ContentTypeMatcher;
import io.ktor.serialization.Configuration;
import io.ktor.serialization.ContentConverter;
import io.ktor.serialization.ContentConverterKt;
import io.ktor.util.AttributeKey;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.ByteReadChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SetsKt___SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* compiled from: ContentNegotiation.kt */
/* loaded from: classes5.dex */
public final class ContentNegotiation {

    /* renamed from: c  reason: collision with root package name */
    public static final Plugin f46467c = new Plugin(null);

    /* renamed from: d  reason: collision with root package name */
    private static final AttributeKey<ContentNegotiation> f46468d = new AttributeKey<>("ContentNegotiation");

    /* renamed from: a  reason: collision with root package name */
    private final List<Config.ConverterRegistration> f46469a;

    /* renamed from: b  reason: collision with root package name */
    private final Set<KClass<?>> f46470b;

    /* compiled from: ContentNegotiation.kt */
    /* loaded from: classes5.dex */
    public static final class Config implements Configuration {

        /* renamed from: a  reason: collision with root package name */
        private final Set<KClass<?>> f46471a;

        /* renamed from: b  reason: collision with root package name */
        private final List<ConverterRegistration> f46472b;

        /* compiled from: ContentNegotiation.kt */
        /* loaded from: classes5.dex */
        public static final class ConverterRegistration {

            /* renamed from: a  reason: collision with root package name */
            private final ContentConverter f46473a;

            /* renamed from: b  reason: collision with root package name */
            private final ContentType f46474b;

            /* renamed from: c  reason: collision with root package name */
            private final ContentTypeMatcher f46475c;

            public ConverterRegistration(ContentConverter converter, ContentType contentTypeToSend, ContentTypeMatcher contentTypeMatcher) {
                Intrinsics.f(converter, "converter");
                Intrinsics.f(contentTypeToSend, "contentTypeToSend");
                Intrinsics.f(contentTypeMatcher, "contentTypeMatcher");
                this.f46473a = converter;
                this.f46474b = contentTypeToSend;
                this.f46475c = contentTypeMatcher;
            }

            public final ContentTypeMatcher a() {
                return this.f46475c;
            }

            public final ContentType b() {
                return this.f46474b;
            }

            public final ContentConverter c() {
                return this.f46473a;
            }
        }

        public Config() {
            Set h8;
            Set<KClass<?>> K0;
            h8 = SetsKt___SetsKt.h(DefaultIgnoredTypesJvmKt.a(), ContentNegotiationKt.a());
            K0 = CollectionsKt___CollectionsKt.K0(h8);
            this.f46471a = K0;
            this.f46472b = new ArrayList();
        }

        private final ContentTypeMatcher b(final ContentType contentType) {
            return new ContentTypeMatcher() { // from class: io.ktor.client.plugins.contentnegotiation.ContentNegotiation$Config$defaultMatcher$1
                @Override // io.ktor.http.ContentTypeMatcher
                public boolean a(ContentType contentType2) {
                    Intrinsics.f(contentType2, "contentType");
                    return contentType2.h(ContentType.this);
                }
            };
        }

        @Override // io.ktor.serialization.Configuration
        public <T extends ContentConverter> void a(ContentType contentType, T converter, Function1<? super T, Unit> configuration) {
            ContentTypeMatcher b8;
            Intrinsics.f(contentType, "contentType");
            Intrinsics.f(converter, "converter");
            Intrinsics.f(configuration, "configuration");
            if (Intrinsics.a(contentType, ContentType.Application.f46731a.a())) {
                b8 = JsonContentTypeMatcher.f46495a;
            } else {
                b8 = b(contentType);
            }
            e(contentType, converter, b8, configuration);
        }

        public final Set<KClass<?>> c() {
            return this.f46471a;
        }

        public final List<ConverterRegistration> d() {
            return this.f46472b;
        }

        public final <T extends ContentConverter> void e(ContentType contentTypeToSend, T converter, ContentTypeMatcher contentTypeMatcher, Function1<? super T, Unit> configuration) {
            Intrinsics.f(contentTypeToSend, "contentTypeToSend");
            Intrinsics.f(converter, "converter");
            Intrinsics.f(contentTypeMatcher, "contentTypeMatcher");
            Intrinsics.f(configuration, "configuration");
            configuration.invoke(converter);
            this.f46472b.add(new ConverterRegistration(converter, contentTypeToSend, contentTypeMatcher));
        }
    }

    /* compiled from: ContentNegotiation.kt */
    /* loaded from: classes5.dex */
    public static final class Plugin implements HttpClientPlugin<Config, ContentNegotiation> {
        private Plugin() {
        }

        public /* synthetic */ Plugin(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        /* renamed from: c */
        public void a(ContentNegotiation plugin, HttpClient scope) {
            Intrinsics.f(plugin, "plugin");
            Intrinsics.f(scope, "scope");
            scope.k().l(HttpRequestPipeline.f46627h.d(), new ContentNegotiation$Plugin$install$1(plugin, null));
            scope.l().l(HttpResponsePipeline.f46667h.c(), new ContentNegotiation$Plugin$install$2(plugin, null));
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        /* renamed from: d */
        public ContentNegotiation b(Function1<? super Config, Unit> block) {
            Intrinsics.f(block, "block");
            Config config = new Config();
            block.invoke(config);
            return new ContentNegotiation(config.d(), config.c());
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public AttributeKey<ContentNegotiation> getKey() {
            return ContentNegotiation.f46468d;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ContentNegotiation(List<Config.ConverterRegistration> registrations, Set<? extends KClass<?>> ignoredTypes) {
        Intrinsics.f(registrations, "registrations");
        Intrinsics.f(ignoredTypes, "ignoredTypes");
        this.f46469a = registrations;
        this.f46470b = ignoredTypes;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0155 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0156  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:68:0x0144 -> B:69:0x0148). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object b(io.ktor.client.request.HttpRequestBuilder r17, java.lang.Object r18, kotlin.coroutines.Continuation<java.lang.Object> r19) {
        /*
            Method dump skipped, instructions count: 396
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.contentnegotiation.ContentNegotiation.b(io.ktor.client.request.HttpRequestBuilder, java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object c(TypeInfo typeInfo, Object obj, ContentType contentType, Charset charset, Continuation<Object> continuation) {
        int v7;
        if (!(obj instanceof ByteReadChannel) || this.f46470b.contains(typeInfo.b())) {
            return null;
        }
        List<Config.ConverterRegistration> list = this.f46469a;
        ArrayList<Config.ConverterRegistration> arrayList = new ArrayList();
        for (Object obj2 : list) {
            if (((Config.ConverterRegistration) obj2).a().a(contentType)) {
                arrayList.add(obj2);
            }
        }
        v7 = CollectionsKt__IterablesKt.v(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(v7);
        for (Config.ConverterRegistration converterRegistration : arrayList) {
            arrayList2.add(converterRegistration.c());
        }
        if (!(!arrayList2.isEmpty())) {
            arrayList2 = null;
        }
        if (arrayList2 == null) {
            return null;
        }
        return ContentConverterKt.a(arrayList2, (ByteReadChannel) obj, typeInfo, charset, continuation);
    }
}
