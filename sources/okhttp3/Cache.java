package okhttp3;

import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheRequest;
import okhttp3.internal.cache.CacheStrategy;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.http.StatusLine;
import okhttp3.internal.io.FileSystem;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.ForwardingSink;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

/* compiled from: Cache.kt */
/* loaded from: classes5.dex */
public final class Cache implements Closeable, Flushable {
    public static final Companion Companion = new Companion(null);
    private static final int ENTRY_BODY = 1;
    private static final int ENTRY_COUNT = 2;
    private static final int ENTRY_METADATA = 0;
    private static final int VERSION = 201105;
    private final DiskLruCache cache;
    private int hitCount;
    private int networkCount;
    private int requestCount;
    private int writeAbortCount;
    private int writeSuccessCount;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Cache.kt */
    /* loaded from: classes5.dex */
    public static final class CacheResponseBody extends ResponseBody {
        private final BufferedSource bodySource;
        private final String contentLength;
        private final String contentType;
        private final DiskLruCache.Snapshot snapshot;

        public CacheResponseBody(DiskLruCache.Snapshot snapshot, String str, String str2) {
            Intrinsics.f(snapshot, "snapshot");
            this.snapshot = snapshot;
            this.contentType = str;
            this.contentLength = str2;
            this.bodySource = Okio.d(new ForwardingSource(this) { // from class: okhttp3.Cache.CacheResponseBody.1
                final /* synthetic */ CacheResponseBody this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(Source.this);
                    this.this$0 = this;
                }

                @Override // okio.ForwardingSource, okio.Source, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    this.this$0.getSnapshot().close();
                    super.close();
                }
            });
        }

        @Override // okhttp3.ResponseBody
        public long contentLength() {
            String str = this.contentLength;
            if (str == null) {
                return -1L;
            }
            return Util.toLongOrDefault(str, -1L);
        }

        @Override // okhttp3.ResponseBody
        public MediaType contentType() {
            String str = this.contentType;
            if (str == null) {
                return null;
            }
            return MediaType.Companion.parse(str);
        }

        public final DiskLruCache.Snapshot getSnapshot() {
            return this.snapshot;
        }

        @Override // okhttp3.ResponseBody
        public BufferedSource source() {
            return this.bodySource;
        }
    }

    /* compiled from: Cache.kt */
    /* loaded from: classes5.dex */
    private final class RealCacheRequest implements CacheRequest {
        private final Sink body;
        private final Sink cacheOut;
        private boolean done;
        private final DiskLruCache.Editor editor;
        final /* synthetic */ Cache this$0;

        public RealCacheRequest(final Cache this$0, DiskLruCache.Editor editor) {
            Intrinsics.f(this$0, "this$0");
            Intrinsics.f(editor, "editor");
            this.this$0 = this$0;
            this.editor = editor;
            Sink newSink = editor.newSink(1);
            this.cacheOut = newSink;
            this.body = new ForwardingSink(newSink) { // from class: okhttp3.Cache.RealCacheRequest.1
                @Override // okio.ForwardingSink, okio.Sink, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    Cache cache = Cache.this;
                    RealCacheRequest realCacheRequest = this;
                    synchronized (cache) {
                        if (realCacheRequest.getDone()) {
                            return;
                        }
                        realCacheRequest.setDone(true);
                        cache.setWriteSuccessCount$okhttp(cache.getWriteSuccessCount$okhttp() + 1);
                        super.close();
                        this.editor.commit();
                    }
                }
            };
        }

        @Override // okhttp3.internal.cache.CacheRequest
        public void abort() {
            Cache cache = this.this$0;
            synchronized (cache) {
                if (getDone()) {
                    return;
                }
                setDone(true);
                cache.setWriteAbortCount$okhttp(cache.getWriteAbortCount$okhttp() + 1);
                Util.closeQuietly(this.cacheOut);
                try {
                    this.editor.abort();
                } catch (IOException unused) {
                }
            }
        }

        @Override // okhttp3.internal.cache.CacheRequest
        public Sink body() {
            return this.body;
        }

        public final boolean getDone() {
            return this.done;
        }

        public final void setDone(boolean z7) {
            this.done = z7;
        }
    }

    public Cache(File directory, long j8, FileSystem fileSystem) {
        Intrinsics.f(directory, "directory");
        Intrinsics.f(fileSystem, "fileSystem");
        this.cache = new DiskLruCache(fileSystem, directory, VERSION, 2, j8, TaskRunner.INSTANCE);
    }

    private final void abortQuietly(DiskLruCache.Editor editor) {
        if (editor != null) {
            try {
                editor.abort();
            } catch (IOException unused) {
            }
        }
    }

    public static final String key(HttpUrl httpUrl) {
        return Companion.key(httpUrl);
    }

    /* renamed from: -deprecated_directory  reason: not valid java name */
    public final File m24deprecated_directory() {
        return this.cache.getDirectory();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.cache.close();
    }

    public final void delete() throws IOException {
        this.cache.delete();
    }

    public final File directory() {
        return this.cache.getDirectory();
    }

    public final void evictAll() throws IOException {
        this.cache.evictAll();
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        this.cache.flush();
    }

    public final Response get$okhttp(Request request) {
        Intrinsics.f(request, "request");
        try {
            DiskLruCache.Snapshot snapshot = this.cache.get(Companion.key(request.url()));
            if (snapshot == null) {
                return null;
            }
            try {
                Entry entry = new Entry(snapshot.getSource(0));
                Response response = entry.response(snapshot);
                if (!entry.matches(request, response)) {
                    ResponseBody body = response.body();
                    if (body != null) {
                        Util.closeQuietly(body);
                    }
                    return null;
                }
                return response;
            } catch (IOException unused) {
                Util.closeQuietly(snapshot);
                return null;
            }
        } catch (IOException unused2) {
        }
    }

    public final DiskLruCache getCache$okhttp() {
        return this.cache;
    }

    public final int getWriteAbortCount$okhttp() {
        return this.writeAbortCount;
    }

    public final int getWriteSuccessCount$okhttp() {
        return this.writeSuccessCount;
    }

    public final synchronized int hitCount() {
        return this.hitCount;
    }

    public final void initialize() throws IOException {
        this.cache.initialize();
    }

    public final boolean isClosed() {
        return this.cache.isClosed();
    }

    public final long maxSize() {
        return this.cache.getMaxSize();
    }

    public final synchronized int networkCount() {
        return this.networkCount;
    }

    public final CacheRequest put$okhttp(Response response) {
        DiskLruCache.Editor editor;
        Intrinsics.f(response, "response");
        String method = response.request().method();
        if (HttpMethod.INSTANCE.invalidatesCache(response.request().method())) {
            try {
                remove$okhttp(response.request());
            } catch (IOException unused) {
            }
            return null;
        } else if (!Intrinsics.a(method, "GET")) {
            return null;
        } else {
            Companion companion = Companion;
            if (companion.hasVaryAll(response)) {
                return null;
            }
            Entry entry = new Entry(response);
            try {
                editor = DiskLruCache.edit$default(this.cache, companion.key(response.request().url()), 0L, 2, null);
                if (editor == null) {
                    return null;
                }
                try {
                    entry.writeTo(editor);
                    return new RealCacheRequest(this, editor);
                } catch (IOException unused2) {
                    abortQuietly(editor);
                    return null;
                }
            } catch (IOException unused3) {
                editor = null;
            }
        }
    }

    public final void remove$okhttp(Request request) throws IOException {
        Intrinsics.f(request, "request");
        this.cache.remove(Companion.key(request.url()));
    }

    public final synchronized int requestCount() {
        return this.requestCount;
    }

    public final void setWriteAbortCount$okhttp(int i8) {
        this.writeAbortCount = i8;
    }

    public final void setWriteSuccessCount$okhttp(int i8) {
        this.writeSuccessCount = i8;
    }

    public final long size() throws IOException {
        return this.cache.size();
    }

    public final synchronized void trackConditionalCacheHit$okhttp() {
        this.hitCount++;
    }

    public final synchronized void trackResponse$okhttp(CacheStrategy cacheStrategy) {
        Intrinsics.f(cacheStrategy, "cacheStrategy");
        this.requestCount++;
        if (cacheStrategy.getNetworkRequest() != null) {
            this.networkCount++;
        } else if (cacheStrategy.getCacheResponse() != null) {
            this.hitCount++;
        }
    }

    public final void update$okhttp(Response cached, Response network) {
        Intrinsics.f(cached, "cached");
        Intrinsics.f(network, "network");
        Entry entry = new Entry(network);
        ResponseBody body = cached.body();
        if (body != null) {
            DiskLruCache.Editor editor = null;
            try {
                editor = ((CacheResponseBody) body).getSnapshot().edit();
                if (editor == null) {
                    return;
                }
                entry.writeTo(editor);
                editor.commit();
                return;
            } catch (IOException unused) {
                abortQuietly(editor);
                return;
            }
        }
        throw new NullPointerException("null cannot be cast to non-null type okhttp3.Cache.CacheResponseBody");
    }

    public final Iterator<String> urls() throws IOException {
        return new Cache$urls$1(this);
    }

    public final synchronized int writeAbortCount() {
        return this.writeAbortCount;
    }

    public final synchronized int writeSuccessCount() {
        return this.writeSuccessCount;
    }

    /* compiled from: Cache.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Set<String> varyFields(Headers headers) {
            Set<String> b8;
            boolean w7;
            List<String> B0;
            CharSequence Y0;
            Comparator x7;
            int size = headers.size();
            TreeSet treeSet = null;
            int i8 = 0;
            while (i8 < size) {
                int i9 = i8 + 1;
                w7 = StringsKt__StringsJVMKt.w("Vary", headers.name(i8), true);
                if (w7) {
                    String value = headers.value(i8);
                    if (treeSet == null) {
                        x7 = StringsKt__StringsJVMKt.x(StringCompanionObject.f51021a);
                        treeSet = new TreeSet(x7);
                    }
                    B0 = StringsKt__StringsKt.B0(value, new char[]{','}, false, 0, 6, null);
                    for (String str : B0) {
                        Y0 = StringsKt__StringsKt.Y0(str);
                        treeSet.add(Y0.toString());
                    }
                }
                i8 = i9;
            }
            if (treeSet == null) {
                b8 = SetsKt__SetsKt.b();
                return b8;
            }
            return treeSet;
        }

        public final boolean hasVaryAll(Response response) {
            Intrinsics.f(response, "<this>");
            return varyFields(response.headers()).contains("*");
        }

        public final String key(HttpUrl url) {
            Intrinsics.f(url, "url");
            return ByteString.f52591i.d(url.toString()).s().p();
        }

        public final int readInt$okhttp(BufferedSource source) throws IOException {
            boolean z7;
            Intrinsics.f(source, "source");
            try {
                long A0 = source.A0();
                String b02 = source.b0();
                if (A0 >= 0 && A0 <= 2147483647L) {
                    if (b02.length() > 0) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    if (!z7) {
                        return (int) A0;
                    }
                }
                throw new IOException("expected an int but was \"" + A0 + b02 + '\"');
            } catch (NumberFormatException e8) {
                throw new IOException(e8.getMessage());
            }
        }

        public final Headers varyHeaders(Response response) {
            Intrinsics.f(response, "<this>");
            Response networkResponse = response.networkResponse();
            Intrinsics.c(networkResponse);
            return varyHeaders(networkResponse.request().headers(), response.headers());
        }

        public final boolean varyMatches(Response cachedResponse, Headers cachedRequest, Request newRequest) {
            Intrinsics.f(cachedResponse, "cachedResponse");
            Intrinsics.f(cachedRequest, "cachedRequest");
            Intrinsics.f(newRequest, "newRequest");
            Set<String> varyFields = varyFields(cachedResponse.headers());
            if ((varyFields instanceof Collection) && varyFields.isEmpty()) {
                return true;
            }
            for (String str : varyFields) {
                if (!Intrinsics.a(cachedRequest.values(str), newRequest.headers(str))) {
                    return false;
                }
            }
            return true;
        }

        private final Headers varyHeaders(Headers headers, Headers headers2) {
            Set<String> varyFields = varyFields(headers2);
            if (varyFields.isEmpty()) {
                return Util.EMPTY_HEADERS;
            }
            Headers.Builder builder = new Headers.Builder();
            int i8 = 0;
            int size = headers.size();
            while (i8 < size) {
                int i9 = i8 + 1;
                String name = headers.name(i8);
                if (varyFields.contains(name)) {
                    builder.add(name, headers.value(i8));
                }
                i8 = i9;
            }
            return builder.build();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Cache(File directory, long j8) {
        this(directory, j8, FileSystem.SYSTEM);
        Intrinsics.f(directory, "directory");
    }

    /* compiled from: Cache.kt */
    /* loaded from: classes5.dex */
    private static final class Entry {
        public static final Companion Companion = new Companion(null);
        private static final String RECEIVED_MILLIS;
        private static final String SENT_MILLIS;
        private final int code;
        private final Handshake handshake;
        private final String message;
        private final Protocol protocol;
        private final long receivedResponseMillis;
        private final String requestMethod;
        private final Headers responseHeaders;
        private final long sentRequestMillis;
        private final HttpUrl url;
        private final Headers varyHeaders;

        /* compiled from: Cache.kt */
        /* loaded from: classes5.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        static {
            Platform.Companion companion = Platform.Companion;
            SENT_MILLIS = Intrinsics.n(companion.get().getPrefix(), "-Sent-Millis");
            RECEIVED_MILLIS = Intrinsics.n(companion.get().getPrefix(), "-Received-Millis");
        }

        public Entry(Source rawSource) throws IOException {
            TlsVersion tlsVersion;
            Intrinsics.f(rawSource, "rawSource");
            try {
                BufferedSource d8 = Okio.d(rawSource);
                String b02 = d8.b0();
                HttpUrl parse = HttpUrl.Companion.parse(b02);
                if (parse != null) {
                    this.url = parse;
                    this.requestMethod = d8.b0();
                    Headers.Builder builder = new Headers.Builder();
                    int readInt$okhttp = Cache.Companion.readInt$okhttp(d8);
                    int i8 = 0;
                    while (i8 < readInt$okhttp) {
                        i8++;
                        builder.addLenient$okhttp(d8.b0());
                    }
                    this.varyHeaders = builder.build();
                    StatusLine parse2 = StatusLine.Companion.parse(d8.b0());
                    this.protocol = parse2.protocol;
                    this.code = parse2.code;
                    this.message = parse2.message;
                    Headers.Builder builder2 = new Headers.Builder();
                    int readInt$okhttp2 = Cache.Companion.readInt$okhttp(d8);
                    int i9 = 0;
                    while (i9 < readInt$okhttp2) {
                        i9++;
                        builder2.addLenient$okhttp(d8.b0());
                    }
                    String str = SENT_MILLIS;
                    String str2 = builder2.get(str);
                    String str3 = RECEIVED_MILLIS;
                    String str4 = builder2.get(str3);
                    builder2.removeAll(str);
                    builder2.removeAll(str3);
                    long j8 = 0;
                    this.sentRequestMillis = str2 == null ? 0L : Long.parseLong(str2);
                    if (str4 != null) {
                        j8 = Long.parseLong(str4);
                    }
                    this.receivedResponseMillis = j8;
                    this.responseHeaders = builder2.build();
                    if (isHttps()) {
                        String b03 = d8.b0();
                        if (!(b03.length() > 0)) {
                            CipherSuite forJavaName = CipherSuite.Companion.forJavaName(d8.b0());
                            List<Certificate> readCertificateList = readCertificateList(d8);
                            List<Certificate> readCertificateList2 = readCertificateList(d8);
                            if (!d8.y0()) {
                                tlsVersion = TlsVersion.Companion.forJavaName(d8.b0());
                            } else {
                                tlsVersion = TlsVersion.SSL_3_0;
                            }
                            this.handshake = Handshake.Companion.get(tlsVersion, forJavaName, readCertificateList, readCertificateList2);
                        } else {
                            throw new IOException("expected \"\" but was \"" + b03 + '\"');
                        }
                    } else {
                        this.handshake = null;
                    }
                    Unit unit = Unit.f50853a;
                    CloseableKt.a(rawSource, null);
                    return;
                }
                IOException iOException = new IOException(Intrinsics.n("Cache corruption for ", b02));
                Platform.Companion.get().log("cache corruption", 5, iOException);
                throw iOException;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.a(rawSource, th);
                    throw th2;
                }
            }
        }

        private final boolean isHttps() {
            return Intrinsics.a(this.url.scheme(), "https");
        }

        private final List<Certificate> readCertificateList(BufferedSource bufferedSource) throws IOException {
            List<Certificate> k8;
            int readInt$okhttp = Cache.Companion.readInt$okhttp(bufferedSource);
            if (readInt$okhttp == -1) {
                k8 = CollectionsKt__CollectionsKt.k();
                return k8;
            }
            try {
                CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                ArrayList arrayList = new ArrayList(readInt$okhttp);
                int i8 = 0;
                while (i8 < readInt$okhttp) {
                    i8++;
                    String b02 = bufferedSource.b0();
                    Buffer buffer = new Buffer();
                    ByteString a8 = ByteString.f52591i.a(b02);
                    Intrinsics.c(a8);
                    buffer.a1(a8);
                    arrayList.add(certificateFactory.generateCertificate(buffer.j1()));
                }
                return arrayList;
            } catch (CertificateException e8) {
                throw new IOException(e8.getMessage());
            }
        }

        private final void writeCertList(BufferedSink bufferedSink, List<? extends Certificate> list) throws IOException {
            try {
                bufferedSink.l0(list.size()).writeByte(10);
                for (Certificate certificate : list) {
                    byte[] bytes = certificate.getEncoded();
                    ByteString.Companion companion = ByteString.f52591i;
                    Intrinsics.e(bytes, "bytes");
                    bufferedSink.Q(ByteString.Companion.f(companion, bytes, 0, 0, 3, null).a()).writeByte(10);
                }
            } catch (CertificateEncodingException e8) {
                throw new IOException(e8.getMessage());
            }
        }

        public final boolean matches(Request request, Response response) {
            Intrinsics.f(request, "request");
            Intrinsics.f(response, "response");
            if (Intrinsics.a(this.url, request.url()) && Intrinsics.a(this.requestMethod, request.method()) && Cache.Companion.varyMatches(response, this.varyHeaders, request)) {
                return true;
            }
            return false;
        }

        public final Response response(DiskLruCache.Snapshot snapshot) {
            Intrinsics.f(snapshot, "snapshot");
            String str = this.responseHeaders.get("Content-Type");
            String str2 = this.responseHeaders.get("Content-Length");
            return new Response.Builder().request(new Request.Builder().url(this.url).method(this.requestMethod, null).headers(this.varyHeaders).build()).protocol(this.protocol).code(this.code).message(this.message).headers(this.responseHeaders).body(new CacheResponseBody(snapshot, str, str2)).handshake(this.handshake).sentRequestAtMillis(this.sentRequestMillis).receivedResponseAtMillis(this.receivedResponseMillis).build();
        }

        public final void writeTo(DiskLruCache.Editor editor) throws IOException {
            Intrinsics.f(editor, "editor");
            BufferedSink c8 = Okio.c(editor.newSink(0));
            try {
                c8.Q(this.url.toString()).writeByte(10);
                c8.Q(this.requestMethod).writeByte(10);
                c8.l0(this.varyHeaders.size()).writeByte(10);
                int size = this.varyHeaders.size();
                int i8 = 0;
                while (i8 < size) {
                    int i9 = i8 + 1;
                    c8.Q(this.varyHeaders.name(i8)).Q(": ").Q(this.varyHeaders.value(i8)).writeByte(10);
                    i8 = i9;
                }
                c8.Q(new StatusLine(this.protocol, this.code, this.message).toString()).writeByte(10);
                c8.l0(this.responseHeaders.size() + 2).writeByte(10);
                int size2 = this.responseHeaders.size();
                for (int i10 = 0; i10 < size2; i10++) {
                    c8.Q(this.responseHeaders.name(i10)).Q(": ").Q(this.responseHeaders.value(i10)).writeByte(10);
                }
                c8.Q(SENT_MILLIS).Q(": ").l0(this.sentRequestMillis).writeByte(10);
                c8.Q(RECEIVED_MILLIS).Q(": ").l0(this.receivedResponseMillis).writeByte(10);
                if (isHttps()) {
                    c8.writeByte(10);
                    Handshake handshake = this.handshake;
                    Intrinsics.c(handshake);
                    c8.Q(handshake.cipherSuite().javaName()).writeByte(10);
                    writeCertList(c8, this.handshake.peerCertificates());
                    writeCertList(c8, this.handshake.localCertificates());
                    c8.Q(this.handshake.tlsVersion().javaName()).writeByte(10);
                }
                Unit unit = Unit.f50853a;
                CloseableKt.a(c8, null);
            } finally {
            }
        }

        public Entry(Response response) {
            Intrinsics.f(response, "response");
            this.url = response.request().url();
            this.varyHeaders = Cache.Companion.varyHeaders(response);
            this.requestMethod = response.request().method();
            this.protocol = response.protocol();
            this.code = response.code();
            this.message = response.message();
            this.responseHeaders = response.headers();
            this.handshake = response.handshake();
            this.sentRequestMillis = response.sentRequestAtMillis();
            this.receivedResponseMillis = response.receivedResponseAtMillis();
        }
    }
}
