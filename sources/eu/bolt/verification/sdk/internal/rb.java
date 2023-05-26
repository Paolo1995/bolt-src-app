package eu.bolt.verification.sdk.internal;

import android.widget.TextView;
import eu.bolt.verification.sdk.internal.pg;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class rb implements pg.b {

    /* renamed from: a  reason: collision with root package name */
    private final TextView f44807a;

    public rb(TextView textView) {
        Intrinsics.f(textView, "textView");
        this.f44807a = textView;
    }

    @Override // eu.bolt.verification.sdk.internal.pg.b
    public int a() {
        return this.f44807a.getLayout().getLineCount();
    }

    @Override // eu.bolt.verification.sdk.internal.pg.b
    public Integer b(int i8) {
        int i9 = i8 + 1;
        if (i9 < a()) {
            return Integer.valueOf(this.f44807a.getLayout().getLineEnd(i9));
        }
        return null;
    }

    @Override // eu.bolt.verification.sdk.internal.pg.b
    public Integer c(int i8) {
        int i9 = i8 + 1;
        if (i9 < a()) {
            return Integer.valueOf(this.f44807a.getLayout().getLineStart(i9));
        }
        return null;
    }

    @Override // eu.bolt.verification.sdk.internal.pg.b
    public Integer d(int i8) {
        int i9 = i8 - 1;
        if (i9 >= 0) {
            return Integer.valueOf(this.f44807a.getLayout().getLineEnd(i9));
        }
        return null;
    }

    @Override // eu.bolt.verification.sdk.internal.pg.b
    public Integer e(int i8) {
        int i9 = i8 - 1;
        if (i9 >= 0) {
            return Integer.valueOf(this.f44807a.getLayout().getLineStart(i9));
        }
        return null;
    }
}
