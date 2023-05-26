package com.bumptech.glide.load.model;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Preconditions;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Map;

/* loaded from: classes.dex */
public class GlideUrl implements Key {

    /* renamed from: b  reason: collision with root package name */
    private final Headers f10307b;

    /* renamed from: c  reason: collision with root package name */
    private final URL f10308c;

    /* renamed from: d  reason: collision with root package name */
    private final String f10309d;

    /* renamed from: e  reason: collision with root package name */
    private String f10310e;

    /* renamed from: f  reason: collision with root package name */
    private URL f10311f;

    /* renamed from: g  reason: collision with root package name */
    private volatile byte[] f10312g;

    /* renamed from: h  reason: collision with root package name */
    private int f10313h;

    public GlideUrl(URL url) {
        this(url, Headers.f10315b);
    }

    private byte[] d() {
        if (this.f10312g == null) {
            this.f10312g = c().getBytes(Key.f9923a);
        }
        return this.f10312g;
    }

    private String f() {
        if (TextUtils.isEmpty(this.f10310e)) {
            String str = this.f10309d;
            if (TextUtils.isEmpty(str)) {
                str = ((URL) Preconditions.d(this.f10308c)).toString();
            }
            this.f10310e = Uri.encode(str, "@#&=*+-_.,:!?()/~'%;$");
        }
        return this.f10310e;
    }

    private URL g() throws MalformedURLException {
        if (this.f10311f == null) {
            this.f10311f = new URL(f());
        }
        return this.f10311f;
    }

    @Override // com.bumptech.glide.load.Key
    public void b(@NonNull MessageDigest messageDigest) {
        messageDigest.update(d());
    }

    public String c() {
        String str = this.f10309d;
        if (str == null) {
            return ((URL) Preconditions.d(this.f10308c)).toString();
        }
        return str;
    }

    public Map<String, String> e() {
        return this.f10307b.getHeaders();
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (!(obj instanceof GlideUrl)) {
            return false;
        }
        GlideUrl glideUrl = (GlideUrl) obj;
        if (!c().equals(glideUrl.c()) || !this.f10307b.equals(glideUrl.f10307b)) {
            return false;
        }
        return true;
    }

    public URL h() throws MalformedURLException {
        return g();
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        if (this.f10313h == 0) {
            int hashCode = c().hashCode();
            this.f10313h = hashCode;
            this.f10313h = (hashCode * 31) + this.f10307b.hashCode();
        }
        return this.f10313h;
    }

    public String toString() {
        return c();
    }

    public GlideUrl(String str) {
        this(str, Headers.f10315b);
    }

    public GlideUrl(URL url, Headers headers) {
        this.f10308c = (URL) Preconditions.d(url);
        this.f10309d = null;
        this.f10307b = (Headers) Preconditions.d(headers);
    }

    public GlideUrl(String str, Headers headers) {
        this.f10308c = null;
        this.f10309d = Preconditions.b(str);
        this.f10307b = (Headers) Preconditions.d(headers);
    }
}
