<script>
import axios from 'axios'
import {mapState,mapActions} from 'pinia'
import {useStore} from '../stores/store.js'



export default{
    
    setup(){
        const store = useStore();
        return {store};
    },

    data(){
        return{
            proInfo: [],
            proSta: [],
            portInfo: [],
            portSta: [],
            compDis: []
        }
    },

    methods:{
        showProInfo(){
            this.store.type = 'showProInfo';
            axios.get("http://localhost:12345/api/protocol_information")
            .then(res => {
                console.log(res);
                var success = res.data.success;
                if(success){
                    var idList = res.data.idList;
                    var proList = res.data.protocolList;
                    for(var i = 0; i < idList.length; i ++){
                        this.proInfo.push({id : idList[i], protocol : proList[i]});
                    }
                    this.store.proInfo = this.proInfo;
                }
                else {
                    console.log("Error occurred.");
                }
            }, err => {
                console.log(err);
            })
        },
        
        showProSta(){
            this.store.type = 'showProSta';
            axios.get("http://localhost:12345/api/protocol_statistics")
            .then(res => {
                console.log(res);
                var success = res.data.success;
                if(success){
                    
                    
                }
                else {
                    console.log("Error occurred.");
                }
            }, err => {
                console.log(err);
            })
        },
        
        showPortInfo() {
            this.store.type = 'showPortInfo';
            axios.get("http://localhost:12345/api/port_information")
            .then(res => {
                console.log(res);
                var success = res.data.success;
                if(success){
                    var idList = res.data.idList;
                    var portList = res.data.portList;
                    for(var i = 0; i < idList.length; i ++){
                        this.portInfo.push({id : idList[i], port : portList[i]});
                    }
                    this.store.portInfo = this.portInfo;
                }
                else {
                    console.log("Error occurred.");
                }
            }, err => {
                console.log(err);
            })


        },
        
        showPortSta(){
            this.store.type = 'showPortSta';
            axios.get("http://localhost:12345/api/port_statistics")
            .then(res => {
                console.log(res);
                var success = res.data.success;
                if(success){
                    var comPortSta = res.data.comPortSta;
                    for(var v in comPortSta){
                        this.store.portXData.push(v);
                        this.store.portYdata.push(comPortSta[v]);
                    }
                }
                else {
                    console.log("Error occurred.");
                }
            }, err => {
                console.log(err);
            })
        },
        
        showCompDisplay(){
            this.store.type = 'compDisplay';
            axios.get("http://localhost:12345/api/comprehensive_display")
            .then(res => {
                console.log(res);
                var success = res.data.success;
                if(success){
                    var encMsgList = res.data.encMsgList;
                    console.log(encMsgList);
                    for(var i = 0; i < encMsgList.length; i ++){
                        this.compDis.push({id : encMsgList[i].id, catalogue : encMsgList[i].catalogue,
                        port : encMsgList[i].port, protocol : encMsgList[i].protocol});
                    }
                    this.store.compDis = this.compDis;
                }
                else {
                    console.log("Error occurred.");
                }
            }, err => {
                console.log(err);
            })
        }
    }
    
}
    

</script>

<template>
    <div id="aside">
        <el-text class="mx-1" type="primary">功能展示</el-text>
        <div id="inner">
            <el-button class="button" type="primary" plain @click="showProInfo">展示协议信息</el-button>
            <el-button class="button" type="primary" plain @click="showProSta">常用协议统计</el-button>
            <el-button class="button" type="primary" plain @click="showPortInfo">展示端口信息</el-button>
            <el-button class="button" type="primary" plain @click="showPortSta">常用端口统计</el-button>
            <el-button class="button" type="primary" plain @click="showCompDisplay">综合结果展示</el-button>
        </div>
    </div>
</template>

<style scoped>
    #aside{
        display: flex;
        flex-direction: column;
        width: 200px;
        height: calc(90vh);
        background-color: #67C23A;
        border-radius: 15px;
        margin-top: 10px;
        justify-content: space-between;
    }
    .button{
        display: flex;
        justify-content: center;
        /* align-items: center; */
        margin-top: 10px;
        margin-bottom: 10px;
        margin-left: 30px !important;
        margin-right: 30px !important;
        border-radius: 10px;
        width: 140px;
        height: 50px;
        color: black;
        background-color: rgba(195, 189, 158, 0.867);
        /* font-weight: bold; */
    }
    .mx-1{
        margin-top: 0;
        height: 80px;
        width: 100%;
        background-color: #F56C6C;
        border-radius:15px;
        line-height: 80px;
        color:black;
        font-weight: bold;
    }
    #inner{
        display: flex;
        flex-direction: column;
        justify-content: space-evenly;
        align-items: center;
        height: 600px;
        background-color: #73e48f;
        /* margin-left: 15px;
        margin-right: 15px; */
        border-radius: 10px;
    }
</style>