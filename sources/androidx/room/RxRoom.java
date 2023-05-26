package androidx.room;

import androidx.annotation.NonNull;
import androidx.room.InvalidationTracker;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class RxRoom {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f7597a = new Object();

    public static <T> Flowable<T> a(RoomDatabase roomDatabase, boolean z7, String[] strArr, Callable<T> callable) {
        Scheduler b8 = Schedulers.b(f(roomDatabase, z7));
        final Maybe e8 = Maybe.e(callable);
        return (Flowable<T>) b(roomDatabase, strArr).a0(b8).g0(b8).L(b8).B(new Function<Object, MaybeSource<T>>() { // from class: androidx.room.RxRoom.2
            @Override // io.reactivex.functions.Function
            /* renamed from: a */
            public MaybeSource<T> apply(Object obj) throws Exception {
                return Maybe.this;
            }
        });
    }

    public static Flowable<Object> b(final RoomDatabase roomDatabase, final String... strArr) {
        return Flowable.l(new FlowableOnSubscribe<Object>() { // from class: androidx.room.RxRoom.1
            @Override // io.reactivex.FlowableOnSubscribe
            public void a(final FlowableEmitter<Object> flowableEmitter) throws Exception {
                final InvalidationTracker.Observer observer = new InvalidationTracker.Observer(strArr) { // from class: androidx.room.RxRoom.1.1
                    @Override // androidx.room.InvalidationTracker.Observer
                    public void b(@NonNull Set<String> set) {
                        if (!flowableEmitter.isCancelled()) {
                            flowableEmitter.onNext(RxRoom.f7597a);
                        }
                    }
                };
                if (!flowableEmitter.isCancelled()) {
                    roomDatabase.m().a(observer);
                    flowableEmitter.c(Disposables.c(new Action() { // from class: androidx.room.RxRoom.1.2
                        @Override // io.reactivex.functions.Action
                        public void run() throws Exception {
                            roomDatabase.m().i(observer);
                        }
                    }));
                }
                if (!flowableEmitter.isCancelled()) {
                    flowableEmitter.onNext(RxRoom.f7597a);
                }
            }
        }, BackpressureStrategy.LATEST);
    }

    public static <T> Observable<T> c(RoomDatabase roomDatabase, boolean z7, String[] strArr, Callable<T> callable) {
        Scheduler b8 = Schedulers.b(f(roomDatabase, z7));
        final Maybe e8 = Maybe.e(callable);
        return (Observable<T>) d(roomDatabase, strArr).subscribeOn(b8).unsubscribeOn(b8).observeOn(b8).flatMapMaybe(new Function<Object, MaybeSource<T>>() { // from class: androidx.room.RxRoom.4
            @Override // io.reactivex.functions.Function
            /* renamed from: a */
            public MaybeSource<T> apply(Object obj) throws Exception {
                return Maybe.this;
            }
        });
    }

    public static Observable<Object> d(final RoomDatabase roomDatabase, final String... strArr) {
        return Observable.create(new ObservableOnSubscribe<Object>() { // from class: androidx.room.RxRoom.3
            @Override // io.reactivex.ObservableOnSubscribe
            public void a(final ObservableEmitter<Object> observableEmitter) throws Exception {
                final InvalidationTracker.Observer observer = new InvalidationTracker.Observer(strArr) { // from class: androidx.room.RxRoom.3.1
                    @Override // androidx.room.InvalidationTracker.Observer
                    public void b(@NonNull Set<String> set) {
                        observableEmitter.onNext(RxRoom.f7597a);
                    }
                };
                roomDatabase.m().a(observer);
                observableEmitter.c(Disposables.c(new Action() { // from class: androidx.room.RxRoom.3.2
                    @Override // io.reactivex.functions.Action
                    public void run() throws Exception {
                        roomDatabase.m().i(observer);
                    }
                }));
                observableEmitter.onNext(RxRoom.f7597a);
            }
        });
    }

    public static <T> Single<T> e(final Callable<T> callable) {
        return Single.f(new SingleOnSubscribe<T>() { // from class: androidx.room.RxRoom.5
            /* JADX WARN: Multi-variable type inference failed */
            @Override // io.reactivex.SingleOnSubscribe
            public void a(SingleEmitter<T> singleEmitter) throws Exception {
                try {
                    singleEmitter.onSuccess(callable.call());
                } catch (EmptyResultSetException e8) {
                    singleEmitter.a(e8);
                }
            }
        });
    }

    private static Executor f(RoomDatabase roomDatabase, boolean z7) {
        if (z7) {
            return roomDatabase.r();
        }
        return roomDatabase.o();
    }
}
