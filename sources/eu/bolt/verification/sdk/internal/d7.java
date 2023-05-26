package eu.bolt.verification.sdk.internal;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public abstract class d7<T> {

    /* renamed from: a  reason: collision with root package name */
    private final String f42617a;

    /* renamed from: b  reason: collision with root package name */
    private final T f42618b;

    /* renamed from: c  reason: collision with root package name */
    private final String f42619c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f42620d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f42621e;

    /* renamed from: f  reason: collision with root package name */
    private final e7 f42622f;

    /* loaded from: classes5.dex */
    public static final class a<T> extends d7<T> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String valueKey, T t7, String str, boolean z7, boolean z8, e7 type) {
            super(valueKey, t7, str, z7, z8, type, null);
            Intrinsics.f(valueKey, "valueKey");
            Intrinsics.f(type, "type");
        }

        public /* synthetic */ a(String str, Object obj, String str2, boolean z7, boolean z8, e7 e7Var, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, obj, (i8 & 4) != 0 ? null : str2, (i8 & 8) != 0 ? true : z7, (i8 & 16) != 0 ? false : z8, e7Var);
        }
    }

    /* loaded from: classes5.dex */
    public static final class b<T> extends d7<T> {

        /* renamed from: g  reason: collision with root package name */
        private final c7 f42623g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(c7 identifier, String valueKey, T t7, String str, boolean z7, boolean z8, e7 type) {
            super(valueKey, t7, str, z7, z8, type, null);
            Intrinsics.f(identifier, "identifier");
            Intrinsics.f(valueKey, "valueKey");
            Intrinsics.f(type, "type");
            this.f42623g = identifier;
        }

        public /* synthetic */ b(c7 c7Var, String str, Object obj, String str2, boolean z7, boolean z8, e7 e7Var, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this(c7Var, str, obj, (i8 & 8) != 0 ? null : str2, (i8 & 16) != 0 ? true : z7, z8, e7Var);
        }
    }

    private d7(String str, T t7, String str2, boolean z7, boolean z8, e7 e7Var) {
        this.f42617a = str;
        this.f42618b = t7;
        this.f42619c = str2;
        this.f42620d = z7;
        this.f42621e = z8;
        this.f42622f = e7Var;
    }

    public /* synthetic */ d7(String str, Object obj, String str2, boolean z7, boolean z8, e7 e7Var, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, obj, str2, z7, z8, e7Var);
    }
}
