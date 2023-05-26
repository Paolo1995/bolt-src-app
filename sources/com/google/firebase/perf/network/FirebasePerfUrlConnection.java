package com.google.firebase.perf.network;

import androidx.annotation.Keep;
import com.google.firebase.perf.impl.NetworkRequestMetricBuilder;
import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.util.URLWrapper;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;

/* loaded from: classes3.dex */
public class FirebasePerfUrlConnection {
    private FirebasePerfUrlConnection() {
    }

    static Object a(URLWrapper uRLWrapper, TransportManager transportManager, Timer timer) throws IOException {
        timer.e();
        long d8 = timer.d();
        NetworkRequestMetricBuilder c8 = NetworkRequestMetricBuilder.c(transportManager);
        try {
            URLConnection a8 = uRLWrapper.a();
            if (a8 instanceof HttpsURLConnection) {
                return new InstrHttpsURLConnection((HttpsURLConnection) a8, timer, c8).getContent();
            }
            if (a8 instanceof HttpURLConnection) {
                return new InstrHttpURLConnection((HttpURLConnection) a8, timer, c8).getContent();
            }
            return a8.getContent();
        } catch (IOException e8) {
            c8.p(d8);
            c8.t(timer.b());
            c8.v(uRLWrapper.toString());
            NetworkRequestMetricBuilderUtil.d(c8);
            throw e8;
        }
    }

    static Object b(URLWrapper uRLWrapper, Class[] clsArr, TransportManager transportManager, Timer timer) throws IOException {
        timer.e();
        long d8 = timer.d();
        NetworkRequestMetricBuilder c8 = NetworkRequestMetricBuilder.c(transportManager);
        try {
            URLConnection a8 = uRLWrapper.a();
            if (a8 instanceof HttpsURLConnection) {
                return new InstrHttpsURLConnection((HttpsURLConnection) a8, timer, c8).getContent(clsArr);
            }
            if (a8 instanceof HttpURLConnection) {
                return new InstrHttpURLConnection((HttpURLConnection) a8, timer, c8).getContent(clsArr);
            }
            return a8.getContent(clsArr);
        } catch (IOException e8) {
            c8.p(d8);
            c8.t(timer.b());
            c8.v(uRLWrapper.toString());
            NetworkRequestMetricBuilderUtil.d(c8);
            throw e8;
        }
    }

    static InputStream c(URLWrapper uRLWrapper, TransportManager transportManager, Timer timer) throws IOException {
        timer.e();
        long d8 = timer.d();
        NetworkRequestMetricBuilder c8 = NetworkRequestMetricBuilder.c(transportManager);
        try {
            URLConnection a8 = uRLWrapper.a();
            if (a8 instanceof HttpsURLConnection) {
                return new InstrHttpsURLConnection((HttpsURLConnection) a8, timer, c8).getInputStream();
            }
            if (a8 instanceof HttpURLConnection) {
                return new InstrHttpURLConnection((HttpURLConnection) a8, timer, c8).getInputStream();
            }
            return a8.getInputStream();
        } catch (IOException e8) {
            c8.p(d8);
            c8.t(timer.b());
            c8.v(uRLWrapper.toString());
            NetworkRequestMetricBuilderUtil.d(c8);
            throw e8;
        }
    }

    @Keep
    public static Object getContent(URL url) throws IOException {
        return a(new URLWrapper(url), TransportManager.e(), new Timer());
    }

    @Keep
    public static Object instrument(Object obj) throws IOException {
        if (obj instanceof HttpsURLConnection) {
            return new InstrHttpsURLConnection((HttpsURLConnection) obj, new Timer(), NetworkRequestMetricBuilder.c(TransportManager.e()));
        }
        if (obj instanceof HttpURLConnection) {
            return new InstrHttpURLConnection((HttpURLConnection) obj, new Timer(), NetworkRequestMetricBuilder.c(TransportManager.e()));
        }
        return obj;
    }

    @Keep
    public static InputStream openStream(URL url) throws IOException {
        return c(new URLWrapper(url), TransportManager.e(), new Timer());
    }

    @Keep
    public static Object getContent(URL url, Class[] clsArr) throws IOException {
        return b(new URLWrapper(url), clsArr, TransportManager.e(), new Timer());
    }
}
