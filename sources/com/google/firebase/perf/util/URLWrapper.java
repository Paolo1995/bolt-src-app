package com.google.firebase.perf.util;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

/* loaded from: classes3.dex */
public class URLWrapper {

    /* renamed from: a  reason: collision with root package name */
    private final URL f16901a;

    public URLWrapper(URL url) {
        this.f16901a = url;
    }

    public URLConnection a() throws IOException {
        return this.f16901a.openConnection();
    }

    public String toString() {
        return this.f16901a.toString();
    }
}
