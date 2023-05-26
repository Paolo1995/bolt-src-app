package kotlinx.coroutines;

import kotlinx.coroutines.internal.LimitedDispatcherKt;

/* compiled from: MainCoroutineDispatcher.kt */
/* loaded from: classes5.dex */
public abstract class MainCoroutineDispatcher extends CoroutineDispatcher {
    @Override // kotlinx.coroutines.CoroutineDispatcher
    public CoroutineDispatcher P0(int i8) {
        LimitedDispatcherKt.a(i8);
        return this;
    }

    public abstract MainCoroutineDispatcher R0();

    /* JADX INFO: Access modifiers changed from: protected */
    public final String S0() {
        MainCoroutineDispatcher mainCoroutineDispatcher;
        MainCoroutineDispatcher c8 = Dispatchers.c();
        if (this == c8) {
            return "Dispatchers.Main";
        }
        try {
            mainCoroutineDispatcher = c8.R0();
        } catch (UnsupportedOperationException unused) {
            mainCoroutineDispatcher = null;
        }
        if (this != mainCoroutineDispatcher) {
            return null;
        }
        return "Dispatchers.Main.immediate";
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        String S0 = S0();
        if (S0 == null) {
            return DebugStringsKt.a(this) + '@' + DebugStringsKt.b(this);
        }
        return S0;
    }
}
