package io.reactivex.observers;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.util.VolatileSizeArrayList;
import io.reactivex.observers.BaseTestConsumer;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes5.dex */
public abstract class BaseTestConsumer<T, U extends BaseTestConsumer<T, U>> implements Disposable {

    /* renamed from: i  reason: collision with root package name */
    protected long f49826i;

    /* renamed from: j  reason: collision with root package name */
    protected Thread f49827j;

    /* renamed from: k  reason: collision with root package name */
    protected boolean f49828k;

    /* renamed from: l  reason: collision with root package name */
    protected int f49829l;

    /* renamed from: m  reason: collision with root package name */
    protected int f49830m;

    /* renamed from: g  reason: collision with root package name */
    protected final List<T> f49824g = new VolatileSizeArrayList();

    /* renamed from: h  reason: collision with root package name */
    protected final List<Throwable> f49825h = new VolatileSizeArrayList();

    /* renamed from: f  reason: collision with root package name */
    protected final CountDownLatch f49823f = new CountDownLatch(1);
}
