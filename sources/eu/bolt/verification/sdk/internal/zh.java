package eu.bolt.verification.sdk.internal;

import com.jakewharton.rxrelay2.PublishRelay;
import eu.bolt.verification.sdk.internal.yh;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class zh implements yh, wh {

    /* renamed from: a  reason: collision with root package name */
    private final hi f45866a;

    /* renamed from: b  reason: collision with root package name */
    private final PublishRelay<yh.a> f45867b;

    @Inject
    public zh(hi view) {
        Intrinsics.f(view, "view");
        this.f45866a = view;
        PublishRelay<yh.a> e8 = PublishRelay.e();
        Intrinsics.e(e8, "create<StoriesPresenter.UiEvent>()");
        this.f45867b = e8;
        view.setHost(this);
    }

    @Override // eu.bolt.verification.sdk.internal.wh
    public void a() {
        this.f45867b.accept(yh.a.b.f45756a);
    }

    @Override // eu.bolt.verification.sdk.internal.wh
    public void b() {
        this.f45867b.accept(yh.a.d.f45758a);
    }

    @Override // eu.bolt.verification.sdk.internal.wh
    public void c() {
        this.f45867b.accept(yh.a.C0100a.f45755a);
    }

    @Override // eu.bolt.verification.sdk.internal.wh
    public void c(String storyId) {
        Intrinsics.f(storyId, "storyId");
        this.f45867b.accept(new yh.a.c(storyId));
    }

    @Override // eu.bolt.verification.sdk.internal.yh
    public void d(int i8) {
        this.f45866a.setBottomNavBarOffset(i8);
    }

    @Override // eu.bolt.verification.sdk.internal.yh
    public void e() {
        this.f45866a.j();
    }

    @Override // eu.bolt.verification.sdk.internal.yh
    public void f(List<String> ids, int i8) {
        Intrinsics.f(ids, "ids");
        this.f45866a.f(ids, i8);
    }

    @Override // eu.bolt.verification.sdk.internal.yh
    public void g() {
        this.f45866a.i();
    }

    @Override // eu.bolt.verification.sdk.internal.yh
    public Observable<yh.a> h() {
        return this.f45867b;
    }

    @Override // eu.bolt.verification.sdk.internal.yh
    public void i(String id) {
        Intrinsics.f(id, "id");
        ji.d(this.f45866a, id, false, 2, null);
    }
}
