package com.google.firebase.perf.network;

import com.google.firebase.perf.impl.NetworkRequestMetricBuilder;
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

/* loaded from: classes3.dex */
public final class InstrHttpURLConnection extends HttpURLConnection {

    /* renamed from: a  reason: collision with root package name */
    private final InstrURLConnectionBase f16801a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public InstrHttpURLConnection(HttpURLConnection httpURLConnection, Timer timer, NetworkRequestMetricBuilder networkRequestMetricBuilder) {
        super(httpURLConnection.getURL());
        this.f16801a = new InstrURLConnectionBase(httpURLConnection, timer, networkRequestMetricBuilder);
    }

    @Override // java.net.URLConnection
    public void addRequestProperty(String str, String str2) {
        this.f16801a.a(str, str2);
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
        this.f16801a.b();
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        this.f16801a.c();
    }

    public boolean equals(Object obj) {
        return this.f16801a.equals(obj);
    }

    @Override // java.net.URLConnection
    public boolean getAllowUserInteraction() {
        return this.f16801a.d();
    }

    @Override // java.net.URLConnection
    public int getConnectTimeout() {
        return this.f16801a.e();
    }

    @Override // java.net.URLConnection
    public Object getContent() throws IOException {
        return this.f16801a.f();
    }

    @Override // java.net.URLConnection
    public String getContentEncoding() {
        return this.f16801a.h();
    }

    @Override // java.net.URLConnection
    public int getContentLength() {
        return this.f16801a.i();
    }

    @Override // java.net.URLConnection
    public long getContentLengthLong() {
        return this.f16801a.j();
    }

    @Override // java.net.URLConnection
    public String getContentType() {
        return this.f16801a.k();
    }

    @Override // java.net.URLConnection
    public long getDate() {
        return this.f16801a.l();
    }

    @Override // java.net.URLConnection
    public boolean getDefaultUseCaches() {
        return this.f16801a.m();
    }

    @Override // java.net.URLConnection
    public boolean getDoInput() {
        return this.f16801a.n();
    }

    @Override // java.net.URLConnection
    public boolean getDoOutput() {
        return this.f16801a.o();
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        return this.f16801a.p();
    }

    @Override // java.net.URLConnection
    public long getExpiration() {
        return this.f16801a.q();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public String getHeaderField(int i8) {
        return this.f16801a.r(i8);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public long getHeaderFieldDate(String str, long j8) {
        return this.f16801a.t(str, j8);
    }

    @Override // java.net.URLConnection
    public int getHeaderFieldInt(String str, int i8) {
        return this.f16801a.u(str, i8);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public String getHeaderFieldKey(int i8) {
        return this.f16801a.v(i8);
    }

    @Override // java.net.URLConnection
    public long getHeaderFieldLong(String str, long j8) {
        return this.f16801a.w(str, j8);
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        return this.f16801a.x();
    }

    @Override // java.net.URLConnection
    public long getIfModifiedSince() {
        return this.f16801a.y();
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() throws IOException {
        return this.f16801a.z();
    }

    @Override // java.net.HttpURLConnection
    public boolean getInstanceFollowRedirects() {
        return this.f16801a.A();
    }

    @Override // java.net.URLConnection
    public long getLastModified() {
        return this.f16801a.B();
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        return this.f16801a.C();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public Permission getPermission() throws IOException {
        return this.f16801a.D();
    }

    @Override // java.net.URLConnection
    public int getReadTimeout() {
        return this.f16801a.E();
    }

    @Override // java.net.HttpURLConnection
    public String getRequestMethod() {
        return this.f16801a.F();
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getRequestProperties() {
        return this.f16801a.G();
    }

    @Override // java.net.URLConnection
    public String getRequestProperty(String str) {
        return this.f16801a.H(str);
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        return this.f16801a.I();
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() throws IOException {
        return this.f16801a.J();
    }

    @Override // java.net.URLConnection
    public URL getURL() {
        return this.f16801a.K();
    }

    @Override // java.net.URLConnection
    public boolean getUseCaches() {
        return this.f16801a.L();
    }

    public int hashCode() {
        return this.f16801a.hashCode();
    }

    @Override // java.net.URLConnection
    public void setAllowUserInteraction(boolean z7) {
        this.f16801a.M(z7);
    }

    @Override // java.net.HttpURLConnection
    public void setChunkedStreamingMode(int i8) {
        this.f16801a.N(i8);
    }

    @Override // java.net.URLConnection
    public void setConnectTimeout(int i8) {
        this.f16801a.O(i8);
    }

    @Override // java.net.URLConnection
    public void setDefaultUseCaches(boolean z7) {
        this.f16801a.P(z7);
    }

    @Override // java.net.URLConnection
    public void setDoInput(boolean z7) {
        this.f16801a.Q(z7);
    }

    @Override // java.net.URLConnection
    public void setDoOutput(boolean z7) {
        this.f16801a.R(z7);
    }

    @Override // java.net.HttpURLConnection
    public void setFixedLengthStreamingMode(int i8) {
        this.f16801a.S(i8);
    }

    @Override // java.net.URLConnection
    public void setIfModifiedSince(long j8) {
        this.f16801a.U(j8);
    }

    @Override // java.net.HttpURLConnection
    public void setInstanceFollowRedirects(boolean z7) {
        this.f16801a.V(z7);
    }

    @Override // java.net.URLConnection
    public void setReadTimeout(int i8) {
        this.f16801a.W(i8);
    }

    @Override // java.net.HttpURLConnection
    public void setRequestMethod(String str) throws ProtocolException {
        this.f16801a.X(str);
    }

    @Override // java.net.URLConnection
    public void setRequestProperty(String str, String str2) {
        this.f16801a.Y(str, str2);
    }

    @Override // java.net.URLConnection
    public void setUseCaches(boolean z7) {
        this.f16801a.Z(z7);
    }

    @Override // java.net.URLConnection
    public String toString() {
        return this.f16801a.toString();
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        return this.f16801a.b0();
    }

    @Override // java.net.URLConnection
    public Object getContent(Class[] clsArr) throws IOException {
        return this.f16801a.g(clsArr);
    }

    @Override // java.net.URLConnection
    public String getHeaderField(String str) {
        return this.f16801a.s(str);
    }

    @Override // java.net.HttpURLConnection
    public void setFixedLengthStreamingMode(long j8) {
        this.f16801a.T(j8);
    }
}
