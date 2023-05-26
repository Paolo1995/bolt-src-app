package eu.bolt.driver.core.ui.common.error.view;

import android.view.View;
import android.view.ViewStub;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ErrorViewInflater.kt */
/* loaded from: classes5.dex */
public final class ErrorViewInflater {

    /* renamed from: a  reason: collision with root package name */
    public static final ErrorViewInflater f41109a = new ErrorViewInflater();

    private ErrorViewInflater() {
    }

    public final ErrorViewController a(ViewStub stub) {
        Intrinsics.f(stub, "stub");
        View inflate = stub.inflate();
        Intrinsics.e(inflate, "stub.inflate()");
        return new ErrorViewController(inflate);
    }
}
