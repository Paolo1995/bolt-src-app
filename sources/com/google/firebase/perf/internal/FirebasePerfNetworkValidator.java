package com.google.firebase.perf.internal;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.util.URLAllowlist;
import com.google.firebase.perf.v1.NetworkRequestMetric;
import java.net.URI;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class FirebasePerfNetworkValidator extends PerfMetricValidator {

    /* renamed from: c  reason: collision with root package name */
    private static final AndroidLogger f16732c = AndroidLogger.e();

    /* renamed from: a  reason: collision with root package name */
    private final NetworkRequestMetric f16733a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f16734b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FirebasePerfNetworkValidator(NetworkRequestMetric networkRequestMetric, Context context) {
        this.f16734b = context;
        this.f16733a = networkRequestMetric;
    }

    private URI g(String str) {
        if (str == null) {
            return null;
        }
        try {
            return URI.create(str);
        } catch (IllegalArgumentException | IllegalStateException e8) {
            f16732c.j("getResultUrl throws exception %s", e8.getMessage());
            return null;
        }
    }

    private boolean h(URI uri, @NonNull Context context) {
        if (uri == null) {
            return false;
        }
        return URLAllowlist.a(uri, context);
    }

    private boolean i(String str) {
        if (str == null) {
            return true;
        }
        return str.trim().isEmpty();
    }

    private boolean j(String str) {
        return i(str);
    }

    private boolean k(String str) {
        if (str != null && !i(str) && str.length() <= 255) {
            return true;
        }
        return false;
    }

    private boolean m(int i8) {
        return i8 > 0;
    }

    private boolean n(long j8) {
        return j8 >= 0;
    }

    private boolean o(int i8) {
        return i8 == -1 || i8 > 0;
    }

    private boolean p(String str) {
        if (str == null) {
            return false;
        }
        if (!"http".equalsIgnoreCase(str) && !"https".equalsIgnoreCase(str)) {
            return false;
        }
        return true;
    }

    private boolean q(long j8) {
        return j8 >= 0;
    }

    private boolean r(String str) {
        return str == null;
    }

    @Override // com.google.firebase.perf.internal.PerfMetricValidator
    public boolean c() {
        NetworkRequestMetric.HttpMethod httpMethod;
        if (j(this.f16733a.getUrl())) {
            AndroidLogger androidLogger = f16732c;
            androidLogger.f("URL is missing:" + this.f16733a.getUrl());
            return false;
        }
        URI g8 = g(this.f16733a.getUrl());
        if (g8 == null) {
            f16732c.f("URL cannot be parsed");
            return false;
        } else if (!h(g8, this.f16734b)) {
            AndroidLogger androidLogger2 = f16732c;
            androidLogger2.f("URL fails allowlist rule: " + g8);
            return false;
        } else if (!k(g8.getHost())) {
            f16732c.f("URL host is null or invalid");
            return false;
        } else if (!p(g8.getScheme())) {
            f16732c.f("URL scheme is null or invalid");
            return false;
        } else if (!r(g8.getUserInfo())) {
            f16732c.f("URL user info is null");
            return false;
        } else if (!o(g8.getPort())) {
            f16732c.f("URL port is less than or equal to 0");
            return false;
        } else {
            if (this.f16733a.hasHttpMethod()) {
                httpMethod = this.f16733a.getHttpMethod();
            } else {
                httpMethod = null;
            }
            if (!l(httpMethod)) {
                AndroidLogger androidLogger3 = f16732c;
                androidLogger3.f("HTTP Method is null or invalid: " + this.f16733a.getHttpMethod());
                return false;
            } else if (this.f16733a.hasHttpResponseCode() && !m(this.f16733a.getHttpResponseCode())) {
                AndroidLogger androidLogger4 = f16732c;
                androidLogger4.f("HTTP ResponseCode is a negative value:" + this.f16733a.getHttpResponseCode());
                return false;
            } else if (this.f16733a.hasRequestPayloadBytes() && !n(this.f16733a.getRequestPayloadBytes())) {
                AndroidLogger androidLogger5 = f16732c;
                androidLogger5.f("Request Payload is a negative value:" + this.f16733a.getRequestPayloadBytes());
                return false;
            } else if (this.f16733a.hasResponsePayloadBytes() && !n(this.f16733a.getResponsePayloadBytes())) {
                AndroidLogger androidLogger6 = f16732c;
                androidLogger6.f("Response Payload is a negative value:" + this.f16733a.getResponsePayloadBytes());
                return false;
            } else if (this.f16733a.hasClientStartTimeUs() && this.f16733a.getClientStartTimeUs() > 0) {
                if (this.f16733a.hasTimeToRequestCompletedUs() && !q(this.f16733a.getTimeToRequestCompletedUs())) {
                    AndroidLogger androidLogger7 = f16732c;
                    androidLogger7.f("Time to complete the request is a negative value:" + this.f16733a.getTimeToRequestCompletedUs());
                    return false;
                } else if (this.f16733a.hasTimeToResponseInitiatedUs() && !q(this.f16733a.getTimeToResponseInitiatedUs())) {
                    AndroidLogger androidLogger8 = f16732c;
                    androidLogger8.f("Time from the start of the request to the start of the response is null or a negative value:" + this.f16733a.getTimeToResponseInitiatedUs());
                    return false;
                } else if (this.f16733a.hasTimeToResponseCompletedUs() && this.f16733a.getTimeToResponseCompletedUs() > 0) {
                    if (!this.f16733a.hasHttpResponseCode()) {
                        f16732c.f("Did not receive a HTTP Response Code");
                        return false;
                    }
                    return true;
                } else {
                    AndroidLogger androidLogger9 = f16732c;
                    androidLogger9.f("Time from the start of the request to the end of the response is null, negative or zero:" + this.f16733a.getTimeToResponseCompletedUs());
                    return false;
                }
            } else {
                AndroidLogger androidLogger10 = f16732c;
                androidLogger10.f("Start time of the request is null, or zero, or a negative value:" + this.f16733a.getClientStartTimeUs());
                return false;
            }
        }
    }

    boolean l(NetworkRequestMetric.HttpMethod httpMethod) {
        if (httpMethod != null && httpMethod != NetworkRequestMetric.HttpMethod.HTTP_METHOD_UNKNOWN) {
            return true;
        }
        return false;
    }
}
