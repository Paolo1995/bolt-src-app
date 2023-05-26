package com.bumptech.glide.provider;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.ResourceDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class ResourceDecoderRegistry {

    /* renamed from: a  reason: collision with root package name */
    private final List<String> f10629a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, List<Entry<?, ?>>> f10630b = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class Entry<T, R> {

        /* renamed from: a  reason: collision with root package name */
        private final Class<T> f10631a;

        /* renamed from: b  reason: collision with root package name */
        final Class<R> f10632b;

        /* renamed from: c  reason: collision with root package name */
        final ResourceDecoder<T, R> f10633c;

        public Entry(@NonNull Class<T> cls, @NonNull Class<R> cls2, ResourceDecoder<T, R> resourceDecoder) {
            this.f10631a = cls;
            this.f10632b = cls2;
            this.f10633c = resourceDecoder;
        }

        public boolean a(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            if (this.f10631a.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f10632b)) {
                return true;
            }
            return false;
        }
    }

    @NonNull
    private synchronized List<Entry<?, ?>> c(@NonNull String str) {
        List<Entry<?, ?>> list;
        if (!this.f10629a.contains(str)) {
            this.f10629a.add(str);
        }
        list = this.f10630b.get(str);
        if (list == null) {
            list = new ArrayList<>();
            this.f10630b.put(str, list);
        }
        return list;
    }

    public synchronized <T, R> void a(@NonNull String str, @NonNull ResourceDecoder<T, R> resourceDecoder, @NonNull Class<T> cls, @NonNull Class<R> cls2) {
        c(str).add(new Entry<>(cls, cls2, resourceDecoder));
    }

    @NonNull
    public synchronized <T, R> List<ResourceDecoder<T, R>> b(@NonNull Class<T> cls, @NonNull Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (String str : this.f10629a) {
            List<Entry<?, ?>> list = this.f10630b.get(str);
            if (list != null) {
                for (Entry<?, ?> entry : list) {
                    if (entry.a(cls, cls2)) {
                        arrayList.add(entry.f10633c);
                    }
                }
            }
        }
        return arrayList;
    }

    @NonNull
    public synchronized <T, R> List<Class<R>> d(@NonNull Class<T> cls, @NonNull Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (String str : this.f10629a) {
            List<Entry<?, ?>> list = this.f10630b.get(str);
            if (list != null) {
                for (Entry<?, ?> entry : list) {
                    if (entry.a(cls, cls2) && !arrayList.contains(entry.f10632b)) {
                        arrayList.add(entry.f10632b);
                    }
                }
            }
        }
        return arrayList;
    }

    public synchronized void e(@NonNull List<String> list) {
        ArrayList<String> arrayList = new ArrayList(this.f10629a);
        this.f10629a.clear();
        for (String str : list) {
            this.f10629a.add(str);
        }
        for (String str2 : arrayList) {
            if (!list.contains(str2)) {
                this.f10629a.add(str2);
            }
        }
    }
}
