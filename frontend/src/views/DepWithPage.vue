<template>
    <div :class="['DepWithPage', {'dark-mode': isDarkMode}]">
        <h1>Deposit & Withdrawals</h1>
        <TabsComponent :tabs="tabs" :is-dark-mode="isDarkMode"/>
    </div>
</template>

<script>
import TabsComponent from '@/components/TabsComponent.vue';
import DepositTab from '@/components/DepositTab.vue';
import WithdrawTab from '@/components/WithdrawTab.vue';


export default {
    name : 'DepWithPage',
    components: {
        TabsComponent,
    },
    props: {
        isDarkMode: {
            type: Boolean,
            default: false
        }
    },
    data(){
        return{
            tabs:[
                {name: 'deposit', label: 'Deposit', component: DepositTab},
                {name: 'withdraw', label: 'Withdraw', component: WithdrawTab}
            ]
        }
    }
}
</script>
<style scoped>
.DepWithPage{
    width: 100%;
    height: 100vh;
    display: flex;
    flex-direction: column;
    color: #333;
}
.DepWithPage.dark-mode{
    background-color: #2a3b47;
    color: #fff;
}
</style>