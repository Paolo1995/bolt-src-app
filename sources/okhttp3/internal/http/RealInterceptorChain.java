package okhttp3.internal.http;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealCall;

/* compiled from: RealInterceptorChain.kt */
/* loaded from: classes5.dex */
public final class RealInterceptorChain implements Interceptor.Chain {
    private final RealCall call;
    private int calls;
    private final int connectTimeoutMillis;
    private final Exchange exchange;
    private final int index;
    private final List<Interceptor> interceptors;
    private final int readTimeoutMillis;
    private final Request request;
    private final int writeTimeoutMillis;

    /* JADX WARN: Multi-variable type inference failed */
    public RealInterceptorChain(RealCall call, List<? extends Interceptor> interceptors, int i8, Exchange exchange, Request request, int i9, int i10, int i11) {
        Intrinsics.f(call, "call");
        Intrinsics.f(interceptors, "interceptors");
        Intrinsics.f(request, "request");
        this.call = call;
        this.interceptors = interceptors;
        this.index = i8;
        this.exchange = exchange;
        this.request = request;
        this.connectTimeoutMillis = i9;
        this.readTimeoutMillis = i10;
        this.writeTimeoutMillis = i11;
    }

    public static /* synthetic */ RealInterceptorChain copy$okhttp$default(RealInterceptorChain realInterceptorChain, int i8, Exchange exchange, Request request, int i9, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i8 = realInterceptorChain.index;
        }
        if ((i12 & 2) != 0) {
            exchange = realInterceptorChain.exchange;
        }
        Exchange exchange2 = exchange;
        if ((i12 & 4) != 0) {
            request = realInterceptorChain.request;
        }
        Request request2 = request;
        if ((i12 & 8) != 0) {
            i9 = realInterceptorChain.connectTimeoutMillis;
        }
        int i13 = i9;
        if ((i12 & 16) != 0) {
            i10 = realInterceptorChain.readTimeoutMillis;
        }
        int i14 = i10;
        if ((i12 & 32) != 0) {
            i11 = realInterceptorChain.writeTimeoutMillis;
        }
        return realInterceptorChain.copy$okhttp(i8, exchange2, request2, i13, i14, i11);
    }

    @Override // okhttp3.Interceptor.Chain
    public Call call() {
        return this.call;
    }

    @Override // okhttp3.Interceptor.Chain
    public int connectTimeoutMillis() {
        return this.connectTimeoutMillis;
    }

    @Override // okhttp3.Interceptor.Chain
    public Connection connection() {
        Exchange exchange = this.exchange;
        if (exchange == null) {
            return null;
        }
        return exchange.getConnection$okhttp();
    }

    public final RealInterceptorChain copy$okhttp(int i8, Exchange exchange, Request request, int i9, int i10, int i11) {
        Intrinsics.f(request, "request");
        return new RealInterceptorChain(this.call, this.interceptors, i8, exchange, request, i9, i10, i11);
    }

    public final RealCall getCall$okhttp() {
        return this.call;
    }

    public final int getConnectTimeoutMillis$okhttp() {
        return this.connectTimeoutMillis;
    }

    public final Exchange getExchange$okhttp() {
        return this.exchange;
    }

    public final int getReadTimeoutMillis$okhttp() {
        return this.readTimeoutMillis;
    }

    public final Request getRequest$okhttp() {
        return this.request;
    }

    public final int getWriteTimeoutMillis$okhttp() {
        return this.writeTimeoutMillis;
    }

    @Override // okhttp3.Interceptor.Chain
    public Response proceed(Request request) throws IOException {
        boolean z7;
        boolean z8;
        boolean z9;
        Intrinsics.f(request, "request");
        boolean z10 = false;
        if (this.index < this.interceptors.size()) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            this.calls++;
            Exchange exchange = this.exchange;
            if (exchange != null) {
                if (exchange.getFinder$okhttp().sameHostAndPort(request.url())) {
                    if (this.calls == 1) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    if (!z9) {
                        throw new IllegalStateException(("network interceptor " + this.interceptors.get(this.index - 1) + " must call proceed() exactly once").toString());
                    }
                } else {
                    throw new IllegalStateException(("network interceptor " + this.interceptors.get(this.index - 1) + " must retain the same host and port").toString());
                }
            }
            RealInterceptorChain copy$okhttp$default = copy$okhttp$default(this, this.index + 1, null, request, 0, 0, 0, 58, null);
            Interceptor interceptor = this.interceptors.get(this.index);
            Response intercept = interceptor.intercept(copy$okhttp$default);
            if (intercept != null) {
                if (this.exchange != null) {
                    if (this.index + 1 < this.interceptors.size() && copy$okhttp$default.calls != 1) {
                        z8 = false;
                    } else {
                        z8 = true;
                    }
                    if (!z8) {
                        throw new IllegalStateException(("network interceptor " + interceptor + " must call proceed() exactly once").toString());
                    }
                }
                if (intercept.body() != null) {
                    z10 = true;
                }
                if (z10) {
                    return intercept;
                }
                throw new IllegalStateException(("interceptor " + interceptor + " returned a response with no body").toString());
            }
            throw new NullPointerException("interceptor " + interceptor + " returned null");
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // okhttp3.Interceptor.Chain
    public int readTimeoutMillis() {
        return this.readTimeoutMillis;
    }

    @Override // okhttp3.Interceptor.Chain
    public Request request() {
        return this.request;
    }

    @Override // okhttp3.Interceptor.Chain
    public Interceptor.Chain withConnectTimeout(int i8, TimeUnit unit) {
        boolean z7;
        Intrinsics.f(unit, "unit");
        if (this.exchange == null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            return copy$okhttp$default(this, 0, null, null, Util.checkDuration("connectTimeout", i8, unit), 0, 0, 55, null);
        }
        throw new IllegalStateException("Timeouts can't be adjusted in a network interceptor".toString());
    }

    @Override // okhttp3.Interceptor.Chain
    public Interceptor.Chain withReadTimeout(int i8, TimeUnit unit) {
        boolean z7;
        Intrinsics.f(unit, "unit");
        if (this.exchange == null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            return copy$okhttp$default(this, 0, null, null, 0, Util.checkDuration("readTimeout", i8, unit), 0, 47, null);
        }
        throw new IllegalStateException("Timeouts can't be adjusted in a network interceptor".toString());
    }

    @Override // okhttp3.Interceptor.Chain
    public Interceptor.Chain withWriteTimeout(int i8, TimeUnit unit) {
        boolean z7;
        Intrinsics.f(unit, "unit");
        if (this.exchange == null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            return copy$okhttp$default(this, 0, null, null, 0, 0, Util.checkDuration("writeTimeout", i8, unit), 31, null);
        }
        throw new IllegalStateException("Timeouts can't be adjusted in a network interceptor".toString());
    }

    @Override // okhttp3.Interceptor.Chain
    public int writeTimeoutMillis() {
        return this.writeTimeoutMillis;
    }
}
