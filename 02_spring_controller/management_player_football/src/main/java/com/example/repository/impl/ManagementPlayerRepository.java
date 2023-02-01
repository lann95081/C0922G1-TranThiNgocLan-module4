package com.example.repository.impl;

import com.example.model.Player;
import com.example.repository.IManagementPlayerRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ManagementPlayerRepository implements IManagementPlayerRepository {

    private static final Map<Integer, Player> playerList;

    static {
        playerList = new HashMap<>();
        playerList.put(1, new Player(1, "Nguyễn Văn Thành", "15/02/1997", "2 năm", "Tiền đạo", "https://img.meta.com.vn/Data/image/2021/09/21/hinh-anh-cho-con-3.jpg"));
        playerList.put(2, new Player(2, "Nguyễn Văn Huy", "15/02/2000", "1 năm", "Hậu vệ", "https://img.meta.com.vn/Data/image/2021/09/21/hinh-anh-cho-con-3.jpg"));
        playerList.put(3, new Player(3, "Trần Bá Tài", "22/02/2004", "3 năm", "Tiền đạo", "https://img.meta.com.vn/Data/image/2021/09/21/hinh-anh-cho-con-3.jpg"));
        playerList.put(4, new Player(4, "Nguyễn Thiện Phúc", "09/02/1999", "5 tháng", "Hậu vệ", "https://img.meta.com.vn/Data/image/2021/09/21/hinh-anh-cho-con-3.jpg"));

    }

    @Override
    public List<Player> findAll() {
        return new ArrayList<>(playerList.values());
    }

    @Override
    public void delete(int id) {
        playerList.remove(id);
    }

    @Override
    public Player findById(int id) {
        return playerList.get(id);
    }
}
