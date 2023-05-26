package ee.mtakso.driver.di.modules;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes3.dex */
public class TimingHooks {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ObservableSource b(Observable observable) {
        return observable;
    }

    public ObservableTransformer<Integer, Integer> c() {
        return new ObservableTransformer() { // from class: ee.mtakso.driver.di.modules.c
            @Override // io.reactivex.ObservableTransformer
            public final ObservableSource a(Observable observable) {
                ObservableSource b8;
                b8 = TimingHooks.b(observable);
                return b8;
            }
        };
    }
}
