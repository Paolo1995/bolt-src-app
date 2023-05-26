package ee.mtakso.driver.di.modules;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@Module
/* loaded from: classes3.dex */
public class RxSchedulerModule {
    @Provides
    Scheduler a() {
        return Schedulers.a();
    }

    @Provides
    Scheduler b() {
        return Schedulers.c();
    }

    @Provides
    Scheduler c() {
        return AndroidSchedulers.a();
    }
}
