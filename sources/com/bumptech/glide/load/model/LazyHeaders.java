package com.bumptech.glide.load.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class LazyHeaders implements Headers {

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, List<LazyHeaderFactory>> f10316c;

    /* renamed from: d  reason: collision with root package name */
    private volatile Map<String, String> f10317d;

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: d  reason: collision with root package name */
        private static final String f10318d;

        /* renamed from: e  reason: collision with root package name */
        private static final Map<String, List<LazyHeaderFactory>> f10319e;

        /* renamed from: a  reason: collision with root package name */
        private boolean f10320a = true;

        /* renamed from: b  reason: collision with root package name */
        private Map<String, List<LazyHeaderFactory>> f10321b = f10319e;

        /* renamed from: c  reason: collision with root package name */
        private boolean f10322c = true;

        static {
            String b8 = b();
            f10318d = b8;
            HashMap hashMap = new HashMap(2);
            if (!TextUtils.isEmpty(b8)) {
                hashMap.put("User-Agent", Collections.singletonList(new StringHeaderFactory(b8)));
            }
            f10319e = Collections.unmodifiableMap(hashMap);
        }

        static String b() {
            String property = System.getProperty("http.agent");
            if (TextUtils.isEmpty(property)) {
                return property;
            }
            int length = property.length();
            StringBuilder sb = new StringBuilder(property.length());
            for (int i8 = 0; i8 < length; i8++) {
                char charAt = property.charAt(i8);
                if ((charAt > 31 || charAt == '\t') && charAt < 127) {
                    sb.append(charAt);
                } else {
                    sb.append('?');
                }
            }
            return sb.toString();
        }

        public LazyHeaders a() {
            this.f10320a = true;
            return new LazyHeaders(this.f10321b);
        }
    }

    /* loaded from: classes.dex */
    static final class StringHeaderFactory implements LazyHeaderFactory {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        private final String f10323a;

        StringHeaderFactory(@NonNull String str) {
            this.f10323a = str;
        }

        @Override // com.bumptech.glide.load.model.LazyHeaderFactory
        public String a() {
            return this.f10323a;
        }

        public boolean equals(Object obj) {
            if (obj instanceof StringHeaderFactory) {
                return this.f10323a.equals(((StringHeaderFactory) obj).f10323a);
            }
            return false;
        }

        public int hashCode() {
            return this.f10323a.hashCode();
        }

        public String toString() {
            return "StringHeaderFactory{value='" + this.f10323a + "'}";
        }
    }

    LazyHeaders(Map<String, List<LazyHeaderFactory>> map) {
        this.f10316c = Collections.unmodifiableMap(map);
    }

    @NonNull
    private String a(@NonNull List<LazyHeaderFactory> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i8 = 0; i8 < size; i8++) {
            String a8 = list.get(i8).a();
            if (!TextUtils.isEmpty(a8)) {
                sb.append(a8);
                if (i8 != list.size() - 1) {
                    sb.append(',');
                }
            }
        }
        return sb.toString();
    }

    private Map<String, String> b() {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, List<LazyHeaderFactory>> entry : this.f10316c.entrySet()) {
            String a8 = a(entry.getValue());
            if (!TextUtils.isEmpty(a8)) {
                hashMap.put(entry.getKey(), a8);
            }
        }
        return hashMap;
    }

    public boolean equals(Object obj) {
        if (obj instanceof LazyHeaders) {
            return this.f10316c.equals(((LazyHeaders) obj).f10316c);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.model.Headers
    public Map<String, String> getHeaders() {
        if (this.f10317d == null) {
            synchronized (this) {
                if (this.f10317d == null) {
                    this.f10317d = Collections.unmodifiableMap(b());
                }
            }
        }
        return this.f10317d;
    }

    public int hashCode() {
        return this.f10316c.hashCode();
    }

    public String toString() {
        return "LazyHeaders{headers=" + this.f10316c + '}';
    }
}
