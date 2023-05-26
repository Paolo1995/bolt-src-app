package com.bumptech.glide.load.model;

import com.bumptech.glide.load.model.LazyHeaders;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes.dex */
public interface Headers {
    @Deprecated

    /* renamed from: a  reason: collision with root package name */
    public static final Headers f10314a = new Headers() { // from class: com.bumptech.glide.load.model.Headers.1
        @Override // com.bumptech.glide.load.model.Headers
        public Map<String, String> getHeaders() {
            return Collections.emptyMap();
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public static final Headers f10315b = new LazyHeaders.Builder().a();

    Map<String, String> getHeaders();
}
