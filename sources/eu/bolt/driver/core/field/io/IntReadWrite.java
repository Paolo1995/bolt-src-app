package eu.bolt.driver.core.field.io;

import eu.bolt.driver.core.storage.BoltPrefsStorage;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IntReadWrite.kt */
/* loaded from: classes5.dex */
public final class IntReadWrite implements ReadWrite<Integer> {

    /* renamed from: a  reason: collision with root package name */
    private final BoltPrefsStorage f40804a;

    public IntReadWrite(BoltPrefsStorage storage) {
        Intrinsics.f(storage, "storage");
        this.f40804a = storage;
    }

    @Override // eu.bolt.driver.core.field.io.ReadWrite
    public /* bridge */ /* synthetic */ Integer a(String str, Integer num) {
        return d(str, num.intValue());
    }

    @Override // eu.bolt.driver.core.field.io.ReadWrite
    public /* bridge */ /* synthetic */ void b(String str, Integer num) {
        e(str, num.intValue());
    }

    @Override // eu.bolt.driver.core.field.io.ReadWrite
    public boolean c(String key) {
        Intrinsics.f(key, "key");
        return this.f40804a.contains(key);
    }

    public Integer d(String key, int i8) {
        Intrinsics.f(key, "key");
        return Integer.valueOf(this.f40804a.a(key, i8));
    }

    public void e(String key, int i8) {
        Intrinsics.f(key, "key");
        this.f40804a.b(key, Integer.valueOf(i8));
    }
}
