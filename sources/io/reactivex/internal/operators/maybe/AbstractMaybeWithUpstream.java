package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeSource;

/* loaded from: classes5.dex */
abstract class AbstractMaybeWithUpstream<T, R> extends Maybe<R> {

    /* renamed from: f  reason: collision with root package name */
    protected final MaybeSource<T> f48109f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractMaybeWithUpstream(MaybeSource<T> maybeSource) {
        this.f48109f = maybeSource;
    }
}
