package eu.bolt.verification.sdk.internal;

import dagger.Component;
import javax.inject.Singleton;

@Component(dependencies = {xh.class})
@Singleton
/* loaded from: classes5.dex */
public interface uh {

    @Component.Builder
    /* loaded from: classes5.dex */
    public interface a {
        a a(xh xhVar);

        uh build();
    }

    void a(eu.bolt.client.stories.view.singlestory.a aVar);
}
