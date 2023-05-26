package eu.bolt.driver.core.storage.field;

import eu.bolt.driver.core.storage.KVStorage;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NullableStringReadWrite.kt */
/* loaded from: classes5.dex */
public final class NullableStringReadWrite implements ReadWrite<String> {

    /* renamed from: a  reason: collision with root package name */
    private final KVStorage f40955a;

    public NullableStringReadWrite(KVStorage storage) {
        Intrinsics.f(storage, "storage");
        this.f40955a = storage;
    }

    @Override // eu.bolt.driver.core.storage.field.ReadWrite
    /* renamed from: c */
    public String a(String key, String str) {
        Intrinsics.f(key, "key");
        String string = this.f40955a.getString(key, null);
        if (string != null) {
            return string;
        }
        return str;
    }

    @Override // eu.bolt.driver.core.storage.field.ReadWrite
    /* renamed from: d */
    public void b(String key, String str) {
        Intrinsics.f(key, "key");
        this.f40955a.c(key, str);
    }
}
