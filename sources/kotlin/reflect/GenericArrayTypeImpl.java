package kotlin.reflect;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TypesJVM.kt */
/* loaded from: classes5.dex */
public final class GenericArrayTypeImpl implements GenericArrayType, Type {

    /* renamed from: f  reason: collision with root package name */
    private final Type f51071f;

    public GenericArrayTypeImpl(Type elementType) {
        Intrinsics.f(elementType, "elementType");
        this.f51071f = elementType;
    }

    public boolean equals(Object obj) {
        if ((obj instanceof GenericArrayType) && Intrinsics.a(getGenericComponentType(), ((GenericArrayType) obj).getGenericComponentType())) {
            return true;
        }
        return false;
    }

    @Override // java.lang.reflect.GenericArrayType
    public Type getGenericComponentType() {
        return this.f51071f;
    }

    @Override // java.lang.reflect.Type
    public String getTypeName() {
        String h8;
        StringBuilder sb = new StringBuilder();
        h8 = TypesJVMKt.h(this.f51071f);
        sb.append(h8);
        sb.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        return sb.toString();
    }

    public int hashCode() {
        return getGenericComponentType().hashCode();
    }

    public String toString() {
        return getTypeName();
    }
}
