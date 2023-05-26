package com.bumptech.glide.load.data;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.HttpException;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.util.ContentLengthInputStream;
import com.bumptech.glide.util.LogTime;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

/* loaded from: classes.dex */
public class HttpUrlFetcher implements DataFetcher<InputStream> {

    /* renamed from: l  reason: collision with root package name */
    static final HttpUrlConnectionFactory f9948l = new DefaultHttpUrlConnectionFactory();

    /* renamed from: f  reason: collision with root package name */
    private final GlideUrl f9949f;

    /* renamed from: g  reason: collision with root package name */
    private final int f9950g;

    /* renamed from: h  reason: collision with root package name */
    private final HttpUrlConnectionFactory f9951h;

    /* renamed from: i  reason: collision with root package name */
    private HttpURLConnection f9952i;

    /* renamed from: j  reason: collision with root package name */
    private InputStream f9953j;

    /* renamed from: k  reason: collision with root package name */
    private volatile boolean f9954k;

    /* loaded from: classes.dex */
    private static class DefaultHttpUrlConnectionFactory implements HttpUrlConnectionFactory {
        DefaultHttpUrlConnectionFactory() {
        }

        @Override // com.bumptech.glide.load.data.HttpUrlFetcher.HttpUrlConnectionFactory
        public HttpURLConnection a(URL url) throws IOException {
            return (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface HttpUrlConnectionFactory {
        HttpURLConnection a(URL url) throws IOException;
    }

    public HttpUrlFetcher(GlideUrl glideUrl, int i8) {
        this(glideUrl, i8, f9948l);
    }

    private HttpURLConnection c(URL url, Map<String, String> map) throws HttpException {
        try {
            HttpURLConnection a8 = this.f9951h.a(url);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                a8.addRequestProperty(entry.getKey(), entry.getValue());
            }
            a8.setConnectTimeout(this.f9950g);
            a8.setReadTimeout(this.f9950g);
            a8.setUseCaches(false);
            a8.setDoInput(true);
            a8.setInstanceFollowRedirects(false);
            return a8;
        } catch (IOException e8) {
            throw new HttpException("URL.openConnection threw", 0, e8);
        }
    }

    private static int f(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getResponseCode();
        } catch (IOException e8) {
            if (Log.isLoggable("HttpUrlFetcher", 3)) {
                Log.d("HttpUrlFetcher", "Failed to get a response code", e8);
                return -1;
            }
            return -1;
        }
    }

    private InputStream g(HttpURLConnection httpURLConnection) throws HttpException {
        try {
            if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
                this.f9953j = ContentLengthInputStream.c(httpURLConnection.getInputStream(), httpURLConnection.getContentLength());
            } else {
                if (Log.isLoggable("HttpUrlFetcher", 3)) {
                    Log.d("HttpUrlFetcher", "Got non empty content encoding: " + httpURLConnection.getContentEncoding());
                }
                this.f9953j = httpURLConnection.getInputStream();
            }
            return this.f9953j;
        } catch (IOException e8) {
            throw new HttpException("Failed to obtain InputStream", f(httpURLConnection), e8);
        }
    }

    private static boolean h(int i8) {
        if (i8 / 100 == 2) {
            return true;
        }
        return false;
    }

    private static boolean i(int i8) {
        if (i8 / 100 == 3) {
            return true;
        }
        return false;
    }

    private InputStream j(URL url, int i8, URL url2, Map<String, String> map) throws HttpException {
        if (i8 < 5) {
            if (url2 != null) {
                try {
                    if (url.toURI().equals(url2.toURI())) {
                        throw new HttpException("In re-direct loop", -1);
                    }
                } catch (URISyntaxException unused) {
                }
            }
            HttpURLConnection c8 = c(url, map);
            this.f9952i = c8;
            try {
                c8.connect();
                this.f9953j = this.f9952i.getInputStream();
                if (this.f9954k) {
                    return null;
                }
                int f8 = f(this.f9952i);
                if (h(f8)) {
                    return g(this.f9952i);
                }
                if (i(f8)) {
                    String headerField = this.f9952i.getHeaderField("Location");
                    if (!TextUtils.isEmpty(headerField)) {
                        try {
                            URL url3 = new URL(url, headerField);
                            b();
                            return j(url3, i8 + 1, url, map);
                        } catch (MalformedURLException e8) {
                            throw new HttpException("Bad redirect url: " + headerField, f8, e8);
                        }
                    }
                    throw new HttpException("Received empty or null redirect url", f8);
                } else if (f8 == -1) {
                    throw new HttpException(f8);
                } else {
                    try {
                        throw new HttpException(this.f9952i.getResponseMessage(), f8);
                    } catch (IOException e9) {
                        throw new HttpException("Failed to get a response message", f8, e9);
                    }
                }
            } catch (IOException e10) {
                throw new HttpException("Failed to connect or obtain data", f(this.f9952i), e10);
            }
        }
        throw new HttpException("Too many (> 5) redirects!", -1);
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    @NonNull
    public Class<InputStream> a() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void b() {
        InputStream inputStream = this.f9953j;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.f9952i;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.f9952i = null;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cancel() {
        this.f9954k = true;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    @NonNull
    public DataSource d() {
        return DataSource.REMOTE;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void e(@NonNull Priority priority, @NonNull DataFetcher.DataCallback<? super InputStream> dataCallback) {
        StringBuilder sb;
        long b8 = LogTime.b();
        try {
            try {
                dataCallback.f(j(this.f9949f.h(), 0, null, this.f9949f.e()));
            } catch (IOException e8) {
                if (Log.isLoggable("HttpUrlFetcher", 3)) {
                    Log.d("HttpUrlFetcher", "Failed to load data for url", e8);
                }
                dataCallback.c(e8);
                if (Log.isLoggable("HttpUrlFetcher", 2)) {
                    sb = new StringBuilder();
                } else {
                    return;
                }
            }
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                sb = new StringBuilder();
                sb.append("Finished http url fetcher fetch in ");
                sb.append(LogTime.a(b8));
                Log.v("HttpUrlFetcher", sb.toString());
            }
        } catch (Throwable th) {
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                Log.v("HttpUrlFetcher", "Finished http url fetcher fetch in " + LogTime.a(b8));
            }
            throw th;
        }
    }

    HttpUrlFetcher(GlideUrl glideUrl, int i8, HttpUrlConnectionFactory httpUrlConnectionFactory) {
        this.f9949f = glideUrl;
        this.f9950g = i8;
        this.f9951h = httpUrlConnectionFactory;
    }
}
