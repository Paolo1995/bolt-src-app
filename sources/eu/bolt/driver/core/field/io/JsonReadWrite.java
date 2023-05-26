package eu.bolt.driver.core.field.io;

import com.google.gson.Gson;
import eu.bolt.driver.core.storage.BoltPrefsStorage;
import java.lang.reflect.Type;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: JsonReadWrite.kt */
/* loaded from: classes5.dex */
public final class JsonReadWrite<T> implements ReadWrite<T> {

    /* renamed from: a  reason: collision with root package name */
    private final BoltPrefsStorage f40805a;

    /* renamed from: b  reason: collision with root package name */
    private final Type f40806b;

    /* renamed from: c  reason: collision with root package name */
    private final Lazy f40807c;

    public JsonReadWrite(BoltPrefsStorage storage, Type type) {
        Lazy b8;
        Intrinsics.f(storage, "storage");
        Intrinsics.f(type, "type");
        this.f40805a = storage;
        this.f40806b = type;
        b8 = LazyKt__LazyJVMKt.b(new Function0<Gson>() { // from class: eu.bolt.driver.core.field.io.JsonReadWrite$gson$2
            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final Gson invoke() {
                return new Gson();
            }
        });
        this.f40807c = b8;
    }

    private final Gson d() {
        return (Gson) this.f40807c.getValue();
    }

    @Override // eu.bolt.driver.core.field.io.ReadWrite
    public T a(String key, T t7) {
        Intrinsics.f(key, "key");
        String string = this.f40805a.getString(key, null);
        if (string == null) {
            return t7;
        }
        return (T) d().fromJson(string, this.f40806b);
    }

    @Override // eu.bolt.driver.core.field.io.ReadWrite
    public void b(String key, T t7) {
        Intrinsics.f(key, "key");
        if (t7 == null) {
            this.f40805a.c(key, null);
        } else {
            this.f40805a.c(key, d().toJson(t7, this.f40806b));
        }
    }

    @Override // eu.bolt.driver.core.field.io.ReadWrite
    public boolean c(String key) {
        Intrinsics.f(key, "key");
        return this.f40805a.contains(key);
    }
}
