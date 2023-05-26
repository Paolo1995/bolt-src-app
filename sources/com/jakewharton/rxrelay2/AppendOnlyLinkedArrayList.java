package com.jakewharton.rxrelay2;

import io.reactivex.functions.Predicate;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class AppendOnlyLinkedArrayList<T> {

    /* renamed from: a  reason: collision with root package name */
    private final int f18936a;

    /* renamed from: b  reason: collision with root package name */
    private final Object[] f18937b;

    /* renamed from: c  reason: collision with root package name */
    private Object[] f18938c;

    /* renamed from: d  reason: collision with root package name */
    private int f18939d;

    /* loaded from: classes3.dex */
    public interface NonThrowingPredicate<T> extends Predicate<T> {
        @Override // io.reactivex.functions.Predicate
        boolean test(T t7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppendOnlyLinkedArrayList(int i8) {
        this.f18936a = i8;
        Object[] objArr = new Object[i8 + 1];
        this.f18937b = objArr;
        this.f18938c = objArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Relay<? super T> relay) {
        int i8 = this.f18936a;
        for (Object[] objArr = this.f18937b; objArr != null; objArr = objArr[i8]) {
            for (int i9 = 0; i9 < i8; i9++) {
                Object obj = objArr[i9];
                if (obj == null) {
                    break;
                }
                relay.accept(obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(T t7) {
        int i8 = this.f18936a;
        int i9 = this.f18939d;
        if (i9 == i8) {
            Object[] objArr = new Object[i8 + 1];
            this.f18938c[i8] = objArr;
            this.f18938c = objArr;
            i9 = 0;
        }
        this.f18938c[i9] = t7;
        this.f18939d = i9 + 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(NonThrowingPredicate<? super T> nonThrowingPredicate) {
        int i8 = this.f18936a;
        for (Object[] objArr = this.f18937b; objArr != null; objArr = objArr[i8]) {
            for (int i9 = 0; i9 < i8; i9++) {
                Object obj = objArr[i9];
                if (obj != null && !nonThrowingPredicate.test(obj)) {
                }
            }
        }
    }
}
