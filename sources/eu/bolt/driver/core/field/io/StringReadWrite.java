package eu.bolt.driver.core.field.io;

import eu.bolt.driver.core.storage.BoltPrefsStorage;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StringReadWrite.kt */
/* loaded from: classes5.dex */
public final class StringReadWrite implements ReadWrite<String> {

    /* renamed from: a  reason: collision with root package name */
    private final BoltPrefsStorage f40810a;

    public StringReadWrite(BoltPrefsStorage storage) {
        Intrinsics.f(storage, "storage");
        this.f40810a = storage;
    }

    @Override // eu.bolt.driver.core.field.io.ReadWrite
    public boolean c(String key) {
        Intrinsics.f(key, "key");
        return this.f40810a.contains(key);
    }

    @Override // eu.bolt.driver.core.field.io.ReadWrite
    /* renamed from: d */
    public String a(String key, String fallback) {
        Intrinsics.f(key, "key");
        Intrinsics.f(fallback, "fallback");
        String string = this.f40810a.getString(key, null);
        if (string != null) {
            return string;
        }
        return fallback;
    }

    @Override // eu.bolt.driver.core.field.io.ReadWrite
    /* renamed from: e */
    public void b(String key, String value) {
        Intrinsics.f(key, "key");
        Intrinsics.f(value, "value");
        this.f40810a.c(key, value);
    }
}
