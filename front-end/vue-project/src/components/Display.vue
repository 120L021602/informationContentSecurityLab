<script>
import * as echarts from 'echarts';
import {defineStore} from 'pinia'
import {useStore} from '../stores/store.js'

var barChartPort = echarts.init(document.getElementById('barChartPort'))
var barChartPro = echarts.init(document.getElementById('barChartPro'))
var option = {
    title: {
        text: 'port statistics'
    },
    xAxis: {
        data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
    },
    yAxis: {},
    series: [
        {
            type: 'bar',
            data: [23, 24, 18, 25, 27, 28, 25]
        }
    ]
}

barChartPort.setOption({
    title: {
        text: 'port statistics'
    },
    xAxis: {
        data: [, 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
    },
    yAxis: {},
    series: [
        {
            type: 'bar',
            data: [23, 24, 18, 25, 27, 28, 25]
        }
    ]
})

export default{
    
    setup(){
        const store = useStore();
        return {store};
    }
}

</script>

<template>
    <div>
        <div id="main" v-if="store.type === 'showPortInfo'">
            <el-table :data="store.portInfo" border style="width: 90%">
                <el-table-column prop="id" label="Id" width="180" />
                <el-table-column prop="port" label="Port" />
            </el-table>
        </div>

        <div id="main" v-else-if="store.type === 'showProInfo'">
            <el-table :data="store.proInfo" border style="width: 90%">
                <el-table-column prop="id" label="Id" width="180" />
                <el-table-column prop="protocol" label="Protocol" />
            </el-table>
        </div>

        <div id="main" v-else-if="store.type === 'compDisplay'">
            <el-table :data="store.compDis" border style="width: 90%">
                <el-table-column prop="id" label="Id" width="180" />
                <el-table-column prop="catalogue" label="Catalogue" width="180" />
                <el-table-column prop="port" label="Port" width="180"/>
                <el-table-column prop="protocol" label="Protocol"/>
            </el-table>
        </div>

        <div id="barChartPro" v-else-if="store.type === 'showProSta'">

        </div>

        <div id="barChartPort" v-else-if="store.type === 'showPortSta'">

        </div>
    </div>
</template>

<style scoped>
    #main{
        display: flex;
        height: 620px;
        width: 1100px;
        /* background-color: #9016d2; */
        border-radius: 15px;
        margin: auto;
        border-style: solid;
        border-color:black;
        align-items: center;
        justify-content: center;
        text-align: center;
    }
    el-table-column{
        margin:0 auto;
        
    }
    el-table{
        margin:0 auto;
        
        
    }
</style>