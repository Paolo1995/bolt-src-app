package io.reactivex.internal.functions;

import io.reactivex.Notification;
import io.reactivex.Scheduler;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function3;
import io.reactivex.functions.Function4;
import io.reactivex.functions.Function5;
import io.reactivex.functions.Function6;
import io.reactivex.functions.Function7;
import io.reactivex.functions.Function8;
import io.reactivex.functions.Function9;
import io.reactivex.functions.LongConsumer;
import io.reactivex.functions.Predicate;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Timed;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscription;

/* loaded from: classes5.dex */
public final class Functions {

    /* renamed from: a  reason: collision with root package name */
    static final Function<Object, Object> f47616a = new Identity();

    /* renamed from: b  reason: collision with root package name */
    public static final Runnable f47617b = new EmptyRunnable();

    /* renamed from: c  reason: collision with root package name */
    public static final Action f47618c = new EmptyAction();

    /* renamed from: d  reason: collision with root package name */
    static final Consumer<Object> f47619d = new EmptyConsumer();

    /* renamed from: e  reason: collision with root package name */
    public static final Consumer<Throwable> f47620e = new ErrorConsumer();

    /* renamed from: f  reason: collision with root package name */
    public static final Consumer<Throwable> f47621f = new OnErrorMissingConsumer();

    /* renamed from: g  reason: collision with root package name */
    public static final LongConsumer f47622g = new EmptyLongConsumer();

    /* renamed from: h  reason: collision with root package name */
    static final Predicate<Object> f47623h = new TruePredicate();

    /* renamed from: i  reason: collision with root package name */
    static final Predicate<Object> f47624i = new FalsePredicate();

    /* renamed from: j  reason: collision with root package name */
    static final Callable<Object> f47625j = new NullCallable();

    /* renamed from: k  reason: collision with root package name */
    static final Comparator<Object> f47626k = new NaturalObjectComparator();

    /* renamed from: l  reason: collision with root package name */
    public static final Consumer<Subscription> f47627l = new MaxRequestSubscription();

    /* loaded from: classes5.dex */
    static final class ActionConsumer<T> implements Consumer<T> {

        /* renamed from: f  reason: collision with root package name */
        final Action f47628f;

        ActionConsumer(Action action) {
            this.f47628f = action;
        }

        @Override // io.reactivex.functions.Consumer
        public void accept(T t7) throws Exception {
            this.f47628f.run();
        }
    }

    /* loaded from: classes5.dex */
    static final class Array2Func<T1, T2, R> implements Function<Object[], R> {

        /* renamed from: f  reason: collision with root package name */
        final BiFunction<? super T1, ? super T2, ? extends R> f47629f;

        Array2Func(BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
            this.f47629f = biFunction;
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 2) {
                return this.f47629f.apply(objArr[0], objArr[1]);
            }
            throw new IllegalArgumentException("Array of size 2 expected but got " + objArr.length);
        }
    }

    /* loaded from: classes5.dex */
    static final class Array3Func<T1, T2, T3, R> implements Function<Object[], R> {

        /* renamed from: f  reason: collision with root package name */
        final Function3<T1, T2, T3, R> f47630f;

        Array3Func(Function3<T1, T2, T3, R> function3) {
            this.f47630f = function3;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        /* renamed from: a */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 3) {
                return (R) this.f47630f.a(objArr[0], objArr[1], objArr[2]);
            }
            throw new IllegalArgumentException("Array of size 3 expected but got " + objArr.length);
        }
    }

    /* loaded from: classes5.dex */
    static final class Array4Func<T1, T2, T3, T4, R> implements Function<Object[], R> {

        /* renamed from: f  reason: collision with root package name */
        final Function4<T1, T2, T3, T4, R> f47631f;

        Array4Func(Function4<T1, T2, T3, T4, R> function4) {
            this.f47631f = function4;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        /* renamed from: a */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 4) {
                return (R) this.f47631f.a(objArr[0], objArr[1], objArr[2], objArr[3]);
            }
            throw new IllegalArgumentException("Array of size 4 expected but got " + objArr.length);
        }
    }

    /* loaded from: classes5.dex */
    static final class Array5Func<T1, T2, T3, T4, T5, R> implements Function<Object[], R> {

        /* renamed from: f  reason: collision with root package name */
        private final Function5<T1, T2, T3, T4, T5, R> f47632f;

        Array5Func(Function5<T1, T2, T3, T4, T5, R> function5) {
            this.f47632f = function5;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        /* renamed from: a */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 5) {
                return (R) this.f47632f.a(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4]);
            }
            throw new IllegalArgumentException("Array of size 5 expected but got " + objArr.length);
        }
    }

    /* loaded from: classes5.dex */
    static final class Array6Func<T1, T2, T3, T4, T5, T6, R> implements Function<Object[], R> {

        /* renamed from: f  reason: collision with root package name */
        final Function6<T1, T2, T3, T4, T5, T6, R> f47633f;

        Array6Func(Function6<T1, T2, T3, T4, T5, T6, R> function6) {
            this.f47633f = function6;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        /* renamed from: a */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 6) {
                return (R) this.f47633f.a(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5]);
            }
            throw new IllegalArgumentException("Array of size 6 expected but got " + objArr.length);
        }
    }

    /* loaded from: classes5.dex */
    static final class Array7Func<T1, T2, T3, T4, T5, T6, T7, R> implements Function<Object[], R> {

        /* renamed from: f  reason: collision with root package name */
        final Function7<T1, T2, T3, T4, T5, T6, T7, R> f47634f;

        Array7Func(Function7<T1, T2, T3, T4, T5, T6, T7, R> function7) {
            this.f47634f = function7;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        /* renamed from: a */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 7) {
                return (R) this.f47634f.a(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6]);
            }
            throw new IllegalArgumentException("Array of size 7 expected but got " + objArr.length);
        }
    }

    /* loaded from: classes5.dex */
    static final class Array8Func<T1, T2, T3, T4, T5, T6, T7, T8, R> implements Function<Object[], R> {

        /* renamed from: f  reason: collision with root package name */
        final Function8<T1, T2, T3, T4, T5, T6, T7, T8, R> f47635f;

        Array8Func(Function8<T1, T2, T3, T4, T5, T6, T7, T8, R> function8) {
            this.f47635f = function8;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        /* renamed from: a */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 8) {
                return (R) this.f47635f.a(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6], objArr[7]);
            }
            throw new IllegalArgumentException("Array of size 8 expected but got " + objArr.length);
        }
    }

    /* loaded from: classes5.dex */
    static final class Array9Func<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> implements Function<Object[], R> {

        /* renamed from: f  reason: collision with root package name */
        final Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> f47636f;

        Array9Func(Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> function9) {
            this.f47636f = function9;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        /* renamed from: a */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 9) {
                return (R) this.f47636f.a(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6], objArr[7], objArr[8]);
            }
            throw new IllegalArgumentException("Array of size 9 expected but got " + objArr.length);
        }
    }

    /* loaded from: classes5.dex */
    static final class ArrayListCapacityCallable<T> implements Callable<List<T>> {

        /* renamed from: f  reason: collision with root package name */
        final int f47637f;

        ArrayListCapacityCallable(int i8) {
            this.f47637f = i8;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public List<T> call() throws Exception {
            return new ArrayList(this.f47637f);
        }
    }

    /* loaded from: classes5.dex */
    static final class BooleanSupplierPredicateReverse<T> implements Predicate<T> {

        /* renamed from: f  reason: collision with root package name */
        final BooleanSupplier f47638f;

        BooleanSupplierPredicateReverse(BooleanSupplier booleanSupplier) {
            this.f47638f = booleanSupplier;
        }

        @Override // io.reactivex.functions.Predicate
        public boolean test(T t7) throws Exception {
            return !this.f47638f.getAsBoolean();
        }
    }

    /* loaded from: classes5.dex */
    static final class CastToClass<T, U> implements Function<T, U> {

        /* renamed from: f  reason: collision with root package name */
        final Class<U> f47639f;

        CastToClass(Class<U> cls) {
            this.f47639f = cls;
        }

        @Override // io.reactivex.functions.Function
        public U apply(T t7) throws Exception {
            return this.f47639f.cast(t7);
        }
    }

    /* loaded from: classes5.dex */
    static final class ClassFilter<T, U> implements Predicate<T> {

        /* renamed from: f  reason: collision with root package name */
        final Class<U> f47640f;

        ClassFilter(Class<U> cls) {
            this.f47640f = cls;
        }

        @Override // io.reactivex.functions.Predicate
        public boolean test(T t7) throws Exception {
            return this.f47640f.isInstance(t7);
        }
    }

    /* loaded from: classes5.dex */
    static final class EmptyAction implements Action {
        EmptyAction() {
        }

        @Override // io.reactivex.functions.Action
        public void run() {
        }

        public String toString() {
            return "EmptyAction";
        }
    }

    /* loaded from: classes5.dex */
    static final class EmptyConsumer implements Consumer<Object> {
        EmptyConsumer() {
        }

        @Override // io.reactivex.functions.Consumer
        public void accept(Object obj) {
        }

        public String toString() {
            return "EmptyConsumer";
        }
    }

    /* loaded from: classes5.dex */
    static final class EmptyLongConsumer implements LongConsumer {
        EmptyLongConsumer() {
        }
    }

    /* loaded from: classes5.dex */
    static final class EmptyRunnable implements Runnable {
        EmptyRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
        }

        public String toString() {
            return "EmptyRunnable";
        }
    }

    /* loaded from: classes5.dex */
    static final class EqualsPredicate<T> implements Predicate<T> {

        /* renamed from: f  reason: collision with root package name */
        final T f47641f;

        EqualsPredicate(T t7) {
            this.f47641f = t7;
        }

        @Override // io.reactivex.functions.Predicate
        public boolean test(T t7) throws Exception {
            return ObjectHelper.c(t7, this.f47641f);
        }
    }

    /* loaded from: classes5.dex */
    static final class ErrorConsumer implements Consumer<Throwable> {
        ErrorConsumer() {
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a */
        public void accept(Throwable th) {
            RxJavaPlugins.s(th);
        }
    }

    /* loaded from: classes5.dex */
    static final class FalsePredicate implements Predicate<Object> {
        FalsePredicate() {
        }

        @Override // io.reactivex.functions.Predicate
        public boolean test(Object obj) {
            return false;
        }
    }

    /* loaded from: classes5.dex */
    enum HashSetCallable implements Callable<Set<Object>> {
        INSTANCE;

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Set<Object> call() throws Exception {
            return new HashSet();
        }
    }

    /* loaded from: classes5.dex */
    static final class Identity implements Function<Object, Object> {
        Identity() {
        }

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            return obj;
        }

        public String toString() {
            return "IdentityFunction";
        }
    }

    /* loaded from: classes5.dex */
    static final class JustValue<T, U> implements Callable<U>, Function<T, U> {

        /* renamed from: f  reason: collision with root package name */
        final U f47644f;

        JustValue(U u7) {
            this.f47644f = u7;
        }

        @Override // io.reactivex.functions.Function
        public U apply(T t7) throws Exception {
            return this.f47644f;
        }

        @Override // java.util.concurrent.Callable
        public U call() throws Exception {
            return this.f47644f;
        }
    }

    /* loaded from: classes5.dex */
    static final class ListSorter<T> implements Function<List<T>, List<T>> {

        /* renamed from: f  reason: collision with root package name */
        final Comparator<? super T> f47645f;

        ListSorter(Comparator<? super T> comparator) {
            this.f47645f = comparator;
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a */
        public List<T> apply(List<T> list) {
            Collections.sort(list, this.f47645f);
            return list;
        }
    }

    /* loaded from: classes5.dex */
    static final class MaxRequestSubscription implements Consumer<Subscription> {
        MaxRequestSubscription() {
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a */
        public void accept(Subscription subscription) throws Exception {
            subscription.f(Long.MAX_VALUE);
        }
    }

    /* loaded from: classes5.dex */
    enum NaturalComparator implements Comparator<Object> {
        INSTANCE;

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    /* loaded from: classes5.dex */
    static final class NaturalObjectComparator implements Comparator<Object> {
        NaturalObjectComparator() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    /* loaded from: classes5.dex */
    static final class NotificationOnComplete<T> implements Action {

        /* renamed from: f  reason: collision with root package name */
        final Consumer<? super Notification<T>> f47648f;

        NotificationOnComplete(Consumer<? super Notification<T>> consumer) {
            this.f47648f = consumer;
        }

        @Override // io.reactivex.functions.Action
        public void run() throws Exception {
            this.f47648f.accept(Notification.a());
        }
    }

    /* loaded from: classes5.dex */
    static final class NotificationOnError<T> implements Consumer<Throwable> {

        /* renamed from: f  reason: collision with root package name */
        final Consumer<? super Notification<T>> f47649f;

        NotificationOnError(Consumer<? super Notification<T>> consumer) {
            this.f47649f = consumer;
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
            this.f47649f.accept(Notification.b(th));
        }
    }

    /* loaded from: classes5.dex */
    static final class NotificationOnNext<T> implements Consumer<T> {

        /* renamed from: f  reason: collision with root package name */
        final Consumer<? super Notification<T>> f47650f;

        NotificationOnNext(Consumer<? super Notification<T>> consumer) {
            this.f47650f = consumer;
        }

        @Override // io.reactivex.functions.Consumer
        public void accept(T t7) throws Exception {
            this.f47650f.accept(Notification.c(t7));
        }
    }

    /* loaded from: classes5.dex */
    static final class NullCallable implements Callable<Object> {
        NullCallable() {
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return null;
        }
    }

    /* loaded from: classes5.dex */
    static final class OnErrorMissingConsumer implements Consumer<Throwable> {
        OnErrorMissingConsumer() {
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a */
        public void accept(Throwable th) {
            RxJavaPlugins.s(new OnErrorNotImplementedException(th));
        }
    }

    /* loaded from: classes5.dex */
    static final class TimestampFunction<T> implements Function<T, Timed<T>> {

        /* renamed from: f  reason: collision with root package name */
        final TimeUnit f47651f;

        /* renamed from: g  reason: collision with root package name */
        final Scheduler f47652g;

        TimestampFunction(TimeUnit timeUnit, Scheduler scheduler) {
            this.f47651f = timeUnit;
            this.f47652g = scheduler;
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a */
        public Timed<T> apply(T t7) throws Exception {
            return new Timed<>(t7, this.f47652g.c(this.f47651f), this.f47651f);
        }
    }

    /* loaded from: classes5.dex */
    static final class ToMapKeySelector<K, T> implements BiConsumer<Map<K, T>, T> {

        /* renamed from: a  reason: collision with root package name */
        private final Function<? super T, ? extends K> f47653a;

        ToMapKeySelector(Function<? super T, ? extends K> function) {
            this.f47653a = function;
        }

        @Override // io.reactivex.functions.BiConsumer
        /* renamed from: a */
        public void accept(Map<K, T> map, T t7) throws Exception {
            map.put(this.f47653a.apply(t7), t7);
        }
    }

    /* loaded from: classes5.dex */
    static final class ToMapKeyValueSelector<K, V, T> implements BiConsumer<Map<K, V>, T> {

        /* renamed from: a  reason: collision with root package name */
        private final Function<? super T, ? extends V> f47654a;

        /* renamed from: b  reason: collision with root package name */
        private final Function<? super T, ? extends K> f47655b;

        ToMapKeyValueSelector(Function<? super T, ? extends V> function, Function<? super T, ? extends K> function2) {
            this.f47654a = function;
            this.f47655b = function2;
        }

        @Override // io.reactivex.functions.BiConsumer
        /* renamed from: a */
        public void accept(Map<K, V> map, T t7) throws Exception {
            map.put(this.f47655b.apply(t7), this.f47654a.apply(t7));
        }
    }

    /* loaded from: classes5.dex */
    static final class ToMultimapKeyValueSelector<K, V, T> implements BiConsumer<Map<K, Collection<V>>, T> {

        /* renamed from: a  reason: collision with root package name */
        private final Function<? super K, ? extends Collection<? super V>> f47656a;

        /* renamed from: b  reason: collision with root package name */
        private final Function<? super T, ? extends V> f47657b;

        /* renamed from: c  reason: collision with root package name */
        private final Function<? super T, ? extends K> f47658c;

        ToMultimapKeyValueSelector(Function<? super K, ? extends Collection<? super V>> function, Function<? super T, ? extends V> function2, Function<? super T, ? extends K> function3) {
            this.f47656a = function;
            this.f47657b = function2;
            this.f47658c = function3;
        }

        @Override // io.reactivex.functions.BiConsumer
        /* renamed from: a */
        public void accept(Map<K, Collection<V>> map, T t7) throws Exception {
            K apply = this.f47658c.apply(t7);
            Collection<? super V> collection = map.get(apply);
            if (collection == null) {
                collection = this.f47656a.apply(apply);
                map.put(apply, collection);
            }
            collection.add(this.f47657b.apply(t7));
        }
    }

    /* loaded from: classes5.dex */
    static final class TruePredicate implements Predicate<Object> {
        TruePredicate() {
        }

        @Override // io.reactivex.functions.Predicate
        public boolean test(Object obj) {
            return true;
        }
    }

    private Functions() {
        throw new IllegalStateException("No instances!");
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> Function<Object[], R> A(Function7<T1, T2, T3, T4, T5, T6, T7, R> function7) {
        ObjectHelper.e(function7, "f is null");
        return new Array7Func(function7);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Function<Object[], R> B(Function8<T1, T2, T3, T4, T5, T6, T7, T8, R> function8) {
        ObjectHelper.e(function8, "f is null");
        return new Array8Func(function8);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Function<Object[], R> C(Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> function9) {
        ObjectHelper.e(function9, "f is null");
        return new Array9Func(function9);
    }

    public static <T, K> BiConsumer<Map<K, T>, T> D(Function<? super T, ? extends K> function) {
        return new ToMapKeySelector(function);
    }

    public static <T, K, V> BiConsumer<Map<K, V>, T> E(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        return new ToMapKeyValueSelector(function2, function);
    }

    public static <T, K, V> BiConsumer<Map<K, Collection<V>>, T> F(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, Function<? super K, ? extends Collection<? super V>> function3) {
        return new ToMultimapKeyValueSelector(function3, function2, function);
    }

    public static <T> Consumer<T> a(Action action) {
        return new ActionConsumer(action);
    }

    public static <T> Predicate<T> b() {
        return (Predicate<T>) f47624i;
    }

    public static <T> Predicate<T> c() {
        return (Predicate<T>) f47623h;
    }

    public static <T, U> Function<T, U> d(Class<U> cls) {
        return new CastToClass(cls);
    }

    public static <T> Callable<List<T>> e(int i8) {
        return new ArrayListCapacityCallable(i8);
    }

    public static <T> Callable<Set<T>> f() {
        return HashSetCallable.INSTANCE;
    }

    public static <T> Consumer<T> g() {
        return (Consumer<T>) f47619d;
    }

    public static <T> Predicate<T> h(T t7) {
        return new EqualsPredicate(t7);
    }

    public static <T> Function<T, T> i() {
        return (Function<T, T>) f47616a;
    }

    public static <T, U> Predicate<T> j(Class<U> cls) {
        return new ClassFilter(cls);
    }

    public static <T> Callable<T> k(T t7) {
        return new JustValue(t7);
    }

    public static <T, U> Function<T, U> l(U u7) {
        return new JustValue(u7);
    }

    public static <T> Function<List<T>, List<T>> m(Comparator<? super T> comparator) {
        return new ListSorter(comparator);
    }

    public static <T> Comparator<T> n() {
        return NaturalComparator.INSTANCE;
    }

    public static <T> Comparator<T> o() {
        return (Comparator<T>) f47626k;
    }

    public static <T> Action p(Consumer<? super Notification<T>> consumer) {
        return new NotificationOnComplete(consumer);
    }

    public static <T> Consumer<Throwable> q(Consumer<? super Notification<T>> consumer) {
        return new NotificationOnError(consumer);
    }

    public static <T> Consumer<T> r(Consumer<? super Notification<T>> consumer) {
        return new NotificationOnNext(consumer);
    }

    public static <T> Callable<T> s() {
        return (Callable<T>) f47625j;
    }

    public static <T> Predicate<T> t(BooleanSupplier booleanSupplier) {
        return new BooleanSupplierPredicateReverse(booleanSupplier);
    }

    public static <T> Function<T, Timed<T>> u(TimeUnit timeUnit, Scheduler scheduler) {
        return new TimestampFunction(timeUnit, scheduler);
    }

    public static <T1, T2, R> Function<Object[], R> v(BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
        ObjectHelper.e(biFunction, "f is null");
        return new Array2Func(biFunction);
    }

    public static <T1, T2, T3, R> Function<Object[], R> w(Function3<T1, T2, T3, R> function3) {
        ObjectHelper.e(function3, "f is null");
        return new Array3Func(function3);
    }

    public static <T1, T2, T3, T4, R> Function<Object[], R> x(Function4<T1, T2, T3, T4, R> function4) {
        ObjectHelper.e(function4, "f is null");
        return new Array4Func(function4);
    }

    public static <T1, T2, T3, T4, T5, R> Function<Object[], R> y(Function5<T1, T2, T3, T4, T5, R> function5) {
        ObjectHelper.e(function5, "f is null");
        return new Array5Func(function5);
    }

    public static <T1, T2, T3, T4, T5, T6, R> Function<Object[], R> z(Function6<T1, T2, T3, T4, T5, T6, R> function6) {
        ObjectHelper.e(function6, "f is null");
        return new Array6Func(function6);
    }
}
