package com.ticketgo.service.impl;

import com.ticketgo.common.Result;
import com.ticketgo.entity.Movie;
import com.ticketgo.entity.Seat;
import com.ticketgo.entity.Showing;
import com.ticketgo.entity.Theather;
import com.ticketgo.mapper.SeatMapper;
import com.ticketgo.mapper.TheatherMapper;
import com.ticketgo.service.SeatService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ticketgo.service.TheatherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2023-11-02
 */
@Service
@Slf4j
public class SeatServiceImpl extends ServiceImpl<SeatMapper, Seat> implements SeatService {
    @Autowired
    private TheatherService theatherService;

/*
    @Autowired
    private TheatherMapper theatherMapper;*/

    /**
     * 生成座位
     * @param showing
     */
    @Override
    public void generateSeat(Showing showing){

        //1. 获取showing_id
        Long showingId = showing.getShowingId();
        //2.showing 获取theater
        Long theatherId = showing.getTheatherId();

        //3. theater获取row,col
        Theather theater = this.theatherService.getById(theatherId);

        //4. 循环生成seat的index
        int row = theater.getRow();
        int col = theater.getCol();
        int count=0;
        for (int i=1;i<=row;i++){
            for (int j=1;j<=col;j++){
                Seat seat = new Seat();
                seat.setRowIndex(i);
                seat.setColIndex(j);
                seat.setStatus(1);
                seat.setShowingId(showingId);
                log.info("新增座位 "+seat);
                count++;
                this.save(seat);
            }
        }
        System.out.println("生成座位数："+count);

    }


}
