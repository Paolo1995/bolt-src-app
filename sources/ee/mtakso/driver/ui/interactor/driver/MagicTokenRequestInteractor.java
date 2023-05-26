package ee.mtakso.driver.ui.interactor.driver;

import ee.mtakso.driver.network.client.auth.anonymous.AnonymousAuthClient;
import ee.mtakso.driver.utils.CompletableExtKt;
import io.reactivex.Completable;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MagicTokenRequestInteractor.kt */
/* loaded from: classes3.dex */
public final class MagicTokenRequestInteractor {

    /* renamed from: a  reason: collision with root package name */
    private final AnonymousAuthClient f26482a;

    @Inject
    public MagicTokenRequestInteractor(AnonymousAuthClient anonymousAuthClient) {
        Intrinsics.f(anonymousAuthClient, "anonymousAuthClient");
        this.f26482a = anonymousAuthClient;
    }

    public final Completable a(String email) {
        Intrinsics.f(email, "email");
        return CompletableExtKt.a(this.f26482a.K(email));
    }
}
