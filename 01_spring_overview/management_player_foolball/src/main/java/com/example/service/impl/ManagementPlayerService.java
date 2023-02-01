package com.example.service.impl;

import com.example.model.Player;
import com.example.service.IManagementPlayerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ManagementPlayerService implements IManagementPlayerService {

    public static List<Player> playerList;

    static {
        playerList = new ArrayList<>();
        playerList.add(new Player(1, "Nguyễn Văn Thành", "15/02/1997", "2 năm", "Tiền đạo","https://img.meta.com.vn/Data/image/2021/09/21/hinh-anh-cho-con-3.jpg"));
        playerList.add(new Player(2, "Nguyễn Văn Huy", "15/02/2000", "1 năm", "Hậu vệ","https://img.meta.com.vn/Data/image/2021/09/21/hinh-anh-cho-con-3.jpg"));
        playerList.add(new Player(3, "Trần Bá Tài", "22/02/2004", "3 năm", "Tiền đạo","https://img.meta.com.vn/Data/image/2021/09/21/hinh-anh-cho-con-3.jpg"));
        playerList.add(new Player(4, "Nguyễn Thiện Phúc", "09/02/1999", "5 tháng", "Hậu vệ","https://img.meta.com.vn/Data/image/2021/09/21/hinh-anh-cho-con-3.jpg"));
    }

    @Override
    public List<Player> findAll() {
        return playerList;
    }
}
