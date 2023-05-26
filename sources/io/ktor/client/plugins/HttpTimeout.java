package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.client.engine.HttpClientEngineCapability;
import io.ktor.client.request.HttpRequestPipeline;
import io.ktor.util.AttributeKey;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: HttpTimeout.kt */
/* loaded from: classes5.dex */
public final class HttpTimeout {

    /* renamed from: d  reason: collision with root package name */
    public static final Plugin f46390d = new Plugin(null);

    /* renamed from: e  reason: collision with root package name */
    private static final AttributeKey<HttpTimeout> f46391e = new AttributeKey<>("TimeoutPlugin");

    /* renamed from: a  reason: collision with root package name */
    private final Long f46392a;

    /* renamed from: b  reason: collision with root package name */
    private final Long f46393b;

    /* renamed from: c  reason: collision with root package name */
    private final Long f46394c;

    /* compiled from: HttpTimeout.kt */
    /* loaded from: classes5.dex */
    public static final class HttpTimeoutCapabilityConfiguration {

        /* renamed from: d  reason: collision with root package name */
        public static final Companion f46395d = new Companion(null);

        /* renamed from: e  reason: collision with root package name */
        private static final AttributeKey<HttpTimeoutCapabilityConfiguration> f46396e = new AttributeKey<>("TimeoutConfiguration");

        /* renamed from: a  reason: collision with root package name */
        private Long f46397a;

        /* renamed from: b  reason: collision with root package name */
        private Long f46398b;

        /* renamed from: c  reason: collision with root package name */
        private Long f46399c;

        /* compiled from: HttpTimeout.kt */
        /* loaded from: classes5.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ HttpTimeoutCapabilityConfiguration(Long l8, Long l9, Long l10, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this((i8 & 1) != 0 ? null : l8, (i8 & 2) != 0 ? null : l9, (i8 & 4) != 0 ? null : l10);
        }

        private final Long b(Long l8) {
            boolean z7;
            if (l8 != null && l8.longValue() <= 0) {
                z7 = false;
            } else {
                z7 = true;
            }
            if (z7) {
                return l8;
            }
            throw new IllegalArgumentException("Only positive timeout values are allowed, for infinite timeout use HttpTimeout.INFINITE_TIMEOUT_MS".toString());
        }

        public final HttpTimeout a() {
            return new HttpTimeout(d(), c(), e(), null);
        }

        public final Long c() {
            return this.f46398b;
        }

        public final Long d() {
            return this.f46397a;
        }

        public final Long e() {
            return this.f46399c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !Intrinsics.a(Reflection.b(HttpTimeoutCapabilityConfiguration.class), Reflection.b(obj.getClass()))) {
                return false;
            }
            HttpTimeoutCapabilityConfiguration httpTimeoutCapabilityConfiguration = (HttpTimeoutCapabilityConfiguration) obj;
            if (Intrinsics.a(this.f46397a, httpTimeoutCapabilityConfiguration.f46397a) && Intrinsics.a(this.f46398b, httpTimeoutCapabilityConfiguration.f46398b) && Intrinsics.a(this.f46399c, httpTimeoutCapabilityConfiguration.f46399c)) {
                return true;
            }
            return false;
        }

        public final void f(Long l8) {
            this.f46398b = b(l8);
        }

        public final void g(Long l8) {
            this.f46397a = b(l8);
        }

        public final void h(Long l8) {
            this.f46399c = b(l8);
        }

        public int hashCode() {
            int i8;
            int i9;
            Long l8 = this.f46397a;
            int i10 = 0;
            if (l8 != null) {
                i8 = l8.hashCode();
            } else {
                i8 = 0;
            }
            int i11 = i8 * 31;
            Long l9 = this.f46398b;
            if (l9 != null) {
                i9 = l9.hashCode();
            } else {
                i9 = 0;
            }
            int i12 = (i11 + i9) * 31;
            Long l10 = this.f46399c;
            if (l10 != null) {
                i10 = l10.hashCode();
            }
            return i12 + i10;
        }

        public HttpTimeoutCapabilityConfiguration(Long l8, Long l9, Long l10) {
            this.f46397a = 0L;
            this.f46398b = 0L;
            this.f46399c = 0L;
            g(l8);
            f(l9);
            h(l10);
        }
    }

    /* compiled from: HttpTimeout.kt */
    /* loaded from: classes5.dex */
    public static final class Plugin implements HttpClientPlugin<HttpTimeoutCapabilityConfiguration, HttpTimeout>, HttpClientEngineCapability<HttpTimeoutCapabilityConfiguration> {
        private Plugin() {
        }

        public /* synthetic */ Plugin(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        /* renamed from: c */
        public void a(HttpTimeout plugin, HttpClient scope) {
            Intrinsics.f(plugin, "plugin");
            Intrinsics.f(scope, "scope");
            scope.k().l(HttpRequestPipeline.f46627h.a(), new HttpTimeout$Plugin$install$1(plugin, scope, null));
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        /* renamed from: d */
        public HttpTimeout b(Function1<? super HttpTimeoutCapabilityConfiguration, Unit> block) {
            Intrinsics.f(block, "block");
            HttpTimeoutCapabilityConfiguration httpTimeoutCapabilityConfiguration = new HttpTimeoutCapabilityConfiguration(null, null, null, 7, null);
            block.invoke(httpTimeoutCapabilityConfiguration);
            return httpTimeoutCapabilityConfiguration.a();
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public AttributeKey<HttpTimeout> getKey() {
            return HttpTimeout.f46391e;
        }
    }

    private HttpTimeout(Long l8, Long l9, Long l10) {
        this.f46392a = l8;
        this.f46393b = l9;
        this.f46394c = l10;
    }

    public /* synthetic */ HttpTimeout(Long l8, Long l9, Long l10, DefaultConstructorMarker defaultConstructorMarker) {
        this(l8, l9, l10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean f() {
        if (this.f46392a == null && this.f46393b == null && this.f46394c == null) {
            return false;
        }
        return true;
    }
}
