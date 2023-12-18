package org.liulinger.Service.admin;

import java.util.List;

public interface ItemListService<T> {
    List<T> getItems(int offset, int limit);

    int getTotalItems();

}
