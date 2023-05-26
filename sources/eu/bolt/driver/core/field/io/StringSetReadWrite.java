package eu.bolt.driver.core.field.io;

import eu.bolt.driver.core.storage.BoltPrefsStorage;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StringSetReadWrite.kt */
/* loaded from: classes5.dex */
public final class StringSetReadWrite implements ReadWrite<Set<? extends String>> {

    /* renamed from: a  reason: collision with root package name */
    private final BoltPrefsStorage f40811a;

    public StringSetReadWrite(BoltPrefsStorage storage) {
        Intrinsics.f(storage, "storage");
        this.f40811a = storage;
    }

    @Override // eu.bolt.driver.core.field.io.ReadWrite
    public boolean c(String key) {
        Intrinsics.f(key, "key");
        return this.f40811a.contains(key);
    }

    @Override // eu.bolt.driver.core.field.io.ReadWrite
    /* renamed from: d */
    public Set<String> a(String key, Set<String> fallback) {
        Intrinsics.f(key, "key");
        Intrinsics.f(fallback, "fallback");
        return this.f40811a.getStringSet(key, fallback);
    }

    @Override // eu.bolt.driver.core.field.io.ReadWrite
    /* renamed from: e */
    public void b(String key, Set<String> value) {
        Intrinsics.f(key, "key");
        Intrinsics.f(value, "value");
        this.f40811a.d(key, value);
    }
}
