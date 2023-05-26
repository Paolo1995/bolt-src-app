package kotlin.reflect;

import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;
import kotlin.NotImplementedError;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TypesJVM.kt */
/* loaded from: classes5.dex */
public final class TypeVariableImpl implements TypeVariable<GenericDeclaration>, Type {

    /* renamed from: f  reason: collision with root package name */
    private final KTypeParameter f51085f;

    public TypeVariableImpl(KTypeParameter typeParameter) {
        Intrinsics.f(typeParameter, "typeParameter");
        this.f51085f = typeParameter;
    }

    public boolean equals(Object obj) {
        if (obj instanceof TypeVariable) {
            TypeVariable typeVariable = (TypeVariable) obj;
            if (Intrinsics.a(getName(), typeVariable.getName()) && Intrinsics.a(getGenericDeclaration(), typeVariable.getGenericDeclaration())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.reflect.TypeVariable
    public Type[] getBounds() {
        int v7;
        Type c8;
        List<KType> upperBounds = this.f51085f.getUpperBounds();
        v7 = CollectionsKt__IterablesKt.v(upperBounds, 10);
        ArrayList arrayList = new ArrayList(v7);
        for (KType kType : upperBounds) {
            c8 = TypesJVMKt.c(kType, true);
            arrayList.add(c8);
        }
        return (Type[]) arrayList.toArray(new Type[0]);
    }

    @Override // java.lang.reflect.TypeVariable
    public GenericDeclaration getGenericDeclaration() {
        throw new NotImplementedError("An operation is not implemented: " + ("getGenericDeclaration() is not yet supported for type variables created from KType: " + this.f51085f));
    }

    @Override // java.lang.reflect.TypeVariable
    public String getName() {
        return this.f51085f.getName();
    }

    @Override // java.lang.reflect.Type
    public String getTypeName() {
        return getName();
    }

    public int hashCode() {
        return getName().hashCode() ^ getGenericDeclaration().hashCode();
    }

    public String toString() {
        return getTypeName();
    }
}
