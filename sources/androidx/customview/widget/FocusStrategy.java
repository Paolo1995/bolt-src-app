package androidx.customview.widget;

import android.graphics.Rect;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* loaded from: classes.dex */
class FocusStrategy {

    /* loaded from: classes.dex */
    public interface BoundsAdapter<T> {
        void a(T t7, Rect rect);
    }

    /* loaded from: classes.dex */
    public interface CollectionAdapter<T, V> {
        V a(T t7, int i8);

        int size(T t7);
    }

    /* loaded from: classes.dex */
    private static class SequentialComparator<T> implements Comparator<T> {

        /* renamed from: f  reason: collision with root package name */
        private final Rect f6181f = new Rect();

        /* renamed from: g  reason: collision with root package name */
        private final Rect f6182g = new Rect();

        /* renamed from: h  reason: collision with root package name */
        private final boolean f6183h;

        /* renamed from: i  reason: collision with root package name */
        private final BoundsAdapter<T> f6184i;

        SequentialComparator(boolean z7, BoundsAdapter<T> boundsAdapter) {
            this.f6183h = z7;
            this.f6184i = boundsAdapter;
        }

        @Override // java.util.Comparator
        public int compare(T t7, T t8) {
            Rect rect = this.f6181f;
            Rect rect2 = this.f6182g;
            this.f6184i.a(t7, rect);
            this.f6184i.a(t8, rect2);
            int i8 = rect.top;
            int i9 = rect2.top;
            if (i8 < i9) {
                return -1;
            }
            if (i8 > i9) {
                return 1;
            }
            int i10 = rect.left;
            int i11 = rect2.left;
            if (i10 < i11) {
                if (!this.f6183h) {
                    return -1;
                }
                return 1;
            } else if (i10 > i11) {
                if (this.f6183h) {
                    return -1;
                }
                return 1;
            } else {
                int i12 = rect.bottom;
                int i13 = rect2.bottom;
                if (i12 < i13) {
                    return -1;
                }
                if (i12 > i13) {
                    return 1;
                }
                int i14 = rect.right;
                int i15 = rect2.right;
                if (i14 < i15) {
                    if (!this.f6183h) {
                        return -1;
                    }
                    return 1;
                } else if (i14 > i15) {
                    if (this.f6183h) {
                        return -1;
                    }
                    return 1;
                } else {
                    return 0;
                }
            }
        }
    }

    private FocusStrategy() {
    }

    private static boolean a(int i8, @NonNull Rect rect, @NonNull Rect rect2, @NonNull Rect rect3) {
        boolean b8 = b(i8, rect, rect2);
        if (b(i8, rect, rect3) || !b8) {
            return false;
        }
        if (j(i8, rect, rect3) && i8 != 17 && i8 != 66 && k(i8, rect, rect2) >= m(i8, rect, rect3)) {
            return false;
        }
        return true;
    }

    private static boolean b(int i8, @NonNull Rect rect, @NonNull Rect rect2) {
        if (i8 != 17) {
            if (i8 != 33) {
                if (i8 != 66) {
                    if (i8 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            if (rect2.right >= rect.left && rect2.left <= rect.right) {
                return true;
            }
            return false;
        }
        if (rect2.bottom >= rect.top && rect2.top <= rect.bottom) {
            return true;
        }
        return false;
    }

    public static <L, T> T c(@NonNull L l8, @NonNull CollectionAdapter<L, T> collectionAdapter, @NonNull BoundsAdapter<T> boundsAdapter, T t7, @NonNull Rect rect, int i8) {
        Rect rect2 = new Rect(rect);
        if (i8 != 17) {
            if (i8 != 33) {
                if (i8 != 66) {
                    if (i8 == 130) {
                        rect2.offset(0, -(rect.height() + 1));
                    } else {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                } else {
                    rect2.offset(-(rect.width() + 1), 0);
                }
            } else {
                rect2.offset(0, rect.height() + 1);
            }
        } else {
            rect2.offset(rect.width() + 1, 0);
        }
        T t8 = null;
        int size = collectionAdapter.size(l8);
        Rect rect3 = new Rect();
        for (int i9 = 0; i9 < size; i9++) {
            T a8 = collectionAdapter.a(l8, i9);
            if (a8 != t7) {
                boundsAdapter.a(a8, rect3);
                if (h(i8, rect, rect3, rect2)) {
                    rect2.set(rect3);
                    t8 = a8;
                }
            }
        }
        return t8;
    }

    public static <L, T> T d(@NonNull L l8, @NonNull CollectionAdapter<L, T> collectionAdapter, @NonNull BoundsAdapter<T> boundsAdapter, T t7, int i8, boolean z7, boolean z8) {
        int size = collectionAdapter.size(l8);
        ArrayList arrayList = new ArrayList(size);
        for (int i9 = 0; i9 < size; i9++) {
            arrayList.add(collectionAdapter.a(l8, i9));
        }
        Collections.sort(arrayList, new SequentialComparator(z7, boundsAdapter));
        if (i8 != 1) {
            if (i8 == 2) {
                return (T) e(t7, arrayList, z8);
            }
            throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD}.");
        }
        return (T) f(t7, arrayList, z8);
    }

    private static <T> T e(T t7, ArrayList<T> arrayList, boolean z7) {
        int lastIndexOf;
        int size = arrayList.size();
        if (t7 == null) {
            lastIndexOf = -1;
        } else {
            lastIndexOf = arrayList.lastIndexOf(t7);
        }
        int i8 = lastIndexOf + 1;
        if (i8 < size) {
            return arrayList.get(i8);
        }
        if (z7 && size > 0) {
            return arrayList.get(0);
        }
        return null;
    }

    private static <T> T f(T t7, ArrayList<T> arrayList, boolean z7) {
        int indexOf;
        int size = arrayList.size();
        if (t7 == null) {
            indexOf = size;
        } else {
            indexOf = arrayList.indexOf(t7);
        }
        int i8 = indexOf - 1;
        if (i8 >= 0) {
            return arrayList.get(i8);
        }
        if (z7 && size > 0) {
            return arrayList.get(size - 1);
        }
        return null;
    }

    private static int g(int i8, int i9) {
        return (i8 * 13 * i8) + (i9 * i9);
    }

    private static boolean h(int i8, @NonNull Rect rect, @NonNull Rect rect2, @NonNull Rect rect3) {
        if (!i(rect, rect2, i8)) {
            return false;
        }
        if (!i(rect, rect3, i8) || a(i8, rect, rect2, rect3)) {
            return true;
        }
        if (a(i8, rect, rect3, rect2) || g(k(i8, rect, rect2), o(i8, rect, rect2)) >= g(k(i8, rect, rect3), o(i8, rect, rect3))) {
            return false;
        }
        return true;
    }

    private static boolean i(@NonNull Rect rect, @NonNull Rect rect2, int i8) {
        if (i8 != 17) {
            if (i8 != 33) {
                if (i8 != 66) {
                    if (i8 == 130) {
                        int i9 = rect.top;
                        int i10 = rect2.top;
                        if ((i9 < i10 || rect.bottom <= i10) && rect.bottom < rect2.bottom) {
                            return true;
                        }
                        return false;
                    }
                    throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                }
                int i11 = rect.left;
                int i12 = rect2.left;
                if ((i11 < i12 || rect.right <= i12) && rect.right < rect2.right) {
                    return true;
                }
                return false;
            }
            int i13 = rect.bottom;
            int i14 = rect2.bottom;
            if ((i13 > i14 || rect.top >= i14) && rect.top > rect2.top) {
                return true;
            }
            return false;
        }
        int i15 = rect.right;
        int i16 = rect2.right;
        if ((i15 > i16 || rect.left >= i16) && rect.left > rect2.left) {
            return true;
        }
        return false;
    }

    private static boolean j(int i8, @NonNull Rect rect, @NonNull Rect rect2) {
        if (i8 != 17) {
            if (i8 != 33) {
                if (i8 != 66) {
                    if (i8 == 130) {
                        if (rect.bottom <= rect2.top) {
                            return true;
                        }
                        return false;
                    }
                    throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                } else if (rect.right <= rect2.left) {
                    return true;
                } else {
                    return false;
                }
            } else if (rect.top >= rect2.bottom) {
                return true;
            } else {
                return false;
            }
        } else if (rect.left >= rect2.right) {
            return true;
        } else {
            return false;
        }
    }

    private static int k(int i8, @NonNull Rect rect, @NonNull Rect rect2) {
        return Math.max(0, l(i8, rect, rect2));
    }

    private static int l(int i8, @NonNull Rect rect, @NonNull Rect rect2) {
        int i9;
        int i10;
        if (i8 != 17) {
            if (i8 != 33) {
                if (i8 != 66) {
                    if (i8 == 130) {
                        i9 = rect2.top;
                        i10 = rect.bottom;
                    } else {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                } else {
                    i9 = rect2.left;
                    i10 = rect.right;
                }
            } else {
                i9 = rect.top;
                i10 = rect2.bottom;
            }
        } else {
            i9 = rect.left;
            i10 = rect2.right;
        }
        return i9 - i10;
    }

    private static int m(int i8, @NonNull Rect rect, @NonNull Rect rect2) {
        return Math.max(1, n(i8, rect, rect2));
    }

    private static int n(int i8, @NonNull Rect rect, @NonNull Rect rect2) {
        int i9;
        int i10;
        if (i8 != 17) {
            if (i8 != 33) {
                if (i8 != 66) {
                    if (i8 == 130) {
                        i9 = rect2.bottom;
                        i10 = rect.bottom;
                    } else {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                } else {
                    i9 = rect2.right;
                    i10 = rect.right;
                }
            } else {
                i9 = rect.top;
                i10 = rect2.top;
            }
        } else {
            i9 = rect.left;
            i10 = rect2.left;
        }
        return i9 - i10;
    }

    private static int o(int i8, @NonNull Rect rect, @NonNull Rect rect2) {
        if (i8 != 17) {
            if (i8 != 33) {
                if (i8 != 66) {
                    if (i8 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return Math.abs((rect.left + (rect.width() / 2)) - (rect2.left + (rect2.width() / 2)));
        }
        return Math.abs((rect.top + (rect.height() / 2)) - (rect2.top + (rect2.height() / 2)));
    }
}
