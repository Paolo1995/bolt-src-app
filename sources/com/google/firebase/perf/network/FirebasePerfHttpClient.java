package com.google.firebase.perf.network;

import androidx.annotation.Keep;
import com.google.firebase.perf.impl.NetworkRequestMetricBuilder;
import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.util.Timer;
import java.io.IOException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.HttpContext;

/* loaded from: classes3.dex */
public class FirebasePerfHttpClient {
    private FirebasePerfHttpClient() {
    }

    static <T> T a(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler, Timer timer, TransportManager transportManager) throws IOException {
        NetworkRequestMetricBuilder c8 = NetworkRequestMetricBuilder.c(transportManager);
        try {
            c8.v(httpHost.toURI() + httpRequest.getRequestLine().getUri()).j(httpRequest.getRequestLine().getMethod());
            Long a8 = NetworkRequestMetricBuilderUtil.a(httpRequest);
            if (a8 != null) {
                c8.o(a8.longValue());
            }
            timer.e();
            c8.p(timer.d());
            return (T) httpClient.execute(httpHost, httpRequest, new InstrumentApacheHttpResponseHandler(responseHandler, timer, c8));
        } catch (IOException e8) {
            c8.t(timer.b());
            NetworkRequestMetricBuilderUtil.d(c8);
            throw e8;
        }
    }

    static <T> T b(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext, Timer timer, TransportManager transportManager) throws IOException {
        NetworkRequestMetricBuilder c8 = NetworkRequestMetricBuilder.c(transportManager);
        try {
            c8.v(httpHost.toURI() + httpRequest.getRequestLine().getUri()).j(httpRequest.getRequestLine().getMethod());
            Long a8 = NetworkRequestMetricBuilderUtil.a(httpRequest);
            if (a8 != null) {
                c8.o(a8.longValue());
            }
            timer.e();
            c8.p(timer.d());
            return (T) httpClient.execute(httpHost, httpRequest, new InstrumentApacheHttpResponseHandler(responseHandler, timer, c8), httpContext);
        } catch (IOException e8) {
            c8.t(timer.b());
            NetworkRequestMetricBuilderUtil.d(c8);
            throw e8;
        }
    }

    static <T> T c(HttpClient httpClient, HttpUriRequest httpUriRequest, ResponseHandler<T> responseHandler, Timer timer, TransportManager transportManager) throws IOException {
        NetworkRequestMetricBuilder c8 = NetworkRequestMetricBuilder.c(transportManager);
        try {
            c8.v(httpUriRequest.getURI().toString()).j(httpUriRequest.getMethod());
            Long a8 = NetworkRequestMetricBuilderUtil.a(httpUriRequest);
            if (a8 != null) {
                c8.o(a8.longValue());
            }
            timer.e();
            c8.p(timer.d());
            return (T) httpClient.execute(httpUriRequest, new InstrumentApacheHttpResponseHandler(responseHandler, timer, c8));
        } catch (IOException e8) {
            c8.t(timer.b());
            NetworkRequestMetricBuilderUtil.d(c8);
            throw e8;
        }
    }

    static <T> T d(HttpClient httpClient, HttpUriRequest httpUriRequest, ResponseHandler<T> responseHandler, HttpContext httpContext, Timer timer, TransportManager transportManager) throws IOException {
        NetworkRequestMetricBuilder c8 = NetworkRequestMetricBuilder.c(transportManager);
        try {
            c8.v(httpUriRequest.getURI().toString()).j(httpUriRequest.getMethod());
            Long a8 = NetworkRequestMetricBuilderUtil.a(httpUriRequest);
            if (a8 != null) {
                c8.o(a8.longValue());
            }
            timer.e();
            c8.p(timer.d());
            return (T) httpClient.execute(httpUriRequest, new InstrumentApacheHttpResponseHandler(responseHandler, timer, c8), httpContext);
        } catch (IOException e8) {
            c8.t(timer.b());
            NetworkRequestMetricBuilderUtil.d(c8);
            throw e8;
        }
    }

    static HttpResponse e(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, Timer timer, TransportManager transportManager) throws IOException {
        NetworkRequestMetricBuilder c8 = NetworkRequestMetricBuilder.c(transportManager);
        try {
            c8.v(httpHost.toURI() + httpRequest.getRequestLine().getUri()).j(httpRequest.getRequestLine().getMethod());
            Long a8 = NetworkRequestMetricBuilderUtil.a(httpRequest);
            if (a8 != null) {
                c8.o(a8.longValue());
            }
            timer.e();
            c8.p(timer.d());
            HttpResponse execute = httpClient.execute(httpHost, httpRequest);
            c8.t(timer.b());
            c8.l(execute.getStatusLine().getStatusCode());
            Long a9 = NetworkRequestMetricBuilderUtil.a(execute);
            if (a9 != null) {
                c8.r(a9.longValue());
            }
            String b8 = NetworkRequestMetricBuilderUtil.b(execute);
            if (b8 != null) {
                c8.q(b8);
            }
            c8.b();
            return execute;
        } catch (IOException e8) {
            c8.t(timer.b());
            NetworkRequestMetricBuilderUtil.d(c8);
            throw e8;
        }
    }

    @Keep
    public static HttpResponse execute(HttpClient httpClient, HttpUriRequest httpUriRequest) throws IOException {
        return g(httpClient, httpUriRequest, new Timer(), TransportManager.e());
    }

    static HttpResponse f(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext, Timer timer, TransportManager transportManager) throws IOException {
        NetworkRequestMetricBuilder c8 = NetworkRequestMetricBuilder.c(transportManager);
        try {
            c8.v(httpHost.toURI() + httpRequest.getRequestLine().getUri()).j(httpRequest.getRequestLine().getMethod());
            Long a8 = NetworkRequestMetricBuilderUtil.a(httpRequest);
            if (a8 != null) {
                c8.o(a8.longValue());
            }
            timer.e();
            c8.p(timer.d());
            HttpResponse execute = httpClient.execute(httpHost, httpRequest, httpContext);
            c8.t(timer.b());
            c8.l(execute.getStatusLine().getStatusCode());
            Long a9 = NetworkRequestMetricBuilderUtil.a(execute);
            if (a9 != null) {
                c8.r(a9.longValue());
            }
            String b8 = NetworkRequestMetricBuilderUtil.b(execute);
            if (b8 != null) {
                c8.q(b8);
            }
            c8.b();
            return execute;
        } catch (IOException e8) {
            c8.t(timer.b());
            NetworkRequestMetricBuilderUtil.d(c8);
            throw e8;
        }
    }

    static HttpResponse g(HttpClient httpClient, HttpUriRequest httpUriRequest, Timer timer, TransportManager transportManager) throws IOException {
        NetworkRequestMetricBuilder c8 = NetworkRequestMetricBuilder.c(transportManager);
        try {
            c8.v(httpUriRequest.getURI().toString()).j(httpUriRequest.getMethod());
            Long a8 = NetworkRequestMetricBuilderUtil.a(httpUriRequest);
            if (a8 != null) {
                c8.o(a8.longValue());
            }
            timer.e();
            c8.p(timer.d());
            HttpResponse execute = httpClient.execute(httpUriRequest);
            c8.t(timer.b());
            c8.l(execute.getStatusLine().getStatusCode());
            Long a9 = NetworkRequestMetricBuilderUtil.a(execute);
            if (a9 != null) {
                c8.r(a9.longValue());
            }
            String b8 = NetworkRequestMetricBuilderUtil.b(execute);
            if (b8 != null) {
                c8.q(b8);
            }
            c8.b();
            return execute;
        } catch (IOException e8) {
            c8.t(timer.b());
            NetworkRequestMetricBuilderUtil.d(c8);
            throw e8;
        }
    }

    static HttpResponse h(HttpClient httpClient, HttpUriRequest httpUriRequest, HttpContext httpContext, Timer timer, TransportManager transportManager) throws IOException {
        NetworkRequestMetricBuilder c8 = NetworkRequestMetricBuilder.c(transportManager);
        try {
            c8.v(httpUriRequest.getURI().toString()).j(httpUriRequest.getMethod());
            Long a8 = NetworkRequestMetricBuilderUtil.a(httpUriRequest);
            if (a8 != null) {
                c8.o(a8.longValue());
            }
            timer.e();
            c8.p(timer.d());
            HttpResponse execute = httpClient.execute(httpUriRequest, httpContext);
            c8.t(timer.b());
            c8.l(execute.getStatusLine().getStatusCode());
            Long a9 = NetworkRequestMetricBuilderUtil.a(execute);
            if (a9 != null) {
                c8.r(a9.longValue());
            }
            String b8 = NetworkRequestMetricBuilderUtil.b(execute);
            if (b8 != null) {
                c8.q(b8);
            }
            c8.b();
            return execute;
        } catch (IOException e8) {
            c8.t(timer.b());
            NetworkRequestMetricBuilderUtil.d(c8);
            throw e8;
        }
    }

    @Keep
    public static HttpResponse execute(HttpClient httpClient, HttpUriRequest httpUriRequest, HttpContext httpContext) throws IOException {
        return h(httpClient, httpUriRequest, httpContext, new Timer(), TransportManager.e());
    }

    @Keep
    public static <T> T execute(HttpClient httpClient, HttpUriRequest httpUriRequest, ResponseHandler<T> responseHandler) throws IOException {
        return (T) c(httpClient, httpUriRequest, responseHandler, new Timer(), TransportManager.e());
    }

    @Keep
    public static <T> T execute(HttpClient httpClient, HttpUriRequest httpUriRequest, ResponseHandler<T> responseHandler, HttpContext httpContext) throws IOException {
        return (T) d(httpClient, httpUriRequest, responseHandler, httpContext, new Timer(), TransportManager.e());
    }

    @Keep
    public static HttpResponse execute(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest) throws IOException {
        return e(httpClient, httpHost, httpRequest, new Timer(), TransportManager.e());
    }

    @Keep
    public static HttpResponse execute(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) throws IOException {
        return f(httpClient, httpHost, httpRequest, httpContext, new Timer(), TransportManager.e());
    }

    @Keep
    public static <T> T execute(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler) throws IOException {
        return (T) a(httpClient, httpHost, httpRequest, responseHandler, new Timer(), TransportManager.e());
    }

    @Keep
    public static <T> T execute(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) throws IOException {
        return (T) b(httpClient, httpHost, httpRequest, responseHandler, httpContext, new Timer(), TransportManager.e());
    }
}
