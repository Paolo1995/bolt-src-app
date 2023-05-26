package eu.bolt.android.engine.html;

import android.text.SpannableStringBuilder;
import android.widget.TextView;
import eu.bolt.android.engine.html.span.ViewBoundSpan;
import eu.bolt.android.engine.html.span.timer.TickListener;
import eu.bolt.android.engine.html.span.timer.TickTimer;
import eu.bolt.android.engine.html.span.timer.TimerInfoProvider;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DesignHtmlSpanBuilder.kt */
/* loaded from: classes5.dex */
public final class DesignHtmlSpanBuilder extends SpannableStringBuilder {

    /* renamed from: f  reason: collision with root package name */
    private final String f36740f;

    /* renamed from: g  reason: collision with root package name */
    private final HtmlEngine f36741g;

    /* renamed from: h  reason: collision with root package name */
    private final List<ViewBoundSpan> f36742h;

    /* renamed from: i  reason: collision with root package name */
    private Set<TimerInfoProvider> f36743i;

    /* renamed from: j  reason: collision with root package name */
    private TextView f36744j;

    /* renamed from: k  reason: collision with root package name */
    private final DesignHtmlSpanBuilder$updaterTime$1 f36745k;

    /* JADX WARN: Type inference failed for: r2v3, types: [eu.bolt.android.engine.html.DesignHtmlSpanBuilder$updaterTime$1] */
    public DesignHtmlSpanBuilder(String source, HtmlEngine converter) {
        Intrinsics.f(source, "source");
        Intrinsics.f(converter, "converter");
        this.f36740f = source;
        this.f36741g = converter;
        this.f36742h = new ArrayList();
        this.f36743i = new LinkedHashSet();
        this.f36745k = new TickListener() { // from class: eu.bolt.android.engine.html.DesignHtmlSpanBuilder$updaterTime$1
            @Override // eu.bolt.android.engine.html.span.timer.TickListener
            public void a(long j8) {
                TextView textView;
                Set set;
                HtmlEngine htmlEngine;
                textView = DesignHtmlSpanBuilder.this.f36744j;
                if (textView != null) {
                    htmlEngine = DesignHtmlSpanBuilder.this.f36741g;
                    textView.setText(htmlEngine.a(DesignHtmlSpanBuilder.this.h()));
                }
                set = DesignHtmlSpanBuilder.this.f36743i;
                boolean z7 = true;
                if (!(set instanceof Collection) || !set.isEmpty()) {
                    Iterator it = set.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        } else if (!(!((TimerInfoProvider) it.next()).a(j8))) {
                            z7 = false;
                            break;
                        }
                    }
                }
                if (z7) {
                    TickTimer.f36898a.e(this);
                }
            }
        };
    }

    @Override // android.text.SpannableStringBuilder, java.lang.CharSequence
    public final /* bridge */ char charAt(int i8) {
        return f(i8);
    }

    public final void d(TextView textView) {
        Intrinsics.f(textView, "textView");
        for (ViewBoundSpan viewBoundSpan : this.f36742h) {
            viewBoundSpan.b(textView);
        }
        long currentTimeMillis = System.currentTimeMillis();
        Set<TimerInfoProvider> set = this.f36743i;
        boolean z7 = false;
        if (!(set instanceof Collection) || !set.isEmpty()) {
            Iterator<T> it = set.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (((TimerInfoProvider) it.next()).a(currentTimeMillis)) {
                        z7 = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        if (z7) {
            TickTimer.f36898a.d(this.f36745k);
        }
        this.f36744j = textView;
    }

    public final void e() {
        TextView textView = this.f36744j;
        if (textView != null) {
            for (ViewBoundSpan viewBoundSpan : this.f36742h) {
                viewBoundSpan.a(textView);
            }
        }
        TickTimer.f36898a.e(this.f36745k);
        this.f36744j = null;
    }

    public /* bridge */ char f(int i8) {
        return super.charAt(i8);
    }

    public /* bridge */ int g() {
        return super.length();
    }

    public final String h() {
        return this.f36740f;
    }

    @Override // android.text.SpannableStringBuilder, java.lang.CharSequence
    public final /* bridge */ int length() {
        return g();
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public void removeSpan(Object obj) {
        super.removeSpan(obj);
        if (obj instanceof ViewBoundSpan) {
            TextView textView = this.f36744j;
            if (textView != null) {
                ((ViewBoundSpan) obj).a(textView);
            }
            this.f36742h.remove(obj);
        }
        if (obj instanceof TimerInfoProvider) {
            this.f36743i.remove(obj);
        }
        if (this.f36743i.isEmpty() && this.f36744j != null) {
            TickTimer.f36898a.e(this.f36745k);
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public void setSpan(Object obj, int i8, int i9, int i10) {
        super.setSpan(obj, i8, i9, i10);
        if (obj instanceof ViewBoundSpan) {
            TextView textView = this.f36744j;
            if (textView != null) {
                ((ViewBoundSpan) obj).b(textView);
            }
            this.f36742h.add(obj);
        }
        if (obj instanceof TimerInfoProvider) {
            if (this.f36743i.isEmpty() && this.f36744j != null) {
                TickTimer.f36898a.d(this.f36745k);
            }
            this.f36743i.add(obj);
        }
    }
}
