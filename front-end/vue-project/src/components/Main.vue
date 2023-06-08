<script>
import Display from "./Display.vue"
import {defineStore} from 'pinia'
import {useStore} from '../stores/store.js'

export default{
    components:{
        Display
    }
    
}
</script>

<template>
    <Display />
</template>