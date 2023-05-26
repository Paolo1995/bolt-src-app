package okhttp3;

import com.google.android.gms.common.api.Api;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: CacheControl.kt */
/* loaded from: classes5.dex */
public final class CacheControl {
    private String headerValue;
    private final boolean immutable;
    private final boolean isPrivate;
    private final boolean isPublic;
    private final int maxAgeSeconds;
    private final int maxStaleSeconds;
    private final int minFreshSeconds;
    private final boolean mustRevalidate;
    private final boolean noCache;
    private final boolean noStore;
    private final boolean noTransform;
    private final boolean onlyIfCached;
    private final int sMaxAgeSeconds;
    public static final Companion Companion = new Companion(null);
    public static final CacheControl FORCE_NETWORK = new Builder().noCache().build();
    public static final CacheControl FORCE_CACHE = new Builder().onlyIfCached().maxStale(Api.BaseClientBuilder.API_PRIORITY_OTHER, TimeUnit.SECONDS).build();

    /* compiled from: CacheControl.kt */
    /* loaded from: classes5.dex */
    public static final class Builder {
        private boolean immutable;
        private int maxAgeSeconds = -1;
        private int maxStaleSeconds = -1;
        private int minFreshSeconds = -1;
        private boolean noCache;
        private boolean noStore;
        private boolean noTransform;
        private boolean onlyIfCached;

        private final int clampToInt(long j8) {
            return j8 > 2147483647L ? Api.BaseClientBuilder.API_PRIORITY_OTHER : (int) j8;
        }

        public final CacheControl build() {
            return new CacheControl(this.noCache, this.noStore, this.maxAgeSeconds, -1, false, false, false, this.maxStaleSeconds, this.minFreshSeconds, this.onlyIfCached, this.noTransform, this.immutable, null, null);
        }

        public final Builder immutable() {
            this.immutable = true;
            return this;
        }

        public final Builder maxAge(int i8, TimeUnit timeUnit) {
            boolean z7;
            Intrinsics.f(timeUnit, "timeUnit");
            if (i8 >= 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7) {
                this.maxAgeSeconds = clampToInt(timeUnit.toSeconds(i8));
                return this;
            }
            throw new IllegalArgumentException(Intrinsics.n("maxAge < 0: ", Integer.valueOf(i8)).toString());
        }

        public final Builder maxStale(int i8, TimeUnit timeUnit) {
            boolean z7;
            Intrinsics.f(timeUnit, "timeUnit");
            if (i8 >= 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7) {
                this.maxStaleSeconds = clampToInt(timeUnit.toSeconds(i8));
                return this;
            }
            throw new IllegalArgumentException(Intrinsics.n("maxStale < 0: ", Integer.valueOf(i8)).toString());
        }

        public final Builder minFresh(int i8, TimeUnit timeUnit) {
            boolean z7;
            Intrinsics.f(timeUnit, "timeUnit");
            if (i8 >= 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7) {
                this.minFreshSeconds = clampToInt(timeUnit.toSeconds(i8));
                return this;
            }
            throw new IllegalArgumentException(Intrinsics.n("minFresh < 0: ", Integer.valueOf(i8)).toString());
        }

        public final Builder noCache() {
            this.noCache = true;
            return this;
        }

        public final Builder noStore() {
            this.noStore = true;
            return this;
        }

        public final Builder noTransform() {
            this.noTransform = true;
            return this;
        }

        public final Builder onlyIfCached() {
            this.onlyIfCached = true;
            return this;
        }
    }

    /* compiled from: CacheControl.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final int indexOfElement(String str, String str2, int i8) {
            boolean P;
            int length = str.length();
            while (i8 < length) {
                int i9 = i8 + 1;
                P = StringsKt__StringsKt.P(str2, str.charAt(i8), false, 2, null);
                if (P) {
                    return i8;
                }
                i8 = i9;
            }
            return str.length();
        }

        static /* synthetic */ int indexOfElement$default(Companion companion, String str, String str2, int i8, int i9, Object obj) {
            if ((i9 & 2) != 0) {
                i8 = 0;
            }
            return companion.indexOfElement(str, str2, i8);
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x004c  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final okhttp3.CacheControl parse(okhttp3.Headers r31) {
            /*
                Method dump skipped, instructions count: 398
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.CacheControl.Companion.parse(okhttp3.Headers):okhttp3.CacheControl");
        }
    }

    private CacheControl(boolean z7, boolean z8, int i8, int i9, boolean z9, boolean z10, boolean z11, int i10, int i11, boolean z12, boolean z13, boolean z14, String str) {
        this.noCache = z7;
        this.noStore = z8;
        this.maxAgeSeconds = i8;
        this.sMaxAgeSeconds = i9;
        this.isPrivate = z9;
        this.isPublic = z10;
        this.mustRevalidate = z11;
        this.maxStaleSeconds = i10;
        this.minFreshSeconds = i11;
        this.onlyIfCached = z12;
        this.noTransform = z13;
        this.immutable = z14;
        this.headerValue = str;
    }

    public /* synthetic */ CacheControl(boolean z7, boolean z8, int i8, int i9, boolean z9, boolean z10, boolean z11, int i10, int i11, boolean z12, boolean z13, boolean z14, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(z7, z8, i8, i9, z9, z10, z11, i10, i11, z12, z13, z14, str);
    }

    public static final CacheControl parse(Headers headers) {
        return Companion.parse(headers);
    }

    /* renamed from: -deprecated_immutable  reason: not valid java name */
    public final boolean m25deprecated_immutable() {
        return this.immutable;
    }

    /* renamed from: -deprecated_maxAgeSeconds  reason: not valid java name */
    public final int m26deprecated_maxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    /* renamed from: -deprecated_maxStaleSeconds  reason: not valid java name */
    public final int m27deprecated_maxStaleSeconds() {
        return this.maxStaleSeconds;
    }

    /* renamed from: -deprecated_minFreshSeconds  reason: not valid java name */
    public final int m28deprecated_minFreshSeconds() {
        return this.minFreshSeconds;
    }

    /* renamed from: -deprecated_mustRevalidate  reason: not valid java name */
    public final boolean m29deprecated_mustRevalidate() {
        return this.mustRevalidate;
    }

    /* renamed from: -deprecated_noCache  reason: not valid java name */
    public final boolean m30deprecated_noCache() {
        return this.noCache;
    }

    /* renamed from: -deprecated_noStore  reason: not valid java name */
    public final boolean m31deprecated_noStore() {
        return this.noStore;
    }

    /* renamed from: -deprecated_noTransform  reason: not valid java name */
    public final boolean m32deprecated_noTransform() {
        return this.noTransform;
    }

    /* renamed from: -deprecated_onlyIfCached  reason: not valid java name */
    public final boolean m33deprecated_onlyIfCached() {
        return this.onlyIfCached;
    }

    /* renamed from: -deprecated_sMaxAgeSeconds  reason: not valid java name */
    public final int m34deprecated_sMaxAgeSeconds() {
        return this.sMaxAgeSeconds;
    }

    public final boolean immutable() {
        return this.immutable;
    }

    public final boolean isPrivate() {
        return this.isPrivate;
    }

    public final boolean isPublic() {
        return this.isPublic;
    }

    public final int maxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    public final int maxStaleSeconds() {
        return this.maxStaleSeconds;
    }

    public final int minFreshSeconds() {
        return this.minFreshSeconds;
    }

    public final boolean mustRevalidate() {
        return this.mustRevalidate;
    }

    public final boolean noCache() {
        return this.noCache;
    }

    public final boolean noStore() {
        return this.noStore;
    }

    public final boolean noTransform() {
        return this.noTransform;
    }

    public final boolean onlyIfCached() {
        return this.onlyIfCached;
    }

    public final int sMaxAgeSeconds() {
        return this.sMaxAgeSeconds;
    }

    public String toString() {
        boolean z7;
        String str = this.headerValue;
        if (str == null) {
            StringBuilder sb = new StringBuilder();
            if (noCache()) {
                sb.append("no-cache, ");
            }
            if (noStore()) {
                sb.append("no-store, ");
            }
            if (maxAgeSeconds() != -1) {
                sb.append("max-age=");
                sb.append(maxAgeSeconds());
                sb.append(", ");
            }
            if (sMaxAgeSeconds() != -1) {
                sb.append("s-maxage=");
                sb.append(sMaxAgeSeconds());
                sb.append(", ");
            }
            if (isPrivate()) {
                sb.append("private, ");
            }
            if (isPublic()) {
                sb.append("public, ");
            }
            if (mustRevalidate()) {
                sb.append("must-revalidate, ");
            }
            if (maxStaleSeconds() != -1) {
                sb.append("max-stale=");
                sb.append(maxStaleSeconds());
                sb.append(", ");
            }
            if (minFreshSeconds() != -1) {
                sb.append("min-fresh=");
                sb.append(minFreshSeconds());
                sb.append(", ");
            }
            if (onlyIfCached()) {
                sb.append("only-if-cached, ");
            }
            if (noTransform()) {
                sb.append("no-transform, ");
            }
            if (immutable()) {
                sb.append("immutable, ");
            }
            if (sb.length() == 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7) {
                return "";
            }
            sb.delete(sb.length() - 2, sb.length());
            String sb2 = sb.toString();
            Intrinsics.e(sb2, "StringBuilder().apply(builderAction).toString()");
            this.headerValue = sb2;
            return sb2;
        }
        return str;
    }
}
