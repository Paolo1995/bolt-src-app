package kotlinx.serialization.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* compiled from: CollectionSerializers.kt */
/* loaded from: classes5.dex */
public final class ReferenceArraySerializer<ElementKlass, Element extends ElementKlass> extends CollectionLikeSerializer<Element, Element[], ArrayList<Element>> {

    /* renamed from: b  reason: collision with root package name */
    private final KClass<ElementKlass> f52252b;

    /* renamed from: c  reason: collision with root package name */
    private final SerialDescriptor f52253c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReferenceArraySerializer(KClass<ElementKlass> kClass, KSerializer<Element> eSerializer) {
        super(eSerializer, null);
        Intrinsics.f(kClass, "kClass");
        Intrinsics.f(eSerializer, "eSerializer");
        this.f52252b = kClass;
        this.f52253c = new ArrayClassDesc(eSerializer.a());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    /* renamed from: A */
    public Element[] q(ArrayList<Element> arrayList) {
        Intrinsics.f(arrayList, "<this>");
        return (Element[]) PlatformKt.n(arrayList, this.f52252b);
    }

    @Override // kotlinx.serialization.internal.CollectionLikeSerializer, kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor a() {
        return this.f52253c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    /* renamed from: t */
    public ArrayList<Element> f() {
        return new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    /* renamed from: u */
    public int g(ArrayList<Element> arrayList) {
        Intrinsics.f(arrayList, "<this>");
        return arrayList.size();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    /* renamed from: v */
    public void h(ArrayList<Element> arrayList, int i8) {
        Intrinsics.f(arrayList, "<this>");
        arrayList.ensureCapacity(i8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    /* renamed from: w */
    public Iterator<Element> i(Element[] elementArr) {
        Intrinsics.f(elementArr, "<this>");
        return ArrayIteratorKt.a(elementArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    /* renamed from: x */
    public int j(Element[] elementArr) {
        Intrinsics.f(elementArr, "<this>");
        return elementArr.length;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.CollectionLikeSerializer
    /* renamed from: y */
    public void s(ArrayList<Element> arrayList, int i8, Element element) {
        Intrinsics.f(arrayList, "<this>");
        arrayList.add(i8, element);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    /* renamed from: z */
    public ArrayList<Element> p(Element[] elementArr) {
        List e8;
        Intrinsics.f(elementArr, "<this>");
        e8 = ArraysKt___ArraysJvmKt.e(elementArr);
        return new ArrayList<>(e8);
    }
}
