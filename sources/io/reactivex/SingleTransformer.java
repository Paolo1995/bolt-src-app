package io.reactivex;

/* loaded from: classes5.dex */
public interface SingleTransformer<Upstream, Downstream> {
    SingleSource<Downstream> a(Single<Upstream> single);
}
