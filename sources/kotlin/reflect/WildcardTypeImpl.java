package kotlin.reflect;

import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TypesJVM.kt */
/* loaded from: classes5.dex */
public final class WildcardTypeImpl implements WildcardType, Type {

    /* renamed from: h  reason: collision with root package name */
    public static final Companion f51088h = new Companion(null);

    /* renamed from: i  reason: collision with root package name */
    private static final WildcardTypeImpl f51089i = new WildcardTypeImpl(null, null);

    /* renamed from: f  reason: collision with root package name */
    private final Type f51090f;

    /* renamed from: g  reason: collision with root package name */
    private final Type f51091g;

    /* compiled from: TypesJVM.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final WildcardTypeImpl a() {
            return WildcardTypeImpl.f51089i;
        }
    }

    public WildcardTypeImpl(Type type, Type type2) {
        this.f51090f = type;
        this.f51091g = type2;
    }

    public boolean equals(Object obj) {
        if (obj instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) obj;
            if (Arrays.equals(getUpperBounds(), wildcardType.getUpperBounds()) && Arrays.equals(getLowerBounds(), wildcardType.getLowerBounds())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.reflect.WildcardType
    public Type[] getLowerBounds() {
        Type type = this.f51091g;
        return type == null ? new Type[0] : new Type[]{type};
    }

    @Override // java.lang.reflect.Type
    public String getTypeName() {
        String h8;
        String h9;
        if (this.f51091g != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("? super ");
            h9 = TypesJVMKt.h(this.f51091g);
            sb.append(h9);
            return sb.toString();
        }
        Type type = this.f51090f;
        if (type != null && !Intrinsics.a(type, Object.class)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("? extends ");
            h8 = TypesJVMKt.h(this.f51090f);
            sb2.append(h8);
            return sb2.toString();
        }
        return "?";
    }

    @Override // java.lang.reflect.WildcardType
    public Type[] getUpperBounds() {
        Type[] typeArr = new Type[1];
        Type type = this.f51090f;
        if (type == null) {
            type = Object.class;
        }
        typeArr[0] = type;
        return typeArr;
    }

    public int hashCode() {
        return Arrays.hashCode(getUpperBounds()) ^ Arrays.hashCode(getLowerBounds());
    }

    public String toString() {
        return getTypeName();
    }
}
