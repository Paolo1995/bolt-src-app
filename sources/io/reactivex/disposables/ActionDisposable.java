package io.reactivex.disposables;

import io.reactivex.functions.Action;
import io.reactivex.internal.util.ExceptionHelper;

/* loaded from: classes5.dex */
final class ActionDisposable extends ReferenceDisposable<Action> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ActionDisposable(Action action) {
        super(action);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.reactivex.disposables.ReferenceDisposable
    /* renamed from: b */
    public void a(Action action) {
        try {
            action.run();
        } catch (Throwable th) {
            throw ExceptionHelper.e(th);
        }
    }
}
