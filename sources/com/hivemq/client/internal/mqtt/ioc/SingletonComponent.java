package com.hivemq.client.internal.mqtt.ioc;

import com.hivemq.client.internal.mqtt.ioc.ClientComponent;
import dagger.Component;
import javax.inject.Singleton;

@Component
@Singleton
/* loaded from: classes3.dex */
public interface SingletonComponent {

    /* renamed from: a  reason: collision with root package name */
    public static final SingletonComponent f18420a = DaggerSingletonComponent.h();

    ClientComponent.Builder a();
}
