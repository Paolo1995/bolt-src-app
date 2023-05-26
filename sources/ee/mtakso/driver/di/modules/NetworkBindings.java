package ee.mtakso.driver.di.modules;

import dagger.Binds;
import dagger.Module;
import ee.mtakso.driver.network.ApiExceptionProvider;
import ee.mtakso.driver.network.response.ResponseErrorProcessor;

/* compiled from: NetworkBindings.kt */
@Module
/* loaded from: classes3.dex */
public interface NetworkBindings {
    @Binds
    ApiExceptionProvider a(ResponseErrorProcessor responseErrorProcessor);
}
