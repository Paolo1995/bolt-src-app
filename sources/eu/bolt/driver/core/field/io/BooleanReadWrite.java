package eu.bolt.driver.core.field.io;

import eu.bolt.driver.core.storage.BoltPrefsStorage;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BooleanReadWrite.kt */
/* loaded from: classes5.dex */
public final class BooleanReadWrite implements ReadWrite<Boolean> {

    /* renamed from: a  reason: collision with root package name */
    private final BoltPrefsStorage f40802a;

    public BooleanReadWrite(BoltPrefsStorage storage) {
        Intrinsics.f(storage, "storage");
        this.f40802a = storage;
    }

    @Override // eu.bolt.driver.core.field.io.ReadWrite
    public /* bridge */ /* synthetic */ Boolean a(String str, Boolean bool) {
        return d(str, bool.booleanValue());
    }

    @Override // eu.bolt.driver.core.field.io.ReadWrite
    public /* bridge */ /* synthetic */ void b(String str, Boolean bool) {
        e(str, bool.booleanValue());
    }

    @Override // eu.bolt.driver.core.field.io.ReadWrite
    public boolean c(String key) {
        Intrinsics.f(key, "key");
        return this.f40802a.contains(key);
    }

    public Boolean d(String key, boolean z7) {
        Intrinsics.f(key, "key");
        return Boolean.valueOf(this.f40802a.getBoolean(key, z7));
    }

    public void e(String key, boolean z7) {
        Intrinsics.f(key, "key");
        this.f40802a.h(key, Boolean.valueOf(z7));
    }
}
