package org.koin.core.scope;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.KotlinNothingValueException;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.koin.core.Koin;
import org.koin.core.error.ClosedScopeException;
import org.koin.core.error.NoBeanDefFoundException;
import org.koin.core.instance.InstanceContext;
import org.koin.core.logger.Level;
import org.koin.core.logger.Logger;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.ext.KClassExtKt;
import org.koin.mp.KoinPlatformTools;

/* compiled from: Scope.kt */
/* loaded from: classes5.dex */
public final class Scope {

    /* renamed from: a  reason: collision with root package name */
    private final Qualifier f52793a;

    /* renamed from: b  reason: collision with root package name */
    private final String f52794b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f52795c;

    /* renamed from: d  reason: collision with root package name */
    private final Koin f52796d;

    /* renamed from: e  reason: collision with root package name */
    private final ArrayList<Scope> f52797e;

    /* renamed from: f  reason: collision with root package name */
    private Object f52798f;

    /* renamed from: g  reason: collision with root package name */
    private final ArrayList<ScopeCallback> f52799g;

    /* renamed from: h  reason: collision with root package name */
    private final ArrayDeque<ParametersHolder> f52800h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f52801i;

    public /* synthetic */ Scope(Qualifier qualifier, String str, boolean z7, Koin koin, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(qualifier, str, (i8 & 4) != 0 ? false : z7, koin);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c() {
        this.f52798f = null;
        Logger d8 = this.f52796d.d();
        String str = "|- (-) Scope - id:'" + this.f52794b + '\'';
        Level level = Level.DEBUG;
        if (d8.b(level)) {
            d8.a(level, str);
        }
        for (ScopeCallback scopeCallback : this.f52799g) {
            scopeCallback.a(this);
        }
        this.f52799g.clear();
    }

    private final <T> T e(KClass<?> kClass, Qualifier qualifier, Function0<? extends ParametersHolder> function0) {
        Iterator<Scope> it = this.f52797e.iterator();
        T t7 = null;
        while (it.hasNext() && (t7 = (T) it.next().i(kClass, qualifier, function0)) == null) {
        }
        return t7;
    }

    private final <T> T o(Qualifier qualifier, KClass<?> kClass, Function0<? extends ParametersHolder> function0) {
        final ParametersHolder parametersHolder;
        if (!this.f52801i) {
            if (function0 != null) {
                parametersHolder = function0.invoke();
            } else {
                parametersHolder = null;
            }
            if (parametersHolder != null) {
                Logger d8 = this.f52796d.d();
                Level level = Level.DEBUG;
                if (d8.b(level)) {
                    d8.a(level, "| >> parameters " + parametersHolder + ' ');
                }
                KoinPlatformTools.f52811a.f(this, new Function0<Unit>() { // from class: org.koin.core.scope.Scope$resolveInstance$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    public final void b() {
                        Scope.this.l().addFirst(parametersHolder);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        b();
                        return Unit.f50853a;
                    }
                });
            }
            T t7 = (T) p(qualifier, kClass, new InstanceContext(this.f52796d, this, parametersHolder), function0);
            if (parametersHolder != null) {
                Logger d9 = this.f52796d.d();
                Level level2 = Level.DEBUG;
                if (d9.b(level2)) {
                    d9.a(level2, "| << parameters");
                }
                KoinPlatformTools.f52811a.f(this, new Function0<ParametersHolder>() { // from class: org.koin.core.scope.Scope$resolveInstance$3
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    /* renamed from: b */
                    public final ParametersHolder invoke() {
                        return Scope.this.l().s();
                    }
                });
            }
            return t7;
        }
        throw new ClosedScopeException("Scope '" + this.f52794b + "' is closed");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5 */
    private final <T> T p(Qualifier qualifier, KClass<?> kClass, InstanceContext instanceContext, Function0<? extends ParametersHolder> function0) {
        Object obj;
        T t7 = (T) this.f52796d.c().g(qualifier, kClass, this.f52793a, instanceContext);
        if (t7 == null) {
            Logger d8 = this.f52796d.d();
            String str = "|- ? t:'" + KClassExtKt.a(kClass) + "' - q:'" + qualifier + "' look in injected parameters";
            Level level = Level.DEBUG;
            if (d8.b(level)) {
                d8.a(level, str);
            }
            ParametersHolder n8 = this.f52800h.n();
            Object obj2 = null;
            if (n8 != null) {
                t7 = (T) n8.b(kClass);
            } else {
                t7 = null;
            }
            if (t7 == null) {
                Logger d9 = this.f52796d.d();
                String str2 = "|- ? t:'" + KClassExtKt.a(kClass) + "' - q:'" + qualifier + "' look at scope source";
                if (d9.b(level)) {
                    d9.a(level, str2);
                }
                Object obj3 = this.f52798f;
                if (obj3 != null && kClass.a(obj3) && (obj = this.f52798f) != null) {
                    obj2 = obj;
                }
                t7 = obj2;
                if (t7 == null) {
                    Logger d10 = this.f52796d.d();
                    String str3 = "|- ? t:'" + KClassExtKt.a(kClass) + "' - q:'" + qualifier + "' look in other scopes";
                    if (d10.b(level)) {
                        d10.a(level, str3);
                    }
                    t7 = (T) e(kClass, qualifier, function0);
                    if (t7 == null) {
                        KoinPlatformTools.f52811a.f(this, new Function0<Unit>() { // from class: org.koin.core.scope.Scope$resolveValue$4$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(0);
                            }

                            public final void b() {
                                Scope.this.l().clear();
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                b();
                                return Unit.f50853a;
                            }
                        });
                        Logger d11 = this.f52796d.d();
                        if (d11.b(level)) {
                            d11.a(level, "|- << parameters");
                        }
                        r(qualifier, kClass);
                        throw new KotlinNothingValueException();
                    }
                }
            }
        }
        return t7;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0018, code lost:
        if (r4 == null) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.Void r(org.koin.core.qualifier.Qualifier r4, kotlin.reflect.KClass<?> r5) {
        /*
            r3 = this;
            if (r4 == 0) goto L1a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = " & qualifier:'"
            r0.append(r1)
            r0.append(r4)
            r4 = 39
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            if (r4 != 0) goto L1c
        L1a:
            java.lang.String r4 = ""
        L1c:
            org.koin.core.error.NoBeanDefFoundException r0 = new org.koin.core.error.NoBeanDefFoundException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "No definition found for class:'"
            r1.append(r2)
            java.lang.String r5 = org.koin.ext.KClassExtKt.a(r5)
            r1.append(r5)
            java.lang.String r5 = "' q:'"
            r1.append(r5)
            r1.append(r4)
            java.lang.String r4 = "'. Check your definitions!"
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            r0.<init>(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.koin.core.scope.Scope.r(org.koin.core.qualifier.Qualifier, kotlin.reflect.KClass):java.lang.Void");
    }

    public final void d() {
        KoinPlatformTools.f52811a.f(this, new Function0<Unit>() { // from class: org.koin.core.scope.Scope$close$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final void b() {
                Scope.this.f52801i = true;
                Scope.this.c();
                Scope.this.k().e().c(Scope.this);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                b();
                return Unit.f50853a;
            }
        });
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Scope) {
            Scope scope = (Scope) obj;
            return Intrinsics.a(this.f52793a, scope.f52793a) && Intrinsics.a(this.f52794b, scope.f52794b) && this.f52795c == scope.f52795c && Intrinsics.a(this.f52796d, scope.f52796d);
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x002b, code lost:
        if (r2 == null) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final <T> T f(kotlin.reflect.KClass<?> r9, org.koin.core.qualifier.Qualifier r10, kotlin.jvm.functions.Function0<? extends org.koin.core.parameter.ParametersHolder> r11) {
        /*
            r8 = this;
            java.lang.String r0 = "clazz"
            kotlin.jvm.internal.Intrinsics.f(r9, r0)
            org.koin.core.Koin r0 = r8.f52796d
            org.koin.core.logger.Logger r0 = r0.d()
            org.koin.core.logger.Level r1 = org.koin.core.logger.Level.DEBUG
            boolean r0 = r0.b(r1)
            if (r0 == 0) goto L98
            r0 = 39
            if (r10 == 0) goto L2d
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = " with qualifier '"
            r2.append(r3)
            r2.append(r10)
            r2.append(r0)
            java.lang.String r2 = r2.toString()
            if (r2 != 0) goto L2f
        L2d:
            java.lang.String r2 = ""
        L2f:
            org.koin.core.Koin r3 = r8.f52796d
            org.koin.core.logger.Logger r3 = r3.d()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "|- '"
            r4.append(r5)
            java.lang.String r6 = org.koin.ext.KClassExtKt.a(r9)
            r4.append(r6)
            r4.append(r0)
            r4.append(r2)
            java.lang.String r0 = " ..."
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            r3.a(r1, r0)
            org.koin.mp.KoinPlatformTimeTools r0 = org.koin.mp.KoinPlatformTimeTools.f52810a
            long r2 = r0.a()
            java.lang.Object r10 = r8.o(r10, r9, r11)
            long r6 = r0.a()
            long r6 = r6 - r2
            double r2 = (double) r6
            r6 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r2 = r2 / r6
            org.koin.core.Koin r11 = r8.f52796d
            org.koin.core.logger.Logger r11 = r11.d()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r5)
            java.lang.String r9 = org.koin.ext.KClassExtKt.a(r9)
            r0.append(r9)
            java.lang.String r9 = "' in "
            r0.append(r9)
            r0.append(r2)
            java.lang.String r9 = " ms"
            r0.append(r9)
            java.lang.String r9 = r0.toString()
            r11.a(r1, r9)
            goto L9c
        L98:
            java.lang.Object r10 = r8.o(r10, r9, r11)
        L9c:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: org.koin.core.scope.Scope.f(kotlin.reflect.KClass, org.koin.core.qualifier.Qualifier, kotlin.jvm.functions.Function0):java.lang.Object");
    }

    public final boolean g() {
        return this.f52801i;
    }

    public final String h() {
        return this.f52794b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.f52793a.hashCode() * 31) + this.f52794b.hashCode()) * 31;
        boolean z7 = this.f52795c;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        return ((hashCode + i8) * 31) + this.f52796d.hashCode();
    }

    public final <T> T i(KClass<?> clazz, Qualifier qualifier, Function0<? extends ParametersHolder> function0) {
        Intrinsics.f(clazz, "clazz");
        try {
            return (T) f(clazz, qualifier, function0);
        } catch (ClosedScopeException unused) {
            Logger d8 = this.f52796d.d();
            String str = "* Scope closed - no instance found for " + KClassExtKt.a(clazz) + " on scope " + this;
            Level level = Level.ERROR;
            if (!d8.b(level)) {
                return null;
            }
            d8.a(level, str);
            return null;
        } catch (NoBeanDefFoundException unused2) {
            Logger d9 = this.f52796d.d();
            String str2 = "* No instance found for " + KClassExtKt.a(clazz) + " on scope " + this;
            Level level2 = Level.ERROR;
            if (!d9.b(level2)) {
                return null;
            }
            d9.a(level2, str2);
            return null;
        }
    }

    public final Qualifier j() {
        return this.f52793a;
    }

    public final Koin k() {
        return this.f52796d;
    }

    public final ArrayDeque<ParametersHolder> l() {
        return this.f52800h;
    }

    public final boolean m() {
        return !g();
    }

    public final void n(Scope... scopes) {
        Intrinsics.f(scopes, "scopes");
        if (!this.f52795c) {
            CollectionsKt__MutableCollectionsKt.C(this.f52797e, scopes);
            return;
        }
        throw new IllegalStateException("Can't add scope link to a root scope".toString());
    }

    public final void q(Object obj) {
        this.f52798f = obj;
    }

    public String toString() {
        return "['" + this.f52794b + "']";
    }

    public Scope(Qualifier scopeQualifier, String id, boolean z7, Koin _koin) {
        Intrinsics.f(scopeQualifier, "scopeQualifier");
        Intrinsics.f(id, "id");
        Intrinsics.f(_koin, "_koin");
        this.f52793a = scopeQualifier;
        this.f52794b = id;
        this.f52795c = z7;
        this.f52796d = _koin;
        this.f52797e = new ArrayList<>();
        this.f52799g = new ArrayList<>();
        this.f52800h = new ArrayDeque<>();
    }
}
