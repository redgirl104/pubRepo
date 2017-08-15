package com.redgirl104.Thrift;

import org.apache.thrift.TException;

import com.redgirl104.Thrift.userserver.User;
import com.redgirl104.Thrift.userserver.UserService;

public class UserServiceImpl implements UserService.Iface {
	@Override
    public User find() throws TException {
        User user = new User();
        user.setName("HenryXi");
        user.setAge(27);
        return user;
    }
}
