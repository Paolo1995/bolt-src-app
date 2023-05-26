package io.reactivex;

/* loaded from: classes5.dex */
public interface ObservableOperator<Downstream, Upstream> {
    Observer<? super Upstream> a(Observer<? super Downstream> observer) throws Exception;
}
