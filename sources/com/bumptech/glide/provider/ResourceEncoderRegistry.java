package com.bumptech.glide.provider;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.ResourceEncoder;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class ResourceEncoderRegistry {

    /* renamed from: a  reason: collision with root package name */
    private final List<Entry<?>> f10634a = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class Entry<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Class<T> f10635a;

        /* renamed from: b  reason: collision with root package name */
        final ResourceEncoder<T> f10636b;

        Entry(@NonNull Class<T> cls, @NonNull ResourceEncoder<T> resourceEncoder) {
            this.f10635a = cls;
            this.f10636b = resourceEncoder;
        }

        boolean a(@NonNull Class<?> cls) {
            return this.f10635a.isAssignableFrom(cls);
        }
    }

    public synchronized <Z> void a(@NonNull Class<Z> cls, @NonNull ResourceEncoder<Z> resourceEncoder) {
        this.f10634a.add(new Entry<>(cls, resourceEncoder));
    }

    public synchronized <Z> ResourceEncoder<Z> b(@NonNull Class<Z> cls) {
        int size = this.f10634a.size();
        for (int i8 = 0; i8 < size; i8++) {
            Entry<?> entry = this.f10634a.get(i8);
            if (entry.a(cls)) {
                return (ResourceEncoder<Z>) entry.f10636b;
            }
        }
        return null;
    }
}
