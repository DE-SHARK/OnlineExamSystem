package org.liulinger.Service;

import org.liulinger.Bean.UserBean;

import java.util.List;

public interface UserListService {
    List<UserBean> getUsers(int offset, int limit);

    int getTotalUsers();

}
