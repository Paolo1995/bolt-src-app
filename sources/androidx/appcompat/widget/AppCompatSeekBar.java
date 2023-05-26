package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.annotation.NonNull;
import androidx.appcompat.R$attr;

/* loaded from: classes.dex */
public class AppCompatSeekBar extends SeekBar {

    /* renamed from: f  reason: collision with root package name */
    private final AppCompatSeekBarHelper f1884f;

    public AppCompatSeekBar(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.J);
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        this.f1884f.h();
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        this.f1884f.i();
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f1884f.g(canvas);
    }

    public AppCompatSeekBar(@NonNull Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        ThemeUtils.a(this, getContext());
        AppCompatSeekBarHelper appCompatSeekBarHelper = new AppCompatSeekBarHelper(this);
        this.f1884f = appCompatSeekBarHelper;
        appCompatSeekBarHelper.c(attributeSet, i8);
    }
}
