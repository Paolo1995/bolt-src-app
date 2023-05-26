package androidx.lifecycle;

import androidx.annotation.NonNull;
import androidx.arch.core.util.Function;

/* loaded from: classes.dex */
public class Transformations {
    private Transformations() {
    }

    @NonNull
    public static <X> LiveData<X> a(@NonNull LiveData<X> liveData) {
        final MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.p(liveData, new Observer<X>() { // from class: androidx.lifecycle.Transformations.3

            /* renamed from: a  reason: collision with root package name */
            boolean f6784a = true;

            @Override // androidx.lifecycle.Observer
            public void onChanged(X x7) {
                T f8 = MediatorLiveData.this.f();
                if (this.f6784a || ((f8 == 0 && x7 != null) || (f8 != 0 && !f8.equals(x7)))) {
                    this.f6784a = false;
                    MediatorLiveData.this.o(x7);
                }
            }
        });
        return mediatorLiveData;
    }

    @NonNull
    public static <X, Y> LiveData<Y> b(@NonNull LiveData<X> liveData, @NonNull final Function<X, Y> function) {
        final MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.p(liveData, new Observer<X>() { // from class: androidx.lifecycle.Transformations.1
            @Override // androidx.lifecycle.Observer
            public void onChanged(X x7) {
                MediatorLiveData.this.o(function.apply(x7));
            }
        });
        return mediatorLiveData;
    }
}
