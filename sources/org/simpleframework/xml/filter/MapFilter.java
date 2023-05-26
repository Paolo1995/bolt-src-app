package org.simpleframework.xml.filter;

import java.util.Map;

/* loaded from: classes5.dex */
public class MapFilter implements Filter {
    private Filter filter;
    private Map map;

    public MapFilter(Map map) {
        this(map, null);
    }

    @Override // org.simpleframework.xml.filter.Filter
    public String replace(String str) {
        Object obj;
        Map map = this.map;
        if (map != null) {
            obj = map.get(str);
        } else {
            obj = null;
        }
        if (obj != null) {
            return obj.toString();
        }
        Filter filter = this.filter;
        if (filter == null) {
            return null;
        }
        return filter.replace(str);
    }

    public MapFilter(Map map, Filter filter) {
        this.filter = filter;
        this.map = map;
    }
}
