package ee.mtakso.driver.param.field;

import eu.bolt.driver.core.storage.BoltPrefsStorage;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StringSettingsField.kt */
/* loaded from: classes3.dex */
public final class StringSettingsField {

    /* renamed from: a  reason: collision with root package name */
    private final String f23265a;

    /* renamed from: b  reason: collision with root package name */
    private final String f23266b;

    /* renamed from: c  reason: collision with root package name */
    private final BoltPrefsStorage f23267c;

    public StringSettingsField(String key, String str, BoltPrefsStorage storage) {
        Intrinsics.f(key, "key");
        Intrinsics.f(storage, "storage");
        this.f23265a = key;
        this.f23266b = str;
        this.f23267c = storage;
    }

    public final String a() {
        return this.f23267c.getString(this.f23265a, this.f23266b);
    }

    public final void b(String str) {
        this.f23267c.c(this.f23265a, str);
    }
}
