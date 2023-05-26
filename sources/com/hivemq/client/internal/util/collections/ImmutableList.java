package com.hivemq.client.internal.util.collections;

import com.hivemq.client.internal.util.Checks;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* loaded from: classes3.dex */
public interface ImmutableList<E> extends List<E>, RandomAccess {

    /* loaded from: classes3.dex */
    public interface ImmutableListIterator<E> extends ListIterator<E> {
    }

    ImmutableList<E> P0();

    @Override // java.util.List, java.util.Collection, j$.util.List
    boolean contains(Object obj);

    @Override // java.util.List, j$.util.List
    E get(int i8);

    @Override // java.util.List, java.util.Collection, j$.util.List
    boolean isEmpty();

    @Override // java.util.List, java.util.Collection, java.lang.Iterable, j$.util.List
    ImmutableListIterator<E> iterator();

    @Override // java.util.List, j$.util.List
    ImmutableListIterator<E> listIterator();

    @Override // java.util.List, j$.util.List
    ImmutableListIterator<E> listIterator(int i8);

    /* loaded from: classes3.dex */
    public static class Builder<E> {

        /* renamed from: a  reason: collision with root package name */
        private E f18705a;

        /* renamed from: b  reason: collision with root package name */
        private Object[] f18706b;

        /* renamed from: c  reason: collision with root package name */
        private int f18707c;

        private Builder() {
        }

        private Object[] c(int i8) {
            Object[] objArr = this.f18706b;
            if (objArr == null) {
                this.f18706b = new Object[Math.max(4, i8)];
            } else if (i8 > objArr.length) {
                this.f18706b = Arrays.copyOf(objArr, Math.max(f(objArr.length), i8), Object[].class);
            }
            E e8 = this.f18705a;
            if (e8 != null) {
                this.f18706b[0] = e8;
                this.f18705a = null;
            }
            return this.f18706b;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static <E> E d(Collection<E> collection) {
            if (collection instanceof List) {
                return (E) ((List) collection).get(0);
            }
            return collection.iterator().next();
        }

        private int f(int i8) {
            return i8 + (i8 >> 1);
        }

        public Builder<E> a(E e8) {
            Checks.j(e8, "Immutable list element");
            int i8 = this.f18707c;
            if (i8 == 0) {
                this.f18705a = e8;
                this.f18707c = 1;
            } else {
                int i9 = i8 + 1;
                c(i9)[this.f18707c] = e8;
                this.f18707c = i9;
            }
            return this;
        }

        public ImmutableList<E> b() {
            int i8 = this.f18707c;
            if (i8 != 0) {
                if (i8 != 1) {
                    if (this.f18706b.length == i8) {
                        return new ImmutableArray(this.f18706b);
                    }
                    return new ImmutableArray(Arrays.copyOfRange(this.f18706b, 0, this.f18707c, Object[].class));
                }
                return new ImmutableElement(this.f18705a);
            }
            return ImmutableEmptyList.b();
        }

        public int e() {
            return this.f18707c;
        }

        private Builder(int i8) {
            if (i8 > 1) {
                this.f18706b = new Object[i8];
            }
        }
    }
}
