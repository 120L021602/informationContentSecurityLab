package com.example.EncryptedTrafficRecognition.controller;


import com.example.EncryptedTrafficRecognition.dao.ComPortStaRepository;
import com.example.EncryptedTrafficRecognition.dao.ComProStaRepository;
import com.example.EncryptedTrafficRecognition.dao.EncMsgRepository;
import com.example.EncryptedTrafficRecognition.domain.ComPortSta;
import com.example.EncryptedTrafficRecognition.domain.ComProSta;
import com.example.EncryptedTrafficRecognition.domain.EncryptedMessage;
import com.example.EncryptedTrafficRecognition.response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    EncMsgRepository encMsgRepository;

    @Autowired
    ComProStaRepository comProStaRepository;

    @Autowired
    ComPortStaRepository comPortStaRepository;

    //从崔子那里接收数据
    @PostMapping("/api/receive_data")
    public @ResponseBody Response receiveData(@RequestParam String protocol,
                                              @RequestParam Integer port,
                                              @RequestParam String catalogue){
        Response response = new Response();
        EncryptedMessage encMsg = new EncryptedMessage();
        encMsg.setProtocol(protocol);
        encMsg.setPort(port);
        encMsg.setCatalogue(catalogue);
        encMsgRepository.save(encMsg);
        response.setSuccess(true);
        response.setMsg("Successfully received your data!");
        return response;
    }

    ///端口信息
    @GetMapping("/api/port_information")
    public @ResponseBody portResponse portInformation(){
        portResponse portResponse = new portResponse();
        //给portList和idList赋值
        List<EncryptedMessage> encMsgList = encMsgRepository.findAll();
        for(EncryptedMessage encMsg : encMsgList){
            portResponse.addIdList(encMsg.getId());
            portResponse.addPortList(encMsg.getPort());
        }
        portResponse.setSuccess(true);
        portResponse.setMsg("Successfully returned the information of ports.");
        return portResponse;
    }

    //常用端口统计
    @GetMapping("/api/port_statistics")
    public @ResponseBody portStaResponse portStatistics(){
        portStaResponse portStaResponse = new portStaResponse();
        //统计常用端口信息
        ComPortSta comPortSta = new ComPortSta();
        comPortSta.setId(1);
        int cnt = 0;

        List<EncryptedMessage> list_20 = encMsgRepository.findAllByPort(20);
        cnt = list_20.size();
        comPortSta.setPort_20(cnt);

        List<EncryptedMessage> list_21 = encMsgRepository.findAllByPort(21);
        cnt = list_21.size();
        comPortSta.setPort_21(cnt);

        List<EncryptedMessage> list_23 = encMsgRepository.findAllByPort(23);
        cnt = list_23.size();
        comPortSta.setPort_23(cnt);

        List<EncryptedMessage> list_25 = encMsgRepository.findAllByPort(25);
        cnt = list_25.size();
        comPortSta.setPort_25(cnt);

        List<EncryptedMessage> list_123 = encMsgRepository.findAllByPort(123);
        cnt = list_123.size();
        comPortSta.setPort_123(cnt);

        List<EncryptedMessage> list_443 = encMsgRepository.findAllByPort(443);
        cnt = list_443.size();
        comPortSta.setPort_443(cnt);

        List<EncryptedMessage> list_161 = encMsgRepository.findAllByPort(161);
        cnt = list_161.size();
        comPortSta.setPort_161(cnt);

        List<EncryptedMessage> list_3389 = encMsgRepository.findAllByPort(3389);
        cnt = list_3389.size();
        comPortSta.setPort_3389(cnt);

        List<EncryptedMessage> list_53 = encMsgRepository.findAllByPort(53);
        cnt = list_53.size();
        comPortSta.setPort_53(cnt);

        List<EncryptedMessage> list_5060 = encMsgRepository.findAllByPort(5060);
        cnt = list_5060.size();
        comPortSta.setPort_5060(cnt);

        List<EncryptedMessage> list_67 = encMsgRepository.findAllByPort(67);
        cnt = list_67.size();
        comPortSta.setPort_67(cnt);

        List<EncryptedMessage> list_68 = encMsgRepository.findAllByPort(68);
        cnt = list_68.size();
        comPortSta.setPort_68(cnt);

        List<EncryptedMessage> list_69 = encMsgRepository.findAllByPort(69);
        cnt = list_69.size();
        comPortSta.setPort_69(cnt);

        List<EncryptedMessage> list_80 = encMsgRepository.findAllByPort(80);
        cnt = list_80.size();
        comPortSta.setPort_80(cnt);

        List<EncryptedMessage> list_110 = encMsgRepository.findAllByPort(110);
        cnt = list_110.size();
        comPortSta.setPort_110(cnt);

        List<EncryptedMessage> list_22 = encMsgRepository.findAllByPort(22);
        cnt = list_22.size();
        comPortSta.setPort_22(cnt);

        List<EncryptedMessage> list_143 = encMsgRepository.findAllByPort(143);
        cnt = list_143.size();
        comPortSta.setPort_143(cnt);

        comPortStaRepository.save(comPortSta);

        portStaResponse.setComPortSta(comPortSta);
        portStaResponse.setSuccess(true);
        portStaResponse.setMsg("Successfully returned the statistics of common ports.");
        return portStaResponse;
    }

    //协议信息
    @GetMapping("/api/protocol_information")
    public @ResponseBody protocolResponse protocolInformation(){
        protocolResponse protocolResponse = new protocolResponse();
        //给protocolList和idList赋值
        List<EncryptedMessage> encMsgList = encMsgRepository.findAll();
        for(EncryptedMessage encMsg : encMsgList){
            protocolResponse.addIdList(encMsg.getId());
            protocolResponse.addProtocolList(encMsg.getProtocol());
        }
        protocolResponse.setSuccess(true);
        protocolResponse.setMsg("Successfully returned the information of protocol.");
        return protocolResponse;
    }

    //常用协议统计
    @GetMapping("/api/protocol_statistics")
    public @ResponseBody proStaResponse protocolStatistics(){
        proStaResponse proStaResponse = new proStaResponse();
        ComProSta comProSta = new ComProSta();
        comProSta.setId(1);
        int cnt = 0;

        List<EncryptedMessage> tcpList = encMsgRepository.findAllByProtocol("tcp");
        cnt = tcpList.size();
        comProSta.setTcp(cnt);

        List<EncryptedMessage> udpList = encMsgRepository.findAllByProtocol("udp");
        cnt = udpList.size();
        comProSta.setUdp(cnt);

        List<EncryptedMessage> sctpList = encMsgRepository.findAllByProtocol("sctp");
        cnt = sctpList.size();
        comProSta.setSctp(cnt);

        List<EncryptedMessage> dccpList = encMsgRepository.findAllByProtocol("dccp");
        cnt = dccpList.size();
        comProSta.setDccp(cnt);

        List<EncryptedMessage> rsvpList = encMsgRepository.findAllByProtocol("rsvp");
        cnt = rsvpList.size();
        comProSta.setRsvp(cnt);

        List<EncryptedMessage> rudpList = encMsgRepository.findAllByProtocol("rudp");
        cnt = rudpList.size();
        comProSta.setRudp(cnt);

        List<EncryptedMessage> tlsList = encMsgRepository.findAllByProtocol("tls");
        cnt = tlsList.size();
        comProSta.setTls(cnt);

        List<EncryptedMessage> quicList = encMsgRepository.findAllByProtocol("quic");
        cnt = quicList.size();
        comProSta.setQuic(cnt);

        List<EncryptedMessage> spxList = encMsgRepository.findAllByProtocol("spx");
        cnt = spxList.size();
        comProSta.setSpx(cnt);

        List<EncryptedMessage> mptcpList = encMsgRepository.findAllByProtocol("mptcp");
        cnt = mptcpList.size();
        comProSta.setMptcp(cnt);

        comProStaRepository.save(comProSta);
        proStaResponse.setComProSta(comProSta);
        proStaResponse.setSuccess(true);
        proStaResponse.setMsg("Successfully returned the statistics of common protocol.");
        return proStaResponse;
    }

    @GetMapping("/api/comprehensive_display")
    public @ResponseBody compResponse compDisplay(){
        compResponse compResponse = new compResponse();
        List<EncryptedMessage> encMsgList = encMsgRepository.findAll();
        compResponse.setEncMsgList(encMsgList);
        compResponse.setSuccess(true);
        compResponse.setMsg("Successfully returned the comprehensive information of encrypted messages.");
        return compResponse;
    }
}
