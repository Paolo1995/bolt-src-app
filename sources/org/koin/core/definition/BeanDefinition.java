package org.koin.core.definition;

import java.util.List;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: BeanDefinition.kt */
/* loaded from: classes5.dex */
public final class BeanDefinition<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Qualifier f52738a;

    /* renamed from: b  reason: collision with root package name */
    private final KClass<?> f52739b;

    /* renamed from: c  reason: collision with root package name */
    private Qualifier f52740c;

    /* renamed from: d  reason: collision with root package name */
    private final Function2<Scope, ParametersHolder, T> f52741d;

    /* renamed from: e  reason: collision with root package name */
    private final Kind f52742e;

    /* renamed from: f  reason: collision with root package name */
    private List<? extends KClass<?>> f52743f;

    /* renamed from: g  reason: collision with root package name */
    private Callbacks<T> f52744g;

    /* JADX WARN: Multi-variable type inference failed */
    public BeanDefinition(Qualifier scopeQualifier, KClass<?> primaryType, Qualifier qualifier, Function2<? super Scope, ? super ParametersHolder, ? extends T> definition, Kind kind, List<? extends KClass<?>> secondaryTypes) {
        Intrinsics.f(scopeQualifier, "scopeQualifier");
        Intrinsics.f(primaryType, "primaryType");
        Intrinsics.f(definition, "definition");
        Intrinsics.f(kind, "kind");
        Intrinsics.f(secondaryTypes, "secondaryTypes");
        this.f52738a = scopeQualifier;
        this.f52739b = primaryType;
        this.f52740c = qualifier;
        this.f52741d = definition;
        this.f52742e = kind;
        this.f52743f = secondaryTypes;
        this.f52744g = new Callbacks<>(null, 1, null);
    }

    public final Callbacks<T> a() {
        return this.f52744g;
    }

    public final Function2<Scope, ParametersHolder, T> b() {
        return this.f52741d;
    }

    public final KClass<?> c() {
        return this.f52739b;
    }

    public final Qualifier d() {
        return this.f52740c;
    }

    public final Qualifier e() {
        return this.f52738a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        Intrinsics.d(obj, "null cannot be cast to non-null type org.koin.core.definition.BeanDefinition<*>");
        BeanDefinition beanDefinition = (BeanDefinition) obj;
        if (Intrinsics.a(this.f52739b, beanDefinition.f52739b) && Intrinsics.a(this.f52740c, beanDefinition.f52740c) && Intrinsics.a(this.f52738a, beanDefinition.f52738a)) {
            return true;
        }
        return false;
    }

    public final List<KClass<?>> f() {
        return this.f52743f;
    }

    public final void g(List<? extends KClass<?>> list) {
        Intrinsics.f(list, "<set-?>");
        this.f52743f = list;
    }

    public int hashCode() {
        int i8;
        Qualifier qualifier = this.f52740c;
        if (qualifier != null) {
            i8 = qualifier.hashCode();
        } else {
            i8 = 0;
        }
        return (((i8 * 31) + this.f52739b.hashCode()) * 31) + this.f52738a.hashCode();
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0039, code lost:
        if (r2 == null) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String toString() {
        /*
            r15 = this;
            org.koin.core.definition.Kind r0 = r15.f52742e
            java.lang.String r0 = r0.toString()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r2 = 39
            r1.append(r2)
            kotlin.reflect.KClass<?> r3 = r15.f52739b
            java.lang.String r3 = org.koin.ext.KClassExtKt.a(r3)
            r1.append(r3)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            org.koin.core.qualifier.Qualifier r2 = r15.f52740c
            java.lang.String r3 = ""
            if (r2 == 0) goto L3b
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = ",qualifier:"
            r2.append(r4)
            org.koin.core.qualifier.Qualifier r4 = r15.f52740c
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            if (r2 != 0) goto L3c
        L3b:
            r2 = r3
        L3c:
            org.koin.core.qualifier.Qualifier r4 = r15.f52738a
            org.koin.core.registry.ScopeRegistry$Companion r5 = org.koin.core.registry.ScopeRegistry.f52787e
            org.koin.core.qualifier.StringQualifier r5 = r5.a()
            boolean r4 = kotlin.jvm.internal.Intrinsics.a(r4, r5)
            if (r4 == 0) goto L4c
            r4 = r3
            goto L5f
        L4c:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = ",scope:"
            r4.append(r5)
            org.koin.core.qualifier.Qualifier r5 = r15.f52738a
            r4.append(r5)
            java.lang.String r4 = r4.toString()
        L5f:
            java.util.List<? extends kotlin.reflect.KClass<?>> r5 = r15.f52743f
            boolean r5 = r5.isEmpty()
            r5 = r5 ^ 1
            if (r5 == 0) goto L8b
            java.util.List<? extends kotlin.reflect.KClass<?>> r6 = r15.f52743f
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            org.koin.core.definition.BeanDefinition$toString$defOtherTypes$typesAsString$1 r12 = new kotlin.jvm.functions.Function1<kotlin.reflect.KClass<?>, java.lang.CharSequence>() { // from class: org.koin.core.definition.BeanDefinition$toString$defOtherTypes$typesAsString$1
                static {
                    /*
                        org.koin.core.definition.BeanDefinition$toString$defOtherTypes$typesAsString$1 r0 = new org.koin.core.definition.BeanDefinition$toString$defOtherTypes$typesAsString$1
                        r0.<init>()
                        
                        // error: 0x0005: SPUT  (r0 I:org.koin.core.definition.BeanDefinition$toString$defOtherTypes$typesAsString$1) org.koin.core.definition.BeanDefinition$toString$defOtherTypes$typesAsString$1.f org.koin.core.definition.BeanDefinition$toString$defOtherTypes$typesAsString$1
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.koin.core.definition.BeanDefinition$toString$defOtherTypes$typesAsString$1.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 1
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.koin.core.definition.BeanDefinition$toString$defOtherTypes$typesAsString$1.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function1
                /* renamed from: b */
                public final java.lang.CharSequence invoke(kotlin.reflect.KClass<?> r2) {
                    /*
                        r1 = this;
                        java.lang.String r0 = "it"
                        kotlin.jvm.internal.Intrinsics.f(r2, r0)
                        java.lang.String r2 = org.koin.ext.KClassExtKt.a(r2)
                        return r2
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.koin.core.definition.BeanDefinition$toString$defOtherTypes$typesAsString$1.invoke(kotlin.reflect.KClass):java.lang.CharSequence");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ java.lang.CharSequence invoke(kotlin.reflect.KClass<?> r1) {
                    /*
                        r0 = this;
                        kotlin.reflect.KClass r1 = (kotlin.reflect.KClass) r1
                        java.lang.CharSequence r1 = r0.invoke(r1)
                        return r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.koin.core.definition.BeanDefinition$toString$defOtherTypes$typesAsString$1.invoke(java.lang.Object):java.lang.Object");
                }
            }
            r13 = 30
            r14 = 0
            java.lang.String r7 = ","
            java.lang.String r3 = kotlin.collections.CollectionsKt.f0(r6, r7, r8, r9, r10, r11, r12, r13, r14)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = ",binds:"
            r5.append(r6)
            r5.append(r3)
            java.lang.String r3 = r5.toString()
        L8b:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r6 = 91
            r5.append(r6)
            r5.append(r0)
            r0 = 58
            r5.append(r0)
            r5.append(r1)
            r5.append(r2)
            r5.append(r4)
            r5.append(r3)
            r0 = 93
            r5.append(r0)
            java.lang.String r0 = r5.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.koin.core.definition.BeanDefinition.toString():java.lang.String");
    }
}
