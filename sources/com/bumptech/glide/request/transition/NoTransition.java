package com.bumptech.glide.request.transition;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.transition.Transition;

/* loaded from: classes.dex */
public class NoTransition<R> implements Transition<R> {

    /* renamed from: a  reason: collision with root package name */
    static final NoTransition<?> f10754a = new NoTransition<>();

    /* renamed from: b  reason: collision with root package name */
    private static final TransitionFactory<?> f10755b = new NoAnimationFactory();

    /* loaded from: classes.dex */
    public static class NoAnimationFactory<R> implements TransitionFactory<R> {
        @Override // com.bumptech.glide.request.transition.TransitionFactory
        public Transition<R> a(DataSource dataSource, boolean z7) {
            return NoTransition.f10754a;
        }
    }

    public static <R> TransitionFactory<R> b() {
        return (TransitionFactory<R>) f10755b;
    }

    @Override // com.bumptech.glide.request.transition.Transition
    public boolean a(Object obj, Transition.ViewAdapter viewAdapter) {
        return false;
    }
}
