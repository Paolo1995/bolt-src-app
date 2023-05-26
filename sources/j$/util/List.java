package j$.util;

import j$.util.function.Consumer;
import j$.util.function.IntFunction;
import j$.util.function.Predicate;
import j$.util.function.UnaryOperator;
import j$.util.stream.Stream;
import java.util.Collection;
import java.util.ListIterator;

/* loaded from: classes2.dex */
public interface List<E> extends InterfaceC0106a {

    /* renamed from: j$.util.List$-CC */
    /* loaded from: classes2.dex */
    public final /* synthetic */ class CC<E> {
        public static Spliterator $default$spliterator(java.util.List list) {
            list.getClass();
            return new a0(16, list);
        }
    }

    void add(int i8, E e8);

    boolean add(E e8);

    boolean addAll(int i8, Collection<? extends E> collection);

    boolean addAll(Collection<? extends E> collection);

    void clear();

    boolean contains(Object obj);

    boolean containsAll(Collection<?> collection);

    boolean equals(Object obj);

    @Override // j$.util.InterfaceC0106a
    /* synthetic */ void forEach(Consumer<? super E> consumer);

    E get(int i8);

    int hashCode();

    int indexOf(Object obj);

    boolean isEmpty();

    java.util.Iterator<E> iterator();

    int lastIndexOf(Object obj);

    ListIterator<E> listIterator();

    ListIterator<E> listIterator(int i8);

    /* synthetic */ Stream<E> parallelStream();

    E remove(int i8);

    boolean remove(Object obj);

    boolean removeAll(Collection<?> collection);

    @Override // j$.util.InterfaceC0106a
    /* synthetic */ boolean removeIf(Predicate<? super E> predicate);

    void replaceAll(UnaryOperator<E> unaryOperator);

    boolean retainAll(Collection<?> collection);

    E set(int i8, E e8);

    int size();

    void sort(java.util.Comparator<? super E> comparator);

    @Override // java.util.Collection, java.lang.Iterable, j$.util.List, j$.util.InterfaceC0106a
    Spliterator<E> spliterator();

    @Override // j$.util.List, j$.util.InterfaceC0106a
    /* synthetic */ Stream<E> stream();

    java.util.List<E> subList(int i8, int i9);

    Object[] toArray();

    /* synthetic */ <T> T[] toArray(IntFunction<T[]> intFunction);

    <T> T[] toArray(T[] tArr);
}
