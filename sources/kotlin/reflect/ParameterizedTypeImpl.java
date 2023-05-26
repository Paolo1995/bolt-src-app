package kotlin.reflect;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TypesJVM.kt */
/* loaded from: classes5.dex */
public final class ParameterizedTypeImpl implements ParameterizedType, Type {

    /* renamed from: f  reason: collision with root package name */
    private final Class<?> f51081f;

    /* renamed from: g  reason: collision with root package name */
    private final Type f51082g;

    /* renamed from: h  reason: collision with root package name */
    private final Type[] f51083h;

    public ParameterizedTypeImpl(Class<?> rawType, Type type, List<? extends Type> typeArguments) {
        Intrinsics.f(rawType, "rawType");
        Intrinsics.f(typeArguments, "typeArguments");
        this.f51081f = rawType;
        this.f51082g = type;
        this.f51083h = (Type[]) typeArguments.toArray(new Type[0]);
    }

    public boolean equals(Object obj) {
        if (obj instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) obj;
            if (Intrinsics.a(this.f51081f, parameterizedType.getRawType()) && Intrinsics.a(this.f51082g, parameterizedType.getOwnerType()) && Arrays.equals(getActualTypeArguments(), parameterizedType.getActualTypeArguments())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type[] getActualTypeArguments() {
        return this.f51083h;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getOwnerType() {
        return this.f51082g;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getRawType() {
        return this.f51081f;
    }

    @Override // java.lang.reflect.Type
    public String getTypeName() {
        String h8;
        boolean z7;
        String h9;
        StringBuilder sb = new StringBuilder();
        Type type = this.f51082g;
        if (type != null) {
            h9 = TypesJVMKt.h(type);
            sb.append(h9);
            sb.append("$");
            sb.append(this.f51081f.getSimpleName());
        } else {
            h8 = TypesJVMKt.h(this.f51081f);
            sb.append(h8);
        }
        Type[] typeArr = this.f51083h;
        if (typeArr.length == 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (!z7) {
            ArraysKt___ArraysKt.R(typeArr, sb, null, "<", ">", 0, null, ParameterizedTypeImpl$getTypeName$1$1.f51084o, 50, null);
        }
        String sb2 = sb.toString();
        Intrinsics.e(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public int hashCode() {
        int i8;
        int hashCode = this.f51081f.hashCode();
        Type type = this.f51082g;
        if (type != null) {
            i8 = type.hashCode();
        } else {
            i8 = 0;
        }
        return (hashCode ^ i8) ^ Arrays.hashCode(getActualTypeArguments());
    }

    public String toString() {
        return getTypeName();
    }
}
