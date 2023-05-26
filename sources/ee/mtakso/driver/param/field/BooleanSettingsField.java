package ee.mtakso.driver.param.field;

import eu.bolt.driver.core.storage.BoltPrefsStorage;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BooleanSettingsField.kt */
/* loaded from: classes3.dex */
public final class BooleanSettingsField {

    /* renamed from: a  reason: collision with root package name */
    private final String f23252a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f23253b;

    /* renamed from: c  reason: collision with root package name */
    private final BoltPrefsStorage f23254c;

    public BooleanSettingsField(String key, boolean z7, BoltPrefsStorage storage) {
        Intrinsics.f(key, "key");
        Intrinsics.f(storage, "storage");
        this.f23252a = key;
        this.f23253b = z7;
        this.f23254c = storage;
    }

    public final boolean a() {
        return this.f23254c.getBoolean(this.f23252a, this.f23253b);
    }

    public final void b(boolean z7) {
        this.f23254c.h(this.f23252a, Boolean.valueOf(z7));
    }
}
