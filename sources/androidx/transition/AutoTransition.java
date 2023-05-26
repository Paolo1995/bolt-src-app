package androidx.transition;

/* loaded from: classes.dex */
public class AutoTransition extends TransitionSet {
    public AutoTransition() {
        y0();
    }

    private void y0() {
        v0(1);
        n0(new Fade(2)).n0(new ChangeBounds()).n0(new Fade(1));
    }
}
