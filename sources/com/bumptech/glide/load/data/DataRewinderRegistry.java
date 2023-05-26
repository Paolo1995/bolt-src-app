package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.util.Preconditions;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class DataRewinderRegistry {

    /* renamed from: b  reason: collision with root package name */
    private static final DataRewinder.Factory<?> f9940b = new DataRewinder.Factory<Object>() { // from class: com.bumptech.glide.load.data.DataRewinderRegistry.1
        @Override // com.bumptech.glide.load.data.DataRewinder.Factory
        @NonNull
        public Class<Object> a() {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override // com.bumptech.glide.load.data.DataRewinder.Factory
        @NonNull
        public DataRewinder<Object> b(@NonNull Object obj) {
            return new DefaultRewinder(obj);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final Map<Class<?>, DataRewinder.Factory<?>> f9941a = new HashMap();

    /* loaded from: classes.dex */
    private static final class DefaultRewinder implements DataRewinder<Object> {

        /* renamed from: a  reason: collision with root package name */
        private final Object f9942a;

        DefaultRewinder(@NonNull Object obj) {
            this.f9942a = obj;
        }

        @Override // com.bumptech.glide.load.data.DataRewinder
        @NonNull
        public Object a() {
            return this.f9942a;
        }

        @Override // com.bumptech.glide.load.data.DataRewinder
        public void b() {
        }
    }

    @NonNull
    public synchronized <T> DataRewinder<T> a(@NonNull T t7) {
        DataRewinder.Factory<?> factory;
        Preconditions.d(t7);
        factory = this.f9941a.get(t7.getClass());
        if (factory == null) {
            Iterator<DataRewinder.Factory<?>> it = this.f9941a.values().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                DataRewinder.Factory<?> next = it.next();
                if (next.a().isAssignableFrom(t7.getClass())) {
                    factory = next;
                    break;
                }
            }
        }
        if (factory == null) {
            factory = f9940b;
        }
        return (DataRewinder<T>) factory.b(t7);
    }

    public synchronized void b(@NonNull DataRewinder.Factory<?> factory) {
        this.f9941a.put(factory.a(), factory);
    }
}
