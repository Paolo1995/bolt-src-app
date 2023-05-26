package ee.mtakso.driver.param.field;

/* compiled from: ConfigField.kt */
/* loaded from: classes3.dex */
public final class ConfigField<T> {

    /* renamed from: a  reason: collision with root package name */
    private final T f23255a;

    /* renamed from: b  reason: collision with root package name */
    private T f23256b;

    public ConfigField(T t7) {
        this.f23255a = t7;
    }

    public final T a() {
        T t7 = this.f23256b;
        if (t7 == null) {
            return this.f23255a;
        }
        return t7;
    }
}
