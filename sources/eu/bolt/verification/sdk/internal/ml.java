package eu.bolt.verification.sdk.internal;

import android.content.Context;
import eu.bolt.verification.sdk.internal.ll;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class ml {

    /* renamed from: a  reason: collision with root package name */
    private final Context f44216a;

    /* renamed from: b  reason: collision with root package name */
    private final v4 f44217b;

    @Inject
    public ml(Context context, v4 designHtml) {
        Intrinsics.f(context, "context");
        Intrinsics.f(designHtml, "designHtml");
        this.f44216a = context;
        this.f44217b = designHtml;
    }

    public final CharSequence a(ll llVar) {
        if (!(llVar instanceof ll.c)) {
            return llVar instanceof ll.d ? ((ll.d) llVar).a() : llVar instanceof ll.b ? this.f44217b.a(((ll.b) llVar).a()) : "";
        }
        String string = this.f44216a.getString(((ll.c) llVar).b());
        Intrinsics.e(string, "context.getString(model.resId)");
        return string;
    }
}
