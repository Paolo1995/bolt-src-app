package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.annotation.NonNull;
import androidx.core.util.Pair;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R$id;
import com.google.android.material.internal.ViewUtils;
import java.util.Calendar;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class MaterialCalendarGridView extends GridView {

    /* renamed from: f  reason: collision with root package name */
    private final Calendar f13315f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f13316g;

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(int i8, Rect rect) {
        if (i8 == 33) {
            setSelection(getAdapter2().m());
        } else if (i8 == 130) {
            setSelection(getAdapter2().b());
        } else {
            super.onFocusChanged(true, i8, rect);
        }
    }

    private View c(int i8) {
        return getChildAt(i8 - getFirstVisiblePosition());
    }

    private static int d(@NonNull View view) {
        return view.getLeft() + (view.getWidth() / 2);
    }

    private static boolean e(Long l8, Long l9, Long l10, Long l11) {
        if (l8 == null || l9 == null || l10 == null || l11 == null || l10.longValue() > l9.longValue() || l11.longValue() < l8.longValue()) {
            return true;
        }
        return false;
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    @NonNull
    /* renamed from: b */
    public MonthAdapter getAdapter2() {
        return (MonthAdapter) super.getAdapter();
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getAdapter2().notifyDataSetChanged();
    }

    @Override // android.view.View
    protected final void onDraw(@NonNull Canvas canvas) {
        int a8;
        int d8;
        int a9;
        int d9;
        int i8;
        int i9;
        int i10;
        int i11;
        int left;
        int left2;
        MaterialCalendarGridView materialCalendarGridView = this;
        super.onDraw(canvas);
        MonthAdapter adapter2 = getAdapter2();
        DateSelector<?> dateSelector = adapter2.f13362g;
        CalendarStyle calendarStyle = adapter2.f13364i;
        int max = Math.max(adapter2.b(), getFirstVisiblePosition());
        int min = Math.min(adapter2.m(), getLastVisiblePosition());
        Long item = adapter2.getItem(max);
        Long item2 = adapter2.getItem(min);
        Iterator<Pair<Long, Long>> it = dateSelector.k0().iterator();
        while (it.hasNext()) {
            Pair<Long, Long> next = it.next();
            Long l8 = next.f5908a;
            if (l8 != null) {
                if (next.f5909b != null) {
                    long longValue = l8.longValue();
                    long longValue2 = next.f5909b.longValue();
                    if (!e(item, item2, Long.valueOf(longValue), Long.valueOf(longValue2))) {
                        boolean f8 = ViewUtils.f(this);
                        if (longValue < item.longValue()) {
                            if (adapter2.h(max)) {
                                left2 = 0;
                            } else if (!f8) {
                                left2 = materialCalendarGridView.c(max - 1).getRight();
                            } else {
                                left2 = materialCalendarGridView.c(max - 1).getLeft();
                            }
                            d8 = left2;
                            a8 = max;
                        } else {
                            materialCalendarGridView.f13315f.setTimeInMillis(longValue);
                            a8 = adapter2.a(materialCalendarGridView.f13315f.get(5));
                            d8 = d(materialCalendarGridView.c(a8));
                        }
                        if (longValue2 > item2.longValue()) {
                            if (adapter2.i(min)) {
                                left = getWidth();
                            } else if (!f8) {
                                left = materialCalendarGridView.c(min).getRight();
                            } else {
                                left = materialCalendarGridView.c(min).getLeft();
                            }
                            d9 = left;
                            a9 = min;
                        } else {
                            materialCalendarGridView.f13315f.setTimeInMillis(longValue2);
                            a9 = adapter2.a(materialCalendarGridView.f13315f.get(5));
                            d9 = d(materialCalendarGridView.c(a9));
                        }
                        int itemId = (int) adapter2.getItemId(a8);
                        int i12 = max;
                        int i13 = min;
                        int itemId2 = (int) adapter2.getItemId(a9);
                        while (itemId <= itemId2) {
                            int numColumns = getNumColumns() * itemId;
                            MonthAdapter monthAdapter = adapter2;
                            int numColumns2 = (numColumns + getNumColumns()) - 1;
                            View c8 = materialCalendarGridView.c(numColumns);
                            int top = c8.getTop() + calendarStyle.f13265a.c();
                            Iterator<Pair<Long, Long>> it2 = it;
                            int bottom = c8.getBottom() - calendarStyle.f13265a.b();
                            if (!f8) {
                                if (numColumns > a8) {
                                    i10 = 0;
                                } else {
                                    i10 = d8;
                                }
                                if (a9 > numColumns2) {
                                    i11 = getWidth();
                                } else {
                                    i11 = d9;
                                }
                            } else {
                                if (a9 > numColumns2) {
                                    i8 = 0;
                                } else {
                                    i8 = d9;
                                }
                                if (numColumns > a8) {
                                    i9 = getWidth();
                                } else {
                                    i9 = d8;
                                }
                                int i14 = i9;
                                i10 = i8;
                                i11 = i14;
                            }
                            canvas.drawRect(i10, top, i11, bottom, calendarStyle.f13272h);
                            itemId++;
                            materialCalendarGridView = this;
                            itemId2 = itemId2;
                            adapter2 = monthAdapter;
                            it = it2;
                        }
                        materialCalendarGridView = this;
                        max = i12;
                        min = i13;
                    }
                }
            } else {
                materialCalendarGridView = this;
            }
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    protected void onFocusChanged(boolean z7, int i8, Rect rect) {
        if (z7) {
            a(i8, rect);
        } else {
            super.onFocusChanged(false, i8, rect);
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i8, KeyEvent keyEvent) {
        if (!super.onKeyDown(i8, keyEvent)) {
            return false;
        }
        if (getSelectedItemPosition() == -1 || getSelectedItemPosition() >= getAdapter2().b()) {
            return true;
        }
        if (19 != i8) {
            return false;
        }
        setSelection(getAdapter2().b());
        return true;
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i8, int i9) {
        if (this.f13316g) {
            super.onMeasure(i8, View.MeasureSpec.makeMeasureSpec(16777215, Integer.MIN_VALUE));
            getLayoutParams().height = getMeasuredHeight();
            return;
        }
        super.onMeasure(i8, i9);
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public void setSelection(int i8) {
        if (i8 < getAdapter2().b()) {
            super.setSelection(getAdapter2().b());
        } else {
            super.setSelection(i8);
        }
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        this.f13315f = UtcDates.k();
        if (MaterialDatePicker.U(getContext())) {
            setNextFocusLeftId(R$id.cancel_button);
            setNextFocusRightId(R$id.confirm_button);
        }
        this.f13316g = MaterialDatePicker.W(getContext());
        ViewCompat.s0(this, new AccessibilityDelegateCompat() { // from class: com.google.android.material.datepicker.MaterialCalendarGridView.1
            @Override // androidx.core.view.AccessibilityDelegateCompat
            public void g(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.g(view, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.a0(null);
            }
        });
    }

    @Override // android.widget.AdapterView
    public final void setAdapter(ListAdapter listAdapter) {
        if (listAdapter instanceof MonthAdapter) {
            super.setAdapter(listAdapter);
            return;
        }
        throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", MaterialCalendarGridView.class.getCanonicalName(), MonthAdapter.class.getCanonicalName()));
    }
}
