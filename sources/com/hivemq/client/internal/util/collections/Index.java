package com.hivemq.client.internal.util.collections;

import com.hivemq.client.internal.util.Pow2Util;
import j$.util.function.Consumer;
import j$.util.function.Function;
import java.util.NoSuchElementException;

/* loaded from: classes3.dex */
public class Index<E, K> {

    /* renamed from: a  reason: collision with root package name */
    private final Spec<E, K> f18708a;

    /* renamed from: b  reason: collision with root package name */
    private Object[] f18709b;

    /* renamed from: c  reason: collision with root package name */
    private int f18710c;

    /* renamed from: d  reason: collision with root package name */
    private int f18711d;

    /* renamed from: e  reason: collision with root package name */
    private int f18712e;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class Node {

        /* renamed from: a  reason: collision with root package name */
        final int f18713a;

        /* renamed from: b  reason: collision with root package name */
        Object f18714b;

        /* renamed from: c  reason: collision with root package name */
        Object f18715c;

        Node(int i8, Object obj, Object obj2) {
            this.f18713a = i8;
            this.f18714b = obj;
            this.f18715c = obj2;
        }
    }

    /* loaded from: classes3.dex */
    public static class Spec<E, K> {

        /* renamed from: a  reason: collision with root package name */
        final Function<? super E, ? extends K> f18716a;

        /* renamed from: b  reason: collision with root package name */
        final int f18717b;

        /* renamed from: c  reason: collision with root package name */
        final float f18718c;

        public Spec(Function<? super E, ? extends K> function) {
            this(function, 16, 0.25f);
        }

        public Spec(Function<? super E, ? extends K> function, int i8) {
            this(function, i8, 0.25f);
        }

        public Spec(Function<? super E, ? extends K> function, int i8, float f8) {
            this.f18716a = function;
            this.f18717b = i8;
            this.f18718c = f8;
        }
    }

    public Index(Spec<E, K> spec) {
        this.f18708a = spec;
        int a8 = 1 << Pow2Util.a(spec.f18717b);
        this.f18709b = new Object[a8];
        d(a8);
    }

    private void a() {
        this.f18710c++;
    }

    private void b() {
        Object obj;
        int i8 = this.f18711d + 1;
        this.f18711d = i8;
        if (i8 > this.f18712e) {
            Object[] objArr = this.f18709b;
            if (objArr.length < 1073741824) {
                int length = objArr.length;
                int i9 = length << 1;
                int i10 = i9 - 1;
                Object[] objArr2 = new Object[i9];
                int i11 = 0;
                for (int i12 = 0; i12 < length; i12++) {
                    Object obj2 = objArr[i12];
                    if (obj2 != null) {
                        if (obj2.getClass() == Node.class) {
                            Node node = (Node) obj2;
                            int i13 = i12 + length;
                            Node node2 = null;
                            Node node3 = null;
                            Node node4 = null;
                            Node node5 = null;
                            while (true) {
                                if ((node.f18713a & i10) == i12) {
                                    if (node3 == null) {
                                        objArr2[i12] = node;
                                    } else {
                                        node3.f18715c = node;
                                        node4 = node3;
                                    }
                                    node3 = node;
                                } else {
                                    if (node2 == null) {
                                        objArr2[i13] = node;
                                    } else {
                                        node2.f18715c = node;
                                        node5 = node2;
                                    }
                                    node2 = node;
                                }
                                i11++;
                                obj = node.f18715c;
                                if (obj.getClass() != Node.class) {
                                    break;
                                }
                                node = (Node) obj;
                            }
                            E e8 = e(obj);
                            if ((this.f18708a.f18716a.apply(e8).hashCode() & i10) == i12) {
                                if (node3 == null) {
                                    objArr2[i12] = e8;
                                } else {
                                    node3.f18715c = e8;
                                }
                                if (node2 != null) {
                                    if (node5 == null) {
                                        objArr2[i13] = node2.f18714b;
                                    } else {
                                        node5.f18715c = node2.f18714b;
                                    }
                                    i11--;
                                }
                            } else {
                                if (node2 == null) {
                                    objArr2[i13] = e8;
                                } else {
                                    node2.f18715c = e8;
                                }
                                if (node3 != null) {
                                    if (node4 == null) {
                                        objArr2[i12] = node3.f18714b;
                                    } else {
                                        node4.f18715c = node3.f18714b;
                                    }
                                    i11--;
                                }
                            }
                        } else {
                            objArr2[this.f18708a.f18716a.apply(e(obj2)).hashCode() & i10] = obj2;
                        }
                    }
                }
                this.f18709b = objArr2;
                this.f18711d = i11;
                d(i9);
            }
        }
    }

    private void d(int i8) {
        this.f18712e = (int) (i8 * this.f18708a.f18718c);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private E e(Object obj) {
        return obj;
    }

    private E i(E e8, boolean z7) {
        Object[] objArr = this.f18709b;
        K apply = this.f18708a.f18716a.apply(e8);
        int hashCode = apply.hashCode();
        int length = (objArr.length - 1) & hashCode;
        Object obj = objArr[length];
        if (obj == null) {
            objArr[length] = e8;
            a();
            return null;
        } else if (obj.getClass() != Node.class) {
            E e9 = e(obj);
            K apply2 = this.f18708a.f18716a.apply(e9);
            if (apply2.equals(apply)) {
                if (z7) {
                    objArr[length] = e8;
                }
                return e9;
            }
            objArr[length] = new Node(apply2.hashCode(), obj, e8);
            a();
            b();
            return null;
        } else {
            while (true) {
                Node node = (Node) obj;
                if (node.f18713a == hashCode && this.f18708a.f18716a.apply(e(node.f18714b)).equals(apply)) {
                    Object obj2 = node.f18714b;
                    if (z7) {
                        node.f18714b = e8;
                    }
                    return e(obj2);
                }
                Object obj3 = node.f18715c;
                if (obj3.getClass() == Node.class) {
                    obj = obj3;
                } else {
                    E e10 = e(obj3);
                    K apply3 = this.f18708a.f18716a.apply(e10);
                    if (apply3.equals(apply)) {
                        if (z7) {
                            node.f18715c = e8;
                        }
                        return e10;
                    }
                    node.f18715c = new Node(apply3.hashCode(), obj3, e8);
                    a();
                    b();
                    return null;
                }
            }
        }
    }

    private void k() {
        Node node;
        Object obj;
        int i8 = this.f18710c - 1;
        this.f18710c = i8;
        if (i8 < this.f18712e) {
            Object[] objArr = this.f18709b;
            if (objArr.length > this.f18708a.f18717b) {
                int length = objArr.length;
                int i9 = length >> 1;
                Object[] objArr2 = new Object[i9];
                int i10 = this.f18711d;
                System.arraycopy(objArr, 0, objArr2, 0, i9);
                for (int i11 = i9; i11 < length; i11++) {
                    Object obj2 = objArr[i11];
                    if (obj2 != null) {
                        int i12 = i11 - i9;
                        Object obj3 = objArr2[i12];
                        if (obj3 == null) {
                            objArr2[i12] = obj2;
                        } else {
                            if (obj3.getClass() == Node.class) {
                                while (true) {
                                    node = (Node) obj3;
                                    obj = node.f18715c;
                                    if (obj.getClass() != Node.class) {
                                        break;
                                    }
                                    obj3 = obj;
                                }
                                node.f18715c = new Node(this.f18708a.f18716a.apply(e(obj)).hashCode(), obj, obj2);
                            } else {
                                objArr2[i12] = new Node(this.f18708a.f18716a.apply(e(obj3)).hashCode(), obj3, obj2);
                            }
                            i10++;
                        }
                    }
                }
                this.f18709b = objArr2;
                this.f18711d = i10;
                d(i9);
            }
        }
    }

    private void l() {
        this.f18711d--;
    }

    public E c() {
        Object[] objArr;
        for (Object obj : this.f18709b) {
            if (obj != null) {
                if (obj.getClass() == Node.class) {
                    return e(((Node) obj).f18714b);
                }
                return e(obj);
            }
        }
        throw new NoSuchElementException();
    }

    public void f(Consumer<? super E> consumer) {
        Object[] objArr;
        for (Object obj : this.f18709b) {
            if (obj != null) {
                if (obj.getClass() == Node.class) {
                    while (true) {
                        Node node = (Node) obj;
                        consumer.accept(e(node.f18714b));
                        obj = node.f18715c;
                        if (obj.getClass() != Node.class) {
                            break;
                        }
                    }
                    consumer.accept(e(obj));
                } else {
                    consumer.accept(e(obj));
                }
            }
        }
    }

    public E g(K k8) {
        Object[] objArr = this.f18709b;
        int hashCode = k8.hashCode();
        Object obj = objArr[(objArr.length - 1) & hashCode];
        if (obj == null) {
            return null;
        }
        if (obj.getClass() != Node.class) {
            E e8 = e(obj);
            if (!this.f18708a.f18716a.apply(e8).equals(k8)) {
                return null;
            }
            return e8;
        }
        while (true) {
            Node node = (Node) obj;
            if (node.f18713a == hashCode && this.f18708a.f18716a.apply(e(node.f18714b)).equals(k8)) {
                return e(node.f18714b);
            }
            obj = node.f18715c;
            if (obj.getClass() != Node.class) {
                E e9 = e(obj);
                if (!this.f18708a.f18716a.apply(e9).equals(k8)) {
                    return null;
                }
                return e9;
            }
        }
    }

    public E h(E e8) {
        return i(e8, true);
    }

    public E j(K k8) {
        Object[] objArr = this.f18709b;
        int hashCode = k8.hashCode();
        int length = (objArr.length - 1) & hashCode;
        Object obj = objArr[length];
        if (obj == null) {
            return null;
        }
        if (obj.getClass() == Node.class) {
            Node node = (Node) obj;
            if (node.f18713a == hashCode && this.f18708a.f18716a.apply(e(node.f18714b)).equals(k8)) {
                objArr[length] = node.f18715c;
                l();
                k();
                return e(node.f18714b);
            }
            Object obj2 = node.f18715c;
            Class<?> cls = obj2.getClass();
            Object obj3 = obj2;
            if (cls != Node.class) {
                E e8 = e(obj2);
                if (!this.f18708a.f18716a.apply(e8).equals(k8)) {
                    return null;
                }
                objArr[length] = node.f18714b;
                l();
                k();
                return e8;
            }
            while (true) {
                Node node2 = (Node) obj3;
                if (node2.f18713a == hashCode && this.f18708a.f18716a.apply(e(node2.f18714b)).equals(k8)) {
                    node.f18715c = node2.f18715c;
                    l();
                    k();
                    return e(node2.f18714b);
                }
                Object obj4 = node2.f18715c;
                if (obj4.getClass() != Node.class) {
                    E e9 = e(obj4);
                    if (!this.f18708a.f18716a.apply(e9).equals(k8)) {
                        return null;
                    }
                    node.f18715c = node2.f18714b;
                    l();
                    k();
                    return e9;
                }
                node = node2;
                obj3 = obj4;
            }
        } else {
            E e10 = e(obj);
            if (!this.f18708a.f18716a.apply(e10).equals(k8)) {
                return null;
            }
            objArr[length] = null;
            k();
            return e10;
        }
    }

    public int m() {
        return this.f18710c;
    }
}
