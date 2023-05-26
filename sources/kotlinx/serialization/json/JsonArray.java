package kotlinx.serialization.json;

import j$.lang.Iterable$CC;
import j$.util.Collection$CC;
import j$.util.List;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.IntFunction;
import j$.util.function.Predicate;
import j$.util.function.UnaryOperator;
import j$.util.stream.Stream;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

/* compiled from: JsonElement.kt */
@Serializable(with = JsonArraySerializer.class)
/* loaded from: classes5.dex */
public final class JsonArray extends JsonElement implements List<JsonElement>, KMappedMarker, j$.util.List {
    public static final Companion Companion = new Companion(null);

    /* renamed from: f  reason: collision with root package name */
    private final List<JsonElement> f52304f;

    /* compiled from: JsonElement.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<JsonArray> serializer() {
            return JsonArraySerializer.f52305a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public JsonArray(List<? extends JsonElement> content) {
        super(null);
        Intrinsics.f(content, "content");
        this.f52304f = content;
    }

    @Override // java.util.List, j$.util.List
    public /* bridge */ /* synthetic */ void add(int i8, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection, j$.util.List
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, j$.util.List
    public boolean addAll(int i8, Collection<? extends JsonElement> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection, j$.util.List
    public boolean addAll(Collection<? extends JsonElement> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean b(JsonElement element) {
        Intrinsics.f(element, "element");
        return this.f52304f.contains(element);
    }

    @Override // java.util.List, java.util.Collection, j$.util.List
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection, j$.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof JsonElement)) {
            return false;
        }
        return b((JsonElement) obj);
    }

    @Override // java.util.List, java.util.Collection, j$.util.List
    public boolean containsAll(Collection<? extends Object> elements) {
        Intrinsics.f(elements, "elements");
        return this.f52304f.containsAll(elements);
    }

    @Override // java.util.List, j$.util.List
    /* renamed from: d */
    public JsonElement get(int i8) {
        return this.f52304f.get(i8);
    }

    @Override // java.util.List, java.util.Collection, j$.util.List
    public boolean equals(Object obj) {
        return Intrinsics.a(this.f52304f, obj);
    }

    @Override // j$.util.List, j$.util.InterfaceC0106a
    public /* synthetic */ void forEach(Consumer consumer) {
        Iterable$CC.$default$forEach(this, consumer);
    }

    @Override // java.lang.Iterable
    public /* synthetic */ void forEach(java.util.function.Consumer consumer) {
        forEach(Consumer.VivifiedWrapper.convert(consumer));
    }

    public int g() {
        return this.f52304f.size();
    }

    @Override // java.util.List, java.util.Collection, j$.util.List
    public int hashCode() {
        return this.f52304f.hashCode();
    }

    public int i(JsonElement element) {
        Intrinsics.f(element, "element");
        return this.f52304f.indexOf(element);
    }

    @Override // java.util.List, j$.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (!(obj instanceof JsonElement)) {
            return -1;
        }
        return i((JsonElement) obj);
    }

    @Override // java.util.List, java.util.Collection, j$.util.List
    public boolean isEmpty() {
        return this.f52304f.isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable, j$.util.List
    public Iterator<JsonElement> iterator() {
        return this.f52304f.iterator();
    }

    public int k(JsonElement element) {
        Intrinsics.f(element, "element");
        return this.f52304f.lastIndexOf(element);
    }

    @Override // java.util.List, j$.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (!(obj instanceof JsonElement)) {
            return -1;
        }
        return k((JsonElement) obj);
    }

    @Override // java.util.List, j$.util.List
    public ListIterator<JsonElement> listIterator() {
        return this.f52304f.listIterator();
    }

    @Override // java.util.List, j$.util.List
    public ListIterator<JsonElement> listIterator(int i8) {
        return this.f52304f.listIterator(i8);
    }

    @Override // java.util.Collection, j$.util.List
    public /* synthetic */ Stream parallelStream() {
        return Collection$CC.$default$parallelStream(this);
    }

    @Override // java.util.Collection
    public /* synthetic */ java.util.stream.Stream parallelStream() {
        return Stream.Wrapper.convert(parallelStream());
    }

    @Override // java.util.List, j$.util.List
    public /* bridge */ /* synthetic */ Object remove(int i8) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection, j$.util.List
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection, j$.util.List
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // j$.util.List, j$.util.InterfaceC0106a
    public /* synthetic */ boolean removeIf(Predicate predicate) {
        return Collection$CC.$default$removeIf(this, predicate);
    }

    @Override // java.util.Collection
    public /* synthetic */ boolean removeIf(java.util.function.Predicate predicate) {
        return removeIf(Predicate.VivifiedWrapper.convert(predicate));
    }

    @Override // j$.util.List
    public void replaceAll(UnaryOperator<JsonElement> unaryOperator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public /* synthetic */ void replaceAll(java.util.function.UnaryOperator<JsonElement> unaryOperator) {
        replaceAll(UnaryOperator.VivifiedWrapper.convert(unaryOperator));
    }

    @Override // java.util.List, java.util.Collection, j$.util.List
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, j$.util.List
    public /* bridge */ /* synthetic */ Object set(int i8, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection, j$.util.List
    public final /* bridge */ int size() {
        return g();
    }

    @Override // java.util.List, j$.util.List
    public void sort(Comparator<? super JsonElement> comparator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable, j$.util.List, j$.util.InterfaceC0106a
    public /* synthetic */ Spliterator spliterator() {
        return List.CC.$default$spliterator(this);
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public /* synthetic */ java.util.Spliterator spliterator() {
        return Spliterator.Wrapper.convert(spliterator());
    }

    @Override // java.util.Collection, j$.util.List, j$.util.InterfaceC0106a
    public /* synthetic */ Stream stream() {
        return Collection$CC.$default$stream(this);
    }

    @Override // java.util.Collection
    public /* synthetic */ java.util.stream.Stream stream() {
        return Stream.Wrapper.convert(stream());
    }

    @Override // java.util.List, j$.util.List
    public java.util.List<JsonElement> subList(int i8, int i9) {
        return this.f52304f.subList(i8, i9);
    }

    @Override // java.util.List, java.util.Collection, j$.util.List
    public Object[] toArray() {
        return CollectionToArray.a(this);
    }

    @Override // j$.util.List
    public /* synthetic */ Object[] toArray(IntFunction intFunction) {
        return Collection$CC.$default$toArray(this, intFunction);
    }

    public /* synthetic */ Object[] toArray(java.util.function.IntFunction intFunction) {
        return toArray(IntFunction.VivifiedWrapper.convert(intFunction));
    }

    @Override // java.util.List, java.util.Collection, j$.util.List
    public <T> T[] toArray(T[] array) {
        Intrinsics.f(array, "array");
        return (T[]) CollectionToArray.b(this, array);
    }

    public String toString() {
        String f02;
        f02 = CollectionsKt___CollectionsKt.f0(this.f52304f, ",", "[", "]", 0, null, null, 56, null);
        return f02;
    }
}
