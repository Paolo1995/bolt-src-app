package io.reactivex;

/* loaded from: classes5.dex */
public interface ObservableTransformer<Upstream, Downstream> {
    ObservableSource<Downstream> a(Observable<Upstream> observable);
}
