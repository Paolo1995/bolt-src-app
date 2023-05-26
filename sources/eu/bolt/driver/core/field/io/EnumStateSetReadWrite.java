package eu.bolt.driver.core.field.io;

import eu.bolt.driver.core.storage.BoltPrefsStorage;
import java.lang.Enum;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EnumStateSetReadWrite.kt */
/* loaded from: classes5.dex */
public final class EnumStateSetReadWrite<TE extends Enum<TE>> implements ReadWrite<TE> {

    /* renamed from: a  reason: collision with root package name */
    private final BoltPrefsStorage f40803a;

    public EnumStateSetReadWrite(BoltPrefsStorage driverStorage) {
        Intrinsics.f(driverStorage, "driverStorage");
        this.f40803a = driverStorage;
    }

    @Override // eu.bolt.driver.core.field.io.ReadWrite
    public boolean c(String key) {
        Intrinsics.f(key, "key");
        return this.f40803a.contains(key);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Enum] */
    @Override // eu.bolt.driver.core.field.io.ReadWrite
    /* renamed from: d */
    public TE a(String key, TE fallback) {
        Intrinsics.f(key, "key");
        Intrinsics.f(fallback, "fallback");
        TE te = null;
        String string = this.f40803a.getString(key, null);
        if (string != null) {
            try {
                te = Enum.valueOf(fallback.getClass(), string);
            } catch (IllegalArgumentException unused) {
                te = fallback;
            }
        }
        if (te != null) {
            return te;
        }
        return fallback;
    }

    @Override // eu.bolt.driver.core.field.io.ReadWrite
    /* renamed from: e */
    public void b(String key, TE value) {
        Intrinsics.f(key, "key");
        Intrinsics.f(value, "value");
        this.f40803a.c(key, value.name());
    }
}
