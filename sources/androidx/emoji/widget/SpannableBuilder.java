package androidx.emoji.widget;

import android.text.Editable;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import androidx.annotation.NonNull;
import androidx.core.util.Preconditions;
import androidx.emoji.text.EmojiSpan;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class SpannableBuilder extends SpannableStringBuilder {

    /* renamed from: f  reason: collision with root package name */
    private final Class<?> f6415f;

    /* renamed from: g  reason: collision with root package name */
    private final List<WatcherWrapper> f6416g;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class WatcherWrapper implements TextWatcher, SpanWatcher {

        /* renamed from: f  reason: collision with root package name */
        final Object f6417f;

        /* renamed from: g  reason: collision with root package name */
        private final AtomicInteger f6418g = new AtomicInteger(0);

        WatcherWrapper(Object obj) {
            this.f6417f = obj;
        }

        private boolean b(Object obj) {
            return obj instanceof EmojiSpan;
        }

        final void a() {
            this.f6418g.incrementAndGet();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            ((TextWatcher) this.f6417f).afterTextChanged(editable);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i8, int i9, int i10) {
            ((TextWatcher) this.f6417f).beforeTextChanged(charSequence, i8, i9, i10);
        }

        final void c() {
            this.f6418g.decrementAndGet();
        }

        @Override // android.text.SpanWatcher
        public void onSpanAdded(Spannable spannable, Object obj, int i8, int i9) {
            if (this.f6418g.get() > 0 && b(obj)) {
                return;
            }
            ((SpanWatcher) this.f6417f).onSpanAdded(spannable, obj, i8, i9);
        }

        @Override // android.text.SpanWatcher
        public void onSpanChanged(Spannable spannable, Object obj, int i8, int i9, int i10, int i11) {
            if (this.f6418g.get() > 0 && b(obj)) {
                return;
            }
            ((SpanWatcher) this.f6417f).onSpanChanged(spannable, obj, i8, i9, i10, i11);
        }

        @Override // android.text.SpanWatcher
        public void onSpanRemoved(Spannable spannable, Object obj, int i8, int i9) {
            if (this.f6418g.get() > 0 && b(obj)) {
                return;
            }
            ((SpanWatcher) this.f6417f).onSpanRemoved(spannable, obj, i8, i9);
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i8, int i9, int i10) {
            ((TextWatcher) this.f6417f).onTextChanged(charSequence, i8, i9, i10);
        }
    }

    SpannableBuilder(@NonNull Class<?> cls, @NonNull CharSequence charSequence) {
        super(charSequence);
        this.f6416g = new ArrayList();
        Preconditions.h(cls, "watcherClass cannot be null");
        this.f6415f = cls;
    }

    private void b() {
        for (int i8 = 0; i8 < this.f6416g.size(); i8++) {
            this.f6416g.get(i8).a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SpannableBuilder c(@NonNull Class<?> cls, @NonNull CharSequence charSequence) {
        return new SpannableBuilder(cls, charSequence);
    }

    private void e() {
        for (int i8 = 0; i8 < this.f6416g.size(); i8++) {
            this.f6416g.get(i8).onTextChanged(this, 0, length(), length());
        }
    }

    private WatcherWrapper f(Object obj) {
        for (int i8 = 0; i8 < this.f6416g.size(); i8++) {
            WatcherWrapper watcherWrapper = this.f6416g.get(i8);
            if (watcherWrapper.f6417f == obj) {
                return watcherWrapper;
            }
        }
        return null;
    }

    private boolean g(@NonNull Class<?> cls) {
        if (this.f6415f == cls) {
            return true;
        }
        return false;
    }

    private boolean h(Object obj) {
        if (obj != null && g(obj.getClass())) {
            return true;
        }
        return false;
    }

    private void i() {
        for (int i8 = 0; i8 < this.f6416g.size(); i8++) {
            this.f6416g.get(i8).c();
        }
    }

    public void a() {
        b();
    }

    public void d() {
        i();
        e();
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int getSpanEnd(Object obj) {
        WatcherWrapper f8;
        if (h(obj) && (f8 = f(obj)) != null) {
            obj = f8;
        }
        return super.getSpanEnd(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int getSpanFlags(Object obj) {
        WatcherWrapper f8;
        if (h(obj) && (f8 = f(obj)) != null) {
            obj = f8;
        }
        return super.getSpanFlags(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int getSpanStart(Object obj) {
        WatcherWrapper f8;
        if (h(obj) && (f8 = f(obj)) != null) {
            obj = f8;
        }
        return super.getSpanStart(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public <T> T[] getSpans(int i8, int i9, Class<T> cls) {
        if (g(cls)) {
            WatcherWrapper[] watcherWrapperArr = (WatcherWrapper[]) super.getSpans(i8, i9, WatcherWrapper.class);
            T[] tArr = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, watcherWrapperArr.length));
            for (int i10 = 0; i10 < watcherWrapperArr.length; i10++) {
                tArr[i10] = watcherWrapperArr[i10].f6417f;
            }
            return tArr;
        }
        return (T[]) super.getSpans(i8, i9, cls);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int nextSpanTransition(int i8, int i9, Class cls) {
        if (g(cls)) {
            cls = WatcherWrapper.class;
        }
        return super.nextSpanTransition(i8, i9, cls);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public void removeSpan(Object obj) {
        WatcherWrapper watcherWrapper;
        if (h(obj)) {
            watcherWrapper = f(obj);
            if (watcherWrapper != null) {
                obj = watcherWrapper;
            }
        } else {
            watcherWrapper = null;
        }
        super.removeSpan(obj);
        if (watcherWrapper != null) {
            this.f6416g.remove(watcherWrapper);
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public void setSpan(Object obj, int i8, int i9, int i10) {
        if (h(obj)) {
            WatcherWrapper watcherWrapper = new WatcherWrapper(obj);
            this.f6416g.add(watcherWrapper);
            obj = watcherWrapper;
        }
        super.setSpan(obj, i8, i9, i10);
    }

    @Override // android.text.SpannableStringBuilder, java.lang.CharSequence
    public CharSequence subSequence(int i8, int i9) {
        return new SpannableBuilder(this.f6415f, this, i8, i9);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public SpannableStringBuilder delete(int i8, int i9) {
        super.delete(i8, i9);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public SpannableStringBuilder insert(int i8, CharSequence charSequence) {
        super.insert(i8, charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public SpannableStringBuilder replace(int i8, int i9, CharSequence charSequence) {
        b();
        super.replace(i8, i9, charSequence);
        i();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public SpannableStringBuilder insert(int i8, CharSequence charSequence, int i9, int i10) {
        super.insert(i8, charSequence, i9, i10);
        return this;
    }

    SpannableBuilder(@NonNull Class<?> cls, @NonNull CharSequence charSequence, int i8, int i9) {
        super(charSequence, i8, i9);
        this.f6416g = new ArrayList();
        Preconditions.h(cls, "watcherClass cannot be null");
        this.f6415f = cls;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public SpannableStringBuilder replace(int i8, int i9, CharSequence charSequence, int i10, int i11) {
        b();
        super.replace(i8, i9, charSequence, i10, i11);
        i();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public SpannableStringBuilder append(CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public SpannableStringBuilder append(char c8) {
        super.append(c8);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public SpannableStringBuilder append(CharSequence charSequence, int i8, int i9) {
        super.append(charSequence, i8, i9);
        return this;
    }

    @Override // android.text.SpannableStringBuilder
    public SpannableStringBuilder append(CharSequence charSequence, Object obj, int i8) {
        super.append(charSequence, obj, i8);
        return this;
    }
}
