package androidx.fragment.app;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FragmentManager.kt */
/* loaded from: classes.dex */
public final class FragmentManagerKt {
    public static final void commit(FragmentManager commit, boolean z7, Function1<? super FragmentTransaction, Unit> body) {
        Intrinsics.f(commit, "$this$commit");
        Intrinsics.f(body, "body");
        FragmentTransaction beginTransaction = commit.beginTransaction();
        Intrinsics.e(beginTransaction, "beginTransaction()");
        body.invoke(beginTransaction);
        if (z7) {
            beginTransaction.commitAllowingStateLoss();
        } else {
            beginTransaction.commit();
        }
    }

    public static /* synthetic */ void commit$default(FragmentManager commit, boolean z7, Function1 body, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            z7 = false;
        }
        Intrinsics.f(commit, "$this$commit");
        Intrinsics.f(body, "body");
        FragmentTransaction beginTransaction = commit.beginTransaction();
        Intrinsics.e(beginTransaction, "beginTransaction()");
        body.invoke(beginTransaction);
        if (z7) {
            beginTransaction.commitAllowingStateLoss();
        } else {
            beginTransaction.commit();
        }
    }

    public static final void commitNow(FragmentManager commitNow, boolean z7, Function1<? super FragmentTransaction, Unit> body) {
        Intrinsics.f(commitNow, "$this$commitNow");
        Intrinsics.f(body, "body");
        FragmentTransaction beginTransaction = commitNow.beginTransaction();
        Intrinsics.e(beginTransaction, "beginTransaction()");
        body.invoke(beginTransaction);
        if (z7) {
            beginTransaction.commitNowAllowingStateLoss();
        } else {
            beginTransaction.commitNow();
        }
    }

    public static /* synthetic */ void commitNow$default(FragmentManager commitNow, boolean z7, Function1 body, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            z7 = false;
        }
        Intrinsics.f(commitNow, "$this$commitNow");
        Intrinsics.f(body, "body");
        FragmentTransaction beginTransaction = commitNow.beginTransaction();
        Intrinsics.e(beginTransaction, "beginTransaction()");
        body.invoke(beginTransaction);
        if (z7) {
            beginTransaction.commitNowAllowingStateLoss();
        } else {
            beginTransaction.commitNow();
        }
    }

    public static final void transaction(FragmentManager transaction, boolean z7, boolean z8, Function1<? super FragmentTransaction, Unit> body) {
        Intrinsics.f(transaction, "$this$transaction");
        Intrinsics.f(body, "body");
        FragmentTransaction beginTransaction = transaction.beginTransaction();
        Intrinsics.e(beginTransaction, "beginTransaction()");
        body.invoke(beginTransaction);
        if (z7) {
            if (z8) {
                beginTransaction.commitNowAllowingStateLoss();
            } else {
                beginTransaction.commitNow();
            }
        } else if (z8) {
            beginTransaction.commitAllowingStateLoss();
        } else {
            beginTransaction.commit();
        }
    }

    public static /* synthetic */ void transaction$default(FragmentManager transaction, boolean z7, boolean z8, Function1 body, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            z7 = false;
        }
        if ((i8 & 2) != 0) {
            z8 = false;
        }
        Intrinsics.f(transaction, "$this$transaction");
        Intrinsics.f(body, "body");
        FragmentTransaction beginTransaction = transaction.beginTransaction();
        Intrinsics.e(beginTransaction, "beginTransaction()");
        body.invoke(beginTransaction);
        if (z7) {
            if (z8) {
                beginTransaction.commitNowAllowingStateLoss();
            } else {
                beginTransaction.commitNow();
            }
        } else if (z8) {
            beginTransaction.commitAllowingStateLoss();
        } else {
            beginTransaction.commit();
        }
    }
}
