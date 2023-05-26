package eu.bolt.driver.core.field;

import eu.bolt.driver.core.field.io.ReadWrite;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ObservableField.kt */
/* loaded from: classes5.dex */
public final class ObservableField<T> {

    /* renamed from: a  reason: collision with root package name */
    private final String f40791a;

    /* renamed from: b  reason: collision with root package name */
    private final T f40792b;

    /* renamed from: c  reason: collision with root package name */
    private final ReadWrite<T> f40793c;

    /* renamed from: d  reason: collision with root package name */
    private final PublishSubject<T> f40794d;

    public ObservableField(String key, T t7, ReadWrite<T> adapter) {
        Intrinsics.f(key, "key");
        Intrinsics.f(adapter, "adapter");
        this.f40791a = key;
        this.f40792b = t7;
        this.f40793c = adapter;
        PublishSubject<T> e8 = PublishSubject.e();
        Intrinsics.e(e8, "create<T>()");
        this.f40794d = e8;
    }

    public final T a() {
        return this.f40793c.a(this.f40791a, this.f40792b);
    }

    public final Observable<T> b() {
        return this.f40794d;
    }

    public final void c(T t7) {
        this.f40793c.b(this.f40791a, t7);
        this.f40794d.onNext(t7);
    }
}
