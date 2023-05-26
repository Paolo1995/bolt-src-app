package okhttp3.internal.cache;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.CacheControl;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.http.DatesKt;

/* compiled from: CacheStrategy.kt */
/* loaded from: classes5.dex */
public final class CacheStrategy {
    public static final Companion Companion = new Companion(null);
    private final Response cacheResponse;
    private final Request networkRequest;

    /* compiled from: CacheStrategy.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean isCacheable(Response response, Request request) {
            Intrinsics.f(response, "response");
            Intrinsics.f(request, "request");
            int code = response.code();
            if (code != 200 && code != 410 && code != 414 && code != 501 && code != 203 && code != 204) {
                if (code != 307) {
                    if (code != 308 && code != 404 && code != 405) {
                        switch (code) {
                            case 300:
                            case 301:
                                break;
                            case 302:
                                break;
                            default:
                                return false;
                        }
                    }
                }
                if (Response.header$default(response, "Expires", null, 2, null) == null && response.cacheControl().maxAgeSeconds() == -1 && !response.cacheControl().isPublic() && !response.cacheControl().isPrivate()) {
                    return false;
                }
            }
            if (response.cacheControl().noStore() || request.cacheControl().noStore()) {
                return false;
            }
            return true;
        }
    }

    /* compiled from: CacheStrategy.kt */
    /* loaded from: classes5.dex */
    public static final class Factory {
        private int ageSeconds;
        private final Response cacheResponse;
        private String etag;
        private Date expires;
        private Date lastModified;
        private String lastModifiedString;
        private final long nowMillis;
        private long receivedResponseMillis;
        private final Request request;
        private long sentRequestMillis;
        private Date servedDate;
        private String servedDateString;

        public Factory(long j8, Request request, Response response) {
            boolean w7;
            boolean w8;
            boolean w9;
            boolean w10;
            boolean w11;
            Intrinsics.f(request, "request");
            this.nowMillis = j8;
            this.request = request;
            this.cacheResponse = response;
            this.ageSeconds = -1;
            if (response != null) {
                this.sentRequestMillis = response.sentRequestAtMillis();
                this.receivedResponseMillis = response.receivedResponseAtMillis();
                Headers headers = response.headers();
                int i8 = 0;
                int size = headers.size();
                while (i8 < size) {
                    int i9 = i8 + 1;
                    String name = headers.name(i8);
                    String value = headers.value(i8);
                    w7 = StringsKt__StringsJVMKt.w(name, "Date", true);
                    if (w7) {
                        this.servedDate = DatesKt.toHttpDateOrNull(value);
                        this.servedDateString = value;
                    } else {
                        w8 = StringsKt__StringsJVMKt.w(name, "Expires", true);
                        if (w8) {
                            this.expires = DatesKt.toHttpDateOrNull(value);
                        } else {
                            w9 = StringsKt__StringsJVMKt.w(name, "Last-Modified", true);
                            if (w9) {
                                this.lastModified = DatesKt.toHttpDateOrNull(value);
                                this.lastModifiedString = value;
                            } else {
                                w10 = StringsKt__StringsJVMKt.w(name, "ETag", true);
                                if (w10) {
                                    this.etag = value;
                                } else {
                                    w11 = StringsKt__StringsJVMKt.w(name, "Age", true);
                                    if (w11) {
                                        this.ageSeconds = Util.toNonNegativeInt(value, -1);
                                    }
                                }
                            }
                        }
                    }
                    i8 = i9;
                }
            }
        }

        private final long cacheResponseAge() {
            Date date = this.servedDate;
            long j8 = 0;
            if (date != null) {
                j8 = Math.max(0L, this.receivedResponseMillis - date.getTime());
            }
            int i8 = this.ageSeconds;
            if (i8 != -1) {
                j8 = Math.max(j8, TimeUnit.SECONDS.toMillis(i8));
            }
            long j9 = this.receivedResponseMillis;
            return j8 + (j9 - this.sentRequestMillis) + (this.nowMillis - j9);
        }

        private final CacheStrategy computeCandidate() {
            long j8;
            if (this.cacheResponse == null) {
                return new CacheStrategy(this.request, null);
            }
            if (this.request.isHttps() && this.cacheResponse.handshake() == null) {
                return new CacheStrategy(this.request, null);
            }
            if (!CacheStrategy.Companion.isCacheable(this.cacheResponse, this.request)) {
                return new CacheStrategy(this.request, null);
            }
            CacheControl cacheControl = this.request.cacheControl();
            if (!cacheControl.noCache() && !hasConditions(this.request)) {
                CacheControl cacheControl2 = this.cacheResponse.cacheControl();
                long cacheResponseAge = cacheResponseAge();
                long computeFreshnessLifetime = computeFreshnessLifetime();
                if (cacheControl.maxAgeSeconds() != -1) {
                    computeFreshnessLifetime = Math.min(computeFreshnessLifetime, TimeUnit.SECONDS.toMillis(cacheControl.maxAgeSeconds()));
                }
                long j9 = 0;
                if (cacheControl.minFreshSeconds() != -1) {
                    j8 = TimeUnit.SECONDS.toMillis(cacheControl.minFreshSeconds());
                } else {
                    j8 = 0;
                }
                if (!cacheControl2.mustRevalidate() && cacheControl.maxStaleSeconds() != -1) {
                    j9 = TimeUnit.SECONDS.toMillis(cacheControl.maxStaleSeconds());
                }
                if (!cacheControl2.noCache()) {
                    long j10 = j8 + cacheResponseAge;
                    if (j10 < j9 + computeFreshnessLifetime) {
                        Response.Builder newBuilder = this.cacheResponse.newBuilder();
                        if (j10 >= computeFreshnessLifetime) {
                            newBuilder.addHeader("Warning", "110 HttpURLConnection \"Response is stale\"");
                        }
                        if (cacheResponseAge > 86400000 && isFreshnessLifetimeHeuristic()) {
                            newBuilder.addHeader("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                        }
                        return new CacheStrategy(null, newBuilder.build());
                    }
                }
                String str = this.etag;
                String str2 = "If-Modified-Since";
                if (str != null) {
                    str2 = "If-None-Match";
                } else if (this.lastModified != null) {
                    str = this.lastModifiedString;
                } else if (this.servedDate != null) {
                    str = this.servedDateString;
                } else {
                    return new CacheStrategy(this.request, null);
                }
                Headers.Builder newBuilder2 = this.request.headers().newBuilder();
                Intrinsics.c(str);
                newBuilder2.addLenient$okhttp(str2, str);
                return new CacheStrategy(this.request.newBuilder().headers(newBuilder2.build()).build(), this.cacheResponse);
            }
            return new CacheStrategy(this.request, null);
        }

        private final long computeFreshnessLifetime() {
            long longValue;
            long longValue2;
            Response response = this.cacheResponse;
            Intrinsics.c(response);
            CacheControl cacheControl = response.cacheControl();
            if (cacheControl.maxAgeSeconds() != -1) {
                return TimeUnit.SECONDS.toMillis(cacheControl.maxAgeSeconds());
            }
            Date date = this.expires;
            Long l8 = null;
            if (date != null) {
                Date date2 = this.servedDate;
                if (date2 != null) {
                    l8 = Long.valueOf(date2.getTime());
                }
                if (l8 == null) {
                    longValue2 = this.receivedResponseMillis;
                } else {
                    longValue2 = l8.longValue();
                }
                long time = date.getTime() - longValue2;
                if (time <= 0) {
                    return 0L;
                }
                return time;
            } else if (this.lastModified == null || this.cacheResponse.request().url().query() != null) {
                return 0L;
            } else {
                Date date3 = this.servedDate;
                if (date3 != null) {
                    l8 = Long.valueOf(date3.getTime());
                }
                if (l8 == null) {
                    longValue = this.sentRequestMillis;
                } else {
                    longValue = l8.longValue();
                }
                Date date4 = this.lastModified;
                Intrinsics.c(date4);
                long time2 = longValue - date4.getTime();
                if (time2 <= 0) {
                    return 0L;
                }
                return time2 / 10;
            }
        }

        private final boolean hasConditions(Request request) {
            if (request.header("If-Modified-Since") == null && request.header("If-None-Match") == null) {
                return false;
            }
            return true;
        }

        private final boolean isFreshnessLifetimeHeuristic() {
            Response response = this.cacheResponse;
            Intrinsics.c(response);
            if (response.cacheControl().maxAgeSeconds() == -1 && this.expires == null) {
                return true;
            }
            return false;
        }

        public final CacheStrategy compute() {
            CacheStrategy computeCandidate = computeCandidate();
            if (computeCandidate.getNetworkRequest() != null && this.request.cacheControl().onlyIfCached()) {
                return new CacheStrategy(null, null);
            }
            return computeCandidate;
        }

        public final Request getRequest$okhttp() {
            return this.request;
        }
    }

    public CacheStrategy(Request request, Response response) {
        this.networkRequest = request;
        this.cacheResponse = response;
    }

    public final Response getCacheResponse() {
        return this.cacheResponse;
    }

    public final Request getNetworkRequest() {
        return this.networkRequest;
    }
}
