package androidx.work.impl;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.work.Operation;
import androidx.work.impl.utils.futures.SettableFuture;

/* loaded from: classes.dex */
public class OperationImpl implements Operation {

    /* renamed from: c  reason: collision with root package name */
    private final MutableLiveData<Operation.State> f8345c = new MutableLiveData<>();

    /* renamed from: d  reason: collision with root package name */
    private final SettableFuture<Operation.State.SUCCESS> f8346d = SettableFuture.t();

    public OperationImpl() {
        a(Operation.f8301b);
    }

    public void a(@NonNull Operation.State state) {
        this.f8345c.m(state);
        if (state instanceof Operation.State.SUCCESS) {
            this.f8346d.p((Operation.State.SUCCESS) state);
        } else if (state instanceof Operation.State.FAILURE) {
            this.f8346d.q(((Operation.State.FAILURE) state).a());
        }
    }
}
