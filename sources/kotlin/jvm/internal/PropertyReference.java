package kotlin.jvm.internal;

import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty;

/* loaded from: classes5.dex */
public abstract class PropertyReference extends CallableReference implements KProperty {
    public PropertyReference() {
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PropertyReference) {
            PropertyReference propertyReference = (PropertyReference) obj;
            if (g().equals(propertyReference.g()) && getName().equals(propertyReference.getName()) && i().equals(propertyReference.i()) && Intrinsics.a(e(), propertyReference.e())) {
                return true;
            }
            return false;
        } else if (!(obj instanceof KProperty)) {
            return false;
        } else {
            return obj.equals(c());
        }
    }

    public int hashCode() {
        return (((g().hashCode() * 31) + getName().hashCode()) * 31) + i().hashCode();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public KProperty j() {
        return (KProperty) super.h();
    }

    public String toString() {
        KCallable c8 = c();
        if (c8 != this) {
            return c8.toString();
        }
        return "property " + getName() + " (Kotlin reflection is not available)";
    }

    public PropertyReference(Object obj, Class cls, String str, String str2, int i8) {
        super(obj, cls, str, str2, (i8 & 1) == 1);
    }
}
