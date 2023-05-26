package androidx.startup;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.tracing.Trace;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class AppInitializer {

    /* renamed from: d  reason: collision with root package name */
    private static volatile AppInitializer f7769d;

    /* renamed from: e  reason: collision with root package name */
    private static final Object f7770e = new Object();
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    final Context f7773c;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    final Set<Class<? extends Initializer<?>>> f7772b = new HashSet();
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    final Map<Class<?>, Object> f7771a = new HashMap();

    AppInitializer(@NonNull Context context) {
        this.f7773c = context.getApplicationContext();
    }

    @NonNull
    private <T> T d(@NonNull Class<? extends Initializer<?>> cls, @NonNull Set<Class<?>> set) {
        T t7;
        if (Trace.d()) {
            try {
                Trace.a(cls.getSimpleName());
            } finally {
                Trace.b();
            }
        }
        if (!set.contains(cls)) {
            if (!this.f7771a.containsKey(cls)) {
                set.add(cls);
                Initializer<?> newInstance = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                List<Class<? extends Initializer<?>>> dependencies = newInstance.dependencies();
                if (!dependencies.isEmpty()) {
                    for (Class<? extends Initializer<?>> cls2 : dependencies) {
                        if (!this.f7771a.containsKey(cls2)) {
                            d(cls2, set);
                        }
                    }
                }
                t7 = (T) newInstance.a(this.f7773c);
                set.remove(cls);
                this.f7771a.put(cls, t7);
            } else {
                t7 = (T) this.f7771a.get(cls);
            }
            return t7;
        }
        throw new IllegalStateException(String.format("Cannot initialize %s. Cycle detected.", cls.getName()));
    }

    @NonNull
    public static AppInitializer e(@NonNull Context context) {
        if (f7769d == null) {
            synchronized (f7770e) {
                if (f7769d == null) {
                    f7769d = new AppInitializer(context);
                }
            }
        }
        return f7769d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        try {
            try {
                Trace.a("Startup");
                b(this.f7773c.getPackageManager().getProviderInfo(new ComponentName(this.f7773c.getPackageName(), InitializationProvider.class.getName()), 128).metaData);
            } catch (PackageManager.NameNotFoundException e8) {
                throw new StartupException(e8);
            }
        } finally {
            Trace.b();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    void b(Bundle bundle) {
        String string = this.f7773c.getString(R$string.androidx_startup);
        if (bundle != null) {
            try {
                HashSet hashSet = new HashSet();
                for (String str : bundle.keySet()) {
                    if (string.equals(bundle.getString(str, null))) {
                        Class<?> cls = Class.forName(str);
                        if (Initializer.class.isAssignableFrom(cls)) {
                            this.f7772b.add(cls);
                        }
                    }
                }
                for (Class<? extends Initializer<?>> cls2 : this.f7772b) {
                    d(cls2, hashSet);
                }
            } catch (ClassNotFoundException e8) {
                throw new StartupException(e8);
            }
        }
    }

    @NonNull
    <T> T c(@NonNull Class<? extends Initializer<?>> cls) {
        T t7;
        synchronized (f7770e) {
            t7 = (T) this.f7771a.get(cls);
            if (t7 == null) {
                t7 = (T) d(cls, new HashSet());
            }
        }
        return t7;
    }

    @NonNull
    public <T> T f(@NonNull Class<? extends Initializer<T>> cls) {
        return (T) c(cls);
    }

    public boolean g(@NonNull Class<? extends Initializer<?>> cls) {
        return this.f7772b.contains(cls);
    }
}
