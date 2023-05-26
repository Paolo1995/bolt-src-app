package eu.bolt.android.stories.widget.helper;

import android.widget.TextView;
import eu.bolt.android.stories.widget.helper.RoundedBackgroundSpan;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LineInfoProviderImpl.kt */
/* loaded from: classes5.dex */
public final class LineInfoProviderImpl implements RoundedBackgroundSpan.LineInfoProvider {

    /* renamed from: a  reason: collision with root package name */
    private final TextView f37617a;

    public LineInfoProviderImpl(TextView textView) {
        Intrinsics.f(textView, "textView");
        this.f37617a = textView;
    }

    @Override // eu.bolt.android.stories.widget.helper.RoundedBackgroundSpan.LineInfoProvider
    public Integer a(int i8) {
        int i9 = i8 + 1;
        if (i9 < b()) {
            return Integer.valueOf(this.f37617a.getLayout().getLineEnd(i9));
        }
        return null;
    }

    @Override // eu.bolt.android.stories.widget.helper.RoundedBackgroundSpan.LineInfoProvider
    public int b() {
        return this.f37617a.getLayout().getLineCount();
    }

    @Override // eu.bolt.android.stories.widget.helper.RoundedBackgroundSpan.LineInfoProvider
    public Integer c(int i8) {
        int i9 = i8 - 1;
        if (i9 >= 0) {
            return Integer.valueOf(this.f37617a.getLayout().getLineStart(i9));
        }
        return null;
    }
}
