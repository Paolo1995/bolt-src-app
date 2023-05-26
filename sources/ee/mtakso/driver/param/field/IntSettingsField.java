package ee.mtakso.driver.param.field;

import eu.bolt.driver.core.storage.BoltPrefsStorage;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IntSettingsField.kt */
/* loaded from: classes3.dex */
public final class IntSettingsField {

    /* renamed from: a  reason: collision with root package name */
    private final String f23258a;

    /* renamed from: b  reason: collision with root package name */
    private final int f23259b;

    /* renamed from: c  reason: collision with root package name */
    private final BoltPrefsStorage f23260c;

    public IntSettingsField(String key, int i8, BoltPrefsStorage storage) {
        Intrinsics.f(key, "key");
        Intrinsics.f(storage, "storage");
        this.f23258a = key;
        this.f23259b = i8;
        this.f23260c = storage;
    }

    public final int a() {
        return this.f23260c.a(this.f23258a, this.f23259b);
    }

    public final void b(int i8) {
        this.f23260c.b(this.f23258a, Integer.valueOf(i8));
    }
}
