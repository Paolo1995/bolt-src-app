package eu.bolt.verification.sdk.internal;

import com.jakewharton.rxrelay2.PublishRelay;
import eu.bolt.verification.sdk.internal.fj;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class gj implements fj, cj {

    /* renamed from: a  reason: collision with root package name */
    private final oj f43145a;

    /* renamed from: b  reason: collision with root package name */
    private final PublishRelay<fj.a> f43146b;

    @Inject
    public gj(oj view) {
        Intrinsics.f(view, "view");
        this.f43145a = view;
        PublishRelay<fj.a> e8 = PublishRelay.e();
        Intrinsics.e(e8, "create<StoryPresenter.UiEvent>()");
        this.f43146b = e8;
        view.setListener(this);
    }

    @Override // eu.bolt.verification.sdk.internal.fj
    public void a() {
        this.f43145a.a0();
    }

    @Override // eu.bolt.verification.sdk.internal.fj
    public void b() {
        this.f43145a.Z();
    }

    @Override // eu.bolt.verification.sdk.internal.cj
    public void c(String storyId) {
        Intrinsics.f(storyId, "storyId");
        this.f43146b.accept(new fj.a.e(storyId));
    }

    @Override // eu.bolt.verification.sdk.internal.fj
    public void close() {
        this.f43145a.Y();
    }

    @Override // eu.bolt.verification.sdk.internal.fj
    public void d(int i8) {
        this.f43145a.setNavBarPaddings(i8);
    }

    @Override // eu.bolt.verification.sdk.internal.fj
    public void e(String storyId) {
        Intrinsics.f(storyId, "storyId");
        eu.bolt.client.stories.view.singlestory.a.w(this.f43145a, storyId, false, 2, null);
    }

    @Override // eu.bolt.verification.sdk.internal.cj
    public void f(String slideId) {
        Intrinsics.f(slideId, "slideId");
        this.f43146b.accept(new fj.a.b(slideId));
    }

    @Override // eu.bolt.verification.sdk.internal.fj
    public Observable<fj.a> h() {
        return this.f43146b;
    }

    @Override // eu.bolt.verification.sdk.internal.cj
    public void i(String storyId) {
        Intrinsics.f(storyId, "storyId");
        this.f43146b.accept(new fj.a.c(storyId));
    }

    @Override // eu.bolt.verification.sdk.internal.cj
    public void j(String storyId) {
        Intrinsics.f(storyId, "storyId");
        this.f43146b.accept(new fj.a.f(storyId));
    }

    @Override // eu.bolt.verification.sdk.internal.cj
    public void k(String storyId, Throwable th) {
        Intrinsics.f(storyId, "storyId");
        this.f43146b.accept(new fj.a.C0054a(storyId, th));
    }

    @Override // eu.bolt.verification.sdk.internal.cj
    public void l(String storyId, Throwable th) {
        Intrinsics.f(storyId, "storyId");
        this.f43146b.accept(new fj.a.d(storyId, th));
    }
}
