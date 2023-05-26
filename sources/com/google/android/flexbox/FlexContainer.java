package com.google.android.flexbox;

import android.view.View;
import java.util.List;

/* loaded from: classes.dex */
interface FlexContainer {
    void b(View view, int i8, int i9, FlexLine flexLine);

    int c(int i8, int i9, int i10);

    View e(int i8);

    int f(int i8, int i9, int i10);

    int g(View view);

    int getAlignContent();

    int getAlignItems();

    int getFlexDirection();

    int getFlexItemCount();

    List<FlexLine> getFlexLinesInternal();

    int getFlexWrap();

    int getLargestMainSize();

    int getMaxLine();

    int getPaddingBottom();

    int getPaddingEnd();

    int getPaddingLeft();

    int getPaddingRight();

    int getPaddingStart();

    int getPaddingTop();

    int getSumOfCrossSize();

    void h(FlexLine flexLine);

    View i(int i8);

    void j(int i8, View view);

    int k(View view, int i8, int i9);

    boolean l();

    void setFlexLines(List<FlexLine> list);
}
