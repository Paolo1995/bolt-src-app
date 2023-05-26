package com.google.firebase.perf.network;

import com.google.firebase.perf.impl.NetworkRequestMetricBuilder;
import com.google.firebase.perf.util.Timer;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ProtocolException;
import java.net.URL;
import java.security.Permission;
import java.security.Principal;
import java.security.cert.Certificate;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes3.dex */
public final class InstrHttpsURLConnection extends HttpsURLConnection {

    /* renamed from: a  reason: collision with root package name */
    private final InstrURLConnectionBase f16802a;

    /* renamed from: b  reason: collision with root package name */
    private final HttpsURLConnection f16803b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public InstrHttpsURLConnection(HttpsURLConnection httpsURLConnection, Timer timer, NetworkRequestMetricBuilder networkRequestMetricBuilder) {
        super(httpsURLConnection.getURL());
        this.f16803b = httpsURLConnection;
        this.f16802a = new InstrURLConnectionBase(httpsURLConnection, timer, networkRequestMetricBuilder);
    }

    @Override // java.net.URLConnection
    public void addRequestProperty(String str, String str2) {
        this.f16802a.a(str, str2);
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
        this.f16802a.b();
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        this.f16802a.c();
    }

    public boolean equals(Object obj) {
        return this.f16802a.equals(obj);
    }

    @Override // java.net.URLConnection
    public boolean getAllowUserInteraction() {
        return this.f16802a.d();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public String getCipherSuite() {
        return this.f16803b.getCipherSuite();
    }

    @Override // java.net.URLConnection
    public int getConnectTimeout() {
        return this.f16802a.e();
    }

    @Override // java.net.URLConnection
    public Object getContent() throws IOException {
        return this.f16802a.f();
    }

    @Override // java.net.URLConnection
    public String getContentEncoding() {
        return this.f16802a.h();
    }

    @Override // java.net.URLConnection
    public int getContentLength() {
        return this.f16802a.i();
    }

    @Override // java.net.URLConnection
    public long getContentLengthLong() {
        return this.f16802a.j();
    }

    @Override // java.net.URLConnection
    public String getContentType() {
        return this.f16802a.k();
    }

    @Override // java.net.URLConnection
    public long getDate() {
        return this.f16802a.l();
    }

    @Override // java.net.URLConnection
    public boolean getDefaultUseCaches() {
        return this.f16802a.m();
    }

    @Override // java.net.URLConnection
    public boolean getDoInput() {
        return this.f16802a.n();
    }

    @Override // java.net.URLConnection
    public boolean getDoOutput() {
        return this.f16802a.o();
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        return this.f16802a.p();
    }

    @Override // java.net.URLConnection
    public long getExpiration() {
        return this.f16802a.q();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public String getHeaderField(int i8) {
        return this.f16802a.r(i8);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public long getHeaderFieldDate(String str, long j8) {
        return this.f16802a.t(str, j8);
    }

    @Override // java.net.URLConnection
    public int getHeaderFieldInt(String str, int i8) {
        return this.f16802a.u(str, i8);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public String getHeaderFieldKey(int i8) {
        return this.f16802a.v(i8);
    }

    @Override // java.net.URLConnection
    public long getHeaderFieldLong(String str, long j8) {
        return this.f16802a.w(str, j8);
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        return this.f16802a.x();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public HostnameVerifier getHostnameVerifier() {
        return this.f16803b.getHostnameVerifier();
    }

    @Override // java.net.URLConnection
    public long getIfModifiedSince() {
        return this.f16802a.y();
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() throws IOException {
        return this.f16802a.z();
    }

    @Override // java.net.HttpURLConnection
    public boolean getInstanceFollowRedirects() {
        return this.f16802a.A();
    }

    @Override // java.net.URLConnection
    public long getLastModified() {
        return this.f16802a.B();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Certificate[] getLocalCertificates() {
        return this.f16803b.getLocalCertificates();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Principal getLocalPrincipal() {
        return this.f16803b.getLocalPrincipal();
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        return this.f16802a.C();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        return this.f16803b.getPeerPrincipal();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public Permission getPermission() throws IOException {
        return this.f16802a.D();
    }

    @Override // java.net.URLConnection
    public int getReadTimeout() {
        return this.f16802a.E();
    }

    @Override // java.net.HttpURLConnection
    public String getRequestMethod() {
        return this.f16802a.F();
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getRequestProperties() {
        return this.f16802a.G();
    }

    @Override // java.net.URLConnection
    public String getRequestProperty(String str) {
        return this.f16802a.H(str);
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        return this.f16802a.I();
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() throws IOException {
        return this.f16802a.J();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public SSLSocketFactory getSSLSocketFactory() {
        return this.f16803b.getSSLSocketFactory();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Certificate[] getServerCertificates() throws SSLPeerUnverifiedException {
        return this.f16803b.getServerCertificates();
    }

    @Override // java.net.URLConnection
    public URL getURL() {
        return this.f16802a.K();
    }

    @Override // java.net.URLConnection
    public boolean getUseCaches() {
        return this.f16802a.L();
    }

    public int hashCode() {
        return this.f16802a.hashCode();
    }

    @Override // java.net.URLConnection
    public void setAllowUserInteraction(boolean z7) {
        this.f16802a.M(z7);
    }

    @Override // java.net.HttpURLConnection
    public void setChunkedStreamingMode(int i8) {
        this.f16802a.N(i8);
    }

    @Override // java.net.URLConnection
    public void setConnectTimeout(int i8) {
        this.f16802a.O(i8);
    }

    @Override // java.net.URLConnection
    public void setDefaultUseCaches(boolean z7) {
        this.f16802a.P(z7);
    }

    @Override // java.net.URLConnection
    public void setDoInput(boolean z7) {
        this.f16802a.Q(z7);
    }

    @Override // java.net.URLConnection
    public void setDoOutput(boolean z7) {
        this.f16802a.R(z7);
    }

    @Override // java.net.HttpURLConnection
    public void setFixedLengthStreamingMode(int i8) {
        this.f16802a.S(i8);
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        this.f16803b.setHostnameVerifier(hostnameVerifier);
    }

    @Override // java.net.URLConnection
    public void setIfModifiedSince(long j8) {
        this.f16802a.U(j8);
    }

    @Override // java.net.HttpURLConnection
    public void setInstanceFollowRedirects(boolean z7) {
        this.f16802a.V(z7);
    }

    @Override // java.net.URLConnection
    public void setReadTimeout(int i8) {
        this.f16802a.W(i8);
    }

    @Override // java.net.HttpURLConnection
    public void setRequestMethod(String str) throws ProtocolException {
        this.f16802a.X(str);
    }

    @Override // java.net.URLConnection
    public void setRequestProperty(String str, String str2) {
        this.f16802a.Y(str, str2);
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.f16803b.setSSLSocketFactory(sSLSocketFactory);
    }

    @Override // java.net.URLConnection
    public void setUseCaches(boolean z7) {
        this.f16802a.Z(z7);
    }

    @Override // java.net.URLConnection
    public String toString() {
        return this.f16802a.toString();
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        return this.f16802a.b0();
    }

    @Override // java.net.URLConnection
    public Object getContent(Class[] clsArr) throws IOException {
        return this.f16802a.g(clsArr);
    }

    @Override // java.net.URLConnection
    public String getHeaderField(String str) {
        return this.f16802a.s(str);
    }

    @Override // java.net.HttpURLConnection
    public void setFixedLengthStreamingMode(long j8) {
        this.f16802a.T(j8);
    }
}
