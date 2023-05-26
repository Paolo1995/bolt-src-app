package com.google.firebase.perf.network;

import android.os.Build;
import com.google.firebase.perf.impl.NetworkRequestMetricBuilder;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.util.Timer;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.security.Permission;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class InstrURLConnectionBase {

    /* renamed from: f  reason: collision with root package name */
    private static final AndroidLogger f16804f = AndroidLogger.e();

    /* renamed from: a  reason: collision with root package name */
    private final HttpURLConnection f16805a;

    /* renamed from: b  reason: collision with root package name */
    private final NetworkRequestMetricBuilder f16806b;

    /* renamed from: c  reason: collision with root package name */
    private long f16807c = -1;

    /* renamed from: d  reason: collision with root package name */
    private long f16808d = -1;

    /* renamed from: e  reason: collision with root package name */
    private final Timer f16809e;

    public InstrURLConnectionBase(HttpURLConnection httpURLConnection, Timer timer, NetworkRequestMetricBuilder networkRequestMetricBuilder) {
        this.f16805a = httpURLConnection;
        this.f16806b = networkRequestMetricBuilder;
        this.f16809e = timer;
        networkRequestMetricBuilder.v(httpURLConnection.getURL().toString());
    }

    private void a0() {
        if (this.f16807c == -1) {
            this.f16809e.e();
            long d8 = this.f16809e.d();
            this.f16807c = d8;
            this.f16806b.p(d8);
        }
        String F = F();
        if (F != null) {
            this.f16806b.j(F);
        } else if (o()) {
            this.f16806b.j("POST");
        } else {
            this.f16806b.j("GET");
        }
    }

    public boolean A() {
        return this.f16805a.getInstanceFollowRedirects();
    }

    public long B() {
        a0();
        return this.f16805a.getLastModified();
    }

    public OutputStream C() throws IOException {
        try {
            return new InstrHttpOutputStream(this.f16805a.getOutputStream(), this.f16806b, this.f16809e);
        } catch (IOException e8) {
            this.f16806b.t(this.f16809e.b());
            NetworkRequestMetricBuilderUtil.d(this.f16806b);
            throw e8;
        }
    }

    public Permission D() throws IOException {
        try {
            return this.f16805a.getPermission();
        } catch (IOException e8) {
            this.f16806b.t(this.f16809e.b());
            NetworkRequestMetricBuilderUtil.d(this.f16806b);
            throw e8;
        }
    }

    public int E() {
        return this.f16805a.getReadTimeout();
    }

    public String F() {
        return this.f16805a.getRequestMethod();
    }

    public Map<String, List<String>> G() {
        return this.f16805a.getRequestProperties();
    }

    public String H(String str) {
        return this.f16805a.getRequestProperty(str);
    }

    public int I() throws IOException {
        a0();
        if (this.f16808d == -1) {
            long b8 = this.f16809e.b();
            this.f16808d = b8;
            this.f16806b.u(b8);
        }
        try {
            int responseCode = this.f16805a.getResponseCode();
            this.f16806b.l(responseCode);
            return responseCode;
        } catch (IOException e8) {
            this.f16806b.t(this.f16809e.b());
            NetworkRequestMetricBuilderUtil.d(this.f16806b);
            throw e8;
        }
    }

    public String J() throws IOException {
        a0();
        if (this.f16808d == -1) {
            long b8 = this.f16809e.b();
            this.f16808d = b8;
            this.f16806b.u(b8);
        }
        try {
            String responseMessage = this.f16805a.getResponseMessage();
            this.f16806b.l(this.f16805a.getResponseCode());
            return responseMessage;
        } catch (IOException e8) {
            this.f16806b.t(this.f16809e.b());
            NetworkRequestMetricBuilderUtil.d(this.f16806b);
            throw e8;
        }
    }

    public URL K() {
        return this.f16805a.getURL();
    }

    public boolean L() {
        return this.f16805a.getUseCaches();
    }

    public void M(boolean z7) {
        this.f16805a.setAllowUserInteraction(z7);
    }

    public void N(int i8) {
        this.f16805a.setChunkedStreamingMode(i8);
    }

    public void O(int i8) {
        this.f16805a.setConnectTimeout(i8);
    }

    public void P(boolean z7) {
        this.f16805a.setDefaultUseCaches(z7);
    }

    public void Q(boolean z7) {
        this.f16805a.setDoInput(z7);
    }

    public void R(boolean z7) {
        this.f16805a.setDoOutput(z7);
    }

    public void S(int i8) {
        this.f16805a.setFixedLengthStreamingMode(i8);
    }

    public void T(long j8) {
        this.f16805a.setFixedLengthStreamingMode(j8);
    }

    public void U(long j8) {
        this.f16805a.setIfModifiedSince(j8);
    }

    public void V(boolean z7) {
        this.f16805a.setInstanceFollowRedirects(z7);
    }

    public void W(int i8) {
        this.f16805a.setReadTimeout(i8);
    }

    public void X(String str) throws ProtocolException {
        this.f16805a.setRequestMethod(str);
    }

    public void Y(String str, String str2) {
        if ("User-Agent".equalsIgnoreCase(str)) {
            this.f16806b.x(str2);
        }
        this.f16805a.setRequestProperty(str, str2);
    }

    public void Z(boolean z7) {
        this.f16805a.setUseCaches(z7);
    }

    public void a(String str, String str2) {
        this.f16805a.addRequestProperty(str, str2);
    }

    public void b() throws IOException {
        if (this.f16807c == -1) {
            this.f16809e.e();
            long d8 = this.f16809e.d();
            this.f16807c = d8;
            this.f16806b.p(d8);
        }
        try {
            this.f16805a.connect();
        } catch (IOException e8) {
            this.f16806b.t(this.f16809e.b());
            NetworkRequestMetricBuilderUtil.d(this.f16806b);
            throw e8;
        }
    }

    public boolean b0() {
        return this.f16805a.usingProxy();
    }

    public void c() {
        this.f16806b.t(this.f16809e.b());
        this.f16806b.b();
        this.f16805a.disconnect();
    }

    public boolean d() {
        return this.f16805a.getAllowUserInteraction();
    }

    public int e() {
        return this.f16805a.getConnectTimeout();
    }

    public boolean equals(Object obj) {
        return this.f16805a.equals(obj);
    }

    public Object f() throws IOException {
        a0();
        this.f16806b.l(this.f16805a.getResponseCode());
        try {
            Object content = this.f16805a.getContent();
            if (content instanceof InputStream) {
                this.f16806b.q(this.f16805a.getContentType());
                return new InstrHttpInputStream((InputStream) content, this.f16806b, this.f16809e);
            }
            this.f16806b.q(this.f16805a.getContentType());
            this.f16806b.r(this.f16805a.getContentLength());
            this.f16806b.t(this.f16809e.b());
            this.f16806b.b();
            return content;
        } catch (IOException e8) {
            this.f16806b.t(this.f16809e.b());
            NetworkRequestMetricBuilderUtil.d(this.f16806b);
            throw e8;
        }
    }

    public Object g(Class[] clsArr) throws IOException {
        a0();
        this.f16806b.l(this.f16805a.getResponseCode());
        try {
            Object content = this.f16805a.getContent(clsArr);
            if (content instanceof InputStream) {
                this.f16806b.q(this.f16805a.getContentType());
                return new InstrHttpInputStream((InputStream) content, this.f16806b, this.f16809e);
            }
            this.f16806b.q(this.f16805a.getContentType());
            this.f16806b.r(this.f16805a.getContentLength());
            this.f16806b.t(this.f16809e.b());
            this.f16806b.b();
            return content;
        } catch (IOException e8) {
            this.f16806b.t(this.f16809e.b());
            NetworkRequestMetricBuilderUtil.d(this.f16806b);
            throw e8;
        }
    }

    public String h() {
        a0();
        return this.f16805a.getContentEncoding();
    }

    public int hashCode() {
        return this.f16805a.hashCode();
    }

    public int i() {
        a0();
        return this.f16805a.getContentLength();
    }

    public long j() {
        long contentLengthLong;
        a0();
        if (Build.VERSION.SDK_INT >= 24) {
            contentLengthLong = this.f16805a.getContentLengthLong();
            return contentLengthLong;
        }
        return 0L;
    }

    public String k() {
        a0();
        return this.f16805a.getContentType();
    }

    public long l() {
        a0();
        return this.f16805a.getDate();
    }

    public boolean m() {
        return this.f16805a.getDefaultUseCaches();
    }

    public boolean n() {
        return this.f16805a.getDoInput();
    }

    public boolean o() {
        return this.f16805a.getDoOutput();
    }

    public InputStream p() {
        a0();
        try {
            this.f16806b.l(this.f16805a.getResponseCode());
        } catch (IOException unused) {
            f16804f.a("IOException thrown trying to obtain the response code");
        }
        InputStream errorStream = this.f16805a.getErrorStream();
        if (errorStream != null) {
            return new InstrHttpInputStream(errorStream, this.f16806b, this.f16809e);
        }
        return errorStream;
    }

    public long q() {
        a0();
        return this.f16805a.getExpiration();
    }

    public String r(int i8) {
        a0();
        return this.f16805a.getHeaderField(i8);
    }

    public String s(String str) {
        a0();
        return this.f16805a.getHeaderField(str);
    }

    public long t(String str, long j8) {
        a0();
        return this.f16805a.getHeaderFieldDate(str, j8);
    }

    public String toString() {
        return this.f16805a.toString();
    }

    public int u(String str, int i8) {
        a0();
        return this.f16805a.getHeaderFieldInt(str, i8);
    }

    public String v(int i8) {
        a0();
        return this.f16805a.getHeaderFieldKey(i8);
    }

    public long w(String str, long j8) {
        long headerFieldLong;
        a0();
        if (Build.VERSION.SDK_INT >= 24) {
            headerFieldLong = this.f16805a.getHeaderFieldLong(str, j8);
            return headerFieldLong;
        }
        return 0L;
    }

    public Map<String, List<String>> x() {
        a0();
        return this.f16805a.getHeaderFields();
    }

    public long y() {
        return this.f16805a.getIfModifiedSince();
    }

    public InputStream z() throws IOException {
        a0();
        this.f16806b.l(this.f16805a.getResponseCode());
        this.f16806b.q(this.f16805a.getContentType());
        try {
            return new InstrHttpInputStream(this.f16805a.getInputStream(), this.f16806b, this.f16809e);
        } catch (IOException e8) {
            this.f16806b.t(this.f16809e.b());
            NetworkRequestMetricBuilderUtil.d(this.f16806b);
            throw e8;
        }
    }
}
