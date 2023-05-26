package com.google.protobuf;

import com.google.protobuf.Internal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public abstract class ListFieldSchema {

    /* renamed from: a  reason: collision with root package name */
    private static final ListFieldSchema f17493a = new ListFieldSchemaFull();

    /* renamed from: b  reason: collision with root package name */
    private static final ListFieldSchema f17494b = new ListFieldSchemaLite();

    /* loaded from: classes3.dex */
    private static final class ListFieldSchemaFull extends ListFieldSchema {

        /* renamed from: c  reason: collision with root package name */
        private static final Class<?> f17495c = Collections.unmodifiableList(Collections.emptyList()).getClass();

        private ListFieldSchemaFull() {
            super();
        }

        static <E> List<E> f(Object obj, long j8) {
            return (List) UnsafeUtil.G(obj, j8);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private static <L> List<L> g(Object obj, long j8, int i8) {
            LazyStringArrayList lazyStringArrayList;
            List<L> arrayList;
            List<L> f8 = f(obj, j8);
            if (f8.isEmpty()) {
                if (f8 instanceof LazyStringList) {
                    arrayList = new LazyStringArrayList(i8);
                } else if ((f8 instanceof PrimitiveNonBoxingCollection) && (f8 instanceof Internal.ProtobufList)) {
                    arrayList = ((Internal.ProtobufList) f8).a(i8);
                } else {
                    arrayList = new ArrayList<>(i8);
                }
                UnsafeUtil.V(obj, j8, arrayList);
                return arrayList;
            }
            if (f17495c.isAssignableFrom(f8.getClass())) {
                ArrayList arrayList2 = new ArrayList(f8.size() + i8);
                arrayList2.addAll(f8);
                UnsafeUtil.V(obj, j8, arrayList2);
                lazyStringArrayList = arrayList2;
            } else if (f8 instanceof UnmodifiableLazyStringList) {
                LazyStringArrayList lazyStringArrayList2 = new LazyStringArrayList(f8.size() + i8);
                lazyStringArrayList2.addAll((UnmodifiableLazyStringList) f8);
                UnsafeUtil.V(obj, j8, lazyStringArrayList2);
                lazyStringArrayList = lazyStringArrayList2;
            } else if ((f8 instanceof PrimitiveNonBoxingCollection) && (f8 instanceof Internal.ProtobufList)) {
                Internal.ProtobufList protobufList = (Internal.ProtobufList) f8;
                if (!protobufList.h()) {
                    Internal.ProtobufList a8 = protobufList.a(f8.size() + i8);
                    UnsafeUtil.V(obj, j8, a8);
                    return a8;
                }
                return f8;
            } else {
                return f8;
            }
            return lazyStringArrayList;
        }

        @Override // com.google.protobuf.ListFieldSchema
        void c(Object obj, long j8) {
            Object unmodifiableList;
            List list = (List) UnsafeUtil.G(obj, j8);
            if (list instanceof LazyStringList) {
                unmodifiableList = ((LazyStringList) list).j();
            } else if (f17495c.isAssignableFrom(list.getClass())) {
                return;
            } else {
                if ((list instanceof PrimitiveNonBoxingCollection) && (list instanceof Internal.ProtobufList)) {
                    Internal.ProtobufList protobufList = (Internal.ProtobufList) list;
                    if (protobufList.h()) {
                        protobufList.c();
                        return;
                    }
                    return;
                }
                unmodifiableList = Collections.unmodifiableList(list);
            }
            UnsafeUtil.V(obj, j8, unmodifiableList);
        }

        @Override // com.google.protobuf.ListFieldSchema
        <E> void d(Object obj, Object obj2, long j8) {
            List f8 = f(obj2, j8);
            List g8 = g(obj, j8, f8.size());
            int size = g8.size();
            int size2 = f8.size();
            if (size > 0 && size2 > 0) {
                g8.addAll(f8);
            }
            if (size > 0) {
                f8 = g8;
            }
            UnsafeUtil.V(obj, j8, f8);
        }

        @Override // com.google.protobuf.ListFieldSchema
        <L> List<L> e(Object obj, long j8) {
            return g(obj, j8, 10);
        }
    }

    /* loaded from: classes3.dex */
    private static final class ListFieldSchemaLite extends ListFieldSchema {
        private ListFieldSchemaLite() {
            super();
        }

        static <E> Internal.ProtobufList<E> f(Object obj, long j8) {
            return (Internal.ProtobufList) UnsafeUtil.G(obj, j8);
        }

        @Override // com.google.protobuf.ListFieldSchema
        void c(Object obj, long j8) {
            f(obj, j8).c();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v2, types: [java.util.List] */
        @Override // com.google.protobuf.ListFieldSchema
        <E> void d(Object obj, Object obj2, long j8) {
            Internal.ProtobufList<E> f8 = f(obj, j8);
            Internal.ProtobufList<E> f9 = f(obj2, j8);
            int size = f8.size();
            int size2 = f9.size();
            Internal.ProtobufList<E> protobufList = f8;
            protobufList = f8;
            if (size > 0 && size2 > 0) {
                boolean h8 = f8.h();
                Internal.ProtobufList<E> protobufList2 = f8;
                if (!h8) {
                    protobufList2 = f8.a(size2 + size);
                }
                protobufList2.addAll(f9);
                protobufList = protobufList2;
            }
            if (size > 0) {
                f9 = protobufList;
            }
            UnsafeUtil.V(obj, j8, f9);
        }

        @Override // com.google.protobuf.ListFieldSchema
        <L> List<L> e(Object obj, long j8) {
            int i8;
            Internal.ProtobufList f8 = f(obj, j8);
            if (!f8.h()) {
                int size = f8.size();
                if (size == 0) {
                    i8 = 10;
                } else {
                    i8 = size * 2;
                }
                Internal.ProtobufList a8 = f8.a(i8);
                UnsafeUtil.V(obj, j8, a8);
                return a8;
            }
            return f8;
        }
    }

    private ListFieldSchema() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ListFieldSchema a() {
        return f17493a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ListFieldSchema b() {
        return f17494b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void c(Object obj, long j8);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract <L> void d(Object obj, Object obj2, long j8);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract <L> List<L> e(Object obj, long j8);
}
