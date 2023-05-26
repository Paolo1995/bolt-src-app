package eu.bolt.driver.core.field.io;

import eu.bolt.driver.core.storage.BoltPrefsStorage;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LongReadWrite.kt */
/* loaded from: classes5.dex */
public final class LongReadWrite implements ReadWrite<Long> {

    /* renamed from: a  reason: collision with root package name */
    private final BoltPrefsStorage f40809a;

    public LongReadWrite(BoltPrefsStorage storage) {
        Intrinsics.f(storage, "storage");
        this.f40809a = storage;
    }

    @Override // eu.bolt.driver.core.field.io.ReadWrite
    public /* bridge */ /* synthetic */ Long a(String str, Long l8) {
        return d(str, l8.longValue());
    }

    @Override // eu.bolt.driver.core.field.io.ReadWrite
    public /* bridge */ /* synthetic */ void b(String str, Long l8) {
        e(str, l8.longValue());
    }

    @Override // eu.bolt.driver.core.field.io.ReadWrite
    public boolean c(String key) {
        Intrinsics.f(key, "key");
        return this.f40809a.contains(key);
    }

    public Long d(String key, long j8) {
        Intrinsics.f(key, "key");
        return Long.valueOf(this.f40809a.getLong(key, j8));
    }

    public void e(String key, long j8) {
        Intrinsics.f(key, "key");
        this.f40809a.g(key, Long.valueOf(j8));
    }
}
