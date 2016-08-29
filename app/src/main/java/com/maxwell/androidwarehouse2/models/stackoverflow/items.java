package com.maxwell.androidwarehouse2.models.stackoverflow;

import java.util.List;

/**
 * Created by Maxwell on 15/08/2016.
 */
public class items<T> {
    List<T> items;
    String has_more;
    int quota_max;
    int quota_remaining;

    public List<T> getItems() {
        return items;
    }
}
