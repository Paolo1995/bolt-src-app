package kotlin.jvm.internal;

/* loaded from: classes5.dex */
public class PropertyReference1Impl extends PropertyReference1 {
    public PropertyReference1Impl(Class cls, String str, String str2, int i8) {
        super(CallableReference.f50987l, cls, str, str2, i8);
    }

    @Override // kotlin.reflect.KProperty1
    public Object get(Object obj) {
        return a().b(obj);
    }
}
