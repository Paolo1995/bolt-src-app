package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
final class Jobs {

    /* renamed from: a  reason: collision with root package name */
    private final Map<Key, EngineJob<?>> f10153a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final Map<Key, EngineJob<?>> f10154b = new HashMap();

    private Map<Key, EngineJob<?>> b(boolean z7) {
        if (z7) {
            return this.f10154b;
        }
        return this.f10153a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public EngineJob<?> a(Key key, boolean z7) {
        return b(z7).get(key);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(Key key, EngineJob<?> engineJob) {
        b(engineJob.p()).put(key, engineJob);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(Key key, EngineJob<?> engineJob) {
        Map<Key, EngineJob<?>> b8 = b(engineJob.p());
        if (engineJob.equals(b8.get(key))) {
            b8.remove(key);
        }
    }
}
