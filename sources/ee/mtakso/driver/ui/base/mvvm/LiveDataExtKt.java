package ee.mtakso.driver.ui.base.mvvm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LiveDataExt.kt */
/* loaded from: classes3.dex */
public final class LiveDataExtKt {
    public static final <T> void a(MutableLiveData<T> mutableLiveData) {
        if (mutableLiveData != null && mutableLiveData.f() != null) {
            mutableLiveData.o(mutableLiveData.f());
        }
    }

    public static final <T> T b(LiveData<T> liveData) {
        Intrinsics.f(liveData, "<this>");
        T f8 = liveData.f();
        Intrinsics.c(f8);
        return f8;
    }
}
