package com.bumptech.glide.load.resource.transcode;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class TranscoderRegistry {

    /* renamed from: a  reason: collision with root package name */
    private final List<Entry<?, ?>> f10577a = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class Entry<Z, R> {

        /* renamed from: a  reason: collision with root package name */
        private final Class<Z> f10578a;

        /* renamed from: b  reason: collision with root package name */
        private final Class<R> f10579b;

        /* renamed from: c  reason: collision with root package name */
        final ResourceTranscoder<Z, R> f10580c;

        Entry(@NonNull Class<Z> cls, @NonNull Class<R> cls2, @NonNull ResourceTranscoder<Z, R> resourceTranscoder) {
            this.f10578a = cls;
            this.f10579b = cls2;
            this.f10580c = resourceTranscoder;
        }

        public boolean a(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            if (this.f10578a.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f10579b)) {
                return true;
            }
            return false;
        }
    }

    @NonNull
    public synchronized <Z, R> ResourceTranscoder<Z, R> a(@NonNull Class<Z> cls, @NonNull Class<R> cls2) {
        if (cls2.isAssignableFrom(cls)) {
            return UnitTranscoder.b();
        }
        for (Entry<?, ?> entry : this.f10577a) {
            if (entry.a(cls, cls2)) {
                return (ResourceTranscoder<Z, R>) entry.f10580c;
            }
        }
        throw new IllegalArgumentException("No transcoder registered to transcode from " + cls + " to " + cls2);
    }

    @NonNull
    public synchronized <Z, R> List<Class<R>> b(@NonNull Class<Z> cls, @NonNull Class<R> cls2) {
        ArrayList arrayList = new ArrayList();
        if (cls2.isAssignableFrom(cls)) {
            arrayList.add(cls2);
            return arrayList;
        }
        for (Entry<?, ?> entry : this.f10577a) {
            if (entry.a(cls, cls2)) {
                arrayList.add(cls2);
            }
        }
        return arrayList;
    }

    public synchronized <Z, R> void c(@NonNull Class<Z> cls, @NonNull Class<R> cls2, @NonNull ResourceTranscoder<Z, R> resourceTranscoder) {
        this.f10577a.add(new Entry<>(cls, cls2, resourceTranscoder));
    }
}
