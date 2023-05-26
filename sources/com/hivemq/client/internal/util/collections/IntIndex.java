package com.hivemq.client.internal.util.collections;

import com.hivemq.client.internal.util.Pow2Util;
import j$.util.function.ToIntFunction;
import java.util.Arrays;

/* loaded from: classes3.dex */
public class IntIndex<E> {

    /* renamed from: a  reason: collision with root package name */
    private final Spec<E> f18719a;

    /* renamed from: b  reason: collision with root package name */
    private Object[] f18720b;

    /* renamed from: c  reason: collision with root package name */
    private int f18721c;

    /* renamed from: d  reason: collision with root package name */
    private int f18722d;

    /* renamed from: e  reason: collision with root package name */
    private int f18723e;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class Node {

        /* renamed from: a  reason: collision with root package name */
        final int f18724a;

        /* renamed from: b  reason: collision with root package name */
        Object f18725b;

        /* renamed from: c  reason: collision with root package name */
        Object f18726c;

        Node(int i8, Object obj, Object obj2) {
            this.f18724a = i8;
            this.f18725b = obj;
            this.f18726c = obj2;
        }
    }

    /* loaded from: classes3.dex */
    public static class Spec<E> {

        /* renamed from: a  reason: collision with root package name */
        final ToIntFunction<? super E> f18727a;

        /* renamed from: b  reason: collision with root package name */
        final int f18728b;

        /* renamed from: c  reason: collision with root package name */
        final float f18729c;

        public Spec(ToIntFunction<? super E> toIntFunction) {
            this(toIntFunction, 16, 0.25f);
        }

        public Spec(ToIntFunction<? super E> toIntFunction, int i8) {
            this(toIntFunction, i8, 0.25f);
        }

        public Spec(ToIntFunction<? super E> toIntFunction, int i8, float f8) {
            this.f18727a = toIntFunction;
            this.f18728b = i8;
            this.f18729c = f8;
        }
    }

    public IntIndex(Spec<E> spec) {
        this.f18719a = spec;
        int a8 = 1 << Pow2Util.a(spec.f18728b);
        this.f18720b = new Object[a8];
        c(a8);
    }

    private void a() {
        this.f18721c++;
    }

    private void b() {
        Object obj;
        int i8 = this.f18722d + 1;
        this.f18722d = i8;
        if (i8 > this.f18723e) {
            Object[] objArr = this.f18720b;
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
                                if ((node.f18724a & i10) == i12) {
                                    if (node3 == null) {
                                        objArr2[i12] = node;
                                    } else {
                                        node3.f18726c = node;
                                        node4 = node3;
                                    }
                                    node3 = node;
                                } else {
                                    if (node2 == null) {
                                        objArr2[i13] = node;
                                    } else {
                                        node2.f18726c = node;
                                        node5 = node2;
                                    }
                                    node2 = node;
                                }
                                i11++;
                                obj = node.f18726c;
                                if (obj.getClass() != Node.class) {
                                    break;
                                }
                                node = (Node) obj;
                            }
                            E d8 = d(obj);
                            if ((this.f18719a.f18727a.applyAsInt(d8) & i10) == i12) {
                                if (node3 == null) {
                                    objArr2[i12] = d8;
                                } else {
                                    node3.f18726c = d8;
                                }
                                if (node2 != null) {
                                    if (node5 == null) {
                                        objArr2[i13] = node2.f18725b;
                                    } else {
                                        node5.f18726c = node2.f18725b;
                                    }
                                    i11--;
                                }
                            } else {
                                if (node2 == null) {
                                    objArr2[i13] = d8;
                                } else {
                                    node2.f18726c = d8;
                                }
                                if (node3 != null) {
                                    if (node4 == null) {
                                        objArr2[i12] = node3.f18725b;
                                    } else {
                                        node4.f18726c = node3.f18725b;
                                    }
                                    i11--;
                                }
                            }
                        } else {
                            objArr2[this.f18719a.f18727a.applyAsInt(d(obj2)) & i10] = obj2;
                        }
                    }
                }
                this.f18720b = objArr2;
                this.f18722d = i11;
                c(i9);
            }
        }
    }

    private void c(int i8) {
        this.f18723e = (int) (i8 * this.f18719a.f18729c);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private E d(Object obj) {
        return obj;
    }

    private E h(E e8, boolean z7) {
        Object[] objArr = this.f18720b;
        int applyAsInt = this.f18719a.f18727a.applyAsInt(e8);
        int length = (objArr.length - 1) & applyAsInt;
        Object obj = objArr[length];
        if (obj == null) {
            objArr[length] = e8;
            a();
            return null;
        } else if (obj.getClass() != Node.class) {
            E d8 = d(obj);
            int applyAsInt2 = this.f18719a.f18727a.applyAsInt(d8);
            if (applyAsInt2 == applyAsInt) {
                if (z7) {
                    objArr[length] = e8;
                }
                return d8;
            }
            objArr[length] = new Node(applyAsInt2, obj, e8);
            a();
            b();
            return null;
        } else {
            while (true) {
                Node node = (Node) obj;
                if (node.f18724a == applyAsInt) {
                    Object obj2 = node.f18725b;
                    if (z7) {
                        node.f18725b = e8;
                    }
                    return d(obj2);
                }
                Object obj3 = node.f18726c;
                if (obj3.getClass() == Node.class) {
                    obj = obj3;
                } else {
                    E d9 = d(obj3);
                    int applyAsInt3 = this.f18719a.f18727a.applyAsInt(d9);
                    if (applyAsInt3 == applyAsInt) {
                        if (z7) {
                            node.f18726c = e8;
                        }
                        return d9;
                    }
                    node.f18726c = new Node(applyAsInt3, obj3, e8);
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
        int i8 = this.f18721c - 1;
        this.f18721c = i8;
        if (i8 < this.f18723e) {
            Object[] objArr = this.f18720b;
            if (objArr.length > this.f18719a.f18728b) {
                int length = objArr.length;
                int i9 = length >> 1;
                Object[] objArr2 = new Object[i9];
                int i10 = this.f18722d;
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
                                    obj = node.f18726c;
                                    if (obj.getClass() != Node.class) {
                                        break;
                                    }
                                    obj3 = obj;
                                }
                                node.f18726c = new Node(this.f18719a.f18727a.applyAsInt(d(obj)), obj, obj2);
                            } else {
                                objArr2[i12] = new Node(this.f18719a.f18727a.applyAsInt(d(obj3)), obj3, obj2);
                            }
                            i10++;
                        }
                    }
                }
                this.f18720b = objArr2;
                this.f18722d = i10;
                c(i9);
            }
        }
    }

    private void l() {
        this.f18722d--;
    }

    public void e() {
        if (this.f18721c > 0) {
            Object[] objArr = this.f18720b;
            int length = objArr.length;
            int i8 = this.f18719a.f18728b;
            if (length == i8) {
                Arrays.fill(objArr, (Object) null);
            } else {
                this.f18720b = new Object[i8];
            }
            this.f18721c = 0;
            this.f18722d = 0;
            c(this.f18719a.f18728b);
        }
    }

    public E f(int i8) {
        Object[] objArr = this.f18720b;
        Object obj = objArr[(objArr.length - 1) & i8];
        if (obj == null) {
            return null;
        }
        if (obj.getClass() != Node.class) {
            E d8 = d(obj);
            if (this.f18719a.f18727a.applyAsInt(d8) != i8) {
                return null;
            }
            return d8;
        }
        while (true) {
            Node node = (Node) obj;
            if (node.f18724a == i8) {
                return d(node.f18725b);
            }
            obj = node.f18726c;
            if (obj.getClass() != Node.class) {
                E d9 = d(obj);
                if (this.f18719a.f18727a.applyAsInt(d9) != i8) {
                    return null;
                }
                return d9;
            }
        }
    }

    public E g(E e8) {
        return h(e8, true);
    }

    public E i(E e8) {
        return h(e8, false);
    }

    public E j(int i8) {
        Object[] objArr = this.f18720b;
        int length = (objArr.length - 1) & i8;
        Object obj = objArr[length];
        if (obj == null) {
            return null;
        }
        if (obj.getClass() == Node.class) {
            Node node = (Node) obj;
            if (node.f18724a == i8) {
                objArr[length] = node.f18726c;
                l();
                k();
                return d(node.f18725b);
            }
            Object obj2 = node.f18726c;
            Class<?> cls = obj2.getClass();
            Object obj3 = obj2;
            if (cls != Node.class) {
                E d8 = d(obj2);
                if (this.f18719a.f18727a.applyAsInt(d8) != i8) {
                    return null;
                }
                objArr[length] = node.f18725b;
                l();
                k();
                return d8;
            }
            while (true) {
                Node node2 = (Node) obj3;
                if (node2.f18724a == i8) {
                    node.f18726c = node2.f18726c;
                    l();
                    k();
                    return d(node2.f18725b);
                }
                Object obj4 = node2.f18726c;
                if (obj4.getClass() != Node.class) {
                    E d9 = d(obj4);
                    if (this.f18719a.f18727a.applyAsInt(d9) != i8) {
                        return null;
                    }
                    node.f18726c = node2.f18725b;
                    l();
                    k();
                    return d9;
                }
                node = node2;
                obj3 = obj4;
            }
        } else {
            E d10 = d(obj);
            if (this.f18719a.f18727a.applyAsInt(d10) != i8) {
                return null;
            }
            objArr[length] = null;
            k();
            return d10;
        }
    }

    public int m() {
        return this.f18721c;
    }
}
