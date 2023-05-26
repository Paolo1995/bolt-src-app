package com.google.crypto.tink.shaded.protobuf;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public class LazyStringArrayList extends AbstractProtobufList<String> implements LazyStringList, RandomAccess {

    /* renamed from: h  reason: collision with root package name */
    private static final LazyStringArrayList f15143h;

    /* renamed from: i  reason: collision with root package name */
    public static final LazyStringList f15144i;

    /* renamed from: g  reason: collision with root package name */
    private final List<Object> f15145g;

    static {
        LazyStringArrayList lazyStringArrayList = new LazyStringArrayList();
        f15143h = lazyStringArrayList;
        lazyStringArrayList.c();
        f15144i = lazyStringArrayList;
    }

    public LazyStringArrayList() {
        this(10);
    }

    private static String f(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof ByteString) {
            return ((ByteString) obj).C();
        }
        return Internal.j((byte[]) obj);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.LazyStringList
    public void U0(ByteString byteString) {
        b();
        this.f15145g.add(byteString);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        b();
        this.f15145g.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    /* renamed from: d */
    public void add(int i8, String str) {
        b();
        this.f15145g.add(i8, str);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.LazyStringList
    public List<?> e() {
        return Collections.unmodifiableList(this.f15145g);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: g */
    public String get(int i8) {
        Object obj = this.f15145g.get(i8);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            String C = byteString.C();
            if (byteString.p()) {
                this.f15145g.set(i8, C);
            }
            return C;
        }
        byte[] bArr = (byte[]) obj;
        String j8 = Internal.j(bArr);
        if (Internal.g(bArr)) {
            this.f15145g.set(i8, j8);
        }
        return j8;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, com.google.crypto.tink.shaded.protobuf.Internal.ProtobufList
    public /* bridge */ /* synthetic */ boolean h() {
        return super.h();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal.ProtobufList
    /* renamed from: i */
    public LazyStringArrayList a(int i8) {
        if (i8 >= size()) {
            ArrayList arrayList = new ArrayList(i8);
            arrayList.addAll(this.f15145g);
            return new LazyStringArrayList(arrayList);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.LazyStringList
    public LazyStringList j() {
        if (h()) {
            return new UnmodifiableLazyStringList(this);
        }
        return this;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    /* renamed from: k */
    public String remove(int i8) {
        b();
        Object remove = this.f15145g.remove(i8);
        ((AbstractList) this).modCount++;
        return f(remove);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.LazyStringList
    public Object l(int i8) {
        return this.f15145g.get(i8);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    /* renamed from: m */
    public String set(int i8, String str) {
        b();
        return f(this.f15145g.set(i8, str));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f15145g.size();
    }

    public LazyStringArrayList(int i8) {
        this(new ArrayList(i8));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        return super.add(obj);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public boolean addAll(int i8, Collection<? extends String> collection) {
        b();
        if (collection instanceof LazyStringList) {
            collection = ((LazyStringList) collection).e();
        }
        boolean addAll = this.f15145g.addAll(i8, collection);
        ((AbstractList) this).modCount++;
        return addAll;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    private LazyStringArrayList(ArrayList<Object> arrayList) {
        this.f15145g = arrayList;
    }
}
