package com.bumptech.glide.provider;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Encoder;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class EncoderRegistry {

    /* renamed from: a  reason: collision with root package name */
    private final List<Entry<?>> f10620a = new ArrayList();

    /* loaded from: classes.dex */
    private static final class Entry<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Class<T> f10621a;

        /* renamed from: b  reason: collision with root package name */
        final Encoder<T> f10622b;

        Entry(@NonNull Class<T> cls, @NonNull Encoder<T> encoder) {
            this.f10621a = cls;
            this.f10622b = encoder;
        }

        boolean a(@NonNull Class<?> cls) {
            return this.f10621a.isAssignableFrom(cls);
        }
    }

    public synchronized <T> void a(@NonNull Class<T> cls, @NonNull Encoder<T> encoder) {
        this.f10620a.add(new Entry<>(cls, encoder));
    }

    public synchronized <T> Encoder<T> b(@NonNull Class<T> cls) {
        for (Entry<?> entry : this.f10620a) {
            if (entry.a(cls)) {
                return (Encoder<T>) entry.f10622b;
            }
        }
        return null;
    }
}
