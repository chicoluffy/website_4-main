<template>
    <div :class="['DepWithPage', {'dark-mode': isDarkMode}]">
        <h1>Deposit</h1>
        <DepositTab />
    </div>
</template>

<script>
import DepositTab from '@/components/DepositTab.vue';


export default {
    name : 'DepWithPage',
    components: {
        DepositTab,
    },
    props: {
        isDarkMode: {
            type: Boolean,
            default: false
        }
    },
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