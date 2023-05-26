package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class CardViewApi21Impl implements CardViewImpl {
    private RoundRectDrawable p(CardViewDelegate cardViewDelegate) {
        return (RoundRectDrawable) cardViewDelegate.d();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void a(CardViewDelegate cardViewDelegate, float f8) {
        p(cardViewDelegate).h(f8);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float b(CardViewDelegate cardViewDelegate) {
        return p(cardViewDelegate).d();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void c(CardViewDelegate cardViewDelegate, float f8) {
        cardViewDelegate.f().setElevation(f8);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float d(CardViewDelegate cardViewDelegate) {
        return p(cardViewDelegate).c();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public ColorStateList e(CardViewDelegate cardViewDelegate) {
        return p(cardViewDelegate).b();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float f(CardViewDelegate cardViewDelegate) {
        return b(cardViewDelegate) * 2.0f;
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void g(CardViewDelegate cardViewDelegate) {
        o(cardViewDelegate, d(cardViewDelegate));
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void h(CardViewDelegate cardViewDelegate, Context context, ColorStateList colorStateList, float f8, float f9, float f10) {
        cardViewDelegate.b(new RoundRectDrawable(colorStateList, f8));
        View f11 = cardViewDelegate.f();
        f11.setClipToOutline(true);
        f11.setElevation(f9);
        o(cardViewDelegate, f10);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float i(CardViewDelegate cardViewDelegate) {
        return cardViewDelegate.f().getElevation();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void j(CardViewDelegate cardViewDelegate) {
        o(cardViewDelegate, d(cardViewDelegate));
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void k(CardViewDelegate cardViewDelegate) {
        if (!cardViewDelegate.c()) {
            cardViewDelegate.a(0, 0, 0, 0);
            return;
        }
        float d8 = d(cardViewDelegate);
        float b8 = b(cardViewDelegate);
        int ceil = (int) Math.ceil(RoundRectDrawableWithShadow.a(d8, b8, cardViewDelegate.e()));
        int ceil2 = (int) Math.ceil(RoundRectDrawableWithShadow.b(d8, b8, cardViewDelegate.e()));
        cardViewDelegate.a(ceil, ceil2, ceil, ceil2);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void l() {
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float m(CardViewDelegate cardViewDelegate) {
        return b(cardViewDelegate) * 2.0f;
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void n(CardViewDelegate cardViewDelegate, ColorStateList colorStateList) {
        p(cardViewDelegate).f(colorStateList);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void o(CardViewDelegate cardViewDelegate, float f8) {
        p(cardViewDelegate).g(f8, cardViewDelegate.c(), cardViewDelegate.e());
        k(cardViewDelegate);
    }
}
