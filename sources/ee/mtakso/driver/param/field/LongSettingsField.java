package ee.mtakso.driver.param.field;

import eu.bolt.driver.core.storage.BoltPrefsStorage;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LongSettingsField.kt */
/* loaded from: classes3.dex */
public final class LongSettingsField {

    /* renamed from: a  reason: collision with root package name */
    private final String f23261a;

    /* renamed from: b  reason: collision with root package name */
    private final long f23262b;

    /* renamed from: c  reason: collision with root package name */
    private final BoltPrefsStorage f23263c;

    public LongSettingsField(String key, long j8, BoltPrefsStorage storage) {
        Intrinsics.f(key, "key");
        Intrinsics.f(storage, "storage");
        this.f23261a = key;
        this.f23262b = j8;
        this.f23263c = storage;
    }

    public final long a() {
        return this.f23263c.getLong(this.f23261a, this.f23262b);
    }

    public final Field<Long> b() {
        return new Field<>(new Function0<Long>() { // from class: ee.mtakso.driver.param.field.LongSettingsField$readOnly$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final Long invoke() {
                return Long.valueOf(LongSettingsField.this.a());
            }
        });
    }

    public final void c(long j8) {
        this.f23263c.g(this.f23261a, Long.valueOf(j8));
    }
}
