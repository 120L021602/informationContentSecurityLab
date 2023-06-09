package com.example.EncryptedTrafficRecognition.request;


import lombok.Data;

import java.util.List;
@Data
public class ReceiveDataRequest {

    private List<SinglePacket> packets;
}
